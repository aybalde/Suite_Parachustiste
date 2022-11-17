import java.util.Scanner;

class Parachutiste {
    static final double G = 9.81;
    public static void main(String[] args) {
        double v0 = 0;
        double t0 = 0;
        Scanner clavier = new Scanner(System.in);

        double masse = 80.0;
        do {
            System.out.print("masse du parachutiste (>= 40) ? ");
            masse = clavier.nextDouble();
        } while (masse < 40.0);

        double h0 = 39000.0;
        do {
            System.out.print("hauteur de depart du parachutiste (>= 250) ? ");
            h0 = clavier.nextDouble();
        } while (h0 < 250.0);

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        double vitesse = v0, hauteur = h0, accel = G, t = t0;
        double s = 2 /masse ;
        double rap, q, delta;
        int count = 0;
        do{
            System.out.printf("%.0f, %.4f, %.4f, %.5f\n", t, hauteur, vitesse, accel);
            t +=1;
            rap = G/s;
            delta = t - t0;
            q = Math.exp(-s * delta);
            hauteur = h0 - rap * delta - (v0 - rap)/s * (1-q);
            vitesse = rap * (1 - q) + v0 * q;
            accel   = G - (s * vitesse);
            if (vitesse > 343 && count < 1){
                System.out.println("## Felix depasse la vitesse du son");
                count++;
            }
            if( accel < 0.5 && count < 2){
                System.out.println("## Felix a atteint sa vitesse maximale");
                count++;
            }
            if (hauteur < 2500 && count < 3){
                System.out.println("## Felix ouvre son parachute");
                count++;
                s = 25 / masse;
                t0 = t;
                v0 = vitesse;
                h0 = hauteur;
            }

        }while(hauteur > 0);
        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/
        clavier.close();
    }
}
