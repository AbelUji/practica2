package org.p2adc.Constructores;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Table {
    private List<String> header;
    private List<Row> rows;

    public Table(){
        super();
        header=new ArrayList<>();
        rows=new ArrayList<>();
    }

    public void addHeader(String cabecera){
        header.add(cabecera);
    }

    public void addRow(Row fila){
        if (fila.getData().size()!=header.size()){
            throw new ArrayIndexOutOfBoundsException();
        }

        rows.add(fila);
    }

    public List<String> getHeader(){
        return header;
    }

    public List<Row> getRows(){
        return rows;
    }

    public Row getRowAt(int rowNumber){
        if (rows.size()<rowNumber){
            throw new NoSuchElementException();
        }

        return rows.get(rowNumber-1);
    }
}
