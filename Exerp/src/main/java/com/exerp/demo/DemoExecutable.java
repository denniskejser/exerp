package com.exerp.demo;

import java.util.List;

import com.exerp.demo.parser.WordOccurrence;
import com.exerp.demo.parser.WordParser;
import com.exerp.demo.parser.WordParserResult;
import com.exerp.demo.util.io.FileReaderUtil;

public class DemoExecutable {

	/** 
	 * The main program to execute
	 * 
	 * The programs most essential parts (parser+occurrence count) are tested in the WordParserTest
	 * 
	 * */
	public static void main (String [] args){
		
		String fileAsString = FileReaderUtil.readFileAsString("tempest.txt", System.getProperty(System.getProperty("file.encoding")));

		WordParser wordParser = new WordParser("[", ". ? , ! ; : ]");
		
		WordParserResult parsed = wordParser.parse(fileAsString);

		List<WordOccurrence> wordOccurences = parsed.getWordOccurences(true,10);

		for (WordOccurrence wordOccurence : wordOccurences) {
			System.out.println(wordOccurence);
		}
		
	}
}
