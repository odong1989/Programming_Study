#7-5. 과제 (파일 제출)
library(ggplot2)

#1. R에서 제공하는 state.x77 데이터셋의 Income, Illiteracy 데이터를 가지고 ggplot 으로 산점도를 작성하시오.
st <- data.frame(state.x77)
ggplot(data = st, aes(x = Income, y = Illiteracy)) +
  geom_point()

#2. R에서 제공하는 mtcars 데이터셋의 gear 데이터를 가지고 기어수별 빈도에 대해 ggplot 으로 막대 그래프를 작성하시오.
class(mtcars)
head(mtcars)
cnt <- table(mtcars$gear)
gear <- c(3,4,5)
data <- cbind(cnt, gear)
data <- data.frame(data)
ggplot(data, aes(x = gear, y = cnt)) +
  geom_bar(stat = "identity", width=0.7, fill = "steelblue")


#3. R에서 제공하는 airmiles 데이터셋은 1937년~1960년까지 비행기 탑승객의 여행거리가 저장되어 있다. 
#ggplot 으로 선그래프를 작성하시오.
#(x축:년도, y축:여행거리. airmiles 는 벡터가 아니기 때문에 다음과 같이 벡터로 바꾼 다음 실행한다.  
#  am <- as.numeric(airmiles)
str(airmiles)
year <- 1937:1960
data <- cbind(year, airmiles)
air <- data.frame(data)
ggplot(air, aes(x = year, y = airmiles)) +
  geom_line(color = 'red', size = 1)

#4. R에서 제공하는 iris 데이터셋의 Petal.Width 에 대해 품종(Species)별 상자그림(boxplot) 을 ggplot 으로 작성하시오.
ggplot() +
  geom_boxplot(data = iris, aes(x = Species, y = Petal.Width, fill=Species))

