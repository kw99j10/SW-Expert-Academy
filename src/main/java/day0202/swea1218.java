package day0202;

import java.util.Scanner;
import java.util.Stack;

public class swea1218 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++) {

            int n = sc.nextInt();
            String s = sc.next(); //n 길이 만큼의 문자열
            int answer = 0;
            Stack<Character> st = new Stack<>();
            boolean right = true;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(' || c == '[' || c == '{' || c == '<') {
                    st.push(c);
                }
                else{
                    if (st.isEmpty()) {
                        if (c == ')' || c == ']' || c == '}' || c == '>') {
                            right = false;
                            break; //유효하지 않은 문자열
                        }
                    }
                    else{
                        if ((c==')' && st.peek()=='(')||(c=='}' && st.peek()=='{')
                        ||(c==']' && st.peek()=='[')||(c=='>' && st.peek()=='<')){
                            st.pop();
                        }
                        else{
                            right = false;
                            break;
                        }
                    }
                }
            }
            if (right && st.isEmpty()) {
                answer = 1; //유효한 문자열 & 괄호 짝 맞을 경우
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}
