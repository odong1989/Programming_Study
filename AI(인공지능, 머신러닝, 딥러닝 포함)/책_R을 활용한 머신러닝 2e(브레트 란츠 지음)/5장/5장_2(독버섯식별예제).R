#예제2. 규칙 학습자를 이용한 독버섯 식별

#단계2. 데이터 탐색과 준비
mushrooms <-read.csv("C:/sourceTree/Programming_Study/AI(인공지능, 머신러닝, 딥러닝 포함)/책_R을 활용한 머신러닝 2e(브레트 란츠 지음)/5장/mushrooms.csv")

mushrooms$veil_type <-NULL
table(mushrooms$type)

install.packages("OneR")
library(OneR)
mushroom_1R <- OneR(type ~., data = mushrooms)

mushroom_1R

#4단계 : 모델 성능 평가(238~239)
summary(mushroom_1R)


#5단계 : 모델 성능 개선(239~)
install.packages("Rweka")
library(Rweka)
m