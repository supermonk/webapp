-- /** User Info, one user only one address**/
CREATE TABLE IF NOT EXISTS ecommerce.STATE (
    id int NOT NULL AUTO_INCREMENT,
    abbrevation VARCHAR(2) NOT NULL,
    fullName VARCHAR(128) NOT NULL,
    CONSTRAINT pk PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS ecommerce.ADDRESS (
    id VARCHAR(256) NOT NULL,
    address1 VARCHAR(256) NOT NULL,
    address2 VARCHAR(256) DEFAULT '',
    stateId int NOT NULL,
    CONSTRAINT fkState FOREIGN KEY (stateId) REFERENCES ecommerce.STATE (id),
    CONSTRAINT pk PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS ecommerce.USER (
    id VARCHAR(256) NOT NULL,
    fname VARCHAR(256) NOT NULL,
    lname VARCHAR(256) NOT NULL,
    addressId VARCHAR(256) NOT NULL,
    CONSTRAINT fkAddress FOREIGN KEY (addressId) REFERENCES ecommerce.ADDRESS (id),
    CONSTRAINT pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ecommerce.PRODUCT (
    id VARCHAR(256) NOT NULL,
    productName VARCHAR(256) NOT NULL,
    productDescription VARCHAR (512) NOT NULL,
    price DOUBLE NOT NULL DEFAULT 0,
    CONSTRAINT pk PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS ecommerce.CATEGORY (
    id VARCHAR(256) NOT NULL,
    categoryName VARCHAR(256) NOT NULL,
    CONSTRAINT pk PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS ecommerce.PRODUCT_CATEGORY (
    id VARCHAR(256) NOT NULL,
    productId VARCHAR(256) NOT NULL,
    categoryId VARCHAR(256) NOT NULL,
    CONSTRAINT pk PRIMARY KEY (id),
    CONSTRAINT fkProduct FOREIGN KEY (productId) REFERENCES ecommerce.PRODUCT (id),
    CONSTRAINT fkCategory FOREIGN KEY (categoryId) REFERENCES ecommerce.CATEGORY (id)
);

INSERT into ecommerce.STATE (abbrevation,fullName)  values
('AL', 'Alabama'),
('AK', 'Alaska'),
('AZ', 'Arizona'),
('AR', 'Arkansas'),
('CA', 'California'),
('CO', 'Colorado'),
('CT', 'Connecticut'),
('DE', 'Delaware'),
('DC', 'District of Columbia'),
('FL', 'Florida'),
('GA', 'Georgia'),
('HI', 'Hawaii'),
('ID', 'Idaho'),
('IL', 'Illinois'),
('IN', 'Indiana'),
('IA', 'Iowa'),
('KS', 'Kansas'),
('KY', 'Kentucky'),
('LA', 'Louisiana'),
('ME', 'Maine'),
('MD', 'Maryland'),
('MA', 'Massachusetts'),
('MI', 'Michigan'),
('MN', 'Minnesota'),
('MS', 'Mississippi'),
('MO', 'Missouri'),
('MT', 'Montana'),
('NE', 'Nebraska'),
('NV', 'Nevada'),
('NH', 'New Hampshire'),
('NJ', 'New Jersey'),
('NM', 'New Mexico'),
('NY', 'New York'),
('NC', 'North Carolina'),
('ND', 'North Dakota'),
('OH', 'Ohio'),
('OK', 'Oklahoma'),
('OR', 'Oregon'),
('PA', 'Pennsylvania'),
('PR', 'Puerto Rico'),
('RI', 'Rhode Island'),
('SC', 'South Carolina'),
('SD', 'South Dakota'),
('TN', 'Tennessee'),
('TX', 'Texas'),
('UT', 'Utah'),
('VT', 'Vermont'),
('VA', 'Virginia'),
('WA', 'Washington'),
('WV', 'West Virginia'),
('WI', 'Wisconsin'),
('WY', 'Wyoming');