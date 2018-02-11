/**
 *
 *  @author Han Cezary S15831
 *
 */

package zadanie1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Main {

  public static void main(String[] args) {
    String fname = System.getProperty("user.home") + "/tab.txt";        
    List<String> lista = new ArrayList<String>();
    FileReader fr;
	try
	{
		fr =  new FileReader(fname);
		Scanner skaner= new Scanner(fr);
		 while (skaner.hasNext())
		 {
			 String cyfra = skaner.next();
			 try  
			  {  
				 Long d = Long.parseLong(cyfra);  
			  }  
			  catch(NumberFormatException nfe)  
			  {  
				 System.out.println("***");
				 System.exit(0);
			  }
			 lista.add(cyfra);
		 }
	} catch (FileNotFoundException e)
	{
		System.out.println("***");
		System.exit(0);
	}
	long[] tab  = new long[lista.size()];
	for (int i = 0; i < tab.length; i++)
	{
		tab[i] = Long.parseLong(lista.get(i));
		System.out.print(tab[i] + " ");
	}
	System.out.println();
	long max = tab[0];
	for (int i = 1; i < tab.length; i++)
	{
		if (max<tab[i])
			max =tab[i];
	}
	System.out.println(max);
	for (int i = 0; i < tab.length; i++)
	{
		if (max == tab[i])
		System.out.print(i +" ");
	}
  }
}
