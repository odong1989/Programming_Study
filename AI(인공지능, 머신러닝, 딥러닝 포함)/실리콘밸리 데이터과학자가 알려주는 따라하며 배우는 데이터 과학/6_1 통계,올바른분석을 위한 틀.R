#6.1.1. 수면제 효과 연구 예(102~105페이지)
y<- sleep$extra[sleep$group==1]
y

summary(y)
sd(y)

par(mfrow=c(2,2))
hist(y)
boxplot(y)
qqnorm(y);qqline(y)
hist(y,prob=TRUE)
lines(density((y)),lty=2)

t.test(y)
t.test(y,alternative = "greater")
