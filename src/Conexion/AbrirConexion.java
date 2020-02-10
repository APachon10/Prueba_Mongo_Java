package Conexion;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class AbrirConexion {
	public static MongoClient conectar() {
		MongoClient cliente = null;
		try {
			cliente = new MongoClient("localhost", 27017);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cliente;
	}
	public void cerrarConexion(MongoClient cliente) {
		cliente.close();
	}
	public MongoClient abrirConexionAtlas() {

		MongoClientURI uri = new MongoClientURI(
				"mongodb+srv://Alberto:Deadzone95@cluster1-yhavo.gcp.mongodb.net/test?retryWrites=true&w=majority");
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("test");
		return mongoClient;

	}
}
