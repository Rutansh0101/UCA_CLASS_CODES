import java.util.*;

class BangImplementation {

  public static int bang(int x) {
    int isZero = (x | (~x + 1)) >> 31;
    return (isZero & 1) ^ 1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(bang(n));
    sc.close();
  }
}
