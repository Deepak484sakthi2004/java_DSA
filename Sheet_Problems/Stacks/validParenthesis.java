package Stacks;
import java.util.Stack;

public class validParenthesis {
    public static void main(String[] args) {

        validParenthesis vp = new validParenthesis();
        System.out.println(vp.isValid("[{()]"));
    }

    public boolean isValid(String s) {

        boolean check=false;

        Stack<Character> st =new Stack<>();

        for(char ch:s.toCharArray())
        {
            if(ch=='('|| ch=='{' || ch=='[')
                st.push(ch);
            else {
                if(st.empty()) return false;
                // in order to handle the case   String s = ")(){}"; the charAt(0)='(',
                // and the stack is empty the if below wouldn't run...
                if(!st.empty()){
                char validate;
                switch(ch)
                {
                    case '}':
                         validate=st.pop();
                        if(!(validate=='{'))
                         return false;
                        break;

                    case ']':
                         validate = st.pop();
                        if(!(validate=='['))
                            return false;
                            break;
                    case ')':
                        validate = st.pop();
                        if(!(validate=='('))
                            return false;
                            break;
                }}
            }
        }

        return st.empty();
    }
}
