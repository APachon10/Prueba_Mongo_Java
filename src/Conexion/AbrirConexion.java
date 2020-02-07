package Conexion;

import com.mongodb.MongoClient;

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
}
