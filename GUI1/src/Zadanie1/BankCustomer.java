package Zadanie1;

public class BankCustomer 
{
	Person osoba;
	Account konto = new Account();
	public BankCustomer(Person osoba)
	{
		this.osoba = osoba;
	}

	public Account getAccount() 
	{
		return this.konto;
	}
	public String toString()  
	{
		return "Klient: " + this.osoba.imie + " stan konta " + this.konto.stanKonta;
	}
}
