package zadanie2;

import java.math.BigDecimal;

public class Odejmowanie implements Operacje
{

	@Override
	public BigDecimal operacja(BigDecimal liczba1, BigDecimal liczb2)
	{
		BigDecimal wynik  =liczba1.subtract(liczb2);
		return wynik;
	}

}
