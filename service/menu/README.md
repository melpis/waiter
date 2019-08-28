메뉴 서비스 기능 정의
=========

1. 메뉴에 해당 하는 카테고리를 등록할 수 있다.
2. 카테고리에 해당 하는 음식을 등록할 수 있다.
3. 음식 등록시에는 가격, 사진, 정보를 입력할 수 있다. 

API sample

urlPath : /menus/{storeId}

response:

[  
   {  
      id:1,
      name:"원조선지해장국",
      price:7000,
      imagePath:"/static/images/1.png",
      description:"정말 맛있어요. 사골로 유려 냈음"
   },
   {  
      id:2,
      name:"순대국",
      price:6500,
      imagePath:"/static/images/2.png",
      description:"와! 한번 맛보면 잊을수 없는맛. 바로그 사골순대국"
   },
   {  
      id:3,
      name:"순두부찌게",
      price:8000,
      imagePath:"/static/images/3.png",
      description:"초당 순두부 보다 맛있어요."
   },
   {  
      id:4,
      name:"육개장",
      price:7000,
      imagePath:"/static/images/4.png",
      description:"얼큰한 맛이 일품인 육개장"
   },
   {  
      id:5,
      name:"얼큰짱뽕",
      price:7500,
      imagePath:"/static/images/5.png",
      description:"얼큰한 맛이 해장에 최고"
   },
   {  
      id:6,
      name:"부대찌게",
      price:8000,
      imagePath:"/static/images/6.png",
      description:"건강한 재료로 엄선해서 만든 부대찌게"
   }
]