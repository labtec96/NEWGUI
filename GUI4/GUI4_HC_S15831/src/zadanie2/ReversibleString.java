package zadanie2;

public class ReversibleString implements Reversible
{
	String tekst;
	public ReversibleString(String tekst)
	{
		this.tekst =tekst;
	}

	@Override
	public Reversible reverse()
	{
		String tmp=this.tekst;
		this.tekst ="";
		for (int i = tmp.length()-1; i>=0; i--)
		{
			tekst = tekst + tmp.charAt(i);
		}
		return this;
	}
	public String toString()
	{
		return tekst;
	}

	

}
