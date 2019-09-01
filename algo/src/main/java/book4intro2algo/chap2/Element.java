package book4intro2algo.chap2;

/**
 * The object to be sorted.
 * */
public class Element<N> implements Comparable<Element<N>>{
    protected N name;
    protected int weight;

    public Element(N name, int weight){
        this.name=name;
        this.weight=weight;
    }

    @Override
    public int compareTo(Element o) {
        return weight-o.weight;
    }

    @Override
    public String toString(){
        return name+":"+weight;
    }
}
