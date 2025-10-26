package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.Arrays;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T>{
    private T value;
    private int dest;

    /**
     * Create a CopyEvent obj
     * @param value type T value we are copying
     * @param dest index to copy value into
     */
    public CopyEvent (T value, int dest) {
        this.value = value;
        this.dest = dest;
    }

    /**
     * @return affected indies as list
     */
    public List<Integer> getAffectedIndices(){
        return Arrays.asList(dest);
    }

    /**
     * Insert value into destination
     * @param takes an array
     */
    public void apply (T[] arr){
        arr[dest] = value;
    }

    /**
     * @return true for copyEvent
     */
    public boolean isEmphasized(){
        return true;
    }
}
