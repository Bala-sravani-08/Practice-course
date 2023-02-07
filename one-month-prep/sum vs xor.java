 public static long sumXor(long n) {
    // Write your code here
    int count = 0;
        for(char ch : Long.toBinaryString(n).toCharArray()){count+=(ch=='0') ? 1 : 0;}
        return (n!=0) ? (long) Math.pow(2, count) : 1;

    }
