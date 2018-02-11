/**
 *
 *  @author Han Cezary S15831
 *
 */

package zadanie1;


public class Calc 
{
	double liczbaPierwsza;
	double liczbaDruga;
	String wynik="";
	
	public void setLiczbaPierwsza(double liczbaPierwsza)
	{
		this.liczbaPierwsza = liczbaPierwsza;
	}

	public void setLiczbaDruga(double liczbaDruga)
	{
		this.liczbaDruga = liczbaDruga;
	}

	public double add(double i, double j) 
	{
		wynik = i +" + "+ j + " = " + (i+j);
		return i+j;
	}

	public double substract(double d, double e) 
	{
		wynik = d +" - "+ e + " = " + (d-e);
		return d-e;
	}

	public double multiply(double i, double j)
	{
		wynik = i +" * "+ j + " = " + (i*j);
		return i*j;
	}

	public double divide(double i, double j) 
	{
		if (j==0.0)
		{
			wynik = i +" / "+ j + " = " + "ERR";
			
			return i%j;
		}
		else
		{
			wynik = i +" / "+ j + " = " + (i/j);
			return i/j;
		}
	}
	public String toString()
	{
		return wynik;
	}
}  

