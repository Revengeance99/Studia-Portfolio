
// Grzegorz Krzesiński
// Numer albumu: 99631.


// Zadanie numer 9.

// Temat: Sortowanie przez proste wstawianie.

import java.util.Scanner;
public class Zad9 {

    public static void sortArray(int[] tab){
        int key, j;
        for(int i = 0; i < tab.length; i++){
            j = i;
            key = tab[i];
            //Szukamy miejsca dla aktualnego elementu
            //Potem szukamy tylko w posortowanej już części tablicy
            //Przesuwamy element w kierunku początku tablicy tak długo, aż przed nim jest element wiekszy i nie znajduje sie na początku tablicy.
            while(j > 0 && tab[j - 1] > key){
                tab[j] = tab[j - 1];
                j--;
            }
            tab[j] = key;
        }
        for(int i = 0; i < tab.length; i++){
            System.out.println("#" + (i + 1) + ":\t" + tab[i]);
        }
        System.out.println();
    }

public static void main(String[] args){
    String number;
    String howNumbers;
    int size, l;

    // pobieranie od użytkownika wartości
    Scanner scan = new Scanner(System.in);
    System.out.println("Podaj ilosc wartosci liczbowych: ");
    howNumbers = scan.nextLine();
    size = Integer.parseInt(howNumbers);
    System.out.println("\n");
     
    // Tworzenie tablicy
    int [] tab = new int [size];
    for(int i = 0;  i < size; i++){
        l = i + 1;
        System.out.print("Wpisz liczbe\t #" + l + "\t");
        number = scan.nextLine();
        tab[i] = Integer.parseInt(number);
    }
    System.out.println();
    
    // Posortowanie tablicy
    sortArray(tab);
} // main
} // public class