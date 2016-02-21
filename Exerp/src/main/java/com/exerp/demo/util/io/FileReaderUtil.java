package com.exerp.demo.util.io;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;

public class FileReaderUtil {

	public static String readFileAsString(String fileName,String encoding){
		StringWriter writer = new StringWriter();
		try {
			IOUtils.copy(FileReaderUtil.class.getClassLoader().getResourceAsStream(fileName), writer, encoding);
			return writer.toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
}
