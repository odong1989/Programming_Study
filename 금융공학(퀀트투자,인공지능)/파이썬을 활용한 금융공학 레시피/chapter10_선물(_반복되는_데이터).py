# -*- coding: utf-8 -*-
"""chapter10_선물(#반복되는 데이터).ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/12M-6lU379GRl_8SWUQr0OwgDpKSZ96X0
"""

#반복되는 일을 처리하기 위해서는 배열(Array) 데이터 구조가 대표적으로 유용하다.
#기본 array배열 대신에 다차원 배열을 제공하는 넘파이를 사용한다.
#넘파이는 기본 array배열보다 장점이 많다.
#넘파이의 장점1:성능측면에서 기본배열보다 우수함.
#넘파이의 장점2:선형대수/난수 발생기/푸리에 변환등 여러가지 추가적인 기능을 제공한다.

#본 책에서 넘파이는 아래의 필수적인 2개만을 다뤄본다.
#(1)다차원 배열 다루기
#(2)벡터 연산법

#배열만들기
#(1) ndarray    : 넘파이가 제공하는 배열을 뜻함.
#(2) np.array() : 넘파이 배열을 만드는 명령어. 소괄호 안에 실제 배열 데이터를 넣는다.

import numpt as np


#1차원 array 만들기 []
a1 = np.array([1,2,3])
print(a1)

#2차원 array만들기[ [] ]
a2 = np.array([ [1,2,3],[4,5,6] ])
print(a2)

#3차원 array만들기 [[[ ]]]
a3 = np.array([ [[1,2,3], [4,5,6]], [[1,2,3], [4,5,6]] ])