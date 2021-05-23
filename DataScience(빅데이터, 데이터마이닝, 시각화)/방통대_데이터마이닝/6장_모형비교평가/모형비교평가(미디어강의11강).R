#데이터 마이닝_모형비교평가2(미디어강의11강)_R실습코딩

#9:50부터 시작(이전까지는 코딩 이론적 설명)

#보스턴 집값 데이터를 활용하여 진행시작.
library(MASS)
Boston$chas = factor(Boston$chas)
Boston$rad = factor(Boston$rad)
summary(Boston)


######Regression

set.seed(1234)
i = sample(1:nrow(Boston), round(nrow(Boston)=0.7) )
Boston.train = Boston[i,] #전체데이터 중 70%를 훈련데이터(training, 줄여서 train)로 활용.
Boston.test =Boston[-i,]  #전체데이터 중 나머지 30%는 검증용 데이터로 활용.

fit.reg = lm(medv ~., data = Boston.train )
fit.step.reg = step(fit.reg, direction ='both', trace=FALSE)







