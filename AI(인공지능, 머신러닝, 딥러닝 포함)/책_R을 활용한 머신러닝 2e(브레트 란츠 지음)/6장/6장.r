#예제:선형 회귀를 이용한 의료비 예측(263)

#1단계 데이터 수집(264)
#이론설명만 있으므로 설명 생략.

#2단계 데이터 탐색 및 준비
insurance <- read.csv("C:/sourceTree/Programming_Study/AI(인공지능, 머신러닝, 딥러닝 포함)/책_R을 활용한 머신러닝 2e(브레트 란츠 지음)/6장/insurance.csv")

str(insurance)
#종속변수 : expenses(그 해에 의료보험에 청구된 개인별 의료비를 측정한 값.)
#[비고]회귀 모델을 구축하기 전에 정규성을 자주 확인하는 것이 좋다.
#      선형 회귀는 종속 변수가 정규 분포를 따르도록 엄격하게 요구하지는 않는다.
#      하지만 정규분포를 따를경우 모델이 좀 더 잘 적합된다.

summary(insurance$expenses)
hist(insurance$expenses)

table(insurance$region)
#table(insurance$region)가 네 개의 지리구에 균등히 나눠져있음을 확인할 수 있다.

#특징 간 관계 탐색 : 상관 행렬(267~268)
cor(insurance[c("age","bmi","children","expenses")])


#특징 간 관계 시각화 : 산포도 행렬(268~271)
pairs(insurance[c("age","bmi","children","expenses")])

install.packages("psych")
library(psych)
pairs.panels(insurance[c("age","bmi","children","expenses")])

launch <- read.csv("C:/sourceTree/Programming_Study/AI(인공지능, 머신러닝, 딥러닝 포함)/책_R을 활용한 머신러닝 2e(브레트 란츠 지음)/6장/challenger.csv")

# 
b <- cov(launch$temperature, launch$distress_ct) / var(launch$temperature)
b

a <- mean(launch$distress_ct) - b * mean(launch$temperature)
a

r <- cov(launch$temperature, launch$distress_ct) /
       (sd(launch$temperature) * sd(launch$distress_ct))
r
cor(launch$temperature, launch$distress_ct)
