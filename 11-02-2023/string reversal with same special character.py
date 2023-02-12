s=input()
front=[]
n=len(s)
res =""
for i in range(len(s)):
    if(s[i].isalnum()):
        front.append(s[i])
l=-1
for i in range(len(s)):
    if(s[i].isalnum()):
        res+=front[l]
        l-=1
    else:
        res+=s[i]
print(res)
