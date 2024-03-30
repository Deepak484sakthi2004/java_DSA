package Striver.RecursionAndBacktracking.Easy;

// https://leetcode.com/problems/string-to-integer-atoi/description/
public class atoi {
    public static void main(String[] args) {
        String s = "  +     4 454 3 34 12 454 4 3 4 8";
        atoi obj = new atoi();
        System.out.println(obj.atoiMethod(s));
    }
    private int atoiMethod(String s)
    {
            int len = s.length();
            boolean isNegative = false;
            for(int ind = 0;ind<len;ind++)
            {
                if(s.charAt(ind)=='-') {
                    isNegative = true;
                    break;
                }
            }

            int out = 0;
            for(int ind=0;ind<len;ind++) {

                if (Character.isDigit(s.charAt(ind))) out = out * 10 + Integer.parseInt(String.valueOf(s.charAt(ind)));

                if (out > Integer.MAX_VALUE / 10 || out < Integer.MIN_VALUE / 10) {
                    return isNegative ? - out : out;
                }
            }

        return isNegative ? - out : out;
    }
    }

