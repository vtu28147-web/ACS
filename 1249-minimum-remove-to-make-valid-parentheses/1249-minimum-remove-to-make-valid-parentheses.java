class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;

        // Remove invalid ')'
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                balance++;
                sb.append(ch);
            } 
            else if (ch == ')') {
                if (balance > 0) {
                    balance--;
                    sb.append(ch);
                }
            } 
            else {
                sb.append(ch);
            }
        }

        // Remove extra '(' from the end
        for (int i = sb.length() - 1; i >= 0 && balance > 0; i--) {
            if (sb.charAt(i) == '(') {
                sb.deleteCharAt(i);
                balance--;
            }
        }

        return sb.toString();
    }
}