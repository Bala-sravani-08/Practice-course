def twoArrays(k, A, B):
    A = sorted(A)
    B = sorted(B, reverse=True)
    for x,y in zip(A,B):
        if x+y<k:
            return "NO"
    return "YES"
