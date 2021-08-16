# -*- coding: utf-8 -*-
"""코드19-1 GAN모델만들기.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1TAB7O7W57_MYLSpR0zQeRxOJ99E9y-9d
"""

from tensorflow.keras.datasets import mnist
from tensorflow.keras.layers import Input, Dense, Reshape, Flatten, Dropout
from tensorflow.keras.layers import BatchNormalization, Activation, LeakyReLU, UpSampling2D, Conv2D
from tensorflow.keras.models import Sequential, Model

import numpy as np
import matplotlib.pyplot as plt

#생성자 모델 만들기
generator = Sequential()
generator.add(Dense(128*7*7, input_dim=100, activation=LeakyReLU(0.2)))
generator.add(BatchNormalization() )
generator.add(Reshape((7,7,128)) )
generator.add(UpSampling2D() )
generator.add(Conv2D(64, kernel_size=5, padding='same', activation='tanh' ) )
generator.add(BatchNormalization())
generator.add(Activation( LeakyReLU(0.2) ))
generator.add(UpSampling2D())
generator.add(Conv2D(1,kernel_size=5, padding='same', activation='tanh'))

#판별자 모델 만들기
discriminator = Sequential() 
discriminator.add(Conv2D(64, kernel_size=5, strides=2, input_shape=(28,28,1), padding="same"))
discriminator.add(Activation(LeakyReLU(0.2)) )
discriminator.add(Dropout(0,3))
discriminator.add(Conv2D(128,kernel_size=5, strides=2, padding="same"))
discriminator.add(Activation( LeakyReLU(0.2)) )
discriminator.add(Dropout(0.3))
discriminator.add(Flatten())
discriminator.add(Dense(1,activation='sigmoid'))
discriminator.compile(loss='binary_crossentropy', optimizer='adam')
discriminator.trainable = False

#생성자와 판별자 모델을 연결시키는 GAN 모델 만들기
ginput = Input(shape=(100,))

dis_output = discriminator(generator(ginput))
gan = Model(ginput, dis_output)
gan.compile(loss='binary_crossentropy', optimizer='adam')
gan.summary()

#신경망을 실행시키는 함수 만들기
def gan_train(epoch, batch_size, saving_interval):

#MNIST 데이터 불러오기
#앞서 불러온 MNIST를 다시 이용한다.
#X_train만 호출한다.(테스트 과정은 필요없으며 이미지만 활용하기 때문.)

(X_train, _), (_, _) = mnist.load_data()
X_train = X_train.reshape(X_train.shape[0], 28, 28, 1).astype('float32')