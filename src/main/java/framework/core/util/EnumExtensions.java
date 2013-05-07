package framework.core.util;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class EnumExtensions
{

	public static Enumeration enumpop;

	public static <T> void populaEnum(List<T> lista_Enum)
	{
		enumpop = Collections.enumeration(lista_Enum);

	}

	public static Object mostraEnum()
	{
		return enumpop.nextElement();
	}
}