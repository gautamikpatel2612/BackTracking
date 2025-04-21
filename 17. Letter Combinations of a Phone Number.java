class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        //IF THE GIVEN STRING IS EMPTY THEN RETURN RESULT LIST.
        if(digits.length() == 0){   
            return result;
        }  

        //CREATE A HASHMAP FOR <Character, String> TO STORE ALL THE STRING OF DIGITS.
        HashMap<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        StringBuilder sb = new StringBuilder(); // to append cur_string.                      
        back_t(0, sb, result, digits, phoneMap);
        return result;
    }

    private void back_t(int index, StringBuilder sb, List<String> result, String digits, HashMap<Character, String> phoneMap){
        
        //BASE CASE : If you reach end of the digit then add cur_string(sb) to result list -> digits = " 2 3 "
                                                                        //                                   ^
        if(index == digits.length()){
            result.add(sb.toString()); //Need to convert StringBuilder sb to String. -> sb.toString()
            return;
        }

        String inputDigit = phoneMap.get(digits.charAt(index)); 

        for(int i=0; i<inputDigit.length(); i++){
        
        sb.append(inputDigit.charAt(i)); 

        back_t(index+1, sb, result, digits, phoneMap);

        //remove the last character and make new combinations.
        sb.deleteCharAt(sb.length()-1);
        }  
    }
}

/*

*****  sb.deleteCharAt(sb.length()-1);  ****

2 = "abc"
3 = "def"

Starting index 0 -> " a b c "-> "ad", Now remove "d". make new combination "ae", Now remove "e". make new combination "af", Now remove "f". 
and then remove "a" as we are done with "a".

Starting index 1 -> " a b c "-> "bd", Now remove "d". make new combination "be", Now remove "e". make new combination "bf", Now remove "f". 
and then remove "b" as we are done with "c".

Starting index 2 -> " a b c "-> "cd", Now remove "d". make new combination "ce", Now remove "e". make new combination "cf", Now remove "f". 
and then remove "c" as we are done with "c".

return all combinations.

*/
