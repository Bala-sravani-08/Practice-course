 public static String counterGame(long n) {
    // Write your code here
    int moves = 0;
        
        while (n >= 1) {
           
            if ((n & (n - 1)) == 0) {
                n = n / 2;               
            } else {           
                String binaryStr = Long.toBinaryString(n);
                                
                int binaryStrLength = binaryStr.length();                
                long closestPowerOf2 = (long) Math.pow(2, binaryStrLength - 1);
                
                n = n - closestPowerOf2;                
            }
            
            moves++;            
        }
        
        if (moves % 2 > 0) {
            return "Richard";
        } else {
            return "Louise";
        }

    }

}
