class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int j = 0;

        for (int value : pushed) {
            // Push the current value
            stack.push(value);

            // Pop whenever the top matches the next required value
            while (!stack.isEmpty() && 
                   stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }
}