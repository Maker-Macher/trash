/*
 * Created on 3 Nov 2020
 * Author: Viktor Engelowski
 */


package building;

import java.util.ArrayList;
import java.util.Scanner;

public class Raum {

	private String name;
	private float size;
	private ArrayList<Moebel> ausstattung;
	private static Scanner inp = new Scanner(System.in);
	
	
	public Raum(String _name, String _size, ArrayList<Moebel> _ausstattung) {
		
		this.name = _name;
		this.size = formatInput(_size);
		this.ausstattung = _ausstattung;
	}
	
	
	public static Raum neuesWohnzimmer(String _size) {
		
		ArrayList<Moebel> wohnzimmerMoebel = new ArrayList<Moebel>();
		
		wohnzimmerMoebel.add(new Moebel("Smorgebal", "Couch", "Leder", "275"));
		wohnzimmerMoebel.add(new Moebel("Fokeng", "Tisch", "Holz", "76"));
		
		wohnzimmerMoebel.add(new Moebel("Kambergun", "Stuhl", "Holz", "22"));
		wohnzimmerMoebel.add(new Moebel("Kambergun", "Stuhl", "Holz", "22"));
		wohnzimmerMoebel.add(new Moebel("Kambergun", "Stuhl", "Holz", "22"));
		wohnzimmerMoebel.add(new Moebel("Kambergun", "Stuhl", "Holz", "22"));
		
		wohnzimmerMoebel.add(new Moebel("Klartun", "Fernsehrtisch", "Metal", "99"));
		wohnzimmerMoebel.add(new Moebel("Ultra Wide Curved LCD 4K 145Hz UHD TV","Fernsehr", "Plastik", "5379"));
		
		wohnzimmerMoebel.add(new Moebel("Lourtan", "Teppich", "Wolle", "259"));
		
		
		Raum wohnzimmer = new Raum("Wohzimmer", _size, wohnzimmerMoebel);
		
		return wohnzimmer;
	}
	
	
	public static Raum leererRaum(String _size) {
		
		Raum leererRaum = new Raum("Leeres Zimmer", _size, null);
		
		return leererRaum;
	}
	
	
	public static Raum erstelleRaum() {
		
		ArrayList<Moebel> _moebel = new ArrayList<Moebel>();
		
		System.out.print("Name vom Raum: ");
		String inpName = inp.nextLine();
		System.out.print("Groesse: ");
		String inpGroesse = inp.nextLine();
		
		System.out.print("Wieviele Moebel? ");
		int _i = inp.nextInt();
		
		if(_i == 0) {
			
			_moebel = null;
		}
		
		for(int i=0; i<_i; i++) {
			
			Moebel _m = Moebel.erstelleMoebel();
			_moebel.add(_m);
		}
		
		Raum _raum = new Raum(inpName, inpGroesse, _moebel);
		
		return _raum;
		
	}
	
	public static String getInfos(Raum _x) {
		
		String y = "\nName: " + _x.name + "\nGroesse: " + _x.size + "m^2\nAusstattung:\n\n";
		String _y = "";
		
		if(_x.ausstattung == null) {
			
			_y = " Keine Moebel";
			return y + _y;
		}
		
		else {
			
			for(Moebel i : _x.ausstattung) {
				
				_y = _y + Moebel.getInfos(i);
			}
			
			return y + _y;
		}
	}
	
	
	private static float formatInput(String _string) {
		
		try {
			
			int y = Integer.parseInt(_string);
			return y;
		} 
		
		catch (Exception e) {
			
			System.out.println("Not a number");
			return 0;
		}
	}
	
	
	public static void main(String[] args) {
		
		//System.out.println(getInfos(erstelleRaum()));
	}
}
