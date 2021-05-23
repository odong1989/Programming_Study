#6.10.2.중심극한정리 -125페이지
hist(c(0,1), nclass=100, prob=TRUE, main='Individual sleep time increase')
set.seed(1606)
B <- 1e4
n <- 10
xbars_star <- rep(NA, B)

for(b in 1:B){
  xbars_star[b] <- mean(sample(c(0,1), size=n, replace=TRUE ))
}
hist(xbars_star, nclass=100, main='Sample mean of 10 obs')
