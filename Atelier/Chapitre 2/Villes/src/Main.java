import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {

        int[][] tabVilles = {
                {76,68,81,91, 65,96,107,94,98,107,96,130},
                {55, 51, 59, 65, 66, 67, 69, 82, 72, 61, 72, 67},
                {71, 63, 70, 72, 76, 90 ,89, 96, 89, 80, 92, 92},
                {87, 68, 84, 84, 78, 78, 95, 91, 73, 89, 86, 102}
        };

        String[] tabNomsVilles = {"Québec", "Toronto", "Joliette", "Gaspé"};

        //a)
        Villes.afficherTab(tabVilles);
        System.out.println();

        //b)
        for (int iLig=0; iLig<tabVilles.length; iLig++)
        System.out.println("Total " + tabNomsVilles[iLig]+ ": " + Villes.sommeUneLigne(tabVilles,iLig));
        System.out.println();

        //c)

        DecimalFormat df = new DecimalFormat("0.00");

        for (int iLig=0; iLig<tabVilles.length; iLig++)
            System.out.println("Moyenne " + tabNomsVilles[iLig]+ ": " + df.format(Villes.moyenneUneLigne(tabVilles,iLig)));
        System.out.println();

        //d)

        for (int iLig=0; iLig<tabVilles.length; iLig++)
            System.out.println("Max " + tabNomsVilles[iLig]+ ": " + Villes.maxLigne(tabVilles,iLig));
        System.out.println();

        //e)

        for (int iLig=0; iLig<tabVilles.length; iLig++)
            System.out.println("Min " + tabNomsVilles[iLig]+ ": " + Villes.minLigne(tabVilles,iLig));
        System.out.println();

    }

}
