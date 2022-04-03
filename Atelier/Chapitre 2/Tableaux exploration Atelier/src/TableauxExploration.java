import java.util.SplittableRandom;

public class TableauxExploration {

    public static void initTen(int[][] tab){

        int nbLigne = tab.length;
        int nbCol= tab[0].length;

        for (int iLig = 0; iLig<nbLigne; iLig++)
            for (int iCol = 0; iCol<nbCol; iCol++)
                tab[iLig][iCol]=10;

    }

    public static void initPosition(String[][] tabch){

        int iLigne= tabch.length;
        int iCol = tabch[0].length;

        for (int i = 0; i<iLigne; i++)
            for (int j = 0; j<iCol; j++)
                tabch[i][j] = String.valueOf(i).concat(":").concat(String.valueOf(j));

    }





}
