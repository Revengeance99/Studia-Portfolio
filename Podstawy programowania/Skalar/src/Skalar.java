import java.util.Scanner;
public class Skalar {

    static void wczytaj(int n, int[]W){
        for(int i=0; i<n;i++){
            Scanner index = new Scanner(System.in);
            System.out.print("Podaj " + (i+1) +" parametr wektrora: ");
            W[i] = index.nextInt();
       2 }


    }
    static void method(int n){
        int l =0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj wymiar: ");
        n = scan.nextInt();
        int suma=0;
        int[] W1 = new int[n];
        int[] W2 = new int[n];
        //System.out.println(W1.length);
        System.out.println("Współrzędne 1 wektora: ");
        wczytaj(n, W1);
        System.out.println("Współrzędne 2 wektora: ");
        wczytaj(n,W2);
        System.out.println("Tablica: ");
        for(int i=0;i<n;i++) {
            System.out.print(W1[i] + " ");
            System.out.println(W2[i] + " ");
        }
            for(int j=0;j<n;j++){
                suma+=W1[j]*W2[j];
            }
            System.out.println("Iloczyn skalarny wynosi: " + suma);

    }

    public static void main(String[] args){
      method(4);
    }
}
