public class Student{
    public static void main(String[] arg){
        Scanner gr = new Scanner(System.in);
        int n = gr.nextInt();
        int marks;
        for(int i=0;i<n;i++){
            marks = gr.nextInt();
            if(marks>=38){
                if((((marks/5)*5+5)-marks)<3){
                    marks = ((marks/5)*5+5);
                }
            }
            System.out.println(marks);
        }
    }
}
