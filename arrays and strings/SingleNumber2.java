class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;

        for(int i=0;i<32;i++){ //since integer has 32 bit size
           int sum = 0; //storing number of 1's at ith position
           for(int n:nums){ //loop through numbers in array
              if(((n>>i) & 1) == 1) sum++; //increment sum by 1 if its a set(1) bit
           }
           if(sum%3 != 0) //removes contributions from numbers that appear exactly three times
            res |= (1<<i); //sets that bit in result (keeps previous bits too).
          
        }

        return res; //we have the single number

    }
}