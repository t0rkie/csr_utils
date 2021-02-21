package com.example.test.readCsr;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.pkcs.Attribute;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;

public class TestCsrUtils {
	
    static String csrPEM = "-----BEGIN CERTIFICATE REQUEST-----\n"+
    		"MIIHRDCCBiwCAQAwggELMR0wGwYDVQQPDBRQcml2YXRlIE9yZ2FuaXphdGlvbjEP\n"+
    		"MA0GA1UEBRMGNTc4NjExMRMwEQYLKwYBBAGCNzwCAQMMAlVTMR4wHAYLKwYBBAGC\n"+
    		"NzwCAQIMDU5ldyBIYW1wc2hpcmUxCzAJBgNVBAYTAlVTMRYwFAYDVQQIDA1OZXcg\n"+
    		"SGFtcHNoaXJlMRMwEQYDVQQHDApQb3J0c21vdXRoMSAwHgYDVQQJDBdUd28gSW50\n"+
    		"ZXJuYXRpb25hbCBEcml2ZTEdMBsGA1UECgwUR01PIEdsb2JhbFNpZ24sIEluYy4x\n"+
    		"KTAnBgNVBAMMIGludHJhbmV0LmludGVybmFsLmdsb2JhbHNpZ24uY29tMIIBIjAN\n"+
    		"BgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtqBrFOLB/0JxlG6DhnO2MQBr84/x\n"+
    		"7KtTx4VxnFY0ObH3e5TzPUnq59mGQgIRtLx8898k2hqIuLnG1glNK5D8CUu7Z7sZ\n"+
    		"lMpjjppNIkmlibd7wyIRJKVKgAeIRlH0MqvzDIRHu/2VBMo5alXh/mv8JDeaphlc\n"+
    		"MjKmq93tEfdAHmdKAn4p5rpy6asnEvHOEJxcu6QwTPYG578bWnlUkeVv/3KWcAOm\n"+
    		"1F8iU4/98EVgHJy5qe4Q2ZZh65aV+n5RSwvsLnFc5euQ0Frq/DtXNXjTgOtZ3PGv\n"+
    		"m1OBcHE3qveN13yM/nuyvO9PtzQSzrmml/fZ2n28a1HBGml/4VVC2AU1JwIDAQAB\n"+
    		"oIID8DCCA+wGCSqGSIb3DQEJDjGCA90wggPZMA4GA1UdDwEB/wQEAwIFoDCBlgYI\n"+
    		"KwYBBQUHAQEEgYkwgYYwRwYIKwYBBQUHMAKGO2h0dHA6Ly9zZWN1cmUuZ2xvYmFs\n"+
    		"c2lnbi5jb20vY2FjZXJ0L2dzZXh0ZW5kdmFsc2hhMmczcjMuY3J0MDsGCCsGAQUF\n"+
    		"BzABhi9odHRwOi8vb2NzcDIuZ2xvYmFsc2lnbi5jb20vZ3NleHRlbmR2YWxzaGEy\n"+
    		"ZzNyMzBVBgNVHSAETjBMMEEGCSsGAQQBoDIBATA0MDIGCCsGAQUFBwIBFiZodHRw\n"+
    		"czovL3d3dy5nbG9iYWxzaWduLmNvbS9yZXBvc2l0b3J5LzAHBgVngQwBATAJBgNV\n"+
    		"HRMEAjAAMEUGA1UdHwQ+MDwwOqA4oDaGNGh0dHA6Ly9jcmwuZ2xvYmFsc2lnbi5j\n"+
    		"b20vZ3MvZ3NleHRlbmR2YWxzaGEyZzNyMy5jcmwwHQYDVR0lBBYwFAYIKwYBBQUH\n"+
    		"AwEGCCsGAQUFBwMCMB0GA1UdDgQWBBQLZ1fT48t7akQvuhjUCOGndztozTAfBgNV\n"+
    		"HSMEGDAWgBTds+dtqC7oxU5uz3TmdTyUFc7oHTCCAfcGCisGAQQB1nkCBAIEggHn\n"+
    		"BIIB4wHhAHcApLkJkLQYWBSHuxOizGdwCjw1mAT5G9+443fNDsgN3BAAAAFh5oP5\n"+
    		"7AAABAMASDBGAiEAnkdU+CfitzSklfNgXeg1bF7200IEO8b9fTA3QghILBsCIQCP\n"+
    		"wWkGMwewb/CtYW0vaevD3i4b7vvbmvl3jXJRoTr20QB2AFYUBpov18Ls0/XhvUSy\n"+
    		"PsdGdrm8mRFcwO+UmFXWidDdAAABYeaD+pkAAAQDAEcwRQIhAJQi567Kn79tlfYv\n"+
    		"dki7JI9yFckY9Qt8M2tbMIqjm3kAAiA3a6zOl8f601mQL6SMbtm+t/C/zKXUvMm1\n"+
    		"gurgzHxGhAB2AN3rHSt6DU+mIIuBrYFocH4ujp0B1VyIjT0RxM227L7MAAABYeaD\n"+
    		"+5YAAAQDAEcwRQIhAKGD3QthjHVrwrJw0L+No+jNHuitZeW9S2UwdYjGw65JAiBG\n"+
    		"E/mFKyNydkXlvgJxUFygbujcKX1YvB8ooinIQN3VowB2AO5Lvbd1zmC64UJpH6vh\n"+
    		"nmajD35fsHLYgwDEe4l6qP3LAAABYeaD/O4AAAQDAEcwRQIhAJgNHVGGOw6yr8Bl\n"+
    		"LdSqt4aCDHEvwowoPdtO1gmEo/HQAiAqdiTdscm+heA/+YMlc+jMrUWzj5h4AQL2\n"+
    		"TwlOuWhQADArBgNVHREEJDAigiBpbnRyYW5ldC5pbnRlcm5hbC5nbG9iYWxzaWdu\n"+
    		"LmNvbTANBgkqhkiG9w0BAQsFAAOCAQEAlJP4cmp9BF8rd04U91d6j1VcrElWhjFv\n"+
    		"pXLDT5C+id+gs7IrFuJjFubrs5vke7qlNZWK+0mnU7N3V+5RJ7hnFJL5Ks1hjVc5\n"+
    		"DGAjEENOdKRlN0am0XQbg4Ce4T/3/qJDha7PVZ8WHgmMlwflReti8a0Effbmrv/p\n"+
    		"xvk/R08JEosE3NS7aW2FtVfZ46ZLei+9xurQ//q4Yb2gra7iD+xqEA0XZn1LNwrQ\n"+
    		"NXkDC4W0PskK9wTFNenMeneLS7IrfFmfa+k6SeNroXnK5XGpC5Avs0HfZNpIC1G3\n"+
    		"MSIdyx64ohnK7mwEZbMzypTE6OmeN0BnTTrokJrMNA7XS+Mk3Z3MLQ==\n"+
    		"-----END CERTIFICATE REQUEST-----";
    
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException, OperatorCreationException {
		
		PKCS10CertificationRequest csrHolder = parseCsrPem(csrPEM);
		
		Attribute[] extensionRequests = csrHolder.getAttributes(PKCSObjectIdentifiers.pkcs_9_at_extensionRequest);
		
		for (Attribute extensionRequest:extensionRequests) {			
			
			ASN1Set attributeSet = extensionRequest.getAttrValues();
			
			if (attributeSet != null) {
				
				ASN1Encodable extension = attributeSet.getObjectAt(0);
				
				if (extension instanceof Extensions) {
					
					Extensions extensions = (Extensions) extension;
					
				} else if (extension instanceof DERSequence) {
					
					Extensions extensions = Extensions.getInstance(extension);
					
					ASN1ObjectIdentifier[] oids = extensions.getExtensionOIDs();
					
					for (ASN1ObjectIdentifier oid : oids ) {
						
					}
				
				}
			}
		}
	}
	

	public static PKCS10CertificationRequest parseCsrPem(String pem) throws IOException {
		
		PKCS10CertificationRequest csr = new PKCS10CertificationRequest(getContentFromPem(pem));
		
		return csr;
	}
	
    private static byte[] getContentFromPem(String pem) throws IOException {
    	
    	Reader reader = new StringReader(pem);	
		PemReader pemReader = new PemReader(reader);
		PemObject pemObject = pemReader.readPemObject();		
		pemReader.close();
		return pemObject.getContent();

    }
    
	
    private static PKCS10CertificationRequest convertPemToPKCS10CertificationRequest(String pem) throws IOException {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        PKCS10CertificationRequest csr = null;
        ByteArrayInputStream pemStream = null;
        try {
            pemStream = new ByteArrayInputStream(pem.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
         
        }

        Reader pemReader = new BufferedReader(new InputStreamReader(pemStream));
        PEMParser pemParser = new PEMParser(pemReader);

        try {
            Object parsedObj = pemParser.readObject();

            if (parsedObj instanceof PKCS10CertificationRequest) {
                csr = (PKCS10CertificationRequest) parsedObj;

            }
        } catch (IOException ex) {
            
        }
        pemParser.close();

        return csr;
    }

}
