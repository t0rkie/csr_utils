package com.example.csrUtils.dto.response;

public class Response {

	private String subjectJson;
	private String extJson; 
	
	public Response(String subjectJson, String extJson) {
		this.subjectJson = subjectJson;
		this.extJson = extJson;
	}

	public String getSubjectJson() {
		return subjectJson;
	}

	public String getExtJson() {
		return extJson;
	}
}
