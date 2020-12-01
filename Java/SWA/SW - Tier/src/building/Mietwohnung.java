/*
 * Created on 3 Nov 2020
 * Author: Viktor Engelowski
 */


package building;

import java.util.ArrayList;
import java.util.Scanner;

public class Mietwohnung {	
	
	private int wohnung;
	private ArrayList<Raum> raeume;
	
	private static Scanner inp = new Scanner(System.in);
	
	
	public Mietwohnung(int _wohnung, ArrayList<Raum> _raeume) {
		
		this.raeume = _raeume;
	}
	
	
	public static Mietwohnung erstelleWohnung(int wohungsNr) {
		
		ArrayList<Raum> _rooms = new ArrayList<Raum>();
		
		int _wohnungsNr = wohungsNr;
		
		System.out.print("Wieviele Raeume?");
		int _i = inp.nextInt();
		
		if(_i == 0) {
			
			return (new Mietwohnung(1, null));
		}
		
		for(int i=0; i<_i; i++) {
			_rooms.add(Raum.erstelleRaum());
			
		}
		
		return (new Mietwohnung(_wohnungsNr, _rooms));
		
	}
	
	
	public static String getInfos(Mietwohnung _x) {
		String y = "Wohnung Nummer: " + _x.wohnung + "Raume: ";
		String _y = "";
		
		for(Raum i : _x.raeume) {
			
			_y += Raum.getInfos(i);
		}
		
		return y + _y;
		
	}
	
	
	public static void main(String[] args) {
		
		getInfos(erstelleWohnung(1));
	}
}
