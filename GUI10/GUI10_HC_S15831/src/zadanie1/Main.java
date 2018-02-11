/**
 *
 *  @author Han Cezary S15831
 *
 */

package zadanie1;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Main {

  public static void main(String[] args) 
  {
	  new Ramka();
  }
}
class Ramka extends JFrame implements ActionListener
{
	JButton button;
	List<Color> lista = new ArrayList<Color>();
	public Ramka()
	{
		lista.add(Color.BLACK);
		lista.add(Color.BLUE);
		lista.add(Color.GRAY);
		lista.add(Color.GREEN);
		lista.add(Color.YELLOW);
		button = new  JButton("Przycisk");
		button.setBackground(lista.get(0));
		button.addActionListener(this);
		add(button);
		setVisible(true); 
	 	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	setSize(600, 450);
	}
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==button)
		{
			if (lista.indexOf(button.getBackground())==lista.size()-1)
				button.setBackground(lista.get(0));
			else
				button.setBackground((lista.get(lista.indexOf(button.getBackground())+1)));
		}
	}
}
