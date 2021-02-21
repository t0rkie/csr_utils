package com.example.csrUtils.dto.request.publicKey;

import com.example.csrUtils.dto.request.publicKey.publicKey.PublicKeyPem;
import com.example.csrUtils.dto.request.publicKey.spec.Spec;

public class PublicKeyRequest {
	
	private Spec spec;
	private PublicKeyPem publicKeyPem;
	
	public Spec getSpec() {
		return spec;
	}
	public void setSpec(Spec spec) {
		this.spec = spec;
	}
	public PublicKeyPem getPublicKeyPem() {
		return publicKeyPem;
	}
	public void setPublicKeyPem(PublicKeyPem publicKeyPem) {
		this.publicKeyPem = publicKeyPem;
	}

}
