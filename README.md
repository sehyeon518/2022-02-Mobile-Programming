# Hoggy Warty Hogwarts

국민대학교 소프트웨어학부 20213043 이세현

모바일프로그래밍 02분반 개인 과제

## Introduction

해리포터 도서 8권 판매 android 10 이상 application

사용자의 기능 이해를 위해서 각 페이지에 대한 소개는 액티비티 최상단 녹색 글씨로 적어 놓음.

- *Harry Potter and the Philosopher's Stone* (1997)
- *Harry Potter and the Chamber of Secrets* (1998)
- *Harry Potter and the Prisoner of Azkaban* (1999)
- *Harry Potter and the Goblet of Fire* (2000)
- *Harry Potter and the Order of the Phoenix* (2003)
- *Harry Potter and the Half-Blood Prince* (2005)
- *Harry Potter and the Deathly Hallows* (2007)
- *Harry Potter and the Cursed Child* (2006)

### 사용 색상

#5d5d5d (gray)

#1a472a (green)

#aaaaaa (gray)

#2a623d (green)

#000000 (black)

## Page # 1 *Sign In*

**앱 접속 페이지 (Relative Layout)**

최초 실행 시 보이는 화면

- 현재 화면 설명 Hoggy Warty Hogwarts (TextView)
- 회원 ID와 비밀번호 입력 뷰 (EditView)
- 로그인 뷰 (Button)
- 회원가입 뷰 (Button)
    
    Page # 2로 연결됨
    
- 비회원으로 상품 보기 뷰 (Button)
    
    Page # 3으로 연결됨
    

![최초실행](https://user-images.githubusercontent.com/84698896/198877499-5b21d23f-b3a7-4a02-9106-9655f6f1f31d.png)

최초실행시

![로그인](https://user-images.githubusercontent.com/84698896/198877497-0f22c404-7ffb-422e-9b11-a236e5af2f3c.png)

로그인 할 때 화면 캡처

## Page # 2 *Sign Up*

**회원가입 페이지 (Linear Layout)**

첫번째 페이지에서 회원가입 버튼 클릭 시 출력되는 화면

세번째 페이지에서 회원 정보 보기 위해 이 화면으로 넘어왔을 때 프리퍼런스에서 data를 get해오고, edit text view에 setText로 저장된 회원정보를 보여줌

회원정보 불러오는 함수는 SecondActivity.java 파일의
private void setStringArrayPref(String key, ArrayList<String> values) 함수와
public ArrayList<String> getStringArrayPref(String key) 함수로 정의되어 있음
    
![SHARE_PREF](https://user-images.githubusercontent.com/84698896/198878195-e68cdb03-3a5d-49c1-8747-4f8fb9126e79.png)

회원가입 이후 저장된 프리퍼런스 SHARE_PREF.xml 파일

- 현재 화면 설명 뷰 Hoggy Warty Hogwarts (TextView)
- 이름, 전화번호, 주소, ID, PW 입력 뷰 (EditText)
- 개인정보 수집 및 이용 동의 뷰 (Radio Button)
- 완료 뷰 (Button)
    
    Page # 1로 연결됨
    
- 비회원으로 상품 보기 뷰 (Button)
    
    Page #3으로 연결됨
    

![회원가입](https://user-images.githubusercontent.com/84698896/198877500-426f2790-413f-4d1a-9fb9-f57d1e5873bc.png)

회원 정보 입력할 때 화면 캡처

## Page # 3 *Books (Goods)*

**도서 8권을 보여주는 페이지 (5 × 1 Grid Layout)**

첫번째 페이지에서 로그인 또는 비회원으로 상품 보기 버튼 클릭 시 출력되는 화면

- row 0 column 0 현재 화면 설명 뷰 Harry Potter Series (TextView)
- row 1 column 0 상품 목록 첫번째 수평 뷰 그룹 (Linear Layout)
    - *Harry Potter and the Philosopher’s Stone* 뷰 그룹 (Linear Layout)
    - *Harry Potter and the Chamber of Secrets* 뷰 그룹 위와 동일함
    - *Harry Potter and the Prisoner of Azkaban* 뷰 그룹 위와 동일함
    - *Harry Potter and the Goblet of Fire* 뷰 그룹 위와 동일함
- row 2 column 0 상품 목록 두번째 수평 뷰 그룹 (Linear Layout)
    - *Harry Potter and the Order of the Phoenix* 뷰 그룹 (Linear Layout)
    - *Harry Potter and the Half-Blood Prince* 뷰 그룹 위와 동일함
    - *Harry Potter and the Deathly Hallows* 뷰 그룹 위와 동일함
    - *Harry Potter and the Cursed Child* 뷰 그룹 위와 동일함
- row 3 column 0 상품 목록 추가 뷰 (Button)
    
    기능 없음
    
- row 4 회원정보 뷰 (Button)
    
    비회원이면 Page #4로 연결됨
    
    회원이면 Page #2로 연결되어 회원 정보가 출력됨
    

![상품보기](https://user-images.githubusercontent.com/84698896/198877498-de186a6b-2384-4f11-a3e4-fb6fcdbffff7.png)

## Page # 4 Sign Up?

**회원가입 여부를 물어보는 페이지 (Linear Layout)**

세번째 페이지에서 회원정보 버튼 클릭 시 출력되는 화면

- 예 뷰 (Button)
    
    Page #2로 이동하여 회원가입 진행
    
- 아니오 뷰 (Button)
    
    Page #3으로 이동
    

![회원가입하시겠습니까](https://user-images.githubusercontent.com/84698896/198877501-43a196e5-576c-48ef-b4a9-33435d3bc271.png)

