library(MASS)
head(Boston)

#install.packages("randomPorest") #랜덤포레스트 패키지 설치
library("randomForest")           #랜덤포레스트 패키지 활성화

set.seed(1234)

#훈련용 테스트용 데이터 분할 실시.
i = sample(1:nrow(Boston), round(nrow(Boston)*0.7))
Boston.train = Boston[i, ] #70%의 데이터를 트레이닝(훈련용) 데이터로 배치


