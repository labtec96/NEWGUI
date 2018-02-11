package zad2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceList
{
	String nazwa;
	double cena = -1;
	static PriceList cennik = null;
	public Map <String, Double> listacen = new HashMap<String, Double>();
	private PriceList()
	{
	}
	public static PriceList getInstance()
	{
		if(cennik == null)
		{
			cennik = new PriceList();
			return cennik;
		}
		return cennik;
	}
	
	public void put(String nazwa, double cena)
	{
		cennik.listacen.put(nazwa, cena);
	}
	

}
