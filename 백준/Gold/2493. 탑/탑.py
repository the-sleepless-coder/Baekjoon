import sys
read = lambda: sys.stdin.readline().strip()
    
n = int(read())
building_list = list(map(int,read().split()))
stack = []
result = []

for i in range(n):
    while stack and stack [-1][1] < building_list[i]:
        stack.pop()
    
    if stack:
        result.append(stack[-1][0] + 1)
    else:
        result.append(0)
    
    stack.append([i, building_list[i]])

print(' '.join(map(str, result)))

    
    