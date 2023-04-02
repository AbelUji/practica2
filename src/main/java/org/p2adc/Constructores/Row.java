package org.p2adc.Constructores;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Double> data;
    public Row(){
        super();
        data=new ArrayList<>();
    }

    public List<Double> getData() {
        return data;
    }

    public void addFila(Double n){
        data.add(n);
    }

    public void addListaFila(List<Double> data){
        this.data=data;
    }



}
