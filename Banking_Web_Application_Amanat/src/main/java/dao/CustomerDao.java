package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Customers;

public class CustomerDao {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	public void save(Customers customers) 
	{
		entityTransaction.begin();
		entityManager.persist(customers);
		entityTransaction.commit();
	}
	public List<Customers> check1(String cEmail)
	{
		List<Customers> cutomerList=entityManager.createQuery("select a from Customers a where cEmail=?1").setParameter(1, cEmail).getResultList();
		return cutomerList;
		//List<Customer> list=query.getResultList();
	}
	public List<Customers> check2(long cPhone)
	{
		List<Customers> customerList=entityManager.createQuery("select a from Customers a where cPhone=?1").setParameter(1, cPhone).getResultList();
		return customerList;
	}
	
	public Customers login(int customerId) {
		Customers customers=entityManager.find(Customers.class, customerId);
		return  customers;
	}
	
	public void update(Customers customers) {
		entityTransaction.begin();
		entityManager.merge(customers);
		entityTransaction.commit();
	}
}
