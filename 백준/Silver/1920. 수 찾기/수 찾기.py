import sys
read = sys.stdin.readline

num1 = int(read().strip())
find_list = list(map(int,read().strip().split()))
find_list.sort()

num2 = int(read().strip())
num_list = list(map(int,read().strip().split()))

for i in range(len(num_list)):
    pl = 0
    pr = len(find_list)-1    
    while pl<=pr:
        pc = (pl+pr)//2
        if num_list[i] == find_list[pc]:
            print(1)
            break
        elif num_list[i]>find_list[pc]:
            pl = pc+1
        elif num_list[i]<find_list[pc]:
            pr = pc-1
            
        if pl>pr:
            print(0)
            break
    
    

        

    