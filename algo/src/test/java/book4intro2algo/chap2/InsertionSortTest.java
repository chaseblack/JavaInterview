package book4intro2algo.chap2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InsertionSortTest {
    InsertionSort insertionSort=null;
    List<Element<String>> elements=null;
    @Before
    public void setup(){
        insertionSort= new InsertionSort();
        elements=new ArrayList<Element<String>>(7);
        elements.add(new Element<String>("a",1));
        elements.add(new Element<String>("e",5));
        elements.add(new Element<String>("c",3));
        elements.add(new Element<String>("d",4));
        elements.add(new Element<String>("b",2));
        elements.add(new Element<String>("g",7));
        elements.add(new Element<String>("f",6));
        System.out.println("Before Sort: "+elements);
    }

    @Test
    public void sortTest(){
        insertionSort.sort(elements);
        System.out.println("After  Sort: "+elements);
    }
}
