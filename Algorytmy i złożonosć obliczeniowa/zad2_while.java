/*Zadanie 2 Wstawianie

Prostym a użytecznym algorytmem jest wstawianie elementu w ciąg posortowanych.
Rozsądnie jest założyć, że do przechowywania danych wykorzystujemy tylko część (początek) wektora (reszta jest wypełniona np. zerami). 
Wygodnie jest też pamiętać, który element jest ostatnim z pamiętanych (końcówka wektora to rezerwa na nowe).
Proszę zatem stworzyć algorytm dopisywania nowego elementu, z zachowniem posortowania.
Można to robić na różne sposoby, np. znaleźć miejsce w które mamy wstawić element i przesunąć do góry wszystkie pozostała albo szukać od góry i od razu przesuwać. 
Można też dopisać na końcu i wszystko posortować - ale to jest zbyt głupie więc proszę tak nie robić.


Testując ten program trzeba zwrócić uwagę na przypadki szczególne:
1. Dopisywany el jest mniejszy od najmniejszego (tu można zastosować metodę z wart)
2. Dopisywany element jest większy od największego
3. Jest wiele elementów jednakowych
*/
public class zad2_while {
    public static void main(String[] args) {
        int tab[] =  {7, 9, 12, 13, 14, 17, 45, 57, 89, 95, 0, 0, 0, 0, 0};
        int temp=0;
        int wpis = 36;

        int i = 0;
        while (tab[i] < wpis && tab[i]!=0) {
            i++;
        }

        temp = tab[i];
        tab[i] = wpis;

        while (tab[i + 1] != 0) {
            int tmp;
            tmp = tab[i + 1];
            tab[i + 1] = temp;
            temp = tmp;
            i++;
        }
        tab[i+1]=temp;
        for(i=0;i<tab.length;i++){
            System.out.println(tab[i]);
        }
    }
}
	/* 
Grzegorz Krzesiński 99631
Program sprawdza w które miejsce wstawić wpis. 
Nadpisuje liczby po kolei do końca tablicy, 
przesuwając je o jedno miejsce tym samym pozorując dopisanie liczby.
/*