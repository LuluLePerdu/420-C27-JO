public class Main {
    public static void main(String[] args) {

        //System.out.println(factorielleR(4));
        //int[] tab = {1,2,3,4};
        //System.out.println(sommeR(tab, 0,0));
        System.out.println(pair(159));
    }

    public static long factorielleR(long n){
        if (n == 0)                          //cas d'arrêt
            return 1;
        else                                 //cas récursif
            return n * factorielleR(n - 1);
    }

    //Fait le décompte d'un entier positif jusqua'a 1
    // décompte(5) 4 3 2 1
    public static void decompte(int n){
        for (int i=n; i>=1; i--)
            System.out.println(i);
    }
    public static void decompteR(int n){

        if (n == 1)                     //cas d'arrêt
            System.out.println(n);
        else {                          //Cas récursif.
            System.out.println(n);
            decompteR(n-1);
        }
    }

    //somme tableau d'entiers
    public static int somme(int[] tab){
        int s = 0;
        for (int i=0; i<tab.length;i++)
            s += tab[i];
                    return s;
    }
    //somme tableau entier récursif
    public static int sommeR(int[] tab, int index, int somme){

        if (index == tab.length)
            return somme;
        else
            return sommeR(tab,index+1,somme+ tab[index]);
    }

    //récursivité directe / indirect
    //directe ex. factorielleR
    //indirecte ex. quand une méthode A fait appel a une méthode B, que cette derniere fait appel a la méthode A

//ex: nombre pairs et impairs (n positif)
/*
récursivité
- n est pair si n-1 est impair
- n est impair si n-1 est pair

conditions d'arrêt:
- si n ==0 pair
- si n ==1 impair
 */

    public static boolean pair(int n){
    if (n == 0)
        return true;
    else if (n == 1)
        return false;
    else return impair(n-1);
    }

    public static boolean impair(int n){
        if (n==0)
            return false;
        else if (n==1)
            return true;
        else
            return pair(n-1);
    }

}

