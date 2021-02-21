package com.example.test.json;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		
		String json = 
				"{\"TEST\":\"TEST\", \"id\" : \"1\", \"group\" : [{\"name\" : \"tom\"}], \"habit\" : {\"morning\" : {\"bb\" : [{\"habit\" : \"test\" }]}, \"night\" : \"run\"}}";
		System.out.println(json);
		
		String reqJson = "{\"sbjHolder\":[],\"extRequest\":{\"otherExtHolder\":[],\"sanHolder\":{\"simpleSanHolder\":[],\"nonSimpleSanHolder\":[]}}}";
		
		ObjectMapper mapper = new ObjectMapper();
		Request req = mapper.readValue(reqJson, Request.class);
		
		
	}
	
	public static class Request {
		List<String> sbjHolder;
		ExtensionRequest extRequest;
		public List<String> getSbjHolder() {
			return sbjHolder;
		}
		public void setSbjHolder(List<String> sbjHolder) {
			this.sbjHolder = sbjHolder;
		}
		public ExtensionRequest getExtRequest() {
			return extRequest;
		}
		public void setExtRequest(ExtensionRequest extRequest) {
			this.extRequest = extRequest;
		}
		
	}
	
	public static class ExtensionRequest {
		List<OtherExtension> otherExtHolder;
		SubjectAltName sanHolder;
		
		public void setOtherExt(List<OtherExtension> otherExtHolder) {
			this.otherExtHolder = otherExtHolder;
		}
		public void setSanHolder(SubjectAltName sanHolder) {
			this.sanHolder = sanHolder;
		}
		
		public List<OtherExtension> getOtherExtHolder () {
			return otherExtHolder;
		}
		
		public SubjectAltName getSanHolder() {
			return sanHolder;
		}
	}
	
	public static class OtherExtension {
		private String oid;
		private String value;
		
		public void setOid(String oid) {
			this.oid = oid;
		}
		public void setValue(String value) {
			this.value = value;
		}
		
		public String getOid() {
			return oid;
		}
		public String getValue() {
			return value;
		}
	}
	
	public static class SubjectAltName {
		List<String> simpleSanHolder;
		List<String> nonSimpleSanHolder;
	}

	public static class Folder {
		private String test;
		private int id;
		private List<Name> group;
		private Habit habit;
		
		public void setTest(String test) {
			this.test = test;
		}
		public void setId(int id) {
			this.id = id;
		}
		public void setName(List<Name> group) {
			this.group = group;
		}
		public void setHabit(Habit habit) {
			this.habit = habit;
		}
		
		public String getTest() {
			return test;
		}
		public int getId() {
			return id;
		}
		public List<Name> getGroup() {
			return group;
		}
		public Habit getHabit() {
			return habit;
		}
	}
	
	public static class Habit {
		private String test;
		private Morning morning;
		private String night;
		
		public void setTest(String test) {
			this.test = test;
		}
		public void setMorning(Morning morning) {
			this.morning = morning;
		}
		public void setNight(String night) {
			this.night = night;
		}
		
		public String getTest() {
			return test;
		}
		
		public Morning getMorning() {
			return morning;
		}
		public String getNight() {
			return night;
		}
	}
	
	public static class Morning {
		private List<BB> bb;
		
		public void setBb(List<BB> bb) {
			this.bb = bb;
		}

		public List<BB> getBB() {
			return bb;
		}

	}
	
	public static class BB {
		private String habit;
		public void setHabit(String habit) {
			this.habit = habit;
		}
		public String getHabit() {
			return habit;
		}
	}
	
	public static class Name {
		private String name;
		
		public void SetName(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
		
	}
	
}
