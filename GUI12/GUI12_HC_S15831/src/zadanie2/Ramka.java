package zadanie2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Ramka extends JFrame
{
	JTextField textField;
	JList<String> lista;
	public Ramka()
	{
		setLayout(new BorderLayout());
		DefaultListModel<String> model = new DefaultListModel<>();
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				model.addElement(textField.getText());
			}
		});
		add(textField,BorderLayout.PAGE_START);
		
		lista = new JList<>( model );
		lista.addKeyListener(new KeyListener()
		{
			
			@Override
			public void keyTyped(KeyEvent e)
			{
				
				
			}
			
			@Override
			public void keyReleased(KeyEvent e)
			{
				if (e.getKeyCode()==18)
				{
					model.remove(lista.getSelectedIndex());
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e)
			{
			}
		});
		add(new JScrollPane(lista, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS),BorderLayout.LINE_START);
		
	}
}
