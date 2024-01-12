package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Products;

public class TestProducts {
	
	public static void main(String[] args) {
		
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Products p=new Products(1,"xxx",20,100);
		Products p1=new Products(2,"yyy",15,200);
		Products p2=new Products(3,"zzz",40,500);
		Products p3=new Products(4,"pppp",50,600);
		
		session.save(p);
		session.save(p2);
		session.save(p3);
		session.save(p);
		tr.commit();
		session.close();
		sf.close();
		
	}

}
