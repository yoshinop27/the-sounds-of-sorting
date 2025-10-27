package edu.grinnell.csc207.soundsofsorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;
import edu.grinnell.csc207.soundsofsorting.sorts.Sorts;

public class SortsTests {
    /**
     * @param <T> the carrier type of the array
     * @param arr the array to check
     * @return true iff <code>arr</code> is sorted.
     */
    public static <T extends Comparable<? super T>> boolean sorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return new integer array for testing
     */
    public static Integer[] makeTestArray() {
        return new Integer[] {
            3, 7, 9, 1, 2,
            18, 16, 15, 19, 8,
            14, 12, 5, 13, 4,
            6, 0, 17, 11, 10
        };
    }

    /**
     * @return sorted array for testing
     */
    public static Integer[] makeSortedArray() {
        return new Integer[] {
            1,2,3,4,5,6,7,8
        };
    }

    /**
     * @return empty array for testing
     */
    public static Integer[] makeEmptyArray() {
        return new Integer[] {};
    }

    /**
     * @return array with duplicates for testing
     */
    public static Integer[] makeDupArray() {
        return new Integer[] {
            3, 7, 9, 1, 1, 2,
            18, 16, 15, 19, 8,
            14, 12, 5, 5, 13, 4,
            6, 0, 17, 17, 11, 10
        };
    }

    /**
     * @return array in descending order for testing
     */
    public static Integer[] makeRevArray() {
        return new Integer[] {
            10,9,8,7,6,5,4,3,2,1
        };
    }

    /**
     * General test suite for our sorts
     * @param func the sorting algorithim we are testing
     */
    public void testSort(Function<Integer[], List<SortEvent<Integer>>> func) {
        // basic test
        Integer [] arr = makeTestArray();
        Integer [] copy = Arrays.copyOf(arr, arr.length);

        List<SortEvent<Integer>> l = func.apply(arr);
        assertTrue(sorted(arr));
        Sorts.eventSort(copy, l);
        assertTrue(sorted(copy));
        assertArrayEquals(arr, copy);

        // pre-sorted test
        arr = makeSortedArray();
        copy = Arrays.copyOf(arr, arr.length);
        
        l = func.apply(arr);
        assertTrue(sorted(arr));
        Sorts.eventSort(copy, l);
        assertTrue(sorted(copy));
        assertArrayEquals(arr, copy);

        // empty array
        arr = makeEmptyArray();
        copy = Arrays.copyOf(arr, arr.length);

        l = func.apply(arr);
        assertTrue(sorted(arr));
        Sorts.eventSort(copy, l);
        assertTrue(sorted(copy));
        assertArrayEquals(arr, copy);

        // duplicates 
        arr = makeDupArray();
        func.apply(arr);
        assertTrue(sorted(arr));
        
        // reverse
        arr = makeRevArray();
        func.apply(arr);
        assertTrue(sorted(arr));       
    }

    @Test
    public void testBubbleSort() {
        testSort(Sorts::bubbleSort);
    }
    
    @Test
    public void testInsertionSort() {
        testSort(Sorts::insertionSort);
    }
    
    @Test
    public void testSelectionSort() {
        testSort(Sorts::selectionSort);
    }

    @Test
    public void testMergeSort() {
        testSort(Sorts::mergeSort);
    }
    
    @Test
    public void testQuickSort() {
        testSort(Sorts::quickSort);
    }

    @Test
    public void testHeapSort() {
        testSort(Sorts::heapSort);
    }
}