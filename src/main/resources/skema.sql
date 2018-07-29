create table mahasiswa (

  id int primary key auto_increment,
  nim varchar(8) not null,
  nama varchar(255) not null,
  tempat_lahir varchar(255) not null,
  tanggal_lahir DATE not null,
  jenis_kelamin varchar (255) not null,
  alamat varchar (255) not null

) engine=innodb;