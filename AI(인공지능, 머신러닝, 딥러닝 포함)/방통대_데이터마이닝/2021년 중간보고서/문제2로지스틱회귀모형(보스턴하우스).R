#문제2. R에 내장된 보스턴하우징 데이터를 변형하여 로지스틱 회귀모형을 적합하고자 
#한다. 새로운 목표변수 y를 medv가 21보다 큰 경우 “H”로, medv가 21보다 작거나 
#같은 경우 “L”로 설정하여 모형을 적합하고 결과를 해석하라. (단, medv는 모형에서 제외) (10점)

#1. 보스턴 하우징 데이터 로드 및 불필요 데이터 삭제
library(MASS) #보스턴 하우징 데이터 로드


#2.전처리 과정 - 불필요데이터 삭제 및 수치형 변수→범주형 변수로 변경실시.

#2.1. medv가 최대값 50인 관측치값 16개를 찾아 제외
i = which(Boston$medv == 50)
boston = Boston[-i,] #delete cases with medv =50

#2.2. 범주형 변수로 인식시켜야 할 변수를 선택
#chas,rad 변수들은 수치형이기 때문에 범주형으로 변환한다
boston$chas = factor(boston$chas) # factor 함수를 통해 범주형 변수라고 인식시킨다.
boston$rad = factor(boston$rad)

#3모형적합단계
fit.all = lm(medv ~ ., data = boston) # fit a linear model with all variables
#fit.all #결과를 보기위해 실시.
summary(fit.all)#Estimate/Standard Error / t-value/P-value들이 나오게 된다.


#(4)모형 선택함수
#모형이 너무크거나, 변수듫이 너무 많아 의미있는 몇 개의 변수로 축약하려고 할 때 step 함수를 활용한다.
fit.step = step(fit.all, direction="both") #stepwise variable selection. # -기호가 앞에 있으면 제외된 함수이다.
fit.step$anova

#(5)예측함수
yhat = predict(fit.step, newdata=boston, type="response") #predictions
yhat
#시각적으로 예측값이 어떻게 나오는지 시각화 실시.
plot(boston$medv, fit.step$fitted, xlim=c(0,50), ylim=c(0,50), xlab="observed values", ylab="Fitted values")#데이터의 분포를 산포도로 보여준다.
abline(a=0,b=1)#대각선을 긋는다.

#MSE(mean squard error) 확인
mean((boston$medv - yhat)^2) #MSE



#데이터 핸들링 실시------------------

#numcredits,residence 등의 데이터를 보면 범주형데이터로 보는게 좋겠다고 교수님등 관련자들이 평가하여
#범주형 데이터로 변경하는 과정을 실시.
Boston$y <- ifelse(Boston$medv>21,"H","L")
#나중에 민감도, 특이도 등의 계산에도 편의를 갖고자 실시.

#선형회귀모형과 동일하게 실시----------
fit.all = glm(y~ ., family = binomial, data = german)
fit.step = step(fit.all, direction="both")
fit.step$anova

summary(fit.step)
#예측 실시. 선형회귀모형과는 다르게 진행된다.
p = predict(fit.step, newdata = german, type="response")#예측함수는 동일하다.
p #하지만 결과는 확률들이 나오게 되므로 보스턴하우스와는 다르다. 0~1이내의 값들이 나오게 된다.

threshold = 0.5 #cutoff
yhat = ifelse(p > threshold, 1,0)# 0.5보다 크면 1, 아니면 0을 주게 된다.
yhat #예측값들을 본다 0.5보다 크면 1, 아니면 0이다.

class.tab = table(german$y, yhat, dnn=c("Actual","Predicted"))
print(class.tab)
sum(german$y==yhat)/length(german$y)
sum(german$y!=yhat)/length(german$y)
class.tab[1,1]/apply(class.tab,1,sum)[1]
class.tab[2,2]/apply(class.tab,1,sum)[2]
