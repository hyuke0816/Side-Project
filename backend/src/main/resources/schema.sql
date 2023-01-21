-- TODO: Table , 시퀀스 등 구조 정의
-- DROP SEQUENCE 시퀀스명;
-- CREATE SEQUENCE 시퀀스명 START WITH 1 INCREMENT BY 1;
-- DROP TABLE 테이블명 CASCADE CONSTRAINTS;

-- TODO: login 관련 테이블/시퀀스
DROP SEQUENCE SQ_USER;
CREATE SEQUENCE SQ_USER START WITH 1 INCREMENT BY 1
                        MINVALUE 1   MAXVALUE 99999999;

DROP SEQUENCE SQ_ROLE;
CREATE SEQUENCE SQ_ROLE START WITH 1 INCREMENT BY 1
                        MINVALUE 1   MAXVALUE 99999999;

DROP SEQUENCE SQ_GOODS;
CREATE SEQUENCE SQ_GOODS START WITH 1 INCREMENT BY 1;

DROP TABLE TB_USER CASCADE CONSTRAINTS;
DROP TABLE TB_ROLE CASCADE CONSTRAINTS;
DROP TABLE TB_USER_ROLE CASCADE CONSTRAINTS;
DROP TABLE TB_GOODS CASCADE CONSTRAINTS;

-- TODO: 유저 테이블
CREATE TABLE TB_USER
(
    ID          NUMBER NOT NULL PRIMARY KEY,
    USER_ID     VARCHAR2(1000), -- 아이디
    PASSWORD    VARCHAR2(1000), -- 비밀번호
    NAME        VARCHAR2(1000), -- 사용자 이름
    EMAIL       VARCHAR2(1000), -- 이메일
    BIRTH       VARCHAR2(1000), -- 생년월일
    PHONE       VARCHAR2(1000), -- 휴대폰번호
    ADDRESS     VARCHAR2(1000), -- 주소
    GENDER      VARCHAR2(1000), -- 성별
    DELETE_YN   VARCHAR2(1) DEFAULT 'N', -- 삭제여부
    INSERT_TIME VARCHAR2(255), -- 생성시간
    UPDATE_TIME VARCHAR2(255), -- 수정시간
    DELETE_TIME VARCHAR2(255) -- 삭제시간
);


-- TODO: 역할 테이블 : ROLE_USER, ROLE_ADMIN
CREATE TABLE TB_ROLE
(
    RID         NUMBER NOT NULL PRIMARY KEY,
    ROLE_NAME   VARCHAR2(1000) UNIQUE,
    DELETE_YN   VARCHAR2(1) DEFAULT 'N',
    INSERT_TIME VARCHAR2(255),
    UPDATE_TIME VARCHAR2(255),
    DELETE_TIME VARCHAR2(255)
);

-- TODO: 매핑테이블 : TB_USER vs TB_ROLE 연결시켜주는 테이블 ( Many To Many 관계에서 사용 )
CREATE TABLE TB_USER_ROLE
(
    USER_ID NUMBER NOT NULL,
    ROLE_ID NUMBER NOT NULL,
    PRIMARY KEY (USER_ID, ROLE_ID) -- 복합키 ( 속성 2이상을 조합해서 기본키로 만드는것 )
);

-- TODO: 상품 테이블
CREATE TABLE TB_GOODS
(
    GID         NUMBER NOT NULL PRIMARY KEY,
    NAME        VARCHAR2(255), -- 상풉명
    PRICE       NUMBER,        -- 가격
    EXPLANATION VARCHAR2(255), -- 설명
    MAIN_PHOTO  VARCHAR2(255), -- 메인사진
    VIEWS       NUMBER,        -- 조회수
    PURCHASE    NUMBER,        -- 구매수
    REVIEWS     NUMBER,        -- 리뷰수
    PUBLISH_DAY VARCHAR2(255), -- 출시일
    PUBLISH_YN  VARCHAR2(255), -- 출시여부
    DELETE_YN   VARCHAR2(1) DEFAULT 'N',
    INSERT_TIME VARCHAR2(255),
    UPDATE_TIME VARCHAR2(255),
    DELETE_TIME VARCHAR2(255)
);



COMMIT;








