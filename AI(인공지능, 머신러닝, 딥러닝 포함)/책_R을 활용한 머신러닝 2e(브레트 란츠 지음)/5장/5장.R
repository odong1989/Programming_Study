#199page
-0.60 * log2(0.60) - 0.40 * log2(0.40)

curve(-x * log2(x) - (1 - x) * log2(1 - x),
      col = "red", xlab = "x", ylab = "Entropy", lwd = 4)


#예제 : C5.0 의사결정 트리를 이용한 위험 은행 대출 식별(202~)
#설명 : 2008년 금융위기이후 금융업계는 신용을 토대로거래의 한계를 느꼈다.
#       이에 따라 은행의 대출 시스템을 강화하고, 위험대출을 정확하게 찾는 머신러닝으로 진화하고 있다.


#신경쓸 요소는 아래와 같다
#         구분할 요소           |
#-------------------------------|--------------------------------------------------------
#(1)채무불이행될 위험이 높은가? | (1)과거 은행 대출에 대한 대량의 데이터
#                               | (2)대출의 채무불이행, 
#                               | (3)신청자의 정보



#1단계: 데이터 수집
#데이터 출처 : credit.csv[UCI 머신러닝 데이터 저장소(함부르크 대학교 한스 호프만이 기부)]


credit<-read.csv("C:/sourceTree/Programming_Study/AI(인공지능, 머신러닝, 딥러닝 포함)/책_R을 활용한 머신러닝 2e(브레트 란츠 지음)/5장/credit.csv")
credit

#str : 통해 obs(데이터 값 개수), variables(칼럼들 갯수)를 파악한다.
str(credit)

#채무불이행을 할 것 같은 이부 대출 특징에 대해 table()출력을 실시.
#수표계좌잔고와 저축계좌잔고는 대출의 채무불이행을 파악&예측에 중요한 예측변수로 쓸 수 있다.
table(credit$checking_balance) #checking_balance : 수표 계좌 잔고
table(credit$savings_balance)  #savings_balance  : 저축 계좌 잔고


#대출의 일부 특징은 요청된 대출기간&금액 등이 있다.
#summary(credit)라고 하는 것보다 $를 활용해 해당 칼럼만 분석하게 하면 
#해당칼럼내의 최대값/최소값 1사분면값등을 간결히 알수 있다.

#대출금정보-대출기간(months_loan_duration)
summary(credit$months_loan_duration) 
#최소 4개월~최대72개월 기간의 중앙값은 18개월, 


#대출금정보-대출금액(credit$amount)
summary(credit$amount)
#대출금의 중앙값은 2320.

#default벡터 : 대출신청자가 채무불이행을 했는지 알려주는 flag역할.
table(credit$default)
#yes가300=30%의 대출자가 채무를 불이행함.


#credit$default(채무불이행여부)를 정답으로 삼고, 
#1000개의 데이터를 훈련용/태스트용으로 나누어 훈련(머신러닝학습)후 평가를 하여
#채무불이행 위험이 높은 고객을 제외시키는 모델을 훈련(개발)시켜보자.

#단계1.랜덤한 훈련 및 테스트 데이터셋 생성
# : 한마디로 "1000개의 데이터를 훈련용/테스트용으로 분할한다"는 말이다. 
#   본 코드에서는 90%는 훈련용, 10%는 테스트용으로 활용한다.

#[참고]'4장-의사결정트리'에서 했던 것과 공통점 및 차이점
#(1)공통점 : 훈련용/테스트용으로 데이터를 분할한다는 것.
#(2)차이점 : 랜덤 샘플을 실시하느다는 것.(이를 위해 set.seed()&sample() 난수생성기를 활용한다. )
#            4장의 경우 임의의 기준으로 정렬되어 있기에 바로 훈련/테스트용을 분할이 가능했다.
#            반면에 5장의 경우 정렬이 안되어있어 4장처럼 했다간 망한다.
#            만약 1~900번의 데이터는 작은 대출만 있고, 901~1000번은 큰 대출만 있다면 어찌될까?
#            이는 엉뚱한 시험범위만 공부한 셈이 된다.
#            따라서 랜덤하게 섞어서 작은대출~큰대출 모두 훈련할 수 있도록 해줘야 하는 것이다.


#랜덤 샘플실시(이를 위해 set.seed()&sample() 난수생성기를 활용한다. )
#(1)sample() : 랜덤샘플링을 수행한다.
#(2)set.seed() : sample()을 통한 랜덤샘플링전에 먼저 설정한다.
#                입력한 값을 통해 나중에 동일한 랜덤샘플이 가능하기 때문이다.
#                즉, 랜덤을 실시하되, 나중에 똑같이 따라할 수 있도록 하는 설정값이다.

set.seed(123) # 123은 임의의 값이다.


train_sample <-sample(1000,900) #1000개의 데이터중 900개를 훈련용으로 할당한다.
str(train_sample)


credit_train <-credit[train_sample,]
credit_test <-credit[-train_sample,] #앞에 -연산자가 붙으면 해당데이터에 포함되지 않은 데이터만 포함하도록 설정한다.


#Q:데이터가 랜덤하게 잘 들어갔는지의 판단기준은?
#A:훈련용/테스트용 모두 각각 채무불이행의 비율이 30%이면 랜덤이 잘 이뤄진 것이다.

prop.table(table(credit_train$default)) # prop.table() : %비율로 표현해준다.
prop.table(table(credit_test$default))  # prop.table() : %비율로 표현해준다.

