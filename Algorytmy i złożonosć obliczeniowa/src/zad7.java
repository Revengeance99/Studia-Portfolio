/* zad 7 sortowanie bąbelkowe*/
import java.util.Scanner;
public class zad7 {
    private static void sort(int tab[]){ //procedura sortująca
        int tymcz;
        int zmiana = 1;
        while(zmiana > 0){ //zamienia pozycjami jeśli napotka większą liczbę od poprzedniej
            zmiana = 0;
            for(int i=0; i<tab.length-1; i++){
                if(tab[i]>tab[i+1]){
                    tymcz = tab[i+1];
                    tab[i+1] = tab[i];
                    tab[i] = tymcz;
                    zmiana++;
                }
            }
        }
        for(int i=0; i<tab.length; i++){// wyświetla posortowane elementy tablicy
            System.out.print(tab[i]+" ");
        }
    }

    public static void main(String[] args) {
        int ilosc;
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj ilość elementów tablicy"); //wprowadzamy ilość elementów w tablicy
        ilosc = in.nextInt();

        int[] tab = new int[ilosc];
        for(int i=0; i<tab.length; i++){
            System.out.println("Podaj "+(i+1)+ " element tablicy:"); //wprowadzamy elementy do tablicy
            tab[i] = in.nextInt();
        }
        sort(tab);//wywołanie procedury sortującej
}

}
// Grzegorz Krzesiński nr.albumu: 99631
