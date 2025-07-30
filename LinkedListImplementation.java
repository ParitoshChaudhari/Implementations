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


        // reverse ll
        public void reverseIterate(){
            if(head == null || head.next == null){
                // case in which ll is empty or only have 1 element
                return;
            }

            Node previousNode = head;
            Node currentNode = head.next;
            while(currentNode != null){
                Node nextNode = currentNode.next;

                currentNode.next = previousNode;
                //update
                previousNode = currentNode;
                currentNode = nextNode;
            }

            head.next = null;
            head = previousNode;
        }

        public Node reverseRecursive(Node head){
            if(head == null || head.next == null){
                return head;
            }

            Node newHead = reverseRecursive(head.next);
            head.next.next = head;
            head.next = null;

            return newHead;
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
        ll.deleteFirst();



        System.out.println("-------");
        ll.addLast("1");
        ll.addLast("2");
        ll.addLast("3");
        ll.addLast("4");
        ll.printList();
        
        System.out.println("Reverse ll");
        // ll.reverseIterate();
        ll.head = ll.reverseRecursive(ll.head);
        ll.printList();
        
    }
}
