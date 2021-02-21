package com.example.csrUtils.model;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.bidimap.DualHashBidiMap;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.ExtensionsGenerator;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.util.encoders.Hex;

import com.example.csrUtils.dto.request.Request;
import com.example.csrUtils.dto.request.extension.ExtensionRequest;
import com.example.csrUtils.dto.request.extension.otherExtension.OtherExtension;
import com.example.csrUtils.dto.request.extension.subjectAltName.GeneralNameRequest;
import com.example.csrUtils.dto.request.extension.subjectAltName.SubjectAltName;

public class ExtensionUtils {
	static HashMap<String, String> extLookUp = new HashMap<>();
	
	static 
	{	
		extLookUp.put("2.5.29.9", "subjectDirectoryAttributes");
		extLookUp.put("2.5.29.14", "subjectKeyIdentifier");
		extLookUp.put("2.5.29.15", "keyUsage");
		extLookUp.put("2.5.29.16", "privateKeyUsagePeriod");
		extLookUp.put("2.5.29.17", "subjectAlternativeName");
		extLookUp.put("2.5.29.18", "issuerAlternativeName");
		extLookUp.put("2.5.29.19", "basicConstraints");
		extLookUp.put("2.5.29.20", "cRLNumber");
		extLookUp.put("2.5.29.21", "reasonCode");
		extLookUp.put("2.5.29.23", "instructionCode");
		extLookUp.put("2.5.29.24", "invalidityDate");
		extLookUp.put("2.5.29.27", "deltaCRLIndicator");
		extLookUp.put("2.5.29.28", "issuingDistributionPoint");
		extLookUp.put("2.5.29.29", "certificateIssuer");
		extLookUp.put("2.5.29.30", "nameConstraints");
		extLookUp.put("2.5.29.31", "cRLDistributionPoints");
		extLookUp.put("2.5.29.32", "certificatePolicies");
		extLookUp.put("2.5.29.33", "policyMappings");
		extLookUp.put("2.5.29.35", "authorityKeyIdentifier");
		extLookUp.put("2.5.29.36", "policyConstraints");
		extLookUp.put("2.5.29.37", "extendedKeyUsage");
		extLookUp.put("2.5.29.46", "freshestCRL");
		extLookUp.put("2.5.29.54", "inhibitAnyPolicy");
		extLookUp.put("1.3.6.1.5.5.7.1.1", "authorityInfoAccess");
		extLookUp.put("1.3.6.1.5.5.7.1.11", "subjectInfoAccess");
		extLookUp.put("1.3.6.1.5.5.7.1.12", "logoType");
		extLookUp.put("1.3.6.1.5.5.7.1.2", "biometricInfo");
		extLookUp.put("1.3.6.1.5.5.7.1.3", "qCStatements");
		extLookUp.put("1.3.6.1.5.5.7.1.4", "auditIdentity");
		extLookUp.put("2.5.29.56", "noRevAvail");
		extLookUp.put("2.5.29.55", "targetInformation");
		extLookUp.put("2.5.29.60", "expiredCertsOnCRL");
				
		}
	
	static HashMap<Integer, String> sbjLookUp = new HashMap<Integer, String>();
	
	static 
	{
		sbjLookUp.put(0, "otherName");
		sbjLookUp.put(1, "rfc822Name");
		sbjLookUp.put(2, "dNSName");
		sbjLookUp.put(3, "x400Address");
		sbjLookUp.put(4, "directoryName");
		sbjLookUp.put(5, "ediPartyName");
		sbjLookUp.put(6, "uniformResourceIdentifier");
		sbjLookUp.put(7, "iPAddress");
		sbjLookUp.put(8, "registeredID");
		
	}
	
	/*
	 * need to check
	 */
	
	public ExtensionRequest createExtensionRequest(Extensions extensions) throws IOException {

		if (extensions == null) {
			return null;
		}
		
		ExtensionRequest extRequest = new ExtensionRequest();
		List<OtherExtension> otherHolder = new ArrayList<>();
		
		SubjectAltName sanAltName = new SubjectAltName();
		List<GeneralNameRequest> simpleSanHolder = new ArrayList<>();
		List<GeneralNameRequest> nonSimpleSanHolder = new ArrayList<>();
		
		Enumeration e = extensions.oids();
	
		while (e.hasMoreElements()) {
			ASN1ObjectIdentifier oid = (ASN1ObjectIdentifier) e.nextElement();
			
			if (oid.equals(Extension.subjectAlternativeName)) {
				
				GeneralNames san = GeneralNames.fromExtensions(extensions, Extension.subjectAlternativeName);
				GeneralName[] names = san.getNames();
				for (GeneralName n : names) {
					
					GeneralNameRequest gnRequest = new GeneralNameRequest();
					int tag = n.getTagNo();
					
					if (!(tag == GeneralName.otherName || tag == GeneralName.x400Address || tag == GeneralName.ediPartyName) ) {
					
						String value = "";
						
						switch (tag) {
						
						case GeneralName.iPAddress:
							
							byte[] bIp = DEROctetString.getInstance(n.getName()).getOctets();
							value = InetAddress.getByAddress(bIp).getHostAddress().toString();
							
							break;
							
						default:
							value = n.getName().toString();
							
							break;
						}
						
						gnRequest.setType(sbjLookUp.get(tag));
						gnRequest.setValue(value);
						
						simpleSanHolder.add(gnRequest);
						
					} else {
						/*
						 * otherName      [0]OtherName,
						 * tx400Address   [3]ORAddress,
						 * ediPartyName   [5]EDIPartyName,
						 */
					}
					sanAltName.setSimpleSanHolder(simpleSanHolder);
					sanAltName.setNonSimpleSanHolder(nonSimpleSanHolder);
				}
				
			} else {
				OtherExtension otherExtension = new OtherExtension();
				
				if (extLookUp.containsKey(oid.toString())) {
					String despName = extLookUp.get(oid.toString());
					otherExtension.setOid(despName);
				} else {
					otherExtension.setOid(oid.toString());
				}
				
				Extension value = extensions.getExtension(oid);
				String critical = String.valueOf(value.isCritical());
				try {
					byte[] bValue = value.getParsedValue().toASN1Primitive().getEncoded();
					String hexValue = new String(Hex.encode(bValue));
					
					otherExtension.setValue(hexValue);
					otherExtension.setCritical(critical);
					
				}catch (Throwable t) {
					//otherExtension.setValue("");
					t.printStackTrace();
				}
				
				otherHolder.add(otherExtension);
			}
			
			extRequest.setOtherExtHolder(otherHolder);
			extRequest.setSubjectAltName(sanAltName);
		}
		return extRequest;
	}

	public ExtensionsGenerator addOtherExtension(ExtensionsGenerator extGen, Request req) throws IOException {
		
		List<OtherExtension> otherExt = req.getExtRequest().getOtherExtHolder();
		for (OtherExtension e : otherExt) {
			
			BidiMap bidiMap = new DualHashBidiMap(extLookUp);
			
			if (bidiMap.containsValue(e.getOid())) {
				//from cert
				String strOid = (String) bidiMap.getKey(e.getOid());
				ASN1ObjectIdentifier oid = new ASN1ObjectIdentifier(strOid);
				
				String strCritical = e.getCritical();
				Boolean isCritical = Boolean.valueOf(strCritical).booleanValue();
				
				String hexValue = e.getValue();
				byte[] bValue = Hex.decode(hexValue);
				
				extGen.addExtension(oid, isCritical, bValue);
				
			} else {
				//new extension
				String newStrOid = e.getOid();
				ASN1ObjectIdentifier asnOid = new ASN1ObjectIdentifier(newStrOid);
				
				String strCritical = e.getCritical();
				Boolean isCritical = Boolean.valueOf(strCritical);
				
				String hexValue = e.getValue();
				byte[] bValue = Hex.decode(hexValue);
				
				extGen.addExtension(asnOid, isCritical, bValue);
			}
		}
        
		return extGen;
	}
	
	public ExtensionsGenerator addSan(ExtensionsGenerator extGen, Request req) throws IOException {
		
		SubjectAltName san = req.getExtRequest().getSubjectAltName();
		List<GeneralNameRequest> simpleSan = san.getSimpleSanHolder();
		List<GeneralNameRequest> nonSimpleSan = san.getNonSimpleSanHolder();
        
		int sumOfSan = simpleSan.toArray().length + nonSimpleSan.toArray().length;
		
		GeneralName[] names = new GeneralName[sumOfSan];
		BidiMap bidiMap = new DualHashBidiMap(sbjLookUp);
		
		if ( simpleSan.toArray().length > 0 ) {
			
	        for (int i = 0; i < simpleSan.toArray().length; i++) {
	        	
	        	int tag = (int) bidiMap.getKey(simpleSan.get(i).getType());
	        	String value = simpleSan.get(i).getValue(); 	
	        	
	        	switch(tag) {
	        	
	        	case GeneralName.directoryName:
	        		
	            	try {	
	                	names[i] = new GeneralName(tag, value);
	            	} catch(Throwable t) {
	            		t.printStackTrace();
	            	}
	            	
	        		break;
	        		
	        	case GeneralName.registeredID:
	        		
	        		if (value.isEmpty()) {
	        			//cannot instantiate
	        			names[i] = new GeneralName(tag, value);
	        			
	        		} else {
	        			ASN1ObjectIdentifier oid = new ASN1ObjectIdentifier(value);
	        			names[i] = new GeneralName(tag, oid);
	        		}
	        		
	        		break;
	        		
        		default:
        			names[i] = new GeneralName(tag, value);
        			
	        		break;
	        	}
	        }
			
		} else if ( nonSimpleSan.toArray().length > 0 ) {
			/*
	        for (int i = 0; i < nonSimpleSan.toArray().length; i++) {
	        	
	        	//OtherName on = new OtherName();
	        	
	        	int tag = nonSimpleSan.get(i).getTag();
	        	String value = nonSimpleSan.get(i).getValue();
	        	
	        	names[i] = new GeneralName(tag, value);
	        }
	        */
			
		}
 
        extGen.addExtension(Extension.subjectAlternativeName, false, new DERSequence(names));
        
        return extGen;
	}
	
}
