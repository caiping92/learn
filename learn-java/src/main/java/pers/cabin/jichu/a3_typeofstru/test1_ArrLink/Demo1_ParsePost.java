package pers.cabin.jichu.a3_typeofstru.test1_ArrLink;

/**
 * 后缀表达式转换
 *
 * @author caiping
 */
public class Demo1_ParsePost {

    private Demo1_StackX theStack;
    private String input;

    // --------
    public Demo1_ParsePost(String input) {
        super();
        this.input = input;
    }

    public int doParse() {

        theStack = new Demo1_StackX(20); // 新的栈
        char ch;
        int j;
        int num1, num2, interAns = 0;

        for (j = 0; j < input.length(); j++) {
            ch = input.charAt(j);
            theStack.displayStack(" " + ch + " ");
            if (ch >= '0' && ch <= '9') {
                theStack.push(ch);
            } else {
                num2 = theStack.pop();
                num1 = theStack.pop();
                switch (ch) {
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                    default:
                        interAns = 0;
                } // End Switch
                theStack.push(interAns);    //放入结果
            }    //End else
        }    //End for
        interAns = theStack.pop();
        return interAns;
    }    //End doParse

}
