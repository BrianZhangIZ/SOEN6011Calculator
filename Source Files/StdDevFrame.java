import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StdDevFrame extends JFrame {

    private final JTextField inputField;
    private final JButton computeButton;
    private final JLabel resultLabel;
    private final JLabel errorLabel;

    public StdDevFrame() {
        setTitle("Standard Deviation Calculator - σ "  + AppVersion.VERSION);
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        add(new JLabel("Enter numbers separated by commas (e.g., 4, 8, 6, 5):"));

        inputField = new JTextField();
        add(inputField);

        computeButton = new JButton("Compute σ");
        add(computeButton);

        resultLabel = new JLabel("Standard Deviation (σ): ");
        add(resultLabel);

        errorLabel = new JLabel("");
        errorLabel.setForeground(Color.RED);
        add(errorLabel);

        computeButton.addActionListener((ActionEvent e) -> {
            calculateStandardDeviation();
        });

        setVisible(true);
    }

    private void calculateStandardDeviation() {
        try {
            String input = inputField.getText();
            String[] tokens = input.split(",");

            double[] numbers = new double[tokens.length];
            double sum = 0;

            for (int i = 0; i < tokens.length; i++) {
                numbers[i] = Double.parseDouble(tokens[i].trim());
                sum += numbers[i];
            }

            double mean = sum / numbers.length;

            double squaredDiffSum = 0;
            for (double num : numbers) {
                squaredDiffSum += Math.pow(num - mean, 2);
            }

            double stdDev = Math.sqrt(squaredDiffSum / numbers.length);

            resultLabel.setText("Standard Deviation (σ): " + String.format("%.5f", stdDev));
            errorLabel.setText("");
        } catch (NumberFormatException ex) {
            errorLabel.setText("Error: Please enter valid numbers separated by commas.");
            resultLabel.setText("Standard Deviation (σ):");
        } catch (Exception ex) {
            errorLabel.setText("Unexpected error occurred.");
        }
    }
}
