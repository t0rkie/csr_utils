package com.example.test.keyGenerator;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequestBuilder;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;



public class KeyGenerator {
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, InvalidKeySpecException, IOException {
		
		createPublicKeyWithECC(521);
		createPublicKeyWithRSA(2048);
		readPublicKey();
		
	}
	
	private static void createPublicKeyWithECC(int keySize) throws NoSuchAlgorithmException {

		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
	
		SecureRandom randomGen = SecureRandom.getInstance("sha1prng");
		
		keyGen.initialize(keySize, randomGen);
		
		KeyPair keyPair = keyGen.generateKeyPair();
		
		PublicKey publicKey = keyPair.getPublic();
		System.out.println("public key: \n" + publicKey);
	}
	
	private static void createPublicKeyWithRSA(int keySize) throws NoSuchAlgorithmException {
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(keySize);
		KeyPair keyPair = keyGen.generateKeyPair();
		
		PublicKey publicKey = keyPair.getPublic();
		
		System.out.println("public key (RSA) \n" + publicKey);
	}
	
	private static void readPublicKey() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
		
		String base64String = 
				"-----BEGIN PUBLIC KEY-----\n"+
				"MIIBIDANBgkqhkiG9w0BAQEFAAOCAQ0AMIIBCAKCAQEAuXp76wv8OHrd5li4QT0A\n"+
				"liLcQ739IjRhUOlBK8zOTCo9ZDg1WVVf00AGQ1Ffs28mpwxTGCfAFtCZAvRr905z\n"+
				"l+RgxlkEFHHRtOKhZhrF9SIRKxfQ3zf/C0f2XWwpTcP0dY5IdFZGSeyxuC3ebOzC\n"+
				"+K+3vz20Ahr3yNgnKtVn0wGQbvbsLEhqlEjs9UUsQIqtPC99PrwpoOPdmsExJf3C\n"+
				"Phepi1oIBxt3p2SREdMKccZETK6YRKzGdL3ulpF8EQe/PkiEeqir82QeNULGn92W\n"+
				"gRlrag5cIUg3sTImth7Yn71g3bPHsFZ7Nu1hLOits0ew45boUlyP3GXPizpTcvdw\n"+
				"PwIBIw==\n"+
				"-----END PUBLIC KEY-----\n";
		  
		PemReader pemReader = new PemReader(new StringReader(base64String));
		PemObject rsaPubKey = pemReader.readPemObject();
		byte[] key = rsaPubKey.getContent();
		
		PublicKey pk = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(key));
		
		
			
	//	PKCS10CertificationRequestBuilder csrBuilder = new JcaPKCS10CertificationRequestBuilder(subject, pk);
	
		   
		pemReader.close();
	}

}
