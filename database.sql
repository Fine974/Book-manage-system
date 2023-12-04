-- auto-generated definition
create table product
(
    id     int auto_increment
        primary key,
    title  varchar(255) not null comment '书名',
    author varchar(255) not null comment '作者',
    price  double       not null comment '价格'
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
    orderId    int auto_increment comment '订单号'
        primary key,
    userId     int    not null comment '用户号',
    bookId     int    not null comment '书号',
    quantity   int    not null comment '数量',
    totalPrice double not null comment '总金额'
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

