/*Grzegorz Krzesiński 99631
Proszę dokonać scalenia dwóch wektorów, umieszczając wyniki w trzecim. Scalenie polega na zapisaniu wartości wektorów z zachowaniem uporządkowania.
        Wynik działania programu dla poniższych wektorów:
        int[] wek = {13,57,89,95};
        int[] wek1 = {25,56,58,67,69,70,76};

        powinien zatem wyglądać następująco: 13 25 56 57 58 67 69 70 76 89 95*/
public class zad13 {

    private static int[] tab = {13, 57, 89, 95};
    private static int[] tab2 = {25, 56, 58, 67, 69, 70, 76};
    private static int[] tab_wynikowa;

    public static void main(String[] args) {
        int i, j, k;

//Wypisz zawartosc pierwszego ciagu
        System.out.println("Pierwszy ciag:");
        for (int e : tab) {
            System.out.print(e + ", ");
        }
//Wypisz zawartosc drugiego ciagu
        System.out.println("\nDrugi ciag:");
        for (int e : tab2) {
            System.out.print(e + ", ");
        }

//Utworz tablice wynikowa
        tab_wynikowa = new int[11];

//Bierz mniejsza wartosc z pierwszego badz drugiego ciagu,
//dopoki zaden z nich sie nie skonczy
        for (i = j = k = 0; i < 4 && j < 7; k++) {
            if (tab[i] < tab2[j]) {
                tab_wynikowa[k] = tab[i];
                ++i;
            }
            else {
                tab_wynikowa[k] = tab2[j];
                ++j;
            }
        }

//Jeden z ciagow sie skonczyl dopisz do wyniku pozostaly
        if (i < 4) {
            for (; i < 4; i++, k++) {
                tab_wynikowa[k] = tab[i];
            }
        }
        else {
            for (; j < 7; j++, k++) {
                tab_wynikowa[k] = tab2[j];
            }
        }

//Wypisz wynik
        System.out.println("\nCiag wynikowy:");
        for (int e : tab_wynikowa) {
            System.out.print(e + ", ");
        }
    }
}