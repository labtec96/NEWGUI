package zad2;

import java.beans.Customizer;
import java.util.ArrayList;
import java.util.List;

public class Box 
{
	Customer klintPudelko = null;
	List<Kwiaty> listaWpudelku = new ArrayList<Kwiaty>();
	public Box(Customer klientWozek)
	{
		this.klintPudelko=klientWozek;
	}
	public String toString()
	{
		String d="Pudełko właściciel "+klintPudelko.imie;
		for (Kwiaty kwiat : listaWpudelku)
		{
			
			 d = d+ "\n"+ kwiat.nazwa + ", kolor: " + kwiat.kolor + ", ilość: " + kwiat.ilosc +", cena: "+ PriceList.cennik.listacen.getOrDefault(kwiat.nazwa,(double) -1);
		}
		return d;
	}

}
