package com.example.csrUtils.dto.request.extension;

import java.util.List;

import com.example.csrUtils.dto.request.extension.otherExtension.OtherExtension;
import com.example.csrUtils.dto.request.extension.subjectAltName.SubjectAltName;

public class ExtensionRequest {
	
	private List<OtherExtension> otherExtHolder;
	private SubjectAltName subjectAltName;
	
	public void setOtherExtHolder(List<OtherExtension> otherExtHolder) {
		this.otherExtHolder = otherExtHolder;
	}
	
	public void setSubjectAltName(SubjectAltName subjectAltName) {
		this.subjectAltName = subjectAltName;
	}
	
	public List<OtherExtension> getOtherExtHolder() {
		return otherExtHolder;
	}
	
	public SubjectAltName getSubjectAltName() {
		return subjectAltName;
	}
}
