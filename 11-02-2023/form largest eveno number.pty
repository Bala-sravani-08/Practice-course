s=input()
res=[]
for i in s:
    if(i.isdigit()):
        res.append(int(i))
res =list(set(res))
small =1
for i in res:
    if(i%2==0):
        small =i
        res.remove(i)
        break
if(small%2==0):
    ans = "".join(str(i) for i in res)
    ans =ans[::-1]
    ans+=str(small)
    print(ans)
else:
    print(-1)
