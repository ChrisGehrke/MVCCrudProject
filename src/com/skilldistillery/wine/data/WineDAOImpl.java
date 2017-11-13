package com.skilldistillery.wine.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class WineDAOImpl implements WineDAO {
	
	Map<Integer,Wine> wines;
	
	private int id = 1;
	
	 public WineDAOImpl() {
		wines = new HashMap<>();
		loadSampleWines();
	}

	 private void loadSampleWines() {
		 wines.put(id, new Wine(id++, "Champagne Brut Yellow Label",375, 12, 38.93,"pagina_prodotto.jpg"));
		 wines.put(id, new Wine(id++, "Veuve Clicquot Brut Chapagne",375, 12, 27.99,"veavebrut.jpeg"));
		 wines.put(id, new Wine(id++,"Gabbiano Chianti Classico D.O.G.C.",750, 13, 12.99,"Gabbiano.jpeg"));
		 wines.put(id, new Wine(id++,"Risata Moscato D'Asti",750, 11, 11.99,"Risata.jpeg"));
		 wines.put(id, new Wine(id++,"Veuve Clicquot Brut Rose Chapagne",750, 12.5, 12.99,"VeuveRose.jpeg"));
		 wines.put(id, new Wine(id++,"Cupcake Vineyards Moscato D'Asti",750, 5.5, 10.99,"Cupcakewine.jpeg"));
		 wines.put(id, new Wine(id++,"Barefoot Bubbly Pink Moscato",750, 9.58, 10.99,"Barefootbubbly.jpeg"));
		 wines.put(id, new Wine(id++,"Barefoot Moscato",750, 9, 5.99,"BarefootMoscato.jpeg"));
		 wines.put(id, new Wine(id++,"Barefoot Red Moscato",750, 9, 5.99,"BarefootRedMascato.jpeg"));
		 wines.put(id, new Wine(id++,"Barefoot Pink Moscato",750, 9.58, 5.99,"BarefootPinkMascato.jpeg"));
		 
	 }
	 
	@Override
	public Wine addWine(Wine w) {
		w.setId(id++);
		return wines.put(w.getId(), w);
	}

	@Override
	public List<Wine> getAllWines() {		
		return new ArrayList<Wine>(wines.values());
	}

	@Override
	public Wine getWineById(int id) {	
		return wines.get(id);
	}

	@Override
	public Wine updateWine(Wine w) {
		return wines.put(w.getId(), w);
	}

	@Override
	public Wine deleteWine(Wine w) {
		return wines.remove(w.getId());
	}

}
