import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class View {
    JFrame frame;
    JList<String> list;
    DefaultListModel<String> model;
    String[] data = {"un","deux", "trois","quatre","cinq","six"};

    JButton btnGo;

    public View(){
        frame = new JFrame("Deo DefaultListMode");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(300,300));
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        //Créer le model en premier
        model = new DefaultListModel<>();
        for (String elem: data)
            model.addElement(elem);

        list = new JList<>(model);
        list.setFixedCellWidth(100);

        btnGo = new JButton("GO");
        btnGo.addActionListener(e -> btnGoAction());


        frame.add(new JScrollPane(list));
        frame.add(btnGo);
        frame.setVisible(true);
    }

    private void btnGoAction() {
/*        //ajouter elem "zero" au début du model
        model.add(0,"zéro");

        //modifier elem un UN
        model.setElementAt("UN", 1);
        //Sans connaitre elem, on peut quand meme mettre en maj comme ci dessous
        model.setElementAt(model.getElementAt(1).toUpperCase(),1);

        //Supprimer elem "quatre" | retourne un boolean si effacé ou non
        System.out.println(model.removeElement("quatre"));

        //Supprime elem a l'index
        model.remove(0);*/

        //supprimer elem selectionné
        int sel = list.getSelectedIndex();
        //model.remove(sel);<

        if (sel != -1) {
            model.remove(sel);
        }

        //nombre elem du model
        int nbElemModel = model.getSize();
        nbElemModel = list.getModel().getSize();

        //nombre elem list sélectionné
        int nbElemSel = list.getSelectedIndices().length;

        //afficher model
        for (int i=0; i<model.getSize();i++)
            System.out.println(model.getElementAt(i));

        System.out.println(model); //[un, deux. ...]

        Object[] tab = model.toArray(); //retourne tableau object



    }

    public static void main(String[] args) {
        View v = new View();
    }
}
