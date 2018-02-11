/**
 *
 *  @author Han Cezary S15831
 *
 */

package zadanie2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Author implements Runnable 
{
	private boolean czyPrzeszlo = false;
	public BlockingQueue<String> kolejka = new ArrayBlockingQueue<String>(1000);
    String[] argumenty;
	
	public Author(String[] args)
	{
		 this.argumenty = args;
	}

	@Override
	public void run()
	{
		for(int i =0; i < argumenty.length; i++)
		{
		 try 
		 {
             Thread.sleep(1000);
             kolejka.put(argumenty[i]);
		 } catch (InterruptedException e) {
             e.printStackTrace();
         	}   
		}
		setczyPrzeszlo(true) ;
	}
	
	
	
	public void setczyPrzeszlo(boolean wartosc) 
	{
        this.czyPrzeszlo = wartosc;
    }

	public boolean getczyPrzeszlo()
	{
		return this.czyPrzeszlo;
	}
}  
