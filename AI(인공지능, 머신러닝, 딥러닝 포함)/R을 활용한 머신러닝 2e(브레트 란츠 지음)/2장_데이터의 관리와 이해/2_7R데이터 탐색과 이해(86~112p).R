#데이터 탐색과 이해(86~87) 
usedcars <-read.csv("C:/sourceTree/Programming_Study/AI(인공지능, 머신러닝, 딥러닝 포함)/R을 활용한 머신러닝 2e(브레트 란츠 지음)/2장_데이터의 관리와 이해/usedcars.csv",
                    stringAsFactors = FALSE)
usedcars

#데이터 구조 탐색(87~88)
#새로운 데이터 셋을 조사시 할 1단계 : "데이터셋이 어떻게 구성되어 있는가?" 이를 파악하는 것.
#이 때 데이터 사전이 있다면 편리하다.
# *데이터 사전 : 데이터셋의 특징을 설명하는 문서.

#str() :데이터 프레임, 벡터, 리스트 같은 R 데이터 구조의 구조들을 보여줌.

str(usedcars)

#str(usedcars)의 실행결과 모습과 그에 대하여 주석을 달자면 아래와 같다.
#> str(usedcars)
#'data.frame':	150 obs. of  6 variables: 
#$ year        : int  2011 2011 2011 2011 2012 2010 2011 2010 2011 2010 ...  
#$ model       : chr  "SEL" "SEL" "SEL" "SEL" ...
#$ price       : int  21992 20995 19995 17809 17500 17495 17000 16995 16995 16995 ...
#$ mileage     : int  7413 10926 7351 11613 8367 25125 27393 21026 32655 36116 ...
#$ color       : chr  "Yellow" "Gray" "Silver" "Gray" ...
#$ transmission: chr  "AUTO" "AUTO" "AUTO" "AUTO" ...


#150 obs:데이터가 150개의 관측을 포함하고 있다.(=150개의 레코드(행)나 예시를 포함하고 있다)
#6 variables : 6개의 특징(칼럼)을 갖고 있따. 

#year : 자동차 제조년도, 광고 개시연도.
#mode, price, mileage, color, transmission : 판매를 위한 자동차의 특성을 나타내는 변수일 가능성이 높음.

# int : integer형
# chr : character형

#수치 변수 탐색(89~89)

#요약통계 값 기술하기
#summary() : 일반적인 요약 통계(최소값/1사분면값/중간값/평균값/3사분면값/최대값)를 출력 할 수 있다.

summary(usedcars$year)

summary(usedcars[c("price","mileage")]) #price,mileage 2개의 각 요약통계를 출력.


#중심경향측정:평균과 중앙값(90~92)
#중심경항측정이란? 데이터셋의 가운데에 있는 값을 식별하는데 사용하는 통계분류. 평균, 중앙값이 이에 해당함.

#평균
(36000+44000+56000) /3
mean(c(36000, 44000, 56000))

#중앙값(median) : n개의 데이터 중에서 가운데에 있는 값이 중앙값이다.
median(c(36000, 44000, 56000))#3개중에서 중앙은 44000이므로 44000이 출력.

median(c(36000, 44000, 56000,99000)) #4개처럼 짝수개인 경우 중앙에 가장 가까운 44000+56000을 실시, 나누기2를 실시. 


#퍼짐 측정(92~)
range(usedcars$price)

diff(range(usedcars$price))

IQR(usedcars$price)

quantile(usedcars$price)
