# Doit
* 생각의 흐름대로 진행하는 프로젝트
* 초기 구상
  * 12/21 - 일단 게시판 만들어
  * 1차 구현 리스트
    * 게시판 기능 CRUD 
      * ~~12/21 기준 USER 등 정의 이루어지지 않음~~
    * 1/2 유저 정의 및 유저와 계시판 관계 연결

---
### 게시판 기능 정의
* 게시판 글 작성
  * 제목
  * 내용
  * 작성자
  * 작성일자
  * 수정일자

* 게시판 리스트
  * 게시글 번호
  * 제목
  * 작성자
  * 조회수
  * 작성일시
* 게시글 디테일
  * 제목
  * 조회수
  * 내용
  * 작성자
  * 작성일시
  * 수정일시
* 게시글 수정
  * 작성자 확인
  * 제목 수정
  * 내용 수정
  * 수정 일시 반영
* 게시글 삭제
  * 작성자 확인
---
### 유저 정의

#### UserEntity
* userId - pk
* username - 계정명
* password - 비밀번호
* email - 이메일
* nickname - 닉네임
* createdAt - 생성일시
* updatedAt - 수정일시

