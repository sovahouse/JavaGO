public class BitsPalindrome {
    public boolean isPalindrome(int input) {

        if(input == Integer.reverse(input)) {

            return true;

        } else {

            return false;

        }

    }
}