n=input()
ls=[]
ans=[]
def ispronic(i):
    if(i==0):
        return False
    n =int(int(i)**(0.5))
    if(n*(n+1)==int(i)):
        return True
    return False
for i in range(len(n)):
    for j in range(i+1,len(n)+1):
        ls.append(int(n[i:j]))
ls=list(set(ls))
for i in ls:
    if(ispronic(i)):
        ans.append(i)
ans.sort()
res=",".join(str(i) for i in ans)
if(len(res)==0):
    print(-1)
else:
    print(res)
