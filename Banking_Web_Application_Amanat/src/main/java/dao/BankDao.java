package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.BankAccounts;

public class BankDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void saveAccount(BankAccounts bankAccounts) {
		entityTransaction.begin();
		entityManager.persist(bankAccounts);
		entityTransaction.commit();
	}

	public List<BankAccounts> fetchAll() {
		List<BankAccounts> bankAccountList=(List<BankAccounts>) entityManager.createQuery("select x from BankAccounts x").getResultList();
		return bankAccountList;
	}

	public BankAccounts fetchAccountDetails(long accountNo) {
		BankAccounts  bankAccounts=entityManager.find(BankAccounts.class, accountNo);
		return bankAccounts;
	}
	
	public void updateAccountDetails(BankAccounts bankAccounts) {
		entityTransaction.begin();
		entityManager.merge(bankAccounts);
		entityTransaction.commit();
	}
	public BankAccounts find(long accountNo)
	{
		BankAccounts bankAccounts=entityManager.find(BankAccounts.class, accountNo);
		return bankAccounts;
	}
}
