class Solution {
    public boolean halvesAreAlike(String s) {
        int count = 0;
        int half = s.length() / 2;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (isVowel(ch)) {
                if (i < half) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        return count == 0;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' ||
               ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' ||
               ch == 'O' || ch == 'U';
    }
}