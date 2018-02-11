package zad2;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart
{
	Customer klientWozek = null;
	public ShoppingCart (Customer klientWozek)
	{
		this.klientWozek = klientWozek;
	}
	List<Kwiaty> lista = new ArrayList<Kwiaty>();
	public void add (Kwiaty kwiat)
	{
		lista.add(kwiat);
	}
	
	public String toString()
	{
		if (klientWozek.koszykSklepowy.lista.isEmpty())
			return "Wózek właściciel "+ klientWozek.imie+" -- pusto";
		else
		{
			String d="Wózek właściciel "+ klientWozek.imie;
			for (Kwiaty kwiat : lista)
			{
				
				 d = d+ "\n"+ kwiat.nazwa + ", kolor: " + kwiat.kolor + ", ilość: " + kwiat.ilosc +", cena: "+ PriceList.cennik.listacen.getOrDefault(kwiat.nazwa,(double) -1);
			}
			return d;
		}
	}
}
