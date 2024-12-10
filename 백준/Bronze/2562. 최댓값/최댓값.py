import sys

#최대값을 구하기 위한 전역변수 설정
num_list = []
max = -1
max_idx = -1

#배열에 추가된 숫자 중 가장 큰 수를 max, max_idx 변수에 업데이트한다.
for i in range(9):
    num = int(sys.stdin.readline())
    num_list.append(num)

    if num_list[i] > max:
        max = num_list[i]
        max_idx = i+1

print(max)
print(max_idx)


