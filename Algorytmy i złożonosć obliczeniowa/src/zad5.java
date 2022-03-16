/*Zadanie 5 wprowadzanie do wektora za pomocą funkcji scanner */
import java.util.Scanner; //import funkcji scanner
public class zad5 {
    public static void main(String[]args){
        int b=0; // deklaracja zmiennej b
        int [] tab = new int [10]; // deklaracja tablicy
       for(int i = 0; i<tab.length;i++) { // pętla wpisująca liczby do tablicy
           Scanner scan = new Scanner(System.in);
           System.out.print("Wprowadź "+ (i+1) +" liczbę do wektora: ");
           System.out.println();
           tab[i] = scan.nextInt();
       }
       System.out.println("Wektor: ");
       for(int j = 0; j<tab.length;j++){// pętla wyświetlająca wprowadzone do tablicy liczby
           System.out.println(tab[j]);
       }
    }
}
// Grzegorz Krzesiński nr.albumu: 99631