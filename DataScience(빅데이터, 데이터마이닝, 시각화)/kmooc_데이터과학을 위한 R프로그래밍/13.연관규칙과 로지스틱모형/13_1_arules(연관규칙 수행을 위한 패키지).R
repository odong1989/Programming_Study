#13. 연관규칙과 로지스틱모형
#13-1.연관규칙

#연관규칙 수행 패키지 : arules
# arules패키지는 연관규칙분석 수행을 위한 라이브러리입니다.
#강의 영상 7:23

#rec13_1.r
#Association Rule
#Market basket analysis

#set working directory
setwd("C:/sourceTree/Programming_Study/DataScience(빅데이터, 데이터마이닝, 시각화)/kmooc_데이터과학을 위한 R프로그래밍")

#association rule analysis package
install.packages("arules")
library(arules)


#옛날 dvd영상을 빌려보던 데이터들을 예제로 삼아 실시해보기
#강의 영상 7:52

#data import -> make transaction data
#dvd1 <-read.csv("dvdtrans.csv") #강의의 설명

dvd1 <-read.csv("C:/sourceTree/Programming_Study/DataScience(빅데이터, 데이터마이닝, 시각화)/kmooc_데이터과학을 위한 R프로그래밍/13.연관규칙과 로지스틱모형/dvdtrans.csv")
dvd1

dvd.list <-split(dvd1$Item, dvd1$ID) #split을 통해 id별로 item들을 as함수를 통해 transaction data로 변환.
dvd.list

dvd.trans <-as(dvd.list,"transactions")
dvd.trans

inspect(dvd.trans)


#9:08
summary(dvd.trans) #tansactions data의 요약


#10:09
#연관 규칙함수 실시
#연관규칙 함수 : 
#
#
#
dvd_rule<-apriori(dvd.trans,
          parameter = list(support=0.2,
                         confidence=0.2,
                         minlen=2) )
dvd_rule


#연관규칙 수행결과 : dvdtrans 데이터
#영상 11:00

summary(dvd_rule)


inspect(dvd_rule)


#연관규칙 수행결과
itemFrequencyPlot(dvd.trans,support=0.2, 
                  main="item for support >=0.2",
                  col="green")

