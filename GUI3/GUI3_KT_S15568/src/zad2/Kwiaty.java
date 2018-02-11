package zad2;

public abstract class Kwiaty
{
	public String nazwa;
	String kolor;
	int ilosc;
	public Kwiaty (int ilosc, String kolor,String nazwa)
	{
		this.nazwa = nazwa;
		this.kolor = kolor;
		this.ilosc = ilosc;
	}
}
