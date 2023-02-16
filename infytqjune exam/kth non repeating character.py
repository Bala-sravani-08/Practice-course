s=input()
k=int(input())
j=0
for i in s:
    if(s.count(i)>1):
        continue
    j+=1
    if(j==k):
        print(i)
if(j<k):
    print(-1)
