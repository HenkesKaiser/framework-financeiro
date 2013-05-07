package famework.core.controller.financeiro;

public class Depreciacao
{

	public static double depreciacaoLinear(Double PV, Double R, Double n)
	{
		return PV - R / n;
	}

	public static double vencimentoAnteriorFocal(Double PV, Double i, Double n)
	{
		return PV * Math.pow((1 + i), n);
	}

	public static double vencimentoPosteriorFocal(Double FV, Double i, Double n)
	{
		return FV / Math.pow((1 + i), n);
	}

	public static double juroCapitalizacaoComposta(Double PV, Double i, Double n)
	{
		return PV * (Math.pow((1 + i), n) - 1);
	}

	public static double juroCapitalizacaoComposta(Double FV, Double i,
			Integer n)
	{
		return FV * (1 - Math.pow((1 + i), -n));
	}

}
