#7장 블랙박스방법-신경망과 서포트벡터 머신

#서장(305~306페이지)
#블랙박스 프로세스 : 입력->출력으로 변환하는 과정(매커니즘)이 불투명한 것을 말한다.
#                    머신러닝의 경우 블랙박스는 복잡한 수학에서 기인하게 된다.

#블랙박스 모델은 이해가 쉽지 않다.
#그렇다고 무작정 블랙박스 모델을 맹목적으로 사용하면 안된다.

#본 책의 7장에서 언급되는 '블랙박스 머신러닝 방법'들은 아래와 같다.
#(1)신경망은 동물의 뇌 구조를 모방해 임의의 기능을 모델링한다.
#(2)서포트 벡터 머신은 다차원 표면을 사용해 특징과 결과 사이의 관계를 정의한다.
#(3)이 방법들은 복잡성에도 불구하고 실제 문제에 쉽게 적용될 수 있다.

#--------------------------------------------------------------------------------------

#신경망의 이해(306~)
#인공신경망(ANN, artifical Neural Network)
# : 일련의 입력 신호와 출력 신호 사이의 관계를 모델링하며,
#   생물학적 뇌가 감각 입력의 자극에 대해 어떻게 반응하는지를 이해해 유도한 모델을 이용한다.
#ANN은 분류/수치예측/자율패턴인식 등 거의 모든 학습작업에 적용될 수 있는 다재다능한 학습자라 할 수 있다.


#가장 기초적인 ANN은 뇌의 문제해결방식을 시뮬레이션하기 위해 50년이상 사용돼왔다.
#처음에는 논리 AND/OR함수와 같은 간단한 함수를 학습했고, 발전해오면서 ANN도 복잡해지면서 실용적인 문제에 적용되게 되었다.
#(1)음성 메일 텍스트 변환 서비스와 우편물 분류기에 사용되는 것과 같은 음성 및 필기체 인식 프로그램
#(2)사무용 건물 환경 제어나 자율주행 차와 자동 조정 드론 같은 스마트 장치의 자동화
#(3)날씨와 기후패턴, 인장강도, 유체역학과 다양한 과학적 사회적 경제적 현상의 정교한 모델 등등


#ANN에 관련된 용어모음-------------------------------------------------------------------------------------


#ANN(신경망) 관련용어  |    설명                                       |   관련용어
#======================|===============================================|==============================================================|
#(1)활성함수           | 인공 뉴런이 들어오는 정보를 처리해서          | 임계치활성함수 : 임계치를 충족한다면 뉴런은 신호를 전달하고, |
#                      | 네트워크를 통해 정보를 전달하는 매커니즘.     |                  임계치 미만시 아무것도 않는것.              |
#                      |                                               |                  대표적으로 '시그모이드 함수'가 있다.        |
#----------------------|-----------------------------------------------|--------------------------------------------------------------|
#(1.1)시그모이드 함수  | 가장 일반적으로 사용되는 활성함수             |                                                              |
#     (311~313)        |                                               |                                                              |
#======================|===============================================|==============================================================|
#(2)네트워크 포플로지  | 신경망의 학습 능력은 뉴런의 토폴리지에 기인   |                                 |
#                      | 네트워크 포폴리지는 아래의 3가지 요인이 있다. |                                 |
#                      | 1.계층 개수                                   |                                 |
#                      | 2.네트워크의 정보가 역방향으로 이동가능 여부  |                                 |
#                      | 3.네트워크의 각 계층별 노드 개수              |                                 |
#----------------------|-----------------------------------------------|--------------------------------------------------------------|
#(2.1)계층(Layer) 개수 | 입력노드:입력 데이터에서 미처리 신호를 받는다.| 단층 네트워크
#                      | 입력노드는 수신 데이터를 그대로 처리한다.     |
#                      |           |                                 |
#----------------------|--------------------------------------------|--------------------------------------------------------------|
#(2.2)네트워크의 정보  |                                    |                                 |
#역방향 이동가능 여부  |   |                                 |
#                      |         |                                 |
#----------------------|--------------------------------------------|--------------------------------------------------------------|
#(2.3)네트워크의 정보  |                                                |                                 |
#각 계층별 노드 개수   |                                           |                                 |
#                      |                                            |                                 |
#----------------------|--------------------------------------------|--------------------------------------------------------------|

#(3)훈련 알고리즘      |




#예제 : ANN으로 콘크리트 강도 모델링========================================================================

#1단계 데이터 수집(321)

#2단계 데이터 탐색 및 준비(322~323)
concrete <- read.csv("C:/sourceTree/Programming_Study/AI(인공지능, 머신러닝, 딥러닝 포함)/책_R을 활용한 머신러닝 2e(브레트 란츠 지음)/7장/concrete.csv")
str(concrete)
#데이터를 분석하면 
#(1)9개의 변수는 8개의 특징과 1개의 결과를 갖고 있다.
#(2)변수들의 값이 0~1000으로 다양하기에 신경망을 그대로 적용하기 어렵다
#   (*신경망의 경은 입력데이터가 0에 가까운 값들일수록 잘 작동함) 
#(3)신경망에 적용하기 위해 정규화/표준화 함수로 데이터 재조정을 실시한다.
#   (=데이터가 비정규적이기에 0~1으로 정규화를 실시한다.)


#정규화를 실시하기 위한 코드
#3장에서 정의한 normalize의 함수 코드
normalize <- function(x) { 
  return((x - min(x)) / (max(x) - min(x)))
}

#lapplt()함수를 이용하여 콘크리트 데이터 프레임의 모든열에 normalize() 함수를 적용한다.
concrete_norm <- as.data.frame(lapply(concrete, normalize))

#0~1으로 정규화가 되었는지를 확인하기 위해 summary함수를 사용함.
summary(concrete_norm$strength)

#정규화 않은 원래의 값. 2.33~82.60까지 매우 폭이 넓으며 0~1으로 상당히 정규화되었음을 알 수 있다.
summary(concrete$strength)


#정규화한 다음에 훈련용/평가용으로 데이터들을 나눈다.
concrete_train <- concrete_norm[1:733,]
concrete_test  <- concrete_norm[734:1030,]


#3단계. 데이터 통한 모델 훈련
#사용할 신경망    : 다층 순방향 신경망
#위의 신경망 이유 : 콘크리트에 사용된 재료와 완성된 산출물의 강도 사이에 관계를 리모델링 하기 위해.
#사용할 패키지    : neralnet 패키지
#neralnet 패키지  : 사용하기 쉬운 표준 신경망의 구현 가능.

#추가설명 : R에서 사용되는 ANN모델들은 각각의 장단점을 갖는다.
#(1)nnet 패키지 : 표준 R에 기본적으로 설치되는 패키지라서 가장 자주 사용된다.  
#                 또한 표준 역전파보다 더 지능적인 알고리즘을 사용.
#(2)RSNNS 패키지 : 완벽한 신경망 기능의 모음을 제공. 배우기 어렵다는게 단점.

install.packages("neuralnet")
library(neuralnet)
concrete_model <- neuralnet(strength ~cement + slag + ash + water + superplastic + coarseagg + fineagg + age, data = concrete_train)
