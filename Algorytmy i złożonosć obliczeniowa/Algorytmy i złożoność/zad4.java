/*Zadanie 4 szukanie binarne

To jest bardzo ważny i trochę już bardziej ambitny algorytm.
Celem jest odnalezienie konkretnej komórki w posortowanym wektorze przy użyciu minimalnej ilosci porównań.
 Rozwiazanie polega na podzieleniu tablicy na dwie połówki, sprawdzeniu, w której z nich znajduje sie poszukiwana komórka, p
 odzieleniu tej połowy tabeli na połowę i tak dalej.

Opisy algorytmu i przykładowe rozwiązania:
http://wazniak.mimuw.edu.pl/index.php?title=Algorytmy_i_struktury_danych/Wyszukiwanie
https://pl.wikipedia.org/wiki/Wyszukiwanie_binarne

Proszę uruchomić ten algorytm, wykorzystując wcześniej napisany program generowania losowego liczb narastających dla uzyskania daych testowych. 
Opracowanie algorytmu szukania binarnego tylko na podstawie słownego opisu jest zadaniem dość trudnym dla początkującego programisty więc proponuję większości z Was wersję łatwiejszą: 
proszę wykorzystać istniejący kod (z dowolnego podręcznika) i uzupełnić go o wyświetlanie etapów obliczeń - elementów wektora znajdowanych po poszczególnych podziałach.

Należy zwrócić uwagę że algorytm szukania binarnego może mieć realizację iteracyjn lub rekurencyjną. 
O rekurencji proszę poczytać: https://pl.wikipedia.org/wiki/Rekurencja
Temat jest dobrze omówiony w podręczniku Lafore w rozdziale 6. 


Jeżeli do testowania algorytmu szukania binernego chcemy użyć rosnącego ciągu liczb losowych to nie można szukanej liczby podać w tekście 
programu - bo ten ciąg będzie różny przy każdym jego uruchomieniu (można to zmienić i za każdym razem mieć ten sam ciąg liczb pseudolosowych (w końcu algorytm startuje od 'ziarna' 
którym jest konkretna liczba) ale do testowania lepsze są  na ogół ciągi losowe).
Zatem musimy najpierw wyświetlić wygenerowany wektor a potem wybierać któryś jego element (albo element nieistniejący).

Wejście to temat złożony (i mało 'algorytmiczny'), zajmiemy się nim może potem a na razie podaję najprostszy sposób wprowadzania pojedynczej liczby, proszę go zastosować.
*/
import java.util.Scanner;
import java.util.Random;
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random generator = new Random();
        int[] tab = new int[102];
        int lewo = 0;
        int prawo = tab.length;
        int srodek = 0;
        int i=1;
        boolean b = false;
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj liczbę którą chcesz wyszukać: ");
        int search= scan.nextInt();
        int c = generator.nextInt(5) + 1;
        tab[0]=c;
        while(i<tab.length) {
            int r = generator.nextInt(5) + 1;
            tab[i]=tab[i-1]+r;
            System.out.println(tab[i]);
            i++;
        }
        while(lewo <= prawo){
            srodek = (lewo+prawo)/2;
            if(tab[srodek]== search){
                System.out.println("Istnieje taka liczba");
                 b= true;
                break;
            }
            else if(tab[srodek]< search){
                lewo = srodek + 1;
                
            }
            else{
                prawo = srodek -1;
                
             }
        }
        if(b==false){
        System.out.println("Nie ma takiej liczby");
    }}
    
}
/* Grzegorz Krzesiński 99631
Program pobiera za pomocą funkcji scanner liczbę. Generuje losowy ciąg liczb rosnących.
 Następnie za pomocą wyszukiwania binarnego sprawdza i wyświetla, 
czy w wygenerowanym ciągu liczb znajduje sięnasza szukana czy nie. 
*/