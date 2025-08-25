/*
[GROUP BY]	데이터를 그룹으로 묶을 때(표현식, 컬럼 명, 별칭 x)
[HAVING]		그룹에 대한 조건
*/

-- GROUP BY : 하위 데이터의 그룹
-- 특정 컬럼에 대한 동일한 값을 가지는 행들을 하나의 행으로 처리
-- 통계 작업


SELECT *
FROM buytbl;

-- 사용자 별 구매 총액을 확인하고 싶다면?

SELECT USERID, SUM(PRICE*AMOUNT)
FROM buytbl
GROUP BY USERID
ORDER BY 2 DESC;

-- 사용자별 평균 구매 개수를 확인하고 싶다면?
-- select절에 집계함수에 쓰이면 일반 컬럼은 select절에 정의될수 없음
-- 하지만 그룹바이에 연계된 컬럼은 select절에 쓸 수 있다.
SELECT USERID, AVG(AMOUNT)
FROM buytbl
GROUP BY USERID
ORDER BY 2 DESC;



SELECT *
FROM employee;

-- 부서펼 평군급여를 조회하고 싶다면?

SELECT DEPT_ID,AVG(SALARY)
FROM employee
GROUP BY DEPT_ID
ORDER BY 1;

-- 성별에 따른 평균 급여를 조회하고 싶다면?

SELECT AVG(SALARY)
FROM employee
GROUP BY SUBSTR(EMP_NO,8,1) IN (1,3);


-- 부서별 급여 총액이 9000000 이상인 부서만 필터링 한다면?
SELECT DEPT_ID,SUM(SALARY)
FROM employee
GROUP BY DEPT_ID
HAVING SUM(SALARY)>=9000000
ORDER BY 1;


-- buytbl에서 사용자별 총 구매엑이 100이상인 사용자들만 필터링 한다면?

SELECT USERID, SUM(PRICE*AMOUNT) AS '총구매액'
FROM buytbl
GROUP BY USERID
HAVING SUM(PRICE*AMOUNT) >=100;

-- GROUP BY  확장기능 : 계층적인 집계 결과 WITH ROLLUP

SELECT *
FROM buytbl;

--- 구매한 목록 중 그룹이름별 구매비용을 검색한다면?
SELECT GROUPNAME,NUM,SUM(PRICE*AMOUNT) AS '구매 비용'
FROM buytbl
GROUP BY GROUPNAME,NUM WITH ROLLUP;

-- JOIN: n개 이상의 테이블을 서로 묶어서 하나의 결과 집합을 만들어 내는 것.
-- 관계형 데이터베이스의 가장 큰 특징
-- 테이블 관계(1:N, 1:1)

/*
ANSI 표준 구문

SELECT
FROM TABLE01 ALIAS
[INNER} JOIN TABLEO2 ALIAS ON( 조건식 )
[INNER} JOIN TABLEO2 ALIAS USING( 컬럼명 )

ON, USING 두가지만 쓰자.
*/

SELECT *
FROM department D
JOIN employee E USING(DEPT_ID);

SELECT *
FROM department D
JOIN employee E ON(D.DEPT_ID = E.DEPT_ID);

SELECT E.EMP_NAME, D.DEPT_NAME, L.LOC_DESCRIBE
FROM department D
JOIN employee E USING(DEPT_ID)
JOIN location L ON(L.LOCATION_ID = D.LOC_ID);


--사용자가 JYP인 유저의 이름과 구매 상품을 조회한다면?

SELECT * FROM usertbl;
SELECT * FROM buytbl;

SELECT *
FROM usertbl U
JOIN buytbl B ON(U.userID = B.userID)


SELECT U.name, B.prodName
FROM usertbl U
JOIN buytbl B ON(U.userID = B.userID)
WHERE U.userID = 'JYP';

--사용자가 아이디, 이름, 구매상품, 연락처(MOBILE1+MOBILE2) 조회한다면? USERTBL-BUYTBL

SELECT U.userID, U.name, B.prodName, CONCAT(U.mobile1,'-',U.mobile2) AS PN
FROM usertbl U
JOIN buytbl B ON(U.userID = B.userID)

-- 위 요구 사항에서 구매이력이 있는 회원만 조회한다면?

SELECT *
FROM usertbl U
WHERE EXISTS (SELECT * FROM buytbl B WHERE U.userID = B.userID)

-- 업무적인 연관성이 없는 테이블도 조인이 가능하다(ON 구문으로) non-eqaul join
-- 이름,급여, 급여등급 검색한다면?
SELECT E.EMP_NAME, E.SALARY, S.SLEVEL
FROM employee E
JOIN sal_grade S ON(E.SALARY BETWEEN S.LOWEST AND S.HIGHEST)
ORDER BY 3;

SELECT *
FROM sal_grade;

-- OUTER JOIN( LEFT | RIGHT )
-- 조인의 조건에 만족하지 않는 모든 행을 조회할 때 사용

-- department
SELECT *
FROM department D
LEFT JOIN employee E ON(D.DEPT_ID = E.DEPT_ID);

-- employee
SELECT *
FROM department D
RIGHT JOIN employee E ON(D.DEPT_ID = E.DEPT_ID);

-- 부서배치를 받지 않은 사원의 이름, 부서명을 조회한다면?

SELECT E.EMP_NAME, D.DEPT_NAME
FROM employee E
LEFT JOIN department D  ON(D.DEPT_ID = E.DEPT_ID)
WHERE E.DEPT_ID IS NULL;

SELECT E.EMP_NAME, D.DEPT_NAME
FROM department D
RIGHT JOIN employee E  ON(D.DEPT_ID = E.DEPT_ID)
WHERE E.DEPT_ID IS NULL;


-- 사원의 이름과 사수의 이름을 검색한다면?

SELECT E.EMP_NAME,M.EMP_NAME,S.EMP_NAME
FROM employee E
LEFT JOIN employee M ON(E.MGR_ID = M.EMP_ID)
LEFT JOIN employee S ON(M.MGR_ID = S.EMP_ID);


-- 직급은 대리이고 지역은 아시아로 시작하는 사원정보만 조회

SELECT E.EMP_NAME,J.JOB_TITLE,D.DEPT_NAME,L.LOC_DESCRIBE,C.COUNTRY_NAME,S.SLEVEL
FROM employee E
LEFT JOIN department D ON (E.DEPT_ID = D.DEPT_ID)
LEFT JOIN location L ON (D.LOC_ID = L.LOCATION_ID)
LEFT JOIN country C ON (L.COUNTRY_ID = C.COUNTRY_ID)
LEFT JOIN job J ON (E.JOB_ID = J.JOB_ID)
JOIN sal_grade S ON (E.SALARY BETWEEN S.LOWEST AND S.HIGHEST)
WHERE J.JOB_TITLE ='대리' AND L.LOC_DESCRIBE LIKE '아시아%';

