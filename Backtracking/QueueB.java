import java.util.Queue;

public class QueueB {
    static class Queue{
       static int arr[];
       static int size;
       static int rear;

       Queue(int n){
        arr = new int[n];
        size = n;
        rear = -1;
       }

       //is_Empty function
       public static boolean isEmpty(){
        return rear == -1;
       }

       //Enqueue/add
       
       public static void Enqueue(int data){
        if(rear == size-1){
            System.out.println("Queue is full");
            return;
        }
        rear = rear+1;
        arr[rear] = data;
       }

       //dequeue/remove

       public static int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
         int front = arr[0];
         for(int i=0; i<rear; i++){
            arr[i] = arr[i+1];
         }
         rear = rear-1;
         return front;
       }

       //peek/ get in front

       public static int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
         return arr[0];
       }

    }
    public static void main(String[] args) {
            Queue q = new Queue(3);

            q.Enqueue(1);
            q.Enqueue(2);
            q.Enqueue(3);

            while(!q.isEmpty()){
                System.out.println(q.peek());
                q.dequeue();
            }
    }
}
