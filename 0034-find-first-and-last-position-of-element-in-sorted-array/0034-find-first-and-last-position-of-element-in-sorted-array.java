class Solution {
    public int[] searchRange(int[] a, int target) {
        int n = a.length;
        int temp[] = new int[2]; // we will create a temp array with size 2 as we know we need to store only 2 indexes in it
        temp[0] = -1;  // we will initialize firs element as -1 (default value to be assumed)
        temp[1] = -1;  // we will initialize firs element as -1 (default value to be assumed)

        // first for loop to find first index of target element
        for(int i=0; i<n; i++){
            if(a[i] == target){
                temp[0] = i;
                break;
            }
        }

        //second for loop to find the last index of the target element
        for(int i=0; i<n; i++){
            if(a[i] == target){
                temp[1] = i;
            }
        }
        
        // return answer of temp array
        return temp;
    }
}