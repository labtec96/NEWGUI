package zadanie2;

import java.math.BigDecimal;

public class Dodawanie implements Operacje
{

	@Override
	public BigDecimal operacja(BigDecimal liczba1, BigDecimal liczb2)
	{
		BigDecimal wynik  =liczba1.add(liczb2);
		return wynik;
	}

}
