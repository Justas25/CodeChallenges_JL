package org.example;

import java.util.HashMap;
import java.util.Map;



/*
Starting with either 3 or 5 and given these operations:
add 5
multiply by 3
Tells if it is possible to reach the target number n.
*/
public class FivesAndThrees {

    private static Map<Integer, Boolean> memo = new HashMap<>();

    public static boolean only5and3(int num) {
        // Clear memoization map before each call
        memo.clear();
        return only5and3Helper(num, 3) || only5and3Helper(num, 5);
    }
    private static boolean only5and3Helper(int num, int current) {
        // Base cases
        if (current == num) {
            return true;
        }
        if (current > num) {
            return false;
        }
        // Check memoization map
        if (memo.containsKey(current)) {
            return memo.get(current);
        }
        // Recursive calls
        boolean result = only5and3Helper(num, current + 5) || only5and3Helper(num, current * 3);
        memo.put(current,result);
        //System.out.println("Added to memo: "+current+" "+ memo.get(current));

        return result;

    }
}
