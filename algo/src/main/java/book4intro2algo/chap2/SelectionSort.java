package book4intro2algo.chap2;

import java.util.List;

public class SelectionSort implements Sort {
    /**
     * @implSpec <p>Algorithm Analysis:
     * Input Size = tobeSorted.size(), assumes as <tt>s</tt>
     * Running Time T(s)=sumup(c_i*count_i)
     *
     * <p>The lower bound of T(s) equals to its upper bound, which is
     * T(s)=as^2+bs+c~\Theta(s^2)
     */
    @Override
    public <T extends Comparable<T>> void sort(List<T> tobeSorted) {
        int size = tobeSorted.size();/**cost=c1,count=1*/
        //the ith element to be replaced
        for (int i = 0; i < size-1; i++) {/**cost=c2,count=s*/
            //init the i as the index of the minimal
            int indexOfMinimal = i;/**cost=c3,count=s-1*/
            //find the minimal from tobeSorted[i] to tobeSorted[size-1]
            for (int j = i; j < size; j++) {/**cost=c4,count=sum^{s-1}_{i=0}{s-i+1}*/
                if (tobeSorted.get(indexOfMinimal).compareTo(tobeSorted.get(j)) > 0 ? true : false) {/**cost=c5,count=sum^{s-1}_{i=0}{s-i}*/
                    indexOfMinimal = j;/**cost=c6,count=sum^{s-1}_{i=0}{s-i}*/
                }
            }
            swap(tobeSorted, i, indexOfMinimal);/**cost=c7,count=s-1*/
        }
    }

    /**
     * Q: why swap works? should t be altered when tobeSorted.set(index1,tobeSorted.get(index2)) is triggered?
     * A: t, tobeSorted[index1], tobeSorted[index2] are all references.
     * Let's say the two objects stored in the memory are [index1], [index2].
     * The 3 lines of code animates the referencing process.
     */
    private static <T extends Comparable<T>> void swap(List<T> tobeSorted, int index1, int index2) {
        //tobeSorted[index1] --> [index1], tobeSorted[index2] --> [index2]
        T t = tobeSorted.get(index1);
        //tobeSorted[index1] --> [index1], t --> [index1], tobeSorted[index2] --> [index2]
        tobeSorted.set(index1, tobeSorted.get(index2));
        //tobeSorted[index1] --> [index2], t --> [index1], tobeSorted[index2] --> [index2]
        tobeSorted.set(index2, t);
        //tobeSorted[index1] --> [index2], t --> [index1], tobeSorted[index2] --> [index1]
    }
}
