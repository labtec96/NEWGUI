package zadanie1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.sun.javafx.geom.Rectangle;


public class Ramka extends JFrame
{
	JLabel op, res;
	JButton add, rem, mul, div, eq, clr;
	JButton[] tabNumery = new JButton[10];
	char znak;
	double pierwsza, druga;
	Calc kalkualtor = new Calc();
	int ktoraZmienna=0;
	public Ramka()
	{
	    BorderLayout borderLayout = new BorderLayout();
		setLayout(borderLayout);
		JPanel panel = new JPanel();
		JPanel panelAkcji = new JPanel();
		JPanel panelWyniku = new JPanel();
		GridLayout gr= new GridLayout();
		gr.setColumns(4);
		gr.setRows(4);
		panel.setLayout(gr);
		panelAkcji.setLayout(gr);
		add(panelAkcji, BorderLayout.EAST);
		add(panel, BorderLayout.WEST);
		add(panelWyniku,BorderLayout.NORTH);
		//add(panel);
	//	panel.setPreferredSize(new Dimension(250, 250));
		int[] tablica = {0,1,2,3,4,5,6,7,8,9};
		for(int wartosc : tablica)
		{
			tabNumery[wartosc] = new JButton("n"+Integer.toString(wartosc));
			tabNumery[wartosc].setText(Integer.toString(wartosc));
			tabNumery[wartosc].setName("n"+Integer.toString(wartosc));
			tabNumery[wartosc].setPreferredSize(new Dimension(100, 66));
			panel.add(tabNumery[wartosc]);
			tabNumery[wartosc].addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
						op.setText(op.getText()+""+wartosc);
				}
			});
		}
		add = new JButton("add");
		add.setName("add");
		add.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (op.getText().length()>0)
				{
					pierwsza=(Double.parseDouble(op.getText()));
					op.setText(op.getText()+"+");
					znak='+';
				}
				else
				{
					op.setText(op.getText()+"+");
				}
			}
		});
		rem = new JButton("rem");
		rem.setName("rem");
		rem.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (op.getText().length()>0)
				{
					pierwsza=(Double.parseDouble(op.getText()));
					op.setText(op.getText()+"-");
					znak = '-';
				}
				else
				{
					op.setText(op.getText()+"-");
				}
			}
		});
		mul = new JButton("mul");
		mul.setName("mul");
		mul.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				pierwsza=(Double.parseDouble(op.getText()));
				op.setText(op.getText()+"/");
				znak = '/';
			}
		});
		div = new JButton("div");
		div.setName("div");
		div.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				pierwsza=(Double.parseDouble(op.getText()));
				op.setText(op.getText()+"*");
				znak = '*';
			}
		});
		eq = new JButton("eq");
		eq.setName("eq");
		eq.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
						
						druga = (Double.parseDouble(op.getText().substring(op.getText().indexOf(znak)+1, op.getText().length())));
						op.setText(op.getText()+"=");
						if (znak=='+')
						{
							res.setText(""+kalkualtor.add(pierwsza, druga));
						System.out.println(kalkualtor.toString());
						}
						else if (znak=='-')
						{
							res.setText(""+kalkualtor.substract(pierwsza, druga));
							System.out.println(kalkualtor.toString());
						}
						else if	(znak =='/')
						{
							res.setText(""+kalkualtor.divide(pierwsza, druga));
							System.out.println(kalkualtor.toString());
						}
						else if (znak =='*')
						{
							res.setText(""+kalkualtor.multiply(pierwsza, druga));
							System.out.println(kalkualtor.toString());
						}
			}
		});
		clr = new JButton("clr");
		clr.setName("clr");
		clr.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				pierwsza=0.0;
				druga=0.0;
				op.setText("");
				res.setText("");
				znak=' ';
			}
		});
		op = new JLabel("");
		add.setName("op");
		res = new JLabel("");
		res.setName("res");
		
		panelAkcji.add(add);
		add.setPreferredSize(new Dimension(100, 66));
		panelAkcji.add(rem);
		rem.setPreferredSize(new Dimension(100, 66));
		panelAkcji.add(mul);
		mul.setPreferredSize(new Dimension(100, 66));
		panelAkcji.add(div);
		div.setPreferredSize(new Dimension(100, 66));
		panelAkcji.add(eq);
		eq.setPreferredSize(new Dimension(100, 66));
		panelAkcji.add(clr);
		clr.setPreferredSize(new Dimension(100, 66));
		panelWyniku.setLayout(new BorderLayout());
		panelWyniku.add(op, BorderLayout.NORTH);
		op.setPreferredSize(new Dimension(200, 66));
		panelWyniku.add(res, BorderLayout.SOUTH);
		res.setPreferredSize(new Dimension(200, 66));
		
	}
}
