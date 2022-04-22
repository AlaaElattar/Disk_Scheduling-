import java.util.ArrayList;
import java.util.Collections;

/*
Initial head start=0, requests are sorted in ascending order.
Start serving from 0 to last sorted element.
Total head movements = last element in the queue after sorting (the furthest request) as it will be the last reached element.
 */

public class OptimizedAlgo {

    ArrayList<Integer> requestQueue;
    ArrayList<Integer> outputSequence;
    int startHead;
    int headMovements;

    public OptimizedAlgo(ArrayList<Integer> rQ) {
        this.requestQueue=new ArrayList<>();
        this.requestQueue.addAll(rQ);
        this.startHead = 0;
        headMovements = 0;
        outputSequence = new ArrayList<>();
        applyAlgo();
    }

    public void applyAlgo() {

        Collections.sort(requestQueue);
        headMovements=requestQueue.get(requestQueue.size()-1);
        outputSequence.add(startHead);
        outputSequence.addAll(requestQueue);
        showOutput();
    }

    public void showOutput() {

        System.out.println("---------Optimized Algorithm---------");
        System.out.println("======================");
        System.out.println("Total head movement: " + headMovements + " Cylinders");
        System.out.println("Head Sequence: ");
        for (int i = 0; i < outputSequence.size() - 1; i++) {
            System.out.print(outputSequence.get(i) + " -> ");
        }
        System.out.println(outputSequence.get(outputSequence.size() - 1));
        System.out.println("======================");
    }

    public ArrayList<Integer> getSequence() {
        return outputSequence;
    }


}
