package zadanie1;

import java.util.HashMap;

public class Towar 
{
	HashMap<Double, Double> dd = new HashMap<>();public Towar()
	{
	}
	
	 int nr;
	 double waga;
	 Towar (int nr, double waga)
	 {
		 this.waga = waga;
		 this.nr = nr;
	 }
	 public double zwrocWage()
	 {
		 return waga;
	 }
}
