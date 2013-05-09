package famework.core.controller.financeiro;

public abstract class JurosSimples
{

	public static float jurosSimples(float P, float i, float n)
	{

		return P * i * n;

	}

	public static float jurosSimplesqualquer(float P, float r, float n)
	{

		return P * r * n / 100;

	}

	public static float jurosSimplesMes(float P, float r, float m)
	{

		return P * r * m / 100;

	}

	public static float jurosSimplesDia(float P, float r, float d)
	{

		return P * r * d / 100;

	}

	public static float montante(float C, float i, float t)
	{

		// return M = P + j = P (1 + i n);
		return C * (C * i * t);

	}

	public static float jurosSimplesAno(float P, float r, float d)
	{

		return P * r * (d / 365) / 100;

	}

}
