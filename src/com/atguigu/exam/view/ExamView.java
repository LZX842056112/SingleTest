package com.atguigu.exam.view;

import java.util.Scanner;

// 为应用程序的主控类，负责与用户交互，完成考试及成绩查询功能
public class ExamView {
	/**
	 * 获取用户输入的指定字符
	 * @Description 
	 * @author lizongxiao
	 * @date 2019年12月15日下午11:15:51
	 * @return
	 */
	public char getUserAction(){
		char[] validKey = { '1', '2', '3', 'A', 'B', 'C', 'D', 'F', 'N', 'P','Y'};
		char key = 0;
		Scanner scanner  = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str = scanner.next();
			if (str.length() != 1) {
				continue;
			}
			str = str.toUpperCase();
			key = str.charAt(0);
			
			for (char k : validKey) {
				if (k == key) {
					return key;
				}
			}
		}
		return key;
	}
	
	/**
	 * 显示指定的考题内容
	 * @Description 
	 * @author lizongxiao
	 * @date 2019年12月16日下午2:33:15
	 * @param no
	 */
	public void displayItem(int no){
		
	}
	
}
