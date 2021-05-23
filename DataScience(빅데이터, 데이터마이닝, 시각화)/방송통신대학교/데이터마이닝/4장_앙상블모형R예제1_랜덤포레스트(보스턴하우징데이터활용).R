#배깅과 부스팅 관련 R함수(124~)
#배깅과 부스팅을 R에서 실행하기 위해서는 adabag라는 패키지를 이용해야 함.

#배깅과 부스팅에 사용되는 R함수
#(1)bagging 함수
#(2)predict.bagging
#(3)errorrevol
#(4)plot.errorrevol
#(5)boosting
#(6)predict.boosting


#(1)bagging 함수 : 훈련 데이터를 이용하여 배깅 앙상블을 수행함.
#                  R의 bagging 오브젝트를 생성하며, rpart패키지도 필요하다.



#R사용예제
#(1)보스턴하우징 데이터

#4-1 랜덤포레스트의 오분류율 감소
library(MASS) #보스턴 하우징 데이터 로드
#Boston데이터에서 chas와 rad는 범주형 변수이다.(이외 변수들은 연속형 변수)

Boston$chas = factor(Boston$chas)
#Boston$chas
Boston$rad  = factor(Boston$rad)
#Boston$rad  
summary(Boston)

#4-2 랜덤포레스트 실행 결과
#install.packages("randomForest")
library(randomForest)
rf.boston <- randomForest(medv ~ ., data = Boston, ntree=100, mtry=5, importance=T, na.action = na.omit)

#rf.boston : 
#ntree : 랜덤포레스트 방법에서 생성하게 될 분류기의 개수. 100개의 분류기를 생성하도록 한 것.
#mtry  : 중간노드마다 랜덤하게 선택되는 변수들의 개수를 의미한다. 5개의 입력변수를 중간노드마다 
#(계속)  모두 선택하고 이들 중에서 분할점이 탐색되도록 하는 것.          
summary(rf.boston)
