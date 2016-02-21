package com.exerp.demo.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordParserResult {
	private List<String> lowerCasedWords;
	private HashMap<String, WordOccurrence> occurrenceMap = null; 

	public WordParserResult(List<String> lowerCasedWords) {
		this.lowerCasedWords = lowerCasedWords;
		initWordOccurence();
	}

	private void initWordOccurence() {
			HashMap<String, WordOccurrence> tmp = new HashMap<String, WordOccurrence>();
			for (String word : getWords()) {
				WordOccurrence o = tmp.get(word);
				if (o == null) {
					o = new WordOccurrence(word);
					tmp.put(word, o);
				}
				o.increment();
			}
			occurrenceMap = tmp;
	}

	
	public List<String> getWords() {
		return lowerCasedWords;
	}
	
	public Collection<String> getUniqueWords(){
		return new HashSet<>(lowerCasedWords);
	}

	public boolean hasWord(String word){
		return lowerCasedWords.contains(word.toLowerCase());
	}

	public int getOccurrence(String word){
		WordOccurrence wordOccurence = occurrenceMap.get(word);
		return wordOccurence == null ? 0 : wordOccurence.getOccurrence();
	}
	
	public List<WordOccurrence> getWordOccurences(boolean desc, int maxReturnSize) {

		ArrayList<WordOccurrence> res = new ArrayList<>(occurrenceMap.values());
		Collections.sort(res);
		if (desc) {
			Collections.reverse(res);
		}
		
		return res.subList(0, Math.min(maxReturnSize, res.size()));
	}

	
}
