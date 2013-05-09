package famework.core.controller.financeiro;

public class Juros
{

	public static float jurosCompostos(float P, float i, float n)
	{

		float soma = 0;

		for (int j = 1; j < n; j++) {

			soma += P * Math.pow((1 + i), n);
		}

		return soma;

	}

	public static float valorMontanteSimples(float PV, float i, float n)
	{
		return PV * (1 + i * n);

	}

	public static float valorPresente(float FV, float i, float n)
	{
		return FV / (1 + i * n);

	}

	public static float peridoJuros(float PV, float J, float i)
	{
		return J / (i * PV);

	}

	public static float peridoJurosValorPresente(float PV, float FV, float i)
	{
		return (FV - PV) / (i * PV);

	}

	public static float valor_presente_desconto_simples_comercial(float FV,
			float i, float n)
	{
		return FV * (1 - i * n);

	}

	public static float valor_presente_desconto_simples_comercial(float DC,
			float FV)
	{
		return FV - DC;

	}

}
