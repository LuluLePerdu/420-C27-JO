import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class View {
    JFrame frame;
    JButton btnQuitter;
    JComboBox<String> cmbOptions;
    JComboBox<Integer> cmbNombre;

    String[] tabCmbOptions = {"un","deux","trois","quatre"};

    public View(){
        frame = new JFrame( "démo JComboBox");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension( 300,300));
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        cmbOptions = new JComboBox(tabCmbOptions);
        cmbOptions.addItemListener(e -> cmbOptionsItemSelectionChange(e));


        //ajouter item à la fin
        cmbOptions.addItem("cinq");

        //Insérer un item au début et sélectionné par default
        cmbOptions.insertItemAt("zéro", 0);
        cmbOptions.setSelectedIndex(0);

        //Supprimer un item ex "deux"
        //cmbOptions.removeItemAt(2);
        cmbOptions.removeItem("deux");

        //accès item selectionné
        System.out.println(cmbOptions.getSelectedIndex());


        cmbNombre = new JComboBox<>();

        for (int i = 1; i<=50; i++)
            cmbNombre.addItem(i);
        //Afficher un max dans le scoll avant de mettre une barre de scroll
        cmbNombre.setMaximumRowCount(12);


        btnQuitter = new JButton("Quitter");
        btnQuitter.addActionListener(e -> btnQuitterAction());

        frame.add(cmbNombre);
        frame.add(cmbOptions);
        frame.add(btnQuitter);
        frame.setVisible(true);
    }

    private void cmbOptionsItemSelectionChange(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED){
            System.out.println(cmbOptions.getSelectedItem() + " à l'indice " + cmbOptions.getSelectedIndex());
        }
    }

    private void btnQuitterAction() {
        System.exit(0);
    }

    public static void main(String[] args) {
        View v = new View();
    }
}
