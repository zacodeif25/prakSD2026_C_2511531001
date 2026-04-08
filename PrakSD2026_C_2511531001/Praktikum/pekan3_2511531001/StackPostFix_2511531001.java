package pekan3_2511531001;
import java.util.*;
public class StackPostFix_2511531001 {
public static int postfixEvaluate_1001 (String expression_1001) {
	Stack<Integer> s_1001 = new Stack <Integer> ();
	Scanner input_1001 = new Scanner (expression_1001);
	while (input_1001.hasNext()) {
		if (input_1001.hasNextInt()) {
			s_1001.push(input_1001.nextInt());
		}else {
			String operator_1001 = input_1001.next();
			int operand2_1001 = s_1001.pop ();
			int operand1_1001 = s_1001.pop();
			if(operator_1001.equals("+")) {
				s_1001.push (operand1_1001 + operand2_1001);	
			} else if (operator_1001.equals("-")) {
				s_1001.push(operand1_1001 - operand2_1001);
			}  else if (operator_1001.equals("*")) {
				s_1001.push(operand1_1001 * operand2_1001);
			} else {
				s_1001.push(operand1_1001 / operand2_1001);
			}
		}
	}
	input_1001.close();
	return s_1001.pop();
}

public static void main (String [] args) {
	System.out.println("hasil postfix= "+ postfixEvaluate_1001("5 2 4 * + 7 -"));
}
}
