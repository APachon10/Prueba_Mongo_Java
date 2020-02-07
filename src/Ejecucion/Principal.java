package Ejecucion;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCursor;

import Conexion.AbrirConexion;

public class Principal {
	public static void main(String[] args) {
		AbrirConexion c = new AbrirConexion();
        System.out.println("Prueba conexi�n MongoDB");
        MongoClient cliente =c.conectar();
 
        if(cliente == null) {
        	System.out.println("Error: Conexi�n no establecida");
        	
        }else {
        	System.out.println("Lista de bases de datos: ");
        	printDatabases(cliente);
        }
    }
	private static void printDatabases(MongoClient mongo) {
        MongoCursor<String> cursor = (MongoCursor<String>) mongo.listDatabaseNames();
        while(cursor.hasNext()) {
        	System.out.println(cursor.next());
        }
    }
}
