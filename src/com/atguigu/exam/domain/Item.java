package com.atguigu.exam.domain;

import java.util.Arrays;
//考试题目类,每个Item对象对应一道题目
public class Item {
	
	private String question;
    private String[] options;
    private char answer;
    
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String[] getOptions() {
		return options;
	}
	public void setOptions(String[] options) {
		this.options = options;
	}
	public char getAnswer() {
		return answer;
	}
	public void setAnswer(char answer) {
		this.answer = answer;
	}
	public Item(String question, String[] options, char answer) {
		this.question = question;
		this.options = options;
		this.answer = answer;
	}
	@Override
	public String toString() {
        return question + "\n" +
               options[0] + "\n" +
               options[1] + "\n" +
               options[2] + "\n" +
               options[3] + "\n标准答案：" + answer + "\n";
    }
}
