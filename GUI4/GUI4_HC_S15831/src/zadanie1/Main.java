/**
 *
 *  @author Han Cezary S15831
 *
 */

package zadanie1;


public class Main {
  public static void main(String[] args)
  {
    Spiewak s1 = new Spiewak("Carrey"){
		String spiewaj() 
		{
			return "oooooooooooo";
		}

    };

    Spiewak s2 = new Spiewak("Houston"){
		String spiewaj() {
			return "a4iBBiii";
		}
    };

    Spiewak s3 = new Spiewak("Madonna"){
		String spiewaj() {
			return "aAa";
		}
      /*<-  kod */
    };

    Spiewak sp[] = {s1, s2, s3};

    for (Spiewak s : sp)
      System.out.println(s);


    System.out.println("\n" + Spiewak.najglosniej(sp));
  }
}
