#3-5. 과제 (파일 제출)


#1. myiris 라는 이름의 list 를 만들되 첫번째 요소는 iris dataset 의 Species 컬럼의 값들만 잘라서 넣고, 두번째 요소에는 iris dataset 의 나머지 4개의 컬럼값들을 잘라서 넣으시오. 각요소의 이름은 각각 ‘’Group” 과 “Data” 로 하시오.
myiris <-list(Group = iris$Species, Data=iris[,1:4])

#2. myiris 의 첫번째 요소와 두번째 요소의 내용을 보이시오.
myiris[1]
myiris[2]

#3. 영어의 요일(Sun, Mon, …)을 가지고 factor 변수 weekdays 를 생성하고 weekdays 의 내용을 보이시오.
weekdays <-factor(c("Sun","Mon","Tue",
                    "Wed","Thurs","Fri","Sat"))
weekdays
is.factor(weekdays)

#4. weekdays 의 값들을 숫자로 바꾸어 보이시오.
as.numeric(weekdays)


