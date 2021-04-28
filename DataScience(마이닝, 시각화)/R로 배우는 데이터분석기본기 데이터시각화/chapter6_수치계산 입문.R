#6.1. 뉴튼법
#f(x)=y  처럼 만드는 것이다.
f <-function(x) exp(x) -2       #f(x)를 정의한다.
(result <- uniroot(f,c(0,1)))   #범위를 c(0,1)로 지정

result$root


#6.2. 다항식의 해
polyroot(c(2,3,1)) #(x+1)(x+2)=0의 해
#출력결과 : [1] -1+0i -2-0i 
#허수 부분은 0이라고 생각해도 된다(아주 작은 값이기 때문이다.)
#x=-1, -2가 해라고 생각할 수 있다.



#6.3. 함수의 미분
f <-expression(a*x^4)     #미분할 함수 f를 정의한다. #함수expression()을 사용하여 정의한다.

#x를 변수, a를 상수로 하여 미분을 실시한다.
D(f,"x")                  #D(수식, 미분할 변수)

#고계(고차)미분하는 예제. 
#여기에서는 DD라는 함수를 정의하여 편의를 추구하였다.
#DD함수는 미분후의 수식을 보여주는 함수이다.(재계산용도 등으로는 사용불가임.)
DD <- function(expr, name, order =1){
  if(order < 1) stop("'order' must be >=1")
  if(order == 1) D(expr, name)
  else DD(D(expr, name), name, order -1)
}

DD(f,"x",3)

#DD함수는 미분후의 수식을 보여주는 함수이다.(재계산용도 등으로는 사용불가임.)
#결과의 수식을 사용하여 다시 계산할 떄는 함수 deriv()를 사용하면 된다.


# deriv(~수식, 미분할 변수, func=T)
f <-deriv(~ x^2, "x", func=T)
f #결과값으로 단순히 2가 나올거 같지만 입력 값을 비롯한 미분 내용이 나온다.
f(-2)









