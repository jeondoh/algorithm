n, m = list(map(int, input().split(' ')))  # 카드의 개수, 카드에 쓰여 있는 수
data = list(map(int, input().split(' ')))  # 카드에 쓰여 있는 수

result = 0

for i in range(0, n):
    for j in range(i + 1, n):
        for k in range(j + 1, n):
            sumResult = data[i] + data[j] + data[k]
            if sumResult <= m:
                result = max(result, sumResult)

print(result)