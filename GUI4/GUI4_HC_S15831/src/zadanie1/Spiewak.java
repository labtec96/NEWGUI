/**
 *
 *  @author Han Cezary S15831
 *
 */

package zadanie1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Spiewak {
	String nazwisko;
	int nrWkonkursie;
	static int licznikNr=1;
	public Spiewak(String nazwisko) 
	{
		this.nrWkonkursie= licznikNr;
		this.nazwisko=nazwisko;
		licznikNr++;
	}
	abstract String spiewaj();
	public String toString ()
	{
		return "(" + this.nrWkonkursie + ") " + this.nazwisko+": " + spiewaj() ;
	}
	public static String najglosniej(Spiewak[] sp)
	{
		Spiewak najglosniejszy=null;
		int max=0;
		for (Spiewak s : sp)
		{
			int count=0;
			Pattern p = Pattern.compile("[A-Z]");
			Matcher m = p.matcher(s.spiewaj());
			while (m.find())
			{
				count++;
			}
			if (count>max)
			{
				najglosniejszy=s;
				max=count;
			}
		}
		return najglosniejszy.toString();
	}
	private boolean matches(String string)
	{
		// TODO Auto-generated method stub
		return false;
	}

}
	
