#정렬되지 않은 학생 데이터를 학번/전공/이름/학점 중 택1하여 오름차순 정렬 실시하는 프로그램.
                  #학번,     전공,     이름, 학점(최대4.5)
sudentsData = [ [20200001,'전자공학과','나영미', 4.2],
                [20200003,'디자인과'  ,'박경심', 4.5],
                [20200002,'경영학과'  ,'김민수', 3.8],
                [20200005,'컴퓨터과'  ,'smith', 3.3],
                [20200004,'영문학과'  ,'daniel', 4.0]
              ]

print("현 sudentsData=", sudentsData)
print("sudentsData는 정렬되지 않은 상태입니다.")
print("오름차순 정렬을 할 수있는 방법은 아래와 같습니다.")
print("0을 입력:학번을 기준으로 정렬됩니다. ")
print("1을 입력:전공을 기준으로 정렬됩니다. ")
print("2을 입력:이름을 기준으로 정렬됩니다.(영어이름 먼저 출력) ")
print("3을 입력:학점을 기준으로 정렬됩니다. ")
select=int(input("원하는 정렬순서의 순번을 입력하세요."))

for i in range(len(sudentsData) -1) :
    for j in range(i+1, len(sudentsData)):
        if sudentsData[j][select] < sudentsData[i][select] :
            temp = sudentsData[i]
            sudentsData[i] = sudentsData[j]
            sudentsData[j] = temp
    print(i,'차 중간결과=',sudentsData)
print()#개행용
print('최종결과=',sudentsData)
