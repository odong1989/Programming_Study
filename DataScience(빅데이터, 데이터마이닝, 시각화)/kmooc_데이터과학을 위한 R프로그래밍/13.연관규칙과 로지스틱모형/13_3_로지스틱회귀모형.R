#로지스틱 회귀모형 

#선형 회귀분석     : 연속형 변수값을 예측한다(x,y모두 연속적인 값을 가졌기 때문) 
#로지스틱 회귀분석 : 종속변수가 범주형인 경우 타겟변수가 2개의 범주(O/X문제처럼)이거나,
#                    또는 3개 이상의 범주인 서열형 데이터(ordinal data), 명목형 데이터(nominal data)
#                    등 경우에 따라 다른 모형이 사용된다.
# summary()함수에서 AIC값이 낮게 나올수록 좋은 로지스틱 회귀모형이라고 할 수 있다. 

#영상 4:59
#로지스틱 회귀모형 
#로지스틱 회귀모형을 실시하려면 glm()함수를 사용하면 된다.
tl<-glm(remiss!cell+smear+infil+li+blast+temp, data=re, family=binomial(logit))
summary(tl)
#p-value를 확인하도록하자!
#p-value에서 밑에 나올수록 기여도가 낮다. 여기서 blast, infill을 빼게 된다.

cor(re)


#영상 7:21
t2<-glm(remiss~cell+smear+li+temp, data=re, family = binomial(logit) )
summary(t2)

