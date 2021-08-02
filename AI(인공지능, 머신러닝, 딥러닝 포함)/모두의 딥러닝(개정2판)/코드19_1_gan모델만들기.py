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





