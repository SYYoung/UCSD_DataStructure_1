package Week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        Boolean matchOrNot = true;
        int	mismatchPos = 1;

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
            		opening_brackets_stack.push(new Bracket(next, position));
            }

            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here
            		matchOrNot = opening_brackets_stack.pop().Match(next);
            		if (!matchOrNot) {
            			mismatchPos = position+1;
            			break;
            		}
            }
        }
        
        // Printing answer, write your code here
        if (opening_brackets_stack.empty()) {
        		// the stack is empty. all the brackets are matched
        		System.out.println("Success");
        }
        else {
        		// there is mismatch
        		System.out.println(mismatchPos);
        }

    }
}
