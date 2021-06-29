
#데이터 수집(124~125)
#데이터세트 읽기
data <-read.csv("C:/sourceTree/Programming_Study/AI(인공지능, 머신러닝, 딥러닝 포함)/책_R예제로 배우는 머신러닝(라가프 발리 지음)/3장.장바구니 분석을 통한 소비자 쇼핑 트렌드 예측/top_supermarket_transactions.csv")

#행의 이름을 열의 이름과 같게 할당하기
#분할 행렬을 만들기 위해
data <- subset(data, select=c(-1))

##분할 행렬 보기
cat("Products Transactions Contingency Matrix")
data

#데이터 분석과 시각화(125~)
##데이터 분석과 시각화
#우유 구매 횟수
data[,'milk']

#우유 구매 횟수를 순서대로 정렬렬
sort(data[,'milk'] , decreasing = TRUE)

#빵 구매 횟수
data[,'bread']

#빵 구매 횟수를 순서대로 정렬
sort(data[,'bread'] , decreasing = TRUE)


#데이터 시각화
mosaicplot(as.matrix(data),
           color=TRUE,
           title(main="Products Contingency Mosaic Plot"),
          las=2
           )







