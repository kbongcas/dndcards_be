---create spells table
CREATE TABLE spells(
    spell_id        INTEGER PRIMARY KEY,
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
    );

CREATE TABLE languages(
    lang_id         INT PRIMARY KEY,
    lang_name       VARCHAR,
    lang_type       VARCHAR
);

CREATE TABLE equipment_category(
    equipment_type  VARCHAR,
    equipment_name  VARCHAR
);

CREATE TABLE weapons(
    weapon_id       INT PRIMARY KEY,
    eq_cat          VARCHAR,
    weapon_name     VARCHAR,
    weapon_cate     VARCHAR,
    weapon_range    VARCHAR,
    category_range  VARCHAR,
    dam_dice_amnt   INT,
    damage_value    INT,
    damage_type     VARCHAR,
    range           INT,
    thrown_range_n  INT,
    thrown_range_l  INT
);

INSERT INTO spells(SELECT * FROM CSVREAD('data/spells/spells.csv'));
INSERT INTO languages(SELECT * FROM CSVREAD('data/languages/languages.csv')) ;
INSERT INTO equipment_category(SELECT * FROM CSVREAD('data/equipment/equipment_cate.csv'));
INSERT INTO weapons(SELECT * FROM CSVREAD('data/equipment/weapons.csv'));
