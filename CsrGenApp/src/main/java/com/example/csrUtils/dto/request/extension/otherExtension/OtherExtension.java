package com.example.csrUtils.dto.request.extension.otherExtension;

public class OtherExtension {
	private String oid;
	private String critical;
	private String value;
	
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getCritical() {
		return critical;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getOid() {
		return oid;
	}
	public void setCritical(String critical) {
		this.critical = critical;
	}
	public String getValue() {
		return value;
	}
	
}
