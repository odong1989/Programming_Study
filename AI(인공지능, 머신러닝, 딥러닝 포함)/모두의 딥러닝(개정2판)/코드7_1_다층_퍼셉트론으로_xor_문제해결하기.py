# -*- coding: utf-8 -*-
"""코드 7-1 다층 퍼셉트론으로 XOR 문제해결하기.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1P1H1r56oMka-SnrV0J34X78my7g8560J
"""

import numpy as np

#가중치와 바이어스

w11 = np.array([-2,-2])
w12 = np.array([2,2])
w2 = np.array([1,1])

b1 = 3
b2 = -1
b3 = -1

#퍼셉트론

def MLP(x,w,b):
    y = np.sum(w*x)+b
    if y <=0 :
        return 0
    else:
        return 1

#NAND 게이트
def NAND(x1, x2):
    return MLP(np.array([x1,x2]), w11, b1 )

#OR 게이트
def OR(x1, x2):
    return MLP(np.array([x1,x2]),w12,b2 )

#AND 게이트
def AND(x1,x2):
    return MLP(NAND(x1, x2), w2,b3)

#XOR 게이트
def XOR(x1,x2):
    return AND(NAND(x1,x2), OR(x1,x2))

#x1,x2 값을 번갈아 대입하며 최종값 출력

if __name__ == '__main__':
    for x in [(0,0), (1,0), (0,1), (1,1) ]:
        y = XOR( x[0], x[1] )
        print("입력값 : "+str(x) + "출력값 : "+str(y) )









