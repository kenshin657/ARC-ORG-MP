import java.util.Arrays;
import java.util.Iterator;

public class NonRest {

     private String divisor;
     private String dividend;

     private int[] M;
     private int[] Mc; //2's complement of M
     private int[] A;
     private int[] Q;

     public NonRest(String divisor, String dividend) {

         String[] split = dividend.split("");
         int length = split.length;
         int[] binary = new int[length];

         for(int i = 0; i < length; i++) {
             binary[i] = Integer.parseInt(split[i]);
         }

         this.Q = binary;

         this.A = new int[length+1];
         this.M = new int[length+1];
         this.Mc = new int[length+1];
         for (int i = 0; i < length+1; i++) {
             this.A[i] = 0;
             this.M[i] = 0;
             this.Mc[i] = 0;
         }
        split = divisor.split("");
         length = split.length;
         int mlenght = this.M.length;
         int temp = length;

         for(int i = 0; i < temp; i++) {
             this.M[mlenght-1] = Integer.parseInt(split[length-1]);
             mlenght--;
             length--;
         }
         StringBuilder stringBuilder = new StringBuilder();
         for(int i = 0; i < this.M.length; i++) {
             stringBuilder.append(this.M[i]);
         }

         String twocomp = stringBuilder.toString();

         StringBuffer stringBuffer = new StringBuffer(twocomp);
         twocomp = convert2sComplement(stringBuffer);

         split = twocomp.split("");
         length = split.length;

         for (int i = 0; i < length; i++) {
             this.Mc[i] = Integer.parseInt(split[i]);
         }

        /* split = twocomp.split("");
         length = split.length;
         int mclenth = this.Mc.length;
         temp = length;

         for (int i = 0; i < temp; i++) {
             this.Mc[mclenth-1] = Integer.parseInt(split[length-1]);
             mclenth--;
             length--;
         }*/

     }

    public int[] getM() {
        return M;
    }

    public int[] getMc() {
        return Mc;
    }

    public int[] getA() {
        return A;
    }

    public int[] getQ() {
        return Q;
    }


    /*https://www.geeksforgeeks.org/efficient-method-2s-complement-binary-string/*/
    private String convert2sComplement(StringBuffer str) {
         int length = str.length();
         int i;

         for ( i = length - 1; i >= 0; i--) {
             if (str.charAt(i) == '1')
                 break;
         }

         if (i == -1)
             return "1" + str;

         for (int k = i-1; k >= 0; k--) {
             if (str.charAt(k) == '1')
                 str.replace(k, k+1, "0");
             else
                 str.replace(k, k+1, "1");
         }

         return str.toString();
    }
}
