 public static int superDigit(String n, int k) {
    // Write your code here
    char[] c = n.toCharArray();
        long sum = 0;
        for (int i = 0; i < c.length; i++) {
            int a = Integer.parseInt(String.valueOf(c[i]));
            sum = sum + a;
        }
        
        sum = sum * k;
        char[] chars = ("" + sum).toCharArray();
        return getTotalSum(chars);
    }
