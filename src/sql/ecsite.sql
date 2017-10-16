drop database if exists ecsite;

create database if not exists ecsite;
use ecsite;

drop table if exists login_user_transaction;

create table login_user_transaction(
id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16),
user_name varchar(50),
insert_date datetime,
updated_date datetime
);

drop table if exists item_info_transaction;

create table items(
id int not null primary key auto_increment,/*商品番号*/
item_name varchar(30),/*商品名*/
item_price int,/*単価*/
item_stock int,/*在庫数*/
item_image varchar(255) not null,/*イメージパス*/
item_detail not null,/*商品詳細*/
item_sales int default 0,/*売り上げ数*/
category varchar(20) not null,/*カテゴリ名*/
insert_date datetime,
update_date datetime
);

drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
id int not null primary key auto_increment,
item_transaction_id int,
total_price int,
total_count int,
user_master_id varchar(16),
pay varchar(30),
insert_date datetime,
delete_date datetime
);


INSERT INTO item_info_transaction(id, item_name, item_price, item_stock, item_image) VALUES
(1, "牛乳を注ぐ女", 50000, 500, "item1.jpg", ""),
(2, "真珠の耳飾りの少女", 40000, 100, "item2.jpg", ""),
(3, "イーゼルの前の自画像", 60000, 900, "item3.jpg", ""),
(4, "耳を切った自画像", 30000, 600, "item4.jpg", ""),
(5, "カーニバルの晩 ", 30000, 600, "item5.jpg", ""),
(6, "風景の中の自画像", 30000, 600, "item6.jpg", "");

INSERT INTO login_user_transaction(login_id, login_pass, user_name) VALUES("internous", "internous01", "test");