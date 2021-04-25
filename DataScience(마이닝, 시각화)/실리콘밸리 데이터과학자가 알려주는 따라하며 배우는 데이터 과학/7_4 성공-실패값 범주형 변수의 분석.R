set.seed(1606)
n<-100
p<-0.5
x <-rbinom(n,1,p)
x<-factor(x, levels =c(0,1), labels = c("no","yes"))
x
table(x)
prop.table(table(x))
barplot(table(x))
