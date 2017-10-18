drop database if exists ecsite;

create database if not exists ecsite;
use ecsite;

drop table if exists login_user_transaction;

create table login_user_transaction(
user_id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16),
user_name varchar(50),
insert_date datetime,
updated_date datetime
);

drop table if exists items;

create table items(
item_id int not null primary key auto_increment,/*商品番号*/
item_name varchar(255) not null,/*商品名*/
item_author varchar(255) not null,/*作者*/
item_price int,/*単価*/
item_stock int,/*在庫数*/
item_image varchar(255),/*イメージパス*/
item_detail varchar(255),/*商品詳細*/
item_sales int default 0,/*売り上げ数*/
category_id int default 1,/*カテゴリー番号*/
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

drop table if exists comments;

create table comments(
comment_id int primary key not null auto_increment,
item_id int not null,
user_name varchar(50) not null,
comment varchar(100) not null,
registration_date date not null,
update_date date not null
/*foreign key(user_id)
references openconnect.users(user_id)*/
);


INSERT INTO items(item_id, item_name, item_author, item_price, item_stock, item_image, item_detail) VALUES
(1, "牛乳を注ぐ女", "ヨハネス・フェルメール", 50000, 500, "item1.jpg", "『牛乳を注ぐ女』は、欧米では牛の乳搾り作業に従事する女性を意味する「ミルクメイド」と呼ばれているが、実際に描かれている女性は低級の家事使用人であり、台所担当の召使い（キッチンメイド）あるいは家政の女中（メイド）である。"),
(2, "真珠の耳飾りの少女", "ヨハネス・フェルメール", 40000, 100, "item2.jpg", "制作されたのは、1665年もしくは1666年と推定されている。フェルメールが33歳から34歳の頃で、画家として安定した技量を発揮しつつあった時期であるが、異論がないわけではない。この少女のモデルをフェルメールの娘マーリアであるとして1670年代とする意見もあるが、1670年代の彼の技法はこの絵と明らかに異なっているため、可能性は低い。"),
(3, "イーゼルの前の自画像", "フィンセント・ファン・ゴッホ", 60000, 900, "item3.jpg", "後期印象派の巨匠フィンセント・ファン・ゴッホ、パリ時代の代表的な自画像作品のひとつ『イーゼルの前の自画像』。ゴッホが南仏アルルへと旅立つ直前となる1888年の1月から2月にかけて制作された本作は、画架の前に絵筆を持つゴッホ自身の≪自画像≫作品で、パリ時代にゴッホは28点もの自画像作品を手がけているが、本作はその中でも特によく知られた作品である。"),
(4, "耳を切った自画像", "フィンセント・ファン・ゴッホ", 30000, 600, "item4.jpg", "包帯をしてパイプをくわえた自画像とは、1889年1月にフィンセント・ファン・ゴッホによって描かれた絵画。油彩。「耳を切った自画像」と表記されることがある。スタブロス・ニアルコスのコレクションとされているが、2016年現在チューリヒ美術館に貸し出されており、鑑賞することができる。アルル在住時にいわゆる「耳切り事件」の直後に描かれたものだと言われる。"),
(5, "カーニバルの晩", "アンリ・ルソー", 30000, 600, "item5.jpg", "素朴派の巨匠アンリ・ルソー作『カーニバルの晩』。1886年に開催された第2回アンデパンダン展への出品作である本作は、現存する画家の同展への最初期の作品として知られている。本作に描かれるのはカーニバルの夜に散歩するピエロとコロンビーヌに扮した男女であるが、現存する最初期の作品であるにも係わらず、本作からはルソーが既に独自の絵画表現や世界観を確立していたことを窺い知ることができる。"),
(6, "風景の中の自画像", "アンリ・ルソー", 30000, 600, "item6.jpg", "素朴派の巨匠アンリ・ルソー初期の代表作『風景の中の自画像』。本作は1889年に開催されたパリ万国博覧会の情景を背景に、まだ税関吏として働いていたルソーが画家としての己の46歳の姿を描いた自画像作品で、ルソーが死の間際まで手放さず、加筆し続けた作品でもある。");

INSERT INTO login_user_transaction(login_id, login_pass, user_name) VALUES
("internous", "internous01", "test"),
("nous@gmail.com", "internous02", "test1");