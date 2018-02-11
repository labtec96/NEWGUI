/**
 *
 *  @author Han Cezary S15831
 *
 */

package zadanie2;


public class Writer implements Runnable {
	Author autor;
	public Writer(Author autor)
	{
		this.autor = autor;
	}

	@Override
	public void run()
	{
		while(!autor.getczyPrzeszlo())
		{
            try {
                System.out.println("-> " + autor.kolejka.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		
		}
	}
}
