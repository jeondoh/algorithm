a = list(map(int, input().split(' ')))

ascending = True
descending = True

for i in range(1, 8):
    if a[i] > a[i - 1]:  # 오름차순 인 경우
        descending = False
    elif a[i] < a[i - 1]:  # 내림차순 인 경우
        ascending = False

if ascending:
    print('ascending')
elif descending:
    print('descending')
else:
    print('mixed')
