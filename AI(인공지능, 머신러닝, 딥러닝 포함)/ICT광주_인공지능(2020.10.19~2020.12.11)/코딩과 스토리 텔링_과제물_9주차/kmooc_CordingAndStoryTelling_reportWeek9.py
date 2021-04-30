#학생들의 최고 성적 찾기 프로그램

#실생활에 맞춰하기 위해 리스트 개념 참조.
studentScore=[ [60, 80, 45], 
               [87, 32, 15], 
               [99, 97, 89] ] #3*1 구조.

maxScore=0    #반복문 통해 계산입력. 초기화만 설정.

#1차 반복 : 학생들의 성적(studentScore)에서 1명의 성적표(each) 선택.
for each in studentScore : #1차 반복문
    tempScore=0 #임시로 각 학생의 성적 총합을 보관할 변수.
    
    #2차 반복 : 선택한 1명의 성적표(each)의 내부값들을 1개씩 꺼냄.
    for studentData in each : #2차 반복문
        print(studentData,end=' ')
        tempScore+=studentData
    #2차 반복문 종료, 1차 반복문의 미진행된 아래의 코드들 진행.

    print("/",each,"의 성적총합 : ",tempScore)
    if(tempScore>maxScore) : 
        maxScore=tempScore
    
    
print("최고성적:",maxScore)
