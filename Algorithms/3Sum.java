class Solution {

public List<List<Integer>> threeSum(int[] num) {
    //Sorting the array firstly, so can use 2Sum algo afterly.
    Arrays.sort(num);
    List<List<Integer>> res = new LinkedList<>(); 
    // DEL THE TWO INDEX(The Front and Rear)
    for (int i = 0; i < num.length-2; i++) {
    //depulicated
        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
        //Equal to 2Sum Algorithm
            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
            while (lo < hi) {
                if (num[lo] + num[hi] == sum) {
                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
                    //depulicated again
                    while (lo < hi && num[lo] == num[lo+1]) lo++;
                    while (lo < hi && num[hi] == num[hi-1]) hi--;
                    lo++; hi--;
                } else if (num[lo] + num[hi] < sum) lo++;
                else hi--;
           }
        }
    }
    return res;
}
}
