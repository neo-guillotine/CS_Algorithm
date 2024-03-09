-- 코드를 입력하세요
SELECT HISTORY_ID,CAR_ID,DATE_FORMAT(START_DATE,'%Y-%m-%d') as START_DATE,DATE_FORMAT(END_DATE,'%Y-%m-%d') AS END_DATE,
       CASE WHEN DATEDIFF(END_DATE,START_DATE)>=29 THEN '장기 대여'
            ELSE '단기 대여'
           END
        AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE month(START_DATE)=9 and year(start_date)=2022
ORDER BY HISTORY_ID DESC;

/*
1. DATEDIFF(A,B): A에서 B를 뺀 값. 문제에서는 대여 기간이 30일 이상이면 장기대여라고 설정하였으나 DATEDIFF로 하면 29로 체크 해야 함.
2. CASE WHEN A THEN B ELSE C END: A인 경우 B, 아닌경우 C
*/