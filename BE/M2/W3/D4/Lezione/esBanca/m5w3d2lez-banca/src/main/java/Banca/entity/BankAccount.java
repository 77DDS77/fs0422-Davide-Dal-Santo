package Banca.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import Banca.controller.IBANSeq;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "bank_accounts")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "iban_id", referencedColumnName = "id")
	private IBANSeq IBAN;
	
	@ManyToMany
	@JoinTable(
			name = "accounts_users",
			joinColumns =  @JoinColumn(name = "account_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
			 )
	private Set<User> users = new HashSet<User>();
	
	private int balance = 0;

	public BankAccount( User user) {
		this.users.add(user);
	}

	public void addUser(User u) {
		this.users.add(u);		
	}

	public void updateBalance(int deposit) {
		this.balance += deposit;
		
	}
		
}
