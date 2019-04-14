import java.io.*;
import java.util.HashMap;
import java.util.Map;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Arrays;

/*
This class is used to connect to the MongoDB provided and read data 
from the database.
This portion is not needed for testing purposes of the software!
*/
public class reading {

	public static void main(String[] args)throws Exception 
	  { 

	  //This part connects to the local file connections and is used to write to the database
	  File file = new File("connection.txt"); 
	  Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	  
	  //This is the local host connection for connecting to the MongoDB datbase
	  MongoClient mongoClient = new MongoClient( "localhost", 27017);
	  
	  //This is the name of my DB
	  MongoDatabase database = mongoClient.getDatabase("Twitter_Connections");
	  
	  //this is the name of my collection
	  MongoCollection<Document> collection = database.getCollection("Contacts");	  
	  
	  //used for file reading and writing
	  BufferedReader br = new BufferedReader(new FileReader(file)); 	  
	  String st; 
	  while ((st = br.readLine()) != null)
	  {
		  String[] output = st.split(" ");
		  if (map.get(output[0]) != null){
			  ArrayList<String> connect = map.get(output[0]);
			  connect.add(output[1]);			  
		  }
		  else{
			  ArrayList<String> connect = new ArrayList<String>();
			  connect.add(output[1]);
			  map.put(output[0], connect);			  
		  }
		  
	  }
	  
	  //Used to write to create a Document and write to a database
	  for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
		  Document doc = new Document("name", entry.getKey())
	                .append("Connections", entry.getValue());  
		  collection.insertOne(doc);
	  }
		  
	    
	  } 
}
