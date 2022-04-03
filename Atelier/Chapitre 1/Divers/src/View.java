import javax.swing.*;
import java.awt.*;

public class View {

    JFrame frame;
    JList list;

    public View(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(600,600));
        frame.setLayout(new FlowLayout());

        list= new JList();
        list.setSelectionMode();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        View v = new View();
    }

    public static int fouilleDichotomique(int[] tab, int valeur){
        int debut = 0;
        int milieu = 0;
        int fin = tab.length -1;
        boolean trouve = false;

        while (debut<=fin && !trouve) {
            milieu = (debut + fin) / 2;
            if (valeur == tab[milieu])
                trouve = true;
            else if (valeur < tab[milieu])
                fin = milieu - 1;
            else
                debut = milieu + 1;
        }
        if (trouve)
            return milieu;
        else
            return -1;

        }
    }

    public int triSSS(int[] tab) {


    int imin;

    for (int i = 0; i<tab.length-1;i++)
        imin = i;

    for (int j = 0; j < tab.length-1; j++)
        if (tab[j] < tab[imin])
            imin = j;
    if (imin != i)

    }

    public static void permuteInt(int[] tab, int ind1, int ind2) {
        int transit = tab[ind1]; //permet de faire la transition entre les tableaux
        tab[ind1] = tab[ind2];
        tab[ind2] = transit;
    }
    public static void triSSSUpInt(int[] tableau) {

        int imin; //indice du plus petit

        for (int i = 0; i < tableau.length - 1; i++) {
            imin = i;

            for (int j = i; j < tableau.length; j++) {
                if (tableau[j] < tableau[imin])
                    imin = j;
            }

            if (imin != i)
                permuteInt(tableau, i, imin);
        }

    }

}
