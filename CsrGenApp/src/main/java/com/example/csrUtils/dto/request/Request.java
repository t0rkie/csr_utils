package com.example.csrUtils.dto.request;

import java.util.List;

import com.example.csrUtils.dto.request.extension.ExtensionRequest;
import com.example.csrUtils.dto.request.publicKey.PublicKeyRequest;
import com.example.csrUtils.dto.request.subject.Subject;

public class Request {
	
	private List<Subject> sbjHolder;
	private ExtensionRequest extRequest;
	private PublicKeyRequest pkRequest;

	public PublicKeyRequest getPkRequest() {
		return pkRequest;
	}
	public void setPkRequest(PublicKeyRequest pkRequest) {
		this.pkRequest = pkRequest;
	}
	public void setSbjHolder(List<Subject> sbjHolder) { 
		this.sbjHolder = sbjHolder;	
	}
	public void setExtRequest(ExtensionRequest extRequest) { 
		this.extRequest = extRequest;
	}
	
	public List<Subject> getSbjHolder() {
		return sbjHolder;
	}
	public ExtensionRequest getExtRequest() {
		return extRequest; 
	}

}
