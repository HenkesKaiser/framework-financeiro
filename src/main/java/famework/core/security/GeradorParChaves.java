package famework.core.security;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.RSAKeyGenParameterSpec;

/**
 * Gera um par de chaves e as guarda em formato serializado. (n�o � o formato
 * mais seguro - seria melhor usar um keystore, que pode ser protegido por
 * senha), mas fa�o isto para simplificar a compreens�o.
 */
class GeradorParChaves
{
	private static final int RSAKEYSIZE = 1024;

	/**
	 * Gera um par de chaves e as guarda em formato serializado em arquivos.
	 * 
	 * @param fPub
	 *            O arquivo que ir� conter a chave p�blica.
	 * @param fPvk
	 *            O arquivo que ir� conter a chave privada.
	 * @throws IOException
	 *             Problemas de acesso/grava��o do arquivo.
	 * @throws NoSuchAlgorithmException
	 *             RSA n�o dispon�vel nesta vers�o do JDK.
	 * @throws InvalidAlgorithmParameterException
	 *             N�o deve ocorrer.
	 * @throws CertificateException
	 *             N�o deve ocorrer.
	 * @throws KeyStoreException
	 *             N�o deve ocorrer.
	 */
	public void geraParChaves(File fPub, File fPvk) throws IOException,
			NoSuchAlgorithmException, InvalidAlgorithmParameterException,
			CertificateException, KeyStoreException
	{

		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		kpg.initialize(new RSAKeyGenParameterSpec(RSAKEYSIZE,
				RSAKeyGenParameterSpec.F4));
		KeyPair kpr = kpg.generateKeyPair();
		PrivateKey priv = kpr.getPrivate();
		PublicKey pub = kpr.getPublic();

		// -- Gravando a chave p�blica em formato serializado
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				fPub));
		oos.writeObject(pub);
		oos.close();

		// -- Gravando a chave privada em formato serializado
		// -- N�o � a melhor forma (deveria ser guardada em um keystore, e
		// protegida por senha),
		// -- mas isto � s� um exemplo
		oos = new ObjectOutputStream(new FileOutputStream(fPvk));
		oos.writeObject(priv);
		oos.close();

	}
}
