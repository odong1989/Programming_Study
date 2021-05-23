
mydata<-read.csv(file.choose())

#아래의 2가지 패키지가 설치 및 packages에서 v체크 되어야 한다.
#install.packages("ggplot2")
#install.packages("dplyr")

#1)검정색 점으로만 표현하고 싶을 경우
#ggplot(data=mydata, aes(x=carat, y=price)) + geom_point()
#---------------------------------------------------------

#2)다양한 색깔로 점을 표현하고 싶을 경우
#ggplot(data=mydata,
#       aes(x=carat, y=price, colour=clarity))+geom_point()
# +geom_point()을 개행하면 작동이 안되더라.
# 가독성 챙기려다 결과 못볼수도 있다!
#---------------------------------------------------------

#3)그래프처럼 표현
ggplot(data=mydata[mydata$carat<2.5,],
       aes(x=carat, y=price, colour=clarity))+
       geom_point(alpha=0.1)+
       geom_smooth()

#---------------------------------------------------------