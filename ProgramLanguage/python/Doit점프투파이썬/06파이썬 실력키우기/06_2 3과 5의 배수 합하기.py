"""
6-2 문제
 : 10미만의 자연수에서 3과 5의 배수를 구하면 3,5,6,9이다.
 이들의 총합은 23이다.
 1000미만의 자연수에서 3의 배수와 5의 배수의 총합을 구하라.
"""

result =0
for i in range(1, 1000):
    if i%3 == 0:
        result = result+i
    if i%5 == 0:
        result = result+i
        
print("result : ",result)
