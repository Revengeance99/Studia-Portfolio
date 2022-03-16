/*Zadanie 1 Szukanie liniowe

Jedną z częściej wykonywanych w przetwarzaniu operacji jest przeszukiwanie – wektorów, list, tablic, plików itp. \
Zaczniemy od prostego zadania: należy sprawdzić czy w wektorze jest jakaś liczba. Zakładamy że wektor jest posortowany (to jest ciekawszy przypadek)
 – można przyjąć upraszczające założenie, że szukamy pierwszego wystąpienia jakiegoś elementu wektora (klucze (szukane elementy) mogą się powtarzać). 

Przetestowanie tego zadania wymaga wskazania jakiegoś rzeczywiście występującego w wektorze elementu oraz – równie ważne: 
sprawdzenie jak działa program gdy szukanego elementu nie ma w wektorze. 
Trzeba tu precyzyjnie określić dane wejściowe. Najprościej użyć do tego deklaracji tablic w postaci np.
int[] wek = {7,9,12,13,14,17,45,57,89,95};
w ten sposób mamy zainicjowany wektor wypełniony danymi (i omijamy złożony problem czytania danych). 
Nie jest to uniwersalny sposób wprowadzania danych – chcąc je zmienić trzeba za każdym razem 
kompilować program – ale zwłaszcza na etapie testowania algorytmów takie proste rozwiązanie bardzo się przydaje.

Testując ten program trzeba zwrócić uwagę na przypadki szczególne:
1. Szukanej liczby nie ma w wektorze
2. Szukana liczba powtarza się
2. Szukana liczba występuje na pierwszzej (zerowej) lub ostatniej pozycji
*/

public static void main(String[] args) {
   
int[] wek = {7,9,12,13,14,17,45,57,89,95};

int b=14;
int i=0;
while(i<wek.length){
   if(wek[i]==b){
        System.out.println(wek[i]);
        break;
   }
       else{ i++;
       }
    
}
}/* 
Grzegorz Krzesiński 99631
Program wyszukuje w pęli while liczbę 14, jeśli ją napotka wychodzi z pętli
i kończy program. Jeśli nie napotka liczby 14, inkrmentuje zmienną "i" 
dopóki nie przeszuka całej tablicy.
*/
}