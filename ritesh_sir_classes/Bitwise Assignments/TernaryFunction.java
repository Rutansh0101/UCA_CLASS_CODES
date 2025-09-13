class TernaryFunction{
  public static int conditional(int x , int y , int z){
    // we are basically trying to convert it into -1 or 0 depending upon the number x, if it is 0 that means the number is zero else it is positive;
    int isZero = ((~x+1) | x) >> 31;
    return (isZero & y) | (~isZero & z);
  }
  public static void main(String[] args){
    System.out.println(conditional(2,4,5));
    System.out.println(conditional(-2,4,5));
    System.out.println(conditional(0,4,5));
  }
}
