import java.util.Scanner;

class Suite {

    public static void main(String[] args) {

        Scanner clavier = new Scanner(System.in);

        int debut;
        do {
            System.out.print("de (>= 1) ? ");
            debut = clavier.nextInt();
        } while (debut < 1);

        int fin;
        do {
            System.out.print("a (>= " + debut + ") ? ");
            fin = clavier.nextInt();
        } while (fin < debut);

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        int count ;
        int value;
        do {
            count = 0;
            value = debut;
            while( value!= 0 ){
                if (value % 3 == 0){
                    value +=4;
                } else if (value % 4 == 0) {
                    value /= 2;
                }
                else {
                    value -= 1;
                }
                count++;
            }
            System.out.println(debut + " -> " + count);
            debut++;

        } while (debut <= fin);

        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/
        clavier.close();
    }
}
