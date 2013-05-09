package famework.core.controller.financeiro;

public class Desconto
{

	public static float valorfuturo_desconto_simples_comercial(float PV,
			float i, float n)
	{
		return PV / (1 - i * n);

	}

	public static float valor_futuro_desconto_simples_comercial(float DC,
			float PV)
	{
		return PV - DC;

	}

	public static float numero_periodo_desconto_simples_comercial(float PV,
			float FV, float i)
	{
		return FV - PV / FV * i;

	}

	public static float numero_periodo_desconto_simples(float DC, float FV,
			float i)
	{
		return DC / FV * i;

	}

	public static float taxa_desconto_simples_comercial(float DC, float FV,
			float n)
	{
		return DC / FV * n;

	}

	public static float taxa_desconto_simples(float PV, float FV, float n)
	{
		return FV - PV / FV * n;

	}

	public static float taxa_desconto_racional(float PV, float FV, float n)
	{
		return (FV / PV - 1) / n;

	}

	public static float periodo_desconto_racional(float PV, float FV, float i)
	{
		return (FV / PV - 1) / i;

	}

	public static float valor_presente_desconto_racional(float FV, float n,
			float i)
	{
		return FV / (1 - i * n);

	}

	public static float valor_futuro_desconto_racional(float PV, float n,
			float i)
	{
		return PV * (1 - i * n);

	}

	public static float desconto_simples_racional(float PV, float FV)
	{
		return FV - PV;

	}

	public static float desconto_simples_racional(float PV, float n, float i)
	{
		return PV * i * n;

	}

	public static float desconto_racional(float FV, float n, float i)
	{
		return (FV * i * n) / (1 + 1 * n);

	}

	public static float desconto_comercial_simples(float N, float d, float n)
	{

		return N * d * n;

	}

	public static float desconto_simples(float A, float d, float n)
	{

		return A * d * n;

	}

	public static float valor_atual(float N, float d)
	{

		return N * (1 - d);

	}

	public static float desconto_comercial_compostos(float N, float d, float n)
	{

		return N * d * n;

	}
}
