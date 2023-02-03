def pangrams(s):
    alphabet = 'abcdefghijklmnopqrstuvwxyz'
    s = s.lower()
    for c in alphabet:
        if c not in s:
            return 'not pangram'
    return 'pangram'
