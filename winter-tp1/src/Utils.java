/*
Objectif: Méthodes utilistaires pour faciliter les méthodes

Auteur: Ludwig-Emmanuel Dufour - 2031990
Session Hiver 2022
 */


import javax.swing.table.DefaultTableModel;

public class Utils {
    /**
     * Effectue la moyenne d'une colonne d'un tableau 2D
     *
     * @param tab le tableau à parcourir
     * @param col la colonne à parcourir
     * @return retourne la moyenne
     */
    public static double moyenneEval(int[][] tab, int col){

        double moyenne = 0; //moyenne qui sera retourné

        for (int[] ints : tab) {
            moyenne += ints[col];
        }

        return moyenne / tab.length;
    }

    /**
     * Détermine le minimum d'une colonne d'un tableau 2D
     *
     * @param tab le tableau à parcourir
     * @param col la colonne à parcourir
     * @return retourne le minimum d'une colonne
     */
    public static int minEval(int[][] tab, int col){

        int min = tab[0][col]; //minimum à retourner

        for (int[] ints : tab){
            if (ints[col] < min)
                min = ints[col];
        }

        return min;
    }

    /**
     * Détermine le maximum d'une colonne d'un tableau 2D
     *
     * @param tab le tableau à parcourir
     * @param col la colonne à parcourir
     * @return retourne le minimum d'une colonne
     */
    public static int maxEval(int[][] tab, int col){

        int max = tab[0][col]; //maximum à retourner

        for (int[] ints : tab){
            if (ints[col] > max)
                max = ints[col];
        }

        return max;
    }

    /**
     * Création d'un tableau 2D à partir d'un DefaultTableModel
     *
     * @param model Le defaultTableModel à convertir
     * @return retourne le DefaultTableModel en tableau int 2D
     */
    public static int[][] convertT2D(DefaultTableModel model){

        int ligne = model.getRowCount(); //nombre de lignes
        int col = model.getColumnCount(); //nombre de colonne
        int[][] tab = new int[ligne][col]; //tableau à retourner

        for (int i = 0; i < ligne; i++)
            for (int j = 0; j < col; j++)
                tab[i][j] = Integer.parseInt(model.getValueAt(i,j).toString());

        return tab;
    }

    /**
     * Permute deux valeurs dans un tableau
     *
     * @param tab tableau contenant les valeurs
     * @param i1 première valeur
     * @param i2 seconde valeur
     */
    public static void permute(int[] tab, int i1, int i2){

        int transit = tab[i1]; //variable temporaire pour la permutation
        tab[i1] = tab[i2];
        tab[i2] = transit;
    }

    /**
     *Trie une partie d'un tableau 2D
     *
     * @param tab tableau 2D à trier
     * @param tabInd tableau index
     * @param col colonne utilisé comme filtre
     * @param g valeur gauche
     * @param d valeur droite
     * @return retourne l'index pour la méthode du quicksort
     */
    public static int partition(int[][] tab, int [] tabInd, int col, int g, int d) {

        int pivot = tab[tabInd[d]][col];
        for (int i = g; i < d; i++){
            if (tab[tabInd[i]][col] < pivot) {
                permute(tabInd, i, g);
                g++;
            }
        }
        permute(tabInd, g, d);

        return g;
    }

    /**
     * Trie un tableau 2D selon la colonne demander
     *
     * @param tab tableau 2D à trier
     * @param tabInd tableau d'indice
     * @param col colonne utilisé comme filtre
     * @param gauche valeur gauche
     * @param droite valeur droite
     */
    public static void quickSort(int[][] tab, int[] tabInd, int col, int gauche, int droite){

        if (gauche < droite) {
            int index = partition(tab, tabInd, col, gauche, droite);
            quickSort(tab, tabInd, col, gauche,index -1);
            quickSort(tab, tabInd, col, index + 1, droite);
        }
    }

    /**
     * Donne l'indice d'une valeur n dans un tableau 2D
     *
     * @param tab      tableau à fouiller
     * @param tabIndex tableau indice pour trier
     * @param valeur   valeur à rechercher
     * @return l'indice de la valeur, sinon -1
     */
    private static int fouilleDichoCol(int[][] tab, int[] tabIndex,int col, int valeur) {
        int debut = 0; // début de la zone de fouille
        int fin = tabIndex.length - 1; // fin de la zone de fouille
        int milieu = 0; // milieu de la zone de fouille
        boolean trouve = false; // si on a trouver search

        while (debut <= fin && !trouve) {
            milieu = (debut + fin) / 2;

            if (valeur == tab[tabIndex[milieu]][col])
                trouve = true;
            else if (valeur < tab[tabIndex[milieu]][col])
                fin = milieu - 1;
            else
                debut = milieu + 1;
        }

        if (trouve)
            return milieu;
        else
            return -1;
    }

    /**
     * Présence ou non d'une valeur de type entier dans une colonne spécifié d'un tableau 2D d'entiers
     *
     * @param tab tableau à fouiller
     * @param valeur valeur de type entier que l'on cherche
     * @return retourne true si la valeur est présente
     */
    public static boolean isPresentCol(int[][] tab, int valeur, int col){

        int[] tabIndex = new int[tab.length]; // tableau d'index
        for (int i = 0; i < tabIndex.length; i++)
            tabIndex[i] = i;

        quickSort(tab, tabIndex, col, 0, tab.length - 1);
        return (fouilleDichoCol(tab, tabIndex, 0, valeur) != -1);
    }

    public static void dessin(){
        String dessin =
                """ 
                
                        ************ 
                       *****************
                       ********************
                        ********************
                         ********
                          ********                 *********
                           ***********              *********
              *********      ****       *            *********
            *            ***               *          *********
          *                       **         *          ********
         *                         **         *       ***********
        *        *****              **      *********************
       *        *******                     *********************
       *         *****                         *****************
       *                                        *
        *     *               *                 *
         *     *             *                  *
           *    *           *                  *
             *    *       *                   *
                *   *****                   *
       ***               *     ************
      *   *            *      *
      *   *          *********          ***
  ****    **********        *          *   *
 *               *         *           *   *
*              *           *************    ****
*      *******                                  *
*      *    *                                    *
  *****    *              *****************      *
          *               *               *      *
         *      ****      *                *****
         *    *      **   *
         *   *         ** *
      *** *  *            *
     *    *   *            *    *
      *    *   *           *   * *
       *     *  *          *  *  *
         *     * *         *  *  *
          *       *        *  *  *
            *       *    *****   *
               *      * * *****  *

     """;
        System.out.println(dessin);
    }
}
