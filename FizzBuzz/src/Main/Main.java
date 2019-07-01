package Main;

public class Main {

    public static void main(String[] args){

        for(int i = 1; i <= 105; i++){

            if(i%5==0 && i%3==0 && i%7==0){
                System.out.println("WHIZZFIZZBUZZ");
            }
            else if(i%3==0){
                System.out.println("FIZZ");
            }
            else if(i%5==0){
                System.out.println("BUZZ");
            }
            else if(i%7==0){
                System.out.println("WHIZZ");
            }
            else {
                System.out.println(i);
            }
        }

    }
}
