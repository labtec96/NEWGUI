/**
 *
 *  @author Han Cezary S15831
 *
 */

package zadanie3;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;


public class Main {

  public static void main(String[] args) throws NumberFormatException, IOException 
  {
	  Ramka ramka= new Ramka();
	  ramka.setVisible(true);
	  ramka.setSize(new Dimension(600, 400));
	  ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
