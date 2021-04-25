#책 307페이지 —————-
#주로 csv 파일, 엑셀(xls, xlsx)파일을 많이 부른다.

#1)csv 파일 불러오기(데이터 가져오기)

#방법1: read.table 명령으로 csv파일 불러오기
Data1 <- read.table(“D:\\DATA\\example.csv”, header=T, sep=“,”)
#옵션1) header=T  csv파일의 첫 줄을 변수명으로 지정할 수 있다.
#옵션2) sep=“,”     데이터가 쉼표(,)로 구분된 데이터 파일임을 지정해준다.


#책 308페이지
#방법2 : read.csv