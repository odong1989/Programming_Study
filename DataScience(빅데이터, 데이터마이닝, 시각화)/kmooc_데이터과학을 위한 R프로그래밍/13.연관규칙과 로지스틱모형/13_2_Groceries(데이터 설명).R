#Groceries data("arules패키지에 탑재되어 있는 데이터)
#[목표] 마트에서 시장 본 데이터를 활용하여 연관규칙을 도출하고자 한다.

#영상 0:59
#install.packages("arules")
#help("Groceries")

library(arules)

data("Groceries") #Groceries :마트에서의 데이터를 뜻함.
summary(Groceries) 
#most frequent item : MVP처럼 거래가 많이 된 아이템을 뜻하게 된다(우유, 온갖야채, 롤빵 등....)
#sizes : 거래횟수

#연관규칙-visualization(지지도)
#일종의 트랜잭션(빈도) 데이터인 셈이다.
#2:15

#1.지지도 5%이상의 item 막대 그래프
itemFrequencyPlot(Groceries,support=0.05,
                  main="items for support >=5%",
                  col="green")
#가장 높은 것이 우유이다.


#2.지지도 상위 20개 막대 그래프
itemFrequencyPlot(Groceries, topN=20,
                  main="support top 20 items",
                  col="coral")
#가장 많이 팔린 제품부터 쫘르르 정렬된다.


#3:30
#support, confidence, length는 minimum값이다.
#이들의 값을 높이면 연관규칙의 도출이 어렵게 된다.

Grocery_rule <-apriori(data=Groceries,
                       parameter= list(support=0.05,
                                       confidence = 0.20,
                                       minlen = 2))
#지지도는 5%이상, 지지도는 20%으로 하는 이유는 이 때문이다.

Grocery_rule #실시하면 6개의 규칙이 도출되었다고 나온다.


#연관규칙 조회 및 평가
#4:49

#도출된 6개의 규칙을 보기(결과분석석)위해 실시.
summary(Grocery_rule)
inspect(Grocery_rule)


#연관규칙-향상도(Lift)순서로 정렬
#6:37
#정렬을 위해 sort()함수를 사용한다. 여기서는 "lift" 를 기준으로 정렬하도록 한다.
inspect(sort(Grocery_rule, by="lift"))


#연관규칙 분석결과
#이번에는 타겟대상이 되는 언어를 중심으로 연관규칙들을 추려내도록 해보자
#7:07

#1.yogert가 들어있는 연관규칙
rule_interest3 <-subset(Grocery_rule, items %in% c("yogurt"))
inspect(rule_interest3)


#2.(other)라는 품목이 들어있고 신뢰도>25% 규칙
#7:52
rule_interest5 <-subset(Grocery_rule, items %pin% c("other") & confidence>0.25)
inspect(rule_interest5)


#연관규칙 분석결과 저장하기
#8:27

#1.데이터 프레임 형태로 저장하기
Grocery_rule_df <- as(Grocery_rule, "data.frame")
Grocery_rule_df

#2.csv파일로 저장하기
write(Grocery_rule, file="Grocery_rule.csv",
      sep=",",
      quote=TRUE,
      row.names=FALSE)#작업폴더에 생성되게 된다.
