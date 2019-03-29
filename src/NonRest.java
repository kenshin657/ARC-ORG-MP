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
        q[length-1] = 99; // temp value only

        System.out.println("Q:");
        System.out.println(Arrays.toString(q));

        length = a.length;

        for (int i = 0; i < length-1; i++) {
            a[i] = a[i+1];
        }
        a[length-1] = temp;

        System.out.println("A: ");
        System.out.println(Arrays.toString(a));

        //end of shift to the left code

        //start of A-M || A+M code
        if(a[0] == 0) {
            String M = binArrayToString(this.Mc);
            String A = binArrayToString(a);
            System.out.println(M + "\n" + A);
            A = addBinaries(A, M);

            System.out.println(A);

            this.A = binStrToArray(A);
            int size = this.Q.length;

            if(this.A[0] == 0)
                q[size-1] = 1;
            else
                q[size-1] = 0;
        }
        else {
            String M = binArrayToString(this.M);
            String A = binArrayToString(a);

            A = addBinaries(A, M);
            this.A = binStrToArray(A);

            this.A = binStrToArray(A);
            int size = this.Q.length;

            if(this.A[0] == 0)
                q[size-1] = 1;
            else
                q[size-1] = 0;
        }

        this.Q = q;

        AQ aq = new AQ();
        aq.setA(this.A);
        aq.setQ(this.Q);

        aqArrayList.add(aq);

    }

    private int[] binStrToArray(String bNum) {
        String[] split = bNum.split("");
        int length = bNum.length();
        int[] array = new int[length];

        for(int i = 0; i < length; i++) {
            array[i] = Integer.parseInt(split[i]);
        }

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

    //https://www.geeksforgeeks.org/program-to-add-two-binary-strings/
    private String addBinaries(String a, String b) {
        String result = "";

        int s = 0;

        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1)
        {

            s += ((i >= 0)? a.charAt(i) - '0': 0);
            s += ((j >= 0)? b.charAt(j) - '0': 0);

            result = (char)(s % 2 + '0') + result;

            s /= 2;

            i--; j--;
        }

        return result;
    }
}
