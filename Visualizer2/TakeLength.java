// Takes the length of the array
package Visualizer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TakeLength extends JDialog {
    private JTextField inputField;
    private int resultValue;

    public TakeLength(JFrame parent) {
        super(parent, "Array Input Length", true);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter The Length Of The Array:");
        inputField = new JTextField(10);
        JButton okButton = new JButton("OK");

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    resultValue = Integer.parseInt(inputField.getText());
                    if(resultValue > 30 || resultValue == 0)
                    {
                        throw new ArrayIndexOutOfBoundsException();
                    }
                    dispose(); // Close the dialog
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(parent, "Invalid input. Please enter an integer.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                catch (ArrayIndexOutOfBoundsException outofrange)
                {
                    JOptionPane.showMessageDialog(parent, "Invalid input. Please enter The Length of The Array Within Range (1 -> 30 ).", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(label);
        panel.add(inputField);
        panel.add(okButton);
        add(panel);

        setSize(300, 100);
        setLocationRelativeTo(parent);
    }

    public int showDialog() {
        setVisible(true);
        return resultValue;
    }
}
