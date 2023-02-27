//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[2*N];
            for(int i = 0;i < 2*N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minThrow(N, arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java


class Solution{
    static int minThrow(int N, int arr[]){
        // code here
         int[] board = new int[31];

        // Fill all values in the board with -1

        Arrays.fill(board, -1);

        // Loop through the input array and update the board with special cells

        for (int i = 0; i <= arr.length - 2; i += 2) {

            board[arr[i]] = arr[i + 1];

        }

        // Create a queue to store cells to be visited

        Queue<Integer> queue = new LinkedList<>();

        // Offer cell 1 to the queue

        queue.offer(1);

        // Create a boolean array to keep track of visited cells

        boolean[] visited = new boolean[31];

        // Initialize a variable to keep track of number of dice throws

        int move = 0;

        // Keep looping until the queue is empty

        while (!queue.isEmpty()) {

            // Get the number of elements in the queue

            int qsize = queue.size();

            // Loop through all elements in the queue

            for (int size = qsize; size > 0; size--) {

                // Get the next cell from the queue

                int num = queue.poll();

                // If the cell has been visited, continue to the next iteration

                if (visited[num])

                    continue;

                // Mark the cell as visited

                visited[num] = true;

                // Check if the cell is cell 30

                if (num == 30)

                    return move;

                // Loop through the possible dice throws (1 to 6)

                for (int i = 1; i <= 6 && num + i <= 30; i++) {

                    int next = num + i;

                    // Check if the next cell has a special value in the board

                    if (board[next] != -1)

                        next = board[next];

                    // If the next cell has not been visited, offer it to the queue

                    if (!visited[next])

                        queue.offer(next);

                }

            }

            // Increment the number of dice throws

            move++;

        }

        // Return -1 if cell 30 could not be reached

        return -1;
    }
}