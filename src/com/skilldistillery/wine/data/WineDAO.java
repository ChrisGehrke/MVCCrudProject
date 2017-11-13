package com.skilldistillery.wine.data;

import java.util.List;

public interface WineDAO {
	Wine addWine(Wine w); //Create
	List<Wine> getAllWines(); //Retrieve
	Wine getWineById(int id);
	Wine updateWine(Wine w); //update
	Wine deleteWine(Wine w); //delete
	

}
