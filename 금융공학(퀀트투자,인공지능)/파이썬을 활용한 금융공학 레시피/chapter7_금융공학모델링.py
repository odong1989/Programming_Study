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

#XPath통해 필요한 데이터의 위치 편하게 찾기(필요한 데이터의 경로 찾기)

td = source.find_all('td')
#<td>태그에 필요한 주식정보(date, number1(당일 종가) 등)가 있기에 td를 확인해 보는 것.
len(td) #td의 갯수를 확인(54개임을 알 수 있다,)
#위처럼 54개나 되는 경우 일일이 확인하기에는 어려움이 많다.
#그래서 'XPath'를 통해 원하는 데이터의 위치를 찾고자 한다.


#XPach(XML Path Language) : 웹사이트(또는 XML문서)에 있는 각 항목의 주소를 
#                           문서에 포함된 태그를 조합한 경로 형태로 표현하는 언어.

#웹브라우저에서 데이터의 XPath 확인 방법(크롬 기준, 책 107페이지 참고)
#(사전준비)개발자 모드등으로 웹페이지의 소스코드를 볼 수 있도록 한다.
#(1)스크린 우측에서 음영으로 선택된 부분에 마우스를 갖다 댄 다음
#(2)오른쪽 클릭하면 나오는 메뉴에서 Copy를 선택한다.
#(3)Copy XPath를 선택한다. 그러면 아래와 같은 형식으로 나오게 된다.
#   /html/body/div/table[1]/tbody/tr[3]/td[1]
#    의미:1번째 테이블의 tbody에서 3번째 행의 1열에 있다.

#find(), 또는 find_all()통해 데이터 가져오기
#XPath를 통해 좌표를 확인했다면 이제 find(), find_all()통해 데이터를 가져올 수 있다.

#find(태그명) : 가져올 값이 1개인 경우 활용.
#find_all(태그명)[순서] : 가져올 값이 2개 이상시 활용.

#거래일(date) 정보를 저장한 td에 접근하여 데이터 가져오기.
source.find_all('table')[0].find_all('tr')[2].find_all('td')[0]

#가져올 데이터들이 class명으로 묶여 있다면 태그를 생략할 수 있다,
#한 마디로 'html 태그들이 걸러진 순수한 정보만 받을 수 있다'는 것이다.
d = source.find_all('td',class_='date')[0].text
d

#가져온 데이터를 파이썬 포맷에 맞추기
#예제1 : 날짜 데이터 가져오기

#d = source.find_all('td',class_='date')[0].text를 통해 가져온 날짜 데이터는 파이썬과 날짜형식이 일치하지 않는다.
# 네이버의 날짜 형식(문자열) : '2021.11.26'                 
# 파이썬의 날짜 형식(date형) : datetime.date(2021, 11, 26) 

# 이처럼 가져온 데이터가 파이썬의 자료형과 맞지 않는 경우가 있기에 관련된 파이썬의 라이브러리로 형식을 맞춰 바꿔준다.
# 본 예제의 경우 '날짜' 형식이므로 파이썬의 datetime 라이브러리를 활용하여 date형식으로 바꿔본다.

#1.관련 라이브러리 임포트
import datetime as dt

#2.문자열 상태인 정보를 split()함수를 통해 분해한다.
#사용법 : 문자열.split(구분자)
yyyy = int( d.split('.')[0] )
mm = int(d.split('.')[1] )
dd = int(d.split('.')[2] )

#3.분해된 정보를 재구성 한다.
this_date = dt.date(yyyy, mm, dd)
this_date

#4.함수를 작성한다. 
#  함수를 통해 분해&재구성 작업을 자동화 시키는 것이다.
#  어렵게 생각할 필요없다. 2,3과정을 정상작동 확인하면 이를 그대로 복사&붙여넣기하는 급이다.

def date_format(d):
    d = str(d).replace('-', '.')
    yyyy = int(d.split('.')[0] )
    mm = int(d.split('.')[1] )
    dd = int(d.split('.')[2] )

    this_date = dt.date(yyyy, mm , dd)
    return this_date

#가져온 데이터를 파이썬 포맷에 맞추기
#예제2 : 지수 데이터 가져오기(해당 일자의 종가지수 가져오기)

this_close = source.find_all('tr')[2].find_all('td')[1].text
this_close = this_close.replace(',','') #쉼표(,) 제거
this_close = float(this_close)
this_close

#데이터 추출 기능을 함수로 만들기 (113~)

def historical_index_naver(index_cd, page_n=1, last_page=0):

    naver_index = 'http://finance.naver.com/sise/sise_index_day.nhn?code=' +index_cd + '&page=' + str(page_n)

    source = urlopen(naver_index).read()        #지정한 페이지에서 코드 읽기
    source = bs4.BeautifulSoup(Source, 'lxml')  #뷰티플 수프로 태그별로 코드 분류

    dates = source.find_all('td', class_='date')        #<td class="date">태그에서 날짜 수집
    prices = source.find_all('td', class_='number_1')    #<td class="number">태그에서 지수 수집

    for n in range(len(dates)):

        if dates[n].text.split('.')[0].isdigit():

            #날짜 처리
            this_date = dates[n].text
            this_date = date_format(this_date)

            #종가처리
            this_close = prices[n*4].text       #prices 중 종가지수인 0,4,8....번째 데이터 추

            this_close = this_close,replace(',','')
            this_close = float(this_close)


            #딕셔너리에 저장
            historical_prices[this_date] = this_close

    #페이지 내비게이션
    if last_page == 0 :
        last_page = source.find('td', class_='pgRR').find('a')['href']

        #마지막 페이지 주소 추출
        last_page = last_page.split('&')[1] # &뒤의 page=506 부분 추출.(숫자 506는 실시당일마다 달라질 수 있을 듯 함.)
        last_page = last_page.split('=')[1] # '=' 뒤의 페이지 번호만 추출.
        last_page = int(last_page)          # 숫자형 변수로 변환

    #다음 페이지 호출
    if page_n < last_page:
        page_n = page_n+1
        historical_index_naver(index_cd, start_date)

    return historical_prices


def historical_index_naver(index_cd, start_date='', end_date='', page_n=1, last_page=0):

if start_date : #start_date가 있으면
    start_date = date_format(start_date)    #date 포맷으로 변환

else:   #없으면
    start_date = dt.date.today()    #오늘 날짜를 지정.

if end_date:
    end_date = date_format(end_date)
else:
    end_date = dt.date.today()

if this_date <= end_date and this_date >= start_date:
    #start_date와 end_date 사이에서 데이터 저장
        #종가 처리
        #관련 코드 생략되어 없음.

    elif this_date < start_date:
    #start_date 이전이면 함수 종료
        return historical_prices

def historical_index_naver(index_cd, start_date='', end_date='', page_n=1, last_page=0):
    if start_date: #start_date가 있으면
        start_date = date_format(start_date) #date 포맷으로 변환
    else : #없으면
        start_date = dt.date.today() #오늘 날짜를 지정
    if end_date:
        end_date = date_format(end_date)
    else : 
        end_date = dt.date.today()


    naver_index = 'http://finance.naver.com/sise/sise_index_day.nhn?code='
                  + index_cd + '&page=' + str(page_n)

    source = urlopen(naver_index).read()     #지정한 페이지에서 코드 읽기
    source = bs4.BeatifulSoup(source,'lxml') #뷰티플 수프로 태그별로 코드 분류

    dates = source.find_all('td',class_='date')     # <td class = "date">태그에서 날짜 수집
    prices =source.find_all('td',class_='number_1') # <td class="number_1">태그에서 지수수집

    for n in range(len(dates)):
        
        if dates[n].text.split('.').isdigit():

            #날짜처리
            this_date = dates[n].text
            this_date = date_format(this_date)

            if this_date <= end_date and this_date >= start_date:
            #start_date와 end_date 사이에서 데이터 저장.
                #종가처리
                this_close = prices[n*4].text   #price 중 종가지수인 0,4,8...번째 데이터 추출.
 
                this_close = this_close.replace(',','')
                this_close = float(this_close)

                #딕셔너리에 저장
                historical_prices[this_date] = this_close

        elif this_date < start_date:
        #start_date 이전이면 함수 종료        
            return historical_prices

        if last_page == 0:
            last_page = source.find('td', class='pgRR').find('a')['href']

        #마지막 페이지 주소 추출
            last_page = last_page.split('&')[1] # &뒤의 page=506부분 추출
            last_page = last_page.split('=')[1] # '='뒤의 페이지 번호만 추출
            last_page = int(last_page) #숫자형 변수로 변환.

        # 다음 페이지 호출
        if page_n < last_page:
            page_n = page_n +1
            historical_index_naver(index_cd, start_date, end_date, page_n, last_page)

        return historical_prices

index_cd = 'KPI200'
    historical_prices = dict()
    historical_index_naver(index_cd, '2018-4-1', '2018-4-4')
    historical_prices

#122page

import pandas as pd
from urllib.request import urlopen
import json #해외지수는 json형태로 표출됨

symbol = 'NII@NI225'
page =1

url ='https://finance.naver.com/word/worldDayListJson.nhn?symbol' +simbol+'&fdtc=0&page='+str(page)
raw = urlopen(url)
data == json.load(raw)

data[0]['xymd']
data[0]['clos']

d=dict()
for n in range(len(data)):
    date = pd.to_datetime(data[n]['xymd']).date()
    price = float(data[n]['clos'])
    d[date] = price
print(d)


def read_json(d, symbol, page=1):
    url = 'https://finance.naver.com/world/worldDayListJson.nhn?symbol=' +symbol+
    '&fdtc=0&page='+str(page)
    raw = urlopen(url)
    data = json.load(raw)

    for n in range(len(data)):
        date = pd.to_datetime(date[n]['xymd']).date()
        price = float(data[n]['clos'])
        d[date] = price


    if len(data) == 10:
        page +=1
        read_json(d, symbol, page) 

    return(d)

#124page

historical_index = pd.Series()
historical_index = read_json(historical_index, symbol, page)

historical_index.head(3)

indices = {
    'SPI@SPX' : 'S&P 500',
    'NAS@NDX' : 'Nasdaq 100',
    'NII@NI225' : 'Nikkei 225'

#125p

historical_index = pd.Series()
historical_index = read_json(historical_index, symbol, page)

historical_index.head(3)

indices = {
    'SPI@SPX' : 'S&P 500',
    'NAS@NDX' : 'Nasdaq 100',
    'NII@NI225' : 'Nikkei 225'
    }


#126페이지

historical_indices = dict()
for key, value in indices.items():
    print(key, value)
    s = dict()
    s = read_json(s, key, 1)
    historical_indices[value] = s

prices_df = pd.DataFrame(hisotical_indices)

def index_global(d, symbol, start_date='', end_date='', page=1):

    end_date = date_format(end_date)
    if start_date == '':
        start_date = end_date - pd.DateOffset(months=1)
    start_date = date_format(start_date)

    url = 'https://finance.naber.com/world/worldDayListJson.nhn?symbol='+symbol+'&fdtc=0&page='str(page)
    raw = urlopen(url)
    data = json.load(raw)

    if len(data)> 0:

        for n in range(len(data)):
            data = pd.to_datetime(data[n]['xymd']).date()

            if data<= end_date and date>=start_date:
                #start_date와 end_date 사이에서 데이터 저장

                #종가처리
                price=float(data[n]['clos'])
                #딕셔너리에 저장
                d[date] = price
            elif date < start_date :
                #start_date 이전이면 함수 종료
                return (d)

        if len(data) == 10:
            page += 1
            index_global(d, symbol, start_date, end_date, page)

    return (d)

    historical_indices = dict()
    start_date = '2019-01-01'
    end_date = '2019-03-31'

    for key, value in indices.items():
        s = dict()
        s = index_global(s, key, start_date)
        historical_indices[value] = s
    
    prices_df = pd.DataFrame(historical_indices)

#127,128페이지

#데이터프레임으로 여러 딕셔너리를 테이블 하나로 합치기
index_cd = 'KPI200'
historical_prices = dict()
kospi200 = historical_index_naver(index_cd,'2017-1-1','2017-12-31')

index_cd = 'SPI&SPX'
historical_prices = dict()
sp500 = index_global(historical_prices, index_cd, '2017-1-1','2017-12-31')

tmp = {'S&P500' : sp500, 'KOSPI200': kospi200}
tmp

import pandas  as pd

df = pd.DataFrame(tmp)
df

#130page


df = df.fillna(method='ffill')
if df.isnull().values.any():
    df = df.fillna(method='bfill')
df


#132page

index_cd = 'SPI@SPX'
historical_prices= dict()
sp500 = index_gloval(hsitorical_prices, index_cd, '2008-1-1', '2017-12-31')

tmp = {'S&P500':sp500, 'KOSPI200': kospi200}

df = pd.DataFrame(tmp)

df - df.fillna(method='ffill')
if df.isnull().values.any():
    df.df.fillna(method='bfill')
#133page

# Commented out IPython magic to ensure Python compatibility.
#맷플롯립을 이용하여 그래프 그리기(134~)
#맷플롯립 : 그래프를 이미 파일로 만들어서 화면에 출력함.

import matplotlib.pyplot as plt
# %matplotlib inline

plt.figure(figsize=(10,5)) #크기 조절
plt.plot(df['S&P500'])      #데이터 선택
plt.plot(df['KOSPI200'])
plt.legend(loc=0)           #범례 위치 지정
plt.grid(True, color='0.7', linestyle=':'. linewidth=1) #그리드 설정
#134


plt.figure(figsize=(10,5)) #크기 조절
plt.plot(df['S&P500']) #데이터 선택
plt.plot(df['KOSPI'])
plt.legend(loc=0)
plt.grid(True, color='0.7', linestyle=':'. linewidth=1) #그리드 설정
#135


df.iloc[0]                  #인덱스(위치)로 지정
df.loc[dt.date(2008,1,2)]   #값(날짜)으로 지정

df_datio_2016_now = df.loc[dt.date(2015,1,1):] / df.loc[pdt.date(2016,1,4)] *100
df_ratio_2016_now.head(3)

#회귀분석
plt.figure(figsize=(5,5))
plt.scatter(df_ratio_2016_now['S&P500'], df_ratio_2016_now['KOSPI200'], marker='.')
plt.grid(True,color='0.7', linestyle=':', linewidth=1)
plt.xlavel('S&P500')
plt.ylabel('KOSPI200')
#138