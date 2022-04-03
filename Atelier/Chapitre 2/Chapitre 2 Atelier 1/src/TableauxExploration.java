public class TableauxExploration {

    public static void initTen(int[][] tab){

        int nbLigne = tab.length;
        int nbCol = tab[0].length;

        for (int iLigne = 0; iLigne <nbLigne;iLigne++)
            for (int iCol = 0; iCol < nbCol; iCol++)
                tab[iLigne][iCol] = 10;
    }

    public static void initPosition(String[][] tabCh){

        int nbLigne = tabCh.length;
        int nbCol = tabCh[0].length;

        for (int iLigne = 0; iLigne < nbLigne; iLigne++)
            for (int iCol = 0; iCol < nbCol; iCol++)
                tabCh[iLigne][iCol]= String.valueOf(iLigne).concat(":").concat(String.valueOf(iCol));

    }

    public static boolean isTabCarre(int[][]tab){

        return tab.length == tab[0].length;
    }

    public static boolean isTabDimEgal(int[][] tab1, int [][] tab2){

        return tab1.length == tab2.length && tab1[0].length == tab2[0].length;
    }

}
