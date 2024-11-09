/* Partition Equal Subset Sum
Category	Difficulty	Likes	Dislikes
algorithms	Medium (46.68%)	12505	256
Tags
dynamic-programming

Companies
ebay

Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.*/
class Solution {
    public  boolean subset(int arr[],int sum){
       boolean dp[][] = new boolean[arr.length+1][sum+1];
       for(int i=0;i<dp.length;i++){
           dp[i][0] = true;
       }
       for(int j=1;j<dp[0].length;j++){
           dp[0][j] = false;
       }
       for(int i=1;i<dp.length;i++){
           for(int j=1;j<dp[0].length;j++){
               if(arr[i-1]<=j){
                   dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
               }else{
                   dp[i][j] = dp[i-1][j];
               }
           }
       }
       return dp[arr.length][sum];
   }
   
   public boolean canPartition(int[] nums) {
       int sum =0;
       for(int i:nums){
           sum +=i;
       }
       if(sum%2 !=0){
           return false;
       }
       return subset(nums,sum/2);
   }
}