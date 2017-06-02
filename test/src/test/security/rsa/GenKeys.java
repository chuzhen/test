package test.security.rsa;

import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.util.Date;

/**
"�ǶԳƼ����㷨"�� 
������1���ҷ�����������Կ����Կ��˽Կ������Կ�ǹ����ģ��κ��˶����Ի�ã�˽Կ���Ǳ��ܵġ� 
������2���׷���ȡ�ҷ��Ĺ�Կ��Ȼ����������Ϣ���ܡ� 
������3���ҷ��õ����ܺ����Ϣ����˽Կ���ܡ� 
�����Կ���ܵ���Ϣֻ��˽Կ��ÿ�����ôֻҪ˽Կ��й©��ͨ�ž��ǰ�ȫ�ġ���Կ���ڼ���, ˽Կ���ڽ���. 

RSA ��һ�ַǶԳƼ����㷨��һ������ƽ⣬���һЩҪ��Ƚϸߵ�ϵͳͨ�������rsa�����㷨��һ����˵��RSA���������¼�������. 
1. ���ɹ�Կ��˽Կ 
2. �ù�Կ����Ҫ���ܵ��ַ����Ƚ��м��� 
3. ����Ҫ���ܵĵط�����˽Կ���н��� 

 * @author zhen
 *
 */
public class GenKeys {
	public static void main(String[] args) throws Exception {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		SecureRandom secureRandom = new SecureRandom(new Date().toString()
				.getBytes());
		keyPairGenerator.initialize(1024, secureRandom);
		KeyPair keyPair = keyPairGenerator.genKeyPair();
		String publicKeyFilename = "D:/publicKeyFile";
		byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
		FileOutputStream fos = new FileOutputStream(publicKeyFilename);
		fos.write(publicKeyBytes);
		fos.close();
		String privateKeyFilename = "D:/privateKeyFile";
		byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
		fos = new FileOutputStream(privateKeyFilename);
		fos.write(privateKeyBytes);
		fos.close();
	}

}
