package famework.core.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.PrivateKey;

/**
 * Serve para carregar a chave privada de um arquivo. N�o � o melhor jeito de
 * guardar a chave (� melhor e mais seguro usar um keystore), mas fa�o isso s�
 * para simplificar.
 */

class CarregadorChavePrivada
{
	/**
	 * Carrega a chave privada serializada de um arquivo.
	 * 
	 * @param fPvk
	 *            O arquivo com a chave privada serializada.
	 * @return A chave privada.
	 * @throws IOException
	 *             Se n�o achar o arquivo, ou se houver algum problema
	 * @throws ClassNotFoundException
	 *             O objeto contido no arquivo � de uma classe n�o presente
	 *             neste projeto.
	 */
	public PrivateKey carregaChavePrivada(File fPvk) throws IOException,
			ClassNotFoundException
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fPvk));
		PrivateKey ret = (PrivateKey) ois.readObject();
		ois.close();
		return ret;
	}
}
