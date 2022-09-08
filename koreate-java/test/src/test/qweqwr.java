package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class qweqwr {

	public static void main(String[] args) throws FileNotFoundException {

		File text = new File("C:\\Users\\박재민\\Desktop\\workspace\\java\\test\\src\\ttt.txt");
		Scanner sc = new Scanner(text);
		List<String> str = new ArrayList<>();
		while(sc.hasNext()) {
			String t = sc.next();
			str.add(t);
		}
	}

}
