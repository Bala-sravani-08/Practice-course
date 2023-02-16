s=input()
ls=[]
for i in s:
    if(i.isdigit()):
        ls.append(int(i))
small=1
ls=list(set(ls))
for i in ls:
    if(i%2==0):
        small=i
        ls.remove(small)
        break
if(small %2==0):
    res = "".join(str(i) for i in ls)
    res=res[::-1]
    res+=str(small)
    print(res)
else:
    print(-1)
