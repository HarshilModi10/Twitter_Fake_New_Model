 
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
This class is used to connect to the MongoDB provided and to write 
to the database.
This portion is not needed for testing purposes of the software!

*/
public class Mongo {


	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception  {
		
		//The data from the database will be read and presented in this format below
		Map<Integer, List<Integer>> vertices = new HashMap<Integer, List<Integer>>();

		//Connecting to the database 
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Twitter_Connections");
		MongoCollection<Document> collection = database.getCollection("Contacts");
		
		//used to scrape database and add the data to the HashMap
		List<Document> vertex = (List<Document>) collection.find().into(new ArrayList<Document>());
		for (Document node : vertex) {		
			int name = Integer.parseInt(node.getString("name"));
			@SuppressWarnings("unchecked")
			List<String> edges = (List<String>) node.get("Connections");
			List<Integer> new_edges = edges.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
			vertices.put(name, new_edges);		 
		}	
	}	
}
