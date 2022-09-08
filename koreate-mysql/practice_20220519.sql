CREATE DATABASE bigdata;

SELECT * FROM dept;
SELECT * FROM emp;
SELECT * FROM salgrade;

-- 1. 급여가 1500 이하인 사원의 사원번호, 사원명, 급여 출력
SELECT empno, ename, sal 
FROM emp 
WHERE sal<=1500;

-- 2. SCOTT 사원의 사원번호, 사원명, 급여 출력
SELECT empno, ename, sal
FROM emp
WHERE ename='SCOTT';

-- 3. 10번 부서 소속의 사원들 중 직급이 MANAGER인 사람을 검색해서 사원명, 부서번호, 직급을 출력
SELECT e.ename, e.deptno, e.job
FROM emp e
WHERE e.deptno='10' AND e.job='MANAGER';

-- 4. 10번 부서가 아닌 사원의 사원명, 부서번호, 직급 출력
SELECT e.ename, d.deptno, e.job
FROM emp e, dept d
WHERE d.deptno !='10';

-- 5. 급여가 2000에서 3000 사이 사원의 사원명, 부서번호, 급여 출력
SELECT e.ename, e.deptno, e.sal
FROM emp e
WHERE e.sal BETWEEN 2000 AND 3000;

-- 6. 커미션이 300이거나 500이거나 1400인 사원의 사원번호, 사원명, 급여, 커미션 출력
SELECT e.empno, e.ename, e.sal, e.comm
FROM emp e
WHERE e.comm IN(300,500,1400);

-- 7. 입사일이 1987년 1월 1일에서 1987년 12월 31일 사이인 사원의 사원번호, 사원명, 급여, 입사일 출력
SELECT e.empno, e.ename, e.sal, e.hiredate
FROM emp e
WHERE e.hiredate BETWEEN '1987-01-01' AND '1987-12-31';
-- WHERE hiredate LIKE '1987%';

-- 8. 이름이 F로 시작하는 사원의 사원번호, 사원명 출력
SELECT e.empno, e.ename
FROM emp e
WHERE e.ename LIKE "F%";

-- 9. 이름에 A가 들어가는 사원의 사원번호, 사원명 출력
SELECT e.empno, e.ename
FROM emp e
WHERE e.ename LIKE "%A%";

-- 10. 이름에 3번째 자리가 R인 사원의 사원번호, 사원명 출력
SELECT e.empno, e.ename
FROM emp e
WHERE e.ename LIKE "__R%";

-- 11. 커미션이 null 인 사원의 사원번호, 사원명, 커미션 출력
SELECT e.empno, e.ename, e.comm
FROM emp e
WHERE e.comm is null;

-- 12. 급여를 많이 받는 순서대로 출력하고, 급여가 같은 사람의 경우 이름이 빠른 순서대로 나오도록 사원번호, 사원명, 급여 출력
SELECT e.empno, e.ename, e.sal
FROM emp e
WHERE e.sal ORDER BY e.sal DESC, e.ename asc;

-- 13. SCOTT과 같은 부서에서 근무하는 사원의 이름과 부서번호 출력
SELECT e.ename, e.deptno
FROM emp e
WHERE deptno=(
 SELECT deptno FROM emp WHERE ename='SCOTT'
);

-- 14. SCOTT과 동일한 직급을 가진 사원의 정보 출력
SELECT * FROM emp
WHERE job=(SELECT job FROM emp WHERE ename='SCOTT');

SELECT * FROM dept;
SELECT * FROM emp;

-- 15. SCOTT이 소속된 부서의 부서명 출력

SELECT d.dname
FROM dept d
WHERE d.deptno=(SELECT deptno FROM emp WHERE ename='SCOTT');


-- 16. DALLAS에서 근무하는 사원의 이름, 부서번호 출력
SELECT e.ename, e.deptno
FROM emp e
WHERE  deptno=(
SELECT deptno FROM dept WHERE loc='DALLAS');

-- 17. 자신의 매니저가 KING인 사원의 이름과 급여 출력
SELECT ename, sal
FROM emp
WHERE mgr=(SELECT empno from emp WHERE ename='KING');

-- 18. 급여를 3000 이상 받는 사원이 소속된 부서 사원의 부서번호, 사원명, 급여 출력
SELECT deptno, ename, sal
FROM emp
WHERE deptno in(
SELECT deptno from emp WHERE sal>=3000
);

-- 19. 30번 부서 사원들 중 급여를 가장 많이 받는 사원보다 더 많은 급여를 받는 사원의 이름과 급여를 출력
SELECT max(sal) FROM emp WHERE deptno = 30;

SELECT ename, sal FROM emp 
WHERE sal > (
	SELECT max(sal) FROM emp 
    WHERE deptno = 30);

SELECT ename, sal FROM emp
WHERE sal > ALL(
SELECT sal FROM emp WHERE deptno=30);

-- 20. 영업사원(SALESMAN)들의 최소 급여보다 많이 받는 사원들의 이름과 급여, 직급을 출력하되, 영업사원은 제외
SELECT ename, sal, job
FROM emp
WHERE sal >(
	SELECT min(sal) FROM emp WHERE job='SALESMAN')
    AND job !='SALESMAN';

-- 21. 가장 최근에 입사한 사원의 입사일과 가장 오래된 사원의 입사일
SELECT max(hiredate), min(hiredate) FROM emp;

-- 22. 부서별 평균급여를 부서번호, 평균급여 형태로 출력
SELECT 
	deptno , avg(sal)
FROM emp 
GROUP BY deptno;

-- 23. 부서의 최소 급여와 최대 급여를 구하고, 최대 급여가 3000 이상인 부서만 출력
SELECT deptno, min(sal) AS '최소급여' , max(sal) AS '최대급여'
FROM emp 
GROUP BY deptno HAVING max(sal)>=3000;

-- 24. 사원들 평균 급여보다 더 많은 급여를 받는 사원의 이름과 급여 출력
SELECT ename, sal
FROM emp
WHERE sal > (
	SELECT avg(sal) FROM emp
);

-- 25. 부서별 가장 급여가 많은 사원의 사원번호, 사원명, 급여, 부서번호
SELECT empno, ename, sal, deptno
FROM emp
WHERE sal in(
	 SELECT max(sal) FROM emp group by deptno
); 
