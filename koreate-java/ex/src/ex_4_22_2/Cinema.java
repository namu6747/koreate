package ex_4_22_2;
import java.util.Scanner;

public class Cinema {
  //field
  String[][] seats;
  Scanner sc = new Scanner(System.in);
  char column;
  int row;
  char finish;
  
  //constructor
  public Cinema() {
    seats = new String[10][10];
  };
  
  //method
  void seat(){
    System.out.println("              Screen");
    for(int i=1; i<=10; i++) {
      System.out.print("["+i+"]");
      
    }
    System.out.println(" [행]");
    for(int i=0; i<10; i++) {
      for(int j=0; j<10; j++) {
        if(seats[i][j] == null) {seats[i][j] = "□";}
        System.out.print("["+seats[i][j]+"]");
      }
      System.out.println(" ["+(char)(i+65)+("열]"));
    }
    System.out.println();
    System.out.println();
  }

  void res(){
    System.out.println("예약하실 좌석의 열을 입력해주세요.");
    column = sc.next().toUpperCase().charAt(0);
    System.out.println("입력한 열: "+column);
    System.out.println("예약 하실 좌석의 행 번호를 입력해주세요 >");
    row = sc.nextInt();
    System.out.println("선택하신 좌석은 : "+column+"열 "+row+"행입니다.");
    System.out.println("예약 완료 하시겠습니까? Y/N");
    finish = sc.next().toUpperCase().charAt(0);
  }
  
  
}
