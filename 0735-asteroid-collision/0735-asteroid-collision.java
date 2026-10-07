class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            while (!stack.isEmpty()
                    && stack.peek() > 0
                    && asteroid < 0) {

                int top = stack.peek();

                // Top asteroid is smaller
                if (top < -asteroid) {
                    stack.pop();
                    continue;
                }

                // Both are the same size
                if (top == -asteroid) {
                    stack.pop();
                }

                // Current asteroid is destroyed
                destroyed = true;
                break;
            }

            // Add current asteroid if it survived
            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}