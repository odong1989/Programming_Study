#회귀모형 학습 코딩 - 1.선형회귀학습
#보스턴 하우징 데이터
library(MASS)
i = which(Boston$medv == 50)

boston = Boston[-i,] #delete cases with medv =50

#전처리 과정 - 범주형 변수로 인식시켜야 할 변수를 선택
boston$chas = factor(boston$chas) # factor 함수를 통해 범주형 변수라고 인식시킨다.
boston$rad = factor(boston$rad)

#모형적합단계
fit.all = lm(medv ~ ., data = boston) # fit a linear model with all variables

fit.all #결과를 보기위해 실시.
summary(fit.all)#Estimate/Standard Error / t-value/P-value들이 나오게 된다.


#(3)모형 선택함수
#모형이 너무크거나, 변수듫이 너무 많아 의미있는 몇 개의 변수로 축약하려고 할 때 step 함수를 활용한다.
fit.step = step(fit.all, direction="both") #stepwise variable selection. # -기호가 앞에 있으면 제외된 함수이다.

fit.step$anova

#(4)예측함수
yhat = predict(fit.step, newdata=boston, type="response") #predictions
yhat
#시각적으로 예측값이 어떻게 나오는지 시각화 실시.
plot(boston$medv, fit.step$fitted, xlim=c(0,50), ylim=c(0,50), xlab="observed values", ylab="Fitted values")#데이터의 분포를 산포도로 보여준다.
abline(a=0,b=1)#대각선을 긋는다.

#MSE(mean squard error) 확인
mean((boston$medv - yhat)^2) #MSE

