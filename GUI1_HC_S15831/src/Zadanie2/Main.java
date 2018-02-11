/**
 *
 *  @author Han Cezary S15831
 *
 */

package Zadanie2;


public class Main {
	  
	  public static void main(String ... args) throws Exception  {
	    String home = System.getProperty("user.home");
	    Finder finder = new Finder(home + "/Test.java");
	    int nif = finder.getIfCount();
	    int nwar = finder.getStringCount("wariant");
	    System.out.println("Liczba instrukcji if: " + nif);
	    System.out.println("Liczba napisow wariant: " + nwar);
	  }
	  
	}
