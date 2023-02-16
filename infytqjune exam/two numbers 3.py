lst= list(map(int,input().split(" ")))
first =0
second=0
mode =0
res = ""
for i in lst:
    
    if(i==5):
        mode  =1
    if(mode==1):
        res+=str(i)
    if(mode==0):
        first+=i
    if(i==8):
        mode =0
    
second =int(res)
print(first+second)
    
