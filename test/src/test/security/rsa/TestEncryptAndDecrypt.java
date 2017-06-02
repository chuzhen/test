package test.security.rsa;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.Cipher;

/**
 * ��ע�������¼��ֻ�ǲ��Է�������Ȼ��ʵ��ʹ�ù����У����ܻ���Ҫ �Լ��ܺ�� byte[] ���� base64 ���룬
 * ת�����ַ����洢�������ڽ��ܵ�ʱ����ͨ�� base64 ��ԭ�� byte, Ȼ���ڽ��ܣ����������
 * @author zhen
 *
 */
public class TestEncryptAndDecrypt {
	public static void main(String[] args) throws Exception {
		String input = "thisIsMyPassword$7788";
		Cipher cipher = Cipher.getInstance("RSA");
		RSAPublicKey pubKey = (RSAPublicKey) PublicKeyReader
				.get("d:/publicKeyFile");
		RSAPrivateKey privKey = (RSAPrivateKey) PrivateKeyReader
				.get("d:/privateKeyFile");
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		byte[] cipherText = cipher.doFinal(input.getBytes());
		// ���ܺ�Ķ���
		System.out.println("cipher: " + new String(cipherText));
		// ��ʼ����
		cipher.init(Cipher.DECRYPT_MODE, privKey);
		byte[] plainText = cipher.doFinal(cipherText);
		System.out.println("plain : " + new String(plainText));
	}

}
