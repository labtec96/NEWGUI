/**
 *
 *  @author Han Cezary S15831
 *
 */

package zadanie1;

import javax.swing.JFrame;

public class Main {
  public static void main(String[] args) {

    Calc c = new Calc();
    double l1 = c.add(1, 3);
    System.out.println(c);
    double l2 = c.substract(1.11, 5.0);
    System.out.println(c);
    double l3 = c.multiply(3, 1.9);
    System.out.println(c);
    c.divide(l1, l2);
    System.out.println(c);
    double x = c.divide(l1, 0.0);

    System.out.println(c);
    System.out.println(x);
    System.out.println(l3);
    
    Ramka ramka = new Ramka();
    ramka.setSize(516, 600);
    ramka.setVisible(true);
    ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
}