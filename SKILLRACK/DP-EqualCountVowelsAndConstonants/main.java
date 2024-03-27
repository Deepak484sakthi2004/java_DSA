import java.util.Scanner;

class main
{
    public static void main(String[] args)
    {
        Scanner z = new Scanner(System.in);
        String input = z.nextLine();
        int subsLength = z.nextInt();

        System.out.println(equalCountVowelsConsonents(subsLength, input));
    }

    private static int equalCountVowelsConsonents(int n, String component)
    {
        int out = 0;
        int len = component.length();
        
        
        for(int i=0;i<len;i++)
        {
            int equalityCount=Integer.MAX_VALUE;
            if(i+4<len)
            {
                for(int j = i;j<i+4;j++)
                {
                    // if it is vowel increase the count else decrease!! 
                    char ch  = component.charAt(j);
                    
                    if(isVowel(ch)) 
                    {
                        if(equalityCount==Integer.MAX_VALUE) equalityCount=1;
                        else equalityCount++;
                      //  System.out.println("Vowel "+ch);
                    }

                    else
                    {
                  //      System.out.println("Consonent "+ch);
                        if(equalityCount==Integer.MAX_VALUE) equalityCount=-1;
                        else equalityCount--;
                    } 
                }
                //System.out.println(equalityCount+"\n\n--------------------------------");
                
                if(equalityCount==0) out++;
            }
        }

        return out;
    }

    private static boolean isVowel(char c)
    {
        String s = "aeiouAEIOU";

        return s.contains(String.valueOf(c));
    }


}