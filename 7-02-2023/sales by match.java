 public static int sockMerchant(int n, List<Integer> ar) {
    // Write your code here
        int c=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            
            int d=ar.get(i);
            if(map.containsKey(d)){
                int val=map.get(d);
                map.put(d,val+1);
            }else{
                map.put(d,1);
            }
        }for(Map.Entry m : map.entrySet()){
            c=c+((int)m.getValue()/2);
            System.out.println(m.getValue());    
   }        
        return c;
    }

}
