class Solution {
    public boolean canTransform(String start, String result) {
        if (start.length() != result.length()) {
            return false;
        }
        
        int startIndex = 0;
        int resultIndex = 0;

        
        return canTransform(0, start, 0, result);
    }

    private boolean canTransform(int startIndex, String start, int resultIndex, String result) {
        while (startIndex < start.length() && start.charAt(startIndex) == 'X') {
            startIndex++;
        }

        while (resultIndex < result.length() && result.charAt(resultIndex) == 'X') {
            resultIndex++;
        }

        if (startIndex == start.length() && resultIndex == result.length()) {
            return true;
        }

        if ((startIndex == start.length() || resultIndex == result.length()) || start.charAt(startIndex) != result.charAt(resultIndex)) {
            return false;
        }

        if ((start.charAt(startIndex) == 'L' && startIndex >= resultIndex) || (start.charAt(startIndex) == 'R' && startIndex <= resultIndex)) {
            return canTransform(startIndex + 1, start, resultIndex + 1, result);
        }

        return false;
    }
}