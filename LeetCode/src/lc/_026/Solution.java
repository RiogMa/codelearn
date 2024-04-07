package lc._026;

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while(q<nums.length){
            if(nums[p]!=nums[q]){
                nums[p+1]=nums[q];
                p++;
            }
            else {
                q++;
            }
        }
        return p;
    }
}
