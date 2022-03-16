import java.util.Scanner;
public class zbpot {
    static int rozmiar(){
        int a=0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Wprowadź rozmiar zbioru: ");
        a = scan.nextInt();
        return a;
    }
    static void wpis(int a, int tab[]) {
            for (int i = 0; i < a; i++) {
                    Scanner scan = new Scanner(System.in);
                    System.out.print("Wprowadź " + (i+1) +" liczbę do  zbioru" +  ": ");
                    tab[i] = scan.nextInt();
            }
    }
    static void wyswietl(int a, int tab[]){
        System.out.print("{");
        for(int i=0;i<a;i++){
            if(i<a-1){
            System.out.print(tab[i] + ",");
            }
            else{
                    System.out.print(tab[i]);
            }
        }
        System.out.println("}");
    }
    static void potegi(int a, int tab[]){
       System.out.println("{}");
        for(int i=0;i<a;i++){
            System.out.println("{"+tab[i]+ "}");
            for(int j=i+1;j<a;j++){
                System.out.println("{" + tab[i] + ", " + tab[j] + "}");
            }

        }
        wyswietl(a, tab);
    }

    public static void main(String[] args){
    int a = rozmiar();
    int b = (int) Math.pow(2, a);
    int [] tab = new int [a];
    wpis(a, tab);
    System.out.println("Zbiór: ");
    wyswietl(a, tab);
    System.out.println("Zbiór potęgowy podanego zbioru to: ");
    potegi(a, tab);
    }
}
