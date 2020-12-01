/*
 * Created on 3 Nov 2020
 * Author: Viktor Engelowski
 */


package building;

import java.util.Scanner;

public class Moebel {

	private String name;
	private String art;
	private String material;
	private float preis;
	private static Scanner inp = new Scanner(System.in);
	
	
	public Moebel(String _name, String _art, String _material, String _preis){
		
		this.name = _name;
		this.art = _art;
		this.material = _material;
		this.preis = formatInput(_preis);
	}
	
	
	public static Moebel erstelleMoebel() { 
		
		System.out.print("Name vom Moebell: ");
		String inpName = inp.nextLine();
		System.out.print("Art vom Moebell: ");
		String inpArt = inp.nextLine();
		System.out.print("Material :");
		String inpMat = inp.nextLine();
		System.out.print("Preis: ");
		String inpPreis = inp.nextLine();
		
		Moebel mobe = new Moebel(inpName, inpArt, inpMat, inpPreis);
		
		return mobe;
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
	
	
	public static String getInfos(Moebel x) {
		
		if(x == null) {
			
			return "Keine Moebel";
		}
		
		else {
			
			String y = "  Name: " + x.name + "\n  Art: " + x.art + "\n  Material: " + x.material + "\n  Preis: " + x.preis + "€\n\n";
			
			return y;
		}		
	}
}
