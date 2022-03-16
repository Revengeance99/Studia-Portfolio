public class Collatz {

    public static void main(String[] args) {
        int jaka_liczba = 0;
        int ile_liczb = 0;

        for(int j=0;j<1000000;j++) {
            long first = j;
            long second = 0;
            int ile = 1;
            int n = 1;
            //System.out.println(first);
            do {
                if (first % 2 == 0) {
                    second = first / 2;
                } else if (first % 2 != 0) {
                    second = 3 * first + 1;

                }
                first = second;
                // System.out.println(second);
                ile++;
            } while (second > 1);


            if(ile>ile_liczb){
                ile_liczb=ile;
                jaka_liczba=j;
            }
        }
        System.out.println("Najdłuższy łańcuch jest dla liczby: " + jaka_liczba + " oraz wynosi  " + ile_liczb);
    }




}





