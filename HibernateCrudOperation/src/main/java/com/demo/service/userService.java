package com.demo.service;

import java.util.List;

import com.demo.model.MyUser;

public interface userService {

	void addNewUser();

	List<MyUser> getAllUsers();

	MyUser getById(int uid);

	boolean removeById(int uid);

	boolean modifyById(int uid, String unm, String street);

	List<MyUser> sortById();

	void closeMySessionFactory();

}
