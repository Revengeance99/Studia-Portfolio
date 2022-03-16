/*Zadanie 3 generowanie liczb losowych w wektorze

Przydatnym mechanizmem programisytcznym są generatory liczb losowych.
Proszę poczytać sobie o ich teorii np. https://pl.wikipedia.org/wiki/Generator_liczb_losowych

W językach progamowania zazwyczaj generowanie liczb losowych jest jedną ze standardowych procedur (metod); 
w Java może to wyglądać tak (choć są inne sposoby):

//generuje wektor 10-elementowy,z liczb od 0 do 99
//(int) 'rzutuje' wygenerowany (i pomnożony przez 100) ułamek na zmienną całkowitą
for (i=0;i<ilw;i++)
      wek[i]=(int)(100*Math.random());	

	  
Często do testowania potrzebne są nam liczby losowe uporządkowane (rosnące lub malejące).
Można oczywiście posortować wygenerowany wcześniej wektor liczb losowych ale to jest czasochłonne. 
Istniej inna, prosta metoda: możemy losować niewielkie liczby losowe (np. z przedziału 1-5) i dodawać je do wcześniej wylosowanych. 
W ten sposób otrzymamy szybko ciąg rosnących sum o zmiennym 'skoku', którego długość można łatwo regulować. 
Proszę zatem wygenerować w ten sposób ciąg przypadkowych, rosnących liczb w wektorze 100-elementowym.
*/
import java.util.Random;
public class zad3 {
    public static void main(String[] args) {
        Random generator = new Random();
        int[] tab = new int[101];
        int i=1;
        int c = generator.nextInt(5) + 1;
        tab[0]=c;
        while(i<tab.length) {
            int r = generator.nextInt(5) + 1;
            tab[i]=tab[i-1]+r;
            System.out.println(tab[i]);
            i++;
        }


        }


}
/* 
Grzegorz Krzesiński 99631
Program losuje liczby z przedziału 1-5 i dodaje 
do siebie na kolejnych miejscach w tablicy 
tworząc losowo wygenerowany ciąg rosnący.*/