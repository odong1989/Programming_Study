#팩터 예제 69~72페이지
#명목(norminal) : 특징 범주 값을 갖는 특성을 보이는 경우를 말함.

#팩터는 명목 데이터를 저장하기 위해 특화된 데이터 구조이다.
#팩터는 범주 변수나 순위 변수만을 나타내기 위해 사용된다.

#문자 벡터로 저장해도 되지만 팩터가 더 효율적이라고 책은 설명하며 이유는 아래와 같이 설명한다.
#이유(1) 저장할 데이터를 범주 레이블에 한 번만 저장한다는 것.
#        "MALE","FEMALE","MALE"를 저장할 경우 1,2,1 를 저장해 동일 정보 저장시 메모리를 절약해준다.
#이유(2) 머신러닝 알고리즘이 명목 데이터와 수치 데이터를 다르게 취급하기 때문.
#        R함수에게 범주데이터를 적절하게 다루려면 팩터로 코딩해야 한다.


gender <- factor(c("MALE","FEMALE","MALE")) 
gender
blood <- factor(c("O", "AB", "A"), levels = c("A","B","AB","O"))
blood[1:2]
symptoms <-factor(c("SEVERE", "MILD", "MODERATE"),
                  levels=c("MILD","MODERATE","SEVERE"),
                  ordered = TRUE
                  )
symptoms

symptoms >"MODERATE"
