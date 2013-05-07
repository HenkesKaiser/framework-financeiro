package famework.core.controller.financeiro;

public class CapitalizacaoComposta
{

	public static double futuroCapitalizacao(Integer PV, Double n, Double i)
	{
		return PV * Math.pow((1 + i), n);

	}

	public static double presenteCapitalizacao(Integer FV, Double n, Double i)
	{
		return FV * Math.pow((1 + i), -n);
	}

	public static double taxaJuro(Double PV, Double FV, Double n, Double i)
	{
		return Math.pow((FV / PV), 1 / n);
	}

	public static double periodoAplicacao(Double LN, Double PV, Double FV,
			Double n, Double i)
	{
		return (LN * (PV / FV)) / LN * (1 + i);
	}

}
