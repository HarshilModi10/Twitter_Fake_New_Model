import java.io.*;
import java.util.HashMap;
import java.util.Map;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.Arrays;

public class reading {

	public static void main(String[] args)throws Exception 
	  { 
	  // We need to provide file path as the parameter: 
	  // double backquote is to avoid compiler interpret words 
	  // like \test as \t (ie. as a escape sequence) 
	  File file = new File("connection.txt"); 
	  Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	  
	  MongoClient mongoClient = new MongoClient( "localhost", 27017);
	  System.out.println("connec");
	  MongoDatabase database = mongoClient.getDatabase("Twitter_Connections");
	  MongoCollection<Document> collection = database.getCollection("Contacts");	  
	  
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
	  for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
		  Document doc = new Document("name", entry.getKey())
	                .append("Connections", entry.getValue());
	                
			
			collection.insertOne(doc);
	  }
		  
	    
	  } 
}
