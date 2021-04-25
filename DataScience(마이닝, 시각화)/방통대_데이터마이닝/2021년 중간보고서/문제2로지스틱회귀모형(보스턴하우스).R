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

#2.3.새로운 목표변수 y를 medv가 21보다 큰 경우 “H”로, medv가 21보다 작거나 같은 경우 “L”로 설정하여 모형을 적합.
Boston$y <- ifelse(Boston$medv>21,"H","L") 

#3.모형적합 및 분석 : fit.all에 모든 변수를 적합한 모형을 생성하게 된다

#3.1. 모형적합
fit.all = glm(medv ~ ., data = boston) #목표변수를 y로 지정하고, 목표변수외의 나머지 변수는 입력변수로 한다. 
fit.all # 적합한 결과를 확인

#3.2. 모형분석관련
fit.step = step(fit.all, direction="both") #summary()에서 의미있는 변수들로만 구성하도록 한다
                                           #여기서는 summary()에 앞서 유의미한 변수파악의 용도로 활용.
                                             
summary(fit.all)#Estimate/Standard Error / t-value/P-value들이 나오게 된다. 
                #Estimate를 통해 회귀하는 성격이 양의값인지, 음의값인지 파악가능.

