package org.webservice.td3.rest;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

public class TwitterClient {

	final static String API_KEY 		= "Tl20ETMXcTvWld9v0MhDJ2PdD";
	
	final static String API_SECRET 		= "PuSMZshFcpvcCogAnmJxMiYOJD8ly0xijD6Fd5IxAaoadqU6XW";
	
	final static String TOKEN_KEY 		= "724433312-eOaHQoYm3qaCONExXApkfOCWqrIuUjaFLaKMHXwb";
	
	final static String TOKEN_SECRET 	= "nQnzRAvdzxLFpRMxhxngebtv9jAlPP8kv1IyXwwi2pKPp";
	

	public TwitterClient() {
		super();
	}

	public static OAuthService TwitterOAuth() {

		// initialisation du service avec les API KEY
		OAuthService service = new ServiceBuilder()
				.provider(TwitterApi.SSL.class).apiKey(API_KEY)
				.apiSecret(API_SECRET).build();
			
		return service;
		
	}
	
	public String TwitterGETSignedRequest(String url){
		
		OAuthService service = this.TwitterOAuth();
		
		// utilisation des TOKEN
		Token requestToken = service.getRequestToken();
		Token accessToken = new Token(TOKEN_KEY,TOKEN_SECRET);
		
		// Envoyer la requete et la signé
		OAuthRequest request = new OAuthRequest(Verb.GET,url );
		
		service.signRequest(accessToken, request);

		// Récuperation de la reponse
		Response response = request.send();
		
		// Recuperation de la reponse sous forme de JSON
		return response.getBody();
		
	}
	
	public String TwitterPOSTSignedRequest(String url){
		
		OAuthService service = this.TwitterOAuth();
		
		// utilisation des TOKEN
		Token requestToken = service.getRequestToken();
		Token accessToken = new Token(TOKEN_KEY,TOKEN_SECRET);
		
		// Envoyer la requete et la signé
		OAuthRequest request = new OAuthRequest(Verb.POST,url );
		
		service.signRequest(accessToken, request);

		// Récuperation de la reponse
		Response response = request.send();
		
		// Recuperation de la reponse sous forme de JSON
		return response.getBody();
		
	}
	
	public static String TwitterPrettyJSON(String json_string) throws JsonParseException, JsonMappingException, IOException{
		
		// creation d'un mapper pour afficher le JSON correctement
		
		ObjectMapper mapper = new ObjectMapper();
		
		Object json = mapper.readValue(json_string, Object.class);

		String indented = mapper.defaultPrettyPrintingWriter().writeValueAsString(json);
		
		return indented;
	}

}
