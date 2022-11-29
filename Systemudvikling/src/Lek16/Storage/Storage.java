package Lek16.Storage;

import Lek16.Model.KontoType;

import java.util.ArrayList;


public class Storage {

	private static ArrayList<KontoType> kontoTyper = new ArrayList<KontoType>();

	public static void addKontoType(KontoType kontoType) {
		if (!kontoTyper.contains(kontoType)) {
			kontoTyper.add(kontoType);
		}
	}

}
