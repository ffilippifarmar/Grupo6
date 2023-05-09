CREATE TABLE bank_account
(
    account_number        VARCHAR(50) PRIMARY KEY,
    account_holder        VARCHAR(100)   NOT NULL,
    balance               DECIMAL(10, 2) NOT NULL,
    currency              VARCHAR(10)    NOT NULL,
    owner_name            VARCHAR(100)   NOT NULL,
    owner_address         VARCHAR(200)   NOT NULL,
    owner_phone_number    VARCHAR(20)    NOT NULL,
    account_type          VARCHAR(50)    NOT NULL,
    is_open               BOOLEAN        NOT NULL,
    last_transaction_date DATE
);


CREATE TABLE transactions
(
    transaction_id   SERIAL PRIMARY KEY,
    account_number   VARCHAR(50)    NOT NULL,
    transaction_type VARCHAR(50)    NOT NULL,
    amount           DECIMAL(10, 2) NOT NULL,
    currency         VARCHAR(10)    NOT NULL,
    transaction_date DATE           NOT NULL,
    description      VARCHAR(200)   NOT NULL,
    FOREIGN KEY (account_number) REFERENCES bank_account (account_number)
);