Select first_name ,last_name ,salary from emp where salary=(select min(salary)from emp);
Select first_name ,last_name ,salary from emp where salary=(select min(salary)from emp where lower(title)='warehouse manager')and  lower(title)='warehouse manager';
Select first_name ,last_name ,salary,title from emp e1 where salary=(select min(salary)from emp e2 where e1.title=e2.title);
Select first_name ,last_name ,salary from emp where salary<(select avg(salary)from emp)order by salary ;
Select first_name ,last_name ,salary,title from emp where salary<(select avg(salary)from emp)and lower(title) like 'sales%' order by salary ;
Select first_name ,last_name ,salary,title from emp where salary > any(select salary from emp where lower(last_name)='patel') order by  salary desc;
Select first_name ,last_name ,salary,title from emp e1 where salary <(select avg(salary)from emp e2 where e1.title=e2.title);
Select first_name ,last_name , id from emp where  exists (select ord.sales_rep_id from ord where emp.id=ord.sales_rep_id);