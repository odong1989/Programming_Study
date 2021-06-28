#R예제로 배우는 머신러닝 퍼셉트론 예제코드(80~84)

#(1)입력벡터 x와 데이터 생성파트 -------------------------------------------

#-1~1까지 랜덤한 30개의 값이 균일하게 분포되어 있도록 한다.(#데이터 생성)
x1 <- runif(30,-1,1)
x2 <- runif(30,-1,1)

#입력 벡터 X 생성
x <-cbind(x1,x2)
#---------------------------------------------------------------------------


#책에서는 누락된 부분...-_-
#generate output vector
#Y는 출력이 아니라 '구분자'의 역할로 작동하는 것으로 보인다.
Y <- ifelse(x2>0.5+x1,+1,-1) 

#(2)핼퍼함수와 선형 분류기 --------------------------------------------------

#헬퍼함수(calculate_distance)
#:초평면으로부터의 거리를 계산한다.(#한마디로_거리계산 함수)
# 분류자의 두 점 사이의 거리를 계산한다고 할 수 있다.
calculate_distance = function(x,w,b){
  sum(x*w) + b
}

#선형 분류기(linear_classifier)
#:두 점이 카테고리 -1(또는 카테고리 +1)에 속하는지 구분한다.
# 퍼셉트론 알고리즘은 트레이닝 데이터 시트를 사용해 정확한 구분자를 찾기위해 분류기를 사용한다.
linear_classifier = function(x,w,b){  
  distances = apply(x, 1, calculate_distance, w, b)
return(ifelse(distances < 0 ,-1, +1))
}

# 두 번째 기준을 계산하는 함수
second_norm = function(x) {
  sqrt(sum(x*x))
}
#----------------------------------------------------------------------------

#(3) 퍼셉트론 학습 알고리즘 작성 --------------------------------------------
# 퍼셉트론 학습 알고리즘
perceptron = function(x, y, learning_rate=1){
  
  #가중치 벡터(W),바이어스(b),반복계수(k) 초기화  
  w = vector(length = ncol(x) )
  b = 0
  k = 0

  #가장 먼 지점의 거리보다 큰 값의 상수
  R = max (apply(x,1, second_norm))

  #분류기를 확인하기 위한 표식
  incorrect = TRUE
  
  #플롯 초기화
  plot(x,cex=0.2)
  
  #정확한 분류기가 나오지 않을 때까지 반복
  #정확한 분류기가 나올때까지 아닌가???
  while(incorrect){
    
    incorrect = FALSE
    
    #현 가중치에 의한 분류
    yc <- linear_classifier(x,w,b) 

    #입력값 x상의 값들을 반복
    for(i in 1:nrow(x) ){
      #값이 정확히 분류하지 못하면 가중치를 변경함.
      if (y[i] != yc[i]){
        
        w <- w + learning_rate * y[i]*x[i,]      
        b <- b + learning_rate * y[i]*R^2
        k <- k+1

        #현재 분류의 요소들. 다섯 번 반복을 마칠때마다 그래프를 업데이트 한다.        
        if(k%%5 ==0){
          intercept <- - b / w[[2]]
          slope <- - w[[1]] / w[[2]]
          
          #plot the classifier hyper plane
          abline(intercept, slope, col="red")
          
          #wait for user input
          cat ("Iteration # ",k,"\n")
          cat ("Press [enter] to continue") 
          line <- readline()
        }
        incorrect = TRUE
      }
    }
  }
  s = second_norm(w)
  
  #scale the classifier with unit vector
  return(list(w=w/s, b=b/s, updates=k))
}

#---------------------------------------------------------------------------


#(4)퍼셉트론 학습시작 ------------------------------------------------------
p <- perceptron(x,Y)


#---------------------------------------------------------------------------


#(5)최종 분류기의 확대결과-----------------------------------------------------

#계산 결과에 기반한 분류
y <- linear_classifier(x,p$w, p$b)

plot(x,cex=0.2)

#분류기와 색 코드 근처의 점들을 확대
#y=1은 +로, 나머지는 -로 데이터 점을 표시한다.
points(subset(x, y==1), col="black", pch="+", cex=2)
points(subset(x, y==-1), col="red", pch="-", cex=2 )


#w와 b로부터 분류기의 y절편 계산
intercept <- - p$b / p$w[[2]]


#w로부터 분류기의 기울기 계산
slope <- - p$w[[1]] / p$ w[[2]]

#분류 경계 그리기
abline(intercept, slope, col="green")

#---------------------------------------------------------------------------
