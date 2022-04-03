import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //int[][] tab = new int[2][3];
        int [][] tab = {
                {2,4,6},
                {1,3,5}
        };

        String[] tabVendeur = {"Pierre", "Paul"};
        String[] tabMois = {"Janvier", "février","mars"};

        //afficher ventes de pierre et paul pour le mois de janvier
        //parcours ligne 0 et 1 COLONNE 0
        for (int iLig = 0; iLig < tab.length; iLig++)
            System.out.println(tabVendeur[iLig]+": " + tab[iLig][0]);

        //afficher ventes de Paul pour les trois mois
        //parcours LIGNE 1 et colonne 0,1,2
        for (int iCol = 0; iCol < tab[1].length;iCol++)
            System.out.println(tabMois[iCol] + ": " + tab[1][iCol]);
/*        int nblignes = tab.length;
          int nbColonnes = tab[0].length;

        for (int iLig = 0; iLig < nblignes; iLig++)
            for (int iCol = 0; iCol < nbColonnes; iCol++)
                System.out.print(tab[iLig][iCol]);

        System.out.println();

        for (int[] tabLigne:tab)
            for (int elem: tabLigne)
                System.out.print(elem);
        System.out.println();

        //System.out.println(tab[0]);

        // parcours d'une ligne tab[LIGNE][iCol]
        // parcours d'une colonne tab [iLig][COLONNE]
        //
        // parcourir la secode ligne de tab(index 1 LIGNE) 1 3 5
        for (int iCol = 0; iCol < tab[1].length; iCol++)
            System.out.print(tab[1][iCol]);

        System.out.println();

        //parcourir la trosieme colonne de tab (index 2 COLONNE) 6 5
        for (int iLig= 0; iLig < tab.length; iLig++)
            System.out.print(tab[iLig][2]);*/

/*        System.out.println(tab[0][1]);
        int i = 0;
        //System.out.println(tab[i+1][3]);
        int code = 55;
                tab[0][0] = code;
                tab[1][0] = tab[1][1];
        System.out.println(Arrays.deepToString(tab));*/

/*        int nbLigne = tab.length; //2
        int nbColonnes = tab[0].length;// 3
        //int nbBizarre = tab[0][0].lenght;

        System.out.println(tab);
        System.out.println(Arrays.toString(tab));

        char[][] tabCar = new char[10][5]; //tableau de 50 char

        final int NB_ETU = 22;
        final int NB_NOTES = 10;

        double[][] tabNotes = new double[NB_ETU][NB_NOTES];*/
    }

    // méthode qui parcourt une colonne d'un tbleau d'entier
    public static void parcourtColonne(int[][] tableau, int colonne) {}

    //métode qui parcourt une ligne d'un tableau d,entier
    public static void parcourtLigne(int[][] tableau, int ligne){}
}
