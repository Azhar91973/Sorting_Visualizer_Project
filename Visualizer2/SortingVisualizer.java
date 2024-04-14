package Visualizer;

import java.util.ArrayList;
import java.util.Collections;

import Visualizer.Sorts.*;

import javax.lang.model.type.NullType;

public class SortingVisualizer {

    private static Thread sortingThread;
    public static VisualizerFrame frame;
    public static Integer[] toBeSorted;
    public static boolean isSorting = false;
    public static int sortDataCount = 0;
    public static int sleep = 20;
    public static int blockWidth;
    public static ArrayInput1 A1;
    public static boolean flag = false;
    private static String type;

    public static void main(String[] args) throws InterruptedException {

        // Taking the Array Length From the User
            TakeLength t1 = new TakeLength(frame);
                sortDataCount = t1.showDialog();
            // Taking the Array Values From the User
             A1 = new ArrayInput1(frame);

            // Building the MainFrame
           frame = new VisualizerFrame();
           // Setting the Array Values to the issorting array
           setuserinputarray();

           diplayarray();
           // setting the mainframe in centre
           frame.setLocationRelativeTo(null);
       }

       // display the array in the frame
    public static void diplayarray(){

        if (isSorting) return;
        frame.preDrawArray(toBeSorted);
    }

    // set the values of the array on the basis of the user input
    public static void setuserinputarray()
    {
        blockWidth = (int) Math.max(Math.floor(500/sortDataCount), 1);
        if(flag == false)
            toBeSorted = A1.showDialog();
    }

    // if user want to increase the size of the array at runtime then it will do
    public static void incresesize()
    {
        toBeSorted = new Integer[sortDataCount];
        blockWidth = (int) Math.max(Math.floor(500/sortDataCount), 1);
        if (flag)
        {
            for(int i = 0; i<sortDataCount; i++){
                toBeSorted[i] = i;
            }
        }
    }

    // shuffle the array which are already sorted
    public static void shufflearray()
    {
        if(isSorting) return;
        
        if (flag) {
            ArrayList<Integer> shuffleThis = new ArrayList<>();
            for (int i = 0; i < toBeSorted.length; i++) {
                shuffleThis.add(toBeSorted[i]);
            }
            Collections.shuffle(shuffleThis);
            toBeSorted = shuffleThis.toArray(toBeSorted);
        }

        frame.preDrawArray(toBeSorted);
    }

    // start the sorting
    public static void startSort(String type){

            if (sortingThread == null || !isSorting) {
                diplayarray();

                flag = true;
            isSorting = true;
            switch(type){
                case "Bubble":
                    sortingThread = new Thread(new BubbleSort(toBeSorted, frame));
                    break;

                case "Selection":
                    sortingThread = new Thread(new SelectionSort(toBeSorted, frame));
                    break;

                case "Insertion":
                    sortingThread = new Thread(new InsertionSort(toBeSorted, frame));
                    break;

                case "Merge":
                    sortingThread = new Thread(new MergeSort());
                    break;

                default:
                    isSorting = false;
                    return;
            }

            sortingThread.start();

        }

    }

}
