create table Signature (
  id bigint generated by default as identity,
  createdDate date not null,
  value varchar(255) not null,
  primary key (id)
);

alter table Signature
  add constraint UK_56m9ahbbkj0gtb5lfhw06h35y unique (value);