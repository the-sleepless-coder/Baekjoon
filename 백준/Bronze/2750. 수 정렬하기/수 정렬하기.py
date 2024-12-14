import sys
read = sys.stdin.readline

n = int(read())

num_list = []
for i in range(n):
    num = int(read())
    num_list.append(num)

for i in range(n):
    for j in range(n-1-i):
        if num_list[j]>num_list[j+1]:
            num_list[j], num_list[j+1] = num_list[j+1], num_list[j]

for i in range(n):
    print(num_list[i])
