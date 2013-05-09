package framework.core.data.tag.facelets;

public class ConvertNumber
{
	public String type; // Tipo de número
	public String pattern; // Formatação de um texto
	public String maxFractionDigits; // Máximo de digitos em números decimais

	public String minFractionDigits; // Mínimo de digitos em números decimais

	public String maxIntegerDigits; // Máximo de digitos em números inteiros

	public String minIntegerDigits; // Mínimo de digitos em números decimais

	public String integerOnly;// Retorna true caso o número for inteiro, por
								// (default : false)

	public String groupingUsed;// Retorna true separar (default: true)

	public String locale; // Retorna localização para formatar e converter

	public String currencyCode;// Código de moeda quando converter valor de uma
								// moeda
	// String ISO 4217 currency code to use when
	// converting currency values
	public String currencySymbol;// Simbolo de moeda quando converter valor de
									// uma moeda

}
