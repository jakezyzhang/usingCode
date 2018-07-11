package com.zzy.test;

import java.util.ArrayList;
import java.util.List;

import com.zzy.entity.Address;

import com.google.gson.Gson;
import com.zzy.entity.Book;
import com.zzy.entity.User;

public class Test {
	public static void main(String[] args) {
//		List<Book> list = new ArrayList<Book>();
//		list.add(new Book(1,"java","sun",55.5));
//		list.add(new Book(2,"c#","Microsoft",45.5));
//		list.add(new Book(3,"c++","Microsoft",35.5));
//		list.add(new Book(4,".net","Microsoft",65.5));
		Gson gson = new Gson(); 
//		System.out.println(gson.toJson(list));
		User u = new User("张三", "female", new Address(1,"dg","jd"));
		System.out.println(gson.toJson(u));
	}
}
