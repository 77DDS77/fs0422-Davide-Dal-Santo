import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {

		// connessione db
		String url = "jdbc:mysql://localhost:3306/j_theory3_db?useSSL=false";
		String username = "root";
		String password = "";
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println( "connessione effettuata correttamente!" );
		}
		catch( Exception exc ) {
			System.out.println( "errore nella connessione" );
		}
		
		// delete
		//deleteStudentById(7, conn);
		
		// insert
		//insertStudent("john", "doe", "5,6,7", conn);
		
		// select
		printAllStudents(conn);
		// printStudentById(4, conn);
		
		// update
		// updateStudentById(7, "name", "anna", conn);
		//updateStudentById(7, "lastname", "bianchi", conn);
		
		// chiusura connession
		if( conn != null ) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println( "errore nella chiusura della connessione" );
			}
		}

	}
	
	// select all
	public static void printAllStudents(Connection conn) {
		System.out.println( "Dati di tutti gli studenti:" );
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
				"SELECT id, name, lastname, votes FROM students"
			);
			
			while( rs.next() ) {
				
				System.out.printf( "ID: %d, Name: %s, Lastname: %s, Votes: %s %n", 
					rs.getInt("id"),
					rs.getString("name"),
					rs.getString("lastname"),
					rs.getString("votes")
				);
				
			}
			
		}
		catch( Exception exc ) {
			System.out.println( "errore nella selezione" );
		}
	}
	
	// select one
	public static void printStudentById(int id, Connection conn) {
		System.out.println("Dati dello studente con id " + id + ":");
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
				"SELECT id, name, lastname, votes FROM students WHERE id = " + id
			);
			
			while( rs.next() ) {
				
				System.out.printf( "ID: %d, Name: %s, Lastname: %s, Votes: %s %n", 
					rs.getInt("id"),
					rs.getString("name"),
					rs.getString("lastname"),
					rs.getString("votes")
				);
				
			}
			
		}
		catch( Exception exc ) {
			System.out.println( "errore nella selezione" );
		}
	}
	
	// update
	public static void updateStudentById(int id, String col, String val, Connection conn) {
		try {			
			Statement stmt = conn.createStatement();
			
			String query = String.format("UPDATE students SET %s = '%s' WHERE id = %d", col, val, id);
			System.out.println( query );
			//return;
			
			stmt.executeUpdate(
				//"UPDATE students SET " + col + " = ' " + val+ " '" +  " WHERE id = " + id
				query
			);
			
			System.out.println( "modifiche effettuate correttamente!" );
			
		}
		catch( Exception exc ) {
			exc.printStackTrace();
			System.out.println( "errore nella modifica " + exc.getMessage() );
		}
	}
	
	// insert
	public static void insertStudent(String n, String ln, String v, Connection conn) {
		
		String query = "INSERT INTO students (name, lastname, votes) VALUES (?, ?, ?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			
			stmt.setString(1, n);
			stmt.setString(2, ln);
			stmt.setString(3, v);
			stmt.execute();
			
			System.out.println( "inserimento effettuato correttamente!" );
			
		} catch (SQLException e) {
			System.out.println( "errore nell'inserimento" );
		}
		
	}
	
	// delete
	public static void deleteStudentById(int id, Connection conn) {
		
		String query = "DELETE FROM students WHERE id = " + id;
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(query);
			
			System.out.println( "eliminazione effettuata correttamente!" );
			
		} catch (SQLException e) {
			System.out.println( "errore nella cancellazione" );
		}
		
	}

}
