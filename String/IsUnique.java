//
//  Problem Statement
//  Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional datastructure.
//

public class Main {
    //Solution when additional data structure is applicable
    public static boolean IsAllUnique(String word) {
        if (word.length() > 128) return false;
        boolean[] checker = new boolean[128];
        for (char ch : word.toCharArray()) {
            if (checker[ch]) {
                return false;
            }
            checker[ch] = true;
        }
        return  true;
    }

    //Solution without additional data structure
    //This solution is based on bit manipulation
    //Assumption word only consist of lower/upper case character.
    //In below considering word only consist of lower case character.

    /*
    * DRY RUN
    * word = "abca"
    *  _________________________________________________________________________________________________________
    * | checker     |   charVal         |   (1 << charVal)          |   (checker & 1 << charVal) > 0)           |
    * |-------------|-------------------|---------------------------|-------------------------------------------|
    * | 0           |   0 (a - a)       |   1 << 0 = 1              |   0 & 0 = 0 --> false                     |
    * | 0 | 1 = 1   |   1 (b - a)       |   1 << 1 = 1 0            |   0 1 & 1 0 = 0 0 --> false               |
    * | 1 | 2 = 3   |   2 (b - a)       |   1 << 2 = 1 0 0          |   0 1 1 & 1 0 0 = 0 0 0 --> false         |
    * | 3 | 4 = 5   |   0 (a - a)       |   1 << 0 = 1              |   1 1 1 & 0 0 1 = 0 0 1 --> true          |
    * |-------------|-------------------|---------------------------|-------------------------------------------|
    *
    * In case of duplicate value "(checker & 1 << charVal) > 0)" will result true.
    *
    * */
    public static boolean IsAllUniqueWOD(String word) {
        int checker = 0;
        for (char ch : word.toCharArray()) {
            int charVal = ch - 'a';
            if ((checker & 1 << charVal) > 0) {
                return false;
            }
            checker |= (1 << charVal);
        }
        return true;
    }
}
