public class LinkedListImplementation {
    public static class LinkedList{

        static class Node{
            String data;
            Node next;

            Node(String data){
                this.data = data;
                this.next = null;
            }
        }


        public static Node head;
        public static Node tail;
        private static int size ;


        // with generics basic structure
        // static class Node<D>{
        //     D data;
        //     Node next;

        //     Node(D data){
        //         this.data = data;
        //         this.next = null;
        //     }
        // }


        // add
        // add first 
        public void addFirst(String data){
            Node newNode = new Node(data);

            // if ll don't have any elements
            if(head == null){
                head = newNode;
                tail = newNode;
                size++;
                return;
            }

            // if LinkedList has already elements
            size++;
            newNode.next = head;
            head = newNode;
        }


        // add last
        public void addLast(String data){
            Node newNode = new Node(data);

            // if ll don't have any elements
            if(head == null){
                head = newNode;
                tail = newNode;
                size++;
                return;
            }

            // if ll have elemets
            Node currentNode = head;
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }

            size++;
            currentNode.next = newNode;
        }

        //printing ll
        public void printList(){
            if(head == null){
                System.out.println("LinkedList is Empty");
                return;
            }
            Node currentNode = head;
            while(currentNode != null){
                System.out.print(currentNode.data + " -> ");
                currentNode = currentNode.next;
            }
            System.out.println("null");
        }


        public void deleteFirst(){
            if(head == null){
                System.out.println("The LinkedList is empty");
                return;
            }

            size--;
            head = head.next;
        }


        public void deleteLast(){
            if(head == null){
                System.out.println("The LinkedList is empty");
                return;
            }

            size--;
            if(head.next == null){
                // in case of linkedlist contain only 1 node
                head = null;
                return;
            }

            Node secondNode = head;
            Node lastNode = head.next;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
                secondNode = secondNode.next;
            }

            secondNode.next = null;
        }


        public int length(){
            return size;
        }
    }



    public static void main(String[] args){
        LinkedList ll = new LinkedList();
        ll.addFirst("Raju");
        System.out.println(ll.size);
        ll.addFirst("Patil");
        ll.length();
        ll.printList();

        System.out.println(ll.size);

        ll.addLast("sham");
        ll.printList();
        System.out.println(ll.size);

        ll.deleteFirst();
        ll.printList();
        System.out.println(ll.size);

        ll.deleteLast();
        ll.printList();
        System.out.println(ll.length());
    }
}
