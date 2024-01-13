package com.demo.dao;

import java.util.List;

import com.demo.model.MyUser;

public interface userDao {

	void save(MyUser uobj);

	List<MyUser> getAllUsers();

	MyUser findById(int uid);

	boolean removeById(int uid);

	boolean updateById(int uid, String unm, String street);

	List<MyUser> sortById();

	void closeSessionFactory();

}
