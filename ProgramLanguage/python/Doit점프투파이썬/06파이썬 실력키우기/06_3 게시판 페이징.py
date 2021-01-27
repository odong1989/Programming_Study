def getTotalPage(PageCount,pagePerOutput):
    """
    PageCount : 게시물의 총 건수
    pagePerOutput : 한 페이지당 보여 줄 게시물 수
    출력값 : 총 페이지 수 = 총건수(m)/한 페이지당 게시물 수(n)
    """

    print(PageCount // pagePerOutput+1) #소수점 이하 출력 않도록 //연산자 사용 



getTotalPage(23,10)
getTotalPage(5, 10)
getTotalPage(25,10)
getTotalPage(0,10)
