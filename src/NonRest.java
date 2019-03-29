import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class NonRest {

     private String divisor;
     private String dividend;

     private int[] M;
     private int[] Mc; //2's complement of M
     private int[] A;
     private int[] Q;

     private ArrayList<AQ> aqArrayList ;

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

         this.aqArrayList = new ArrayList<>();
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

    public ArrayList<AQ> getAqArrayList() {
        return aqArrayList;
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

    public void  compute(int[] a, int[] q) {
        //shift left code
        int length = q.length;
        int temp = q[0];
        for(int i = 0; i < length-1; i++) {
            q[i] = q[i+1];
        }
        System.out.println("Q:");
        System.out.println(Arrays.toString(q));

        length = a.length;

        for (int i = 0; i < length-1; i++) {
            a[i] = a[i+1];
        }
        a[length-1] = temp;

        System.out.println("A: ");
        System.out.println(Arrays.toString(a));

    }

    private int[] binStrToArray(String bNum) {
        String[] split = bNum.split("");
        int length = bNum.length();
        int[] array = new int[length];

        return array;
    }

    private String binArrayToString(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = array.length;

        for (int i = 0; i < length; i++) {
            stringBuilder.append(array[i]);
        }

        return stringBuilder.toString();
    }
}
