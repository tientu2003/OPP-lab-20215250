package hust.soict.globalict.garbage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
	public static void main(String[] args) throws IOException  {
		String filename = "test.exe"; //file 100KB
		byte[] inputBytes = { 0 };

		long startTime, endTime;
		// operator +
		inputBytes = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		String outputString = "";
		for(byte b: inputBytes) {
			outputString += (char)b;
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		
		// String Buffer
		
		startTime = System.currentTimeMillis();
		StringBuilder outputStringBuilder = new StringBuilder();
		for (byte b: inputBytes) {
			outputStringBuilder.append((char)b); 
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}	
}