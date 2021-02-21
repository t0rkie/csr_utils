package com.example.csrUtils.model;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.pkcs.Attribute;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;

public class CertUtils {
	public static void main(String[] args) throws IOException {
		
		String csrPem = 
				"-----BEGIN CERTIFICATE REQUEST-----\n"+
				"MIICajCCAVICAQAwCzEJMAcGA1UECgwAMIIBIDANBgkqhkiG9w0BAQEFAAOCAQ0A\n"+
				"MIIBCAKCAQEAuXp76wv8OHrd5li4QT0AliLcQ739IjRhUOlBK8zOTCo9ZDg1WVVf\n"+
				"00AGQ1Ffs28mpwxTGCfAFtCZAvRr905zl+RgxlkEFHHRtOKhZhrF9SIRKxfQ3zf/\n"+
				"C0f2XWwpTcP0dY5IdFZGSeyxuC3ebOzC+K+3vz20Ahr3yNgnKtVn0wGQbvbsLEhq\n"+
				"lEjs9UUsQIqtPC99PrwpoOPdmsExJf3CPhepi1oIBxt3p2SREdMKccZETK6YRKzG\n"+
				"dL3ulpF8EQe/PkiEeqir82QeNULGn92WgRlrag5cIUg3sTImth7Yn71g3bPHsFZ7\n"+
				"Nu1hLOits0ew45boUlyP3GXPizpTcvdwPwIBI6AcMBoGCSqGSIb3DQEJDjENMAsw\n"+
				"CQYDVR0RBAIwADANBgkqhkiG9w0BAQsFAAOCAQEAow9kcBr83fPLdRRCZpzHMeZq\n"+
				"cquXkiEWUybF1YYKPndr5x9OFdbZaqLXQB4P4vcZLI3GZ2Z6ITrMtFdGpcV1FDw+\n"+
				"xZxCBrKE5PhUJpHjR/yh7lgVbIQ+2B660iDyc/tKzI11H6cE9nc7Exg2g8+SJclY\n"+
				"aa0DuSpF2feshiTjZdNvPbHEpAeKg7lxNsn6vb4R+tSVK5CQIHCq76CwB+3vjS9e\n"+
				"/UxlofkGUYldo/JT4cCW+okayoIupzEh0XNw8miT3GWRDlz0H18963vZO/Q+E0P1\n"+
				"njmh18M7dCEOW+ttxRQyBWbYeAF7lt1xTt0vTdB2yGEr2asPZYg1HziM+9FN9Q==\n"+
				"-----END CERTIFICATE REQUEST-----\n";
		
		String csrWithECC = 
				"-----BEGIN CERTIFICATE REQUEST-----\n"+
				"MIHAMHkCAQAwCzEJMAcGA1UECgwAMEkwEwYHKoZIzj0CAQYIKoZIzj0DAQEDMgAE\n"+
				"RJvHOnYypkWo+BYq0KDOjr93hQ3S2xsEgYAIk2h7CSUeFzEKAa8prFs8P4oL7GxI\n"+
				"oBwwGgYJKoZIhvcNAQkOMQ0wCzAJBgNVHREEAjAAMAoGCCqGSM49BAMCAzcAMDQC\n"+
				"GHIZIYONnaGSkii8D8Rgb/TgTL0dRQGk9AIYagQJWPdUcYLMv/TA6SW228BTGEIV\n"+
				"ohNE\n"+
				"-----END CERTIFICATE REQUEST-----\n";
				
	
		generateCertFromCSR(csrWithECC);
		
	}

	private static String generateCertFromCSR(String csrPem) throws IOException {
		
		PKCS10CertificationRequest csrHolder = parseCsrPem(csrPem);
		
		X500Name sbj = csrHolder.getSubject();
		Extensions extensions = createExtensionsFromCsr(csrHolder);
		
		
		//JcaX509v3CertificateBuilder  certBuilder = new JcaX509v3CertificateBuilder();
	
		//X509CertificateHolder = new X509CertificateHolder(x509Certificate);
		
		return null;
	}
	
	private static Extensions createExtensionsFromCsr(PKCS10CertificationRequest csrHolder) {
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

}


