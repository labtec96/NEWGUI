/**
 *
 *  @author Han Cezary S15831
 *
 */

package zadanie2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class Main {

  public static void main(String[] args) 
  {
	  new Ramka();
  }
}
class Ramka extends JFrame
{
	  public Ramka ()
	  {
		  BorderLayout borderLayout = new BorderLayout();
		  setLayout(borderLayout);
		  setVisible(true);
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  setSize(600, 450);
		  JLabel n = new JLabel("NORTH"), s = new JLabel("SOUTH"), w = new JLabel(
	                "WEST"), e = new JLabel("EAST"), c = new JLabel("CENTER");
		  n.setForeground(Color.BLACK);
		  s.setForeground(Color.BLUE);
		  w.setForeground(Color.ORANGE);
		  e.setForeground(Color.RED);
		  c.setForeground(Color.YELLOW);
		  
		  n.setOpaque(true);
		  s.setOpaque(true);
		  w.setOpaque(true);
		  e.setOpaque(true);
		  c.setOpaque(true);
		  
		  n.setToolTipText("N");
		  s.setToolTipText("S");
		  w.setToolTipText("W");
		  e.setToolTipText("E");
		  c.setToolTipText("C");
		  
		  n.setFont(new Font("Arial", Font.ITALIC, 10));
		  s.setFont(new Font("Arial Black", Font.ROMAN_BASELINE, 11));
		  w.setFont(new Font("Baghdad", Font.CENTER_BASELINE, 12));
		  e.setFont(new Font("Cochin", Font.BOLD, 13));
		  c.setFont(new Font("Courier", Font.PLAIN, 23));
		  
		  n.setBorder(BorderFactory.createEtchedBorder());
		  s.setBorder(BorderFactory.createLoweredBevelBorder());
		  w.setBorder(BorderFactory.createSoftBevelBorder(ALLBITS));
		  e.setBorder(BorderFactory.createTitledBorder("obramowanie"));
		  c.setBorder(BorderFactory.createLineBorder(Color.cyan));
		  
		  n.setBackground(Color.LIGHT_GRAY);
		  s.setBackground(Color.PINK);
		  w.setBackground(Color.MAGENTA);
		  e.setBackground(Color.GREEN);
		  c.setBackground(Color.DARK_GRAY);
		  
		  add(n);
	      add(s);
	      add(w);
	      add(e);
	      add(c);
	      borderLayout.addLayoutComponent(n, BorderLayout.NORTH);
	      borderLayout.addLayoutComponent(s, BorderLayout.SOUTH);
	      borderLayout.addLayoutComponent(w, BorderLayout.WEST);
	      borderLayout.addLayoutComponent(e, BorderLayout.EAST);
	      borderLayout.addLayoutComponent(c, BorderLayout.CENTER);
	       
	  }
}
