package zadanie3;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class TableClass extends JTable
{
	DefaultTableModel model;
	public TableClass() throws NumberFormatException, IOException
	{
		model = new DefaultTableModel();
		model.addColumn("autor");
		model.addColumn("tytul");
		model.addColumn("cena");
		model.addColumn("obrazek");
		this.setModel(model);
		List<Obiekt> listaObiektow = new ArrayList<Obiekt>();
		int max =0;
		try
		{
			FileReader f = new FileReader("D:/Javaprogramy/gui12.zip_expanded/GUI12_HC_S15831/src/zadanie3/plik.txt");
			Scanner skaner = new Scanner(f);
			while (skaner.hasNextLine())
			{
				String[] zmienna = skaner.nextLine().split(" ");
				ImageIcon image =new ImageIcon("D:/Javaprogramy/gui12.zip_expanded/GUI12_HC_S15831/src/zadanie3/"+zmienna[0]+".jpg");
				listaObiektow.add(new Obiekt(zmienna[0], zmienna[1], Double.parseDouble(zmienna[2]),image));
				if(image.getIconHeight()>max)
					max = image.getIconHeight();
			}
			skaner.close();
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setRowHeight(max);
		for (int i = 0; i < listaObiektow.size(); i++)
		{
			model.addRow(new Object[]
			{ listaObiektow.get(i).autor, listaObiektow.get(i).tytul, listaObiektow.get(i).cena, listaObiektow.get(i).obrazek});
		}
	}
	public Class getColumnClass(int c) 
	{     
		
		    if(c==2)
		       return Double.class;
		    if (c==3)
		    	return ImageIcon.class;
		    else
		    	return Object.class;
		  
		}

}
