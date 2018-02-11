package zadanie2;


public class ReversibleDouble implements Reversible
{
	double liczba;
	public ReversibleDouble(double liczba)
	{
		this.liczba=liczba;
	}

	@Override
	public Reversible reverse()
	{
		this.liczba = 1/this.liczba;
		return this;
	}
	public String toString()
	{
		return ""+liczba;
	}


	
}
