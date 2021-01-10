# CRUDproject

jsp로 만들어본 간단한 CRUD 게시판을 부트스트랩과 스프링 프레임워크로 여러 기능들을 추가하는 프로젝트 ✋


## 정리 ⛹

뷰는 제외하고 서버단 클래스를 기능별로 나중에 알아보기 쉽게 정리해봤습니다. 

게시판 페이징, 게시판 상세보기 뷰는 알아보기 쉬워서 제외했어요.


### 회원가입 

![회원가입](https://user-images.githubusercontent.com/48975983/104113811-b2efbb80-5340-11eb-9a8d-3be522013661.JPG)


### 로그인 

![로그인](https://user-images.githubusercontent.com/48975983/104113636-e4678780-533e-11eb-977e-f37bedebf87e.JPG)


### 회원탈퇴

![회원탈퇴](https://user-images.githubusercontent.com/48975983/104113638-e9c4d200-533e-11eb-93da-9b3ecadc4df4.JPG)


### 비밀번호변경

![비밀번호 변경](https://user-images.githubusercontent.com/48975983/104113637-e6314b00-533e-11eb-8305-04c6beb54cfc.JPG)


## 게시판

모든 게시글 변경, 삭제는 세션 객체의 닉네임과 글쓴이의 닉네임 기준으로 트랜잭션 처리합니다.
어드민 확인된 계정은 검증절차 없이 모든 댓글과 글을 삭제할 수 있습니다.  


![글 작성](https://user-images.githubusercontent.com/48975983/104113740-d36b4600-533f-11eb-8af9-80aefa70fb1c.JPG)


![글 수정 삭제](https://user-images.githubusercontent.com/48975983/104113741-d6663680-533f-11eb-9855-febd9a1ae7bf.JPG)

## 댓글



![댓글 작성 삭제](https://user-images.githubusercontent.com/48975983/104113745-e1b96200-533f-11eb-88c8-b06300fd5b63.JPG)



----------------------------------------------------------------------------

후기


인턴쉽하면서 틈날 때 만들었다보니 간략하게 줄일 수 있음에도 서비스 객체가 중구난방으로 흩어져있어 애 먹었네요....

점차 나아지겠죠... 🙃
