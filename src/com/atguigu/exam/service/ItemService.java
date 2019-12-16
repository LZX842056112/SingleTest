package com.atguigu.exam.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.atguigu.exam.domain.Item;

//封装了与考试题目访问相关的业务方法
public class ItemService {
	private Item[] items;//题目数组
    private final String ITEM_FILENAME = "./Items.txt";//读取的文件位置
    private final String ANSWER_FILENAME = "./answer.dat";//文件输出的位置
    private final int LINES_PER_ITEM = 6;//每题占用的行数
    public final int TOTAL_ITEMS;//题目数
    
	public ItemService() {
		List<String> list = readTextFile(ITEM_FILENAME);
		TOTAL_ITEMS = list.size() / LINES_PER_ITEM;
		items = new Item[TOTAL_ITEMS];
		
		for (int i = 0; i < TOTAL_ITEMS; i++) {
			String question = list.get(i * LINES_PER_ITEM);
			String[] options = {
					list.get(i * LINES_PER_ITEM + 1),
					list.get(i * LINES_PER_ITEM + 2),
					list.get(i * LINES_PER_ITEM + 3),
					list.get(i * LINES_PER_ITEM + 4)
			};
			char answer = list.get(i * LINES_PER_ITEM + 5).charAt(0);
			items[i] = new Item(question, options, answer);
		}
	}

	/**
	 * 读取指定位置文件的内容到内存中
	 * @Description 
	 * @author lizongxiao
	 * @date 2019年12月15日下午10:05:59
	 * @param filename
	 * @return
	 */
	private List<String> readTextFile(String filename){
		FileReader fr = null;
		BufferedReader br = null;
		List<String> content = new ArrayList<String>();
		
		try {
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			
			String line;
			while((line = br.readLine()) != null){
				if(!line.trim().equals("")) content.add(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return content;
	}
	/**
	 * 返回指定题号的题目
	 * @Description 
	 * @author lizongxiao
	 * @date 2019年12月15日下午10:48:25
	 * @param no
	 * @return
	 */
	public Item getItem(int no){
		if (no <= 0 || no > TOTAL_ITEMS) {
			return null;
		}
		return items[no-1];
	}
	/**
	 * 将所有的答案构成的数组持久化到文件中
	 * @Description 
	 * @author lizongxiao
	 * @date 2019年12月15日下午11:02:58
	 * @param answer
	 */
	public void saveAnswer(char[] answer){
		FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        try {
			fos = new FileOutputStream(ANSWER_FILENAME);
			oos =new ObjectOutputStream(fos);
			oos.writeObject(answer);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
}
