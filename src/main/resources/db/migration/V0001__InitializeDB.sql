CREATE TABLE spells(
    alph_num_name   VARCHAR PRIMARY KEY,
    spell_name      VARCHAR,
    ritual          BIT,
    name_ritual     VARCHAR,
    level           INT,
    school          VARCHAR,
    level_school    VARCHAR,
    casting_time    VARCHAR,
    range           VARCHAR,
    duration        VARCHAR,
    components      VARCHAR,
    materials       VARCHAR,
    spell_desc      CLOB,
    higher_level    CLOB,
    higher_desc     CLOB,
    save            VARCHAR,
    class           VARCHAR,
    book            VARCHAR,
    page            VARCHAR,
    book_page       VARCHAR
    );

INSERT INTO spells(SELECT * FROM CSVREAD('data/spells/spells.csv'));

CREATE TABLE languages(
    lang_id         INT PRIMARY KEY,
    lang_name       VARCHAR,
    lang_type       VARCHAR
);

INSERT INTO languages(SELECT * FROM CSVREAD('data/languages/languages.csv')) ;
