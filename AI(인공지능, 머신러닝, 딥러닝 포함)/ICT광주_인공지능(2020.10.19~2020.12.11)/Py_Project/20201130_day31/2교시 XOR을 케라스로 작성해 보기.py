#!/usr/bin/env python
# coding: utf-8

# In[1]:


import numpy as np
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Activation,Dense


# In[2]:


training_data = np.array([ [0,0], [0,1], [1,0], [1,1] ],"float32")
target_data = np.array([ [0], [1], [1], [0] ],"float32" )


# In[3]:


#딥러닝 구조를 결정합니다(모델을 설정하고 실행하는 부분입니다.)
model = Sequential()
model.add(Dense(4,input_dim=2,activation='relu')) #sigmoid로하면 
model.add(Dense(1,activation='sigmoid'))


# In[4]:


#딥러닝을 실행합니다.
model.compile(loss='binary_crossentropy',optimizer='adam',metrics=['accuracy'])
model.fit(training_data,target_data,epochs=1000, verbose=2)
print(model.predict(training_data) )


# In[5]:


#결과를 출력합니다.
print("\n Accuracy: %.4f "%(model.evaluate(training_data,target_data)[1]))

