def lonelyinteger(a):
    que = 0
    for element in a:
        que ^= element
    return que
