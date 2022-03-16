public class Euler12 {
    public static void main(String[] args){
        int l=0;
        int j=0;
        int ile=0;

        for(;;){
            l++;
            j+=l;
            ile=0;


            for(int t = 1; t <= Math.sqrt(j); t++){
                if(j % t == 0){
                    ile += 2;
                }
            }

            if(Math.sqrt(j)*Math.sqrt(j)==j){
                ile-=1;
            }

            //System.out.println(ile);
            if(ile >= 500){
                System.out.println(j);
                return;
            }
        }



    }
}
