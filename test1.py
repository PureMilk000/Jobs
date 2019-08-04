n = 3
a = [100,98,87]
q = 3

for i in range(q):
    xx = int(input().strip())
    pn = len(list(filter(lambda x:x<=a[xx-1], a)))
    p = (pn-1)/n*100
    p = str(round(p, 6))
    if p.split('.')[1] == '0':
        p += '00000'
    print(p)
