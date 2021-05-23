#6-3. 과제 (파일 제출)

#1.  다음과 같이 두 정수를 입력하면 두 수의 최대 공약수를 찾아서 
#return 해주는 함수 lgm() 를 작성하고 테스트 하시오.
lgm = function(x,y){
  if(x<y){
    temp <- x
    x <- y
    y <- temp
  }
  while(y!=0){
    n<-x %% y
    x <- y
    y <- n
  }
  return(x)
}
result <- lgm(10,8)
result
result <- lgm(10,20)
result

#2. 다음과 같이 벡터를 입력하면 벡터의 최대값과 최소값을 return 하는 함수 maxmin() 을 작성하고 테스트 하시오.
#(return 값이 list 임)
maximum <- function(v){
  return (list(max= max (v), min = min(v) ))
}

v1 <- c(7,1,2,8,9)
result <- maxmin(v1)
result$max ; result$min
result <- maxmin(iris[,1])
result$max ; result$min



