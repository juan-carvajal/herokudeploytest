package hello;

import java.io.File;
import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Prueba {
	

private class Cosa{
	private Map<String,Integer>mapita;
	private String[]array;
	
	public Cosa() {
		mapita=new HashMap<>();
		mapita.put("cosa1", 1);
		mapita.put("cosa2", 2);
		mapita.put("cosa3", 3);
		array=new String[] {"S1","S2","S3"};
	}
	
	public Map<String,Integer> getMapa(){
		return mapita;
	}
	
	public String[] getArray() {
		return array;
	}
}
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		Prueba p=new Prueba();
		ObjectMapper objectMapper = new ObjectMapper();
		Cosa c=p.new Cosa();
		objectMapper.writeValue(new File("C:\\Users\\garab\\OneDrive\\Desktop\\cosa.json"), c);
		
		// TODO Auto-generated method stub
		
	}
	
	

}

