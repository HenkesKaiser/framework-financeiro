package framework.core.util;

public class BooleanExtensions
{

	public static String simnaoString(Boolean condicao)
	{
		return condicao ? "Yes" : "No";
	}

	public static int simnaoNumero(Boolean condicao)
	{
		return condicao ? 1 : 0;
	}
}
