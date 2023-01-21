-- TODO: login 샘플 데이터
INSERT INTO TB_ROLE
VALUES (SQ_ROLE.NEXTVAL, 'ROLE_USER', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);
INSERT INTO TB_ROLE
VALUES (SQ_ROLE.NEXTVAL, 'ROLE_ADMIN', 'N', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL, NULL);

-- admin user 1명 최초 생성
-- id : admin
-- password : 123123
-- email : admin@admin.com
-- roles : ROLE_ADMIN

-- $2a$10$QrX8ZL/Z.VCfw..fuTnN9O2rOngh.JzwXfX.Qjy3CsZ53ZO6oW.o6

INSERT INTO TB_USER
VALUES (SQ_USER.NEXTVAL,
        'admin',
        '$2a$10$QrX8ZL/Z.VCfw..fuTnN9O2rOngh.JzwXfX.Qjy3CsZ53ZO6oW.o6',
        '관리자',
        'admin@admin.com',
         '',
         '',
         '',
         '',
         'N',
         TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'),
         NULL,
         NULL
         );


-- TODO: (첫번째 : 유저id(시퀀스), 두번째 : 1(일반유저) 2(관리자) )
INSERT INTO TB_USER_ROLE
VALUES (1, 2);

COMMIT;