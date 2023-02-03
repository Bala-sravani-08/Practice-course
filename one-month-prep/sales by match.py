def sockMerchant(n, ar):
    no = 0
    for i in range(0,n):
        gum = 1
        for j in range(i+1,n):
            if ar[i] == None:
                continue
            if ar[i] == ar[j] and gum ==1:
                no = no + 1
                gum = gum + 1
                ar[j] = None
            
    return no
