package framework.core.util;

public class DoubleExtensions
{

	public static double valordefault = 0;

	public static Boolean obterRange(double valor, double minValor,
			double maxValor)
	{
		return (valor >= minValor && valor <= maxValor);
	}

	public static double inRange(double valor, double minValor,
			double maxValor, double defaultValor)
	{
		return obterRange(valor, minValor, maxValor) ? valor : defaultValor;
	}

	public static double inRange(double valor, double minValor, double maxValor)
	{
		return obterRange(valor, minValor, maxValor) ? valor : valordefault;
	}

}