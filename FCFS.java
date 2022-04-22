import java.util.ArrayList;

import static java.lang.Math.abs;

public class FCFS {

    ArrayList<Integer> requestQueue;
    ArrayList<Integer> outputSequence;
    int startHead;
    int headMovements;


    public FCFS(ArrayList<Integer> rQ,int sHead)
    {
        this.requestQueue=new ArrayList<>();
        this.requestQueue.addAll(rQ);
        this.startHead=sHead;
        headMovements=0;
        outputSequence=new ArrayList<>();
        applyAlgo();
    }

    public void applyAlgo()
    {
        headMovements+=abs(startHead-requestQueue.get(0));
        for (int i = 0; i < requestQueue.size()-1; i++) {
            headMovements+=abs(requestQueue.get(i)-requestQueue.get(i+1));
        }

        outputSequence.add(startHead);
        outputSequence.addAll(requestQueue);

        showOutput();
    }

    public void showOutput()
    {

        System.out.println("---------FCFS---------");
        System.out.println("======================");
        System.out.println("Total head movement: "+headMovements+" Cylinders");
        System.out.println("Head Sequence: ");
        for (int i = 0; i < outputSequence.size()-1; i++) {
            System.out.print(outputSequence.get(i)+" -> ");
        }
        System.out.println(outputSequence.get(outputSequence.size()-1));
        System.out.println("======================");
    }

    public ArrayList<Integer> getSequence()
    {
        return outputSequence;
    }


}
