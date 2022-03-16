public class Fibo {
    public static void main(String[] args) {
        long a = 0;
        long b = 1;
        long s = 0;
        for(;;){
            b += a;
            a = b-a;
            if(b<=4000000 && b%2 == 0){
                System.out.println(b);
                s += b;
            }
            else if(b>4000000){
                break;
            }
        }
        System.out.println("\r\n");
        System.out.println("Suma parzystych liczb ciagu Fibbonaciego \r\n nie przekraczająca 4mln to: " + s);
    }
}

