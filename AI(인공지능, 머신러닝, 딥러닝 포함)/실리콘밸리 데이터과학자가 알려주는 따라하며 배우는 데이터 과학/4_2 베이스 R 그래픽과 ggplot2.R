#4.2 베이스 R 그래픽과 ggplot2(책69~74 페이지)

#install.packages("ggplot2")
library(ggplot2)
library(dplyr)
library(gapminder)

#갭마인더 데이터의 평균소득과 기대수명변수의 ggplot2를 이용한 시각화.
gapminder %>% ggplot(aes(x=lifeExp)) + geom_histogram() #그래프1
gapminder %>% ggplot(aes(x=gdpPercap)) + geom_histogram() #그래프2
gapminder %>% ggplot(aes(x=gdpPercap)) + geom_histogram()+scale_x_log10() #그래프3
gapminder %>% ggplot(aes(x=gdpPercap, y=lifeExp)) + geom_point() + scale_x_log10() + geom_smooth()

#aes() : 변수를 그래프 구성요소에 따라 맵핑해주는 명령.


#4.2.1. ggplot2란?(71~73페이지)
#ggplot2 : R의 시각화 라이브러리. 데이터 시각화의 필수 도구이다.
#ggplot2가 기본제공되는 R베이스패키지보다 좋은점은 아래와 같다.
#1. 많은 커스텀화 없이도 보기 좋은 그래프를 얻을 수 있다.
#2. 다양한 플롯 타입(히스토그램, 산점도, 박스플롯 등)을 하나의 통일된 개념으로 처리한다.
#3. 다변량 데이터 플롯에 특히 효율적이다. 특히, facet_* 함수가 효율적이다.

#[주의] ggplot()은 함수이고, ggplot2는 패키지명이다. 한 마디로 전혀다른 존재임.



#4.2.2. ggplot과 dplyr의 %>%(73페이지)

#4.2.3. 예제 데이터 소개(73~74페이지)
