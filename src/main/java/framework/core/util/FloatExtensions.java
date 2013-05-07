package framework.core.util;

public class FloatExtensions
{
	public static float valordefault = 0;

	public static Boolean obterRange(float value, float minValue, float maxValue)
	{
		return (value >= minValue && value <= maxValue);
	}

	public static float InRange(float value, float minValue, float maxValue,
			float defaultValue)
	{
		return obterRange(value, minValue, maxValue) ? value : defaultValue;
	}

	public static float InRange(float value, float minValue, float maxValue)
	{
		return obterRange(value, minValue, maxValue) ? value : valordefault;
	}
}