public class Main {

    public static void main(String[] args){

        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();

        System.out.println(l1 == l2);

    }
}
