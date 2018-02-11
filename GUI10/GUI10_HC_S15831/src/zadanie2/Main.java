/**
 *
 *  @author Han Cezary S15831
 *
 */

package zadanie2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;

import javafx.scene.layout.Border;


public class Main {

  public static void main(String[] args) 
  {
	new Ramka();
  }
}

class Ramka extends JFrame 
{
	Tekst tekstWczytany = new Tekst();
	JTextArea textArea;
	JMenuBar menu;
	JMenu file, edit, options, adresy, foreground, background, fontSize; 
	JButton dd;
	JMenuItem open, save, saveas, exit, praca, szkola,dom, wspolny;
	JSeparator sep1;
	public Ramka ()
	{
		setTitle("Prosty edytor - bez tytułu");
		Font f = new Font("sans-serif", Font.BOLD, 13);
		UIManager.put("Menu.font", f);
		UIManager.put("MenuItem.font", f);
		UIManager.put("MenuItem.border", BorderFactory.createLineBorder(Color.black));
		Map<String, Color> colors = new HashMap<String, Color>();

		colors.put("Blue", Color.BLUE);
		colors.put("Yellow", Color.YELLOW);
		colors.put("Orange", Color.ORANGE);
		colors.put("Red", Color.RED);
		colors.put("White", Color.WHITE);
		colors.put("Black", Color.BLACK);
		colors.put("Green", Color.GREEN);

		int[] fonts = { 8,10,12,14,16,18,20,22};
		
		
		menu = new JMenuBar();
		file = new JMenu("File");
		edit = new JMenu("Edit");
		options = new JMenu("Options");
		
		
		textArea = new JTextArea();
		add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
		
		
		setJMenuBar(menu);
		menu.add(file);
		menu.add(edit);
		menu.add(options);

		// file
		open = new JMenuItem("Open",'O');
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				ActionEvent.CTRL_MASK));
		open.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				textArea.setText(tekstWczytany.otworz());
				setTitle("Prosty Edytor - " + tekstWczytany.getSciezka());
			}
		});
		
		
		save = new JMenuItem("Save",'S');
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.CTRL_MASK));
		save.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				tekstWczytany.zapisz(textArea.getText());
			}
		});
		
		saveas = new JMenuItem("Save as ...",'a');
		saveas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				ActionEvent.CTRL_MASK));
		saveas.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				tekstWczytany.zapiszJako(textArea.getText());
			}
		});
		
		exit = new JMenuItem("Exit",'E');
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				ActionEvent.CTRL_MASK));
		exit.addActionListener(new ActionListener() 
		{
	        public void actionPerformed(ActionEvent event) 
	        {
	            System.exit(0);
	        }
		});
		sep1 = new JSeparator(SwingConstants.CENTER);
		sep1.setMaximumSize(new Dimension(100,100));
		sep1.setPreferredSize((new Dimension(50, 6)));
		sep1.setBackground(Color.RED);
		
		file.add(open);
		file.add(save);
		file.add(saveas);
		file.add(sep1);
		file.add(exit);
		
		
		
		// adresy 
		adresy = new JMenu("Adresy");
		praca = new JMenuItem("Praca", 'P');
		szkola = new JMenuItem("Szkola", 'S');
		dom = new JMenuItem("Dom",'D');
		
		edit.add(adresy);
		
		adresy.add(praca);
		praca.setAccelerator(KeyStroke.getKeyStroke("control shift P"));
		praca.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				textArea.insert("02-031 Warszawa ul. Zamoscia 3", textArea.getCaretPosition());
			}
		});
		
		adresy.add(szkola);
		szkola.setAccelerator(KeyStroke.getKeyStroke("control shift S"));
		szkola.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				textArea.insert("02-008 Warszawa ul. Koszykowa 86", textArea.getCaretPosition());
			}
		});
		
		adresy.add(dom);
		dom.setAccelerator(KeyStroke.getKeyStroke("control shift D"));
		dom.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				textArea.insert("01-231 Warszawa ul. Plocka 8", textArea.getCaretPosition());
			}
		});
		
		// Opcje 
		foreground = new JMenu("Foreground");
		background = new JMenu("Background");
		fontSize = new JMenu("Fontsize");
		options.add(foreground);
		options.add(background);
		options.add(fontSize);
		
		JMenuItem[] tablicaForeground = new JMenuItem[7];
		int fore =0;
		for (String kolor : colors.keySet())
		{
			tablicaForeground[fore] = new JMenuItem(kolor, new Ikona(colors.get(kolor)));
			foreground.add(tablicaForeground[fore]);
			tablicaForeground[fore].addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					textArea.setForeground(colors.get(kolor));
				}
			});
			fore++;
		}
		JMenuItem[] tablicaBackground = new JMenuItem[7];
		int back =0;
		for (String kolor : colors.keySet())
		{
			tablicaBackground[back] = new JMenuItem(kolor, new Ikona(colors.get(kolor)));
			background.add(tablicaBackground[back]);
			tablicaBackground[back].addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					textArea.setBackground(colors.get(kolor));
				}
			});
			back++;
		}
		JMenuItem[] tablicaFontow = new JMenuItem[8];
		int font = 0;
		for (int rozmiar : fonts)
		{	
			String tekst = rozmiar +" pts";
			tablicaFontow[font] = new JMenuItem(tekst);
			fontSize.add(tablicaFontow[font]);
			tablicaFontow[font].addActionListener(new ActionListener()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					//Font font = textArea.getFont();
					textArea.setFont( new Font(textArea.getFont().getFontName(), textArea.getFont().getStyle(), rozmiar) );
				}
			});
			font++;
		}
	
		
		setVisible(true); 
	 	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	setSize(600, 450);
	}
	
}
