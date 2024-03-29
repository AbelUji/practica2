package org.p2adc.Clases;

import org.p2adc.Constructores.Row;
import org.p2adc.Constructores.Table;
import org.p2adc.Excepciones.ClusterException;
import org.p2adc.Interfaces.Algorithm;


import java.util.*;

public class Kmeans implements Algorithm<Table> {
    private int numClusters, numIterations;
    private long seed;
    private Map<Integer,List<Row>> grupos;
    private List<Row> centroides;
    private Table tablaK;

    public Kmeans(int numClusters,int numIterations, long seed){
        this.numClusters=numClusters;
        this.numIterations=numIterations;
        this.seed=seed;
        this.grupos=new HashMap<>();
        this.centroides=new ArrayList<>();
    }
    public List<Row> getCentroides() {
        return centroides;
    }

    public Map<Integer, List<Row>> getGrupos() {
        return grupos;
    }


    @Override
    public void train(Table datos) throws ClusterException {
        if(numClusters>numIterations){
            throw new ClusterException();
        }
        tablaK=datos;
        randomCentroides();
        for(int j=0;j<numIterations;j++) {
            asignarPuntos();
            centroides.clear();
            for (int i = 0; i < numClusters; i++) {
                centroides.add(meanCentroide(grupos.get(i)));
                if(j!=numIterations-1){
                    grupos.get(i).clear();
                }
            }
        }
    }

    public void asignarPuntos(){
        for (int i = 0; i < tablaK.getRows().size(); i++) {
            int numberClass = estimate(tablaK.getRowAt(i).getData());
            if(!grupos.get(numberClass).contains(tablaK.getRowAt(i)))
                grupos.get(numberClass).add(tablaK.getRowAt(i));
        }
    }
    @Override
    public Integer estimate(List<Double> dato){
        int id=-1,contador=0;
        double distMin=Double.MAX_VALUE;
        KNN myKNN=new KNN();
        for(Row element:centroides){
            double distActual=myKNN.calcularDistancia(dato,element.getData());
            if(distMin > distActual){
                distMin=distActual;
                id=contador;
            }
            contador++;
        }
        return id;
    }
    private void randomCentroides(){
        Random random=new Random(seed);
        for(int i=0;i<numClusters;i++){
            int numeroRandom=random.nextInt(tablaK.getRows().size()-1);
            if(!centroides.contains(tablaK.getRowAt(numeroRandom))){//No puede meter la funcion random.nextInt dentro del getRowAt(no funciona)
                centroides.add(tablaK.getRowAt(numeroRandom));
                grupos.put(i,new ArrayList<>());
            }else{
                i--;
            }
        }
    }
    private Row meanCentroide(List<Row> rows) {
        Row devolver=new Row();
        List<Double> aux=new ArrayList<>();
        for(int i=0;i<tablaK.getHeaders().size();i++){
            aux.add(0.0);
        }
        for(Row element:rows){
            List<Double> aux2=element.getData();
            for(int i=0;i<aux2.size();i++){
                aux.set(i,aux2.get(i)+aux.get(i)/ rows.size()-1);
            }
        }

        devolver.addListaFila(aux);
        return devolver;
    }
}
