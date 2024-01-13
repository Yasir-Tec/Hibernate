package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.dao.userDao;
import com.demo.dao.userDaoImpl;
import com.demo.model.Address;
import com.demo.model.MyUser;

public class userServiceImpl implements userService{

	
	private userDao udao;
	public userServiceImpl() {
		udao = new userDaoImpl();
	}
	
	
	public void addNewUser()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enetr user id");
		int uid=sc.nextInt();
		System.out.println("enetr user name");
		String uname=sc.next();
		System.out.println("enetr address id");
		int aid=sc.nextInt();
		System.out.println("enetr street");
		String street=sc.next();
		System.out.println("enetr city");
		String city=sc.next();
		MyUser uobj = new MyUser(uid,uname,new Address(aid,street,city));
		udao.save(uobj);
		
	}


	public List<MyUser> getAllUsers() {
		
		
		return udao.getAllUsers();
	}


	public MyUser getById(int uid) {

		return udao.findById(uid);
	}


	public boolean removeById(int uid) 
	{

		return udao.removeById(uid);
	}


	public boolean modifyById(int uid, String unm, String street) {
	
		return udao.updateById(uid,unm,street);
	}


	public List<MyUser> sortById() {
	
		return udao.sortById();
	}


	public void closeMySessionFactory() {
		
		udao.closeSessionFactory();
		
	}

}
