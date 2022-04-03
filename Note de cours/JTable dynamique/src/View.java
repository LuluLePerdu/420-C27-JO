import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class View {
    JTable tableData;
    DefaultTableModel model;
    JScrollPane scroll;
    JFrame frame;

    String[] colNames = {"id","Nom","Description"};
    String[][] data = {
            {"1","pdA","Le produit A"},
            {"2","pdB","Le produit B"},
            {"3","pdC","Le produit C"},
    };

    public View(){
        frame = new JFrame("demo jTable dynamique");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(600,200));
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        //model = new DefaultTableModel(colNames,0);
        model = new DefaultTableModel(data,colNames){
            @Override
            public boolean isCellEditable(int row,int col){
                return false;
            }
        };
        tableData = new JTable(model);
        scroll = new JScrollPane(tableData);
        scroll.setPreferredSize(new Dimension(400,100));

        tableData.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting())
                tableSelectionChange();
            }
        });

        tableData.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN)
                    tableSelectionChange();
            }
        });

/*        //ajouter une ligne fin model
        model.addRow(new String[]{"1","pdA","Le pro A"});
        model.addRow(data[2]);

        //modifier la valeur d'une cellulu 0,0
        model.setValueAt("toto",0,0);
        System.out.println(model.getValueAt(0,0));

        //insérer une ligne au début
        model.insertRow(0,data[0]);

        //supprimr une ligne
        model.removeRow(0);*/
        frame.add(scroll);
        frame.setVisible(true);
    }

    private void tableSelectionChange() {
        //SINGLE parcourir les éléments de la ligne selectionné
        int selIndex = tableData.getSelectedRow();

        for (int icol=0; icol<model.getColumnCount();icol++)
            System.out.print(model.getValueAt(selIndex,icol)+ " ");

        //MULTIPLE parcourir tous les éléments des lignes sélectionnées
        int[] sel = tableData.getSelectedRows();
        for (int ilig=0; ilig<sel.length; ilig++)
            for (int icol = 0; icol<model.getColumnCount();icol++)
                System.out.print(model.getValueAt(sel[ilig],icol)+ " ");

        //modifier la ligne sélectionée    "---"
        int selLigne = tableData.getSelectedRow();

        for (int icol=0; icol<tableData.getColumnCount(); icol++)
            model.setValueAt("---",selLigne,icol);
    }

    public static void main(String[] args) {
        View v = new View();
    }
}
