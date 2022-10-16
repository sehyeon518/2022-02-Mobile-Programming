# Readme

# Hoggy Warty Hogwarts

---

국민대학교 소프트웨어학부 20213043 이세현

모바일프로그래밍 02분반 개인 과제

## Introduction

해리포터 도서 8권 판매 android application

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

---

#5d5d5d (gray)

#1a472a (green)

#aaaaaa (gray)

#2a623d (green)

#000000 (black)

## Page # 1 *Sign In*

**앱 접속 페이지 (Relative Layout)**

---

최초 실행 시 보이는 화면

- 현재 화면 설명 Hoggy Warty Hogwarts (TextView)
- 회원 ID와 비밀번호 입력 뷰 (EditView)
- 로그인 뷰 (Button)
- 회원가입 뷰 (Button)
    
    Page # 2로 연결됨
    
- 비회원으로 상품 보기 뷰 (Button)
    
    Page # 3으로 연결됨
    

## Page # 2 *Sign Up*

**회원가입 페이지 (Linear Layout)**

---

첫번째 페이지에서 회원가입 버튼 클릭 시 출력되는 화면

- 현재 화면 설명 뷰 Hoggy Warty Hogwarts (TextView)
- 이름, 전화번호, 주소, ID, PW 입력 뷰 (EditText)
- 개인정보 수집 및 이용 동의 뷰 (Radio Button)
- 회원 정보 입력 완료 뷰 (Button)
    
    Page # 1로 연결됨
    

## Page # 3 *Books (Goods)*

**도서 8권을 보여주는 화면 (5 × 1 Grid Layout)**

---

첫번째 페이지에서 로그인 또는 비회원으로 상품 보기 버튼 클릭 시 출력되는 화면

- row 0 column 0 현재 화면 설명 뷰 Harry Potter Series (TextView)
- row 1 column 0 상품 목록 첫번째 수평 뷰 그룹 (Linear Layout)
    
    *Harry Potter and the Philosopher’s Stone* 뷰 그룹 (Linear Layout)
    
    Harry Potter and the Philosopher’s Stone 도서 이미지 뷰 (ImageView)
    
    책 제목 뷰 (TextView)
    
    *Harry Potter and the Chamber of Secrets* 뷰 그룹 위와 동일함
    
    *Harry Potter and the Prisoner of Azkaban* 뷰 그룹 위와 동일함
    
    *Harry Potter and the Goblet of Fire* 뷰 그룹 위와 동일함
    
- row 2 column 0 상품 목록 두번째 수평 뷰 그룹 (Linear Layout)
    
    *Harry Potter and the Order of the Phoenix* 뷰 그룹 (Linear Layout)
    
    Harry Potter and the Order of the Phoenix 도서 이미지 뷰 (ImageView)
    
    책 제목 뷰 (TextView)
    
    *Harry Potter and the Half-Blood Prince* 뷰 그룹 위와 동일함
    
    *Harry Potter and the Deathly Hallows* 뷰 그룹 위와 동일함
    
    *Harry Potter and the Cursed Child* 뷰 그룹 위와 동일함
    
- row 3 column 0
    
    상품 목록 추가 뷰 (Button) → 변동 가능
    
- row 4 column 0
    
    회원정보 보기 뷰 (Button)
    
    비회원일 경우 Page # 3으로 연결됨
    
    회원일 경우 회원정보를 보여줌