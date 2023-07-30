CREATE TABLE IF NOT EXISTS users
(
    user_id    UUID         NOT NULL,
    email      varchar(50)  NOT NULL UNIQUE,
    password   varchar(100) NOT NULL,
    first_name varchar(45)  NOT NULL,
    last_name  varchar(45)  NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS items
(
    item_id        UUID           NOT NULL,
    label          varchar(50)    NOT NULL,
    description    varchar(200)   NOT NULL,
    price          numeric(12, 2) NOT NULL,
    stock_quantity integer        NOT NULL,
    CONSTRAINT items_pkey PRIMARY KEY (item_id)
);

CREATE TABLE IF NOT EXISTS wishlist_items
(
    wishlist_items_id UUID NOT NULL,
    user_id UUID         NOT NULL,
    item_id          UUID         NOT NULL,
    note             varchar(200),
    added_date       timestamp(6) NOT NULL,
    enabled          boolean      NOT NULL,
    CONSTRAINT wishlist_items_pkey PRIMARY KEY (wishlist_items_id),
    CONSTRAINT fk_wishlist_items_users FOREIGN KEY (user_id) REFERENCES users (user_id),
    CONSTRAINT fk_wishlist_items_items FOREIGN KEY (item_id) REFERENCES items (item_id)
);