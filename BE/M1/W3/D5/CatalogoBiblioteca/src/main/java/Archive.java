import java.time.LocalDate;

import models.Book;
import models.Every;
import models.Loan;
import models.Magazine;
import models.User;
import utils.ArchiveDAO;
import utils.BookDAO;
import utils.LoanDAO;
import utils.MagazineDAO;
import utils.UserDAO;

public class Archive {

	public static void main(String[] args) {

		//populateDB();

		//Ricerca per titolo o parte di esso
		//ArchiveDAO.findByTitle("milion");
		
		//Ricerca degli elementi attualmente 
		//in prestito dato un numero di tessera utente
		ArchiveDAO.elementOnLoanByCard(1);
		
		//Ricerca di tutti i prestiti scaduti e non ancora restituiti
		ArchiveDAO.findOffLoans();
		
		
	}

	private static void populateDB() {
		
		//Books
		Book b1 = new Book("libro numero 1", "1997", 100, "Davide", "Horror");
		BookDAO.save(b1);
		
		Book b2 = new Book("altro libro", "2010", 148, "Piero", "Fantasy");
		BookDAO.save(b2);
		
		Book b3 = new Book("come fare un milione di dollari", "2022", 200, "Carisio Di Giampietro", "Fantasy");
		BookDAO.save(b3);
		
		//Magazines
		Magazine m1 = new Magazine("magazine 1", "1997", 50, Every.WEEK);
		MagazineDAO.save(m1);
		
		Magazine m2 = new Magazine("Vogue", "2012", 50, Every.SIXMONTH);
		MagazineDAO.save(m2);
		
		Magazine m3 = new Magazine("VanityFair", "2010", 50, Every.MONTH);
		MagazineDAO.save(m3);
		
		//Users
		User u1 = new User("Davide", "Dal Santo", LocalDate.of(1997, 4, 20));
		UserDAO.save(u1);
		
		User u2 = new User("Carisio", "Di Giampietro", LocalDate.of(2001, 9, 30));
		UserDAO.save(u2);
		
		User u3 = new User("Mirco", "Marco", LocalDate.of(1973, 3, 12));
		UserDAO.save(u3);
		
		//Loans
		Loan l1 = new Loan(u1, b1);
		LoanDAO.save(l1);
		
		Loan l2 = new Loan(u1, m1);
		LoanDAO.save(l2);
		
		Loan l3 = new Loan(u2, b2);
		LoanDAO.save(l3);
		
		Loan l4 = new Loan(u2, m2);
		LoanDAO.save(l4);
		
		Loan l5 = new Loan(u3, b3);
		LoanDAO.save(l5);
		
		Loan l6 = new Loan(u3, m3);
		LoanDAO.save(l6);
		
		//Loans status
		LoanDAO.endLoan(1);
		LoanDAO.endLoan(4);
		
	}
	


}





