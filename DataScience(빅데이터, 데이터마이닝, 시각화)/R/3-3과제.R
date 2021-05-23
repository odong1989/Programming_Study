#3-3. 과제 (파일 제출)
#R 에서 제공하는 state.x77 데이터셋(미국 50개 주에 대한 통계데이터) 을 이용하여 실습하시오.

#1. state.x77 를 st 에 data.frame 으로 저장하시오.
st <- data.frame(state.x77) 

#2. st 의 내용을 보이시오.
st

#3. st 의 열 이름을 보이시오.
colnames(st)

#4. st 의 행 이름을 보이시오.
rownames(st)

#5. st 의 행의 개수와 열의 개수를 보이시오.
dim(st)

#6. st 의 요약정보를 보이시오.
str(st)

#7. st 의 행별 합계와 평균을 보이시오.
rowSums(st)#7. st 의 행별 합계.
rowMeans(st)#7. st 의 평균.

#8. st 의 열별 합계와 평균을 보이시오.
colSums(st)
colMeans(st)

#9. Florida 주의 모든 정보를 보이시오.
st["Florid",]

#10. 50개 주의 Income 정보만 보이시오.
st.income <-st[,"Income"]
names(st.income) <- rownames(st)
st.income

#11. Texas 주의 면적(Area) 을 보이시오.
st["Texas","Area"]

#12. Ohio 주의 인구(Population) 와 수입(Income)을 보이시오.
st["Ohio", c("Population","Income")]

#13. 인구가 5000 이상인 주의 데이터만 보이시오.
st[st$Population >= 5000, ]

#14. 수입이 4500 이상인 주의 인구, 수입, 면적을 보이시오.
st[st$Income >= 4500, c("Population","Income","Area")]

#15. 수입이 4500 이상인 주는 몇 개인지 보이시오.
sum(st$Income >= 4500)

#16. 전체면적(area)이 100000 이상이고 결빙일수(frost) 가 120 이상인 주의 정보를 보이시오.
st[st$Area > 100000 & st$Frost >=120,]

#17. 문맹률(illiteracy)이 2.0 이상인 주의 평균 수입은 얼마인가?
ill.2 <- st[st$Illiteracy >=2.0, ]  
mean(ill.2$Income)

#18. 문맹률(illiteracy)이 2.0 미만인 주와  2.0 이상인 주의 평균 수입의 차이를 보이시오.
less2 <- subset(st, Illiteracy <2.0, select ="Income")
less.mean <- mean(less2$Income)

#19. 기대수명(life.exp)이 가장 높은 주는 어디인가?
max.le <- max(st$Life.Exp)  
subset(st, Life.Exp == max.le)

#20. Pennsylvania 보다 수입이 높은 주들을 보이시오.
penn.income <- st["Pennsylvania", "Income"]
subset(st,Income > penn.income, select = Income)

