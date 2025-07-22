import java.util.ArrayList;
import java.util.LinkedList;

class HashMapImplementation {

    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // total no of nodes
        private int N; // total no of Buckets
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4; // threshold
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            // it should be always positive
            // it should be range of 0 to N-1
            int bucketIndex = key.hashCode();
            // hashCode -> can return negative also to convert into Positive taking abs
            return Math.abs(bucketIndex) % N;
        }

        private int searchInLinkedList(K key, int bucketIndex) {
            LinkedList<Node> ll = buckets[bucketIndex];

            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) {
                    return i; // dataindex
                }
            }

            // return -1 when key is not available
            return -1;
        }

        private void rehash() {
            LinkedList<Node> oldBucket[] = buckets;

            // new bucket with double capacity
            buckets = new LinkedList[N * 2];

            // initialization of LinkedList on bucket indexes
            for (int i = 0; i < N * 2; i++) {
                buckets[i] = new LinkedList<>();
            }

            // assigning values to new bucket
            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }

        }

        public void put(K key, V value) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLinkedList(key, bucketIndex);

            if (dataIndex == -1) {
                // key doesn't exist
                buckets[bucketIndex].add(new Node(key, value));
                n++;
            } else {
                // keys exists
                Node node = buckets[bucketIndex].get(dataIndex);
                node.value = value;
            }

            double lambda = (double) n / N;
            if (lambda > 2.0) {
                // rehashing
                rehash();
            }
        }

        public V get(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLinkedList(key, bucketIndex);

            if (dataIndex == -1) {
                // key doesn't exist
                return null;
            } else {
                // keys exists
                Node node = buckets[bucketIndex].get(dataIndex);
                return node.value;
            }

        }

        public boolean containsKey(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLinkedList(key, bucketIndex);

            if (dataIndex == -1) {
                // key doesn't exist
                return false;
            } else {
                // keys exists
                return true;
            }

        }

        public V remove(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLinkedList(key, bucketIndex);

            if (dataIndex == -1) {
                // key doesn't exist
                return null;
            } else {
                // keys exists
                Node node = buckets[bucketIndex].remove(dataIndex);
                n--; // reducing n size by 1 on element removal
                return node.value;
            }
        }

        public boolean isEmpty() {
            // hashmap is empty when no node is present in it
            // i.e node
            // if no node is present -> i.e hashmap is empty -> true
            // if nodes are present -> i.e hashmap is not empty -> false
            return n == 0;
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                // bucket index
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    // data index
                    Node node = ll.get(j);
                    keys.add(node.key);

                }
            }

            return keys;
        }

    }

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 120);
        map.put("US", 67);
        map.put("China", 210);
        map.put("japan", 29);


        ArrayList<String> keys = map.keySet();
        System.out.println(keys);

        for(int i=0;i<keys.size();i++){
            System.out.println(keys.get(i) + "->" + map.get(keys.get(i)));
        }

        map.remove("US");
        System.out.println(map.get("US"));
    }
}