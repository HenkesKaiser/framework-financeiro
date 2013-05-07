package famework.core.controller.financeiro;

public class CorrecaoMonetaria
{

	public double correcao(int J, int P)
	{
		double soma = 0;
		for (int i = 0; i < J; i++) {
			soma = soma + P * (i + 1);
		}
		return soma;
	}

}
