import java.util.ArrayList;

public class StackImplementedByArrayList {
    // Stack Implemented By ArrayList

    static class Stack{
        ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty(){
            return list.size() == 0;
        }


        //push
        public void push(int data){
            list.add(data);
        }

        //pop
        public int pop(){
            // first store the last element of arraylist and remove it and return 

            if(isEmpty()){
                //represent stack is empty
                return -1;
            }

            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        

        //peek
        public int peek(){
            // return last element as top

             if(isEmpty()){
                //represent stack is empty
                return -1;
            }

            int top = list.get(list.size()-1);
            return top;
        }

    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        // System.out.println(s.peek());

        // s.pop();

        // System.out.println(s.peek() );

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }

    }
}
