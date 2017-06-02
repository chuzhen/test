package test.security.rsa;

import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.util.Date;

/**
"非对称加密算法"。 
　　（1）乙方生成两把密钥（公钥和私钥）。公钥是公开的，任何人都可以获得，私钥则是保密的。 
　　（2）甲方获取乙方的公钥，然后用它对信息加密。 
　　（3）乙方得到加密后的信息，用私钥解密。 
如果公钥加密的信息只有私钥解得开，那么只要私钥不泄漏，通信就是安全的。公钥用于加密, 私钥用于解密. 

RSA 是一种非对称加密算法，一般很难破解，因此一些要求比较高的系统通常会采用rsa加密算法，一般来说用RSA加密有如下几个步骤. 
1. 生成公钥与私钥 
2. 用公钥对需要加密的字符串等进行加密 
3. 在需要解密的地方，用私钥进行解密 

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
