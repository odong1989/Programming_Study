'''
def gugudan(danCnt) :
    print(danCnt,"단을 출력합니다")
    for i in range(1,10) : # 2*1=2 ...2*9=18 식으로 뒤의 숫자는 1~9므로 range실시.
        print(danCnt," * ", i , " = ", danCnt*i)

danCnt = int(input("구구단의 단수를 입력하세요 : ") )
gugudan(danCnt)
'''

#함수정의
def sum(a,b) :
    print("%d과 %d의 더하기 결과는 %d 입니다." %(a,b,a+b))
def sub(a,b) :
    print("%d과 %d의 빼기 결과는 %d 입니다."   %(a,b,a-b))
def mul(a,b) :
    print("%d과 %d의 곱하기 결과는 %d 입니다." %(a,b,a*b))
def div(a,b) :
    print("%d과 %d의 나눗셈 결과는 %d 입니다." %(a,b,a/b))

print("1.더하기 : sum(숫자1, 숫자2)")
print("2.빼기   : sub(숫자1, 숫자2)")
print("3.곱하기 : mul(숫자1, 숫자2)")
print("4.나누기 : div(숫자1, 숫자2)")

calAndNums = input("함수(숫자1, 숫자) 형식입력:")
cal = (calAndNums[0:3])
num1 = int((calAndNums[4:5]))
num2 = int((calAndNums[7:8]))
#print("입력된 계산함수:",cal)  #입력값 확인용코드.
#print("입력된 숫자1값 :",num1) #입력값 확인용코드.
#print("입력된 숫자2값 :",num2) #입력값 확인용코드.

if(cal == 'sum') :
    sum(num1,num2)
elif(cal == 'sub') :
    sub(num1,num2)
elif(cal == 'mul') :
    mul(num1,num2)
elif(cal == 'div') :
    div(num1,num2)
else :
    print("정의되지 않은 기능입니다. 계산을 종료합니다.")


'''
calAndNums = input("함수명(숫자, 숫자)식으로 입력하세요:")
cal = (calAndNums[0:3])
num1 = int((calAndNums[4:5]))
num2 = int((calAndNums[7:8]))
print(cal)
print(num1)
print(num2)
print(num1+num2)
'''


