package Ejecucion;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

import Conexion.AbrirConexion;
import Modelos.Persona;

public class Principal {
	public static void main(String[] args) {
		AbrirConexion c = new AbrirConexion();
        System.out.println("Prueba conexión MongoDB");
        MongoClient cliente =c.abrirConexionAtlas();

        if(cliente == null) {
        	System.out.println("Error: Conexión no establecida");
        	
        }else {
        	System.out.println("Lista de bases de datos: ");
        	printDatabases(cliente);
        	System.out.println("==========================");
        	System.out.println("Colecciones de la Base: ");
        	System.out.println("==========================");
        	selectColecciones(cliente); 	
        }
        System.out.println("==================");
        c.abrirConexionAtlas();
    }
	private static void printDatabases(MongoClient mongo) {
		MongoIterable<String> mongo2 = mongo.listDatabaseNames();
		MongoCursor<String> cursor =  mongo2.iterator();
        while(cursor.hasNext()) {
        	System.out.println(cursor.next());
        }
    }
	private static void selectColecciones(MongoClient mongo) {
		try {
			MongoDatabase database = mongo.getDatabase("AlbertoPrueba");
			MongoCollection<Document> collection = database.getCollection("Anime");
			
			FindIterable<Document> docs = collection.find();//--> Select * from Databases;
			for (Document document : docs) {
				System.out.println(document);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	private static void insertar(MongoClient mongo) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
