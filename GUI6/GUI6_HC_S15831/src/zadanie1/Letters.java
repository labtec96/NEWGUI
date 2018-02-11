package zadanie1;

import java.util.ArrayList;

public class Letters extends Thread
{
	boolean stanWatku =false;
	ArrayList<Thread> listaWatkow = new ArrayList<Thread>();
	String ciag;
	
	void koniecWatku ()
	{
		 stanWatku=false;
	}
	void poczatekWatku ()
	{
		stanWatku=true;
	}
	
	public Letters(String ciag)
	{
		this.ciag = ciag;
		for(int i = 0; i < ciag.length(); i++)
		{
			String litera = ciag.substring(i, i+1);
            //System.out.println(litera);
            listaWatkow.add(new Thread("Theard " + litera)
            {
            public void run()
            {
            	poczatekWatku();
                while(stanWatku==true)
                {
                    try
                    {
                        System.out.print(litera);
                        Thread.sleep(1000);
                    } catch (InterruptedException ie)
                    {
                        break;
                    }
                }   
            }
        });
		}
	}

	public ArrayList<Thread> getThreads()
	{
		return listaWatkow;
	}
	
}
