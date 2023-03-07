package org.p2adc.Constructores;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Double> data;

    public Row(){
        super();
        data=new ArrayList<>();
    }

    public void addDatoFila(Double dato){
        data.add(dato);
    }
    public List<Double> getData(){
        return data;
    }
}
