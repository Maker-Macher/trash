package tier;

import java.awt.Color;
import java.util.HashMap;
import java.util.Scanner;

public class Hund {

	private String Name;
	private Color Fellfarbe;
	private String Rasse;
	private int Gewicht;
	private String Geschlecht;
	private boolean Kastriert;
	private static Scanner in = new Scanner(System.in);
	
	private static Color braun = new Color(139, 69, 19);


	public Hund(String name, Color f, String r, int gew, String ges, boolean n) {

		this.Name = name;
		this.Fellfarbe = f;
		this.Rasse = r;
		this.Gewicht = gew;
		this.Geschlecht = ges;
		this.Kastriert = n;
	}
	
	
	public static String[] getVars(Hund x) {
		
		String[] vars = new String[6];
		
		vars[0] = "Name: " + x.Name;
		vars[1] = "Fellfarbe: " + x.Fellfarbe;
		vars[2] = "Rasse: " + x.Rasse;
		vars[3] = "Gewicht: " + String.valueOf(x.Gewicht);
		vars[4] = "Geschlecht: " + x.Geschlecht;
		
		if(x.Kastriert) {
			
			vars[5] = "Kastriert: Ja";
		}
		else {
			
			vars[5] = "Kastriert: Nein";
		}
		
		return vars;
	}
		
	
	public static int convertStringToInt(String i) {

		String x = i.replaceAll("([\\D])", "");
		
		if(x.equals("")) {
			int j = 0;
			return j;
		}
		else {
			return Integer.parseInt(x);
		}
	}
	
	
	public static boolean evalStringToBool(String x) {
	
		if(x.equalsIgnoreCase("ja")) {
			
			return true;
		}
		else {
			
			return false;
		}
	}


	public static Color evalFarbe(String f) {

		f = f.toLowerCase();
		
		HashMap<String, Color> colorDict = new HashMap<String, Color>();
		
		colorDict.put("schwarz", Color.black);
		colorDict.put("braun", braun);
		colorDict.put("blond", Color.yellow);

		if(colorDict.get(f) != null) {
			
			return colorDict.get(f);
		}
		
		else {

			return Color.black;
		}
	}
	
	
	public static Hund abfrage() {
			
		System.out.println("Name:");
		String name = in.nextLine();
		
		System.out.println("Fellfarbe:");
		Color farbe = evalFarbe(in.nextLine());
		
		System.out.println("Rasse:");
		String rasse = in.nextLine();
		
		System.out.println("Gewicht:");
		int gewicht = convertStringToInt(in.nextLine());
		
		System.out.println("Geschlecht:");
		String ges = in.nextLine();
		
		System.out.println("Kastriert?:");
		boolean kas = evalStringToBool(in.nextLine());
		
		Hund dog = new Hund(name, farbe, rasse, gewicht, ges, kas);
		
		return dog;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Wieviele Hunde?");
		int loops = Integer.parseInt(in.nextLine());
		
		Hund[] HundeListe = new Hund[loops];
		
		for(int i = 0; i < loops; i++) {
			
			HundeListe[i] = abfrage();
		}
		
		for(int i = 0; i < HundeListe.length; i++) {
			
			String[] vars = getVars(HundeListe[i]);
			
			for(int j = 0; j < vars.length; j++) {
				System.out.println(vars[j]);
			}
		}
		
		in.close();
	}
}
