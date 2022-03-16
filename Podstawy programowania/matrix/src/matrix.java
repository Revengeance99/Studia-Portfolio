import java.util.Scanner;
public class matrix {

    static int rozmiar(){
        int a=0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Wprowadź rozmiar macierzy kwadratowej: ");
        a = scan.nextInt();
        return a;
    }
    static void wpis(int a, int tab[][]) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                Scanner scan = new Scanner(System.in);
                System.out.print("Wprowadź parametr a" + (i + 1) + (j + 1) + ": ");
                tab[i][j] = scan.nextInt();
            }
        }
    }
        static void wyswietl(int a, int tab[][]){
        for(int i=0;i<a;i++){
            for(int j=0;j<a;j++)
                if (j+1 != a) {
                    System.out.print(tab[i][j] + " ");
                } else {
                    System.out.println(tab[i][j]);
                }
    }
        System.out.println("");
    }

    static void multi(int a, int tab[][], int tab2[][], int tab3[][]){
        int w=0,k=0;

        for(int p=0;p<a;p++ ){
            for(int i=0;i<a;i++){
                for(int j=0;j<a;j++){
                    tab3[w][k] += tab[i][j] * tab2[j][p];
                }
                w++;
            }
            k++;
            w=0;
    }
    }

    public static void  main(String[] args){
        int a = rozmiar();
        int [][] tab = new int [a][a];
        int [][] tab2 = new int[a][a];
        int [][] tab3 = new int[a][a];
        System.out.println("Podaj parametry 1 macierzy: ");
        wpis(a, tab);
        System.out.println("Podaj parametry 2 macierzy: ");
        wpis(a, tab2);
        System.out.println("Macierz 1: ");
        wyswietl(a, tab);
        System.out.println("Macierz 2: ");
        wyswietl(a,tab2);
        multi(a, tab, tab2, tab3);
        System.out.println("Wynik działania Macierz 1 * Macierz 2: ");
        wyswietl(a, tab3);
    }
}
