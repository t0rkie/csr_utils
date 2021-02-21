package com.example.csrUtils.dto.request.publicKey.spec;

import com.example.csrUtils.dto.request.publicKey.spec.ec.EC;
import com.example.csrUtils.dto.request.publicKey.spec.rsa.RSA;

public class Spec {
	
	private RSA rsa;
	private EC ec;
	
	public RSA getRsa() {
		return rsa;
	}
	public void setRsa(RSA rsa) {
		this.rsa = rsa;
	}
	public EC getEc() {
		return ec;
	}
	public void setEc(EC ec) {
		this.ec = ec;
	}

}
