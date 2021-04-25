#3-4. 과제 (파일 제출)

#1. R 에서 제공하는 state.x77 데이터셋에서 수입이 5000 이상인 주의 데이터만 추출하여 rich_state.csv 에 저장하시오.
st <- data.frame(state.x77)
income5000 <- subset(st, Income >= 5000)
write.csv(income5000, file = "rich_state.csv")



#2. rich_state.csv 파일을 읽어서 ds 변수에 저장후 ds 의 내용을 보이시오.
ds <- read.csv("rich_state.csv")
rownames(ds) <- ds$X
ds <- ds[,-1]