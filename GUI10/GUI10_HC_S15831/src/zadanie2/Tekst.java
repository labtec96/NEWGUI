package zadanie2;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Tekst
{
	private String sciezka = "";
	private File ostatniKatalog;
	public Tekst ()
	{
		
	}

	public String getSciezka()
	{
		return sciezka;
	}
	public String otworz()
	{
		String tekst = "";
		JFileChooser fc =new JFileChooser(ostatniKatalog);
		if (fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
		{
			ostatniKatalog = fc.getCurrentDirectory();
			File plik = fc.getSelectedFile();
			this.sciezka = plik.getPath();
			try
			{
				Scanner skaner = new Scanner(plik);
				while(skaner.hasNextLine())
					tekst =tekst+ skaner.nextLine() + "\n";
				skaner.close();
			} catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			//System.out.println(tekst.toString());
		}
		return tekst;
	}
	public void zapisz(String tekstWyjsciowy)
	{
		
			File f = new File(sciezka);
			if(f.exists() && !f.isDirectory())
			{
				try(PrintWriter out = new PrintWriter(sciezka))
				{
				    out.println( tekstWyjsciowy );
				} catch (FileNotFoundException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		else 
		{
			zapiszJako(tekstWyjsciowy);
		}
	}
	public void zapiszJako(String tekstWyjsciowy)
	{
		JFileChooser fc = new JFileChooser(ostatniKatalog);
		if (fc.showSaveDialog(null)==JFileChooser.APPROVE_OPTION)
		{
			ostatniKatalog = fc.getCurrentDirectory();
			File plik =fc.getSelectedFile();
			try
			{
				PrintWriter pw = new PrintWriter(plik);
				Scanner skaner = new Scanner(tekstWyjsciowy);
				
				while (skaner.hasNextLine())
					pw.println(skaner.nextLine());
				this.sciezka=plik.getPath();
				pw.close();
				skaner.close();
			} catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			
		}
	}
}
