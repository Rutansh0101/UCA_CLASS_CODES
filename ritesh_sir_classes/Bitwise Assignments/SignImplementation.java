import java.util.*;

class SignImplementation {
    static public int getSign(int number) {
	// (number >> 31) moves the sign bit to the right, which tells whether its negative or positive(including zero);
	// (~number + 1) reverts all the bits and add 1 to make it (~n);
	// and by doing AND operation, we are basically storing 1 if number is positive and 0 if number is zero or negative;

	int negative = (number >> 31);
	int positive = (((~number + 1) >> 31) & 1);
	return negative | positive;
    }

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int number = sc.nextInt();
	System.out.println(getSign(number));
	sc.close();
    }
}
