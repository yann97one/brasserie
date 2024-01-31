CREATE TABLE BRASSERIE (
                           id_brasserie INT AUTO_INCREMENT PRIMARY KEY,
                           nom VARCHAR(50) NOT NULL,
                           adresse VARCHAR(50),
                           coord_gps VARCHAR(50),
                           dt_ouverture DATE
);

CREATE TABLE BIERE (
    id_biere INT AUTO_INCREMENT PRIMARY KEY,
    id_brasserie INT,
    nom VARCHAR(50) NOT NULL,
    ty_biere VARCHAR(50),
    description VARCHAR(200),
    dg_alcool FLOAT,
    note INT,
    CONSTRAINT fk_brasserie FOREIGN KEY (id_brasserie) REFERENCES BRASSERIE
);

