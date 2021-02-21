package com.example.csrUtils.model;

import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.style.BCStrictStyle;
import org.bouncycastle.asn1.x500.style.BCStyle;

import com.example.csrUtils.dto.request.Request;
import com.example.csrUtils.dto.request.subject.Subject;

public class SubjectUtils {
	
	public List<Subject> createSbjHolder(X500Name subject) {
		List<Subject> sbjHolder = new ArrayList<>();
		
		if ( subject != null ) {
			for ( RDN s : subject.getRDNs() ) {
				Subject sbj = new Subject();
				
				String[] dns = new BCStrictStyle().oidToAttrNames(s.getFirst().getType());
				String dn = null;
				if (dns.length == 0) {
					dn = s.getFirst().getType().toString();
				} 
				for (String d : dns) {
					dn = d;
				}
				
				sbj.setDn(dn);
				sbj.setValue(s.getFirst().getValue().toString());
				sbjHolder.add(sbj);
			}
		}
		return sbjHolder;
	}
	
	public X500Name createSubject(Request request) {
		
		if (request.getSbjHolder().isEmpty()) {
			return null;
		}
		
		X500NameBuilder sbjBuilder = new X500NameBuilder(BCStyle.INSTANCE);
		
		for (Subject s : request.getSbjHolder()) {
			ASN1ObjectIdentifier oid = new BCStrictStyle().attrNameToOID(s.getDn());
			sbjBuilder.addRDN(oid, s.getValue());
			
			/*
			 * PrintableString
			 */
			//DERPrintableString dps = new DERPrintableString(s.getValue());
			//sbjBuilder.addRDN(oid, dps);
			
		}
		X500Name subject = sbjBuilder.build();
		return subject;
	}

}
