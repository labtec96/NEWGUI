package zadanie3;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;

import javax.swing.ImageIcon;

import com.sun.prism.Image;

public class Obiekt
{
	String autor;
	String tytul;
	double cena;
	ImageIcon obrazek;
	public Obiekt(String autor, String tytul,double cena,ImageIcon obrazek)
	{
		this.autor = autor;
		this.tytul = tytul;
		this.cena = cena;
		this.obrazek = obrazek;
	}
}
