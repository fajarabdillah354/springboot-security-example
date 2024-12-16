create table products(
id_product varchar(255) not null,
nama_product varchar(255) not null,
deskripsi text,
harga long default 0,
stok int default 0,
kategori varchar(255),
primary key(id_produk)
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
id_pesanan varchar(25) not null,
id_customer varchar(25) not null,
tanggal_pesanan timestamp,
total_harga decimal default 0,
status_pembayaran enum('diproses','selesai'),
foreign key (id_customer) references customers(id_customer)
on delete cascade on update cascade,
primary key(id_detail)
)engine=InnoDB;

create table order_details(
id_detail varchar(25) not null,
id_customers varchar(25) not null,
id_products varchar(25) not null,
kuantitas int default 0,
subtotal decimal default 0,
constraint fk_costumers_products
	foreign key (id_customers) references customer(id_customer)
    on delete cascade on update cascade,
constraint fk_products_customers
	foreign key (id_products) references products(id_product)
    on delete cascade on update cascade,
primary key(id_pesanan)
)engine=InnoDB;


create table categories(
id_kategori varchar(25) not null,
nama_kategori varchar(255) not null,
primary key(id_kategori)
)engine=InnoDB;
