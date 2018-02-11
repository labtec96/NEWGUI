package zadanie2;

import java.math.BigDecimal;

public class Mnozenie implements Operacje
{

	@Override
	public BigDecimal operacja(BigDecimal liczba1, BigDecimal liczb2)
	{
		BigDecimal wynik  =liczba1.multiply(liczb2);
		return wynik;
	}

}
