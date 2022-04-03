import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class View {
    JFrame frame;
    JTable tableData;

    String[] colNames = {"Prénom","Noms","Âge"};

    String[][] data = {
            {"Deneige","Lacour","55"},
            {"Matin","Joyeux","75"},
            {"Perdu","Lulu","62"},
            {"Alex","Thérieur","58"},
            {"Amphès","Dlapen","27"},
            {"Matin","Joyeux","75"},
            {"Perdu","Lulu","62"},
            {"Alex","Thérieur","58"},
            {"Amphès","Dlapen","27"},
    };

    public View(){
        frame = new JFrame("demo JTable statique");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(600,300));
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        //tableData = new JTable(data,colNames); //éditable

        //Créer un JTable non éditable
        tableData = new JTable(data,colNames){
            @Override
            public boolean isCellEditable(int row, int col){
                //tout le JTable non éditable
                //return false;

                //colonne Prénom non éditable
                //prendre le reflex de ne pas utiliser de if si je retourne un boolean

/*                if (col == 0)
                    return false;
                else
                    return true;*/

                return col !=0;
            }
        };
        //tableData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableData.getSelectionModel().addListSelectionListener(e -> tableDataSelectionChange(e));
        tableData.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode()== KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN)
                    tableSelectionChange();

            }
        });

        //FFICHER LE NOM DE LA COLONNE 0)
        System.out.println(tableData.getColumnName(0));

        frame.add(tableData);

        JScrollPane scroll = new JScrollPane(tableData);
        scroll.setPreferredSize(new Dimension(400,100));

        //Par programmation, modifier la largeur d'une colonne, exemple la colonne prénom(colonne 0)
        TableColumn colPrenom = tableData.getColumn("Prénom");
        colPrenom.setPreferredWidth(200);

        //frame.add(new JScrollPane(tableData)); //rajoute un en-tête
        frame.add(scroll);
        frame.setVisible(true);
    }

    private void tableSelectionChange() {
/*
//Single selection
// afficher la ligne selectionnée (le vecteur)
        int selIndex = tableData.getSelectedRow();
        System.out.println(Arrays.toString(data[selIndex]));

        //parcourir les éléments de la ligne sélectionnée
        for (int iCol = 0; iCol < data[selIndex].length; iCol++)
            System.out.print(data[selIndex][iCol] + " ");*/
        //Multiple Selection
        int[] sel = tableData.getSelectedRows();
        //System.out.println(Arrays.toString(sel));

        //Afficher vecteur des lignes selectionnées [ , , ]
        for (int i=0; i<sel.length; i++)
            System.out.println(Arrays.toString(data[sel[i]]));

        //afficher les éléments des lignes (vecteurs) sélectionnées
        for (int iLig = 0; iLig < sel.length; iLig++) {
            for (int iCol = 0; iCol < data[sel[iLig]].length; iCol++)
                System.out.print(data[sel[iLig]][iCol] + " ");
            System.out.println();
        }

    }

    private void tableDataSelectionChange(ListSelectionEvent e) {
        if (e.getValueIsAdjusting())
            tableSelectionChange();

    }


    public static void main(String[] args) {
        View v = new View();
    }
}
