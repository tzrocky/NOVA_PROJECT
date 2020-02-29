package fr.autoecole.nova.novaschool;

import java.net.URI;

import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class SpringBootJunit5ApiTest {
	
	@Autowired
	private TestRestTemplate restTemplate = new TestRestTemplate();
	
	@Value("${server.port}")
    private int serverPort=8082;


	 @Test
	 @DisplayName("/hello rest api test ")
	 void testMessage() {
		 
		 //String user = "Peter";
		 String idEleve = null;
		 idEleve=String.valueOf(7);
		 URI targetUrl= UriComponentsBuilder.fromUriString("/api/eleve/")                             
				    .path(idEleve)                               
				    .build()                                                
				    .encode()                                               
				    .toUri();
		 
		 System.out.println(targetUrl);
		 System.out.println(this.restTemplate);
	  String message = this.restTemplate.getForObject("http://localhost:" + serverPort + "/SpringBootCRUDApp" + targetUrl.toString(), String.class);
	  System.out.println(new JSONObject(message).toString());
	  StringBuilder builder = new StringBuilder();
	  builder.append("{\"id\":7,\"name\":\"TSANE\",\"prenom\":\"Jade\",\"adresse\":\"39 rue de la fosse rouge, 94370 Sucy-en-brie\",\"email\":\"tzrocky@yaho.fr\",\"age\":33,\"matricule\":\"M001\",\"profil\":{\"id\":2,\"intituleProfil\":\"Eleve\",\"niveau\":\"2\"}}\r\n"  
	  		+ "");
	  System.out.println(builder.toString());
	  JSONAssert.assertEquals(builder.toString(), new JSONObject(message).toString(), true);	 }

}