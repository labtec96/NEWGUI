package Zadanie1;

public class Account 
{
	double stanKonta;
	static double  InterestRate; 
	public void deposit (double depozyt)
	{
		if (depozyt>0)
			this.stanKonta = this.stanKonta+ depozyt;
		else
			System.out.println("Ujemny lub zerowy depozyt");
	}
	
	public void withdraw (double wyplata)
	{
		if (this.stanKonta - wyplata>=0 && wyplata>0)
		{
			this.stanKonta = this.stanKonta - wyplata;
		}
		else 
			System.out.println("Nie masz wystarczajac srodkow lub wartosc jest ujemna");
	}

	public void transfer(Account kontoDotransferu, double kwota) 
	{
		if (this.stanKonta - kwota>=0 && kwota >0)
		{
			this.stanKonta = this.stanKonta - kwota;
			kontoDotransferu.stanKonta=kontoDotransferu.stanKonta+kwota;
		}
		else 
			System.out.println("Nie masz wystarczajaca srodkow lub ujemna kwota");
	}

	public static void setInterestRate(double d) 
	{
		InterestRate = d;
	}

	public void addInterest() 
	{
		this.stanKonta = this.stanKonta + (this.stanKonta*(InterestRate/100)); 
	}
	
	
}
