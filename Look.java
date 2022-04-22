import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.abs;

public class Look {
    ArrayList<Integer> requestQueue;
    ArrayList<Integer> outputSequence;
    int startHead;
    int currentHead;
    int headMovements;

    public Look(ArrayList<Integer> rQ,int sHead)
    {
        this.requestQueue=new ArrayList<>();
        this.requestQueue.addAll(rQ);
        this.startHead=sHead;
        this.currentHead=startHead;
        headMovements=0;
        outputSequence=new ArrayList<>();
        applyAlgo();
    }
    public void applyAlgo() {
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
        Collections.sort(less);
        Collections.sort(more);
        outputSequence.add(startHead);
        for(int i=0;i<more.size();i++){
            headMovements+=abs(currentHead-more.get(i));
            currentHead=more.get(i);
            outputSequence.add(currentHead);
           /* if(currentHead==more.get(more.size()-1)){
                currentHead=199;
                outputSequence.add(currentHead);
                headMovements+=abs(currentHead-more.get(more.size()-1));
            }*/
        }
        if(less.size()-1==0){
            headMovements+=abs(currentHead-less.get(0));
            currentHead=less.get(0);
            outputSequence.add(currentHead);
        }
        if(less.size()!=0){
            headMovements+=abs(currentHead-less.get(less.size()-1));
            for(int i=less.size()-1;i>=1;i--){
                currentHead=less.get(i);
                outputSequence.add(currentHead);
                headMovements+=abs(currentHead-less.get(i-1));
               if(currentHead== less.get(1)){
                    currentHead=less.get(0);
                    outputSequence.add(currentHead);
                }
            }
        }
        showOutput();
    }




    public void showOutput(){

        System.out.println("---------LOOK---------");
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
