/*
 1. 학생이름과 주소지를 표시하시오. 단, 출력 헤더는 "학생 이름", "주소지"로 하고, 
	 정렬은 이름으로 오름차순 표시하도록 한다. 
*/

SELECT STUDENT_NAME AS '학생 이름', STUDENT_ADDRESS AS '주소지'
FROM tb_student
ORDER BY 1;

/*
 2. 휴학중인 학생들의 이름과 주민번호를 나이가 적은 순서로 화면에 출력하시오. 
*/

SELECT STUDENT_NAME, STUDENT_SSN
FROM tb_student
WHERE ABSENCE_YN = 'Y'
ORDER BY STUDENT_SSN DESC;

/*
 3. 주소지가 강원도나 경기도인 학생들 중 1900년대 학번을 가진 학생들의 이름과 학번, 
	 주소를 이름의 오름차순으로 화면에 출력하시오. 단, 출력헤더에는 "학생이름","학번", 
	 "거주지 주소" 가 출력되도록 핚다.
*/

SELECT STUDENT_NAME AS '학생 이름',STUDENT_NO AS '학번',STUDENT_ADDRESS AS '거주지 주소'
FROM tb_student
WHERE SUBSTRING(STUDENT_NO,1,1) = '9'
AND (STUDENT_ADDRESS LIKE '경기도%' OR STUDENT_ADDRESS LIKE '강원도%');

/*
 4. 현재 법학과 교수 중 가장 나이가 맋은 사람부터 이름을 확인할 수 있는 SQL 문장을 
	 작성하시오. (법학과의 '학과코드'는 학과 테이블(TB_DEPARTMENT)을 조회해서 찾아 
	 내도록 하자) 
*/

SELECT PROFESSOR_NAME, PROFESSOR_SSN
FROM tb_professor
WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO
								FROM tb_department
								WHERE DEPARTMENT_NAME ='법학과')
ORDER BY PROFESSOR_SSN;

/*
 5. 2004년2학기에 'C3118100' 과목을 수강핚 학생들의 학점을 조회하려고 핚다. 학점이 
	 높은 학생부터 표시하고, 학점이 같으면 학번이 낮은 학생부터 표시하는 구문을 
	 작성해보시오. 
*/

SELECT STUDENT_NO,POINT
FROM tb_grade
WHERE CLASS_NO = 'C3118100'
AND TERM_NO='200402'
ORDER BY POINT DESC,STUDENT_NO

/*
 6. 학생 번호, 학생 이름, 학과 이름을 학생 이름으로 오름차순 정렬하여 출력하는 SQL 
	 문을 작성하시오. 
*/

SELECT S.STUDENT_NO,S.STUDENT_NAME, D.DEPARTMENT_NAME
FROM tb_student S
JOIN tb_department D ON(S.DEPARTMENT_NO = D.DEPARTMENT_NO)
ORDER BY S.STUDENT_NAME;

/*
 7. 춘 기술대학교의 과목 이름과 과목의 학과 이름을 출력하는
 	 SQL 문장을 작성하시오.
*/

SELECT C.CLASS_NAME,D.DEPARTMENT_NAME
FROM tb_department D
JOIN tb_class  C ON (D.DEPARTMENT_NO = C.DEPARTMENT_NO)

/*
 8. 과목별 교수 이름을 찾으려고 한다. 과목 이름과 교수 이름을 출력하는 SQL 문을 
	 작성하시오. 
*/

SELECT C.CLASS_NAME,P.PROFESSOR_NAME
FROM tb_class C
JOIN tb_class_professor CP ON(C.CLASS_NO=CP.CLASS_NO)
JOIN tb_professor P ON(CP.PROFESSOR_NO=P.PROFESSOR_NO)

/*
 9. 8번의 결과 중 ‘인문사회’ 계열에 속핚 과목의 교수 이름을 찾으려고 한다. 이에 
	 해당하는 과목 이름과 교수 이름을 출력하는 SQL 문을 작성하시오.
*/


















