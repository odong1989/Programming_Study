#2-3리스트

#데이터 구성설명
#-----------|---------------|-----------------------------------|------------------
# 챕터번호  |   백터변수명  |       벡터 타입                   |  변수 설명 
#-----------|---------------|-----------------------------------|--------------------
#  2.1 벡터 | subject_name  | character 벡터                    | 환자의 이름을 저장
#  2.1 벡터 |  temperature  | double 벡터                       | 환자의 체온을 저장
#  2.1 벡터 |  flu_status   | logical 벡터                      | 환자의 진단을 저장(인플루엔자 환자시  TRUE/아닐시 FALSE)  
#-----------|---------------|-----------------------------------|--------------------
#  2.2 팩터 |  gender       | MALE/FEMALE 펙터                  | 성별
#  2.2 팩터 |  blood        | Levels 펙터(A B AB O)             | 혈액형
#  2.2 팩터 |  symptoms     | Levels 펙터(SEVERE/MILD/MODERATE) | 병의 조짐(심각/경미/보통)
#-----------|---------------|-----------------------|--------------------

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
symptoms <-factor(c("SEVERE", "MILD", "MODERATE"),
                  levels=c("MILD","MODERATE","SEVERE"),
                  ordered = TRUE
                  )

#각 벡터마다 데이터들이 있음을 확인한다.
subject_name[1]
temperature[1]
flu_status[1]
gender[1]
blood[1]
symptoms[1]


#위의 데이터들을 리스트 구조로 만들자.
#리스트구조는 모든 데이터를 하나의 객체로 묶어 반복적으로 사용할 수 있게 해준다.
#c()함수 : 벡터를 생성.
#list()함수 : 리스트 생성.


#subject1 리스트에 1번행의 환자 정보들을 저장한다.
subject1 <- list(fullname = subject_name[1],
                 temperature = temperature[1],
                 flu_status = flu_status[1],
                 gender = gender[1],
                 blood = blood[1],
                 symptoms = symptoms[1])

subject1 #정상저장 확인
subject1[2] #온도(temperature) 확인 / subject1라는 리스트 안에 temperature라는 부분 list가 있다.
subject1$temperature #subject1[2]와 동일. 사람에게는 이방법이 더 쉽다.

#이름 벡터를 명시하여 리스트의 여러 항목을 얻을 수도 있다.
subject1[c("temperature","flu_status")] # temperature와 flu_status 구성 요소로 된 subject1 리스트의 부분집합을 반환한다.

#전체 데이터셋을 여러개의 리스트들을 묶어 선언하는 방법도 가능하다.