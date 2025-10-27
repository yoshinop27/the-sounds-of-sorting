package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CompareEvent</code> logs a comparison a sort makes between two
 * indices in the array.
 */
public class CompareEvent<T> implements SortEvent<T>{

    private int i;
    private int j;

    /**
     * Create a CompareEvent object
     * @param i first index
     * @param j second index
     */
    public CompareEvent (int i, int j){
        this.i = i;
        this.j = j;
    }

    /**
     * does nothing
     * @param arr takes an array
     */
    @Override
    public void apply(T[] arr){
        return;
    }

    /**
     * @return a list of compared indices
     */
    @Override
    public List<Integer> getAffectedIndices(){
        List<Integer> l = new ArrayList<>();
        l.add(i);
        l.add(j);
        return l;
    }

    /**
     * @return false becuase comparisons are not emphasized
     */
    @Override
    public boolean isEmphasized(){
        return false;
    }
 }
