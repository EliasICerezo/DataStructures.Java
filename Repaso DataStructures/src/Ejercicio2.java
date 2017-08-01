import Stack.ArrayStack;
import Stack.Stack;

public class Ejercicio2 {
	private final static String OPEN_PARENTHESES = "{[(";
	private final static String CLOSED_PARENTHESES = "}])";

	public static boolean isOpenParentheses(char c) {
		return OPEN_PARENTHESES.indexOf(new Character(c).toString()) >= 0;
	}

	public static boolean isClosedParentheses(char c) {
		return CLOSED_PARENTHESES.indexOf(new Character(c).toString()) >= 0;
	}

	public static boolean match(char x, char y) {
		return OPEN_PARENTHESES.indexOf(new Character(x).toString()) == CLOSED_PARENTHESES
				.indexOf(new Character(y).toString());
	}

	public static boolean wellBalanced(String exp, Stack<Character> s) {
		for (Character ch : exp.toCharArray()) {
			if (isOpenParentheses(ch)) {
				s.push(ch);
			} else if (isClosedParentheses(ch)) {
				try{
				if (match(ch, s.top())) {
					s.pop();
				} else {
					return false;
				}
				}catch(Exception e){
					return false;
				}
			}

		}
		return s.isEmpty();
	
	}

	public static void main(String[] args) {
		
		Stack<Character> s = new ArrayStack<>();
		System.out.println(wellBalanced(args[0], s));
	}
}
