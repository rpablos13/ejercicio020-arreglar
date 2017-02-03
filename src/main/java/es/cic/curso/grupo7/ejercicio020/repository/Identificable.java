package es.cic.curso.grupo7.ejercicio020.repository;

import java.io.Serializable;

public interface Identificable<K> extends Serializable {

	K getId();

	void setId(K id);
}