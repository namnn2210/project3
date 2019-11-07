-- Role Table Data
INSERT INTO role(role_name) VALUES ('USER');
INSERT INTO role(role_name) VALUES ('MANAGER');
INSERT INTO role(role_name) VALUES ('ADMIN');

--User Table Data
INSERT INTO `user` ( `address`, `created_at`, `dob`, `email`, `full_name`, `gender`, `password`, `phone`, `status`, `updated_at`, `username`, `role_id`) VALUES
('9B Le Quy Don', '2019-10-31 10:33:51', '1997-10-22', 'nam@gmailcom', 'Ngo Ngoc Nam', 2, '$2a$10$JrfQrN9sNr1nqJ7qFt55oOPjHcLIztzr2px6yLpeNrL1GGuNMVcHS', '0373924314', 1, '2019-10-31 10:33:51', 'namngocngo22', 1);
INSERT INTO `user` (`address`, `created_at`, `dob`, `email`, `full_name`, `gender`, `password`, `phone`, `status`, `updated_at`, `username`, `role_id`) VALUES
('Kim Nguu', '2019-11-07 22:03:06', '1997-02-09', 'admin@gmail.com', 'Admin Test', 1, '$2a$10$Pr7QEv8IzkeZbd2HMBJ1oO0mOmpxNwf33HLXsSbrVwONg2Xrep/iq', '0962266324', 1, '2019-11-07 22:03:06', 'admin', 3);

-- Category Table Data
INSERT INTO category(cat_name, description,status) VALUES ('Long sleeves','Long sleeves clothes',true);
INSERT INTO category(cat_name, description,status) VALUES ('Short sleeves', 'Short sleeves clothes',true);
INSERT INTO category(cat_name, description,status) VALUES ('Accessories', 'Football accessories',true);
INSERT INTO category(cat_name, description,status) VALUES ('Trophies, Medals', 'Football trophies and medals',true);
INSERT INTO category(cat_name, description,status) VALUES ('Services', 'Football services',true);
-- Team Table Data
INSERT INTO team(team_name,status) VALUES ('Manchester United',true);
INSERT INTO team(team_name,status) VALUES ('Chelsea',true);
INSERT INTO team(team_name,status) VALUES ('Barcelona',true);
INSERT INTO team(team_name,status) VALUES ('Arsenal',true);
INSERT INTO team(team_name,status) VALUES ('Real Madrid',true);
INSERT INTO team(team_name,status) VALUES ('Manchester City',true);
INSERT INTO team(team_name,status) VALUES ('Liverpool',true);
INSERT INTO team(team_name,status) VALUES ('Athletico Madrid',true);
INSERT INTO team(team_name,status) VALUES ('Juventus',true);
INSERT INTO team(team_name,status) VALUES ('Bayern Munich',true);
INSERT INTO team(team_name,status) VALUES ('Borussia Dortmund',true);
INSERT INTO team(team_name,status) VALUES ('Others',true);

-- Product Table Data
-- Football Shirts
-- Short Sleeves
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Manchester United Home Kit 2019/2020 Short Sleeves','http://aobongda.net/pic/Product/4d4081299_636923843568531554_HasThumb.jpg',4.5,2,1,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Manchester United Away Kit 2019/2020 Short Sleeves','http://aobongda.net/pic/Product/2d50a9661_637008625260522819_HasThumb.jpg',4.5,2,1,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Manchester United Fan Kit 2019/2020 Short Sleeves','http://aobongda.net/pic/Product/902c75381_637066469452147447_HasThumb.jpg',4.5,2,1,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Chelsea Home Kit 2019/2020 Short Sleeves','http://aobongda.net/pic/Product/f69c4751c_636935367044830712_HasThumb.jpg',4.5,2,2,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Chelsea Away Kit 2019/2020 Short Sleeves','http://aobongda.net/pic/Product/21265e418_636981824198638891_HasThumb.jpg',4.5,2,2,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Chelsea 3rd Kit 2019/2020 Short Sleeves','http://aobongda.net/pic/Product/1cac120f0_636903988113061725_HasThumb.jpg',4.5,2,2,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Barcelona Home Kit 2019/2020 Short Sleeves','http://aobongda.net/pic/Product/fed6111b9_636935369097468116_HasThumb.jpg',4.5,2,3,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Barcelona Away Kit 2019/2020 Short Sleeves','http://aobongda.net/pic/Product/1929941e2_637008633540391508_HasThumb.jpg',4.5,2,3,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Real Madrid Home Kit 2019/2020 Short Sleeves','http://aobongda.net/pic/Product/f9af6768a_636939681974900677_HasThumb.jpg',4.5,2,5,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Real Madrid Away Kit 2019/2020 Short Sleeves','http://aobongda.net/pic/Product/0f4baf803_636945448642727897_HasThumb.jpg',4.5,2,5,true);
-- Long Sleeves
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Liverpool Home Kit 2019/2020 Long Sleeves','http://aobongda.net/pic/Product/55d0c3e07_636934514464855926_HasThumb.jpg',7.5,1,7,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Liverpool Away Kit 2019/2020 Long Sleeves','http://aobongda.net/pic/Product/8a9c995ff_636969647346166382_HasThumb.jpg',7.5,1,7,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Juventus Home Kit 2019/2020 Long Sleeves','http://aobongda.net/pic/Product/6393ece5e_636927388757438775_HasThumb.jpg',7.5,1,9,true);
-- Accessories
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Adidas Predator Goalkeeper Gloves','http://aobongda.net/pic/Product/IMG_182_636672720217227224_HasThumb.jpg',15,3,12,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Nike Blue Goalkeeper Gloves','http://aobongda.net/pic/Product/IMG_163_636660976196346531_HasThumb.JPG',15,3,12,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Reusch Black Goalkeeper Gloves','http://aobongda.net/pic/Product/gang-tay-_636189654827998930_HasThumb.jpg',15,3,12,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Kamito Sakiro Ball Size 5','http://aobongda.net/pic/Product/93181476c_637043310459303761_HasThumb.jpg',25.2,3,12,true);
--Trophies, Medals
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Champions Cup 2018A','http://aobongda.net/pic/Product/Cup-bong-_636632773608250908_HasThumb.jpg',125,4,12,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Champions Cup 4060B','http://aobongda.net/pic/Product/cup-4046A_636632769794282761_HasThumb.jpg',125,4,12,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Golden Shoes','http://aobongda.net/pic/Product/cup-4046A_636632769794282761_HasThumb.jpg',50,4,12,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Medals','http://aobongda.net/pic/Product/huy-chuon_636191405535673681_HasThumb.jpg',1.75,4,12,true);
--Services
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('England National Team Print Font','http://aobongda.net/pic/Product/z10161270_636672736829587397_HasThumb.jpg',1,5,12,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('France National Team Print Font','http://aobongda.net/pic/Product/z10161270_636672737923399959_HasThumb.jpg',1,5,12,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Brazil National Team Print Font','http://aobongda.net/pic/Product/z10161270_636672735488240676_HasThumb.jpg',1,5,12,true);
INSERT INTO product(product_name,product_url,product_price,cat_id,team_id,status) VALUES ('Spain National Team Print Font','http://aobongda.net/pic/Product/z10161270_636672732359671732_HasThumb.jpg',1,5,12,true);
-- --Orders
INSERT INTO `orders` (`created_at`, `shipping_address`, `shipping_name`, `shipping_phone`, `status`, `total_price`, `updated_at`, `user_id`) VALUES ('2019-11-07 10:56:14', '9B Le Quy Don', 'Ngo Ngoc Nam', '0373924314', 0, 4.5, '2019-11-07 10:56:14', 1);
-- --Orders Detail
INSERT INTO `order_detail` (`item_total_price`, `quantity`, `size`, `order_id`, `product_id`) VALUES(7.5, 1, 'XL', 1, 11);
