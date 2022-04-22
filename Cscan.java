import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.abs;

public class Cscan {
    ArrayList<Integer> requestQueue;
    ArrayList<Integer> outputSequence;
    int startHead;
    int currentHead;
    int headMovements;

    public Cscan(ArrayList<Integer> rQ,int sHead)
    {
        this.requestQueue=new ArrayList<>();
        this.requestQueue.addAll(rQ);
        this.startHead=sHead;
        this.currentHead=startHead;
        headMovements=0;
        outputSequence=new ArrayList<>();
        applyAlgo();
    }
    public void applyAlgo()
    {
        ArrayList<Integer>less=new ArrayList<>();
        ArrayList<Integer>more=new ArrayList<>();

        for(int i=0;i<requestQueue.size();i++){
            if(requestQueue.get(i)<startHead){
                less.add(requestQueue.get(i));
            }
            else{
                more.add(requestQueue.get(i));
            }
        }
        more.add(199);
        less.add(0);
        Collections.sort(less);
        Collections.sort(more);
        outputSequence.add(startHead);
        for(int i=0;i<more.size()-1;i++){
            headMovements+=abs(currentHead-more.get(i));
            currentHead=more.get(i);
            outputSequence.add(currentHead);
            if(currentHead==more.get(more.size()-2)&&more.get(0)!=199){
                currentHead=199;
                outputSequence.add(currentHead);
                headMovements+=abs(currentHead-more.get(more.size()-2));
            }
        }
        //headMovements+=abs(currentHead);
        if(more.size()-1==0){
            headMovements=abs(currentHead-199);
            currentHead=199;
            outputSequence.add(currentHead);
        }
        currentHead=0;
        if(less.size()-1!=0){
            outputSequence.add(currentHead);
        }
        for(int i=1;i<less.size();i++){
            headMovements+=abs(currentHead-less.get(i));
            currentHead=less.get(i);
            outputSequence.add(currentHead);
            if(currentHead== less.get(less.size()-1)){
                //currentHead=less.get(less.size()-1);
                //outputSequence.add(currentHead);
                //headMovements+=1;
            }
        }
        showOutput();
    }
    public void showOutput(){

        System.out.println("---------CSCAN---------");
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
