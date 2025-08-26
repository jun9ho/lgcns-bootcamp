/*
 1. 영어영문학과(학과코드 002) 학생들의 학번과 이름, 입학 년도를 입학 년도가 빠른 
	 순으로 표시하는 SQL 문장을 작성하시오.( 단, 헤더는 "학번", "이름", "입학년도" 가 
	 표시되도록 한다.)
*/

SELECT STUDENT_NO AS '학번', STUDENT_NAME AS '이름', SUBSTRING(ENTRANCE_DATE,1,4) AS '입학년도'
FROM tb_student
WHERE DEPARTMENT_NO = '002'
ORDER BY 3 ;

/*
 2. 춘 기술대학교의 교수 중 이름이 세 글자가 아닌 교수가 한 명 있다고 핚다. 그 교수의 
	 이름과 주민번호를 화면에 출력하는 SQL 문장을 작성해 보자. (* 이때 올바르게 작성한 SQL 
	 문장의 결과 값이 예상과 다르게 나올 수 있다. 원인이 무엇일지 생각해볼 것) 
*/

SELECT PROFESSOR_NAME
FROM tb_professor
WHERE CHAR_LENGTH(PROFESSOR_NAME) !=3;

/*
 3. 춘 기술대학교의 남자 교수들의 이름과 나이를 출력하는 SQL 문장을 작성하시오. 단 
	 이때 나이가 적은 사람에서 맋은 사람 순서로 화면에 출력되도록 만드시오. (단, 교수 중 
	 2000 년 이후 출생자는 없으며 출력 헤더는 "교수이름", "나이"로 한다. 나이는 ‘만’으로 
	 계산한다.) 
*/

SELECT PROFESSOR_NAME AS '교수 이름', YEAR(CURDATE()) - 1900 - CAST((SUBSTRING(PROFESSOR_SSN,1,2)) AS INT) AS '나이'
FROM tb_professor
WHERE SUBSTRING(PROFESSOR_SSN,8,1) = '1'
ORDER BY 2 ;


/*
 4. 교수들의 이름 중 성을 제외한 이름만 출력하는 SQL 문장을 작성하시오. 출력 헤더는 
	 "이름" 이 찍히도록 한다. (성이 2자인 경우는 교수는 없다고 가정하시오)
*/

SELECT SUBSTRING(PROFESSOR_NAME,2,2) AS "이름"
FROM tb_professor

/*
 5. 춘 기술대학교의 재수생 입학자를 구하려고 한다. 어떻게 찾아낼 것인가?  이때, 
	 19살에 입학하면 재수를 하지 않은 것으로 간주한다. 
*/

SELECT STUDENT_NO,STUDENT_NAME,
CAST(SUBSTRING(ENTRANCE_DATE,1,4) AS INT)-1900-CAST(SUBSTRING(STUDENT_SSN,1,2) AS INT) AS '나이'
FROM tb_student
WHERE CAST(SUBSTRING(ENTRANCE_DATE,1,4) AS INT)-1900-CAST(SUBSTRING(STUDENT_SSN,1,2) AS INT) = 20;

/*
 6. 2020년 크리스마스는 무슨 요일인가? 
*/

SELECT DATEDIFF(CURDATE(),"2020-12-25")%7;

SELECT (CASE WEEKDAY('2020-12-25')
				WHEN '0' THEN '월요일'
				WHEN '1' THEN '화요일'
				WHEN '2' THEN '수요일'
				WHEN '3' THEN '목요일'
				WHEN '4' THEN '금요일'
				WHEN '5' THEN '토요일'
				WHEN '6' THEN '일요일'
				END) AS WEEK_DAY

/*
 8. 춘 기술대학교의 2000년도 이후 입학자들은 학번이 A로 시작하게 되어있다. 2000년도 
	 이전 학번을 받은 학생들의 학번과 이름을 보여주는 SQL 문장을 작성하시오. 
*/

SELECT STUDENT_NO,STUDENT_NAME
FROM tb_student
WHERE CAST(SUBSTRING(ENTRANCE_DATE,1,4) AS INT) < 2000;

/*
 9. 학번이 A517178 인 한아름 학생의 학점 총 평점을 구하는 SQL 문을 작성하시오. 단, 
	 이때 출력 화면의 헤더는 "평점" 이라고 찍히게 하고, 점수는 반올림하여 소수점 이하 한 
	 자리까지만 표시한다.
*/

SELECT ROUND(AVG(POINT),1)
FROM tb_grade
WHERE STUDENT_NO = 'A517178';

/*
 10. 학과별 학생수를 구하여 "학과번호", "학생수(명)" 의 형태로 헤더를 만들어 결과값이 
	  출력되도록 하시오. 
*/
SELECT *
FROM tb_student;

SELECT DEPARTMENT_NO AS '학과 번호',COUNT(STUDENT_NO) AS '학생 수'
FROM tb_student
GROUP BY DEPARTMENT_NO;

/*
 11. 지도 교수를 배정받지 못한 학생의 수는 몇 명 정도 되는 알아내는 SQL 문을 
	  작성하시오.
*/
SELECT COUNT(STUDENT_NO)
FROM tb_student
WHERE COACH_PROFESSOR_NO IS NULL;

/*
 12. 학번이 A112113인 김고운 학생의 년도 별 평점을 구하는 SQL 문을 작성하시오. 단, 
	  이때 출력 화면의 헤더는 "년도", "년도 별 평점" 이라고 찍히게 하고, 점수는 반올림하여 
	  소수점 이하 한 자리까지만 표시한다.
*/

SELECT SUBSTRING(TERM_NO,1,4) AS '년도', ROUND(AVG(POINT),1) AS '년도 별 평점'
FROM tb_grade
WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTRING(TERM_NO,1,4)


/*
 13. 학과 별 휴학생 수를 파악하고자 한다. 학과 번호와 휴학생 수를 표시하는 SQL 문장을 
	  작성하시오. 
*/

SELECT D.DEPARTMENT_NO AS "학과코드명",IFNULL(COUNT(S.STUDENT_NO),0) AS "휴학생 수"
FROM tb_department D
LEFT JOIN tb_student S ON D.DEPARTMENT_NO = S.DEPARTMENT_NO AND S.ABSENCE_YN = 'Y'
GROUP BY D.DEPARTMENT_NO;

/*
 14. 춘 대학교에 다니는 동명이인 학생들의 이름을 찾고자 한다. 어떤 SQL 
	  문장을 사용하면 가능하겠는가?
*/

SELECT STUDENT_NAME, COUNT(*)
FROM tb_student
GROUP BY STUDENT_NAME
HAVING COUNT(*)>1;

/*
 15. 학번이 A112113 인 김고운 학생의 년도, 학기 별 평점과 년도 별 누적 평점 , 총 
	  평점을 구하는 SQL 문을 작성하시오. (단, 평점은 소수점 1자리까지만 반올림하여 
	  표시한다.) 
*/

SELECT SUBSTRING(TERM_NO,1,4) AS '년도',SUBSTRING(TERM_NO,5,2) AS '학기',ROUND(AVG(POINT),1) AS '년도 별 평점'
FROM tb_grade
WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTRING(TERM_NO,1,4) ,SUBSTRING(TERM_NO,5,2)  WITH ROLLUP


