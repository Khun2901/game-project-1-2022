package map;

import java.util.ArrayList;
import logic.Player;

public class World {

	public static ArrayList<Country> allCountry;
	public static ArrayList<Region> allRegion;

	public World() {
		World.setAllRegion(new ArrayList<Region>());
		World.setAllCountry(new ArrayList<Country>());

		Country D1 = new Country("D1", true, new ArrayList<Country>());
		Country D2 = new Country("D2", true, new ArrayList<Country>());
		Country D3 = new Country("D3", false, new ArrayList<Country>());
		Country D4 = new Country("D4", false, new ArrayList<Country>());
		Country D5 = new Country("D5", true, new ArrayList<Country>());
		Country P1 = new Country("P1", true, new ArrayList<Country>());
		Country P2 = new Country("P2", false, new ArrayList<Country>());
		Country P3 = new Country("P3", true, new ArrayList<Country>());
		Country P4 = new Country("P4", false, new ArrayList<Country>());
		Country G1 = new Country("G1", true, new ArrayList<Country>());
		Country G2 = new Country("G2", false, new ArrayList<Country>());
		Country G3 = new Country("G3", false, new ArrayList<Country>());
		Country B1 = new Country("B1", true, new ArrayList<Country>());
		Country B2 = new Country("B2", false, new ArrayList<Country>());
		Country B3 = new Country("B3", true, new ArrayList<Country>());
		Country B4 = new Country("B4", false, new ArrayList<Country>());
		Country B5 = new Country("B5", true, new ArrayList<Country>());
		Country B6 = new Country("B6", false, new ArrayList<Country>());
		Country R1 = new Country("R1", true, new ArrayList<Country>());
		Country R2 = new Country("R2", false, new ArrayList<Country>());
		Country R3 = new Country("R3", true, new ArrayList<Country>());
		Country Y1 = new Country("Y1", false, new ArrayList<Country>());
		Country Y2 = new Country("Y2", true, new ArrayList<Country>());
		Country C1 = new Country("C1", false, new ArrayList<Country>());
		Country C2 = new Country("C2", true, new ArrayList<Country>());
		Country C3 = new Country("C3", false, new ArrayList<Country>());
		Country W1 = new Country("W1", false, new ArrayList<Country>());
		Country W2 = new Country("W2", false, new ArrayList<Country>());
		Country W3 = new Country("W3", true, new ArrayList<Country>());
		Country W4 = new Country("W4", true, new ArrayList<Country>());

		D1.getAdjacencyCountry().add(D3);
		D2.getAdjacencyCountry().add(D3);
		D3.getAdjacencyCountry().add(D1);
		D3.getAdjacencyCountry().add(D2);
		D3.getAdjacencyCountry().add(D4);
		D3.getAdjacencyCountry().add(G2);
		D4.getAdjacencyCountry().add(D3);
		D4.getAdjacencyCountry().add(D5);
		D4.getAdjacencyCountry().add(B1);
		D5.getAdjacencyCountry().add(D4);
		D5.getAdjacencyCountry().add(P3);
		P1.getAdjacencyCountry().add(P4);
		P2.getAdjacencyCountry().add(P3);
		P2.getAdjacencyCountry().add(P4);
		P3.getAdjacencyCountry().add(P2);
		P3.getAdjacencyCountry().add(P4);
		P3.getAdjacencyCountry().add(D5);
		P4.getAdjacencyCountry().add(P1);
		P4.getAdjacencyCountry().add(P2);
		P4.getAdjacencyCountry().add(P3);
		P4.getAdjacencyCountry().add(R1);
		G1.getAdjacencyCountry().add(G2);
		G1.getAdjacencyCountry().add(G3);
		G2.getAdjacencyCountry().add(G1);
		G2.getAdjacencyCountry().add(B1);
		G2.getAdjacencyCountry().add(D3);
		G3.getAdjacencyCountry().add(G1);
		G3.getAdjacencyCountry().add(Y2);
		G3.getAdjacencyCountry().add(B5);
		G3.getAdjacencyCountry().add(G1);
		B1.getAdjacencyCountry().add(B2);
		B1.getAdjacencyCountry().add(B4);
		B1.getAdjacencyCountry().add(G2);
		B1.getAdjacencyCountry().add(D4);
		B2.getAdjacencyCountry().add(B1);
		B2.getAdjacencyCountry().add(B3);
		B2.getAdjacencyCountry().add(B4);
		B3.getAdjacencyCountry().add(B2);
		B3.getAdjacencyCountry().add(B4);
		B3.getAdjacencyCountry().add(B6);
		B3.getAdjacencyCountry().add(R1);
		B4.getAdjacencyCountry().add(B1);
		B4.getAdjacencyCountry().add(B2);
		B4.getAdjacencyCountry().add(B3);
		B4.getAdjacencyCountry().add(B5);
		B4.getAdjacencyCountry().add(B6);
		B5.getAdjacencyCountry().add(B4);
		B5.getAdjacencyCountry().add(B6);
		B5.getAdjacencyCountry().add(C2);
		B5.getAdjacencyCountry().add(G3);
		B6.getAdjacencyCountry().add(B3);
		B6.getAdjacencyCountry().add(B4);
		B6.getAdjacencyCountry().add(B5);
		R1.getAdjacencyCountry().add(R2);
		R1.getAdjacencyCountry().add(B3);
		R1.getAdjacencyCountry().add(P4);
		R2.getAdjacencyCountry().add(R1);
		R2.getAdjacencyCountry().add(R3);
		R3.getAdjacencyCountry().add(R2);
		R3.getAdjacencyCountry().add(W2);
		Y1.getAdjacencyCountry().add(Y2);
		Y2.getAdjacencyCountry().add(Y1);
		Y2.getAdjacencyCountry().add(C1);
		Y2.getAdjacencyCountry().add(G3);
		C1.getAdjacencyCountry().add(C2);
		C1.getAdjacencyCountry().add(Y2);
		C2.getAdjacencyCountry().add(C1);
		C2.getAdjacencyCountry().add(C3);
		C2.getAdjacencyCountry().add(W1);
		C2.getAdjacencyCountry().add(B5);
		C3.getAdjacencyCountry().add(C2);
		W1.getAdjacencyCountry().add(W2);
		W1.getAdjacencyCountry().add(W3);
		W1.getAdjacencyCountry().add(C2);
		W2.getAdjacencyCountry().add(W1);
		W2.getAdjacencyCountry().add(W4);
		W2.getAdjacencyCountry().add(R3);
		W3.getAdjacencyCountry().add(W1);
		W3.getAdjacencyCountry().add(W4);
		W4.getAdjacencyCountry().add(W2);
		W4.getAdjacencyCountry().add(W3);

		World.getAllCountry().add(D1);
		World.getAllCountry().add(D2);
		World.getAllCountry().add(D3);
		World.getAllCountry().add(D4);
		World.getAllCountry().add(D5);
		World.getAllCountry().add(P1);
		World.getAllCountry().add(P2);
		World.getAllCountry().add(P3);
		World.getAllCountry().add(P4);
		World.getAllCountry().add(G1);
		World.getAllCountry().add(G2);
		World.getAllCountry().add(G3);
		World.getAllCountry().add(B1);
		World.getAllCountry().add(B2);
		World.getAllCountry().add(B3);
		World.getAllCountry().add(B4);
		World.getAllCountry().add(B5);
		World.getAllCountry().add(B6);
		World.getAllCountry().add(R1);
		World.getAllCountry().add(R2);
		World.getAllCountry().add(R3);
		World.getAllCountry().add(Y1);
		World.getAllCountry().add(Y2);
		World.getAllCountry().add(C1);
		World.getAllCountry().add(C2);
		World.getAllCountry().add(C3);
		World.getAllCountry().add(W1);
		World.getAllCountry().add(W2);
		World.getAllCountry().add(W3);
		World.getAllCountry().add(W4);

		Region D = new Region("D", 3, new ArrayList<Country>());
		Region P = new Region("P", 2, new ArrayList<Country>());
		Region G = new Region("G", 2, new ArrayList<Country>());
		Region B = new Region("B", 3, new ArrayList<Country>());
		Region R = new Region("R", 2, new ArrayList<Country>());
		Region Y = new Region("Y", 1, new ArrayList<Country>());
		Region C = new Region("C", 2, new ArrayList<Country>());
		Region W = new Region("W", 2, new ArrayList<Country>());

		D.getCountryInRegion().add(D1);
		D.getCountryInRegion().add(D2);
		D.getCountryInRegion().add(D3);
		D.getCountryInRegion().add(D4);
		D.getCountryInRegion().add(D5);

		P.getCountryInRegion().add(P1);
		P.getCountryInRegion().add(P2);
		P.getCountryInRegion().add(P3);
		P.getCountryInRegion().add(P4);

		G.getCountryInRegion().add(G1);
		G.getCountryInRegion().add(G2);
		G.getCountryInRegion().add(G3);

		B.getCountryInRegion().add(B1);
		B.getCountryInRegion().add(B2);
		B.getCountryInRegion().add(B3);
		B.getCountryInRegion().add(B4);
		B.getCountryInRegion().add(B5);
		B.getCountryInRegion().add(B6);

		R.getCountryInRegion().add(R1);
		R.getCountryInRegion().add(R2);
		R.getCountryInRegion().add(R3);

		Y.getCountryInRegion().add(Y1);
		Y.getCountryInRegion().add(Y2);

		C.getCountryInRegion().add(C1);
		C.getCountryInRegion().add(C2);
		C.getCountryInRegion().add(C3);

		W.getCountryInRegion().add(W1);
		W.getCountryInRegion().add(W2);
		W.getCountryInRegion().add(W3);
		W.getCountryInRegion().add(W4);

		World.getAllRegion().add(D);
		World.getAllRegion().add(P);
		World.getAllRegion().add(G);
		World.getAllRegion().add(B);
		World.getAllRegion().add(R);
		World.getAllRegion().add(Y);
		World.getAllRegion().add(C);
		World.getAllRegion().add(W);

	}

	public static ArrayList<Country> getAllCountry() {
		return allCountry;
	}

	public static ArrayList<Region> getAllRegion() {
		return allRegion;
	}

	public static void setAllCountry(ArrayList<Country> allCountry) {
		World.allCountry = allCountry;
	}

	public static void setAllRegion(ArrayList<Region> allRegion) {
		World.allRegion = allRegion;
	}

}
