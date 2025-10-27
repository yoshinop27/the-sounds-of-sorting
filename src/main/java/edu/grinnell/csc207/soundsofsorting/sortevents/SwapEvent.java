package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.Arrays;
import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 */
public class SwapEvent<T> implements SortEvent<T>{
    
    private int i;
    private int j;

    /**
     * Creates a swap event obj
     * @param i one index thats swapped
     * @param j other index thats swapped
     */
    public SwapEvent (int i, int j){
        this.i = i;
        this.j = j;
    }

    /**
     * swaps elements i,j
     * @param arr array to perform swap operation on
     */
    @Override
    public void apply(T[] arr){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; 
    }

    /**
     * @return a list of affected indices
     */
    @Override
    public List<Integer> getAffectedIndices(){
        return Arrays.asList(i, j);
    }

    /**
     * @return true for swaps
     */
    @Override
    public boolean isEmphasized(){
        return true;
    }
}
