/**
 *
 *  @author Han Cezary S15831
 *
 */

package zadanie3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Main 
{
 public static void main(String[] args) 
	{
	  new Ramka();
	}
}
class Ramka extends JFrame
{
	 public Ramka ()
	 {

		 String input = (String) JOptionPane.showInputDialog("Podaj wartosc");
		 input= input.toUpperCase();
		 setVisible(true);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setSize(600, 450);
		 JButton q = new JButton("Przycisk 1"), w = new JButton("P 2"), e = new JButton(
	                "Większy przycisk numer 3"), r = new JButton("Przycisk 4"), t = new JButton("P5");
		 switch (input) 
		 {
		    case "A":
		    	BorderLayout borderLayout = new BorderLayout();
			     setLayout(borderLayout);
			     borderLayout.addLayoutComponent(q, BorderLayout.NORTH);
			     borderLayout.addLayoutComponent(w, BorderLayout.SOUTH);
			     borderLayout.addLayoutComponent(e, BorderLayout.WEST);
			     borderLayout.addLayoutComponent(r, BorderLayout.EAST);
			     borderLayout.addLayoutComponent(t, BorderLayout.CENTER);
			     break;
		    case "B":
		    	setLayout(new FlowLayout());
		    	break;
		    case "C":
		    	setLayout(new FlowLayout(FlowLayout.LEFT));
		    	break;
		    case "D":
		    	setLayout(new FlowLayout(FlowLayout.RIGHT));
			      break;
		    case "E":
		    	setLayout(new GridLayout (1,0));
			      break;
		    case "F" :
		    	setLayout(new GridLayout (0,1));
			      break;
		    case "G" :
		    	setLayout(new GridLayout (3,2));
		    	break;
		    default:
		      System.out.println("nieprzewidziana sytuacja");
		  }
		 add(q);
	     add(w);
	     add(e);
	     add(r);
	     add(t);
	 }
}

