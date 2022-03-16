public class triangle {
    public static void main(String[] args){
        int a=0,b=0, c=0;

        for(int m=0;m<40;m++){
            for(int n=0;n<m;n++){
                a=2*m*n;
                b=m*m-n*n;
                c=m*m+n*n;
                if(a+b+c == 1000){
                    System.out.println(a + "\r\n" + b + "\r\n" + c + "\r\n");

                }
            }
        }

    }
}
