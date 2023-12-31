-- auto-generated definition
create table product
(
    id     int auto_increment
        primary key,
    title  varchar(255) not null comment '书名',
    author varchar(255) not null comment '作者',
    price  double       not null comment '价格',
    picture varchar(255) not null comment '图片'
)
    comment '商品';

-- auto-generated definition
create table cart
(
    id       int auto_increment comment 'ID'
        primary key,
    userId   int not null comment '用户ID',
    bookId   int not null comment '书本ID',
    quantity int not null comment '数量'
)
    comment '购物车';


-- auto-generated definition
create table `order`
(
    id         int auto_increment comment '订单号'
        primary key,
    userId     int    not null comment '用户号',
    productId  int    not null comment '书号',
    quantity   int    not null comment '数量',
    totalPrice double not null comment '总金额',
    orderDate  date   not null comment '订单创建时间'
)
    comment '订单';


-- auto-generated definition
create table inventory
(
    id        int auto_increment
        primary key,
    productId int not null comment '商品号',
    quantity  int not null comment '数目'
)
    comment '库存';

CREATE TABLE user
(
    id       int auto_increment comment '用户ID' primary key,
    username varchar(255) not null comment '用户名',
    password varchar(255) not null comment '密码',
    role     int not null comment '用户角色，0表示普通用户，1表示管理员'
)
    comment '用户/管理员';