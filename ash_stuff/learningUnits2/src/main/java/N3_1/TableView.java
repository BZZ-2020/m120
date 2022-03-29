package N3_1;
import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Die Klasse TableView bringt die Daten des Modells DataModel zur Anzeige. 
 * Die Daten werden �ber das MVC-Pattern von der Model-Klasse gelesen.
 * 
 * @author Ren� Probst
 *
 */
public class TableView extends JFrame {
 
  // Deklaration der Attribute
  private JTable table;
  private TableModel model;
  private JButton newBtn;
  private JTextField cellEditor;
  
  public TableView(TableModel m){
    super("Autoliste");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    model = m;
    //
    init();
    //
    this.pack();
    this.setVisible(true);
  }
  
  private void init(){
    // Tabelle erstellen und in Contentpane ablegen
    
    
    //
    // Als editierbares Objekt f�r die Zelle wird eine JTextField-Komponente festgelegt = es k�nnen nur String verarbeitete werden.
    // Dieser Komponente wird dann ein KeyListener angeh�ngt, der die Eingabe der ENTER-Taste abf�ngt.
    // Danach wird aus der Editor-Komponente (und NICHT der Tabellenzelle!!) der neu eingegebene Wert gelesen und dem 
    // Datenmodel zugwiesen.
    // Hinweis: in der Tabellen-Zelle steht noch immer der alte Wert.
    
    /*-- Code wenn der Benutzer die Eingabe selber kontrollieren will
    cellEditor = new JTextField();
    cellEditor.addKeyListener(new KeyAdapter(){
      @Override
      public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
          System.out.println("neuer Wert in Spalte"+table.getEditingColumn()+" und Zeile"+table.getEditingRow());
          System.out.println("Wert = "+ table.getValueAt(table.getEditingRow(), table.getEditingColumn()));
          //
          System.out.println( ((JTextField)table.getEditorComponent()).getText());
        }
      }
    } );
    table.setDefaultEditor(Object.class, new DefaultCellEditor(cellEditor));
    --*/
    
    // Schaltfl�che 
    
  }
  
  
  public static void main(String[] args){
    // Objekte erstellen
    new TableView(new DataModel());
  }
  
}

class InputDialog extends JDialog{
  
  private JTextField[] eingabeFelder;
  private JButton okBtn, abortBtn;
  private JDialog dialog;
  
  InputDialog(TableModel model){
    this.dialog = this;
    this.setTitle("Autoliste erfassen");
    this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    //
    this.getContentPane().add(new JLabel("Zeile erfassen"), BorderLayout.NORTH);
    //
    eingabeFelder = new JTextField[model.getColumnCount()];
    JPanel inputPanel = new JPanel(new GridLayout(model.getColumnCount(),2));
    for (int i=0; i < model.getColumnCount(); i++){
      eingabeFelder[i] = new JTextField();
      inputPanel.add(new JLabel(model.getColumnName(i)+": "));
      inputPanel.add(eingabeFelder[i]);
    }
    this.getContentPane().add(inputPanel, BorderLayout.CENTER);
    //
    okBtn = new JButton("OK");
    okBtn.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        /**
           ein neues Objekt der Model-Klasse zuf�gen.Dazu die add-Methode implementieren.
           ACHTUNG: die Referenz model ist vom Type TableModel und kennt daher die
           Methdei add() nicht. Die Referenz muss zuerst in den entsprechenden Typ
           umgewandelt werden (cast)
        **/
      }
    });
    
    abortBtn = new JButton("Abbrechen");
    abortBtn.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        dialog.dispose();
      }
    });
    
    JPanel btnPanel = new JPanel(new GridLayout(1,2));
    btnPanel.add(abortBtn);
    btnPanel.add(okBtn);
    this.getContentPane().add(btnPanel, BorderLayout.SOUTH);
    //
    pack();
    setVisible(true);   
  }
}
