#군집분석(cluster analysis)
#[정의] 유사한 속성을 가진 객체들을 군집(Cluster)으로 나누는(묶는) 데이터마이닝 기법

#[종류] 1.계층적 군집 : 사전에 군집수 k를 정하지 않고 단계적으로 군집 트리를 제공.
#       2.비계층적 군집 : 사전에 군집수 k를 정한 다음 각 객체를 k개 중 하나의 군집에 배정

#[척도] 1.거리(distance) 척도
#       : 거리가 가까울수록 유사성이 큼. 거리가 멀수록 유사성이 적어짐.
#       - 객체 i의 p차원 공간에서의 좌표는 다음과 같은 열벡터로 표현
#       - 대표적인 예로 '유클리디안 거리'가 있다.

#       2.상관계수척도
#       : 객체간 상관계수가 클수록 두 객체의 유사성이 커짐


#거리척도 예제
#(1)유클리디안 거리 예제
#lec 12_1_clus.R
#Clustering
#Distance measure

m1<- matrix(c(150, 50, 130, 55, 80, 80, 100, 85, 95, 91),
            nrow = 5,
            ncol = 2,
            byrow = TRUE)

m1 #m1이 매트릭스 구성임을 확임

m1<-as.data.frame(m1) #m1을 데이터프레임으로 변경.
m1

D1 <-dist(m1) #dist() : 거리계산 옵션.help("dist")에서 자세히 확인 가능
D1


#(2)민코프스키 거리(Minkowski distance)
D2 <- dist(m1, method="minkowski", p=3) #dist(data(or matrix), method="minliwski",p=3)
D2


#상관계수측정(cor) 예제

m2 <- matrix(
  c(20, 6, 14, 30, 7, 15, 46, 4, 2),
  nrow=3,
  ncol=3,
  byrow=TRUE)

m2

#상관계수 측정
cor(m2[1,], m2[2,] )
cor(m2[1,], m2[3,] )
