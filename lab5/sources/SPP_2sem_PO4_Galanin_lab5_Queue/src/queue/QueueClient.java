package queue;

import java.util.Scanner;

public class QueueClient {

    /**
     * A test client.
     */
    public static void main(String[] args) {
        Queue<String> q = new Queue<String>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any word (add to the queue)");            // = = = = = = = =
        System.out.println("Enter word \"-\" (remove from the queue)");     // = = = = = = = =
        System.out.println();                                               // = = = = = = = =

        System.out.print("Word : ");                                        // = = = = = = = =
        while (scanner.hasNext()) {
            String item = scanner.next();
            if (!item.equals("-")) {
                q.enqueue(item);
            } else if (!q.isEmpty()) {
                System.out.print("Removed an element from the queue : ");   // = = = = = = = =
                System.out.println(q.dequeue() + " ");
            }
            System.out.println("The queue has " + q.size() + " elements");  // = = = = = = = =
            System.out.println();                                           // = = = = = = = =
            System.out.print("Word : ");                                    // = = = = = = = =
        }
        System.out.println(q.size());
    }
}
