import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> requestQueue = new ArrayList<>();
        String inputQueue;
        int startHead;
        Scanner sc = new Scanner(System.in);

        System.out.print("Request Queue: "); //98, 183, 37, 122, 14, 124, 65, 67
        inputQueue = sc.nextLine();

        System.out.print("Start Head: "); //53
        startHead = sc.nextInt();

        String[] array = inputQueue.split(", ");
        for (String s : array) {
            requestQueue.add(Integer.parseInt(s));
        }

        //Algorithms

        FCFS f = new FCFS(requestQueue, startHead);

        SSTF s = new SSTF(requestQueue, startHead);

        OptimizedAlgo opt = new OptimizedAlgo(requestQueue);

        Scan scn = new Scan(requestQueue, startHead); //---->

        Cscan cs = new Cscan(requestQueue, startHead);

        Look l = new Look(requestQueue, startHead);  // ---->

        Clook cl = new Clook(requestQueue, startHead);

        ///////////////////////////////////

        Representation r = new Representation(f,s,scn,cs,l,cl,opt);
        r.setVisible(true);


    }
}

