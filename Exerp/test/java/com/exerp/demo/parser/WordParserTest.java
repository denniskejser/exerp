package com.exerp.demo.parser;

import org.junit.Assert;
import org.junit.Test;

import com.exerp.demo.util.io.FileReaderUtil;

public class WordParserTest {


	@Test
	public void resultVerificationTest(){
		String fileAsString = FileReaderUtil.readFileAsString("tempest.txt", System.getProperty(System.getProperty("file.encoding")));
		WordParser wordParser = new WordParser("[", ". ? , ! ; : ]");
		WordParserResult parsed = wordParser.parse(fileAsString);
		
		Assert.assertEquals("and",  514,parsed.getOccurrence("and")); 
		Assert.assertEquals("the", 513, parsed.getOccurrence("the")); 

		Assert.assertEquals("i", 446, parsed.getOccurrence("i")); 
		Assert.assertEquals("to", 324, parsed.getOccurrence("to")); 
		
		Assert.assertEquals("a", 310,parsed.getOccurrence("a")); 
		Assert.assertEquals("of", 295,parsed.getOccurrence("of")); 
		
		Assert.assertEquals("my", 288,parsed.getOccurrence("my")); 
		
		Assert.assertEquals("that", 188,parsed.getOccurrence("that")); 
		Assert.assertEquals("This", 185,parsed.getOccurrence("this")); 

		Assert.assertEquals("you", 211,parsed.getOccurrence("you")); 
	}

	
}
