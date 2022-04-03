public class Villes {

    public static void afficherTab(int[][] tab) {

        int nbLigne = tab.length;
        int nbCol = tab[0].length;

        for (int iLig = 0; iLig < nbLigne; iLig++){
            for (int iCol = 0; iCol < nbCol; iCol++)
                System.out.print(tab[iLig][iCol] + " ");
            System.out.println();
        }

    }

    public static int sommeUneLigne(int[][] tab, int ligne){

        int somme = 0;

        for (int iLig = 0; iLig< tab[ligne].length; iLig++)
            somme += tab[ligne][iLig];
return somme;
    }

    public static double moyenneUneLigne(int[][] tab, int ligne){

        double moyenne = 0;

        if (tab[ligne].length > 0){
            double somme = sommeUneLigne(tab,ligne);
            moyenne= somme/tab[ligne].length;
        }
return moyenne;
    }

    public static int maxLigne(int[][] tab, int ligne){

        int max= tab[ligne][0];

        for (int iLig = 0; iLig < tab[ligne].length; iLig++)
            if (tab[ligne][iLig]>max)
                max = tab[ligne][iLig];

        return max;
    }

    public static int minLigne(int[][] tab, int ligne){

        int min= tab[ligne][0];

        for (int iLig = 0; iLig < tab[ligne].length; iLig++)
            if (tab[ligne][iLig]<min)
                min = tab[ligne][iLig];

        return min;
    }

}