#!/usr/bin/env python
# coding: utf-8

# In[1]:


from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
from sklearn.preprocessing import LabelEncoder
from sklearn.model_selection import StratifiedKFold

import pandas as pd
import numpy as np
import tensorflow as tf


# In[2]:


#시드값 설정
seed = 0
np.random.seed(seed)
tf.random.set_seed(seed)


# In[3]:


#데ㅣ터
df_pre =pd.read_csv("C:/sourceTree/DataScience/ICT/Py_Project/20201204_day35/wine.csv",header=None)
df = df_pre.sample(frac=1)#frac=1 : 원본데이터 100%를 불러온다, frac=1
#print(df.head(5)) #위처럼 샘플을 해준 덕분에 읨의 위치들의 정보들이 출력된다. 헤더는 헤더인데 다양한 행들을 출력한다.

#데이터 셋을 구성. 학습셋 검증셋 않음.
dataset = df.values
X = dataset[:,0:12].astype(float)
Y = dataset[:,12].astype(float)


# In[4]:


model = Sequential()

#조건1 : 4개의 은닉층 생성 30,12,8,1(선생님이 정한 임의의 값들임.)
model.add(Dense(30, input_dim=12,activation='relu' ))
model.add(Dense(12,  activation='relu' ) )
model.add(Dense(8,  activation='relu' ) )
model.add(Dense(1,  activation='sigmoid' ) )


# In[10]:


#조건2 : binary_crossentropy, adam 사용
model.compile(loss='binary_crossentropy',optimizer='adam',metrics=['accuracy'])

#조건3 : 200회 반복 
model.fit(X, Y, epochs =300 ,batch_size=300) 

#결과를 출력합니다.
print("\n Accuracy : %.4f" %(model.evaluate(X,Y)[1]))


# In[9]:





# In[ ]:




