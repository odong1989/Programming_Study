#50페이지

#데이터를 로드한다.
#gapminder 패키지를 설치
install.packages("gapminder")

library("gapminder")


#행과 열 선택
gapminder[gapminder$country == 'Korea, Rep.', c('pop','gdpPercap')]


#행선택
gapminder[gapminder$country == 'Korea, Rep.',]
gapminder[gapminder$year ==2007,]
gapminder[gapminder$country =='Korea, Rep.'& gapminder$year==2007,]
gapminder[1:10,]
head(gapminder, 10)


#정렬
gapminder[order(gapminder$year, gapminder$country),]


#변수 선택
gapminder[, c('pop', 'gdpPercap')]
gapminder[, 1:3]


#변수명 바꾸기 : gdpPercap를 gdp_per_cap으로 변경
f2 = gapminder
names(f2)
names(f2)[6] = 'gdp_per_cap'
names(f2)


#변수 변환과 변수 생성
f2 = gapminder
f2$total_gdp = f2$pop * f2$gdpPercap
f2$total_gdp


#요약 통계량 계산
median(gapminder$gdpPercap)
apply(gapminder[,4:6], 2, mean)
summary(gapminder)


