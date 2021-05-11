#1단계 : 데이터 수집 및 칼럼(열)들 설명.
#책에서 안내한 다운로드 사이트는 UCI머신러닝(http://archive.ics.uci.edu/ml/index.php)
#하지만 나는 캐글관련 사이트(https://www.kaggle.com/uciml/breast-cancer-wisconsin-data)에서 얻어왔다.
#csv파일을 찾는데 UCI는 찾지 못한 관계로...

#총 32개의 칼럼(열)로 식별번호, 암진단(양성음성여부)가 차지한다.
#나머지 30개의 수치 측정치는 디지털화된 세포핵의 데이터이다. 이는 즉 30개의 열들로 구성되고 있다는 것이다.
#
#이 중에서 10개의 특성이 세포핵의 특성을 나타낸다.

#(1)반지름
#질감
#둘레
#넓이
#매끄러움
#조밀성
#오목함
#오목점
#대칭성
#프랙탈 차원





wbcd <-read.csv("C:/sourceTree/Programming_Study/AI(인공지능, 머신러닝, 딥러닝 포함)/R을 활용한 머신러닝 2e(브레트 란츠 지음)/3장_게으른학습_최근접이웃분류/data_BreastCancer_Wisconsin.csv",stringsAsFactors = FALSE)
str(wbcd) #칼럼들을 확인하려면 str()이 더 좋다.

wbcd <-wbcd[-1] #id 삭제(id는 분석에 의미없다.)
str(wbcd) #칼럼들을 확인하려면 str()이 더 좋다.

table(wbcd$diagnosis)#B(양성)이 357개, M(음성)이 212개임을 확인할 수 있다.

wbcd$diagnosis <-factor(wbcd$diagnosis, levels=c("B","M"),
                        labels = c("Benign","Malignant") )


round(prop.table(table(wbcd$diagnosis)) * 100, digits = 1)



summary(wbcd[c("radius_mean","area_mean","smoothness_mean")])


#변환 : 수치 데이터 정규화(130~)

normalize <- function(x){
  return ( (x - min(x)) / (max(x) - min(x)) )
}









