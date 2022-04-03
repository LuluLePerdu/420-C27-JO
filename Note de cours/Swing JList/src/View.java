import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class View {

JFrame frame;
JList<String> list;
JList<Integer> listInt;
String[] data = {"un","deux","trois","quatre","cinq","six"};
Integer[] dataInt = {1,2,3,4,5,6};
JButton btnGo;

public View(){
    frame = new JFrame("Demo JList");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(new Dimension(300,300));
    frame.setLocationRelativeTo(null);
    frame.setLayout(new FlowLayout());

    list = new JList(data);
    list.setFixedCellWidth(100);
    //list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    list.setVisibleRowCount(10);

    list.addListSelectionListener(e -> listSelectionChange(e));

    list.addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode()==KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN)
                System.out.println(list.getSelectedValue());

        }
    });

    listInt = new JList<>();

    btnGo = new JButton("Go");
    btnGo.addActionListener(e -> btnGoAction());

    frame.add(listInt);
    frame.add(btnGo);
    frame.add(new JScrollPane(list));
    frame.setVisible(true);

}

    private void btnGoAction() {
        //tableau des index des items sélectionnés
        int[] tabSel = list.getSelectedIndices();
        int nbSel = tabSel.length;
/*
        //parcourir les index des items selectionnés
        for (int elem: tabSel)
            System.out.println(elem + " ");

        //afficher les items sélectionnés
        for (int i=0; i<tabSel.length;i++)
            System.out.println(data[tabSel[i]]);

        //ou
        for (int index: tabSel)
            System.out.println(data[index]);*/

        //sélectionner de un à quatre
        //list.setSelectionInterval(0,3);

        //tout déselcetionner
        //list.clearSelection();

        //Vérifier si au moins un item est sélectionné
        //if (!list.isSelectionEmpty());

        data[0] = "bdjsfbjksd"; //Aucun effet JList
    }

    private void listSelectionChange(ListSelectionEvent e) {
    if (e.getValueIsAdjusting())
        System.out.println(list.getSelectedValue());
    }

    public static void main(String[] args) {
        View v = new View();
    }
}
