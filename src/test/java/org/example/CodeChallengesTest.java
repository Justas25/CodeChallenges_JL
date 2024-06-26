package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CodeChallengesTest {


    @Test //#1
    void wordReversal() {
        assertEquals("\"Man bites dog\"",CodeChallenges.wordReversal("\"Dog bites man\""));
        assertEquals("Man bites dog",CodeChallenges.wordReversal("Dog bites man"));
        assertEquals("Man bites bites dog",CodeChallenges.wordReversal("Dog bites bites man"));
    }

    @Test //#2
    void groupAnagrams() {
        String[] array = {"tar", "rat", "art", "meats", "steam", "rob"};
        List<List<String>> expectedList = new ArrayList<>(Arrays.asList(Arrays.asList("tar","rat","art"),Arrays.asList("rob"),Arrays.asList("meats","steam")));
        assertEquals(expectedList,CodeChallenges.groupAnagrams(array));
    }

    @Test //#3
    void isAnagramTest() {
        assertEquals(true,CodeChallenges.isAnagram("steam","meats"));
        assertEquals(false,CodeChallenges.isAnagram("Steam","meats"));
        assertEquals(false,CodeChallenges.isAnagram("steeam","meats"));
    }

    @Test //#4
    void numberReversalTest() {
        assertEquals(new BigDecimal("65563.91"),CodeChallenges.numberReversal(new BigDecimal("19365.56")));
    }

    @Test //#5
    void bigDecimalReversalTest(){
        assertEquals(new BigDecimal("65563.91"),CodeChallenges.numberReversal(new BigDecimal("19365.56")));
    }

    @Test //#6
    void isArmstrongNumber() {
        assertEquals(true,CodeChallenges.isArmstrongNumber(0));
        assertEquals(true,CodeChallenges.isArmstrongNumber(1));
        assertEquals(true,CodeChallenges.isArmstrongNumber(153));
        assertEquals(true,CodeChallenges.isArmstrongNumber(370));
        assertEquals(true,CodeChallenges.isArmstrongNumber(371));
        assertEquals(true,CodeChallenges.isArmstrongNumber(407));
        assertEquals(false,CodeChallenges.isArmstrongNumber(1635));
        assertEquals(false,CodeChallenges.isArmstrongNumber(8209));

    }

    @Test //#7
    void getArmstrongNumbersTest() {
        assertEquals(new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208)),CodeChallenges.getArmstrongNumbers(8208));
        assertEquals(new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315)),CodeChallenges.getArmstrongNumbers(10000000));


    }

    @Test //#8
    void productMaximizerTest() {
        double[] doublesArray = {2.5, 3.7, -1.2, 1.6, 2.5, 9.6};
        assertEquals(35.52, CodeChallenges.productMaximizer(doublesArray));
    }

    //#9
    @Test
    void primeNumberCalculatorTest() {
        //small range: 2
        testPrimeNumbersHelper(2, new ArrayList<>(Arrays.asList(2)));
        //small range: 10
        testPrimeNumbersHelper(10, new ArrayList<>(Arrays.asList(2, 3, 5, 7)));
        //Small Range Including Edge Case (No Primes Below 2): 1
        testPrimeNumbersHelper(1, new ArrayList<>()); // Edge case: no primes below 2
        //moderate range :30
        testPrimeNumbersHelper(30, new ArrayList<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)));
        //range with single prime: 3
        testPrimeNumbersHelper(3, new ArrayList<>(Arrays.asList(2, 3)));
        //large range: 100
        testPrimeNumbersHelper(100, new ArrayList<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97)));
        //edge case, largest possible integer(also prime number): Integer.MAX_VALUE = 2147483647
        //testPrimeNumbersHelper(2147483647, new ArrayList<>(Arrays.asList(2147483647)));
    }

    private void testPrimeNumbersHelper(int input, List<Integer> expected) {
        List<Integer> actual = CodeChallenges.primeNumberCalculator(input);
        assertEquals(expected, actual);
    }

    //#10
    @Test
    void isPrimeTest(){
        assertEquals(true,CodeChallenges.isPrime(1069));
        assertEquals(true,CodeChallenges.isPrime(4987));
        assertEquals(true,CodeChallenges.isPrime(2));
        assertEquals(true,CodeChallenges.isPrime(3));
        assertEquals(false,CodeChallenges.isPrime(1));
        assertEquals(false,CodeChallenges.isPrime(4988));
    }



    @Test //#11
    void primeFactorsTest() {
        //Small prime
        testPrimeFactorsHelper(13L, new ArrayList<>(Arrays.asList(13L)));
        //Small composite
        testPrimeFactorsHelper(18L, new ArrayList<>(Arrays.asList(2L, 3L, 3L)));
        //Large composite
        testPrimeFactorsHelper(100L, new ArrayList<>(Arrays.asList(2L, 2L, 5L, 5L)));
        //Prime number
        testPrimeFactorsHelper(29L, new ArrayList<>(Arrays.asList(29L)));
        //Composite number
        testPrimeFactorsHelper(56L, new ArrayList<>(Arrays.asList(2L, 2L, 2L, 7L)));
        //Edge Case - 1 (not prime and not composite): 1
        testPrimeFactorsHelper(1L, new ArrayList<>());
        //Edge case, very larger number - Long.MAX_VALUE
        testPrimeFactorsHelper(9223372036854775807L, new ArrayList<>(Arrays.asList(7L, 7L, 73L, 127L, 337L, 92737L, 649657L)));
        //small even number
        testPrimeFactorsHelper(8L, new ArrayList<>(Arrays.asList(2L, 2L, 2L)));
    }

    private void testPrimeFactorsHelper(long input, ArrayList<Long> expected) {
        ArrayList<Long> actual = CodeChallenges.primeFactors(input);
        assertEquals(expected, actual);
    }

    @Test //#12
    void digitsCountTest() {
        assertEquals(4,CodeChallenges.digitsCount(1225));
        assertEquals(10,CodeChallenges.digitsCount(Integer.MAX_VALUE));
        assertEquals(4,CodeChallenges.digitsCount(-1225));
    }

    @Test //#13
    void isHarshadTest() {
        assertEquals(true,CodeChallenges.isHarshad(21));
        assertEquals(false,CodeChallenges.isHarshad(75));
    }

    @Test //#14
    void isFactorialTest() {
        assertEquals(true,CodeChallenges.isFactorial(2));
        assertEquals(false,CodeChallenges.isFactorial(16));
        assertEquals(true,CodeChallenges.isFactorial(24));
        assertEquals(false,CodeChallenges.isFactorial(36));
        assertEquals(true,CodeChallenges.isFactorial(120));
        assertEquals(false,CodeChallenges.isFactorial(721));
        assertEquals(false,CodeChallenges.isFactorial(3));

    }

    @Test //#14b
    void isFactorialLoopTest() {
        assertEquals(true,CodeChallenges.isFactorialLoop(1));
        assertEquals(false,CodeChallenges.isFactorialLoop(16));
        assertEquals(true,CodeChallenges.isFactorialLoop(24));
        assertEquals(false,CodeChallenges.isFactorialLoop(36));
        assertEquals(true,CodeChallenges.isFactorialLoop(120));
        assertEquals(false,CodeChallenges.isFactorialLoop(721));
        assertEquals(false,CodeChallenges.isFactorialLoop(3));

    }

    @Test //#15
    void isPalindromeTest(){
        assertEquals(false,CodeChallenges.isPalindrome("rascal"));
        assertEquals(true,CodeChallenges.isPalindrome("racecar"));
        assertEquals(true,CodeChallenges.isPalindrome("madam"));
        assertEquals(false,CodeChallenges.isPalindrome("adieu"));
        assertEquals(true,CodeChallenges.isPalindrome("radar"));
        assertEquals(true,CodeChallenges.isPalindrome("rotor"));
        assertEquals(false,CodeChallenges.isPalindrome("abacus"));
        assertEquals(true,CodeChallenges.isPalindrome("rotator"));
        assertEquals(false,CodeChallenges.isPalindrome("scholars"));
        assertEquals(true,CodeChallenges.isPalindrome("rotaator"));
        assertEquals(false,CodeChallenges.isPalindrome("Not a palindrome"));
        assertEquals(true,CodeChallenges.isPalindrome("A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal-Panama!"));
        assertEquals(true,CodeChallenges.isPalindrome("Go hang a salami, I'm a lasagna hog!"));
        assertEquals(false,CodeChallenges.isPalindrome("This phrase is really this!"));
        assertEquals(true,CodeChallenges.isPalindrome("Red rum, sir, is murder."));
        assertEquals(true,CodeChallenges.isPalindrome("Big step on no pets, Gib"));
        assertEquals(false,CodeChallenges.isPalindrome("One true fortune, but no!"));
        assertEquals(true,CodeChallenges.isPalindrome("Don't nod."));
        assertEquals(true,CodeChallenges.isPalindrome("I did, did I?"));
        assertEquals(true,CodeChallenges.isPalindrome("My gym."));
        assertEquals(true,CodeChallenges.isPalindrome("Top spot."));
        assertEquals(true,CodeChallenges.isPalindrome("My gym."));
        assertEquals(true,CodeChallenges.isPalindrome("Was it a cat I saw?"));
        assertEquals(true,CodeChallenges.isPalindrome("No lemon, no melon."));
        assertEquals(true,CodeChallenges.isPalindrome("Eva, can I see bees in a cave?"));
        assertEquals(false,CodeChallenges.isPalindrome("Can I be iconic?"));
        assertEquals(true,CodeChallenges.isPalindrome("Madam I'm Adam."));
        assertEquals(false,CodeChallenges.isPalindrome("The man on the moon are them."));
        assertEquals(true,CodeChallenges.isPalindrome("Sit on a potato pan, Otis."));
        assertEquals(false,CodeChallenges.isPalindrome("Truly, a classic cadillac!"));
        assertEquals(true,CodeChallenges.isPalindrome("Able was I, ere I saw Elba."));
        assertEquals(true,CodeChallenges.isPalindrome("Step on no pets!"));


    }


    @Test //16
    void isHappyTest(){
        assertEquals(true,CodeChallenges.isHappy(1));
        assertEquals(true,CodeChallenges.isHappy(10));
        assertEquals(true,CodeChallenges.isHappy(44));
        assertEquals(false,CodeChallenges.isHappy(67));
        assertEquals(false,CodeChallenges.isHappy(89));
        assertEquals(true,CodeChallenges.isHappy(139));
        assertEquals(false,CodeChallenges.isHappy(1327));
        assertEquals(false,CodeChallenges.isHappy(2871));
        assertEquals(true,CodeChallenges.isHappy(3970));
        assertEquals(false,CodeChallenges.isHappy(5209));
        assertEquals(true,CodeChallenges.isHappy(6329));
        assertEquals(false,CodeChallenges.isHappy(8888));
        assertEquals(true,CodeChallenges.isHappy(9331));
        assertEquals(true,CodeChallenges.isHappy(10000));
    }

    @Test //#17
    void flattenTest(){

    Object[][] objVector = new Object[][] {
		{new Object[] {17.2, 500, "code"}, "generate"},
		{new Object[] {new Object[] {new Object[] {new Object[] {2, 14, "core"}}}, 2, 3, 4}},
		{new Object[] {"dimension"}, "vertical", new Object[] {new Object[] {"objective"}}},
		{new Object[] {new Object[] {new Object[] {new Object[] {new Object[] {"construct"}}}}}},
		{0, new Object[] {12, "recurrence", new Object[] {new Object[] {2}}}},
		{new Object[] {3.1415926, 3.2e5, "absolute", "edabit"}},
		{4, 6, 6, 6, new Object[] {579, 466, 876, 696}},
		{new Object[] {3.14, new Object[] {1.59, new Object[] {2.65, new Object[] {3.58, new Object[] {9.79}}}}}}
	};
	Object[][] resVector = new Object[][] {
		{17.2, 500, "code", "generate"},
		{2, 14, "core", 2, 3, 4},
		{"dimension", "vertical", "objective"},
		{"construct"},
		{0, 12, "recurrence", 2},
		{3.1415926, 320000.0, "absolute", "edabit"},
		{4, 6, 6, 6, 579, 466, 876, 696},
		{3.14, 1.59, 2.65, 3.58, 9.79}
	};
    assertArrayEquals(resVector[0],CodeChallenges.flatten(objVector[0]));
    assertArrayEquals(resVector[1],CodeChallenges.flatten(objVector[1]));
    assertArrayEquals(resVector[2],CodeChallenges.flatten(objVector[2]));
    assertArrayEquals(resVector[3],CodeChallenges.flatten(objVector[3]));
    assertArrayEquals(resVector[4],CodeChallenges.flatten(objVector[4]));
    assertArrayEquals(resVector[5],CodeChallenges.flatten(objVector[5]));
    assertArrayEquals(resVector[6],CodeChallenges.flatten(objVector[6]));
    assertArrayEquals(resVector[7],CodeChallenges.flatten(objVector[7]));
    }

    @Test //#18
    void kaprekarTEst(){
        assertEquals(5, CodeChallenges.kaprekar(1112));
        assertEquals(7, CodeChallenges.kaprekar(456));
        assertEquals(3, CodeChallenges.kaprekar(76));
        assertEquals(5, CodeChallenges.kaprekar(100));
        assertEquals(4, CodeChallenges.kaprekar(101));
    }

    @Test //#19
    void multiplyBy11Test() {
        assertEquals("121", CodeChallenges.multiplyBy11("11"));
        assertEquals("2127774", CodeChallenges.multiplyBy11("193434"));
        assertEquals("1222222221", CodeChallenges.multiplyBy11("111111111"));
        assertEquals("13345200220", CodeChallenges.multiplyBy11("1213200020"));
        assertEquals("13389177351", CodeChallenges.multiplyBy11("1217197941"));
        assertEquals("135802468864197531", CodeChallenges.multiplyBy11("12345678987654321"));
        assertEquals("104211199012633638785785900953", CodeChallenges.multiplyBy11("9473745364784876253253263723"));
        assertEquals("635783230909890532314447724963988510927543384582233109612769192056405578275705998540420364959788789519053403744017934787457261267552542543285435656175662404183030348849574039872257773944086571190888786847074756786564518203896815761793024453765630446693432922890436114349336495211031758681811992188070207300537435692693433611568697667003564013046540716780092199075001026112195705800164620258745160401995730248179648572857445719902139747183174704337379031002152460961006074198559739469164047819604029384", CodeChallenges.multiplyBy11("57798475537262775664949793178544410084322125871112100873888108368764143479609636230947305905435344501732127613092539526132478297050231140298675968743242036743911849895415821806568888540371506471898980622461341526051319836717892341981184041251420949699402992990039646759030590473730159880164726562551837027321585062972130328324427060636687637549685519707281109006818275101108700527287692750795014581999611840743604415714313247263830886107561336757943548272922950996455097654414521769924004347236729944"));
    }

    @Test //#20
    void multiplyBy11RecursionTest() {
        assertEquals("121", CodeChallenges.multiplyBy11re("11"));
        assertEquals("2127774", CodeChallenges.multiplyBy11re("193434"));
        assertEquals("1222222221", CodeChallenges.multiplyBy11re("111111111"));
        assertEquals("13345200220", CodeChallenges.multiplyBy11re("1213200020"));
        assertEquals("13389177351", CodeChallenges.multiplyBy11re("1217197941"));
        assertEquals("135802468864197531", CodeChallenges.multiplyBy11re("12345678987654321"));
        assertEquals("104211199012633638785785900953", CodeChallenges.multiplyBy11re("9473745364784876253253263723"));
        assertEquals("635783230909890532314447724963988510927543384582233109612769192056405578275705998540420364959788789519053403744017934787457261267552542543285435656175662404183030348849574039872257773944086571190888786847074756786564518203896815761793024453765630446693432922890436114349336495211031758681811992188070207300537435692693433611568697667003564013046540716780092199075001026112195705800164620258745160401995730248179648572857445719902139747183174704337379031002152460961006074198559739469164047819604029384", CodeChallenges.multiplyBy11("57798475537262775664949793178544410084322125871112100873888108368764143479609636230947305905435344501732127613092539526132478297050231140298675968743242036743911849895415821806568888540371506471898980622461341526051319836717892341981184041251420949699402992990039646759030590473730159880164726562551837027321585062972130328324427060636687637549685519707281109006818275101108700527287692750795014581999611840743604415714313247263830886107561336757943548272922950996455097654414521769924004347236729944"));
    }







}