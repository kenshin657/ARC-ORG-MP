import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Menu {
    private JPanel panel1;
    private JTextField dividendField;
    private JTextField aField;
    private JButton solveButton;
    private JButton seeCyclesButton;
    private JLabel inputLabel;
    private JLabel ansLabel;
    private JTextField divisorField;
    private JTextField qField;

    private NonRest start;
    private ArrayList<AQ> aqArrayList;


    public Menu() {


        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start = new NonRest(divisorField.getText(), dividendField.getText());
                int length = start.getQ().length;

                for (int i = 0; i < length; i++) {
                    start.compute(start.getA(), start.getQ());
                }

                int size = start.getAqArrayList().size();

                aField.setText(start.getAqArrayList().get(size-1).getA());
                qField.setText(start.getAqArrayList().get(size-1).getQ());

                aqArrayList = start.getAqArrayList();
            }
        });
        seeCyclesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cycles cycles = new Cycles(aqArrayList);

                JFrame jFrame = new JFrame("Cycles");
                jFrame.setContentPane(cycles.getPanel1());
                //jFrame.setSize(1000, 1000);
                jFrame.pack();
                jFrame.setLocationRelativeTo(null);
                jFrame.setVisible(true);
                jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
