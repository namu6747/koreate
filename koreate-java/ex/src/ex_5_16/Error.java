package ex_5_16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Error {
	public static void main(String[] args) throws FileNotFoundException {
		InputStream fis = new FileInputStream("test.txt");
	}
}
