package zadanie2;

import java.util.ArrayList;

public class StringTask implements Runnable
{
	Thread thread;
	public enum stany
	{
		CREATED, RUNNING, ABORTED, READY
	}

	volatile boolean czyZakonczeonePoprawnie = false;
	volatile stany st;
	String tekstDoPowielenia = null;
	String tekst = "";
	 int dlugosc = 0;

	public StringTask(String tekst, int dlugosc)
	{
		st = stany.CREATED;
		this.tekstDoPowielenia = tekst;
		this.dlugosc = dlugosc;
	}
	
	public void run()
	{
		int i=0;
		while (!thread.isInterrupted())
		{
				st = stany.RUNNING;
				this.tekst = this.tekst + this.tekstDoPowielenia;
				i++;
		}
		if (st!=stany.ABORTED)
		{
			czyZakonczeonePoprawnie = true;
			st = stany.READY;
			thread.interrupted();
		}
	}
	public void abort()
	{
		czyZakonczeonePoprawnie = true;
		st = stany.ABORTED;
	}
	public stany getState()
	{
		return st;
	}

	public void start()
	{
		thread = new Thread(this);
        thread.start();
	}

	public boolean isDone()
	{
		return czyZakonczeonePoprawnie;
	}

	public String getResult()
	{
		return tekst;
	}

}
