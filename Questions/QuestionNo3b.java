public class QuestionNo3b {
    public static boolean matches(String input, String pattern) {
        int inputIndex = 0;
        int patternIndex = 0;
        int inputLength = input.length();
        int patternLength = pattern.length();
        while (inputIndex < inputLength && patternIndex < patternLength) {
            char currentChar = pattern.charAt(patternIndex);
            if (currentChar == '@') {
                patternIndex++;
                if (patternIndex == patternLength) {
                    return true; // The '@' character is at the end of the pattern, so it matches the rest of the input
                }
                char nextChar = pattern.charAt(patternIndex);
                while (inputIndex < inputLength && input.charAt(inputIndex) != nextChar) {
                    inputIndex++;
                }
                if (inputIndex == inputLength) {
                    return false; // Couldn't find the next character after '@' in the input
                }
            } else if (currentChar == '#') {
                inputIndex++;
                patternIndex++;
            } else if (input.charAt(inputIndex) == currentChar) {
                inputIndex++;
                patternIndex++;
            } else {
                return false; // The current character in the pattern does not match the corresponding character in the input
            }
        }
        return (inputIndex == inputLength && patternIndex == patternLength);
    }

    public static void main(String[] args) {
        String input = "tt";
        String pattern = "@";
        boolean isMatch = matches(input, pattern);
        System.out.println(isMatch);

        String input2 = "ta";
        String pattern2 = "t";
        boolean isMatch2 = matches(input2, pattern2);
        System.out.println(isMatch2);

        String input3 = "ta";
        String pattern3 = "t#";
        boolean isMatch3 = matches(input3, pattern3);
        System.out.println(isMatch3);
    }
}
