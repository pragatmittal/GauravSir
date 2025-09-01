class Solution {
    public static int f(int i,int target,int[][]dp,int[]nums){
        if(i==0)   {
            if(target==0 && nums[0]==0) return 2;
            if(target==0 || nums[0]==target)    return 1;
            return 0;
        }
        if(dp[i][target]!=-1)   return dp[i][target];
        int notTake=f(i-1,target,dp,nums);
        int take=0;
        if(nums[i]<=target){
            take=f(i-1,target-nums[i],dp,nums);
        }
        return dp[i][target]=take+notTake;

    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum=0;
        for (int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum<target){
            return 0;
        }
        if((sum-target)%2==1)   return 0;  // that is odd falso condition
        int s2=(sum-target)/2;
        int[][]dp=new int[n][s2+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);

        }
        return f(n-1,s2,dp,nums);



    }
}
