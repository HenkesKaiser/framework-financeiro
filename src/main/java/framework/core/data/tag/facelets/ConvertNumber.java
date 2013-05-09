package framework.core.data.tag.facelets;

public class ConvertNumber
{
	public String type; // Tipo de n�mero
	public String pattern; // Formata��o de um texto
	public String maxFractionDigits; // M�ximo de digitos em n�meros decimais

	public String minFractionDigits; // M�nimo de digitos em n�meros decimais

	public String maxIntegerDigits; // M�ximo de digitos em n�meros inteiros

	public String minIntegerDigits; // M�nimo de digitos em n�meros decimais

	public String integerOnly;// Retorna true caso o n�mero for inteiro, por
								// (default : false)

	public String groupingUsed;// Retorna true separar (default: true)

	public String locale; // Retorna localiza��o para formatar e converter

	public String currencyCode;// C�digo de moeda quando converter valor de uma
								// moeda
	// String ISO 4217 currency code to use when
	// converting currency values
	public String currencySymbol;// Simbolo de moeda quando converter valor de
									// uma moeda

}
