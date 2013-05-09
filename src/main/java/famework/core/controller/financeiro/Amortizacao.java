package famework.core.controller.financeiro;

public class Amortizacao
{

	public static double amortizacaoConstante(Integer PV, Double n)
	{
		return PV / n;

	}

	public static double amortizacaoFraces(Integer PV, Double n, Double i)
	{
		return PV * (Math.pow((1 - i), n) * i / Math.pow((1 - i), n) - 1);
	}

}
