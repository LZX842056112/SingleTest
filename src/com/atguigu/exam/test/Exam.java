package com.atguigu.exam.test;

import com.atguigu.exam.domain.Item;
import com.atguigu.exam.service.ItemService;

//程序入口类
public class Exam {
	public static void main(String[] args) {
		ItemService itemService = new ItemService();
		Item item = itemService.getItem(3);
		System.out.println(item);
	}
}
