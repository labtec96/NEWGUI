/**
 *
 *  @author Han Cezary S15831
 *
 */

package zadanie1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main 
{

  public static void main(String[] args) 
  {
	  new Ramka();
  }
  
}
class Ramka extends JFrame
{
	JTextArea tekst;
	JScrollPane scrollPane = new JScrollPane();
	  public Ramka ()
	  {
		  tekst = new JTextArea(3,25);
		  scrollPane = new JScrollPane(tekst, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		  setLayout(new FlowLayout());
		  tekst.setFont(new Font("Dialog", Font.BOLD, 14));
		  tekst.setForeground(Color.yellow);
		  tekst.setBackground(Color.BLUE);
		  add(scrollPane);
		 // add(scrollPane, BorderLayout.CENTER);
		  setVisible(true);
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  setSize(600, 450);
	  }
}

