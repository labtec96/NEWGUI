/**
 *
 *  @author Han Cezary S15831
 *
 */

package zadanie2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {

	public String doCalc(String string)
	{
		BigDecimal liczba1 =null;
		BigDecimal liczba2=null;
		BigDecimal wynik;
		//String wynik1 ="";
		String znak="";
		Pattern p = Pattern.compile("\\d+\\s+[+\\-\\*\\/]{1}\\s+\\d+");
		 Matcher m = p.matcher(string);
		 Map<String, Operacje> MapaOperacji = new HashMap<>();
		 MapaOperacji.put("+", new Dodawanie());
		 MapaOperacji.put("*", new Mnozenie());
		 MapaOperacji.put("-", new Odejmowanie());
		 MapaOperacji.put("/", new Dzielenie());
		 String[] st =string.split("\\s");
		 try 
		 {
			znak=st[1];
			liczba1= new BigDecimal(st[0]);
			liczba2= new BigDecimal(st[2]);
			wynik=(MapaOperacji.get(znak).operacja(liczba1,liczba2));
		 } catch(NullPointerException  | NumberFormatException  |ArrayIndexOutOfBoundsException b)
		 {
			 return "Invalid command to calc";
		 }
		 wynik=(MapaOperacji.get(znak).operacja(liczba1,liczba2));
		 wynik= wynik.setScale(7, RoundingMode.HALF_UP).stripTrailingZeros();
//		 wyn= wyn.valueOf(wynik);
		return wynik.toString();
	}
}  
