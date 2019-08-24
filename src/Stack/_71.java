package Stack;

import org.junit.Test;

import java.util.Stack;

public class _71 {
    @Test
    public void test() {
        System.out.println(simplifyPath1("/......"));
    }

    public String simplifyPath(String path) {
        if("/.".equals(path)|| "/..".equals(path)) {
            return path;
        }
        Stack<Character> stack = new Stack<>();
        stack.push('/');
        for (int i = 1; i < path.length(); i++) {
            char ch = path.charAt(i);
            if ((ch != '.' && ch != '/') || (ch == '/' && stack.peek() != '/'&&stack.peek()!='.')||(ch=='.'&&stack.peek()=='/')){
                System.out.println("进栈");
                stack.push(ch);
                continue;
            }

            if (ch == '.' && stack.peek() == '.') {
               System.out.println("返回上一层");
                int cnt = 0;
                while (stack.size()>1&&(stack.peek() != '/' || cnt !=1)) {
                    if (stack.pop() == '/') {
                        cnt++;
                    }
                }
                continue;
            }if (ch == '/' && stack.peek() == '.') {
                System.out.println("出栈");
                stack.pop();
            }
            System.out.println(stack);
        }
        if (stack.size() > 1 && (stack.peek() == '/'||stack.peek()=='.')) {
            stack.pop();
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }
    public String simplifyPath1(String path) {
        String[] strs = path.split("/");
        String[] stack = new String[strs.length];
        int cur = 0;
        for(String str:strs){
            switch(str){
                case "..": cur=Math.max(cur-1, 0); break;
                case ".": case "": break;
                default: stack[cur]=str; cur++; break;
            }
        }
        StringBuilder sb = new StringBuilder("/");
        for(int i=0; i<cur; i++) {
            sb.append(stack[i]).append("/");
        }
        String s = sb.toString().substring(0, sb.length()-1);
        return s.length()==0?"/":s;
    }
}
