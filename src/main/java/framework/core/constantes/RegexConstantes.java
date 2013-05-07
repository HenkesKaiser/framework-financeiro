package framework.core.constantes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexConstantes
{

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(
			"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);
	public static final String VALID_NUMBER = ".*[^0-9].*";

	public static boolean validate(String emailStr)
	{
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	public static final String single_upper_case = "[A-Z]";
	public static final String zero_more_upper_case = "[A-Z]*";
	public static final String one_upper_case = "[A-Z]+";
	public static final String Exactly_two_upper_case = "[A-Z][A-Z]";
	public static final String Exactly_two_more_upper_case = "[A-Z]{2}";
	public static final String Two_more_upper_case = "[A-Z]{2,}";
	public static final String Between_upper_case = "[A-Z]{2,10}";
	public static final String single_letter = "[a-zA-Z]";
	// public static final String datetime =
	// "/^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/";
	// numeric ranges
}
