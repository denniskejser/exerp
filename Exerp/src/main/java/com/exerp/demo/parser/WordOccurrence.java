package com.exerp.demo.parser;

public class WordOccurrence implements Comparable<WordOccurrence>{

	private String word;
	private int occurrence = 0;
	
	public WordOccurrence(String word){
		this.word=word;
	}

	public String getWord() {
		return word;
	}

	public int getOccurrence() {
		return occurrence;
	}

	public void increment(){
		occurrence++;
	}
	
	@Override
	public String toString(){
		return word + "(" + occurrence +")";
	}
	@Override
	public int compareTo(WordOccurrence o) {
		return new Integer(occurrence).compareTo(o.occurrence);
	}
	
	
}
