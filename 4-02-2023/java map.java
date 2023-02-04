class Solution{
	public static void main(String []args)
	{
        Map<String,Integer> jm = new HashMap<>();
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		in.nextLine();
		for(int i=0;i<n;i++)
		{
			String name=in.nextLine();
			int phone=in.nextInt();
			in.nextLine();
        jm.put(name,phone);    
		}
		while(in.hasNext())
		{
			String s=in.nextLine();
        if(jm.containsKey(s)){
            System.out.println(s+"="+jm.get(s));
        }    
        else{
            System.out.println("Not found");
        }    
		}
	}
}
