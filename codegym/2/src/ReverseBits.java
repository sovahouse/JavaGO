public class ReverseBits {



    public int reverse(int input) {
        System.out.println(Integer.toString(input, 2));
        input = (input & 0x55555555) << 1 | (input >>> 1) & 0x55555555;

        // 0000 0000 0000 0000 0000 0000 0001 0011 input
        // 0101 0101 0101 0101 0101 0101 0101 0101 mask
        // 0000 0000 0000 0000 0000 0000 0001 0001 &
        // 0000 0000 0000 0000 0000 0000 0010 0010 << 1

        // 0000 0000 0000 0000 0000 0000 0001 0011 input
        // 0000 0000 0000 0000 0000 0000 0000 1001 >>> 1
        // 0101 0101 0101 0101 0101 0101 0101 0101 mask
        // 0000 0000 0000 0000 0000 0000 0000 0001 &

        // 0000 0000 0000 0000 0000 0000 0010 0011 result


        System.out.println(Integer.toString(input, 2));
        input = (input & 0x33333333) << 2 | (input >>> 2) & 0x33333333;

        // 0000 0000 0000 0000 0000 0000 0010 0011 input
        // 0011 0011 0011 0011 0011 0011 0011 0011 mask
        // 0000 0000 0000 0000 0000 0000 0010 0011 &
        // 0000 0000 0000 0000 0000 0000 1000 1100 << 2

        // 0000 0000 0000 0000 0000 0000 0010 0011 input
        // 0000 0000 0000 0000 0000 0000 0000 1000 >>> 2
        // 0011 0011 0011 0011 0011 0011 0011 0011 mask
        // 0000 0000 0000 0000 0000 0000 0000 0000 &

        // 0000 0000 0000 0000 0000 0000 1000 1100 result



        System.out.println(Integer.toString(input, 2));
        input = (input & 0x0f0f0f0f) << 4 | (input >>> 4) & 0x0f0f0f0f;

        // 0000 0000 0000 0000 0000 0000 0011 0000 input
        // 1111 0000 1111 0000 1111 0000 1111 0000 mask
        // 0000 0000 0000 0000 0000 0000 0011 0000 &
        // 0000 0000 0000 0000 0000 0011 0000 0000 << 4

        // 0000 0000 0000 0000 0000 0000 0011 0000 input
        // 0000 0000 0000 0000 0000 0000 0000 0011 >>> 4
        // 1111 0000 1111 0000 1111 0000 1111 0000 mask
        // 0000 0000 0000 0000 0000 0000 0000 0000 &

        // 0000 0000 0000 0000 0000 0011 0000 0000 result



        System.out.println(Integer.toString(input, 2));
        input = (input << 24) | ((input & 0xff00) << 8) |
                ((input >>> 8) & 0xff00) | (input >>> 24);

        // 0000 0000 0000 0000 0000 0011 0000 0000 input
        // 0000 0000 0000 0000 0000 0000 0000 0000 << 24

        // 0000 0000 0000 0000 0000 0011 0000 0000 input
        // 1111 1111 0000 0000 1111 1111 0000 0000 mask
        // 0000 0000 0000 0000 0000 0011 0000 0000 &
        // 0000 0000 0000 0011 0000 0000 0000 0000 << 8

        // 0000 0000 0000 0000 0000 0011 0000 0000 input
        // 0000 0000 0000 0000 0000 0000 0000 0011 >>> 8
        // 1111 1111 0000 0000 1111 1111 0000 0000 mask
        // 0000 0000 0000 0000 0000 0000 0000 0000 &

        // 0000 0000 0000 0000 0000 0011 0000 0000 input
        // 0000 0000 0000 0000 0000 0000 0000 0000 >>> 24


        // 0000 0000 0000 0000 0000 0000 0000 0000
        // 0000 0000 0000 0011 0000 0000 0000 0000
        // 0000 0000 0000 0000 0000 0000 0000 0000
        // 0000 0000 0000 0000 0000 0000 0000 0000


        // 0000 0000 0000 0011 0000 0000 0000 0000




        System.out.println(Integer.toString(input, 2));
        return input;
     }
}