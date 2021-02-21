package com.example.csrUtils.dto.request.extension.subjectAltName;

import java.util.List;
import com.example.csrUtils.dto.request.extension.subjectAltName.GeneralNameRequest;

public class SubjectAltName {

	private List<GeneralNameRequest> simpleSanHolder;
	private List<GeneralNameRequest> nonSimpleSanHolder;
	
	public List<GeneralNameRequest> getSimpleSanHolder() {
		return simpleSanHolder;
	}
	
	public List<GeneralNameRequest> getNonSimpleSanHolder() {
		return nonSimpleSanHolder;
	}

	public void setSimpleSanHolder(List<GeneralNameRequest> simpleSanHolder) {
		this.simpleSanHolder = simpleSanHolder;
	}
	
	public void setNonSimpleSanHolder(List<GeneralNameRequest> nonSimpleSanHolder) {
		this.nonSimpleSanHolder = nonSimpleSanHolder;
	}

}
