#!/usr/bin/env python
# coding: utf-8

# In[1]:


#import tensorflow.compat.v1 as tf
#tf.disable_v2_behavior()
#본퀴즈조건 : 텐서플로우 사용않고! 
#넘파이만으로 시그모이드 함수를 구현하세요(    np.exp, np.dot  활용)
import numpy as np


# In[2]:


##앞의 부분
#이부분에서 OR, AND, NAND 연산에 대한 10000번의 시뮬결과가 아래와 같이 나왔다고 가정하자.
#step: 10000 cost: 0.01747633  W: [[7.4011198] [7.4171198]] b: [-11.283303]#AND
#step: 10000 cost: 0.009325321 W: [[8.675739] [8.675732]] b: [-3.8626876]  #OR
#step: 10000 cost: 0.017403867 W: [[-7.4055345] [-7.4015345]] b: [11.295905] #NAND


# In[3]:


#가중치와 바이어스 설정
w11 = np.array([-7.40, -7.40]) #NAND
w12= np.array([8.67, 8.67])    #OR
w2 = np.array([7.41, 7.41])    #AND
b1=11.28
b2=-3.87
b3=-11.29


# In[4]:


#퍼셉트론-오리지널
#def MLP(x,w,b) :
#    y = np.sum(w*x) +b
#    if y<=0:
#        return 0
#    else:
#        return 1

#퍼셉트론-함수전체(1/1/e^2)로 만들어 검증
def MLP(x,w,b) :
    #y = 1 / (1+np.exp())#오답 나의 생각.
    y=1/(1+np.exp(-(np.dot(x,w) +b) ) )
    print(y)
    if y<=0.5:#시그모이드 함수 전체를 사용했으므로 0.5기준 비교
        return 0
    else:
        return 1


# In[5]:


#NAND게이트
def NAND(x1,x2):
    return MLP(np.array([x1,x2]), w11,b1)


# In[6]:


#OR게이트
def OR(x1,x2):
    return MLP(np.array([x1,x2]),w12,b2 )


# In[7]:


#AND 게이트
def AND(x1,x2):
    return MLP(np.array([x1,x2]),w2,b3)


# In[8]:


#XOR게이트
def XOR(x1,x2):
    return AND( NAND(x1,x2), OR(x1,x2) )


# In[9]:


# 값을 번갈아 대입해가며 최종값을 출력
if __name__ == '__main__':#메인모듈이면 아래의 내용을 실행하시오! 라는 의미로 간단히 생각하자.
    for x in [(0,0), (1,0), (0,1), (1,1)]:
        print("x[0]:",x[0], "x[1] :",x[1])
        y=XOR(x[0], x[1])
        print("입력 값 :"+str(x)+"출력 값:"+str(y))


# In[ ]:





# In[ ]:




