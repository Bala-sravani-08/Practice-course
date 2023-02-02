def plusMinus(arr):
    # Write your code here
    x,z,y=0,0,0
    for i in range(0,len(arr)):
        if arr[i]>0:
            x = x + 1
        elif arr[i]<0:
            y = y + 1
        else:
            z = z + 1
    print(x/len(arr))
    print(y/len(arr))
    print(z/len(arr))
