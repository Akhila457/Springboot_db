CREATE TABLE myrule (
  id number(38),
  ruleKey varchar2(255) NOT NULL,
  content varchar2(2048) NOT NULL,
  version varchar2(255) NOT NULL,
  lastModifyTime varchar2(255) DEFAULT NULL,
  createTime varchar2(255) NOT NULL,
  PRIMARY KEY (id));
  
  
  
