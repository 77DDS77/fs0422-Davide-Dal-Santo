package models;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "loans")
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user; //
	
	@OneToOne //TODO one to one su item
	@JoinColumn(name = "item_id")
	private Item itemLoaned;
	
	private LocalDateTime loanStart;
	
	private LocalDateTime returnDate;
	
	private LocalDateTime actualReturnDate;
	
	public Loan() {}

	public Loan(User user, Item itemLoaned) {
		this.user = user;
		this.itemLoaned = itemLoaned;
		this.loanStart = LocalDateTime.now();
		this.returnDate = loanStart.plusMonths(1); //stonks
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Item getItemLoaned() {
		return itemLoaned;
	}

	public void setItemLoaned(Item itemLoaned) {
		this.itemLoaned = itemLoaned;
	}

	public LocalDateTime getLoanStart() {
		return loanStart;
	}

	public void setLoanStart(LocalDateTime loanStart) {
		this.loanStart = loanStart;
	}

	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}

	public LocalDateTime getActualReturnDate() {
		return actualReturnDate;
	}

	public void setActualReturnDate(LocalDateTime actualReturnDate) {
		this.actualReturnDate = actualReturnDate;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", user=" + user 
				+ ", itemLoaned=" + itemLoaned 
				+ ", loanStart=" + loanStart.getYear() 
				+ "-" + loanStart.getMonthValue() 
				+ "-" + loanStart.getDayOfMonth() 
				+ ", returnDate=" + returnDate.getYear() 
				+ "-" + returnDate.getMonthValue() 
				+ "-" + returnDate.getDayOfMonth()
				+ "]";
	}
	
	
	
	
}
