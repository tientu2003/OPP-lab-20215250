package hust.soict.globalict.garbage;

import java.io.*;
import java.nio.file.StandardOpenOption;
import java.nio.file.Files;
import java.nio.file.Paths;
public class NoGarbage {

	public static void main(String[] args) throws IOException  {
		String filename = "test.exe";
		byte[] outputBytes = new byte[1024*100];
		// create a 100 KB file
			Files.write(Paths.get(filename), outputBytes);

	}
}