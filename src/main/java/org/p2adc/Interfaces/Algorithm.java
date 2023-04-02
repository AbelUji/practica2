package org.p2adc.Interfaces;

import org.p2adc.Constructores.Table;
import org.p2adc.Excepciones.ClusterException;

import java.util.List;

public interface Algorithm<T extends Table> {
    void train(T datos) throws ClusterException;
    Integer estimate(List<Double> dato);
}
