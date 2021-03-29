package model;

import java.util.Comparator;

public class ClientNameSort implements Comparator<Client>{

	@Override
	public int compare(Client o1, Client o2) {
		return o1.getName().compareToIgnoreCase(o2.getName());
	}

}
