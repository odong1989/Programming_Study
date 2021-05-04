#2-3리스트
#데이터 구성설명
#--------------|-----------------|------------------
# 백터변수명   |    벡터 타입    |  변수 설명 
#--------------|-----------------|--------------------
# subject_name | character 벡터  | 환자의 이름을 저장
# temperature  | double 벡터     | 환자의 체온을 저장
# flu_status   | logical 벡터    | 환자의 진단을 저장(인플루엔자 환자시  TRUE/아닐시 FALSE)  
# 


#데이터 입력
#2.1.백터예제에서 추가.
subject_name <- c("John Doe", "Jane Doe", "Steve Graves") #모두 같은 자료형(character형)을 갖는다.
temperature <-c(98.1, 98.6, 101.4)
flu_status <-c(FALSE, FALSE, TRUE)

#2.2.펙터예제에서 추가.
#팩터는 명목 데이터를 저장하기 위해 특화된 데이터 구조이다.
#팩터는 범주 변수나 순위 변수만을 나타내기 위해 사용된다.

gender <- factor(c("MALE","FEMALE","MALE")) 
blood <- factor(c("O", "AB", "A"), levels = c("A","B","AB","O"))

subject_name[1]
temperature[1]
flu_status[1]
gender[1]
