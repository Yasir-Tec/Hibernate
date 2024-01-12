package com.demo.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.demo.model.Products;

public class TestCriteriaQuery 
{

	public static void main(String[] args) {
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		
		
		//retrieve all products
		//String str="select p from Product p"
		Criteria cr = session.createCriteria(Products.class);
		List<Products> plist = cr.list();
		for(Products p : plist)
		{
			System.out.println(p.getPid());
			System.out.println(p.getPname());
			System.out.println(p.getQty());
			System.out.println(p.getPrice());
		}
		System.out.println("***************************************************");
		
		
		Criteria cr1 = session.createCriteria(Products.class);
		Criterion pricegt = Restrictions.gt("price",300.00);
		Criterion qtylt = Restrictions.lt("qty",50);
		LogicalExpression expr = Restrictions.and(pricegt, qtylt);
		cr1.add(expr);
		plist = cr1.list();
		for(Products p : plist)
		{
			System.out.println(p.getPid());
			System.out.println(p.getPname());
			System.out.println(p.getQty());
			System.out.println(p.getPrice());
		}
		System.out.println("************************************************************");
		
		//to find only first 2 records
		
		cr.setFirstResult(0);
		cr.setMaxResults(2);
		plist = cr.list();
		for(Products p : plist)
		{
			System.out.println(p.getPid());
			System.out.println(p.getPname());
			System.out.println(p.getQty());
			System.out.println(p.getPrice());
		}
		System.out.println("***************************************************");
		
		//using JPQL
		System.out.println("using JPQL");
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		javax.persistence.criteria.CriteriaQuery<Products> cr2 = cb.createQuery(Products.class);
		Root<Products> rt=cr2.from(Products.class);
		Query q=session.createQuery(cr2.select(rt));
		plist=q.getResultList();
		for(Products p : plist)
		{
			System.out.println(p.getPid());
			System.out.println(p.getPname());
			System.out.println(p.getQty());
			System.out.println(p.getPrice());
		}
		System.out.println("************************************");
		
	}
}
