german = read.table("C:/sourceTree/Programming_Study/AI(인공지능, 머신러닝, 딥러닝 포함)/방통대_데이터마이닝/2장_회귀모형/germandata.txt", header=T)

#데이터의 일부만 출력
head(german)

#데이터 핸들링 실시------------------

#numcredits,residence 등의 데이터를 보면 범주형데이터로 보는게 좋겠다고 교수님등 관련자들이 평가하여
#범주형 데이터로 변경하는 과정을 실시.
german$numcredits = factor(german$numcredits)
german$residence = factor(german$residence)
german$residpeople = factor(german$residpeople)
german$y = ifelse(german$y == "good", 1, 0)
#나중에 민감도, 특이도 등의 계산에도 편의를 갖고자 실시.

#선형회귀모형과 동일하게 실시----------
fit.all = glm(y~ ., family = binomial, data = german)
fit.step = step(fit.all, direction="both")
fit.step$anova

summary(fit.step)
#예측 실시. 선형회귀모형과는 다르게 진행된다.
p = predict(fit.step, newdata = german, type="response")#예측함수는 동일하다.
p #하지만 결과는 확률들이 나오게 되므로 보스턴하우스와는 다르다. 0~1이내의 값들이 나오게 된다.

threshold = 0.5 #cutoff
yhat = ifelse(p > threshold, 1,0)# 0.5보다 크면 1, 아니면 0을 주게 된다.
yhat #예측값들을 본다 0.5보다 크면 1, 아니면 0이다.

class.tab = table(german$y, yhat, dnn=c("Actual","Predicted"))
print(class.tab)
sum(german$y==yhat)/length(german$y)
sum(german$y!=yhat)/length(german$y)
class.tab[1,1]/apply(class.tab,1,sum)[1]
class.tab[2,2]/apply(class.tab,1,sum)[2]
