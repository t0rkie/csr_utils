package com.example.test;

import java.io.IOException;
import java.io.StringWriter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.style.BCStrictStyle;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.ExtensionsGenerator;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequestBuilder;

public class CsrUtils {
	public static void main(String[] args) throws NoSuchAlgorithmException, OperatorCreationException, IOException {
		
		String csr = generateCsr();
		
		System.out.println(csr);
	}
	
	private static String generateCsr() throws NoSuchAlgorithmException, OperatorCreationException, IOException {
		
		ExtensionsGenerator extGen = new ExtensionsGenerator();
		
		
		Extensions extensions = extGen.generate();
		
		KeyPair keyPairForSign = generateKeyPairForSign();
		PublicKey publicKey = keyPairForSign.getPublic();
		PrivateKey privateKey = keyPairForSign.getPrivate();
		
		
		X500NameBuilder sbjBuilder = new X500NameBuilder(BCStyle.INSTANCE);
		ASN1ObjectIdentifier c = new BCStrictStyle().attrNameToOID("c");
		ASN1ObjectIdentifier st = new BCStrictStyle().attrNameToOID("st");
		
		sbjBuilder.addRDN(c, "test.com");
		sbjBuilder.addRDN(st, "street");
		
		X500Name subject = sbjBuilder.build();
		
		PKCS10CertificationRequestBuilder csrBuilder = new JcaPKCS10CertificationRequestBuilder(subject, publicKey);
		//csrBuilder.addAttribute(PKCSObjectIdentifiers.pkcs_9_at_extensionRequest, extensions);
		PKCS10CertificationRequest csrRequest = generateCsrRequest(csrBuilder, privateKey);
		
		String pem = parseToPem(csrRequest);
		
		return pem;
		
	}
	
	private static String parseToPem(PKCS10CertificationRequest csrRequest) throws IOException {
		StringWriter sw = new StringWriter();
		JcaPEMWriter pemWriter = new JcaPEMWriter(sw);
		pemWriter.writeObject(csrRequest);
		pemWriter.close();	
		return sw.toString();
		
	}
	
	
	private static PKCS10CertificationRequest generateCsrRequest(PKCS10CertificationRequestBuilder csrBuilder, PrivateKey privateKey) throws OperatorCreationException {
		JcaContentSignerBuilder jcsBuilder = new JcaContentSignerBuilder("SHA256WITHRSA");
		ContentSigner signer = jcsBuilder.build(privateKey);
		PKCS10CertificationRequest csrRequest = csrBuilder.build(signer);
		return csrRequest;
	}
	
	private static KeyPair generateKeyPairForSign() throws NoSuchAlgorithmException {
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(2048);
		KeyPair keyPair = keyGen.generateKeyPair();
		return keyPair;
	}
}