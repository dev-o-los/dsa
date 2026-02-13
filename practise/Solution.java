class Solution {
    static public int[] plusOne(int[] digits) {

        StringBuilder s = new StringBuilder();

        for (int digit : digits) {
            s.append(digit);
        }

        int num = Integer.parseInt(s.toString());
        num++;

        String newNum = Integer.toString(num);
        System.out.println(newNum);

        int[] array = new int[newNum.length()];
        for (int i = 0; i < array.length; i++) {
            array[i] = newNum.charAt(i);
            System.out.println(newNum.charAt(i));
        }

        System.out.println(array);

        return array;
    }

    public static void main(String[] args) {

        int[] a = { 1, 2, 3 };
        plusOne(a);
    }
}