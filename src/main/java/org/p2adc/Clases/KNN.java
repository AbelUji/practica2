package org.p2adc.Clases;



import org.p2adc.Constructores.RowWithLabel;
import org.p2adc.Constructores.TableWithLabels;
import org.p2adc.Interfaces.Algorithm;

import java.util.List;

public class KNN implements Algorithm<TableWithLabels> {
    private TableWithLabels table;
    public void train(TableWithLabels data){
        this.table=data;
    }
    public Integer estimate(List<Double> data){
        double euclidea;
        double distMin=-1;
        int numberClass=-1;
        for(int i=0;i<table.getRows().size();i++){
            RowWithLabel row=(RowWithLabel) table.getRows().get(i);
             euclidea=calcularDistancia(row.getData(),data);
             if(euclidea<distMin || distMin==-1){
                 distMin=euclidea;
                 numberClass=table.getRowAt(i).getNumberClass();
             }
        }
        return numberClass;
    }
    public double calcularDistancia(List<Double> data_source, List<Double> data){
        double amount=-1;
        for(int i=0;i<data_source.size();i++){
            amount+=Math.pow((data_source.get(i)-data.get(i)),2);
        }
        return Math.sqrt(amount);
    }
}
