package com.example.test.subject;

import java.io.IOException;
import java.io.StringWriter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

import com.example.csrUtils.model.CsrUtils;

public class SubjectUtils {
	
	public static String certPem = 
			"-----BEGIN CERTIFICATE-----\n" +
			"MIIHzDCCBrSgAwIBAgIMXjA21tekMHKcrZ40MA0GCSqGSIb3DQEBCwUAMGIxCzAJ\n" +
			"BgNVBAYTAkJFMRkwFwYDVQQKExBHbG9iYWxTaWduIG52LXNhMTgwNgYDVQQDEy9H\n" +
			"bG9iYWxTaWduIEV4dGVuZGVkIFZhbGlkYXRpb24gQ0EgLSBTSEEyNTYgLSBHMzAe\n" +
			"Fw0xODAzMDEwNTExMDdaFw0yMDAzMDEwNTExMDdaMIHRMR0wGwYDVQQPDBRQcml2\n" +
			"YXRlIE9yZ2FuaXphdGlvbjEXMBUGA1UEBRMOMDExMC0wMS0wNDAxODExEzARBgsr\n" +
			"BgEEAYI3PAIBAxMCSlAxCzAJBgNVBAYTAkpQMQ4wDAYDVQQIEwVUb2t5bzEQMA4G\n" +
			"A1UEBxMHU2hpYnV5YTEZMBcGA1UECRMQMjYtMSBTYWt1cmFnYW9rYTEcMBoGA1UE\n" +
			"ChMTR01PIEdsb2JhbFNpZ24gSy5LLjEaMBgGA1UEAxMRanAuZ2xvYmFsc2lnbi5j\n" +
			"b20wggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDXsFoVAkW60YM03UUz\n" +
			"wjyW0wtXYLG0n/wbx74/Us/Ztl/SR+sRs+IG+OsBU/w2JkE1cnA0Lrr7x/wzfIma\n" +
			"fPYvpvYaNhsIkrK7eplOS2o7Nu1QCRxGzLeYcPpy58OIjdzXq4R9O2xV7tONIidt\n" +
			"8dYrJSq7K2uVKfYx7KNrrMko5dIIyNHVKblZad7PjLGOwkzP/NJ4RKIiX12HTQSl\n" +
			"0KgcnpHVi6gTfmeou45ZmeVuus75JF0wKU+bWy91gXcNGo+kN4Asw/NNOG3uvrIw\n" +
			"869Itk5yJdpubAEG2GJetx2IXo7YX8actXWjWc0ywAU3PmIQT7MgRiDE3df3hAoF\n" +
			"fyx9AgMBAAGjggQQMIIEDDAOBgNVHQ8BAf8EBAMCBaAwgZYGCCsGAQUFBwEBBIGJ\n" +
			"MIGGMEcGCCsGAQUFBzAChjtodHRwOi8vc2VjdXJlLmdsb2JhbHNpZ24uY29tL2Nh\n" +
			"Y2VydC9nc2V4dGVuZHZhbHNoYTJnM3IzLmNydDA7BggrBgEFBQcwAYYvaHR0cDov\n" +
			"L29jc3AyLmdsb2JhbHNpZ24uY29tL2dzZXh0ZW5kdmFsc2hhMmczcjMwVQYDVR0g\n" +
			"BE4wTDBBBgkrBgEEAaAyAQEwNDAyBggrBgEFBQcCARYmaHR0cHM6Ly93d3cuZ2xv\n" +
			"YmFsc2lnbi5jb20vcmVwb3NpdG9yeS8wBwYFZ4EMAQEwCQYDVR0TBAIwADBFBgNV\n" +
			"HR8EPjA8MDqgOKA2hjRodHRwOi8vY3JsLmdsb2JhbHNpZ24uY29tL2dzL2dzZXh0\n" +
			"ZW5kdmFsc2hhMmczcjMuY3JsMF0GA1UdEQRWMFSCEWpwLmdsb2JhbHNpZ24uY29t\n" +
			"ghVlLXNpZ24uZ2xvYmFsc2lnbi5jb22CEmVkaS5nbG9iYWxzaWduLmNvbYIUb2Nu\n" +
			"Z3MuZ2xvYmFsc2lnbi5jb20wHQYDVR0lBBYwFAYIKwYBBQUHAwEGCCsGAQUFBwMC\n" +
			"MB0GA1UdDgQWBBSl6pqy6p4HkQq6LoNNvAqe1xSFyzAfBgNVHSMEGDAWgBTds+dt\n" +
			"qC7oxU5uz3TmdTyUFc7oHTCCAfgGCisGAQQB1nkCBAIEggHoBIIB5AHiAHcA3esd\n" +
			"K3oNT6Ygi4GtgWhwfi6OnQHVXIiNPRHEzbbsvswAAAFh3/ifIgAABAMASDBGAiEA\n" +
			"5cQQh2eT/UxrP6mnXZ1/lwajlQtC09tNJiuSJam6dnQCIQCjDOInhWhCL+hvt/Dk\n" +
			"6ecGkvQ4go5T3DbAfQGyEpgReQB1AFYUBpov18Ls0/XhvUSyPsdGdrm8mRFcwO+U\n" +
			"mFXWidDdAAABYd/4nz8AAAQDAEYwRAIgcLTPBDL/SrTe7wF6qVUmN4syOB8e7BYf\n" +
			"WgZ68dY4kooCIAPt4Oj9UCxo9Ijf77T42eP9i+G6klek53+0wSbTNOoHAHcApLkJ\n" +
			"kLQYWBSHuxOizGdwCjw1mAT5G9+443fNDsgN3BAAAAFh3/iiLgAABAMASDBGAiEA\n" +
			"zJV1utSqow7IHaekpMvou6gWjfc9BrqAlHe7X8mXqBwCIQDH65Tl9ZXXuE4c3CYB\n" +
			"yHG33V55zN//IzLPjGHljRpQnAB3AO5Lvbd1zmC64UJpH6vhnmajD35fsHLYgwDE\n" +
			"e4l6qP3LAAABYd/4pTcAAAQDAEgwRgIhAIZV4NCxHu3oDvMz5AsbnTdl9x7vsBEg\n" +
			"z+f3EIePMLc9AiEAr92UauTCIj6SjpcXR90+gvV7eh9EDcTTOSG296uh/BwwDQYJ\n" +
			"KoZIhvcNAQELBQADggEBAGxH+jlIoLiWl5ttLhWaomFDvgwwEjm8euFAMBqCNvW4\n" +
			"P8ryl0h4FsnQotxzGAhdfDkhJYDZfJZLH5HLRnK8FSGSaOFIi+iH31fa+PIU1OLL\n" +
			"IKj303RUJ/iYh22kqcCpNKkIAyjJR+rLA9LdjYsk+rUErWTU0YBxeUJr2EwJ59hr\n" +
			"UdQyVxwYGQmsxeiKx2CQ7MqQFVnbS643shsIKqsKPkyy7DChjIUe7glMjff6uEtL\n" +
			"4X/8qmFtfgqOiDr2u9/jEfkFT192TDzk2I01ZtUu9WokeuZKAT3PeC/gzRQXuHcU\n" +
			"37rlkZUOdTgN1vOnwuf2SBHZtlYyZ1U103snZaT1778=\n" +
			"-----END CERTIFICATE-----\n";
	
	static String multiSun = "-----BEGIN CERTIFICATE-----\n"+
			"MIIHzDCCBrSgAwIBAgIMXjA21tekMHKcrZ40MA0GCSqGSIb3DQEBCwUAMGIxCzAJ\n"+
			"BgNVBAYTAkJFMRkwFwYDVQQKExBHbG9iYWxTaWduIG52LXNhMTgwNgYDVQQDEy9H\n"+
			"bG9iYWxTaWduIEV4dGVuZGVkIFZhbGlkYXRpb24gQ0EgLSBTSEEyNTYgLSBHMzAe\n"+
			"Fw0xODAzMDEwNTExMDdaFw0yMDAzMDEwNTExMDdaMIHRMR0wGwYDVQQPDBRQcml2\n"+
			"YXRlIE9yZ2FuaXphdGlvbjEXMBUGA1UEBRMOMDExMC0wMS0wNDAxODExEzARBgsr\n"+
			"BgEEAYI3PAIBAxMCSlAxCzAJBgNVBAYTAkpQMQ4wDAYDVQQIEwVUb2t5bzEQMA4G\n"+
			"A1UEBxMHU2hpYnV5YTEZMBcGA1UECRMQMjYtMSBTYWt1cmFnYW9rYTEcMBoGA1UE\n"+
			"ChMTR01PIEdsb2JhbFNpZ24gSy5LLjEaMBgGA1UEAxMRanAuZ2xvYmFsc2lnbi5j\n"+
			"b20wggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDXsFoVAkW60YM03UUz\n"+
			"wjyW0wtXYLG0n/wbx74/Us/Ztl/SR+sRs+IG+OsBU/w2JkE1cnA0Lrr7x/wzfIma\n"+
			"fPYvpvYaNhsIkrK7eplOS2o7Nu1QCRxGzLeYcPpy58OIjdzXq4R9O2xV7tONIidt\n"+
			"8dYrJSq7K2uVKfYx7KNrrMko5dIIyNHVKblZad7PjLGOwkzP/NJ4RKIiX12HTQSl\n"+
			"0KgcnpHVi6gTfmeou45ZmeVuus75JF0wKU+bWy91gXcNGo+kN4Asw/NNOG3uvrIw\n"+
			"869Itk5yJdpubAEG2GJetx2IXo7YX8actXWjWc0ywAU3PmIQT7MgRiDE3df3hAoF\n"+
			"fyx9AgMBAAGjggQQMIIEDDAOBgNVHQ8BAf8EBAMCBaAwgZYGCCsGAQUFBwEBBIGJ\n"+
			"MIGGMEcGCCsGAQUFBzAChjtodHRwOi8vc2VjdXJlLmdsb2JhbHNpZ24uY29tL2Nh\n"+
			"Y2VydC9nc2V4dGVuZHZhbHNoYTJnM3IzLmNydDA7BggrBgEFBQcwAYYvaHR0cDov\n"+
			"L29jc3AyLmdsb2JhbHNpZ24uY29tL2dzZXh0ZW5kdmFsc2hhMmczcjMwVQYDVR0g\n"+
			"BE4wTDBBBgkrBgEEAaAyAQEwNDAyBggrBgEFBQcCARYmaHR0cHM6Ly93d3cuZ2xv\n"+
			"YmFsc2lnbi5jb20vcmVwb3NpdG9yeS8wBwYFZ4EMAQEwCQYDVR0TBAIwADBFBgNV\n"+
			"HR8EPjA8MDqgOKA2hjRodHRwOi8vY3JsLmdsb2JhbHNpZ24uY29tL2dzL2dzZXh0\n"+
			"ZW5kdmFsc2hhMmczcjMuY3JsMF0GA1UdEQRWMFSCEWpwLmdsb2JhbHNpZ24uY29t\n"+
			"ghVlLXNpZ24uZ2xvYmFsc2lnbi5jb22CEmVkaS5nbG9iYWxzaWduLmNvbYIUb2Nu\n"+
			"Z3MuZ2xvYmFsc2lnbi5jb20wHQYDVR0lBBYwFAYIKwYBBQUHAwEGCCsGAQUFBwMC\n"+
			"MB0GA1UdDgQWBBSl6pqy6p4HkQq6LoNNvAqe1xSFyzAfBgNVHSMEGDAWgBTds+dt\n"+
			"qC7oxU5uz3TmdTyUFc7oHTCCAfgGCisGAQQB1nkCBAIEggHoBIIB5AHiAHcA3esd\n"+
			"K3oNT6Ygi4GtgWhwfi6OnQHVXIiNPRHEzbbsvswAAAFh3/ifIgAABAMASDBGAiEA\n"+
			"5cQQh2eT/UxrP6mnXZ1/lwajlQtC09tNJiuSJam6dnQCIQCjDOInhWhCL+hvt/Dk\n"+
			"6ecGkvQ4go5T3DbAfQGyEpgReQB1AFYUBpov18Ls0/XhvUSyPsdGdrm8mRFcwO+U\n"+
			"mFXWidDdAAABYd/4nz8AAAQDAEYwRAIgcLTPBDL/SrTe7wF6qVUmN4syOB8e7BYf\n"+
			"WgZ68dY4kooCIAPt4Oj9UCxo9Ijf77T42eP9i+G6klek53+0wSbTNOoHAHcApLkJ\n"+
			"kLQYWBSHuxOizGdwCjw1mAT5G9+443fNDsgN3BAAAAFh3/iiLgAABAMASDBGAiEA\n"+
			"zJV1utSqow7IHaekpMvou6gWjfc9BrqAlHe7X8mXqBwCIQDH65Tl9ZXXuE4c3CYB\n"+
			"yHG33V55zN//IzLPjGHljRpQnAB3AO5Lvbd1zmC64UJpH6vhnmajD35fsHLYgwDE\n"+
			"e4l6qP3LAAABYd/4pTcAAAQDAEgwRgIhAIZV4NCxHu3oDvMz5AsbnTdl9x7vsBEg\n"+
			"z+f3EIePMLc9AiEAr92UauTCIj6SjpcXR90+gvV7eh9EDcTTOSG296uh/BwwDQYJ\n"+
			"KoZIhvcNAQELBQADggEBAGxH+jlIoLiWl5ttLhWaomFDvgwwEjm8euFAMBqCNvW4\n"+
			"P8ryl0h4FsnQotxzGAhdfDkhJYDZfJZLH5HLRnK8FSGSaOFIi+iH31fa+PIU1OLL\n"+
			"IKj303RUJ/iYh22kqcCpNKkIAyjJR+rLA9LdjYsk+rUErWTU0YBxeUJr2EwJ59hr\n"+
			"UdQyVxwYGQmsxeiKx2CQ7MqQFVnbS643shsIKqsKPkyy7DChjIUe7glMjff6uEtL\n"+
			"4X/8qmFtfgqOiDr2u9/jEfkFT192TDzk2I01ZtUu9WokeuZKAT3PeC/gzRQXuHcU\n"+
			"37rlkZUOdTgN1vOnwuf2SBHZtlYyZ1U103snZaT1778=\n"+
			"-----END CERTIFICATE-----\n";
	
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, OperatorCreationException {
	
		X509CertificateHolder certHolder = CsrUtils.parseCertPem(multiSun);
		
		/*
		    public static final int otherName                     = 0;
		    public static final int rfc822Name                    = 1;
		    public static final int dNSName                       = 2;
		    public static final int x400Address                   = 3;
		    public static final int directoryName                 = 4;
		    public static final int ediPartyName                  = 5;
		    public static final int uniformResourceIdentifier     = 6;
		    public static final int iPAddress                     = 7;
		    public static final int registeredID                  = 8;
		    
		       * For x400Address, otherName and ediPartyName there is no common string
		 */
		
        ASN1Encodable[] asn = new ASN1Encodable[] {
        		//new GeneralName(GeneralName.otherName, ""), // no common string: sequence
        		new GeneralName(GeneralName.rfc822Name, "rfc822name.com"),
        		new GeneralName(GeneralName.rfc822Name, "rfc822name2.com"),
        		
        		new GeneralName(GeneralName.dNSName, "test.com"),
        		new GeneralName(GeneralName.dNSName, "test2.com"),
        		//new GeneralName(GeneralName.x400Address, ""), // no common string
        		new GeneralName(GeneralName.directoryName, certHolder.getSubject()),
        		new GeneralName(GeneralName.directoryName, certHolder.getSubject()),//  new X500Name()
        		//new GeneralName(GeneralName.ediPartyName, ""), // no common string: sequence
        		new GeneralName(GeneralName.uniformResourceIdentifier, "uniResourceID.com"),
        		new GeneralName(GeneralName.uniformResourceIdentifier, "uniResourceID2.com"),
        		
                new GeneralName(GeneralName.iPAddress, "1.1.1.1"),
                new GeneralName(GeneralName.iPAddress, "1.1.1.2"),
                
                new GeneralName(GeneralName.iPAddress, "ABCD:EF01:2345:6789:ABCD:EF01:2345:6781"),
                new GeneralName(GeneralName.iPAddress, "ABCD:EF01:2345:6789:ABCD:EF01:2345:6782"),
                
                new GeneralName(GeneralName.registeredID, Extension.subjectAlternativeName), // OID
                new GeneralName(GeneralName.registeredID, Extension.subjectAlternativeName)
               
        };
        X500Name sb = certHolder.getSubject();
        System.out.println(sb);
        
        String directoryName = "dn=test.com";
        X500Name n = new X500Name(directoryName);
        
   
        X509v3CertificateBuilder certBuilder = new X509v3CertificateBuilder(
        		certHolder.getIssuer(),
        		certHolder.getSerialNumber(),
        		certHolder.getNotBefore(),
        		certHolder.getNotAfter(),
        		certHolder.getSubject(),

        		certHolder.getSubjectPublicKeyInfo()
        		);
    
		KeyPair keyPairForSign = generateKeyPair();
		String certPem = getCertPem(certBuilder, keyPairForSign);
		System.out.println(certPem);
		
	}
	
	private static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(2048);
		KeyPair keyPair = keyGen.generateKeyPair();
		return keyPair;
	}
	
	private static String getCertPem(X509v3CertificateBuilder certBuilder, KeyPair keyPairForSign) throws OperatorCreationException, IOException {
        JcaContentSignerBuilder csBuilder = new JcaContentSignerBuilder("SHA1withRSA");
        ContentSigner signer = csBuilder.build(keyPairForSign.getPrivate());
        X509CertificateHolder cert = certBuilder.build(signer);
        return toPem(cert);
	}
	
	private static String toPem(Object obj) throws IOException {
		StringWriter sw = new StringWriter();
		JcaPEMWriter pemWrt = new JcaPEMWriter(sw);
		pemWrt.writeObject(obj);
		pemWrt.close();
		return sw.toString();
	}

}