#책 63page
#install.packages("gapminder")
library(gapminder)
#gapminder
head(gapminder)
tail(gapminder)

libray(dplyr)
glimpse(gapminder)

gapminder$lifeExp
gapminder$gdpPercap
gapminder[,c('lifeExp', 'gdpPercap')]
gapminder %>% select(gdpPercap, lifeExp)

summary(gapminder$lifeExp)
summary(gapminder$gdpPercap)
cor(gapminder$lifeExp, gapminder$gdpPercap)
