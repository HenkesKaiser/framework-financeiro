package famework.core.controller.financeiro;

public class Taxa
{

	public static double taxasEquivalentes(Integer i, Double n1, Double n2)
	{
		return Math.pow((1 + i), (n1 / n2)) - 1;

	}

	public static double taxasEfetiva(Integer i, Double K)
	{
		return Math.pow((1 + i / K), K) - 1;

	}
}
