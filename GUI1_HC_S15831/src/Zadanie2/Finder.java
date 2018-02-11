/**
 *
 *  @author Han Cezary S15831
 *
 */

package Zadanie2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finder 
{
	String sciezka = "";
	FileReader fr;
	StringBuffer sb = new StringBuffer();
	StringBuffer sb2 = new StringBuffer();
	public Finder (String sciezka)
	{
		try{		
			FileReader fr = new FileReader(sciezka);
			int tmp;
			  while ((tmp = fr.read()) != -1) 
			  {
	             sb.append((char)tmp);
	             sb2.append((char)tmp);
			  }
			  fr.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public int getIfCount()
	{
		 char ch = (char)(34);
		 char chEndLine = (char)(10);
		 String koniecLinni = "" + chEndLine;
		 String cudzyslow=""+ ch;
		 int pozycjaCudzyslowa = sb.indexOf(cudzyslow);
		 while ( pozycjaCudzyslowa!=-1)
		 {
			 sb.delete(sb.indexOf(cudzyslow), sb.indexOf(cudzyslow,pozycjaCudzyslowa+1)+1);
			 pozycjaCudzyslowa = sb.indexOf(cudzyslow,sb.indexOf(cudzyslow,pozycjaCudzyslowa+1));
		 }
		 while (sb.indexOf("/*") !=-1)
		 {
			 sb.delete(sb.indexOf("/*"), sb.indexOf("*/")+2);
		 }
		 while (sb.indexOf("//") !=-1)
		 {
			 sb.delete(sb.indexOf("//"), sb.indexOf(koniecLinni,sb.indexOf("//")));
		 }
		// System.out.println(sb.toString());
		 int suma=0;
		 Pattern p = Pattern.compile("(\\Wif\\W)");
		 Matcher m = p.matcher(sb);
		 while (m.find())
			{
				suma++;
			}
		return suma;
	}
	public int getStringCount(String string) 
	{
		int suma = 0;
		Pattern p = Pattern.compile(string);
		Matcher m = p.matcher(sb2);
		while (m.find())
		{
			suma++;
		}
		return suma;
	}
	
}    
