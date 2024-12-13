import sys
read = sys.stdin.readline

n = int(read())

for i in range(n):
    result = ""
    testcase = read().strip().split()
    num = int(testcase[0])
    test = testcase[1]
    
    for j in range(len(test)):
        result+= test[j] * num
    print(result) 


