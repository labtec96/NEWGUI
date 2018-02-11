/**
 *
 *  @author Han Cezary S15831
 *
 */

package zadanie2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.javafx.collections.SetAdapterChange;

import sun.rmi.transport.proxy.CGIHandler;

public class CountWords {
	List<String> lista = new ArrayList<String>();
	List<String> lista1 = new ArrayList<String>();
	public CountWords(String fname) throws FileNotFoundException 
	{
		StringBuffer sb = new StringBuffer();
		FileReader fr = new FileReader(fname);
		 Scanner skaner= new Scanner(fr);
		 //ystem.out.println(skaner.hasNext("<def>"));
			try
			{
				int tmp;
				while ((tmp =fr.read())!=-1)
				{
					//tmp = (char)fr.read();
					sb.append((char)tmp);
			 	}
				for (int i =0; i < sb.length(); i++)
				{
					if (sb.charAt(i)=='.'|| sb.charAt(i)=='?'||sb.charAt(i)=='!' ||sb.charAt(i)==';'||sb.charAt(i)==':'||
							sb.charAt(i)==',' ||sb.charAt(i)=='-' ||sb.charAt(i)=='"' ||sb.charAt(i)=='('||sb.charAt(i)==')')   
					{
						sb.setCharAt(i, ' ');
					}
				}
				for (int i =0; i < sb.length(); i++)
				{
					if ((int)sb.charAt(i)>=0 && (int)sb.charAt(i)<=31 )
					{
						sb.setCharAt(i, ' ');
						i--;
					}
				}

				for (int i =0; i < sb.length()-1; i++)
				{
					if ((sb.charAt(i)== ' ' && sb.charAt(i+1)== ' '))
					{
						sb.deleteCharAt(i);
						i--;
					}
				}
				int i = sb.length()-1;
				while (sb.charAt(i)== ' ')
				{
						sb.deleteCharAt(i);
					i--;
				}
				int last=0;
				String slowo;
				while (last !=-1)
				{
					int koniec = sb.indexOf(" ",last+1);
					if (sb.charAt(0) !=' ' && last==0)
					{
						slowo = sb.substring(last,sb.indexOf(" ",last+1));
						last = sb.indexOf(" ",last+1);
						lista1.add(slowo);
					}
					else
					{
							
						if (koniec == -1)
						{
							slowo = sb.substring(last+1,sb.length());
							last = sb.indexOf(" ",last+1);
							lista1.add(slowo);
						}
						else
						{
							slowo = sb.substring(last+1,koniec);
							last = sb.indexOf(" ",last+1);
							lista1.add(slowo);
						}
					}
					//System.out.println(last);
				}
				int ostaniapozycja = 0;
				fr.close();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 int[] tablica = new int[lista1.size()];
		 for (int i = 0; i < tablica.length; i++)
		{
			tablica[i] =1;
		} 
		for (int i = 0; i < lista1.size(); i++)
		{
			for (int j =i+1; j<lista1.size(); j++)
			{
				if (lista1.get(i).compareTo(lista1.get(j))==0)
				{
					tablica[i]++;
					lista1.remove(j);
					j--;
				}		
			}
		}
		int size =lista1.size();
		for (int i = 0; i < size; i++)
		{
			String slowo= lista1.get(i);
			//System.out.println(slowo);
			lista1.remove(i);
			lista1.add(i,slowo+ " " +String.valueOf(tablica[i]));
		}
//		StringBuffer sb = new StringBuffer();
//		try{		
//			FileReader fr = new FileReader(fname);
//			int tmp;
//			  while ((tmp = fr.read()) != -1) 
//			  {
//				  lista1.add(fr.toString());
//	             sb.append((char)tmp);
//			  }
//			  fr.close();
//		} catch (IOException e)
//		{
//			e.printStackTrace();
//		}
//		//System.out.println(sb.toString());
//		//lista1.add(fr.r)
//		Pattern p = Pattern.compile("\\W");
//		Matcher m = p.matcher(sb);
//		String tekst = m.replaceAll(" ");
//		for (int i = 0; i < tekst.length()-1; i++)
//		{
//			if (tekst.charAt(i) ==' ' && tekst.charAt(i)==' ')
//			{
//				//tekst.
//			}
//		}
//		System.out.println(tekst.toString());
	}

	public List<String> getResult() 
	{
		return lista1;
	}
}  
