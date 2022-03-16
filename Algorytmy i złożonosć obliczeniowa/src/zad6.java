/*zadanie 6  Sortowanie przez porównywanie*/
public class zad6 {
    public static void main (String Args[]) {
        int ile = 20;
        int[] wektor = new int[ile];
        int[] pomo = new int[ile];
        boolean[] log = new boolean[ile]; //ustawiany automatycznie na false
        int i,j;
        int minim,wskminim;


        for (i=0;i<ile;i++) //generuje wektor 20-elementowy
            wektor[i]=(int)(100*Math.random());


        System.out.println("Oto wektor: ");//wyświetla wygenerowany wektor
        for (i=0;i<ile;i++)
            System.out.print(wektor[i]+ "  ");
        System.out.println();


        for (j=0;j<ile;j++){ //sortowanie
            minim = 1000;
            wskminim = 0;
            for (i=0;i<ile;i++){
                if (!log[i])
                    if (wektor[i]<minim) {
                        minim = wektor[i];
                        wskminim = i;
                    }
            }
            log[wskminim]=true;
            pomo[j] = minim;
        }

        System.out.println("Oto wektor posortowany: "); //wyświetla wektor posortowany
        for (i=0;i<ile;i++)
            System.out.print(pomo[i]+ "  ");

    }}
// Grzegorz Krzesiński nr.albumu: 99631