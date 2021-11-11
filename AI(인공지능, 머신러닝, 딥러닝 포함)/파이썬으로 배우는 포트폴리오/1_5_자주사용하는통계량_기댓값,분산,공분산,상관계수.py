# -*- coding: utf-8 -*-
"""1.5.자주사용하는통계량_기댓값,분산,공분산,상관계수.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1B0jgz46jvrYxuR72t_szOkVDjPlRoAl-
"""

#1.5.1.평균과 기댓값

#산술평균-(1)파이썬의 표준함수로 처리.
nums =[1,2,3,4,5,6] #nums 리스트에 값을 저장.
print(sum(nums) / len(nums ) ) #sum함수로 합계를, len함수로 데이터의 개수를 구한다.

#산술평균-(2)numpy 라이브러리를 가져와서 처리.
import numpy as np
a = np.array( [1,2,3,4,5,6] ) #array()함수로 리스트를 array 객체로 저장한다.
print(a.mean() ) #객체의 mean()함수를 활용하여 평균을 계산.

#기대값을 계산한다.,
#기대값을 계산하려면 사건과, 사건이 일어날 확률을 가진 리스트가 각각 필요하다.
#리스트를 반복하는 동안 두 리스트(사건값 리스트, 확률값 리스트)에서 사건/확률을 하나씩 곱하고 더하면 된다.

#사건과 확률을 case와 prob 리스트에 저장한다.
case =[1,2,3,4,5,6]
prob =[1/6. 1/6, 1/6. 1/6. 1/6. 1/6]

#사건리스트와 확률리스트를 zip 함수로 묶고 for루프로 반복한다.
#ex변수 : 반복하는 동안 두 리스트에서 값을 받아 변수 c와 p에 저장하고 곱한 결과를 저장.
ex = 0.0

for c,p in zip(case, prob):
    ex = ex + c*p
print(ex)#결과를 출력한다.

#위 반복문은 아래와 같은 1줄 for문으로도 대체가능.
ex = sum(c*p for c,p in zip(case, prob))

#결과출력
print(ex)

#여담-zip함수 설명
#  zip   : 여러 개의 리스트를 묶어 하나의 리스트처럼 사용하게 만들어주는 함수.
# 기대값 : case와 prob리스트 두 개를 하나로 묶어 반복하면서 c와p를 곱한뒤 더한 값.

a = [1,2,3] #리스트a에 1,2,3을 저장한다.
b = [4,5,6] #리스트b에 4,5,6을 저장한다.

for ab in zip(a,b): #두 개의 리스트를 하나로 묶어 루프를 돌린다.
    print(ab)

#1.5.2. 이동평균
#책의 '표1-8 일자별 이동평균의 계산흐름'의 이동평균 값들을 리스트저장.

#이동평균
#주가를 prices 리스트에 저장한다.
prices =[ 44800, 44850, 44600,43750, 44000, 44350, 45350, 45500, 45700 ]

#5일 이동평균
n =5

#prices의 n번째 항목부터 마지막 항목까지 반복.
for p in prices[ n: ]:
    #항목 p의 index를 마지막 인덱스로 지정한다.
    end_index = prices.index(p)
    #마지막 인덱스에서 n만큼 앞에 있는 시작 인덱스를 정한다.
    begin_index = end_index - n

#end_index와 begin_index를 계산해 가져올 위치를 계산한다.
print(begin_index, end_index)

#계산한 end_index와 begin_index를 갖고 prices 리스트에서 다섯 개 항목을 확인한다.
for p in prices[n:]:
    end_index = prices.index(p)
    begin_index = end_index - n
    print( prices[begin_index : end_index ] )

#다섯 개씩 가져와서 sum()함수로 합계를 구하고, n으로 나눠 이동평균을 계산한다.
for p in prices[ n: ]:
    end_index = prices.index(p)
    begin_index = end_index -n
    print(sum(prices[begin_index : end_index])/n )

#1.5.3. 가중(산술)평균

#평가 점수와 평가 비중을 scores와 weight리스트에 저장한다.
scores =[82, 90, 76]
weight = [0.2, 0.35, 0,45]

#scores와 weight 리스트를 zip함수로 묶어 for 루프로 반복한다.
#wgt_avg : 합계를 저장할 변수
wgt_avg = 0.0

#반복하는 동안 변수 s와 w에 저장하고 곱셈의 결과를 합한다.
for s,w in zip(scores, weight) :
    wgt_avg = wgt_avg + s*w

#결과를 출력한다.
print (wgt_avg)

