package ex_4_22_2;
import java.util.Scanner;

public class _06 {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[][] seats = new String[10][10];
    char column;
    int row;
    char finish;
    
    while(true) {
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
      
      System.out.println("예약하실 좌석의 열을 입력해주세요.");
      column = sc.next().toUpperCase().charAt(0);
      System.out.println("입력한 열: "+column);
      System.out.println("예약 하실 좌석의 행 번호를 입력해주세요 >");
      row = sc.nextInt();
      System.out.println("선택하신 좌석은 : "+column+"열 "+row+"행입니다.");
      System.out.println("예약 완료 하시겠습니까? Y/N");
      finish = sc.next().toUpperCase().charAt(0);
      
      String mySeat = seats[column-65][row-1];
      
      if(finish == 'Y') {
        if(mySeat.equals("□")) {
          seats[column-65][row-1] = "■"; 
          System.out.println("              Screen");
          for(int i=1; i<=10; i++) {
            System.out.print("["+i+"]");
            
          }
          System.out.println(" [행]");
          for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
              System.out.print("["+seats[i][j]+"]");
            }
            System.out.println(" ["+(char)(i+65)+("열]"));
          }
          break;
          
        }else if(mySeat == "■") {
          System.out.println("이미 예약이 완료된  좌석입니다.\n다시 선택해주세요.");
          System.out.println("              Screen");
          for(int i=1; i<=10; i++) {
            System.out.print("["+i+"]");
            
          }
          System.out.println(" [행]");
          for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
              System.out.print("["+seats[i][j]+"]");
            }
            System.out.println(" ["+(char)(i+65)+("열]"));
          }
          System.out.println("예약하실 좌석의 열을 입력해주세요.");
          column = sc.next().toUpperCase().charAt(0);
          System.out.println("입력한 열: "+column);
          System.out.println("예약 하실 좌석의 행 번호를 입력해주세요 >");
          row = sc.nextInt();
          System.out.println("선택하신 좌석은 : "+column+"열 "+row+"행입니다.");
          System.out.println("예약 완료 하시겠습니까? Y/N");
          finish = sc.next().toUpperCase().charAt(0);
          break;
        }
      }else{
        break;
      }
    }
  }
}
