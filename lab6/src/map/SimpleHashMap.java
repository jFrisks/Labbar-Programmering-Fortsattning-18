package map;

public class SimpleHashMap<K, V> implements Map<K, V>{
    private Entry<K, V>[] entries;
    private float loadFactor;
    private int capacity;
    private int size;

    public SimpleHashMap() {
        size = 0;
        loadFactor = .75f;
        capacity = 16;
        entries = (Entry<K, V>[]) new Entry[capacity];
    }
    public SimpleHashMap(int capacity) {
        size = 0;
        this.capacity = capacity;
        loadFactor = .75f;
        entries = (Entry<K, V>[]) new Entry[capacity];
    }

    @Override
    public V get(Object key) {
        //find key
            //if found
                //return found.value
            //if not
                //return null
        return null;
    }

    @Override
    public boolean isEmpty() {
        if(size <= 0) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public V put(K key, V value) {
        //Få hashcodeplats
        //lägg in ny entry i sista entry (entry.next == null)
        return null;
    }

    @Override
    public V remove(Object key) {
        //find key
            //if found
                //relink and remove
                //return value from deleted
            //if not
                //return null
        return null;
    }

    private Entry<K, V> find(K key) {
        //få index
        //Loopa igenom alla entries
            //returnera entry om den hittar
            //annars null
    }

    private int index(K key) {
        //fixa hashcoden
        //returnera var den borde ha för index
    }

    public String show(){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < entries.length; i++){
            Entry<K, V> currentEntry = entries[i];  //keeps track of current entry of all that collides

            //loopa igenom alla next
            while(entries[i] != null) {
                sb.append(i + "         " + entries[i].key.toString() + "=" +  entries[i].value.toString() + "\n");
                currentEntry = currentEntry.next;
            }
        }
        return sb.toString();
    }

    @Override
    public int size() {
        return size;
    }

    public static class Entry<K, V> implements Map.Entry<K, V>{
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
            next = null;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return value;
        }
    }
}
