  public static List<Integer> breakingRecords(List<Integer> scores) {
    // Write your code here
        int max =scores.get(0);
        int min=scores.get(0);
        int c1=0;
        int c2=0;
        for(int i=0;i<scores.size();i++){
            if( max < scores.get(i)){
                max = scores.get(i);
                c1++;
            }
            if( min > scores.get(i)){
                min = scores.get(i);
                c2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(c1);
        res.add(c2);
        return res;
    }
}
