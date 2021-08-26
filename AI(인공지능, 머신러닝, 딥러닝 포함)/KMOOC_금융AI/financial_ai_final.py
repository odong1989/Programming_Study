# -*- coding: utf-8 -*-
"""Financial_AI_Final.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1-SSgPaANV3pmTe9TOESYxANjFetsNUmO
"""

# 수업명 : AI 금융 - 기말고사(Kmooc)
# 제출일 : 2021년 08월 29일 
# 수험자 : 김보성
# 연락처 : kwunodong@gmail.com

# 비 고 : 문제 코드의 풀이를 위한 주석들이 작성되어있습니다.

# 금융 AI 기말고사 - 주의내용 및 시험목표 안내(출처:fnal_finai)
# 1.주의사항 
# – 주어진 ipynb 파일을 참고하여, 문제를 코딩하여 실행시켜 결과를 출력하여 최종 ipynb 파일을 업로드 해주세요. 
# – 파일은 구글 Colab에서 실행시켜주세요. 

# 2. 기말고사 - 기본사항 안내
# 본 기말고사는 한국거래소에 있는 주식을 대상으로 모멘텀 투자전략의 수익률을 추정해보고자 한다. 
# 예를 들어서, 모멘텀 계산방식은 다음과 같다 
# : 시점 t에서, (한 달 모멘텀 수익률) = (t − 23) 에서 t 시점까지의 종가(Close) 수익률). 
# (1)한 달 기간은 거래일 기준으로 23일로 가정하자. 
# (2)데이터는 ”FinanceDataReader”를 통해서 다운받도록 하자. 
#   (모멘텀 계산 기간: 2010.1.4 – 2020.11.30; 데이터 주기 (frequency) : daily)

#  =====  기말고사 시작   ============================================================================================

# 각 문제는 각각의 코드에 나뉘어 있습니다.
# 라이브러리는 각 문제에 선언하고 실시합니다.

# [문제 1] (데이터 준비) KOSPI 지수와 개별 주식별로 일별로 두 가지 종류의 데이터를 생성하시오. 다음 아래의 2개문항을 실시하시오.
# [1.1] KOSPI 지수와 개별 주식별로 일별로 다음 종가(Close) 와 수익률(%)의 두 가지 종류의 데이터를 생성하시오. 

# [1.1.1] 코스피 - 종가&수익률 출력
import matplotlib.pyplot as plt
import numpy as np
import pandas as pd

from sklearn.linear_model import LinearRegression
import FinanceDataReader as fdr

print("[1.1.1] 코스피 - 종가&수익률 출력")
temp_kospi = fdr.DataReader('KS11', '2021') #temp_kospi : 코스피 정보를 임시 보관.
KOSPI= pd.DataFrame()
KOSPI['Close']=temp_kospi['Close']          # Close(종가) 추가.
KOSPI['Yield']= 100 * (temp_kospi['Close']/temp_kospi['Close']-1) #수익률(Yield) : rt = 100 × ln(Closet/Closet−1). 

print(KOSPI)
print("----------------------------")

# 참고사이트 
# https://post.naver.com/viewer/postView.nhn?volumeNo=28170053&memberNo=21815

#------------------------------------------------------
#1.1.2. 임의의 주식(삼성전자)  - 종가&수익률 출력
print("[1.1.1] 임의의 주식 - 종가&수익률 출력")
temp_samsung = fdr.DataReader('005930','2021')#[['Close'] ] #2021년 전체를 적용
SAMSUNG= pd.DataFrame()
SAMSUNG['Close']=temp_samsung['Close']          # Close(종가) 추가.
SAMSUNG['Yield']= 100 * (temp_samsung['Close']/temp_samsung['Close']-1) #수익률(Yield) : rt = 100 × ln(Closet/Closet−1). 

print(SAMSUNG)
print("----------------------------")
#samsung


# [1.1.2] 개별주식 지수- 일별로 다음 종가(Close) 와 수익률(%)의 두 가지 종류의 데이터를 생성하시오. 
#        본 작성자는 아래와 같은 칼럼으로 출력하도록 할 예정.
#        | 거래일자 |  KOSPI 지수의 종가(Close) | 수익률(%)
#
#       * 수익률은 다음 공식으로 계산하시오 : rt = 100 × ln(Closet/Closet−1). 
# [1.2] KOSPI 지수와 임의의 한 주식을 선택하여 결과를 출력하시오. 



# 이외 참고한 사이트 목록
# https://pandas-datareader.readthedocs.io/en/latest/remote_data.html
# https://m.blog.naver.com/freed0om/221981429329
# https://colab.research.google.com/github/corazzon/finance-data-analysis/blob/main/2.1%20FinanceDataReader%EB%A5%BC%20%ED%86%B5%ED%95%9C%20%EC%83%81%EC%9E%A5%EC%A2%85%EB%AA%A9%20%EC%A0%84%EC%B2%B4%20%EB%B6%88%EB%9F%AC%EC%98%A4%EA%B8%B0-output.ipynb
# https://blog.naver.com/PostView.nhn?blogId=nackji80&logNo=222318657325&parentCategoryNo=&categoryNo=28&viewDate=&isShowPopularPosts=true&from=search



import matplotlib.pyplot as plt
import numpy as np
import pandas as pd

from sklearn.linear_model import LinearRegression
import FinanceDataReader as fdr

#-------------------------------------------------------------------------------------------------------------------------------
# [문제 2] (모멘텀 계산) 개별 주식의 Close를 활용하여 아래의 2개 사항을 수행하시오.
# [2.1] 1개월(23일,1m), 3개월 (65일, 3m), 6개월(130일, 6m), 9개월(190일, 9m), 12개월(253일, 12m) 등의 모멘텀을 계산하시오. 
# [2.2] KOSPI 지수와 임의의 한 주식을 선택하여 결과를 출력하시오.

#