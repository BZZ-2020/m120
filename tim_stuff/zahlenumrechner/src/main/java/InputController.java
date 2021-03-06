import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputController extends KeyAdapter {
    private InputView view;
    private IntegerModel model;

    public InputController(InputView view, IntegerModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // check if number
        char c = e.getKeyChar();
        String text = view.getText();
        if (!Character.isDigit(c)) {
            if (text.length() > 0) {
                text = text.substring(0, text.length() - 1);
                view.setText(text);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        // if enter
        if (c == KeyEvent.VK_ENTER) {
            String text = view.getText();

            if (text.length() > 0) {
                try {
                    int value = Integer.parseInt(text);
                    model.setValue(value);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane optionPane = new JOptionPane("Invalid number");
                    JDialog dialog = optionPane.createDialog("Error");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                }

                view.setText("");
            }
        }
    }
}
