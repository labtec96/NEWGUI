package zadanie1;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.naming.OperationNotSupportedException;


public class Hailstone implements Iterable <Integer>
{
	int wartosc;
	public Hailstone(int wartosc) 
	{
		this.wartosc= wartosc;
	}
	 public Iterator<Integer> iterator() 
	 {
		 
	        return new MyIterator(this);
	 }

	 public static class MyIterator implements Iterator<Integer> 
	 {

	        private final Hailstone myArray;
	        private int current;
	        int back;
	        MyIterator(Hailstone myArray) {
	            this.myArray = myArray;
	            this.current = myArray.wartosc;
	        }
	        
	        
	        @Override
	        public boolean hasNext() 
	        {
	        	boolean b = !((current ==4) && (back==1));
	            return b;
	        }

	        @Override
	        public Integer next() 
	        {
	            if (hasNext())   
	            {
	            	
	 	            	if (this.current%2==0)
	 	            	{
	 	            		int tmp = this.current;
	 	            		this.current=this.current/2;
	 	            		back= tmp;
	 	            		return tmp;
	 	            	}
	 	            	else
	 	            	{
	 	            		int tmp = this.current;
	 	            		this.current=this.current*3+1;
	 	            		back = tmp;
	 	            		return tmp;
	 	            	}
	            }
	            else 
	            {
	            	throw new NoSuchElementException();
	            }
	        }
	 }
}