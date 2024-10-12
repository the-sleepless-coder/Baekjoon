import sys
read = sys.stdin.readline

N = int(read().strip())
case = int(read().strip())

graph = [[1,1], [N,N]]
for i in range(case):
    loc_list = list(map(int,read().strip().split()))
    graph.append(loc_list)

# 각 경찰차 1, 2에 따른 이동 거리를 나타낸다
dp = [[-1] * 1002 for _ in range(1002)]
# 어떤 경찰차가 출동했는지 확인한다
dp_trace = [[-1] * 1002 for _ in range(1002)]

# m번째 사건에서 n번째 사건 간 이동 거리를 구하는 코드이다
def calc(m, n):
    dist = abs(graph[m][0] - graph[n][0]) + abs(graph[m][1] - graph[n][1])

    return dist


# 경찰차가 각각 m, n 번째 사건을 해결했을 때 남은 사건이 갖는 이동거리의 최소값
def solve(m,n):
    dist = 0

    next = max(m,n)+1

    if next > case+1 :
        return 0
    
    if dp[m][n] != -1:
        return dp[m][n]
    
    # 첫번째 경찰차가 사건을 해결하는 거리를 계산
    calc1 = solve(next,n) + calc(m,next)    
    calc2 = solve(m, next) + calc(n, next)

    if calc1 < calc2:
        dp_trace[m][n] =1
        dp[m][n] = calc1
    else:
        dp_trace[m][n] = 2
        dp[m][n] = calc2
    
    dist = dp[m][n]

    return dist


print(solve(0,1))

# dp 추적을 이용해서, 어떤 경찰차가 출동했는지 확인한다 

m,n = 0,1
for i in range(2, case+2):
    print(dp_trace[m][n])
    if dp_trace[m][n] == 1:
        m = i
    else:
        n = i



# print(graph)
