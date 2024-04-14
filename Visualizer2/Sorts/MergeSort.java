package Visualizer.Sorts;

import Visualizer.SortingVisualizer;

public class MergeSort implements Runnable{

    public void run() {
        Integer[] toBeSorted = SortingVisualizer.toBeSorted;
        mergesort(toBeSorted);
        SortingVisualizer.isSorting=false;
    }
    public void mergesort ( Integer[] x )
    {  mergesort (x, 0, x.length-1);  }

    private void mergesort ( Integer[] x, int first, int last )
    {
        int mid, lt, rt;
        int tmp;

        if ( first >= last ) return;

        mid = (first + last) / 2;

        mergesort (x, first, mid);
        mergesort (x, mid+1, last);

        lt = first;  rt = mid+1;
        // One extra check:  can we SKIP the merge?
        if ( x[mid] <= x[rt])
            return;

        while (lt <= mid && rt <= last)
        {
            // Select from left:  no change, just advance lt
            if ( x[lt] <= x[rt])
                lt++;
                // Select from right:  rotate [lt..rt] and correct
            else
            {
                tmp = x[rt];     // Will move to [lt]
                for (int i = rt-lt;i>0; i--){
                    x[lt+i] = x[lt+i-1];
                }
                x[lt] = tmp;
                // EVERYTHING has moved up by one
                lt++;  mid++;  rt++;
            }
            SortingVisualizer.frame.reDrawArray(x, mid, rt, lt);
            try {
                Thread.sleep(SortingVisualizer.sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Whatever remains in [rt..last] is in place
    }
}