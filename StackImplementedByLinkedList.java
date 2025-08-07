import java.util.LinkedList;

public class StackImplementedByLinkedList {

    static class Stack{
        LinkedList<Integer> list = new LinkedList<>();

        public boolean isEmpty(){
            return list.size() == 0;
        }

        // push
        public void push(int data){
            list.addFirst(data);
        }

        //pop
        public int pop(){
            // first store the first element of LinkedList as top 
            // then remove it and return
            // if its already empty return -1
            if(isEmpty()){
                return -1;
            }

            int top = list.getFirst();
            list.removeFirst(); // it remove the first element as well as return the value which is removed
            // we can use this also , instead of above implementation
            // int top = list.removeFirst();

            return top;
        }

        public int peek(){
            // return LinkedList first element as top element 
            // if its empty return -1
            if(isEmpty()){
                return -1;
            }

            int top = list.getFirst();
            return top;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
