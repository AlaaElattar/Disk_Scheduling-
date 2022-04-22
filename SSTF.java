import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.abs;

public class SSTF {
    ArrayList<Integer> requestQueue;
    ArrayList<Integer> outputSequence;
    int startHead;
    int headMovements;

    
    public SSTF(ArrayList<Integer> rQ,int sHead)
    {
        this.requestQueue=new ArrayList<>();
        this.requestQueue.addAll(rQ);
        this.startHead=sHead;
        headMovements = 0;
        outputSequence=new ArrayList<>();
        Collections.sort(requestQueue);
        applyAlgo();
    }

    public void applyAlgo()
    {
        ArrayList<Integer> diff = new ArrayList<>();

        for (Integer request : requestQueue) {
            diff.add(abs(startHead - request));
        }
        int min = Collections.min(diff);
        int index = diff.indexOf(min);

        headMovements += min;

        outputSequence.add(startHead);

        while(requestQueue.size() > 1){

          index = findMin(index);
        }
        outputSequence.add(requestQueue.get(0));

        showOutput();
    }
    
    public int findMin(int start){
      ArrayList<Integer> diff = new ArrayList<>();

      for (int i = 0; i < requestQueue.size(); i++) {
        if(start != i){
          diff.add(abs(requestQueue.get(start) - requestQueue.get(i)));
        }
        else{
          diff.add(Integer.MAX_VALUE);
        }
      }
      int min = Collections.min(diff);

      int index = diff.indexOf(min);
      int elem = requestQueue.get(index);

      headMovements += min;

      outputSequence.add(requestQueue.get(start));
      requestQueue.remove(start);

      index = requestQueue.indexOf(elem);

      return index;
    }

    public void showOutput()
    {
        System.out.println("---------SSTF---------");
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
