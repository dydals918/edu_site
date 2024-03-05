# Spring Boot Project

한국IT교육원 팀 프로젝트


## 프로젝트 소개

이튜(주) 의 요구사항을 받아 평생 학습 플랫폼을 제작

## 팀 구성

front-end 1
- 프로젝트 HTML and CSS

back-end 1
- 프로젝트 구성, 설계
- 테스트 코드 설계
- main git 담당
- front thymeleaf 적용

**back-end 2 (Me)**
- Account, Category, Company, Exam, Rating, Survey 모듈 기능 구현
- front thymeleaf 적용
- Spring Security 설정 및 적용
                      
back-end 3
- Lecture 모듈 테스트 코드 작성 및 기능 구현


## 개발 환경
- 'Java 17'
- 'Spring Boot 3.2.1'
- **IDE** : Intellli J
- **Database** : MySQL
- **ORM** : JPA
- **Dependency** : Spring JDBC, Spring JPA, Spring web, Spring security, thymeleaf, p6spy, lombok

## 모듈 기능

#### Security
- Security 설정
- 로그인 성공, 실패 핸들러
- Security 권한

#### Account
- 회원 등록, 수정, 삭제, 아이디중복체크
- 회원검색, 가입날 기준 회원 검색, 회원 카운트
- 시큐리티 로그인

#### Company
- 회사 등록, 수정, 삭제, 검색, 카운트
- 강사 등록
- 회사 승인, 거부
  
#### Lecture
- 강의 등록, 수정, 삭제
- 강의 동영상 등록, 삭제
  
#### Rating
- 강의 평가 등록

#### Exam
- 강의 별 시험 등록, 수정, 삭제
- 시험 답안 등록, 삭제

#### Survey
- 강의 별 설문 등록, 수정
- 시험 답안 등록
