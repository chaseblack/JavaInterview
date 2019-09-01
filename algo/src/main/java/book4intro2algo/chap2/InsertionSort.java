package book4intro2algo.chap2;

import java.util.List;


/**
 * Implementation of the interface Sort.
 * <p>The sorting algorithm is named as "insertion sort" which
 * works the way many people sort a hand of playing cards.
 */
public class InsertionSort implements Sort {

    /**
     * @implNote
     * The objects to be sorted must implement the <tt>Comparable</tt> interface.
     * <p>Starting with the second element in the <tt>List</tt>, we compare
     * it with each of the cards already in the hand to find the correct position
     * for the card.
     *
     * <p>Algorithm Analysis:
     * Input Size = tobeSorted.size(), assumes as <tt>n</tt>
     * Running Time T(<tt>n</tt>)=c1*n+c2*(n-1)+c3*(n-1)+c4*(sum^n_{j=2}t_j)+c5*(sum^n_{j=2}{t_j-1})+c6*(sum^n_{j=2}{t_j-1})+c7*(n-1)
     *
     * <p>Best-case, also named as lower bound, of T(<tt>n</tt>), is when the list is already sorted, which means t_j=1 for any j.
     * In this case T(n)=c1*n+c2*(n-1)+c3*(n-1)+c4*(n-1)+c7*(n-1)
     * ~Theta(n) which is <tt>linear function</tt> of <tt>n</tt>.
     *
     * <p>Worst-case, also named as upper bound, T(<tt>n</tt>), is when the list is inversely sorted, which means t_j=(j-1) for any j.
     * In this case T(n)=c1*n+c2*(n-1)+c3*(n-1)+c4*(sum^n_{j=2}(j-1))+c5*(sum^n_{j=2}{j-2})+c6*(sum^n_{j=2}{j-2})+c7*(n-1)
     * ~Theta(n^2) which is <tt>quadratic function</tt> of <tt>n</tt>.
     */
    @Override
    public <T extends Comparable<T>> void sort(List<T> tobeSorted) {
        //start with the second card j
        for (int j = 1; j < tobeSorted.size(); j++) {/**cost=c1 , count=n*/
            T key = tobeSorted.get(j);/**cost=c2 , count=n-1*/
            //start the comparison with (j-1)th card
            int i = j - 1;/**cost=c3 , count=n-1*/
            //compare with j-1,j-2,...,1
            while (i > 0 && key.compareTo(tobeSorted.get(i)) < 0 ? true : false) {/**cost=c4 , count=sum^n_{j=2}t_j*/
                tobeSorted.set(i + 1, tobeSorted.get(i));/**cost=c5 , count=sum^n_{j=2}{t_j-1}*/
                i = i - 1;/**cost=c6 , count=sum^n_{j=2}{t_j-1}*/
            }
            //jump out the loop because the ith element is smaller than the key.
            //Therefore, we put the key to the (i+1)th position.
            tobeSorted.set(i + 1,key);/**cost=c7 , count=n-1*/
        }
    }
}
