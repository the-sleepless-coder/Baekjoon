-- 코드를 입력하세요

SELECT COUNT(*) as count
FROM USER_INFO
WHERE AGE >=20 && AGE <= 29 && YEAR(JOINED)=2021
;