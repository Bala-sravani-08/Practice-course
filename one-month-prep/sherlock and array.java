public static String balancedSums(List<Integer> arr) {
        int n = arr.size();
        int sumFor [] = new int [n];
        int sumBack [] = new int [n];
        sumFor[0] = arr.get(0);
        sumBack[n-1] = arr.get(n-1);
        for (int i = 1 ; i < n ; i++){
            sumFor[i] = arr.get(i) + sumFor[i-1];
        } 
        for (int i = n-2 ; i >= 0 ; i--){
            sumBack[i] = arr.get(i) + sumBack[i+1];
        }
        for (int i = 0 ; i < n; i++){
            if (sumFor[i] == sumBack[i]){
                return "YES";
            }
        }
        
        return "NO";

    }
