package com.reservavehiculos.services.api;

import java.util.List;


/*
 * T = Class database
 * K = Primary key data type 
 * */

public interface EntityServiceAPI <T, K> {

	void save(T object);

	void delete(K idObject);

	List<T> getAll();

	T getById(K idObject);
	
	Boolean isExistObject(K idObject);

}
