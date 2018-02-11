/**
 *
 *  @author Han Cezary S15831
 *
 */

package zadanie1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException 
  {
	 ListaTowarow listaTowarow = new ListaTowarow();
	 int iloscProduktow =0;
	  Thread a = new Thread()
	  {
			int counter=0;
				public void run() 
		        {
		        	 Scanner skaner = null;
		        	 try {
		   				 	skaner = new Scanner(new FileReader("../Towary.txt"));
		   				 	while (skaner.hasNext())
		   				 	{
		   				 	listaTowarow.dolozProdukt(Integer.parseInt(skaner.next()), Double.parseDouble(skaner.next()));
		   				 		if (counter %200==0 && counter!=0)
		   				 			System.out.println("Utworzono " + counter + " obiektów");
		   				 	counter++;
		   				 	}
		   					} catch (IOException e) 
		        	 		{

		        	 		}
		        	 listaTowarow.koniec();

		        }
	  };
	  Thread b  = new Thread()
	 {
		double suma=0;
		 public void run() 
		    {
				int i=0;
				while(i<listaTowarow.getSize() || !listaTowarow.koniec)
				{
					if (i %100==0 && i!=0)
						System.out.println("policzono wage " + i + " towarów");
					suma=suma+listaTowarow.getTowary(i);
					i++;
				}
				System.out.println(suma);
		    }
	 };
	 synchronized (listaTowarow)
	 {
		 a.start();
		b.start();

	}
	
//	  try
//	{
//		Thread.sleep(100);
//	} catch (InterruptedException e)
//	{
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	  b1.start();
    
    
	//System.out.println(lista.get("1"));
	//System.out.println(skaner.next());
  }
  
}
