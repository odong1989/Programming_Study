# -*- coding: utf-8 -*-
"""chapter7_금융공학모델링.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1XandXZj2qeySDi90fKE-_rDJikDuWLhU
"""

#7.1S&P500 vs KOSPI200비교
#각 지수출처
#S&P500 : 네이버
#KOSPI200 : 다음

#[참고]각 포털별 금융시세 정보 제공여부 및 장단점.
#구글(불가)-2018년부터 금융시세정보 데이터정보수집 차단.
#야후 파이낸스(가능)-미국, 유럽시장의 금융시세정보 좋음. 단 한국시장정보는 누락이 많음.
#네이버&다음(가능)-국내외 금융정보를 제공해주는 것은 좋은데 포맷이 달라서 일일이 만들어줘야 함.

#네이버에서 KOSPI200 지수 수집하기(HTML 페이지 크롤링)(100page~)
#링크 : http://finance.naver.com/sise/sise_index.nhn?code=KOSPI200
#대상링크 : http://finance.naver.com/sise/sise_index_day.nhn?code=KPI200
#           위의 링크에서 KOSPI200지수 정보가 출력(레이아웃이 그때마다 달라질수 있음)

index_cd = 'KPI200'
page_n = 1

#'&page='는 해당 웹페이지에서 페이지번호를 선택하는데 사용합니다.
naver_index = 'http://finance.naver.com/sise/sise_index_day.nhn?code=' + index_cd + '&page=' +str(page_n)

#파이썬으로 해당 웹페이지의 소스코드를 가져온다.
from urllib.request import urlopen
source = urlopen(naver_index).read()
source

#뷰티풀수프(bs4)를 통해 태그별로 읽기 용이하게 변환한다.
#source를 그대로 출력하면 1줄로 쫘악 길게 나오기에 보기 불편하다.
import bs4
source = bs4.BeautifulSoup(source,'lxml')
print(source.prettify())