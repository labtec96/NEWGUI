package zadanie1;

import java.util.ArrayList;

public class ListaTowarow
{
	boolean koniec = false;
	static ArrayList<Towar> towary;
	public boolean koniec()
	{
		return this.koniec =true;
	}
	public boolean getKoniec()
	{
		return this.koniec;
	}
	public ListaTowarow()
	{
		towary = new ArrayList<>();
	}

	public synchronized void dolozProdukt (int id, double waga)
	{
        towary.add(new Towar(id,waga));
        
        notify();
    }
	
	public synchronized double getTowary(int i)
	{
		if (!this.koniec)
		{
		 try {
             wait(200);
         } catch (InterruptedException e) {}
		}
        return towary.get(i).zwrocWage();
  
	}
	public int getSize()
	{
        return towary.size();
}
}
