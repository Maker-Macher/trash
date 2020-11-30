letter = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789'
password = 'aabd'
pw = [''] * len(password)


def convertToString(x):
    s = ''
    
    for i in x:
        s += i

    return s

        


for i in letter:
    pw[0] = i

    for i in letter:
        pw[1] = i

        for i in letter:
            pw[2] = i

            for i in letter:
                pw[3] = i
                if convertToString(pw) == password:
                    break


