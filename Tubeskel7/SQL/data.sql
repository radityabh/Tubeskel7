--------------------------------------------------------
--  File created - Sunday-May-01-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PELANGGAN
--------------------------------------------------------

  CREATE TABLE "DATA"."PELANGGAN" 
   (	"NAMA" VARCHAR2(20 BYTE), 
	"NOHP" VARCHAR2(12 BYTE), 
	"PASS" VARCHAR2(10 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PENGEMUDI
--------------------------------------------------------

  CREATE TABLE "DATA"."PENGEMUDI" 
   (	"NAMA" VARCHAR2(20 BYTE), 
	"NOHP" VARCHAR2(12 BYTE), 
	"PASS" VARCHAR2(10 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TPELANGGAN
--------------------------------------------------------

  CREATE TABLE "DATA"."TPELANGGAN" 
   (	"NAMA" VARCHAR2(20 BYTE), 
	"JENIS" VARCHAR2(10 BYTE), 
	"AWAL" VARCHAR2(20 BYTE), 
	"AKHIR" VARCHAR2(20 BYTE), 
	"NAMAP" VARCHAR2(20 BYTE), 
	"NOHPP" VARCHAR2(12 BYTE), 
	"STATUS" VARCHAR2(100 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TPENGEMUDI
--------------------------------------------------------

  CREATE TABLE "DATA"."TPENGEMUDI" 
   (	"NAMA" VARCHAR2(20 BYTE), 
	"JENIS" VARCHAR2(10 BYTE), 
	"AWAL" VARCHAR2(20 BYTE), 
	"AKHIR" VARCHAR2(20 BYTE), 
	"NAMAP" VARCHAR2(20 BYTE), 
	"NOHPP" VARCHAR2(12 BYTE), 
	"STATUS" VARCHAR2(20 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into DATA.PELANGGAN
SET DEFINE OFF;
Insert into DATA.PELANGGAN (NAMA,NOHP,PASS) values ('bayu','856','bayu');
REM INSERTING into DATA.PENGEMUDI
SET DEFINE OFF;
Insert into DATA.PENGEMUDI (NAMA,NOHP,PASS) values ('dap','1234','dap');
Insert into DATA.PENGEMUDI (NAMA,NOHP,PASS) values ('asd','123','asd');
REM INSERTING into DATA.TPELANGGAN
SET DEFINE OFF;
Insert into DATA.TPELANGGAN (NAMA,JENIS,AWAL,AKHIR,NAMAP,NOHPP,STATUS) values ('bayu','Pesanan','bandung','boyolala','asd','123','diambil');
Insert into DATA.TPELANGGAN (NAMA,JENIS,AWAL,AKHIR,NAMAP,NOHPP,STATUS) values ('bayu','Kurir','boyolala','bandung','dap','1234','diambil');
REM INSERTING into DATA.TPENGEMUDI
SET DEFINE OFF;
Insert into DATA.TPENGEMUDI (NAMA,JENIS,AWAL,AKHIR,NAMAP,NOHPP,STATUS) values ('asd','Pesanan','bandung','boyolala','bayu','856','diambil');
Insert into DATA.TPENGEMUDI (NAMA,JENIS,AWAL,AKHIR,NAMAP,NOHPP,STATUS) values (null,'Pesanan','bandung','boyolala','beha','85642286535','belum diambil');
Insert into DATA.TPENGEMUDI (NAMA,JENIS,AWAL,AKHIR,NAMAP,NOHPP,STATUS) values ('dap','Kurir','boyolala','bandung','bayu','856','diambil');
--------------------------------------------------------
--  DDL for Index PK_PENGEMUDI
--------------------------------------------------------

  CREATE UNIQUE INDEX "DATA"."PK_PENGEMUDI" ON "DATA"."PENGEMUDI" ("NAMA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_PELANGGAN
--------------------------------------------------------

  CREATE UNIQUE INDEX "DATA"."PK_PELANGGAN" ON "DATA"."PELANGGAN" ("NAMA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table PELANGGAN
--------------------------------------------------------

  ALTER TABLE "DATA"."PELANGGAN" ADD CONSTRAINT "PK_PELANGGAN" PRIMARY KEY ("NAMA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PENGEMUDI
--------------------------------------------------------

  ALTER TABLE "DATA"."PENGEMUDI" ADD CONSTRAINT "PK_PENGEMUDI" PRIMARY KEY ("NAMA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TPELANGGAN
--------------------------------------------------------

  ALTER TABLE "DATA"."TPELANGGAN" ADD CONSTRAINT "FK_TPELANGGAN" FOREIGN KEY ("NAMA")
	  REFERENCES "DATA"."PELANGGAN" ("NAMA") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TPENGEMUDI
--------------------------------------------------------

  ALTER TABLE "DATA"."TPENGEMUDI" ADD CONSTRAINT "FK_TPENGEMUDI" FOREIGN KEY ("NAMA")
	  REFERENCES "DATA"."PENGEMUDI" ("NAMA") ENABLE;
