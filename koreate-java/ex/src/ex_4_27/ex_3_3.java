package ex_4_27;

public class ex_3_3 {
  public static void main(String[] args) {
    int i, j, temp, min;
    int[] array = new int[10];
    System.out.print("최초의 리스트 : ");
    for (i = 0; i < 10; i++) {
      array[i] = (int) (Math.random() * 100+1);
      System.out.print(array[i] + " ");
      if(i==9) {
        min = array[0];
        System.out.print("\n정렬된 리스트 : ");
        for (i = 0; i < 10; i++) {
          for (j = i + 1; j < 10; j++) {
            if (array[i] > array[j]) {
              temp = array[i];
              array[i] = array[j];
              array[j] = temp;
            }
          }
        }
        for(int k : array) {
          System.out.print(k+" ");
        }
        return;
      }
    }
  }
}
