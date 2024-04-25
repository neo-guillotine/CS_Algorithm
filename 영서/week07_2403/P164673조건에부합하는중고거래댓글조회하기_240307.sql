-- 코드를 입력하세요
SELECT a.title, a.board_ID,B.REPLY_ID, B.WRITER_ID, B.CONTENTS, DATE_FORMAT(B.CREATED_DATE,'%Y-%m-%d') as created_date
FROM USED_GOODS_BOARD  AS A
         INNER JOIN USED_GOODS_REPLY  AS B ON a.board_id=b.board_id
WHERE A.CREATED_DATE BETWEEN '2022-10-01 00:00:00' AND '2022-10-31 00:00:00'
ORDER BY B.CREATED_DATE ASC, A.TITLE ASC;

-- 날짜 형식 설정 date_format(column, '%Y-%m-%d')