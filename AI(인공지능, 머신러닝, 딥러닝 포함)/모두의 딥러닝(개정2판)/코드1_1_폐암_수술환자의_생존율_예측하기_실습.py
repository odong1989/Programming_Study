# -*- coding: utf-8 -*-
"""코드1-1 폐암 수술환자의 생존율 예측하기 실습.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1QQMcXxSBUBoVJfpEb58QSjRH48Rsl9rj
"""

#1장-나의 첫 딥러닝_4.폐암 수술환자의 생존율 예측하기

#딥러닝을 구동하는데 필요한 케라스 함수 호출
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense

#필요한 라이브러리 불러오기
import numpy as np
import tensorflow as tf

#실행할 때마 같은 결과를 출력하기 위해 설정하는 부분
np.random.seed(3)
tf.random.set_seed(3)

#준비된 수술 환자 데이터를 불러오기

#개인적으로 구글드라이브에 csv파일을 업로드하였기에 마운트를 실시하는 코드 추가.
from google.colab import drive
drive.mount('/content/drive')

Data_set = np.loadtxt("/content/drive/MyDrive/Colab Notebooks/모두의 딥러닝(개정2판)/dataset/ThoraricSurgery.csv"
                       , delimiter="," )

#환자의 기록과 수술 결과를 X와 Y로 구분하여 저장
X = Data_set[:,0:17]
Y = Data_set[:,17]

#딥러닝 구조를 결정(모델을 설정하고 실행)
model = Sequential()
model.add(Dense(30, input_dim=17, activation='relu'))
model.add(Dense(1,activation='sigmoid'))

#딥러닝 실행
model.compile(loss='binary_crossentropy',
                optimizer='adam',
              metrics=['accuracy'])

model.fit(X,Y,epochs=100, batch_size=10)