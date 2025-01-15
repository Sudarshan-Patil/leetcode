class Solution {
    public int minimizeXor(int num1, int num2) {
        int[] n1 = new int[32];
        int[] n2 = new int[32];
        int count1 = 0;
        int count2 = 0;
        for (int i=31; i>=0; i--) {
            if ((num2&1) == 1) {
                n2[i] = 1;
                count2++;
            }
            num2 >>= 1;
        }

        for (int i=31; i>=0; i--) {
            if ((num1&1) == 1) {
                n1[i] = 1;
                count1++;
            }
            num1 >>= 1;
        }
        if (count1 == count2) {
            return getNum(n1);
        }

        if (count1 > count2) {
            int temp = count1-count2;
            int i = 31;
            while (temp > 0) {
                if (n1[i] == 1) {
                    n1[i] = 0;
                    temp--;
                }
                i--;
            }

            return getNum(n1);
        } else {
            int temp = count2-count1;
            int i = 31;
            while (temp > 0) {
                if (n1[i] == 0) {
                    n1[i] = 1;
                    temp--;
                }
                i--;
            }

            return getNum(n1);
        }
    }

    public void display(int[] arr) {
        for (int i=0; i<32; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return;
    }

    public int getNum(int[] arr) {
        int num = 0;
        for (int i=0; i<32; i++) {
            if (arr[i] == 1) {
                num = (num<<1) | 1;
            } else {
                num = num<<1;
            }
        }

        return num;
    }
}