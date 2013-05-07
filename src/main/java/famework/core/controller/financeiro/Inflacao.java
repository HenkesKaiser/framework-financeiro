package famework.core.controller.financeiro;

public class Inflacao
{

	public static double amortizacaoConstante(Double Pt, Double PTo)
	{
		return (Pt / PTo) - 1;
	}

	public static double taxaDesvalorizaçãoMonetária(Double J)
	{
		return J / J + 1;
	}

	public static double taxaAparente(Double m1, Double m2)
	{
		return (m1 / m2) - 1;
	}

	public static double taxaReal(Double i, Double j)
	{
		return ((i + i) / (i + j)) - 1;
	}
}
