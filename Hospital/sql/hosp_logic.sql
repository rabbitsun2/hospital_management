/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  정도윤(Doyun Jung)
 * E-mail:  rabbit.white at daum dot net
 * Created: 2022. 2. 6.
 */

select hosp_reservation.id as "id", hosp_reservation.dept_id as "dept_id", hosp_dept.dept_name as "dept_name",
    hosp_reservation.res_date as "res_date", hosp_reservation.birth_date as "birth_date",
    hosp_reservation.regi_date as "regi_date", hosp_reservation.cus_name as "cus_name", 
    hosp_reservation.cus_phone as "cus_phone" 
    from hosp_reservation, hosp_dept where hosp_reservation.dept_id = hosp_dept.dept_id order by id;

/* 특정 학과 조회 */
select hosp_reservation.id as "id", hosp_reservation.dept_id as "dept_id", hosp_dept.dept_name as "dept_name",
    hosp_reservation.res_date as "res_date", hosp_reservation.birth_date as "birth_date",
    hosp_reservation.regi_date as "regi_date", hosp_reservation.cus_name as "cus_name",
    hosp_reservation.cus_phone as "cus_phone" 
    from hosp_reservation, hosp_dept where hosp_reservation.dept_id = hosp_dept.dept_id and ( dept_name = '정신건강의학과1' ) order by id;

/* 특정 날짜 조회 */
    select hosp_reservation.id as "id", hosp_reservation.dept_id as "dept_id", hosp_dept.dept_name as "dept_name",
    hosp_reservation.res_date as "res_date", hosp_reservation.birth_date as "birth_date",
    hosp_reservation.regi_date as "regi_date", hosp_reservation.cus_name as "cus_name",
    hosp_reservation.cus_phone as "cus_phone"
    from hosp_reservation, hosp_dept where hosp_reservation.dept_id = hosp_dept.dept_id and 
    ( dept_name = '정신건강의학과1' and 
      res_date BETWEEN TO_DATE('2022-02-07', 'YYYY-MM-DD HH24:MI:SS') 
                   AND TO_DATE('2022-02-07', 'YYYY-MM-DD HH24:MI:SS')  ) order by id;

/* 
select hosp_reservation.id as "id", hosp_reservation.dept_id as "dept_id", hosp_dept.dept_name as "dept_name",
    hosp_reservation.res_date as "res_date", hosp_reservation.birth_date as "birth_date",
    hosp_reservation.regi_date as "regi_date", hosp_reservation.cus_name as "cus_name",
    hosp_reservation.cus_phone as "cus_phone"
    from hosp_reservation, hosp_dept where hosp_reservation.dept_id = hosp_dept.dept_id and 
    ( dept_name = '신경외과1' and to_number( to_char( hosp_reservation.res_date, 'YYYYMMDD') ) = 20220207 ) order by id;

/* 학과 조회 */
    select hosp_dept.dept_id as "dept_id", hosp_dept.dept_name as "dept_name", hosp_dept.professor_id as "professor_id",
    hosp_professor.professor_name as "professor_name", hosp_professor.professor_email as "professor_email",
    hosp_professor.professor_position as "professor_position" from hosp_dept, hosp_professor where dept_id = hosp_professor.id order by dept_id;

/* 환자 예약 등록 */
insert into hosp_reservation(dept_id, res_date, birth_date, regi_date, cus_name, cus_phone) 
values(3, to_date('2022-02-08 11:50:00', 'YYYY-MM-DD HH24:MI:SS'), 
          to_date('1991-10-05 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 
          to_date('1991-10-05 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 
          '홍길동', '010-1234-1234');

/* 환자 예약 삭제 */
delete from hosp_reservation where id = '9';

/* 환자 예약 수정 */
update hosp_reservation set dept_id = 1 where id = 15;