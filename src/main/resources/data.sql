-- Role Table Data
INSERT INTO role(role_name) VALUES ('USER');
INSERT INTO role(role_name) VALUES ('MANAGER');
INSERT INTO role(role_name) VALUES ('ADMIN');

-- Category Table Data
INSERT INTO category(cat_name, description) VALUES ('Long sleeves','Long sleeves clothes');
INSERT INTO category(cat_name, description) VALUES ('Short sleeves', 'Short sleeves clothes');
INSERT INTO category(cat_name, description) VALUES ('Accessories', 'Football accessories');
-- Team Table Data
INSERT INTO team(team_name) VALUES ('Manchester United');
INSERT INTO team(team_name) VALUES ('Chelsea');
INSERT INTO team(team_name) VALUES ('Barcelona');
INSERT INTO team(team_name) VALUES ('Arsenal');
INSERT INTO team(team_name) VALUES ('Real Madrid');
INSERT INTO team(team_name) VALUES ('Manchester City');
INSERT INTO team(team_name) VALUES ('Liverpool');
INSERT INTO team(team_name) VALUES ('Athletico Madrid');
INSERT INTO team(team_name) VALUES ('Juventus');
INSERT INTO team(team_name) VALUES ('Bayern Munich');
INSERT INTO team(team_name) VALUES ('Borussia Dortmund');

-- Product Table Data
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Manchester United Home Kit 2019/2020 Short Sleeves','http://aobongda.net/pic/Product/4d4081299_636923843568531554_HasThumb.jpg',90000,2,1,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Manchester United Away Kit 2019/2020 Short Sleeves','http://aobongda.net/pic/Product/2d50a9661_637008625260522819_HasThumb.jpg',90000,2,1,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Manchester United Fan Kit 2019/2020 Short Sleeves','http://aobongda.net/pic/Product/902c75381_637066469452147447_HasThumb.jpg',90000,2,1,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Chelsea Home Kit 2019/2020 Short Sleeves','http://aobongda.net/pic/Product/f69c4751c_636935367044830712_HasThumb.jpg',90000,2,2,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Chelsea Away Kit 2019/2020 Short Sleeves','http://aobongda.net/pic/Product/21265e418_636981824198638891_HasThumb.jpg',90000,2,2,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Chelsea 3rd Kit 2019/2020 Short Sleeves','http://aobongda.net/pic/Product/1cac120f0_636903988113061725_HasThumb.jpg',90000,2,2,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Barcelona Home Kit 2019/2020 Short Sleeves','http://aobongda.net/pic/Product/fed6111b9_636935369097468116_HasThumb.jpg',90000,2,3,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Barcelona Away Kit 2019/2020 Short Sleeves','http://aobongda.net/pic/Product/1929941e2_637008633540391508_HasThumb.jpg',90000,2,3,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Real Madrid Home Kit 2019/2020 Short Sleeves','http://aobongda.net/pic/Product/f9af6768a_636939681974900677_HasThumb.jpg',90000,2,5,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Real Madrid Away Kit 2019/2020 Short Sleeves','http://aobongda.net/pic/Product/0f4baf803_636945448642727897_HasThumb.jpg',90000,2,5,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Liverpool Home Kit 2019/2020 Long Sleeves','http://aobongda.net/pic/Product/55d0c3e07_636934514464855926_HasThumb.jpg',150000,1,7,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Liverpool Away Kit 2019/2020 Long Sleeves','http://aobongda.net/pic/Product/8a9c995ff_636969647346166382_HasThumb.jpg',150000,1,7,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Juventus Home Kit 2019/2020 Long Sleeves','http://aobongda.net/pic/Product/6393ece5e_636927388757438775_HasThumb.jpg',150000,1,9,true);