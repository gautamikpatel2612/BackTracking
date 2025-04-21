# BackTracking
17. Letter Combinations of a Phone Number


![image](https://github.com/user-attachments/assets/f8ad71fb-76d5-42dc-abc4-0c160a57c29c)



![image](https://github.com/user-attachments/assets/f951b116-2bee-48a1-8b0d-f6003584330f)



![image](https://github.com/user-attachments/assets/b13b6df1-b050-4189-be6a-b20da9db85e0)



    class Solution {
      public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if(digits.length() == 0){   
            return result;
        }  

        HashMap<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        StringBuilder sb = new StringBuilder();                      
        back_t(0, sb, result, digits, phoneMap);
        return result;
    }

    private void back_t(int index, StringBuilder sb, List<String> result, String digits, HashMap<Character, String> phoneMap){
        
        if(index == digits.length()){
            result.add(sb.toString()); 
            return;
        }

        String inputDigit = phoneMap.get(digits.charAt(index)); 

        for(int i=0; i<inputDigit.length(); i++){
        
        sb.append(inputDigit.charAt(i)); 

        back_t(index+1, sb, result, digits, phoneMap);

        sb.deleteCharAt(sb.length()-1);
        }  
    }
    }

/*

    *****  sb.deleteCharAt(sb.length()-1);  ****

    2 = "abc"
    3 = "def"

    Starting index 0 -> " a b c "-> "ad", Now remove "d". make new combination "ae", Now remove "e". make new combination "af", Now remove "f". and then remove "a" as we are done with "a".

    Starting index 1 -> " a b c "-> "bd", Now remove "d". make new combination "be", Now remove "e". make new combination "bf", Now remove "f". and then remove "b" as we are done with "c".

    Starting index 2 -> " a b c "-> "cd", Now remove "d". make new combination "ce", Now remove "e". make new combination "cf", Now remove "f". and then remove "c" as we are done with "c".

    return all combinations.

*/


    TC: M^N -> M is the letters of 7 and 9. because 7 and 9 has maximum letters 4. rest of all has 3. N is the length of input digits. 
                so either 3^N or 4^N.
                
    SC: O(N) -> 
        Recursion stack:
        At most n recursive calls deep → O(n)
        StringBuilder (temporary):
        Uses up to n characters → O(n)
        Result list:
        Stores 3ⁿ strings, each of length n → O(n × 3ⁿ)
