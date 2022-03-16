public class Pallindrom {
    public static void main(String[] args) {
        int[] tab = new int[810000];
        int wynik=0;
        int n = 0;
        for (int i = 100; i <= 999; i++) {
            for (int j = 100; j <= 999; j++) {
                tab[n] = i * j;
                n++;
            }
        }
        for (int i = 809999; i >= 0; i--) {

            int liczba = tab[i];
            boolean status = true;

            int p = 0, k = 0, dziel=0;

            if (liczba >= 100000) dziel = 100000;
            else if(liczba<100000) dziel = 10000;

            while (liczba >= 999) {

                k = liczba % 10;
                p = (liczba / dziel) % 10;
                //System.out.println(p + " - " + k);
                if (k != p) {
                    status = false;
                }

                dziel /= 100;
                liczba = (liczba - k) / 10;
            }
            
        
            if (status == true) {
                if(tab[i]>wynik){
                    wynik=tab[i];
                    
                
            }
                
            }
        }System.out.println(wynik);
    }
}
