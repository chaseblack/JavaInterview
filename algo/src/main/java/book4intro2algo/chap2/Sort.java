package book4intro2algo.chap2;

import java.util.List;

/**
 * The interface for all sorting algorithms.
 * */
public interface Sort {
    /**
     *@implSpec
     *<p>The runtime type T must extends Comparable because we compare a list of T.
     *@param <T> the runtime type  of the list to be sorted.
     *@param tobeSorted the list of T, which is to be sorted.
     *@return void
     * */
    <T extends Comparable<T>> void sort(List<T> tobeSorted);
}
