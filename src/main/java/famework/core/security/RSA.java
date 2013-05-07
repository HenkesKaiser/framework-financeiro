package famework.core.security;

import java.io.File;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class RSA
{

	/**
	 * Cifra um bloco de dados com a chave p�blica.
	 * 
	 * @param pub
	 *            A chave p�blica.
	 * @param textoClaro
	 *            O bloco de dados a ser cifrado.
	 * @return Dois arrays de bytes, sendo que o primeiro � o bloco cifrado, e o
	 *         segundo � a chave gerada e cifrada. N�o jogue fora nenhum deles.
	 * @throws NoSuchAlgorithmException
	 *             Algoritmo (AES) n�o dispon�vel na sua vers�o do JDK.
	 * @throws NoSuchPaddingException
	 *             Padding (PKCS5Padding) n�o dispon�vel na sua vers�o do JDK.
	 * @throws InvalidKeyException
	 *             Se a chave p�blica for inv�lida.
	 * @throws IllegalBlockSizeException
	 *             N�o deve ocorrer.
	 * @throws BadPaddingException
	 *             N�o deve ocorrer.
	 * @throws InvalidAlgorithmParameterException
	 *             N�o deve ocorrer.
	 */
	public byte[][] cifra(PublicKey pub, byte[] textoClaro)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException, InvalidAlgorithmParameterException
	{
		byte[] textoCifrado = null;
		byte[] chaveCifrada = null;

		// -- A) Gerando uma chave sim�trica de 128 bits
		KeyGenerator kg = KeyGenerator.getInstance("AES");
		kg.init(128);
		SecretKey sk = kg.generateKey();
		byte[] chave = sk.getEncoded();
		// -- B) Cifrando o texto com a chave sim�trica gerada
		Cipher aescf = Cipher.getInstance("AES/CBC/PKCS5Padding");
		IvParameterSpec ivspec = new IvParameterSpec(new byte[16]);
		aescf.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(chave, "AES"), ivspec);
		textoCifrado = aescf.doFinal(textoClaro);
		// -- C) Cifrando a chave com a chave p�blica
		Cipher rsacf = Cipher.getInstance("RSA");
		rsacf.init(Cipher.ENCRYPT_MODE, pub);
		chaveCifrada = rsacf.doFinal(chave);

		return new byte[][] { textoCifrado, chaveCifrada };
	}
}

/**
 * A classe a seguir cifra a decifra a string "Hello, world!".
 */
class ExemploCriptografia
{
	/**
	 * Mostra um array de bytes como um "dump".
	 * 
	 * @param b
	 *            O array de bytes que deve ser mostrado em formato dump.
	 */
	static void printHex(byte[] b)
	{
		if (b == null) {
			System.out.println("(null)");
		}
		else {
			for (int i = 0; i < b.length; ++i) {
				if (i % 16 == 0) {
					System.out.print(Integer
							.toHexString((i & 0xFFFF) | 0x10000)
							.substring(1, 5)
							+ " - ");
				}
				System.out.print(Integer.toHexString((b[i] & 0xFF) | 0x100)
						.substring(1, 3) + " ");
				if (i % 16 == 15 || i == b.length - 1) {
					int j;
					for (j = 16 - i % 16; j > 1; --j) {
						System.out.print("   ");
					}
					System.out.print(" - ");
					int start = (i / 16) * 16;
					int end = (b.length < i + 1) ? b.length : (i + 1);
					for (j = start; j < end; ++j) {
						if (b[j] >= 32 && b[j] <= 126) {
							System.out.print((char) b[j]);
						}
						else {
							System.out.print(".");
						}
					}
					System.out.println();
				}
			}
			System.out.println();
		}
	}

	/**
	 * O programa principal
	 * 
	 * @param args
	 *            Os argumentos s�o ignorados.
	 * @throws Exception
	 *             Lan�o uma Exception para n�o poluir muito o c�digo de
	 *             demonstra��o com tratamento de exce��es. Em um programa
	 *             "de verdade" voc� deveria tratar corretamente as exce��es.
	 */
	public static void main(String[] args) throws Exception
	{
		// -- Gera o par de chaves, em dois arquivos (chave.publica e
		// chave.privada)
		GeradorParChaves gpc = new GeradorParChaves();
		gpc.geraParChaves(new File("chave.publica"), new File("chave.privada"));

		// -- Cifrando a mensagem "Hello, world!"
		byte[] textoClaro = "Hello, world!".getBytes("ISO-8859-1");
		CarregadorChavePublica ccp = new CarregadorChavePublica();
		PublicKey pub = ccp.carregaChavePublica(new File("chave.publica"));
		RSA cf = new RSA();
		byte[][] cifrado = cf.cifra(pub, textoClaro);
		printHex(cifrado[0]);
		printHex(cifrado[1]);

		// -- Decifrando a mensagem
		CarregadorChavePrivada ccpv = new CarregadorChavePrivada();
		PrivateKey pvk = ccpv.carregaChavePrivada(new File("chave.privada"));
		Decifrador dcf = new Decifrador();
		byte[] decifrado = dcf.decifra(pvk, cifrado[0], cifrado[1]);
		// System.out.println (new String (textoClaro, "ISO-8859-1"));
		printHex(decifrado);
	}
}
