package zad2;

import java.util.ArrayList;
import java.util.List;


public class Customer extends przechowywaczKwiatow
{
	String imie;
	double budzet;
	ShoppingCart koszykSklepowy = new ShoppingCart(this);
	public String getImie()
	{
		return imie;
	}
	public Customer (String imie, double budzet)
	{
		this.imie = imie;
		this.budzet = budzet;
	}
	public double getCash()
	{
		return this.budzet;
	}
	public void pay()
	{
		int tab[] = new int[koszykSklepowy.lista.size()];
		double sumaZaKwiaty=0;
		int i=0;
		while ( i < koszykSklepowy.lista.size())
		{
			if (this.koszykSklepowy.lista.get(i).ilosc *PriceList.cennik.listacen.getOrDefault(this.koszykSklepowy.lista.get(i).nazwa,(double) -1)>0 
					&& this.budzet-sumaZaKwiaty-this.koszykSklepowy.lista.get(i).ilosc *PriceList.cennik.listacen.getOrDefault(this.koszykSklepowy.lista.get(i).nazwa,(double) -1)>=0)
			{
				sumaZaKwiaty = sumaZaKwiaty+ this.koszykSklepowy.lista.get(i).ilosc *PriceList.cennik.listacen.getOrDefault(this.koszykSklepowy.lista.get(i).nazwa,(double) -1);
			}
			else
			{
				this.koszykSklepowy.lista.remove(i);
				i--;
			}
			i++;
		}
		this.budzet=this.budzet-sumaZaKwiaty;
	}
	public void get(Kwiaty kwiat)
	{
		koszykSklepowy.add(kwiat);
		
	}
	public ShoppingCart getShoppingCart()
	{
		return koszykSklepowy;
	}
	public void pack(Box box)
	{
		for (Kwiaty kwiat : koszykSklepowy.lista)
		{
			box.listaWpudelku.add(kwiat);
		}
		koszykSklepowy.lista.clear();
	}
}
