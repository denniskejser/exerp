package com.exerp.demo.parser;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.exerp.demo.util.validation.FailFast;

/**
 * The WordParser will break a string into words and remove char's that are not significant 
 */
public class WordParser {
	
	private String[] removeFromStartArr =null;
	private String[] removeFromEndArr =null;

	/**
	 * 
	 * @param stripFromWordStart - optional, can be used to remove not significant chars from beginning of word. Separate by whitespace e.g. "- ' ["
	 * @param stripCharFromWordEnd- optional, can be used to remove not significant chars from end of word. Separate by whitespace e.g. ". , ?"
	 */
	public WordParser(String stripFromWordStart, String stripCharFromWordEnd){
		if (stripFromWordStart != null){
			removeFromStartArr = StringUtils.split(stripFromWordStart);
		}
		if (stripCharFromWordEnd != null){
			removeFromEndArr = StringUtils.split(stripCharFromWordEnd);
		}
	}
	
	public WordParserResult parse(String input){
		FailFast.notNull(input, "parse method will not accept null as input");
		//Split the string into words, strip not significant characters and lower case word
		List<String> tmp = new ArrayList<>();
		for (String word : split(input)) {
			tmp.add(stripWord(word).toLowerCase());
		}
		return new WordParserResult(tmp);
	}
	
	/** 
	 * NOTE: Normally I would consider the code in this method to "small" for method extraction
	 * 
	 * But the code has been extracted to a separate method as I struggled a little with the '--' char sequence in the txt file. 
	 * 
	 * The struggle was about the task definition '...treating hyphen and apostrophe as part of a word' 
	 * I would consider '--' not a hyphen but a separation sequence, but that lead to some differences to the expected output
	 * 
	 * */
	public List<String> split(String input) {
//		input = StringUtils.replace(input, "--", " ");
		ArrayList<String> res = new ArrayList<>();
		for (String s : StringUtils.split(input)) {
			res.add(s);
		}
		return res;
	}
	
	protected String stripWord(String word){
		if (removeFromEndArr != null){
			for (String r : removeFromEndArr){
				if (word.contains(r)){
					String s = StringUtils.substringBefore(word, r);
					word = s;
				}
			}
		}
		if (removeFromStartArr != null){
			for (String r : removeFromStartArr){
				if (word.contains(r))
					word = StringUtils.substringAfter(word, r);
			}
		}
		return word.trim();
	}
	
	
}
