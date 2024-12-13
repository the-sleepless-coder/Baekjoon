import sys
read = sys.stdin.readline

n = int(read())
testcase = list(map(int,read().strip().split()))

tot = 0
for i in range(n):
    cnt =0
    if testcase[i]<2:
        continue
    for j in range(2, int(testcase[i]**0.5)+1):
        if testcase[i]%j==0:
            cnt+=1
            break
    if cnt == 0:
        tot+=1
print(tot)
