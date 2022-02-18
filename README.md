# 💰 쌍용은행 SYBANK

<img width="100%" alt="1  메인화면" src="https://user-images.githubusercontent.com/90780701/153699299-12bd358d-8228-4c79-b9f2-a9966d543646.png">

>  **쌍용은행**은 **Java Console**로 구현한 은행 업무 시스템입니다. <br />
>  **15일** 동안( 21.10.21 - 21.11.05 ) **6명**의 팀원이 하루 약 **4시간씩** 개발에 참여했습니다. <br />

 <br />
 <br />
 
## 📌 Table Of Contents
* [📖 Introduction](#-introduction)
* [📝 Main Function](#-main-function)
* [🙋 My Role](#-my-role)
* [💡 Review](#-review)

 <br />
 <br />

## 📖 Introduction
<table>
    <tr>
        <th>프로젝트 명 </th>
        <th>쌍용은행</th>
        <th>개발기간</th>
        <th>2021.10.21. ~ 2021.11.05.</th>
    </tr>
    <tr>
        <th>프로젝트 성격</th>
        <th>Java Console</th>
        <th>개발인원</th>
        <th>팀 / 6명<br>
            강규준 | 김기현 | 김혜림 | 송성현 | 윤한빈 | 이혜인
        </th>
    </tr>
    <tr>
        <th>프로젝트 개요</th>
        <th>은행 업무 시스템</th>
        <th>개발환경&nbsp;</th>
        <th>Windows10 / Mac OS</th>
    </tr>
    <tr>
        <th colspan="5">사용 도구</th>
    </tr>
    <tr>
        <th>개발언어</th>
        <th colspan="3">Java(JDK 11)</th>
    </tr>
    <tr>
        <th>개발도구</th>
        <th colspan="3">Eclipse IDE</th>
    </tr>
</table>

<br />
<br />

## 📝 Main Function
### 1. 비회원
* 회원가입 및 로그인
* ID/PW 찾기
### 2. 회원
* 계좌 이체, 조회, 개설, 해지
* 적금, 대출, 펀드 가입 및 해지
* 나의 가입상품 조회
* 월급, 주휴수당, 퇴직금, 예상신용등급 계산
### 3. 관리자
* 은행 상품 추가 및 제거
* 은행 상품 이자율 수정
* 회원 정보 조회 및 수정

<br />
<br />

## 🙋 My Role

### 1. 계좌이체
<img width="500" alt="3  이체" src="https://user-images.githubusercontent.com/90780701/154630439-5b1f0690-2bc1-44a6-bdbb-04a32cbb864e.png">
<img width="500" alt="4  이체결과" src="https://user-images.githubusercontent.com/90780701/154630455-89545680-8645-4218-91f1-f23f393c9879.png">

#### 1.1 계좌이체
* 원하는 계좌에 이체를 할 수 있습니다.
* 원하는 계좌 번호를 입력하면 계좌 소유주를 알려주고 맞는지 확인합니다.
* 원하는 이체 금액을 선택하고 이체할 계좌를 선택합니다.
* 선택한 계좌의 잔액이 이체할 금액보다 적으면 이체가 불가합니다.
* 이체 후 잔액을 알려준 뒤 이체여부를 한 번 더 묻습니다.
* 이체를 성공하면 완료 메시지를 출력합니다.

<br />

### 2. 계좌조회
<img width="512" alt="2  계좌 확인" src="https://user-images.githubusercontent.com/90780701/154633029-495e8286-c4dc-4819-9001-c402a0b34522.png">
<img width="508" alt="5  계좌 조회 목록 2" src="https://user-images.githubusercontent.com/90780701/154632717-0a2e5584-9a78-4b77-9b11-a6451c08f8df.png">

#### 2.1 계좌조회
* 고객이 소유한 계좌를 조회할 수 있습니다.
* 고객이 가지고 있는 계좌 리스트를 보여줍니다.
* 선택한 계좌를 페이지 형식으로 조회할 수 있습니다.

<br />

### 3. 계좌개설

<img width="508" alt="2  본인인증" src="https://user-images.githubusercontent.com/90780701/154633814-adfc74b4-94a9-470d-84d5-8791aeb5103f.png">
<img width="509" alt="3  개설 목적확인" src="https://user-images.githubusercontent.com/90780701/154633834-34f6205a-e301-4c9e-bf3d-f66a028fc3b7.png">
#### 3.1 계좌개설
* 새로운 계좌를 개설할 수 있습니다.
* 본인인증을 완료하면 개설 목적을 선택합니다.
* 계좌 개설이 완료되면 개설된 계좌 번호를 알려줍니다.

![7  잘못된 비밀번호 입력](https://user-images.githubusercontent.com/90780701/154634658-5a4d81f9-45d8-4704-9a7b-1d277258a95b.png)
![이미지 366](https://user-images.githubusercontent.com/90780701/154635253-92833597-505a-41de-bb98-5ca2a935956e.png)
#### 3.2 본인인증 실패
* 비밀번호와 주민번호를 5회 이상 틀리면 본인 인증에 실패하고 계좌를 개설할 수 없습니다.
* 주민번호 형식이 다르면 틀린 횟수를 증가시키지 않고 형식이 다르다고 알려줍니다.

<br />
<br />

## 💡 Review
### 1. 후기



