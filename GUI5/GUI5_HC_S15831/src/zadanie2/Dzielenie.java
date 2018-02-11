package zadanie2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Dzielenie implements Operacje
{
	@Override
	public BigDecimal operacja(BigDecimal liczba1, BigDecimal liczb2)
	{
		BigDecimal wynik  =liczba1.divide(liczb2);
		return wynik;
	}
}
