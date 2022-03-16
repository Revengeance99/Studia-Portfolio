
// Grzegorz Krzesiński
// Numer albumu: 99631.


// Zadanie numer 8.

// Temat: Sortowanie przez proste wybieranie

// 1. Szukamy najmniejszego elementu 
// 2. Po znalezieniu zamieniamy go miejscami z pierwszym (chyba że ten pierwszy jest  właśnie najmniejszy)
// 3. Operację powtarzamy dla drugiego elementu itd.

public class Zad8{


    public static void sortArray(int[] entry){  // metoda sortuje elementy tablicy przekazanej jako parametr

    int arraySize = entry.length;               // zmienna przechowująca rozmiar tablicy


    for (int i = 0; i < arraySize; i++){        // pętla przejścia przez wszystkie elementy tablicy

    int min = entry[i];                         // zakladamy, ze element na pozycji i jest najmniejszy

    int index = i;                              // zapisujemy indeks tego elementu


    
    for (int j = i; j < arraySize; j++){        // szukamy w pozostałej części tablicy elementu mniejszego niz min

    if(entry[j] < min) {                        // jesli jest taki, on staje się teraz elementam najmniejszym
    min = entry[j];

    index=j;                                    // zapisujemy jego indeks
    }
    }


    entry[index] = entry[i];                    // zamieniamy miejscami elementy w tablicy
    entry[i] = min;                             // najmniejszy z aktualnym wskazywanym przez zmienną i
    }
    }

    public static void showArray(int[] entry){  // metoda wyświetla zawartość tablicy przekazanej jako parametr na ekranie

    for(int x : entry) System.out.print(x + " ");   // każdy element znajdujący się w tablicy wyświetlamy na ekranie
    System.out.println();
    }
    public static void main(String[] args) {

    int[] tab = {10, 45, 3, 4, 8, 25, 77};          // tworzymy tablicę wypełniając ją od razu danymi

    showArray(tab);                                 // wyświetlamy tablicę na ekranie

    sortArray(tab);                                 // sortujemy tablicę

    showArray(tab);                                 // wyświetlamy posortowaną tablicę na ekranie
    }                                               // mian
    }                                               // public class

