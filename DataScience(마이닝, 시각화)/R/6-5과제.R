#6-5. 과제 (파일 제출)

#1. 세개의 숫자를 매개변수로 입력하면 그중에 가장 큰 수를 돌려주는 함수를 작성하고 테스트 하시오.
maxofthree <- function(a,b,c){
  max = a
  if(max < b) max = b
  if(max < c) max = c
  return (max)
}
result <- maxofthree(3,5,9)
result
result <- maxofthree(10,8,10)
result

#2. 화면에서 숫자 2개를 입력 받아 두숫자의 합과 곱을 출력하는 프로그램을 작성하시오.
#(이작업을 계속 반복하되 두 숫자가 모두 0 이면 프로그램을 중지한다) 
while(TRUE){
  a <- readline(prompt="give number : ")             
  a <- as.integer(a)
  b <- readline(prompt="give number : ")
  b <- as.integer(b)
  if(a==0 & b==0){
    break;
  }
  print(a+b)
  print(a*b)                
}