#3.6.2 dplyr의 유용한 유틸리티
# : glimpse, tbl_df(), %>%

#3.6.2. (1) tbl_df()
library("dplyr")

i2 <-tbl_df(iris)
class(i2)
i2


#3.6.2. (2) glimpse
glimpse(i2)


#3.6.2. (3) %>%
iris %>% head()

iris %>% head(10)
