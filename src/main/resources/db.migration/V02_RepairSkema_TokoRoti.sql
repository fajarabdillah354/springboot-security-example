create table products(
id_product varchar(255) not null,
nama_product varchar(255) not null,
deskripsi text,
harga int default 0,
stok int default 0,
primary key(id_product)
)engine=InnoDB;

create table customers(
id_customer varchar(25) not null,
nama_customer varchar(255) not null,
email varchar(255),
nomor_telepon long,
alamat varchar(255) not null,
primary key(id_customer)
)engine=InnoDB;

create table orders(
id_order varchar(25) not null,
tanggal_pesanan timestamp,
total_harga decimal default 0,
status_pembayaran enum('diproses','selesai'),
primary key(id_order)
)engine=InnoDB;

create table categories(
id_categori varchar(25) not null,
nama_categori varchar(255) not null,
primary key(id_categori)
)engine=InnoDB;

