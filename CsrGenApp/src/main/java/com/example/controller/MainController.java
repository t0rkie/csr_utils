package com.example.controller;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;

import org.bouncycastle.operator.OperatorCreationException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.example.csrUtils.dto.PemHolder;
import com.example.csrUtils.dto.response.Response;
import com.example.csrUtils.model.CsrUtils;

@RestController
public class MainController {
	
	@RequestMapping("/readPem")
	public Response readPem ( @RequestParam(value="pem") String pem) throws IOException {
		CsrUtils csrUtils = new CsrUtils();
		Response response = csrUtils.readPem(pem);
		
		return response;

	}
	
	@RequestMapping("/generateCsr")
	public PemHolder GenerateCsr( @RequestParam(value="request") String request) throws JsonParseException, JsonMappingException, IOException, NoSuchAlgorithmException, OperatorCreationException, NoSuchProviderException, InvalidAlgorithmParameterException, InvalidKeySpecException {
		CsrUtils csrUtils = new CsrUtils();
		String pem = csrUtils.generatePem(request);
		PemHolder pemHolder = new PemHolder(pem);
		
		return pemHolder;
	}
	
}
