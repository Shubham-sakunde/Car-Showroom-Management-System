package com.tka.DAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		cms.joinTables();
		//cms.deleteRecord();
		//cms.updateRecord();
		//cms.insertRecord();

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
	}
	
	
	
	public void deleteRecord() {

		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(ShowroomA.class);
		configuration.addAnnotatedClass(ShowroomB.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		
		Query<ShowroomA> query = session.createQuery("delete from ShowroomA where id=:id");
		query.setParameter("id",16);
		
		
		Transaction tx = session.beginTransaction();
		
		
		int count = query.executeUpdate();
		
		
		System.out.println();
	
		System.out.println("Number Of Records Deleted From ShowroomA : " + count);
		
		tx.commit();
	}
	
	
	
	
	
	public void updateRecord() {
		
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(ShowroomA.class);
		configuration.addAnnotatedClass(ShowroomB.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		
		Query query = session.createQuery("update ShowroomA set showName=:showName, totalCars=:totalCars where showNo=:showNo");
		
		
		query.setParameter("showName", "Mukesh Motors");
		query.setParameter("totalCars",58);
		query.setParameter("showNo", 13);
		
		
		Transaction tx = session.beginTransaction();
		
		
		int count = query.executeUpdate();
		
		
		tx.commit();
		System.out.println(count + " : Records affected ");
		session.close();
		
	}
	
	
	
	
	
	public void insertRecord() {
		
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(ShowroomA.class);
		configuration.addAnnotatedClass(ShowroomB.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		
		Query query = session.createQuery("insert into ShowroomA(showNo,showName,totalCars)values(16,'Yogesh Motors',77)");
		
		
		
		Transaction tx = session.beginTransaction();
		
		
		int count = query.executeUpdate();
		
		
		System.out.println(count + " : Records are inserted successfully !!!"  );
		
		tx.commit();
		session.close();
	}
	

}
