package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Address;
import com.demo.model.MyUser;

public class TestMyUserAddress {
	
	public static void main(String[] args) {
		
		Address addr1 = new Address(1,"Narhe","pune");
		Address addr2 = new Address(2,"katraj","pune");
		
		MyUser us1 = new MyUser(11,"Yasir",addr1);
		MyUser us2 = new MyUser(22,"Rushi",addr2);
		
		addr1.setU(us1);
		addr1.setU(us2);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(addr1);
		session.save(addr2);
		session.save(us1);
		session.save(us2);
		
		tr.commit();
 	}

}
