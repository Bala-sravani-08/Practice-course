n =int(input())
s= input()
q= int(input())
ls=[]
for i in range(q):
    index = int(input())
    ele = s[:index-1].count(s[index-1])
    print(ele)
