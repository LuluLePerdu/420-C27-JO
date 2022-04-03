public class Divers {

        /**
         * Détermine si une note est une réussite ou non. La note de passage est 60.
         * @param note note à évaluer
         * @return vrai si la note est supérieure ou égale à la note de passage, faux sinon
         */
        public static boolean estReussite(int note){
            return note >= 60;
        }

        /**
         * Calcule un nombre exposant deux
         * @param nb le nombre
         * @return un nombre exposant deux
         */
        public static int exposantDeux(int nb){
            return nb * nb;
        }

        /**
         * Détermine si un entier est pair ou non
         * @param nb le nombre à évaluer
         * @return vrai si le nombre est pair, faux sinon
         */
        public static boolean estPair(int nb){
            return nb % 2 == 0;
        }

        /**
         * Détermine si un premier entier est plus grand qu'un deuxième entier
         * @param nb1 premier entier
         * @param nb2 deuxième entier
         * @return vrai si le premier entier est plus grand que le deuxième, faux sinon
         */
        public static boolean estPlusGrand (int nb1, int nb2){
            return nb1 > nb2;
        }

        /**
         * Détermine l'entier le plus grand entre trois entiers
         * @param nb1 entier 1
         * @param nb2 entier 2
         * @param nb3 entier 3
         * @return l'entier le plus grand
         */
        public static int lePlusGrand(int nb1, int nb2, int nb3){
            int max; //nombre le plus grand

            if (nb1 >= nb2 && nb1 >= nb3)
                max = nb1;
            else if (nb2 >= nb1 && nb2 >= nb3)
                max = nb2;
            else
                max = nb3;

            return max;
        }

        /**
         * Calcule le nombre de jours dans un mois. Les annees bissextiles ne sont pas considérées.
         * Si le mois n'est pas valide retourne 0.
         * @param mois le mois à évaluer
         * @return le nombre de jour du mois si le mois est valide, 0 sinon
         */
        public static int nbJours(int mois){
            int nb; //nombre de jours

            if (mois >= 1 && mois <= 12){
                if (mois == 2)
                    nb = 28;
                else if (mois == 4 || mois == 6 || mois == 9 || mois == 11)
                    nb = 30;
                else
                    nb = 31;
            } else
                nb = 0;

            return nb;
        }

        /**
         * Détermine la couleur secondaire à partir de deux couleurs. Si la couleur n'est pas reconnue
         * retourne "Aucune".
         * @param couleur1 première couleur
         * @param couleur2 deuxième couleur
         * @return la couleur secondaire, ou "Aucune" si la couleur n'est pas reconnue
         */
        public static String couleurSecondaire(char couleur1, char couleur2){
            String sec; //couleur secondaire

            if ((couleur1 == 'R' && couleur2 == 'J') || (couleur1 == 'J' && couleur2 == 'R'))
                sec = "Orange";
            else if ((couleur1 == 'J' && couleur2 == 'B') || (couleur1 == 'B' && couleur2 == 'J'))
                sec = "Vert";
            else if ((couleur1 == 'R' && couleur2 == 'B') || (couleur1 == 'B' && couleur2 == 'R'))
                sec = "Violet";
            else
                sec = "Aucune";

            return sec;
        }

        /**
         * Retourne le nombre central entre trois entiers.
         * @param nb1 entier1
         * @param nb2 entier2
         * @param nb3 entier3
         * @return le nombre central entre trois entiers
         */
        public static int nbCentral(int nb1, int nb2, int nb3){
            int central; //nombre central

            if ((nb1 >= nb2 && nb1 <= nb3) || (nb1 >= nb3 && nb1 <= nb2))
                central = nb1;
            else if ((nb2 >= nb1 && nb2 <= nb3) || (nb2 >= nb3 && nb2 <= nb1))
                central = nb2;
            else
                central = nb3;

            return central;
        }

        /**
         * Retourne l'entier le plus grand entre deux nombres
         * @param nb1 nombre 1
         * @param nb2 nombre 2
         * @return l'entier le plus grand entre deux nombres
         */
        public static int max2(int nb1, int nb2){
            return nb1 > nb2 ? nb1 : nb2;
        }

        /**
         * Retourne l'entier le plus grand entre quatre entiers
         * @param nb1 nombre 1
         * @param nb2 nombre 2
         * @param nb3 nombre 3
         * @param nb4 nombre 4
         * @return l'entier le plus entre quatre nombres
         */
        public static int max4(int nb1, int nb2, int nb3, int nb4){
            return max2(max2(nb1, nb2), max2(nb3, nb4));
        }

    }