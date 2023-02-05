  public static int cookies(int k, List<Integer> A) {
    // Write your code here
         if (A == null || A.size() < 1) 
            return -1;
            
        PriorityQueue<Integer> jesse = new PriorityQueue<>();
        for (Integer a: A) {
            jesse.add(a);
        }
        int cnt = 0;
        while (jesse.size() > 1 && jesse.peek().intValue() < k) {
            int min = jesse.peek().intValue();
            int val = jesse.poll().intValue() + 2 * jesse.poll().intValue();
            if (val < min) 
              return -1;
            jesse.add(Integer.valueOf(val));
            cnt++;
        }
        if (jesse.size() == 0)
            return -1;

        if (jesse.peek().intValue() >= k) 
            return cnt;
        else 
            return -1;

    }
