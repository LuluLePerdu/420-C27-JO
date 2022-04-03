public class Main {

    public static void main(String[] args) {
        int[][] data = {
                {5, 115, 15},
                {3, 223, 33},
                {1, 331, 11},
                {2, 442, 22},
                {4, 554, 44}
        };

        int[] indexCol0 = new int[data.length];
        int[] indexCol1 = new int[data.length];
        int[] indexCol2 = new int[data.length];

        initIndex(indexCol0);
        initIndex(indexCol1);
        initIndex(indexCol2);

        System.out.println("-----Colonne 0-------");
        triSSS(data, indexCol0, 0);
        affTableau(data, indexCol0);

        System.out.println("-----Colonne 1-------");
        triSSS(data, indexCol1, 1);
        affTableau(data, indexCol1);

        System.out.println("-----Colonne 2-------");
        triSSS(data, indexCol2, 2);
        affTableau(data, indexCol2);

    }

    public static void initIndex(int[] ind) {
        for (int i = 0; i < ind.length; i++)
            ind[i] = i;
    }

    public static void permute(int[] tab, int i1, int i2) {

        int transit = tab[i1];
        tab[i1] = tab[i2];
        tab[i2] = transit;

    }

    public static void triSSS(int[][] tab, int[] ind, int col) {

        int imin = 0;
        for (int i=0; i<tab.length-2; i++) {
            imin = i;
            for (int j=i+1; j<tab.length-1; j++)
                if (tab[ind[j]][col] < tab[ind[imin]][col])
                    imin = j;
            if (imin != i)
                permute(ind, i, imin);
        }

    }

    public static void affTableau(int[][] tab, int[] ind) {
        for (int ilig = 0; ilig < tab.length; ilig++) {
            for (int icol = 0; icol < tab[0].length; icol++)
                System.out.print(tab[ind[ilig]][icol] + " ");
            System.out.println();
        }
    }
}