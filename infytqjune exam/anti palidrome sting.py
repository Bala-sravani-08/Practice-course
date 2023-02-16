n = int(input())
for i in range(n):
    s=input()
    if(s==s[::-1]):
        print(-1)
    else:
        ls=[]
        for j in s:
            ls.append(j)
        ls.sort()
        res ="".join(i for i in ls)
        print(res)
