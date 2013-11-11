package org.andy.song;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HtmlCompressorTest extends TestCase {

	HtmlCompressor htmlCompressor;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		htmlCompressor = new HtmlCompressor();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test()  throws Exception{
		File f = new File("e:\\login.jsp");
		InputStreamReader inReader = new InputStreamReader(new FileInputStream(f),"UTF-8");
		java.io.
		BufferedReader inLine = new BufferedReader(inReader);
		String line = null;
		StringBuffer sb = new StringBuffer(); 
		while((line=inLine.readLine())!=null){
			sb.append(line + "\r\n");	
		}
		inReader.close();
		inLine.close();
		
		String text = sb.toString();
		
		String result = new HtmlCompressor().compress(text);
		File file = new File("e:\\login2.jsp");
		OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file,false),"UTF-8");
		writer.write(result);
		writer.flush();
		writer.close();
		
	}

}
