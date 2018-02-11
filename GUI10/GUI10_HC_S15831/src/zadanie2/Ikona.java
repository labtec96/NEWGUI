package zadanie2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class Ikona implements Icon
{
	public Color kolor;
	int width=10, height=10;
	public Ikona (Color kolor) 
	{
		this.kolor = kolor;
	}
	@Override
	public int getIconHeight()
	{
		return height;
	}

	@Override
	public int getIconWidth()
	{
		return width;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		//Color temp = g.getColor();
		g.setColor(kolor);
        g.fillOval(x, y, getIconWidth(), getIconHeight());
       // g.setColor(temp);
	}
}
