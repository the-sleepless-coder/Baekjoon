import sys
read = sys.stdin.readline

sum = 0 
num_list = []
for i in range(9):
    num = int(read().strip())
    num_list.append(num)
    sum+=num_list[i]
rmn = sum - 100

for i in range(len(num_list)):
    for j in range(len(num_list)-1-i):
        if num_list[j]>num_list[j+1]:
            num_list[j], num_list[j+1] = num_list[j+1], num_list[j]

idx1=-1
idx2=-1
for i in range(9):
    for j in range(i+1, 9):
        temp = num_list[i]
        temp += num_list[j]
        if temp == rmn:
            idx1=i
            idx2=j

for i in range(9):
    if i == idx1 or i==idx2:
        continue
    print(num_list[i])

