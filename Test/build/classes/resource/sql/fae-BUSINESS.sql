
-- Create table PRALCPROP
-- =================================
--
create table PRALCPROP
(
  alcprdcod            VARCHAR(22)     not null,
  alcprdsts            CHAR           ,
  alcorgcod            VARCHAR(8)     ,
  alcntfsts            VARCHAR(32)    ,
  alcntftim            datetime       ,
  alccrtusr            VARCHAR(20)    ,
  alccrttim            datetime       ,
  alcupdusr            VARCHAR(20)    ,
  alcupdtim            datetime       
);

alter table PRALCPROP add constraint PK_PRALCPROP primary key(alcprdcod);



