"""
함수만으로 2개의 계산기를 구현하는 경우
 =>2개의 add함수를 선언해야 한다.
"""

result1=0
result2=0

#계산기-덧셈1
def add1(num):
    global result1
    result1 += num
    return result1

#계산기-덧셈2
def add2(num):
    global result2
    result2 += num
    return result2

#계산기-덧셈1 실행결과
print(add1(3))
print(add1(4))

#계산기-덧셈2 실행결과 
print(add2(100))
print(add2(300))
