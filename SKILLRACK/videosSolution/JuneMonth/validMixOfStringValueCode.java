package SKILLRACK.videosSolution.JuneMonth;
// given three strings, the third strings can be a ordered combination of first two
// strings.
// Eg: str1 = "mro" ; str2="ack"
// str3 = "marocko"

import org.w3c.dom.ls.LSOutput;// kool, boot, kbootool
// mano , kon , maknoon
// orderly increase the index, if both the index characters are same, try with
// one, if not satisfied try with other one!!
// return the combinaation is satisfied or not
public class validMixOfStringValueCode {
    public static void main(String[] args) {
        String s1 = "kool";
        String s2 = "boot";
        String s3 = "kbootool";
        validMixOfStringValueCode obj = new validMixOfStringValueCode();
        System.out.println(obj.rec(s1, s2, s3, s1.length()-1, s2.length()-1, s3.length()-1));
    }

    private boolean isValid(String s1, String s2, String s3, int ind1, int ind2, int ind3) {
        while (ind3 < s3.length()) {
            if (ind1 < s1.length() && ind2 < s2.length() && s2.charAt(ind2) == s3.charAt(ind3) && s1.charAt(ind1) == s3.charAt(ind3)) {
                if (isValid(s1, s2, s3, ind1 + 1, ind2, ind3 + 1)) return true;
                else return isValid(s1, s2, s3, ind1, ind2 + 1, ind3 + 1);
            } else if (ind2 < s2.length() && s2.charAt(ind2) == s3.charAt(ind3)) {
                ind2++;
                ind3++;
            } else if (ind1 < s1.length() && s1.charAt(ind1) == s3.charAt(ind3)) {
                ind1++;
                ind3++;
            } else {
                return false; // If none of the conditions satisfy, return false
            }
        }
        return true;
    }
    private boolean rec(String s1, String s2, String s3, int ind1, int ind2, int ind3)
    {
        if(ind3<0) return true;

        if(ind1>=0 && ind2>=0 && s1.charAt(ind1)==s3.charAt(ind3) && s2.charAt(ind2)==s3.charAt(ind3))
        {
            if(rec(s1,s2,s3,ind1-1,ind2,ind3-1)) return true;
            else return rec(s1,s2,s3,ind1,ind2-1,ind3-1);
        }
        else if(ind1>=0 && s1.charAt(ind1)==s3.charAt(ind3))
        {
            return rec(s1,s2,s3,ind1-1,ind2,ind3-1);
        }
        else if(ind2>=0 && s2.charAt(ind2)==s3.charAt(ind3))
        {
            return rec(s1,s2,s3,ind1,ind2-1,ind3-1);
        }
        else return false;

        //return true;
    }
}

