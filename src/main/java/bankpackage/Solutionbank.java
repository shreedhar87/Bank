package bankpackage;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.From;

import org.hibernate.sql.Select;


public class Solutionbank {
	public static void main(String[] args) {
		while(true) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shreedhar");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Scanner scan=new Scanner(System.in);
		System.out.print("1.Add the bank details\n2.Delete the bank details\n"
				+ "3.Show the bank details\n4.update the bank data\n5.Show the detailes of all banks\nSelect the choice=");

		int choice=scan.nextInt();

		switch(choice) {
		case 1:
			Bank b=new Bank(); //Add the data	
			System.out.print("enter the bank id number=");
			int id=scan.nextInt();
			b.setId(id);
			
			System.out.print("enter the nuber of employess working in bank=");
			int bankid=scan.nextInt();
			b.setNumemployee(bankid);
			
			System.out.print("enter the name of the bank=");
			String bankname=scan.next();
			b.setBankname(bankname);
			
			System.out.print("enter the location of the bank=");
			String locbank=scan.next();
			b.setBankloc(locbank);

			entityTransaction.begin(); 
			entityManager.persist(b);
			entityTransaction.commit();
			System.err.println("data inserted sucssesfully");
			break;
		case 2:
			System.out.print("enter the bank id to delete detiles of the bank=");
			int i=scan.nextInt();
			Bank bank=entityManager.find(Bank.class,i); //Delete the data

			if(bank!=null) { 
				entityTransaction.begin(); 
				entityManager.remove(bank);
			entityTransaction.commit(); 
			System.err.println("data deleted sucssesfully");
			} 
			else {
				System.err.println("data is not deleted");
				}

			break;
			
		case 3:
			System.out.print("enter the bank id to get the detiles of the bank=");
			int i1=scan.nextInt();
			Bank bank1 = entityManager.find(Bank.class, i1); // Get the data

			if (bank1 != null) {
				System.out.println("The id of the bank " + bank1.getId());
				System.out.println("The number of employee of the bank " + bank1.getNumemployee());
				System.out.println("The name of the bank " + bank1.getBankname());
				System.out.println("The location of the bank " + bank1.getBankloc());
				

			} else {
				System.err.println("data is not deleted");
			}
			break;
		case 4:
			System.out.print("enter the bank id to update the detiles of the bank=");
			int i2=scan.nextInt();
			Bank bank2=entityManager.find(Bank.class,i2);
			
		/*	System.out.print("enter the bank id number=");
			int id1=scan.nextInt();
			bank2.setId(id1);*/
			
			System.out.print("enter the nuber of employess working in bank=");
			int bankid1=scan.nextInt();
			bank2.setNumemployee(bankid1);
			
			System.out.print("enter the name of the bank=");
			String bankname1=scan.next();
			bank2.setBankname(bankname1);
			
			System.out.print("enter the location of the bank=");
			String locbank1=scan.next();
			bank2.setBankloc(locbank1);

			entityTransaction.begin(); 
			entityManager.merge(bank2);
			entityTransaction.commit();
			System.err.println("data updated sucssesfully");
			break;
		case 5:
			Query query=entityManager.createQuery("SELECT s FROM Bank s");
			 List<Bank> bank4=query.getResultList();
			
			for(Bank bank5:bank4) {
				System.out.println("bank names are="+bank5.getBankname());
				System.out.println("bank id's are="+bank5.getId());
				System.out.println("bank locations are="+bank5.getBankloc());
				System.out.println("bank employes of each banks are="+bank5.getNumemployee());
			}
			break;
		default:
			System.err.println("invalid choice");
		}
		}		
	}
}
