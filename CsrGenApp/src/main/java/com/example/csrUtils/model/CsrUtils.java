package com.example.csrUtils.model;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.pkcs.Attribute;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.ExtensionsGenerator;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequestBuilder;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.csrUtils.dto.request.Request;
import com.example.csrUtils.dto.request.extension.ExtensionRequest;
import com.example.csrUtils.dto.request.subject.Subject;
import com.example.csrUtils.dto.response.Response;

public class CsrUtils {

	public Response readPem(String pem) throws IOException {

		ExtensionUtils extUtils = new ExtensionUtils();
		SubjectUtils sbjUtils = new SubjectUtils();
		
		List<Subject> sbjRequest = new ArrayList<>(); 
		ExtensionRequest extRequest = new ExtensionRequest();
		
		String type = checkType(pem);
		
		switch(type) {
		case "X509CertificateHolder":
			
			X509CertificateHolder certHolder = parseCertPem(pem);
			X500Name certSubject = certHolder.getSubject();
			sbjRequest = sbjUtils.createSbjHolder(certSubject);
			extRequest = extUtils.createExtensionRequest(certHolder.getExtensions());
			
			/*
			 * public key
			 */
			//byte[] publicKeyFromCert =  certHolder.getSubjectPublicKeyInfo().getPublicKey().getEncoded();
			
			break;
			
		case "PKCS10CertificationRequest":
			
			PKCS10CertificationRequest csrHolder = parseCsrPem(pem);
			X500Name csrSubject = csrHolder.getSubject();
			sbjRequest = sbjUtils.createSbjHolder(csrSubject);
			Extensions extensions = createExtensionsFromCsr(csrHolder);
			extRequest = extUtils.createExtensionRequest(extensions);
			
			/*
			 * public key
			 */
			//ASN1Primitive publicKeyFromCsr = csrHolder.getSubjectPublicKeyInfo().getPublicKey();
			
			break;
			
		default:
			break;
		}

		String subjectJson = null;
		String extJson = null;
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			subjectJson = mapper.writeValueAsString(sbjRequest);
			extJson = mapper.writeValueAsString(extRequest);
			
		}catch (JsonProcessingException j) {
			j.printStackTrace();
		}

		return new Response(subjectJson, extJson);
	}
	
	private String checkType(String pem) throws IOException {
		String type = "";
		
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        ByteArrayInputStream pemStream = null;
        try {
            pemStream = new ByteArrayInputStream(pem.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
        	e.printStackTrace();
        }

        Reader pemReader = new BufferedReader(new InputStreamReader(pemStream));
        PEMParser pemParser = new PEMParser(pemReader);

        try {
            Object parsedObj = pemParser.readObject();

            if (parsedObj instanceof PKCS10CertificationRequest) {
            	type = "PKCS10CertificationRequest";
            } else if (parsedObj instanceof X509CertificateHolder) {
            	type = "X509CertificateHolder";
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        pemParser.close();
    
		return type;
		
	}

	private Extensions createExtensionsFromCsr(PKCS10CertificationRequest csrHolder) {
		Attribute[] extensionRequests = csrHolder.getAttributes(PKCSObjectIdentifiers.pkcs_9_at_extensionRequest);
		
		for (Attribute extensionRequest:extensionRequests) {			
			
			ASN1Set attributeSet = extensionRequest.getAttrValues();
			
			if (attributeSet == null ) {
				continue;
			}
			
			ASN1Encodable extension = attributeSet.getObjectAt(0);
			
			if (extension instanceof Extensions) {
				
				Extensions extensions = (Extensions) extension;
				
				return extensions;
				
			} else if (extension instanceof DERSequence) {
				
				Extensions extensions = Extensions.getInstance(extension);
				
				return extensions;
			}

		}
			return null;
	}
	
	public static X509CertificateHolder parseCertPem(String pem) throws IOException {
		return new X509CertificateHolder(getContentFromPem(pem));
	}
	
	public static PKCS10CertificationRequest parseCsrPem(String pem) throws IOException {
		return new PKCS10CertificationRequest(getContentFromPem(pem));
	}
	
	private static byte[] getContentFromPem(String pem) throws IOException {
		
		Reader reader = new StringReader(pem);	
		PemReader pemReader = new PemReader(reader);
		PemObject pemObject = pemReader.readPemObject();		
		pemReader.close();
		return pemObject.getContent();
	}

	public String generatePem(String request) throws IOException, NoSuchAlgorithmException, OperatorCreationException, NoSuchProviderException, InvalidAlgorithmParameterException, InvalidKeySpecException {
		
		ExtensionUtils extUtils = new ExtensionUtils();
		SubjectUtils sbjUtils = new SubjectUtils();
		
		ObjectMapper mapper = new ObjectMapper();
		Request req = mapper.readValue(request, Request.class);
		ExtensionsGenerator extGen = new ExtensionsGenerator();

		X500Name subject = sbjUtils.createSubject(req);
		
        extGen = extUtils.addOtherExtension(extGen, req);
        extGen = extUtils.addSan(extGen, req);
		Extensions extensions = extGen.generate();
	
		KeyPair keyPairForSign = generateKeyPairForSign(req);
		PublicKey publicKey = keyPairForSign.getPublic();
		PrivateKey privateKey = keyPairForSign.getPrivate();
		String signatureAlgorithm = setSignatureAlgorithm(req);
		
		try {
			PKCS10CertificationRequestBuilder csrBuilder = new JcaPKCS10CertificationRequestBuilder(subject, publicKey);
			csrBuilder.addAttribute(PKCSObjectIdentifiers.pkcs_9_at_extensionRequest, extensions);
			
			PKCS10CertificationRequest csrRequest = generateCsrRequest(csrBuilder, privateKey, signatureAlgorithm);
			String pem = toPem(csrRequest);
			
			return pem;
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return null;
	}
	

	private static PKCS10CertificationRequest generateCsrRequest(PKCS10CertificationRequestBuilder csrBuilder, PrivateKey privateKey, String signatureAlgorithm) throws OperatorCreationException {
		JcaContentSignerBuilder csBuilder = new JcaContentSignerBuilder(signatureAlgorithm);
    	ContentSigner signer = csBuilder.build(privateKey);
    	PKCS10CertificationRequest csrRequest = csrBuilder.build(signer);
		return csrRequest;
	}
	
	private static KeyPair generateKeyPairForSign(Request req) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {

		KeyPair keyPairForSign = null;
		
		if (req.getPkRequest().getSpec() != null) {
			
			if (req.getPkRequest().getSpec().getRsa() != null) {
				
				int keySize = req.getPkRequest().getSpec().getRsa().getKeySize();
				keyPairForSign = generateKeyPairWithRSA(keySize);
				
			} else if(req.getPkRequest().getSpec().getEc() != null) {
				
				String curveName = req.getPkRequest().getSpec().getEc().getCurveName();
				keyPairForSign = generateKeyPairWithECC(curveName);
				
			}
			
		} else if(req.getPkRequest().getPublicKeyPem() != null) {
			
			String publicKeyPem = req.getPkRequest().getPublicKeyPem().getPublicKeyPem();
			
			PemReader pemReader = new PemReader(new StringReader(publicKeyPem));
			PemObject pemObject = pemReader.readPemObject();
			byte[] encodedKey = pemObject.getContent();
			
			PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(encodedKey));	
			PrivateKey privateKey = generateKeyPairWithRSA(2048).getPrivate();

			keyPairForSign = new KeyPair(publicKey, privateKey);
			
			pemReader.close();

		}
		
		return keyPairForSign;
	}

	private static KeyPair generateKeyPairWithRSA(int keySize) throws NoSuchAlgorithmException {
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(keySize);
		KeyPair keyPair = keyGen.generateKeyPair();
		
		return keyPair;
	}
	
	private static KeyPair generateKeyPairWithECC(String curveName) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
		
		ECGenParameterSpec  ecSpec = new ECGenParameterSpec(curveName);
		keyGen.initialize(ecSpec);
		//keyGen.initialize(keySize, randomGen);
		
		KeyPair keyPair = keyGen.generateKeyPair();
		
		return keyPair;
	}

	private static String setSignatureAlgorithm(Request req) {
		
		String signatureAlgorithm = null;
		
		if (req.getPkRequest().getSpec() != null) {
			
			if (req.getPkRequest().getSpec().getRsa() != null) {
				signatureAlgorithm = "SHA256WITHRSA";
				
			} else if(req.getPkRequest().getSpec().getEc() != null) {
				signatureAlgorithm = "SHA256WITHECDSA";
				
			}
			
		} else if (req.getPkRequest().getPublicKeyPem() != null) {
			
			if (req.getPkRequest().getPublicKeyPem() != null) {
				signatureAlgorithm = "SHA256WITHRSA";
				
			}
		}
		
		return signatureAlgorithm;
	}

	private static String toPem(Object obj) throws IOException {
		StringWriter sw = new StringWriter();
		JcaPEMWriter pemWrt = new JcaPEMWriter(sw);
		pemWrt.writeObject(obj);
		pemWrt.close();
		return sw.toString();
	}
	
}