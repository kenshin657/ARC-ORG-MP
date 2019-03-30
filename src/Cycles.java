import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Cycles {
    private JPanel panel1;
    private JTextArea aqTextArea;
    private ArrayList<AQ> aqArrayList;


    public Cycles(ArrayList<AQ> list) {
        this.aqArrayList = list;

        aqTextArea.setText("Cycles List\n\n\tA\t\tQ\n");


        for (int i = 0; i < aqArrayList.size(); i++) {
            String data = "(" + (i+1) + ")\t" + aqArrayList.get(i).getA() + "\t\t" + aqArrayList.get(i).getQ() + "\n";
            aqTextArea.append(data);
        }
    }



    public JPanel getPanel1() {
        return panel1;
    }
}
