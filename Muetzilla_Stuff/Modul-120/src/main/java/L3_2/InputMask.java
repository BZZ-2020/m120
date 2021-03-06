package L3_2;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputMask extends JFrame {
    private JLabel personTitleLabel =  new JLabel("Person:");
    private JLabel nameLabel =  new JLabel("Name");
    private JLabel vornameLabel =  new JLabel("Vorname");
    private JLabel strasseLabel =  new JLabel("Strasse");
    private JLabel plzLabel =  new JLabel("PLZ");
    private JLabel ortLabel =  new JLabel("Ort");
    private JLabel kontakteTitleLabel =  new JLabel("Kontakte:");
    private JLabel telLabel =  new JLabel("Tel");
    private JLabel mailLabel =  new JLabel("Mail");
    private JLabel imageLabel =  new JLabel(new ImageIcon("src\\main\\java\\L3_2\\Logo.gif"));
    private JLabel title = new JLabel("Informatik/Technik");
    private JPanel titlePanel =  new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JPanel buttonSoutPanel = new JPanel();
    private JButton neuButton =  new JButton("Neu");
    private JButton erfassenButton =  new JButton("Erfassen");
    private JButton verwerfenButton =  new JButton("Verwerfen");
    private JButton schliessenButton =  new JButton("Schliessen");
    private JPanel centerPanel = new JPanel();
    private JPanel topCenterPanel = new JPanel();
    private JPanel bottomCenterPanel = new JPanel();
    private JSeparator topSeparator = new JSeparator();
    private JSeparator bottomSeparator = new JSeparator();
    private JTextField nameTextfield =  new JTextField();
    private JTextField vornameTextfield =  new JTextField();
    private JTextField strasseTextfield =  new JTextField();
    private JTextField plzTextfield =  new JTextField();
    private JTextField ortTextfield =  new JTextField();
    private JTextField telTextfield =  new JTextField();
    private JTextField mailTextfield =  new JTextField();
    private JPanel emptyPanelLeft = new JPanel();
    private JPanel emptyPanelRight = new JPanel();
    private JPanel centerLeftPanel =  new JPanel();
    private JPanel centerRightPanel =  new JPanel();
    private JPanel bottomTopPanel = new JPanel();
    private JPanel bottomTopInnerPanel = new JPanel();
    private JPanel bottomBottomPanel = new JPanel();
    private JLabel klasseLabel =  new JLabel("Klasse");
    private String[]klassen = new String[]{"IABM03 A"};
    private JComboBox klassSelector = new JComboBox(klassen);
    private JLabel bmsLabel = new JLabel("BMS");
    private JCheckBox bmsCheckBox = new JCheckBox();
    private JLabel bemerkungLabel = new JLabel("Bemerkung");
    private JTextArea bemerkungArea = new JTextArea(20, 50);
    private JPanel textAreaPanel = new JPanel();
    private JPanel bemerkungLabelPanel = new JPanel();


    public InputMask(){
        super("Beispiel zu GUI-Design");

        displayContent();
        pack();
        setVisible(true);
    }

    private void displayContent() {
        //Title Panel
        titlePanel.setLayout(new BorderLayout());
        titlePanel.add(title, BorderLayout.WEST);
        titlePanel.add(imageLabel, BorderLayout.EAST);
        //Center Panel
        centerPanel.setLayout(new GridLayout(0,1));
        centerPanel.add(topSeparator);
        //Center Top Panel
        topCenterPanel.setLayout(new GridLayout(0,2));
        centerLeftPanel.setLayout(new GridLayout(0,2));
        centerLeftPanel.add(personTitleLabel);
        centerLeftPanel.add(emptyPanelLeft);
        centerLeftPanel.add(nameLabel);
        centerLeftPanel.add(nameTextfield);
        centerLeftPanel.add(vornameLabel);
        centerLeftPanel.add(vornameTextfield);
        centerLeftPanel.add(strasseLabel);
        centerLeftPanel.add(strasseTextfield);
        centerLeftPanel.add(plzLabel);
        centerLeftPanel.add(plzTextfield);
        centerLeftPanel.add(ortLabel);
        centerLeftPanel.add(ortTextfield);
        centerRightPanel.setLayout(new GridLayout(0,2));
        centerRightPanel.add(kontakteTitleLabel);
        centerRightPanel.add(emptyPanelRight);
        centerRightPanel.add(telLabel);
        centerRightPanel.add(telTextfield);
        centerRightPanel.add(mailLabel);
        centerRightPanel.add(mailTextfield);
        topCenterPanel.add(centerLeftPanel);
        topCenterPanel.add(centerRightPanel);
        centerPanel.add(topCenterPanel);
        centerPanel.add(bottomSeparator);
        //Center Bottom Panel
        bottomCenterPanel.setLayout(new BorderLayout());
        bottomTopPanel.setLayout(new BorderLayout());
        bottomTopInnerPanel.setLayout(new GridLayout(1,0));
        bottomTopInnerPanel.add(klasseLabel);
        bottomTopInnerPanel.add(klassSelector);
        bottomTopInnerPanel.add(bmsLabel);
        bottomTopInnerPanel.add(bmsCheckBox);
        bottomTopPanel.add(bottomTopInnerPanel, BorderLayout.WEST);
        bottomTopPanel.add(bemerkungLabel, BorderLayout.SOUTH);
        bottomBottomPanel.setLayout(new BorderLayout());
        bottomBottomPanel.add(bemerkungArea, BorderLayout.CENTER);
        bottomCenterPanel.add(bottomTopPanel, BorderLayout.NORTH);
        bottomCenterPanel.add(bottomBottomPanel, BorderLayout.SOUTH);
        centerPanel.add(bottomCenterPanel);


        //Button Panel
        buttonPanel.setLayout(new GridLayout(1,0));
        buttonPanel.add(neuButton);
        buttonPanel.add(erfassenButton);
        buttonPanel.add(verwerfenButton);
        buttonPanel.add(schliessenButton);
        buttonSoutPanel.setLayout(new BorderLayout());
        buttonSoutPanel.add(buttonPanel, BorderLayout.EAST);
        //Add Panels to main scene
        add(titlePanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(buttonSoutPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
      InputMask im = new InputMask();
      im.setSize(600,500);
    }
}
