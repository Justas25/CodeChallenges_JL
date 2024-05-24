package org.example;

import java.math.BigDecimal;
import java.util.*;


public class CodeChallenges {

    public static void main(String[] args) {

        System.out.printf("<<<---------------------------------->>>\n");
        System.out.printf("<<<------ CODE CHALLENGE TASKS ------>>>\n");
        System.out.printf("<<<---------------------------------->>>\n");
        //System.out.println("Number of iterations took: "+kaprekar(45));

        System.out.println("result:"+FivesAndThrees.only5and3(6));



    }

    //#1
    public static String wordReversal(String sentence) {
        System.out.println("Input string: "+sentence);
        //check if input sentence has quotes
        boolean quotes = false;
        if (sentence.startsWith("\"") && sentence.endsWith("\"")){
            sentence = sentence.substring(1,sentence.length()-1);
            quotes = true;
        }
        String[] words;
        words = sentence.split(" ");
        String newString="";
        //Separate words from the array's end
        for (int i= words.length-1;i>=0;i--) {
            //no space at the beginning of reversed sentence
            if (i== words.length-1) {
                //Make first word's first letter capital
                words[i]=words[i].substring(0,1).toUpperCase()+words[i].substring(1);
                newString = newString.concat(words[i]);
                //change last words capital letter to lowerCase
            } else if (i==0) {
                words[i]=words[i].substring(0,1).toLowerCase()+words[i].substring(1);
                newString = newString.concat(" "+words[i]);
            } else newString = newString.concat(" "+words[i]);
        }
        //add quotes if original sentence had ones
        if (quotes) {
            newString = "\""+newString+"\"";
        }
        System.out.println("Output string: "+newString);
        return newString;
    }

    //#2
    //takes array of words and groups to separate anagram lists
    public static List<List<String>> groupAnagrams(String[] words) {
        System.out.println("Provided array of words:"+ Arrays.stream(words).toList().toString());
        // Create a HashMap to store anagrams
        Map<String, List<String>> anagramMap = new HashMap<>();
        // Iterate through each word in the array
        for (String word : words) {
            // Sort the characters of the word
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            // If sortedWord is already a key in the map
            // append the word to the corresponding list
            if (anagramMap.containsKey(sortedWord)) {
                anagramMap.get(sortedWord).add(word);
            } else {
                // If sortedWord is not in the map, create a new key-value pair
                List<String> newList = new ArrayList<>();
                newList.add(word);
                anagramMap.put(sortedWord, newList);
            }
        }
        // Convert map values to list of lists
        System.out.println("Grouped Anagram Lists:");
        System.out.println("----------------------");
        List<List<String>> groupedAnagrams = new ArrayList<>(anagramMap.values());
        for (List<String> group:groupedAnagrams) {
            System.out.println(group);
        }
        return groupedAnagrams;
    }

    //#3
    //checks if two strings are anagrams
    //An anagram is a word or phrase formed by rearranging the letters of a different word or phrase
    public static boolean isAnagram(String word1,String word2) {
        if (word1.length()!=word2.length()) {
            return false;
        }
        char[] list1 = word1.toCharArray();
        char[] list2 = word2.toCharArray();
        Arrays.sort(list1);
        Arrays.sort(list2);
        return Arrays.equals(list1, list2);
    }

    //#4
    // Simple Integer number reverse Method. For a given input Integer number, returns number in reverse
    public static int numberReversal(Integer number){
        int numberToReverse = Math.abs(number);
        int reversedNumber=0;
        //List<Integer> array = new ArrayList<>();
        while (numberToReverse>0) {
            int mod = numberToReverse%10;
            reversedNumber = reversedNumber*10 + mod;
            numberToReverse /=10;
        }
        //if input number is negative, reversed number also negative
        return number < 0 ? reversedNumber * -1 : reversedNumber;
    }


    //#5
    //Method to print a decimal number in reverse order, Input a Bigdecimal number
    public static BigDecimal numberReversal(BigDecimal number){
        System.out.println("Input decimal number to be reversed: "+number);
            String reversedNumber="";
			// separate the integer part
			int integerPart = number.intValue();

			// separate the decimal part
			BigDecimal dp = number.remainder(BigDecimal.ONE);

			// convert the decimal part into an integer
			while(dp.remainder(BigDecimal.ONE).floatValue() > 0){
				dp = dp.movePointRight(1);
			}
			int decimalPart = dp.intValue();


			// reverse the decimal part
			Integer remainder;
			while((remainder = decimalPart % 10) != 0){
                reversedNumber = reversedNumber.concat(remainder.toString());
				decimalPart = decimalPart/10;
			}

            reversedNumber = reversedNumber.concat(".");

			// reverse the integer part
			while((remainder = integerPart % 10) != 0){
                reversedNumber=reversedNumber.concat(remainder.toString());
				integerPart = integerPart/10;
			}

            //covert string to BigDecimal
            BigDecimal newNumber = new BigDecimal(reversedNumber);

            // Determine the current number of decimal places
            int currentDecimalPlaces = newNumber.scale();

            // Calculate the difference between the current number of decimal places and 2
            int difference = currentDecimalPlaces-2;

            //move decimal point right by difference
            newNumber = newNumber.movePointRight(difference);
        System.out.println("Reversed decimal number: "+newNumber);
        return newNumber;
    }

    //#6
    //Armstrong number is a number that is equal to the sum of cubes of its digits
    public static boolean isArmstrongNumber(int number){
        int armstrong=0;
        //get digits count
        int count=0;
        int temp = number;
        while (temp>0) {
            count+=1;
            temp/=10;
        }
        //calculate number
        temp = number;
        while (temp>0){
            int mod = temp%10;
            armstrong = armstrong + (int)Math.pow(mod,count);
            temp/=10;
        }
        if (armstrong==number){
            return true;
        } else return false;

    }


    //#7
    //Get Armstrong number from 0 to input number
    public static List<Integer> getArmstrongNumbers(int finalNumber) {
        List<Integer> armstrongList = new ArrayList<>();
        for (int i=0;i<=finalNumber;i++) {
            if (isArmstrongNumber(i)) armstrongList.add(i);
        }
        System.out.println("--------------------------------------------");
        System.out.println("Armstrong numbers from 0 to "+finalNumber+" are these:");
        System.out.println("--------------------------------------------");
        System.out.println(armstrongList);
        return armstrongList;
    }

    //#8
    //Return max product of the two largest numbers
    public static double productMaximizer(double[] array){
        System.out.println("Array elements:");
        System.out.println(Arrays.stream(array)
                .mapToObj(Double::toString)
                .reduce((a,b)->a+" "+b)
                .orElse(""));

        double maxProduct = Double.NEGATIVE_INFINITY;
        double num1=0;
        double num2=0;
        for (int i=0;i< array.length;i++) {
            for (int j = i+1; j < array.length ; j++) {
                if (array[i]*array[j] > maxProduct) {
                    maxProduct = array[i]*array[j];
                    num1 = array[i];
                    num2 = array[j];
                }
            }
        }
        System.out.println("The two numbers that result in the largest product are: " + num1 + " and " + num2);
        System.out.println("Their product is: " + maxProduct);
        return maxProduct;
    }

    //#9
    //outputs all prime numbers between 2 and the input number.
    public static List<Integer> primeNumberCalculator(int inputNumber) {
        List<Integer> primeArray = new ArrayList<>();
        if (inputNumber <= 1) return primeArray;
        if (inputNumber == 2) {
            primeArray.add(2);
            return primeArray;
        }
        if (inputNumber>=3) {
            primeArray.add(2);
            primeArray.add(3);
        }
        for (int i=5;i<=inputNumber;i+=2) {
            if (isPrime(i)) {primeArray.add(i);
            }
        }
        System.out.println(primeArray);
        return primeArray;
    }

    //#10
    //checks if number is prime
    public static boolean isPrime(int n) {
        // Check base cases
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        // Check divisibility from 5 up to sqrt(n)
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    //#11
    //Outputs prime factors of a Long number between 2 and Long.MAX_VALUE (9223372036854775807)
    //Trial division algorithm
    public static ArrayList<Long> primeFactors(long n) {
        System.out.println("Number "+n+" prime factors are:");
        // Print the number of 2s that divide n
        ArrayList<Long> primeFactors = new ArrayList<>();
        while (n % 2 == 0) {
            primeFactors.add(2L);
            n /= 2;
        }
        // n must be odd at this point.  So we can
        // skip all even numbers (Note i = i +2)
        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            // While i divides n, save i and divide n
            while (n % i == 0) {
                primeFactors.add(i);
                n /= i;
            }
        }
        //If the value of n is greater than 2 after all divisions, it means n itself is a prime factor
        if (n > 2) {
            primeFactors.add(n);
        }
        System.out.println(primeFactors);
        return primeFactors;

    }

    //#12 RECURSION
    //Recursion method, returns digits count
    public static int digitsCount(int n) {
        n = Math.abs(n);
        int result;
        if (n<10) {
            return 1;
        }
        result = digitsCount(n/10) + 1;
        return result;
    }

    //#13 RECURSION
    //A number is said to be Harshad if it's exactly divisible by the sum of its digits
    public static boolean isHarshad(int n){
        return n%digitsSum(n)==0;
    }

    private static int digitsSum(int n){
        int sum;
        //base case
        if (n<10) {
            return n;
        }
        sum = n%10 + digitsSum(n/10);
        return sum;
    }

    //14 RECURSION
    //Checks if number is factorial of a number
    public static boolean isFactorial(int n) {
       return isFactorialHelper(n,1);
    }

    private static boolean isFactorialHelper (int n, int i) {
        if (n==1&&i==1){
            System.out.println("Is factorial of number: " + i);
            return true;
        }
        if (n==1) {
            i-=1;
            System.out.println("Is factorial of number: " + i);
            return true;
        }
        if (n%i!=0) return false;
        System.out.println("n: "+n+ " i= :"+i);
        return isFactorialHelper(n/i,i+1);

    }

    //#14a
   //Checks if number is factorial of a number
    public static boolean isFactorialLoop(int n) {
        int i=1;
        System.out.println("Given number: "+n);
        while (n>=1) {
            if(n%i==0) {
                n=n/i;
                if (n>1) i++;
                else {
                    System.out.println("This number is factorial of: "+i);
                    return true;
                }
            } else return false;
        }
        return false;
    }


    //#15 RECURSION
    //palindrome is a word that reads the same backwards as forwards
    public static boolean isPalindrome(String word) {
        if (word.length()<=1) return true;
        if (word.charAt(0)== word.charAt(word.length()-1)) return isPalindrome(word.substring(1,word.length()-1));
        else return false;
    }

    //16 RECURSION
    //A number is called happy if it leads to 1 after a sequence of steps where in each step number is
    // replaced by the sum of squares of its digit .
    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        return isHappy(n,seen);

    }
    private static boolean isHappy(int n, Set<Integer> seen) {
        if (n==1) return true; // Base case: if n is 1, it is a happy number
        if (seen.contains(n)) return false; // If n is already in the set, it's a cycle and not happy
        seen.add(n);
        int newNumber=0;
        while (n>0) {
            int digit = n%10;
            newNumber+= digit*digit;
            n=n/10;
        }
        return isHappy(newNumber,seen);
    }

    //#17RECURSION
    //a recursive function that transforms a multi-dimensional array into a single-dimensional array.
    public static Object[] flatten(Object[] arr) {
        List<Object> result = new ArrayList<>();
        flattenHelper(arr,result);
        System.out.println(result.toString());
        return result.toArray();

    }
    private static void flattenHelper(Object[] arr, List<Object> result){
        for (Object element:arr) {
            if(element instanceof Object[]) {
                flattenHelper((Object[])element,result);
            }
            else result.add(element);
        }

    }

    //#18RECURSION
    //Kaprekar constant, or 6174, is a constant that arises when we take a 4-digit integer,
    // form the largest and smallest numbers from its digits, and then subtract these two numbers.
    // Continuing with this process of forming and subtracting, we will always arrive at the number 6174.
    /*
    0. Take any four-digit number, using at least two different digits (leading zeros are allowed).
    1. Arrange the digits in descending and then in ascending order to get two four-digit numbers
    , adding leading zeros if necessary.
    2. Subtract the smaller number from the bigger number.
    3. Go back to step 2 and repeat.
    //Returns the number of times it will take to get from a number to 6174
     */
    public static int kaprekar(int num) {
        return kaprekarHelper(num,1);
    }

    private static int kaprekarHelper(int num, int iteration) {
        int max_number = sortDigits(num, Collections.reverseOrder());
        while (max_number<1000) max_number*=10;
        int min_number = sortDigits(num, Comparator.naturalOrder());
        System.out.println("Max: "+max_number);
        System.out.println("Min: "+min_number);
        int newNumber = max_number-min_number;
        System.out.println("New number: "+newNumber);
        if (newNumber==6174) return iteration;
        else return kaprekarHelper(newNumber, iteration+1);
    }


    //sorts numbers digits and returns new number
    public static int sortDigits(int number, Comparator<Character> comparator) {
        // Convert the integer to a string
        String numberStr = Integer.toString(number);

        // Convert the string to a character array
        Character[] digits = new Character[numberStr.length()];
        for (int i = 0; i < numberStr.length(); i++) {
            digits[i] = numberStr.charAt(i);
        }

        // Sort the character array in reverse order
        Arrays.sort(digits, comparator);

        // Convert the sorted character array back to a string
        StringBuilder sortedStr = new StringBuilder(digits.length);
        for (char digit : digits) {
            sortedStr.append(digit);
        }

        // Convert the string back to an integer
        return Integer.parseInt(sortedStr.toString());
    }

    //#19


}




