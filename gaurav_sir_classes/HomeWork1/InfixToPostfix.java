import java.util.*;

class InfixToPostfix{

	static int precedence(char ch){
		switch(ch){
			case '+':
			case '-':	return 1;
			case '*':
			case '/':	return 2;
		}
		return -1;
	}

	public static String convertInfixToPostfix(String infix){
		StringBuilder postfix = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		for(char ch: infix.toCharArray()){
			// If operand, add to result:
			if(Character.isLetterOrDigit(ch)){
				postfix.append(ch);
			}

			// If '(', push to stack
			else if(ch == '('){
				stack.push(ch);
			}
			// If ')', pop till '('
			else if(ch == ')'){
				while(!stack.isEmpty() && stack.peek() != '('){
					postfix.append(stack.pop());
				}
				if(!stack.isEmpty() && stack.peek() == '('){
					stack.pop();
				}
			}
			// If operator
			else{
				while(!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())){
					postfix.append(stack.pop());
				}
				stack.push(ch);
			}
		}

		while(!stack.isEmpty()){
			postfix.append(stack.pop());
		}

		return postfix.toString();
	}

	public static void main(String[] args){
		// Scanner for Input:
		Scanner sc = new Scanner(System.in);

		// Input String:
		String infix = sc.nextLine();

		// Converted into postfix:
		String postfix = convertInfixToPostfix(infix);

		// Printing the output:
		System.out.println(postfix);
		return;
	}
}
