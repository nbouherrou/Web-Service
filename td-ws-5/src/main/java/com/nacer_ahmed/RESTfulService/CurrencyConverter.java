package com.nacer_ahmed.RESTfulService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import com.nacer_ahmed.model.Currency;
import com.rest.DB.DBClass;
import com.rest.util.ToJSON;

/**
 * Version du service REST 
 */
@Path("currencyConverter")
public class CurrencyConverter {

	/**
	 * Version du service REST 
	 */
	private String version;

	/**
	 * Tableau des currencies 
	 */
	private static List<Currency> currencies = new ArrayList<Currency>();

	/**
	 * Constructeur de la classe.
	 * Initialisation de la liste avec les currencies (EURO, YEN, DOLLAR) si elle est vide
	 */
	public CurrencyConverter() {

		super();
		
		this.version = "1.0";

		if(currencies.isEmpty()){
			
			CurrencyConverter.initializeCurrencies();
			
		}
		
	}

	/**
	 * Constructeur de la classe.
	 * Initialisation de la liste avec les currencies (EURO, YEN, DOLLAR) si elle est vide
	 */
	private static void initializeCurrencies() {

		currencies.add(new Currency("USA", "Dollar", 1800, 1));

		currencies.add(new Currency("EU", "Euro", 2000, 2));

		currencies.add(new Currency("Japan", "Yen", 1945, 3));
	}


	/**
	 * Retourne la version actuelle du web-service
	 * URL : 
	 * http://localhost:8080/td4-ws/v1/converterApp/currencyConverter/version/
	 * @return String  : version du web serivce REST
	 */
	@GET
	@Path("version")
	public String version() {
		return "The current version is " + this.version;

	}

	
	/**
	 * Retourne la currency selon son id (dans notre cas, entre 1-3).
	 * 
	 * URL : 
	 * http://localhost:8080/td4-ws/v1/converterApp/currencyConverter/currency/:id
	 * 
	 * @param  Integer id 	: id de la currency
	 * @return String  		: version du web serivce REST
	 */
	@GET
	@Path("currency/{identifier: [0-9]*}")
	public String currency(@PathParam("identifier") Integer id) {

		String result = null;

		for (Currency c : currencies) {

			if (c.getId() == id) {

				result = c.getName();

			}

		}

		if (result == null) {

			result = "No currency found with id = " + id;

		}

		return result;

	}

	
	/**
	 * Convertie un montant entre deux devises (EURO/YEN/DOLLAR) 
	 * 
	 * URL : 
	 * 
	 * Conversion de 300 Euro 'E' en Dollar 'D' 
	 * http://localhost:8080/td4-ws/v1/converterApp/currencyConverter/converter/E/D/300
	 * 
	 * Conversion de 4500 Yens 'Y' en Euros 'E' 
	 * http://localhost:8080/td4-ws/v1/converterApp/currencyConverter/converter/Y/E/4500
	 * 
	 * @param  String currency_source 		: identifiant (E/Y/D) de la currency source
	 * @param  String currency_destination 	: identifiant (E/Y/D) de la currency de destination
	 * @param  Double amount 				: montant a convertir
	 * @return String  						: resultat de la conversion
	 */
	@GET
	@Path("converter/{currency_source}/{currency_destination}/{amount}")
	public String converter(@PathParam("currency_source") String source,
			@PathParam("currency_destination") String destination,
			@PathParam("amount") double amount) {

		Double amountConverted = 0d;

		Double device;

		String dest_long = null;

		if (source.equals("D") && destination.equals("Y")) {

			device = 118.481;

			dest_long = "Yens";

			amountConverted = amount * device;

		}

		if (source.equals("D") && destination.equals("E")) {

			device = 0.802032;

			dest_long = "Euros";

			amountConverted = amount * device;

		}

		if (source.equals("E") && destination.equals("D")) {

			device = 1.24683;

			dest_long = "Dollars";

			amountConverted = amount * device;

		}

		if (source.equals("E") && destination.equals("Y")) {

			device = 147.726;

			dest_long = "Yens";

			amountConverted = amount * device;

		}

		if (source.equals("Y") && destination.equals("D")) {

			device = 0.00844069;

			dest_long = "Dollars";

			amountConverted = amount * device;

		}

		if (source.equals("Y") && destination.equals("E")) {

			device = 0.00676927;

			dest_long = "Euros";

			amountConverted = amount * device;

		}

		return amountConverted.floatValue() + " " + dest_long;

	}
	
	
	/**
	 * Retourne la liste des currencies en XML.
	 * En passant le parametre GET 'sortedYN' à 'y' , on demande une liste ordonnée.
	 * En passant le parametre GET 'sortedYN' à une autre valeur, l'ordre de la liste est inversé.
	 * 
	 * HEADER :  Accept à text/xml
	 * 
	 * URL : 
	 * 
	 * http://localhost:8080/td4-ws/v1/converterApp/currencyConverter/currencies?sortedYN=y
	 * 
	 * http://localhost:8080/td4-ws/v1/converterApp/currencyConverter/currencies?sortedYN=n
	 * 
	 * @param  String sortedYN 		: Dans le cas ou c'est 'y', la liste est ordonnée
	 * 								  Sinon, la liste est dans l'ordre inverse
	 * @return String XML			: Liste des currencies en XML
	 */
	@GET
	@Path("/currencies")
	@Produces(MediaType.TEXT_XML)
	public List<Currency> getCurrenciesXML(@QueryParam("sortedYN") String value){
		
		// Dans le cas ou on a sortedYN=y
		if(value.equals("y")){
			
			// on ordonne la liste en spécifiant une fonction pour le  Comparator
			Collections.sort(currencies, new Comparator<Currency>(){
				
				public int compare(Currency c1, Currency c2){

					return c1.getName().compareTo(c2.getName());

				}

			});
			
		}else{
			
			// On inverse la liste
			Collections.reverse(currencies);
		}
		
		return currencies;
		
	}
	
	
	/**
	 * Retourne la liste des currencies en JSON.
	 * En passant le parametre GET 'sortedYN' à 'y' , on demande une liste ordonnée.
	 * En passant le parametre GET 'sortedYN' à une autre valeur, l'ordre de la liste est inversé
	 * 
	 * HEADER :  Accept à application/json
	 * 
	 * URL :
	 * 
	 * http://localhost:8080/td4-ws/v1/converterApp/currencyConverter/currencies?sortedYN=y
	 * 
	 * http://localhost:8080/td4-ws/v1/converterApp/currencyConverter/currencies?sortedYN=n
	 * 
	 * @param  String sortedYN 		: Dans le cas ou c'est 'y', la liste est ordonnée
	 * 								  Sinon, la liste est dans l'ordre inverse
	 * @return String JSON			: Liste des currencies en XML
	 */
	@GET
	@Path("currencies")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Currency> getCurrenciesJSON(@QueryParam("sortedYN") String value){
		
		// Dans le cas ou on a sortedYN=y
		if(value.equals("y")){
			
			// on ordonne la liste en spécifiant une fonction pour le  Comparator
			Collections.sort(currencies, new Comparator<Currency>(){
				
				public int compare(Currency c1, Currency c2){

					return c1.getName().compareTo(c2.getName());

				}

			});
			
		}else{
			
			// On inverse la liste
			Collections.reverse(currencies);
		}
		
		return currencies;
		
	}
	
	// --------------------------- TD5 --------------------------- //
	/**
	 * Question 1
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("offices")
	@Produces(MediaType.APPLICATION_JSON)
	public String getOffices() throws Exception{
		
		Connection connection = DBClass.returnConnection();
		
		String SQL = "SELECT * FROM office ORDER BY id";
		
		Statement stmt = connection.createStatement();
		
		ResultSet resultSet = stmt.executeQuery(SQL);
		
		ToJSON toJSON = new ToJSON();
		
		JSONArray jsonArray = toJSON.toJSONArray(resultSet);
		
		return jsonArray.toString();
	}
	
	/**
	 * Question 2: A Method with QueryParameter
	 * @param city
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("office")
	@Produces(MediaType.APPLICATION_JSON)
	public String getOffice(@QueryParam ("city")String city) throws Exception{
		
		Connection connection = DBClass.returnConnection();
		
		String query = "SELECT * FROM office WHERE city = ? ORDER BY id";
		
		PreparedStatement stmt = connection.prepareStatement(query);

		stmt.setString(1, city);
		
		ResultSet resultSet = stmt.executeQuery();
		
		ToJSON toJSON = new ToJSON();
		
		JSONArray jsonArray = toJSON.toJSONArray(resultSet);
		
		return jsonArray.toString();
	}
	
	/**
	 * Question 3: Using The Response Class
	 * <p>Used to see a response code of a request<p>
	 * http://localhost:8080/td-ws-5/v1/converterApp/currencyConverter/office?city=Paris
	 * @param city
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("officeResponse")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOffice2(@QueryParam ("city")String city) throws Exception{
		
		Connection connection = DBClass.returnConnection();
		
		String query = "SELECT * FROM office WHERE city = ? ORDER BY id";
		
		PreparedStatement stmt = connection.prepareStatement(query);

		stmt.setString(1, city);
		
		ResultSet resultSet = stmt.executeQuery();
		
		if (!resultSet.first()) {
			
			return Response.status(400).build();
			
		}else{
			
			return Response.status(200).build();
		}

	}
	
	/**
	 * Question 4
	 * @return
	 */
	@POST
	@Path("offices")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String addOffice(@FormParam("city") String city,
							@FormParam("manager_name") String manager_name,
							@FormParam("year_founded") String year_founded,
							@FormParam("email") String email){
		return null;
	}
	
	

}
