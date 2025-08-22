
-- Day02 함수 : select, where 
/*
- 프로그램에서 반복적으로 사용되는 부분을 분리해서 서브 프로그램 

- 유형
단일행 함수 :  문자열, 날짜, 숫자, 기타변형 함수...
복수행(그룹) 함수 : min, max, sum, count, avg ..... 


*/

SELECT	*
FROM		employee ; 


SELECT	EMP_NAME,
			LENGTH(EMP_NAME),
			CHAR_LENGTH(EMP_NAME)
FROM		employee ;

SELECT	CHAR(65) ; 

SELECT	EMP_NAME,
			CONCAT(EMP_NAME, '님'),
			LENGTH(EMP_NAME),
			CHAR_LENGTH(EMP_NAME)
FROM		employee ;

-- LOWER(), UPPER()

SELECT 	LOWER('HELLO'), UPPER('lgcns') ;


-- LPAD, RPAD : 자리수를 고정하여 빈 공간을 원하는 문자로 채우는 함수
-- 정렬의 의미로도 해석 

SELECT	EMAIL AS `원본데이터`
			,LENGTH(EMAIL) `원본길이`
			,LPAD(EMAIL, 30)
			,RPAD(EMAIL, 30, '*')
			,LENGTH(LPAD(EMAIL, 30))
FROM		employee ; 

-- ELT()    : 인덱스를 이용해서 특정위치의 문자를 찾는 함수 
-- INSTR()  : 문자열을 이용해서 부분문자열의 인덱스를 반환하는 함수  (첫 문자) 


SELECT	ELT(2 , '1','2','3'), INSTR('임정섭', '임');

SELECT	EMAIL 
FROM		employee ; 

-- . 앞의 문자 'c' 의 인덱스 번지를 검색하고 싶다면?

SELECT EMAIL,INSTR(EMAIL,'.')-1,INSTR(EMAIL,'c')
FROM employee

-- LEFT() , RIGHT() 
SELECT	LEFT('ABCDE' , 3), RIGHT('ABCDE', 3) ;
 

-- SUBSTRING(st,a,b) st에서 a시작번지에서 b개의 문자
-- 부분문자열을 반환하하는 함수 
SELECT	SUBSTR('ABCDE' , 1, 1); 

SELECT	EMAIL,
			SUBSTR(EMAIL, INSTR(EMAIL, '.') - 1, 1),
			INSTR(EMAIL, 'c.') 
FROM		employee ; 

-- TRIM(), LTRIM(), RTRIM() : 제거(패턴을 제거하는 것은 아니다) , 기본 공백 
  
SELECT 	LTRIM('    LGCNS'), RTRIM('LGCNS    ') , TRIM('   LGCNS    '); 
 
SELECT	TRIM(BOTH     '123' FROM '123TECH123'),
			TRIM(LEADING  '123' FROM '123TECH123'),
			TRIM(TRAILING '123' FROM '123TECH123') ; 
// 이해안됨.
	
-- 문자열  반복 : REPEAT() ;
SELECT	REPEAT('LGCNS' , 3) ;

-- 문자열 치환 : REPLACE();
SELECT	REPLACE('오늘은 코스모스 졸업식 즐겨보자', '즐겨보자', '놀아보자');

-- 중요
-- SUBSTRING(문자열, 시작위치, 길이) OR (문자열 FROM 시작위치 FOR 길이) 
-- SUBSTRING_INDEX(문자열, 구분자, 횟수)
 
SELECT	SUBSTRING('THIS IS INSPIRE CAMP' , 9, 7),
			SUBSTRING('THIS IS INSPIRE CAMP' FROM 9 FOR 7) ;
			
SELECT	SUBSTRING_INDEX('WWW.LGCNS.COM', '.', 1) ,
			SUBSTRING_INDEX('WWW.LGCNS.COM', '.', 2) , 
			SUBSTRING_INDEX('WWW.LGCNS.COM', '.', 3) ,  
			SUBSTRING_INDEX('WWW.LGCNS.COM', '.', -1),
			SUBSTRING_INDEX('WWW.LGCNS.COM', '.', -2),
			SUBSTRING_INDEX('WWW.LGCNS.COM', '.', -3);

/*
employee

QUIZ)
1. 사원 이메일 중 아디만 추출
2. 입사년도만 추출
3. 주민번호 앞 6자리만 추출
4. 입사일 출력 포맷을 XXXX년 XX월 XX일 형식으로 추출 

*/ 
SELECT * FROM employee;
-- 1
SELECT EMAIL,SUBSTRING(EMAIL,1,INSTR(EMAIL,'@')-1) AS '사원아이디' FROM employee;
-- 2
SELECT HIRE_DATE,SUBSTRING_INDEX(HIRE_DATE,'-',1) FROM employee;
-- 3
SELECT EMP_NO,SUBSTRING(EMP_NO,1,INSTR(EMP_NO,'-')-1) FROM employee;
-- 4
SELECT	CONCAT(	SUBSTRING(hire_date, 1, 4), '년 ',
						SUBSTRING(hire_date, 6, 2), '월 ',
						SUBSTRING(hire_date, 9, 2), '일' ) 
FROM		employee ; 



SELECT * FROM employee;
SELECT EMAIL, SUBSTRING_INDEX(EMAIL,'@',1) FROM employee;
SELECT SUBSTRING_INDEX(HIRE_DATE,'-',1) FROM employee;


SELECT 	SUBSTRING_INDEX(EMAIL, '@', 1)
FROM 		employee ;

SELECT 	SUBSTRING(EMAIL, 1, INSTR(EMAIL, '@')-1)
FROM 		employee ;

SELECT 	CONCAT(SUBSTRING_INDEX(HIRE_DATE, '-', 1), '년') AS `입사년도`
FROM 		employee;

SELECT 	SUBSTRING(HIRE_DATE, 1, 4)  AS `입사년도`
FROM 		employee ;

SELECT 	SUBSTRING(EMP_NO, 1, 6)
FROM 		employee;

SELECT	CONCAT(	SUBSTRING(hire_date, 1, 4), '년 ',
						SUBSTRING(hire_date, 6, 2), '월 ',
						SUBSTRING(hire_date, 9, 2), '일' ) 
FROM		employee ; 


SELECT	*
FROM		usertbl ; 

SELECT	*
FROM		buytbl ; 
 

-- 평균 구매 개수를 확인하고 싶다면?
SELECT	AVG(AMOUNT)
FROM		buytbl ; 


-- int형으로 casting
SELECT	CAST(AVG(AMOUNT) AS INT) AS `평균구매개수`
FROM		buytbl ; 

-- ERROR 
-- SELECT	INT(AVG(AMOUNT)) AS `평균구매개수`
-- FROM		buytbl ; 


SELECT	CAST(AVG(AMOUNT) AS SIGNED INTEGER) AS `평균구매개수`
FROM		buytbl ; 

-- 둘다 같은 값 200이나온다.
SELECT	'100' + '100' , CAST('100' AS INT) + CAST('100' AS INT) ;


-- 구매번호, 총 금액( PRICE * AMOUNT = ), 구매액 검색한다면?
-- concat에서 * 가 문자기에 묵시적으로 형변환?
SELECT	NUM AS `구매번호`,
			CONCAT(
					CAST(PRICE AS VARCHAR(10)),
					' * ',
					CAST(AMOUNT AS VARCHAR(10))
			) AS `총 금액`,
			PRICE * AMOUNT AS `구매액`
FROM		buytbl ; 


SELECT	LEFT(EMP_NO, 6),
			RIGHT(EMP_NO, 7),
			LEFT(EMP_NO, 6) + RIGHT(EMP_NO, 7),
			CAST(LEFT(EMP_NO, 6) AS INT) + CAST(RIGHT(EMP_NO, 7) AS INT) 	
FROM		employee ; 


-- 숫자함수
SELECT	ABS(-100),
			CEILING(4.7),
			CEILING(4.1),
			FLOOR(4.7),
			FLOOR(4.1),
			ROUND(4.5),
			ROUND(4.4),
			TRUNCATE(123.1234567, 2),
			TRUNCATE(123.1234567, -2) ; 
			-- 소수점 자리 버림, 음수가 들어가면 정수자리가 버려짐
			
-- 날짜함수 
SELECT	NOW(),
			SYSDATE(),
			CURDATE(),
			CURTIME() ; 
			
			 
-- 날짜도 연산이 가능할까?
-- ADDDATE(DATE , INTERVAL EXPR TYPE) , DATA_ADD() ;
-- SUBDATE()
-- TYPE : YEAR, MONTH, DAY
-- ADDTIME() , SUBTIME() 
 
SELECT	NOW() + 1 ;
	
SELECT	CURDATE(),
			ADDDATE( CURDATE() , INTERVAL 1 MONTH),
			SUBDATE( CURDATE() , INTERVAL 1 MONTH),
			SYSDATE(),
			ADDTIME( SYSDATE() , '1:1:1'),
			SUBTIME( SYSDATE() , '2:0:0');
			 
			
SELECT	*
FROM		employee ; 
			
-- 오늘 날짜를 기준으로 근속년수가 25년 이상인 사원의 정보를 검색한다면?
-- DATEDIFF() 일수 반환, 앞에 큰숫자가 있어야 양수 반환

SELECT	ROUND( DATEDIFF( CURDATE() ,  '2000-01-01') / 365 ) ;

SELECT	ROUND(  DATEDIFF('2000-01-01', CURDATE()) / 365) ;

SELECT	EMP_NAME,
			HIRE_DATE,
			ROUND( DATEDIFF( CURDATE() , HIRE_DATE) / 365 ) AS `근속년수`
FROM		employee 
WHERE 	DATEDIFF( CURDATE() , HIRE_DATE) >= (25*365); 	

-- DATE_SUB()
SELECT 	*
FROM 		employee
WHERE 	HIRE_DATE <= DATE_SUB(CURDATE(), INTERVAL 25 YEAR);			
			

-- YEAR(), MONTH(), DAY(), HOUR(), MINUTE(), SECOND() 


SELECT	CAST( YEAR(HIRE_DATE) AS CHAR),
			MONTH(HIRE_DATE),
			DAY(HIRE_DATE)  
FROM		employee ;

			
-- 기타 변형함수 
-- 제어 흐름 함수(IF, IFNULL, NULLIF, CASE ~ WHEN ~ END) 
			
SELECT	IF(100 > 200 , '참', '거짓') ; 
			
SELECT	CASE 1
				WHEN 1  THEN '1'
				WHEN 10 THEN '10'
				ELSE '내가 원하는 값이 아님'
			END AS  `구분` ; 
						
-- 부서번호가 50번인 사원의 이름, 주민번호, 성별  검색?
SELECT	EMP_NAME,
			EMP_NO,
			CASE SUBSTRING(EMP_NO, 8,1)
				WHEN '1' THEN 'MALE'
				WHEN '2' THEN 'FEMALE'
			END AS GENDER 	
FROM		employee
WHERE		DEPT_ID = '50' ; 

SELECT	EMP_NAME,
			EMP_NO,
			CASE 
				WHEN SUBSTRING(EMP_NO, 8,1) IN ('1','3') THEN 'MALE'
				WHEN SUBSTRING(EMP_NO, 8,1) IN ('2','4') THEN 'FEMALE'
			END AS GENDER 	
FROM		employee
WHERE		DEPT_ID = '50' ; 


-- 사원테이블에서 남자사원의 이름, 주민번호, 성별을 검색한다면?

SELECT 	EMP_NAME,
			EMP_NO,
			'MALE' AS GENDER
FROM 		employee
WHERE 	SUBSTRING(EMP_NO, 8, 1) IN ('1','3');

-- 사원테이블에서 직급이 J4인 사원의 사번, 이름, 사수번호 검색?
-- 추가) 사수번호가 없는 사원의 MRG_ID 컬럼에 '관리자' 넣어주고 싶다면?
-- HINT) IF 

SELECT * FROM employee;
SELECT EMP_ID,EMP_NAME,MGR_ID,IF(MGR_ID,MGR_ID,'관리자') as MGR_ID FROM employee WHERE JOB_ID='J4';

/*
NULL
- 값이 없음
EMPTY STRING('')
- 길이가 0 문자열
*/
SELECT 	EMP_ID,
			EMP_NAME,
			-- MGR_ID
			IF(MGR_ID = '' ,'관리자', MGR_ID) AS 사수번호
			-- IFNULL(MGR_ID,'관리자') AS 사수번호
FROM 		employee 
WHERE 	JOB_ID = 'J4' ; 


SELECT 	EMP_ID,
			EMP_NAME,
			CASE 
				WHEN MGR_ID = '' THEN '관리자'
				ELSE MGR_ID
			END AS `구분`
FROM 		employee 
WHERE 	JOB_ID = 'J4' ; 

-- 사원 급여등급을 나눠보고 싶다
-- 3000000 이하면 초급, 4000000 이하면 중급, 초과면 고급
-- 사원번호, 이름, 급여, 급여등급을 검색한다면?

SELECT
			EMP_ID 	AS `사원번호`,
			EMP_NAME AS `이름`,
			SALARY 	AS `급여`,
			CASE
				WHEN SALARY <= 3000000 THEN '초급'
				WHEN SALARY <= 4000000 THEN '중급'
				ELSE '고급'
			END AS `급여등급`
FROM employee
ORDER BY `급여` ASC ; 
-- index 나 '급여'같은 별칭도 사용가능 order by A  A부분에
 
-- 복수행(그룹, 집계)함수 : 여러 행의 결과를 입력으로 하나의 결과를 반환하는 함수

SELECT	COUNT(*), 
			COUNT(BONUS_PCT),
			COUNT(IFNULL(BONUS_PCT, 0)),
			MIN(SALARY),
			MAX(SALARY),
			SUM(SALARY),
			AVG(SALARY)
FROM		employee ;


-- q6) HINT WEEKDAY() : 날짜의 요일을 정수로 변환(0 - 월) , 
-- DAYOFWEEK() : 요일을 숫자로 변환 (1 : 일요일)

SELECT	WEEKDAY(CURDATE()),
			DAYOFWEEK(CURDATE()) ;