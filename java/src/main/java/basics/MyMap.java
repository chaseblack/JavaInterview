package basics;

public class MyMap<K,V> {
    Entry<K,V>[]buckets;
    static final int initalCapacity=1<<4;
    int size=0;

    public MyMap(){
        this(initalCapacity);
    }

    public MyMap(int initalCapacity){
        buckets=new Entry[initalCapacity];
    }


    //check if key is identical
    public void put(K key, V value){
        Entry<K,V>entry=new Entry<K,V>(key,value,null);
        int bucket=key.hashCode()%initalCapacity;
        Entry<K,V>existing=buckets[bucket];
        if(existing==null){
            buckets[bucket]=entry;
            size++;
            return;
        }
        while(existing.next!=null){
            if(existing.key.equals(key)){
                existing.value=value;
                return;
            }
            existing=existing.next;
        }
        //existing now is the rear entry, we should check if the rear entry's key is the same as the given key
        if(existing.key.equals(key)){
            existing.value=value;
            return;
        }
        //the key is not identical, then we add the new entry to the rear entry
        existing.next=entry;
        size++;
        return;
    }



    public V get(K key){
        int bucket=key.hashCode()%initalCapacity;
        Entry<K,V>existing=buckets[bucket];
        if(existing==null){
            return null;
        }
        while(existing.next!=null){
            if(existing.key.equals(key)){
                return existing.value;
            }
            existing=existing.next;
        }
        //check the rear entry
        if(existing.key.equals(key)){
            return existing.value;
        }
        return null;
    }


    public static void main(String[]args){
        MyMap<String, String> myMap = new MyMap<String,String>();
        myMap.put("USA", "Washington DC");
        myMap.put("Nepal", "Kathmandu");
        myMap.put("India", "New Delhi");
        myMap.put("Australia", "Sydney");
        myMap.put("Nepal", "NoIdea");
        System.out.println(myMap.size);

        System.out.println(myMap.get("India"));
        System.out.println(myMap.get("Australia"));
        System.out.println(myMap.get("Nepal"));

    }






    class Entry<K,V>{
        final K key;
        V value;
        Entry next;

        public Entry(K key,V value,Entry next){
            this.key=key;
            this.value=value;
            this.next=next;
        }

        @Override
        public boolean equals(Object obj){
            if(obj==this)return true;
            if(obj instanceof Entry){
                Entry entry=(Entry)obj;
                return key.equals(entry.key) && value.equals(entry.value);
            }
            return false;
        }
    }
}
