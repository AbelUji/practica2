package org.p2adc;

import org.p2adc.Constructores.Table;

import java.util.List;

public class Kmeans {
    private int numClust,numIter;
    private long semilla;

    public Kmeans(int numClusters, int numIterations, long seed){
        numClust=numClusters;
        numIter=numIterations;
        semilla=seed;
    }

    public void train(Table datos){

    }

    public Integer estimate(List<Double> dato){
        return 0;
    }

    public double calcularDistancia(List<Double> dato1,List<Double> dato2){
        double suma=0;
        for (int i=0;i<dato1.size();i++){
            suma+=Math.pow((dato1.get(i)-dato2.get(i)),2);
        }
        return Math.sqrt(suma);
    }
}
