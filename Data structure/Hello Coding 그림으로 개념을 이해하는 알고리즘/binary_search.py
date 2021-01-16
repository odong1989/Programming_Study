#책11~12페이지

def binary_search(list, item):
    low = 0
    high = len(list) -1

    while low <= high :
        mid = int( (low + high) /2 )
        #원래 코드 : mid = (low + high)/2 
        #TypeError: list indices must be integers or slices, not float
        #위와 같이 형이 맞지 않는 타입에러 발생으로 형변환 처리.
        guess = list[mid]

        if guess == item:
            return mid
        if guess > item:
            high = mid-1
        else :
            low = mid +1

    return None



my_list = [1,3,5,7,9]

print( binary_search(my_list,3) )
print( binary_search(my_list, -1) )

#원래코드는 아래와 같다. 출력을 위해 수정함.
#print binary_search(my_list,3) 
#print binary_search(my_list, -1) 



























    
