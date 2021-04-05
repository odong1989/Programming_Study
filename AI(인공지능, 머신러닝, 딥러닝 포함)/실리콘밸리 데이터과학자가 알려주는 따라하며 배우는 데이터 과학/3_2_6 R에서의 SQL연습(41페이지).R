#실리콘밸리  데이터과학자 따라하며 배우는 데이터 과학 
# RDBMS+SQL (40~페이지) 

#3.2.6. R에서의 SQL연습(41페이지)
#install.packages("sqldf")

library(sqldf)
sqldf("select * from iris")
sqldf("select count(*) from iris")
sqldf("select Species, count(*), avg('Sepal.Length')
      from iris
      group by 'Species'")
sqldf("select Species, 'Sepal.Length', 'Sepal.Width'
      from iris
      where 'Sepal.Length' < 4.5
      order by 'Sepal.Width' ")


sqldf("select count(*)
      from iris
            where 'Sepal.Length' < 5.5
      ")
