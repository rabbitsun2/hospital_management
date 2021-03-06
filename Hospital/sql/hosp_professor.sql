/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  정도윤(Doyun Jung)
 * Created: 2022. 2. 10.
 */

  CREATE TABLE "HR"."HOSP_PROFESSOR" 
   (	"ID" NUMBER NOT NULL ENABLE, 
	"PROFESSOR_NAME" VARCHAR2(20 BYTE), 
	"PROFESSOR_EMAIL" VARCHAR2(100 BYTE), 
	"PROFESSOR_POSITION" VARCHAR2(20 BYTE), 
	 CONSTRAINT "HOSP_PROFESSOR_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

  CREATE OR REPLACE TRIGGER "HR"."HOSP_PROFESSOR_TRG" 
BEFORE INSERT ON HOSP_PROFESSOR 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    NULL;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "HR"."HOSP_PROFESSOR_TRG" ENABLE;

