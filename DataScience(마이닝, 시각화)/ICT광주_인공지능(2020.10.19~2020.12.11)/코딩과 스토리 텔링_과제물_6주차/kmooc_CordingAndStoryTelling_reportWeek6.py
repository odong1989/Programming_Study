
#나의 소유금.
myWalletMoney=10000 
#마트품목 설정
ramenSet = 3500.0         #5개 묶음 셋트
saleRate_ramen = 20/100 #라면의 할인율(20%) 

beefSirloin=20000.0 #소고기등심
saleRate_beefSirloin = 50/100 #소고기등심의 할인율(50%)  

holidayPresent = 20000.0  #명절선물셋트
saleRate_holidayPresent = 0/100 #정가 그대로 진행.

#현 상황안내 출력문 
print("마트에 도착했습니다. 필요한 물건명,개수를 입력해주세요.")
print("현 지갑금액:",myWalletMoney)
print("<가격안내>")
print("라면셋트     :  3500원 / 할인률20%(셋트당 실제가격 2800원)")
print("소고기등심   : 20000원 / 할인률50%(개당 실제가격 10000원)")
print("명절선물셋트 : 20000원 / 할인률 0%(개당 실제가격 20000원)")


buyGoods=input("구매할 물품명:")

#사용자의 대표적인 입력패턴 대응 위해 or로 범주 넓힘.
if (buyGoods =="라면셋트" or buyGoods=="라면 셋트"or buyGoods=="라면 세트" or buyGoods=="라면") :
    print("구매하실 품목 : 라면셋트")
    goodsPrice=ramenSet
    saleRate = float(saleRate_ramen)
    goodsEA=float( input("구매 개수:") )
    
elif(buyGoods=="소고기등심" or buyGoods=="소고기 등심" or buyGoods=="소고기") :
    print("구매하실 품목 : 소고기등심")
    goodsPrice=beefSirloin
    saleRate = saleRate_beefSirloin
    goodsEA=float( input("구매 개수:") )

elif(buyGoods=="명절선물셋트" or buyGoods=="명절 선물 셋트" or buyGoods=="명절선물") :
    print("구매하실 품목 : 명절선물셋트")
    goodsPrice=holidayPresent
    saleRate = saleRate_holidayPresent
    goodsEA=float( input("구매 개수:") )
    
else :
    print("없는 품목입니다. 종료합니다.")

#
salesPrice = (goodsPrice*saleRate)*goodsEA
totalPrice = goodsPrice*float(goodsEA) - salesPrice

if(myWalletMoney>=totalPrice):
    myWalletMoney=myWalletMoney-totalPrice
    print("") #구분용 개행
    print("구매완료되었습니다. 결과는 아래와 같습니다.")

    print("구매품목 : ",buyGoods)
    print("구매개수 : ",int(goodsEA) )

    print("") #구분용 개행
    print("정가 가격   : ",int(goodsPrice*goodsEA) )
    print("할인된 금액 :-",int(salesPrice) )
    print("최종 구매가 : ",int(totalPrice) )

    print("") #구분용 개행
    print("지갑잔액 : ",int(myWalletMoney) )
else :
    print("") #구분용 개행
    print("구매가능 금액을 초과하여 불가합니다.")
    print("현재 구매가능 금액:",myWalletMoney)
