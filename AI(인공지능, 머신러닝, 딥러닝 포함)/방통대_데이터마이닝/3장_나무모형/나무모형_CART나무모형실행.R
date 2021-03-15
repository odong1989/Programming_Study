
.libPaths()#설치경로를 확인한다.
.libPaths("C:/Program Files/R/R-4.0.2/library")#라이브러리 폴더에 설치하도록 설치경로를 지정한다.

install.packages("rpart")#위의 설치경로를 했는데도 안될경우 Rstudio를 관리자권한으로 실시해보자

library(rpart)
set.seed(1234)
german = read.table("C:/sourceTree/Programming_Study/AI(인공지능, 머신러닝, 딥러닝 포함)/방통대_데이터마이닝/3장_나무모형/germandata.txt",header=T)

#로지스틱 회귀모형처럼 일부 데이터를 변환(facter화)한다.
german$numcredits = factor(german$numcredits)
german$residence = factor(german$residence)
german$residpeople = factor(german$residpeople)
german$y=relevel(german$y, ref<-'bad') 
#교수님은
#german$y=relevel(german, ref='bad')
#으로하면 정상작동하는데, 내가하면 아래와 같은 에러가 발생한다,
#Error in relevel.default(german, ref = "bad") : 
#  'relevel' only for (unordered) factors

summary(german)

threshold = 0.5

#Classification Tree 시작

library(rpart)

set.seed(1234)

#훈련용 데이터, 평가용 데이터 분할
i = sample(1:nrow(german), round(nrow(german)*0.7) )
german.train = german[i] #70%는 훈련용으로 사용한다.
german.test = german[-i] #나머지 30%는 평가용으로 사용한다. 

#나무모형 만들기 시작
my.control = rpart.control(xval=10, cp = 0, minsplit = 5)
fit.tree = rpart(y ~ , data = german.train, method="class", control=my.control)
ii = which.min(fit.tree$cp[,4])
fit.prun.tree = prune(fit.tree, cp = fit.tree$cp[ii,1])

p.test.tree = predict(fit.prun.tree, newdata = german.test, type = "prob")[,2]
yhat.test.tree = ifelse(p.test.tree > threshold, levels(german$y)[2], levels(german$y)[1] )

tab = table(german.test$y, yhat.test.tree, dnn = c("Observed","Predicted") )
print(tab)
1-sum(diag(tab)/sum(tab))
tab[,2]/apply(tab, 1, sum)

