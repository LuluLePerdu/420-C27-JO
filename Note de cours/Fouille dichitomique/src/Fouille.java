import java.lang.invoke.VarHandle;

public class Fouille {
public static int sommeUneLigne(int[][] tab, int ligne){

    int somme = 0;

    int nbLigne = tab.length;
    int nbCol = tab[0].length;

    for (int i=0; i<tab[ligne].length; i++)
        somme+=tab[ligne][i];

return somme;
}

public static int maxLigne(int[][] tab, int ligne){
    int max = tab[ligne][0];

    for (int i=0; i<tab[ligne].length; i++)
        if (max < tab[ligne][i])
            max = tab[ligne][i];
    return max;
}

String s;


}