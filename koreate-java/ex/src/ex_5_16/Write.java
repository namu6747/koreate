package ex_5_16;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Write {

	public static void main(String[] args) throws IOException {
		String dir = "C:\\Test";
		String fileName = "test.txt";
		File file = new File(dir,fileName);
		
		Writer writer = new FileWriter(file,true);
		writer.write("최기근");
		System.out.println("출력완료");
		writer.flush();
		writer.close();
		
		
	}

}
