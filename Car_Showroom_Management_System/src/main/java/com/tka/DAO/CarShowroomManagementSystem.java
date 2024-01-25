package com.tka.DAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import com.tka.entity.ShowroomA;
import com.tka.entity.ShowroomB;

public class CarShowroomManagementSystem {

	public static void main(String[] args) {

		
		
        
        
		CarShowroomManagementSystem cms = new CarShowroomManagementSystem();
		//cms.joinTables();
		//cms.deleteRecord();
		//cms.updateRecord();
		//cms.insertRecord();
		cms.menu();
		
	}
	
	
	public void menu() {
		
		System.out.println();
        System.out.println("======= *** WELCOME TO CAR SHOWROOM MANAGEMENT SYSTEM *** =======");
        System.out.println();
        System.out.println("==================** ENTER YOUR CHOICE *** ======================");
        System.out.println();
        System.out.println("1]. SEE SHOWROOM \t\t\t 2]. DELETE RECORD FROM SHOWROOM");
        System.out.println("3]. UPDATE SHOWROOM RECORD\t\t 4]. INSERT RECORD IN SHOWROOM");
        System.out.println();
        System.out.println("================== *** ENTER 0 TO EXIT *** =======================");
		
		CarShowroomManagementSystem cms = new CarShowroomManagementSystem();

		Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
       
		
        switch(choice) {
        
        case 1:
        	cms.joinTables();
        	break;
        	
        case 2:
        	cms.deleteRecord();
        	break;
        	
        case 3:
        	cms.updateRecord();
        	break;
        	
        case 4:
        	cms.insertRecord();
        	break;
        	
        case 0:
        	break;
        default:
        	System.out.println("Enter valid choice: ");
        }
		

		
	}
	
	
	
	
	public void joinTables() {
		
		
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(ShowroomA.class);
		configuration.addAnnotatedClass(ShowroomB.class);

		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		
		
		Query query = session.createQuery("select s1.showNo,s1.showName,s1.totalCars,s2.showAddress,s2.showContact from ShowroomA s1 inner join ShowroomB s2 on s1.showNo=s2.showNo");
		
		
		List<Object[]> list = query.list();

		
		System.out.println();
		System.out.println("========**  UPDATED TABLE  **======== ");
		System.out.println();

		
		for (Object[] array : list) {
			System.out.println(Arrays.toString(array));
		}	
		
		menu();
	}
	
	
	
	public void deleteRecord() {

		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(ShowroomA.class);
		configuration.addAnnotatedClass(ShowroomB.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		
		Query<ShowroomA> query = session.createQuery("delete from ShowroomA where showNo=:showNo");
		
		
		System.out.print("Enter show number: ");
		Scanner scanner = new Scanner(System.in);
		int showNo = scanner.nextInt();
		
		query.setParameter("showNo",showNo);
		
		
		Transaction tx = session.beginTransaction();
		
		
		int count = query.executeUpdate();
		
		
		System.out.println();
		
		System.out.println("Number Of Records Deleted From ShowroomA : " + count);
		
		tx.commit();
		menu();
	}
	
	
	
	
	
	public void updateRecord() {
		
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(ShowroomA.class);
		configuration.addAnnotatedClass(ShowroomB.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		
		Query query = session.createQuery("update ShowroomA set showName=:showName, totalCars=:totalCars where showNo=:showNo");
		
		System.out.print("Enter show name: ");
		Scanner scanner = new Scanner(System.in);
		String showName = scanner.nextLine();
		
		
		System.out.print("Enter total cars: ");
		Scanner scanner1 = new Scanner(System.in);
		int totalCars = scanner1.nextInt();
		
		System.out.print("Enter show number: ");
		Scanner scanner3 = new Scanner(System.in);
		int showNo = scanner3.nextInt();
		
		query.setParameter("showName", showName);
		query.setParameter("totalCars",totalCars);
		query.setParameter("showNo", showNo);
		
		
		Transaction tx = session.beginTransaction();
		
		
		int count = query.executeUpdate();
		
		
		tx.commit();
		System.out.println();
		System.out.println(count + " : Records affected ");
		session.close();
		menu();
	}
	
	
	
	
	
	public void insertRecord() {
		
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(ShowroomA.class);
		configuration.addAnnotatedClass(ShowroomB.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		
		Query query = session.createQuery("insert into ShowroomA(showNo,showName,totalCars)values(:showNo,:showName,:totalCars)");
		
		
		
		System.out.print("Enter show number: ");
		Scanner scanner = new Scanner(System.in);
		int showNo = scanner.nextInt();
		
		System.out.print("Enter show name: ");
		Scanner scanner1 = new Scanner(System.in);
		String showName = scanner1.nextLine();
		
		System.out.print("Enter total cars: ");
		Scanner scanner3 = new Scanner(System.in);
		int totalCars = scanner3.nextInt();
		
		query.setParameter("showName", showName);
		query.setParameter("totalCars",totalCars);
		query.setParameter("showNo", showNo);
		
		
		Transaction tx = session.beginTransaction();
		
		
		int count = query.executeUpdate();
		
		System.out.println();
		System.out.println(count + " : Records are inserted successfully !!!"  );
		
		tx.commit();
		session.close();
		
		menu();
	}
	

}
