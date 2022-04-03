
package com.company;

import javax.swing.*;

public class Tableaux {

    public static void permuteInt(int[] tab, int ind1, int ind2) {

        int transit = tab[ind1];
        tab[ind1] = tab[ind2];
        tab[ind2] = transit;
    }
    public static int[] conversionTab(String[] tabs) {

        String[] transit; //tableau de String transit pour passer de String à int

        transit = tabs;

        int longueur = transit.length;
        int[] tableau = new int[longueur];
        for (int i = 0; i < longueur; i++) {
            tableau[i] = Integer.parseInt(transit[i]);
        }
        return tableau;
    }

    /**
     * Méthode permettant un tri croissant d'un tableau d'entier reçus en argument
     *
     * @param tab tableau d'entier reçus en argument
     */
    public static void trieCroissantSSS(int[] tab) {

        int imin;

        for (int i = 0; i < tab.length - 1; i++) {
            imin = 1;

            for (int j = i; j < tab.length; j++) {
                if (tab[j] < tab[imin])
                    imin = j;
            }

            if (imin != i)
                permuteInt(tab, i, imin);
        }

    }

    public static void trieCroissantSSS(String[] stab) {

        int imin;

        int[] tab = Integer.parseInt(stab)

        for (int i = 0; i < stab.length - 1; i++) {
            imin = 1;

            for (int j = i; j < stab.length; j++) {
                if (stab[j] < stab[imin])
                    imin = j;
            }

            if (imin != i)
                permuteInt(stab, i, imin);
        }
    }
}