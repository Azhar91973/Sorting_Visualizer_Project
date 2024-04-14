// Take the elements of the array from the user

package Visualizer;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class ArrayInput1 extends JDialog {
    private JTextField inputField;
    private Integer[] resultArray;

    public ArrayInput1(JFrame parent) {
        super(parent, "Elements of Array", true);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter Array Elements (Space-separated):");
        inputField = new JTextField(20);
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                try {
                    String[] values = input.split(" ");
                    resultArray = new Integer[SortingVisualizer.sortDataCount];
                    for (int i = 0; i < SortingVisualizer.sortDataCount; i++) {
                        resultArray[i] = Integer.parseInt(values[i].trim());
                    }
                    dispose(); // Close the dialog
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(parent, "Invalid input. Please enter integers separated by Spaces.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(label);
        panel.add(inputField);
        panel.add(okButton);
        add(panel);

        setSize(400, 100);
        setLocationRelativeTo(parent);
    }

    public Integer[] showDialog() {
        setVisible(true);
        return resultArray;
    }
}
