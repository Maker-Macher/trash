package fahrrad;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Fahrrad {
	
	private String Besitzer;
	private String Hersteller;
	private Color Farbe;
	private int Laufrad_Zoll;
	private int Rahmen_Zoll;
	private static Scanner in = new Scanner(System.in);
	
	
	public Fahrrad(String b, String h, String f, String lz, String rz) {
		
		this.Besitzer = b;
		this.Hersteller = h;
		this.Laufrad_Zoll = isNumber(lz);
		this.Rahmen_Zoll = isNumber(rz);
		this.Farbe = evalColor(f);		
	}
	
	
	public static int isNumber(String s) {
		
		return Integer.parseInt(s.replaceAll("([\\D])", ""));		
	}
	
	
	public static HashMap<String, Color> initColorDict() {
		
		HashMap<String, Color> colorDict = new HashMap<String, Color>();
		
		colorDict.put("rot", Color.red);
		colorDict.put("schwarz", Color.black);
		colorDict.put("gruen", Color.green);
		colorDict.put("gelb", Color.yellow);
		colorDict.put("blau", Color.blue);
		
		return colorDict;		
	}

	
	public static Color evalColor(String x) {
		
		HashMap<String, Color> col = initColorDict();
		x.toLowerCase();
		
		if(col.get(x) != null) {
			return col.get(x);
		}		
		else {
			return Color.white;
		}		
	}
	
	
	public static Fahrrad neuesFahrrad() {
			
			System.out.println("Besitzer?");
			String b = in.nextLine();
			
			System.out.println("Hersteller?");
			String h = in.nextLine();
			
			System.out.println("Farbe?");
			String f = in.nextLine();
			
			System.out.println("Reifengroesse in Zoll?");
			String lz = in.nextLine();
			
			System.out.println("Rahmengroesse in Zoll?");
			String rz = in.nextLine();
			
			Fahrrad bike = new Fahrrad(b, h, f, lz, rz);
			
			return bike;
	}
	
	public static String getDaten(Fahrrad x) {
		
		String y = "";
		
		y += "\nBesitzer: " + x.Besitzer;
		y += "\nHersteller: " + x.Hersteller;
		y += "\nFarbe: " + x.Farbe;
		y += "\nReifenzoll: " + x.Laufrad_Zoll + " Zoll";
		y += "\nRahmengröße: " + x.Rahmen_Zoll + " Zoll";
		
		return y;
	}
	

	public static void main(String[] args) {
		
		ArrayList<Fahrrad> garage = new ArrayList<>();
		
		System.out.println("Wieviele Fahrräder?");
		int amount = isNumber(in.nextLine());		
		
		for(int i = 0; i < amount; i++) {
			
			garage.add(neuesFahrrad());
		}
		
		for(int i=0; i < garage.size(); i++) {
			System.out.println(getDaten(garage.get(i)));
		}
	}
}
