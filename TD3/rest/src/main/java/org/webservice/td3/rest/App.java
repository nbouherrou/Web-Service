package org.webservice.td3.rest;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import twitter4j.IDs;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;



/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws JsonGenerationException,
			JsonMappingException, IOException, ParseException, TwitterException {

		/* __________ STEP 00 ____________ */

		System.out
				.println("**** Hello World  ********************************");

		TwitterClient twitter = new TwitterClient();

		String url_1 = "https://api.twitter.com/1.1/account/verify_credentials.json";

		String json_response_1 = twitter.TwitterGETSignedRequest(url_1);

		// Affichage avec indentation du JSON
		//System.out.println(TwitterClient.TwitterPrettyJSON(json_response_1));

		/* __________ Question 01 ____________ */

		// on utilise la reponse de "json_response_1" de STEP 00

		JSONParser parser = new JSONParser();

		Object objetNormal = parser.parse(json_response_1);

		JSONObject jsonObject = (JSONObject) objetNormal;

		System.out
				.println("**** QUESTION 01 : ********************************");

		System.out.println();

		System.out.println(" |---- My Info ------------------------");

		System.out.println(" |->Id : \t\t\t\t" + jsonObject.get("id_str"));

		System.out.println(" |->Name : \t\t\t\t" + jsonObject.get("name"));

		System.out.println(" |->ScreenName : \t\t\t"
				+ jsonObject.get("screen_name"));

		System.out.println(" |->Followers :  \t\t\t"
				+ jsonObject.get("followers_count"));

		System.out.println(" |->Friends :  \t\t\t\t"
				+ jsonObject.get("friends_count"));

		System.out.println(" |->Created At :  \t\t\t"
				+ jsonObject.get("created_at"));

		System.out.println(" |->Time-Zone :  \t\t\t"
				+ jsonObject.get("time_zone"));

		/* __________ Question 02 ____________ */

		System.out
				.println("**** QUESTION 02 : ********************************");

		String url_2 = "https://api.twitter.com/1.1/followers/list.json";

		String json_response_2 = twitter.TwitterGETSignedRequest(url_2);

		System.out.println(TwitterClient.TwitterPrettyJSON(json_response_2));

		Object objetNormal2 = parser.parse(json_response_2);

		JSONObject jsonObject2 = (JSONObject) objetNormal2;

		JSONArray array = (JSONArray) jsonObject2.get("users");

		for (int i = 0; i < array.size(); i++) {

			System.out.println();

			System.out.println(" |---- Follower " + i
					+ "------------------------");

			JSONObject arrayObject = (JSONObject) array.get(i);

			System.out.println(" |->Id : \t\t\t\t" + arrayObject.get("id_str"));

			System.out.println(" |->Name : \t\t\t\t" + arrayObject.get("name"));

			System.out.println(" |->ScreenName : \t\t\t"
					+ arrayObject.get("screen_name"));

			System.out.println(" |->Followers :  \t\t\t"
					+ arrayObject.get("followers_count"));

			System.out.println(" |->Friends :  \t\t\t\t"
					+ arrayObject.get("friends_count"));

			System.out.println(" |->Created At :  \t\t\t"
					+ jsonObject.get("created_at"));

			System.out.println(" |->Time-Zone :  \t\t\t"
					+ jsonObject.get("time_zone"));
		}

		/* __________ Question 03 ____________ */

		System.out
				.println("**** QUESTION 03 : ********************************");

		String url_3 = "https://api.twitter.com/1.1/friends/list.json";

		String json_response_3 = twitter.TwitterGETSignedRequest(url_3);

		System.out.println(TwitterClient.TwitterPrettyJSON(json_response_3));

		Object objetNormal3 = parser.parse(json_response_2);

		JSONObject jsonObject3 = (JSONObject) objetNormal2;

		JSONArray array3 = (JSONArray) jsonObject3.get("users");

		Double star_phile = 0.0;

		for (int i = 0; i < array3.size(); i++) {

			JSONObject arrayObject = (JSONObject) array3.get(i);

			System.out.println();

			System.out.println(" |---- " + arrayObject.get("name"));

			System.out.println(" |->Followers :  \t\t"
					+ arrayObject.get("followers_count"));

			star_phile += Double.parseDouble(arrayObject.get("followers_count")
					.toString());

		}

		System.out.println("\n --->Star_phile Ratio :  \t\t"
				+ (star_phile / array3.size()));

		/* __________ Question 04 ____________ */

		System.out
				.println("**** QUESTION 04 : ********************************");

		String message_to_post = "[WS-Class] This is my RESTFUL status @ : "
				+ (new Date()).toString();

		StringBuilder req_post = new StringBuilder();

		req_post.append("https://api.twitter.com/1.1/statuses/update.json?");
		req_post.append("status=" + URLEncoder.encode(message_to_post));

		System.out.println("---> Q04 Server Response ");

		// Resultat a voir sur le mure de Twitter AHMED BACHA (@kimkero13)

		String post_response =
		twitter.TwitterPOSTSignedRequest(req_post.toString());

		//System.out.println(TwitterClient.TwitterPrettyJSON(post_response));

		/* __________ Question 05 ____________ */

		System.out
				.println("**** QUESTION 05 : ********************************");

		System.out
				.println("REST verbs  : GET - PUT - DELETE - POST - PATCH - OPTION ");

		/* __________ GO FURTHER Twitter4J ____________ */

		System.out
				.println("**** GO FURTHER : ********************************");

		final String API_KEY 		= "Tl20ETMXcTvWld9v0MhDJ2PdD";

		final String API_SECRET 	= "PuSMZshFcpvcCogAnmJxMiYOJD8ly0xijD6Fd5IxAaoadqU6XW";

		final String TOKEN_KEY 		= "724433312-eOaHQoYm3qaCONExXApkfOCWqrIuUjaFLaKMHXwb";

		final String TOKEN_SECRET 	= "nQnzRAvdzxLFpRMxhxngebtv9jAlPP8kv1IyXwwi2pKPp";

		final Integer MY_ID = 724433312;

		// Configuration de Twitter4J
		ConfigurationBuilder cb = new ConfigurationBuilder();

		cb.setDebugEnabled(true).setOAuthConsumerKey(API_KEY)
				.setOAuthConsumerSecret(API_SECRET)
				.setOAuthAccessToken(TOKEN_KEY)
				.setOAuthAccessTokenSecret(TOKEN_SECRET);

		TwitterFactory twitter_factory = new TwitterFactory(cb.build());

		Twitter twitter4j = twitter_factory.getInstance();

		/* POSTING */
		Status status_1 =
		twitter4j.updateStatus("This is a POST from TwitterJ4 framework");
		System.out.println("Successfully updated the status to [" +
		status_1.getText() + "].");

		/* Getting Timeline */
		List<Status> statuses = twitter4j.getHomeTimeline();

		System.out.println("---> Showing home timeline : ");

		for (Status status : statuses) {
			System.out.println("* " + status.getUser().getName() + " ::: "
					+ status.getText());
		}

		/* Getting Friends List */
		long cursor = -1;

		List<User> users = twitter4j.getFriendsList(MY_ID, cursor);

		System.out.println("\n---> Getting My Friends List : ");

		for (User user : users) {

			System.out.println("|->Name :\t\t" + user.getName());

			System.out.println("|->Friends :\t\t" + user.getFriendsCount());

			System.out.println("|->Followers number :\t"
					+ user.getFavouritesCount());

			System.out.println();
		}

		/* Getting Followers List */

		long followerCursor = -1;
		IDs followerIds;
		
		System.out.println("\n---> Getting My Followers List : ");
		
		do {
			followerIds = twitter4j.getFollowersIDs(MY_ID, followerCursor);
			ResponseList<User> followers = twitter4j.lookupUsers(followerIds.getIDs());

			for (User follower : followers) {
				
				System.out.println("|->Name :\t\t" + follower.getName());

				System.out.println("|->Friends :\t\t" + follower.getFriendsCount());

				System.out.println("|->Followers number :\t"+ follower.getFollowersCount());
				
				System.out.println();

			}

		} while ((followerCursor = followerIds.getNextCursor()) != 0);

	}
}
