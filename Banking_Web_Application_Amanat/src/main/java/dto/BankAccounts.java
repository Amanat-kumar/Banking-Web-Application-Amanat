package dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class BankAccounts {
	@Id
	@SequenceGenerator(initialValue = 4456321, allocationSize = 1,sequenceName = "accountNo",name = "accountNo")
	@GeneratedValue(generator = "accountNo")
	long accountNo;
	@Column
	String accountType;
	@Column
	double accountLimit;
	@Column
	boolean accountStatus;
	@Column
	double amount;
	
	@ManyToOne
	Customers customer;
	
	@OneToMany(cascade = CascadeType.ALL)//it is used to saved data inside database without begin, persist, commit
	List<BankTransactions> TransactionList;

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAccountLimit() {
		return accountLimit;
	}

	public void setAccountLimit(double accountLimit) {
		this.accountLimit = accountLimit;
	}

	public boolean isAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(boolean accountStatus) {
		this.accountStatus = accountStatus;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public List<BankTransactions> getTransactionList() {
		return TransactionList;
	}

	public void setTransactionList(List<BankTransactions> transactionList) {
		TransactionList = transactionList;
	}	
	
}
