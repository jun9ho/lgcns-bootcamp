SHOW DATABASES;

USE inspire;


/*

Select Query
DDL : create, drop, alter
DML : insert, update, delete
DCL : commit, rollback

select: 데이터를 검색할 때 사용하는 문법

select 	column_name, *, as , distinct
from		table_name
[where]		   행의 제한
[group by]		데이터를 그룹으로 묶을 떄
[having]			그룹에 대한 조건
[order by]		정렬(내림차순 DESC, 오름차순 ASC)
*/

SELECT *
FROM employee;

SELECT *
FROM department;

SELECT *
FROM employee
WHERE DEPT_ID = '90';


SELECT EMP_NAME, SALARY, ((SALARY + (SALARY * IFNULL(BONUS_PCT,0)))*12) AS `연 봉`
FROM employee;


-- Null 처리를 위한 함수: IFNULL(EXP1,EXP2), NULLIF(EXP1,EXP2)

SELECT IFNULL(NULL,'넌 누구냐?'), NULLIF(100,'NOT NULL')


SELECT * FROM employee;
SELECT DISTINCT DEPT_ID, JOB_ID FROM employee;

-- where
-- 연산자 (비교(like,not like), 산술, 논리(and,or not))

-- 부서 번호가 90번이거나 급여가 4000000 이상의 사원의 정보를 검색한다면

SELECT * FROM employee WHERE SALARY>=4000000 OR DEPT_ID='90';

-- CONCAT(): 연결연산자

SELECT CONCAT('임정섭','강사님은','과연','강사료가','얼마일까요?');

SELECT CONCAT(EMP_NAME, '님의 급여는', SALARY,'원 입니다') AS '급여정보(원)'
FROM employee


-- 급여정보가 3500000 ~ 5500000 

SELECT * FROM employee WHERE SALARY>= 3500000 AND SALARY<=5500000 ;
SELECT * FROM employee WHERE SALARY BETWEEN 3500000 AND 5500000 ;



-- LIKE, NOT LIKE : 패턴검색시 사용하는 연산자 (%,_

-- %: 하나이상의 문자와 매칭
__ _: 하나의 문자를 매칭


-- 김씨 성을 가진 사원만 검색한다면
SELECT * FROM employee WHERE EMP_NAME LIKE '김%';

SELECT * FROM employee WHERE EMP_NAME LIKE '김__';

SELECT * FROM employee WHERE EMP_NAME NOT LIKE '김%';


-- IS NULL, IS NOT NULL : 널값은 = 비교할수 없다
-- 부서 배치를 받지 않는 사원 정보를 검색한다면?

SELECT * FROM employee WHERE DEPT_ID IS NULL;

SELECT * FROM employee WHERE ISNULL(DEPT_ID);

-- 부서번호가 60번이거나 90번인 사원의 정보를 검색한다면?
-- IN()
SELECT * FROM employee WHERE DEPT_ID = '60' OR DEPT_ID ='90';

SELECT * FROM employee WHERE DEPT_ID IN(60,90);


SELECT EMP_ID  AS '아이디',EMP_NAME  AS '아이디' FROM employee;

