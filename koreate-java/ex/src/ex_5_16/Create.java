package ex_5_16;

import java.io.File;
import java.io.IOException;

public class Create {

	public static void main(String[] args) throws IOException {
//		String dir = "C:\\Test";
//		File file1 = new File(dir);
//
//		if (!file1.isDirectory()) {
//			file1.mkdirs();
//			System.out.println("디렉토리 생성 완료");
//		}
//		
		
		
		String fileName = "C:\\Test\\test.txt";
		File file2 = new File(fileName);
//		if (!file2.exists()) {
//			file2.createNewFile();
//			System.out.println("파일 생성 완료");
//		}
		
		file2.getParentFile().mkdirs();
		file2.createNewFile();

	}

}
