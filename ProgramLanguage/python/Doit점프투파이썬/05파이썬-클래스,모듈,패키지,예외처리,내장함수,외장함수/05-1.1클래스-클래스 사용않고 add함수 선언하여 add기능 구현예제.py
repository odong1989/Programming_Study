result = 0

def add(num):
    global result   #결과값을 유지하기 위해서 전역변수 global 사용.
    result += num
    return result

print(add(3))
print(add(4))
