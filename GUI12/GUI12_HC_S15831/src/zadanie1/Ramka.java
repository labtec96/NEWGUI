package zadanie1;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

public class Ramka extends JFrame
{
	AbstractListModel ab = new AbstractListModel<String>() {

		@Override
		public String getElementAt(int index) {
			return ""+(index-70) + "Stopni C = f Stopni "+ (32+((index-70)*9/5));
		}

		@Override
		public int getSize() {
			return 131;
		}
	};
	public Ramka ()
	{
		JList	list = new JList(ab);
	//	list.
		add(list);
	    JScrollPane panel = new JScrollPane(list);
	    add(panel);
	}
}
