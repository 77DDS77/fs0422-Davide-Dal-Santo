import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		
		//connessione al db
		String url= "jdbc:mysql://localhost:3306/";
		String username= "";
		String password = "";

		Connection conn = null;
		
		try {
			
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connessione a buion fine");
		}
		catch( Exception e) {
			System.out.println("Eroore nella connessione");
		}
		
		//stampa da database (select)
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT id, name, lastname, votes FROM students"
					);
			while(rs.next()) {
				System.out.printf("ID: %d, Name: %s, lastname: %s, Votes: %s %n", 
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("lastname"),
						rs.getString("votes")
						);
			}
		}
		catch(Exception e){
			System.out.println("errore nella selezione");
		}
		
		
	}
	
	public static void printUserById(int id, Connection conn) {
		/*
		 * mettere su metodo per codice piu pulito, smetto di seguire
		 * perche' la lezione di so tipo non ha senso.
		 */
	}

}
