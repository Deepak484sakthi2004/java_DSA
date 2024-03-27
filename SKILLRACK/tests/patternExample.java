package SKILLRACK.tests;

//h               o
//    e       l
//        l
//    e        l
//h                o
public class patternExample {
    public static void main(String[] args) {
        String s = "Josephite";
        pattern(s);
    }

    private static void pattern(String s)
    {
        int nRow = s.length();
        int nCol = s.length();
        int count = 0;
        for(int i=0;i<nRow;i++)
        {
            for(int j=0;j<nCol;j++)
            {
                if(j==i || j==(nRow-1-i))
                    System.out.print(s.charAt(j));
                else
                    System.out.print(" ");
            }
            //System.out.println(s.charAt(i) +" "*(nRow-1-count)+s.charAt(nRow-i-1));
            System.out.println();

        }
    }
}
