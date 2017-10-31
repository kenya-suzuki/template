set names utf8;
DROP DATABASE if EXISTS mastercard;
CREATE DATABASE mastercard;
use mastercard;

/* ユーザー情報
 **************************/
create table user(
login_id varchar(10) not null primary key comment 'ログインID',
password varchar(15) not null comment 'ログインパスワード',
name varchar(50) not null comment '姓名（漢字）',
name_e varchar(50) not null comment '姓名（ローマ字）',
postal int(7) not null comment '郵便番号',
address varchar(100) not null comment '住所',
email varchar(40) not null unique comment 'メールアドレス',
tel_number varchar(11) comment '電話番号（自宅）',
mobile varchar(11) comment '電話番号（携帯）',
birthday date not null comment '生年月日',
gender varchar(1) not null comment '性別',
industry_type varchar(20) comment '職種',
job varchar(20) comment '職業',
corporation_name varchar(100) comment '勤務先名（法人呼称）',
office_name varchar(100) comment '勤務先名',
office_address varchar(40) comment '勤務先所在地',
office_tel varchar(11) comment '勤務先電話番号（外線）',
office_years int comment '勤務年数',
bank_code varchar(4) default "9999" comment '銀行コード',
bank_name varchar(10) comment '金融機関名',
branch_number varchar(3) comment '支店番号',
branch_name varchar(10) comment '支店名',
account_type varchar(5) comment '口座種別',
normal_account varchar(7) unique comment '普通口座番号',
deposit_account varchar(7) unique comment '預金口座番号',
savings int comment '預貯金額',
debt int comment '他社借入れ金額',
spouse varchar(1) default "無" comment '配偶者の有無',
use_card varchar(100) comment 'カード使用目的',
income bigint(20) comment '本人年収',
income_f bigint(20) comment '世帯年収',
request_limit int comment '希望利用可能枠',
id_number varchar(4) not null comment '希望暗証番号',
judge_flg varchar(3) default "保留" comment 'クレジットカード審査承認フラグ',
register_day datetime not null default current_timestamp comment '登録日',
update_day datetime not null default current_timestamp on update current_timestamp comment '更新日',
delete_flg boolean default false comment '削除フラグ',
admin_flg boolean default false comment '管理者フラグ'
);

/* 購入お支払履歴
 **************************/
create table user_history(
history_id int not null auto_increment comment 'ヒストリーID',
login_id varchar(50) not null comment 'ログインID',
name_e varchar(50) not null comment '名前（ローマ字）',
corporation_name varchar(50) not null comment 'ご利用店名',
use_day datetime not null default current_timestamp comment 'ご利用日',
division varchar(10) not null default '一括' comment '支払い区分',
split int not null default '0' comment '分割回数',
payment_day datetime not null default current_timestamp comment '支払い予定日',
spend int not null comment '利用金額',
payment int not null comment '支払い金額',
commission int not null default '0' comment '手数料',
delete_flg boolean default false comment '削除フラグ',
cancel_flg boolean default false comment '返品フラグ',
cancel_order_flg boolean default false comment '返品依頼フラグ',
PRIMARY KEY (history_id)
);

/* クレジットカード情報
 ***************************/
create table credit_card(
login_id varchar(10) not null primary key comment 'ログインID',
name_e varchar(50) not null comment '姓名(ローマ字)',
credit_number varchar(16) not null unique comment 'クレジット番号',
security_code varchar(4) not null comment 'セキュリティコード',
id_number varchar(4) not null comment '暗証番号',
credit_limit int not null comment '利用限度額',
register_day datetime not null comment '登録日',
update_day datetime not null comment '更新日',
delete_flg boolean default false comment '削除フラグ',
expiration_year int(11) not null comment '有効期限（年）',
expiration_month int(11) not null comment '有効期限（月）',
spend int(11) default 0 comment 'ご利用金額'
);


/* 法人情報登録申請
 ****************************/
create table corporation(
login_id varchar(10) not null primary key comment 'ログインID',
password varchar(10) not null comment 'ログインパスワード',
corporation_name varchar(50) not null comment '会社名',
postal varchar(7) not null comment '本社郵便番号',
address varchar(100) not null comment '本社所在地',
capital bigint(20) not null comment '資本金',
rep_name varchar(50) not null comment '代表者',
charge varchar(50) not null comment '担当者',
email varchar(40) not null comment 'メールアドレス',
tel_number varchar(11) not null comment '電話番号（外線）',
employee int not null comment '従業員数',
established varchar(3) not null comment '設立年数',
hp_url varchar(100) comment 'ホームページURL',
judge_flg varchar(3) default '保留' comment '加盟店審査認証フラグ',
register_day datetime not null default current_timestamp comment '登録日',
update_day datetime not null default current_timestamp on update current_timestamp comment '更新日',
delete_flg boolean default false comment '削除フラグ'
);

/*管理者情報*/
create table admins(
admin_id int primary key comment '管理者ログインID',
admin_name_e varchar(100) not null comment '管理者名',
admin_password  varchar(20) not null comment '管理者パスワード',
admin_phone_email varchar(200) not null comment '管理者Eメールアドレス'
);


/**
 * ユーザー情報
 */
insert into user(login_id,password,name,name_e,postal,address,email,tel_number,mobile,birthday,gender,industry_type,job,corporation_name,office_name,office_address,office_tel,office_years,bank_code,branch_number,account_type,normal_account,deposit_account,savings,debt,spouse,use_card,income,income_f,request_limit,id_number,judge_flg,register_day,update_day,delete_flg)values
("hidekisama","ikemen","工藤秀樹","KUDOHIDEKI",1112222,"東京都台東区上野1-1-1","hidekisama@gmail.com","0312341234","09012341234","1992-05-31","男","プログラマー","クドゥー開発者","株式会社クドゥー","クドゥー言語研究所","東京都","0355558888","1","0001","004","1","1234567",null,"5000000","1000000000", "有", "パチンコ","10","50","5000000","5555", "承認","2016-06-15 13:25:59","2016-06-15 13:26:00",false),
("kudo","ikezura","工藤秀樹","KUDOHIDEKI",1112222,"東京都台東区上野1-1-1","hidekisam@gmail.com","0312341234","09012341234","1992-05-31","男","プログラマー","クドゥー開発者","株式会社クドゥー","クドゥー言語研究所","東京都","0355558888","1","0001","015","1","1234568",null,"5000000","1000000000", "無", "パチンコ","10","50","5000000","5555", "承認","2016-06-15 13:25:59","2016-06-15 13:26:00",false),
("mura","megane","村上俊一","MURAKAMIJUNICHI",1112222,"東京都台東区上野1-1-1","mura@gmail.com","0313331234","09012341234","2016-06-17","男","プログラマー","クドゥー開発者","株式会社クドゥー","クドゥー言語研究所","東京都","0355558888","1","0001","024","2",null,"6264997","5000000","1000000000", "無","マック食べたい","10","50","5000000","5555","保留","2016-06-15 13:25:59","2016-06-15 13:26:00",false),
("morita","mask","森田直美","MORITANAOMI",1112222,"東京都台東区上野1-1-1","morita@gmail.com","0313331234","09012341234","1990-11-16","女","プログラマー","クドゥー開発者","株式会社クドゥー","クドゥー言語研究所","東京都","0355558888","1","0001","453","2",null,"6774567","5000000","1000000000","無","スロット","10","50","5000000","5555","不承認","2016-06-15 13:25:59","2016-06-15 13:26:00",false),
("shogo","ikemen","中村匠吾","NAKAMURASHOGO",1116622,"東京都台東区上野1-1-1","shogo@gmail.com","0313331234","09012341234","1995-07-18","男","プログラマー","クドゥー開発者","株式会社クドゥー","クドゥー言語研究所","東京都","0355558888","1","0001","481","1","6994567",null,"5000000","1000000000", "無","イケメン講義","10","50","5000000","5555", "保留","2016-06-15 13:25:59","2016-06-15 13:26:00",false),
("kura","kawaii","倉地祥吾","KUTACHISHOGO",1116622,"東京都台東区上野1-1-1","kura@gmail.com","0313331234","09012341234","1995-07-18","男","プログラマー","クドゥー開発者","株式会社クドゥー","クドゥー言語研究所","東京都","0355558888","1","0001","723","2",null,"9994567","5000000","1000000000","無","天才になるため","10","50","5000000","5555", "保留","2016-06-15 13:25:59","2016-06-15 13:26:00",false),
("sasamin","ikemen","石鉢ささみん","ISHIBACHISASAMIN",1116622,"東京都台東区上野1-1-1","sasamin@gmail.com","0313331234","09012341234","1990-10-15","男","プログラマー","クドゥー開発者","株式会社クドゥー","クドゥー言語研究所","東京都","0355558888","1","0001","813","1","9394567",null,"5000000","1000000000","無","ホモアプリ課金","10","50","5000000","5555", "保留","2016-06-15 13:25:59","2016-06-15 13:26:00",false),
("aporo","aporo","冨澤アポロ","TOMIZAWAAPORO",1234567,"23系銀河太陽系月の上","aporo@ginga.com","1232345122","08098721230","4896-10-10","女","宇宙系","宇宙","熱式宇宙アポロ","アポロ言語伝達所","銀河太陽系地球","1231234000","2","0001","760","2",null,"1122567","5123123","12300", "有","宇宙旅行","10000000","500000","50","4885", "承認","2012-06-15 13:25:59","2020-06-15 13:48:53",false);


insert into user(login_id,password,name,name_e,postal,address,email,tel_number,mobile,birthday,gender,normal_account,deposit_account,id_number)values
('1','testuser','テストユーザー','testuser',1130034,'東京都文京区湯島3-2-12　御茶ノ水天神ビル','user.test@gmail.com','0123456789','09012345678','1993-12-24','男','1098765','1098761','5555'),
('2','internous01','井上琢磨','inouetakuma',1130034,'東京都文京区湯島3-2-12　御茶ノ水天神ビル','takuma.inoue@gmail.com','0123456789','09012345678','1990-09-25','男','2109876','2109872','5555'),
('3','internous01','原田美友貴','haradamiyuki',1130034,'東京都文京区湯島3-2-12　御茶ノ水天神ビル','miyuki.harada@gmail.com','0123456789','09012345678','1992-05-03','女','3210987','3210983','5555'),
('4','leader11','テストリーダー1','testleader1',1130034,'東京都文京区湯島3-2-12　御茶ノ水天神ビル','leader1.test@gmail.com','0123456789','09012345678','1990-04-01','男','4321098','4321094','5555'),
('5','leader22','テストリーダー2','testleader2',1130034,'東京都文京区湯島3-2-12　御茶ノ水天神ビル','kouhei.nitabaru@gmail.com','0123456789','09012345678','1990-04-01','男','6543210','6543216','5555'),
('6','student1','仁田原耕平','nitabarukouhei',1130034,'東京都文京区湯島3-2-12　御茶ノ水天神ビル','tatsuhumi.itou@gmail.com','0123456789','09012345678','1990-04-01','男','7654321','7654327','5555'),
('7','student2','伊藤竜文','itoutatsuhumi',1130034,'東京都文京区湯島3-2-12　御茶ノ水天神ビル','leader2.test@gmail.com','0123456789','09012345678','1990-04-01','男','5432109','5432105','5555'),
('8','student3','砂川みのり','sunakawaminori',1130034,'東京都文京区湯島3-2-12　御茶ノ水天神ビル','minori.sunakawa@gmail.com','0123456789','09012345678','1990-04-01','女','8765432','8765438','5555'),
('9','student4','毛塚正広','kedukamasahiro',1130034,'東京都文京区湯島3-2-12　御茶ノ水天神ビル','masahiro.keduka@gmail.com','0123456789','09012345678','1990-04-01','男','9876543','9876549','5555'),
('10','student5','堀口謙一','horiguchikennichi',1130034,'東京都文京区湯島3-2-12　御茶ノ水天神ビル','kennichi.horiguchi@gmail.com','0123456789','09012345678','1990-04-01','男','0987654','0987650','5555'),
('11','student6','霧生雄一','kiryuuyouichi',1130034,'東京都文京区湯島3-2-12　御茶ノ水天神ビル','yuuichi.kiryuu@gmail.com','0123456789','09012345678','1990-04-01','男','1987654','1987651','5555'),
('12','student7','星達也','hoshitatsuya',1130034,'東京都文京区湯島3-2-12　御茶ノ水天神ビル','tatsuya.hoshi@gmail.com','0123456789','09012345678','1990-04-01','男','2987654','2987652','5555'),
('13','student8','岩本興明','iwamotokoumei',1130034,'東京都文京区湯島3-2-12　御茶ノ水天神ビル','koumei.iwamoto@gmail.com','0123456789','09012345678','1990-04-01','男','3987654','3987653','5555');


/**
 * 購入お支払い履歴
 */
insert into user_history(login_id,name_e,corporation_name,use_day,payment_day,spend,payment)values
('1','testuser','株式会社どんとこい','2016-01-27','2016-02-27','100000','100000'),
('2','inoue takuma','株式会社クドゥー','2016-01-27','2016-02-27','130000','130000'),
('3','harada miyuki','bulackcompany','2016-01-27','2016-02-27','32000','32000'),
('4','testleader1','bulackcompany','2016-01-27','2016-02-27','160000','160000'),
('5','testleader2','bulackcompany','2016-01-27','2016-02-27','160000','160000'),
('6','nitabaru kouhei','bulackcompany','2016-01-27','2016-02-27','160000','160000'),
('7','ito tathuhumi','bulackcompany','2016-01-27','2016-02-27','160000','160000'),
('8','sunakawa minori','bulackcompany','2016-01-27','2016-02-27','10000','10000'),
('9','keduka masahiro','黒色グループ','2016-01-27','2016-02-27','710000','710000'),
('10','horiguchi kenichi','暗井洞建設','2016-01-27','2016-02-27','6710000','6710000'),
('11','kiryu yuichi','手招世界警備','2016-01-27','2016-02-27','90000','90000'),
('12','hoshi tathuya','痛井歯科','2016-01-27','2016-02-27','5600','5600'),
('13','iwamoto komei','底野企業','2016-01-27','2016-02-27','65600','65600'),
('14','toshiie maeda','金沢城保守企業','2016-07-03','2016-09-15','12700000','12700000');



/**
 * クレジットカード情報
 */
insert into credit_card(login_id,name_e,credit_number,security_code,id_number,credit_limit,register_day,update_day,delete_flg,expiration_year,expiration_month,spend)values
("hidekisama","KUDOHIDEKI","5555557891234567","1234","1234","100000","2016-06-17 13:16:00","2018-06-17 13:25:00",false,"2019","6","10"),
("kudo","IKEMENKUDO","5555555665877458","4567","4567","456430","2202-08-17 15:16:00","2016-06-17 12:25:00",false,"2019","6","20000"),
("1","test","5555550000000001","001","0001","100000","2202-08-27 15:16:00","2016-06-27 12:25:00",false,"2019","6","20000"),
("2","test","5555550000000002","002","0002","200000","2202-08-27 15:16:00","2016-06-27 12:25:00",false,"2019","6","20000"),
("3","test","5555550000000003","003","0003","300000","2202-08-27 15:16:00","2016-06-27 12:25:00",false,"2019","6","20000"),
("4","test","5555550000000004","004","0004","400000","2202-08-27 15:16:00","2016-06-27 12:25:00",false,"2019","6","20000"),
("5","test","5555550000000005","005","0005","500000","2202-08-27 15:16:00","2016-06-27 12:25:00",false,"2019","6","20000"),
("6","test","5555550000000006","006","0006","600000","2202-08-27 15:16:00","2016-06-27 12:25:00",false,"2019","6","20000"),
("7","test","5555550000000007","007","0007","700000","2202-08-27 15:16:00","2016-06-27 12:25:00",false,"2019","6","20000"),
("8","test","5555550000000008","008","0008","800000","2202-08-27 15:16:00","2016-06-27 12:25:00",false,"2019","6","20000"),
("9","test","5555550000000009","009","0009","900000","2202-08-27 15:16:00","2016-06-27 12:25:00",false,"2019","6","20000"),
("10","test","5555550000000010","010","0010","100000","2202-08-27 15:16:00","2016-06-27 12:25:00",false,"2019","6","20000"),
("11","test","5555550000000011","011","0011","110000","2202-08-27 15:16:00","2016-06-27 12:25:00",false,"2019","6","20000"),
("12","test","5555550000000012","012","0012","120000","2202-08-27 15:16:00","2016-06-27 12:25:00",false,"2019","6","20000")
;

/* 法人データ */
insert into corporation(login_id,password,corporation_name,postal,address,capital,rep_name,charge,email,tel_number,employee,established,hp_url,judge_flg,register_day,update_day,delete_flg)values
("kudo","ikemen","株式会社工藤","1119898","東京都台東区上野1-1-1","50000000","工藤秀樹","倉地祥吾","kudo@gmail.com","0311112222","800","50","kudouhideki@gmail.com","承認",20160617,20160617,false),
("hideki","ikemen","tbox","1119898","東京都台東区上野1-1-1","50000000","工藤秀樹","倉地祥吾","hideki@gmail.com","0311112222","800","50","tbox@gmail.com","保留",20160617,20160617,false),
("yugo","ikemen","kinnosawa","1119898","東京都台東区上野1-1-1","50000000","丸井優吾","丸井優吾","yugoi@gmail.com","0311112222","800","50","tbox@gmail.com","不承認",20160617,20160617,false),
("asa","ikemen","ichigoichie","1119898","東京都台東区上野1-1-1","50000000","あさまさき","あさまさき","asamasaki@gmail.com","0311112222","800","50","asamasaki@gmail.com","保留",20160617,20160617,false),
("morita","ikemen","gekidanroadshow","1119898","東京都台東区上野1-1-1","50000000","森田","直美","morita@gmail.com","0311112222","800","50","moritai@gmail.com","保留",20160617,20160617,false),
("jirou","ueda","株式会社どんとこい","1130034","東京都文京区湯島3-2-12","50000000","上田","次郎","uedajirou@gmail.com","0311112222","800","50","uedajirou@gmail.com","承認",20160617,20160617,false);


/*管理者情報*/
insert into admins(admin_id,admin_password,admin_name_e,admin_phone_email)values
('1','internous01','takuma.inoue','takuma.inoue@gmail.com'),
('2','internous01','akira.kazami','akira.kazami@gmail.com'),
('3','testuser','kubi','kubin@gmail.com'),
('4','testuser','sora','howait@gmail.com'),
('5','testuser','type10tank','tankatack@gmail.com'),
('6','nihonnoyoakezeyo?','ryouma sakamoto','isin@gmail.com'),
('7','tenkahubu','nobunaga.oda','toworld@gmail.com');
