# -*- coding: utf-8 -*-
"""chapter6코딩기술-파이썬기초.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1-UPYRSLPtSmdGDDodrgHTlko5wQ8u5qp
"""

#6.1함수선언
#선언방법 
#def 함수명(인수, 인수, ...):
#   #함수기능들 기재
#   return 반환값

#(예)f(x) = x+1 라는 함수를 선언&활용시
def f(x):
    y = x+1
    return y

print( f(66) )

#6.2외부 모듈 사용
import bs4 #bs4이라는 외부 모듈을 가져온다

#urllib라는 라이브러리 내의 request 모듈에 있는 urlopen 함수를 가져온다
from urllib.request import urlopen

import pandas as pd #pandas라는 모듈을 pd라는 이름으로 가져온다