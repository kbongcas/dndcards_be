CREATE TABLE users(
    user_id         BIGSERIAL PRIMARY KEY,
    user_name       VARCHAR,
);

CREATE TABLE characters(
    char_id         BIGSERIAL PRIMARY KEY,
    char_name       VARCHAR,
    created_on      datetime not null default NOW(),
    last_updated    datetime
);

CREATE TABLE has_characters(
    user_id         BIGINT,
    char_id         BIGINT,
    FOREIGN KEY(user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY(char_id) REFERENCES characters(char_id) ON DELETE CASCADE
);

CREATE TABLE ability_scores_set(
    char_id     BIGSERIAL PRIMARY KEY,
    str_score   INT DEFAULT 0,
    dex_score   INT DEFAULT 0,
    con_score   INT DEFAULT 0,
    int_score   INT DEFAULT 0,
    wis_score   INT DEFAULT 0,
    chr_score   INT DEFAULT 0,
    FOREIGN KEY(char_id) REFERENCES characters(char_id) ON DELETE CASCADE
);

---create spells table
CREATE TABLE spells(
    spell_id        BIGSERIAL PRIMARY KEY,
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

CREATE TABLE has_spell(
    char_id         BIGINT,
    spell_id        BIGINT,
    FOREIGN KEY(char_id) REFERENCES characters(char_id) ON DELETE CASCADE,
    FOREIGN KEY(spell_id) REFERENCES spells(spell_id) ON DELETE CASCADE
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

--this is test data
INSERT INTO users( user_name) VALUES ('Kevin');
INSERT INTO users( user_name) VALUES ('Erkan');
INSERT INTO users( user_name) VALUES ('Anthony');
INSERT INTO users( user_name) VALUES ('Tommy');
INSERT INTO users( user_name) VALUES ('Jack');
INSERT INTO users( user_name) VALUES ('Steven');
INSERT INTO users( user_name) VALUES ('Eric');
INSERT INTO characters( char_name ) VALUES ('Mentos');
INSERT INTO characters( char_name ) VALUES ('Solden');
INSERT INTO characters( char_name ) VALUES ('Khronos');
INSERT INTO characters( char_name ) VALUES ('Creed');
INSERT INTO characters( char_name ) VALUES ('Kneecap');
INSERT INTO characters( char_name ) VALUES ('Leoz');
INSERT INTO characters( char_name ) VALUES ('Ethanol');
INSERT INTO has_characters( user_id, char_id) VALUES ( 1, 1);
INSERT INTO has_characters( user_id, char_id) VALUES ( 2, 2);
INSERT INTO has_characters( user_id, char_id) VALUES ( 3, 3);
INSERT INTO has_characters( user_id, char_id) VALUES ( 4, 4);
INSERT INTO has_characters( user_id, char_id) VALUES ( 5, 5);
INSERT INTO has_characters( user_id, char_id) VALUES ( 6, 6);
INSERT INTO has_characters( user_id, char_id) VALUES ( 7, 7);
INSERT INTO has_spell( char_id, spell_id) VALUES (1, 238);
INSERT INTO has_spell( char_id, spell_id) VALUES (2, 205);
INSERT INTO has_spell( char_id, spell_id) VALUES (3, 348);
INSERT INTO has_spell( char_id, spell_id) VALUES (4, 197);
INSERT INTO has_spell( char_id, spell_id) VALUES (6, 220);
INSERT INTO has_spell( char_id, spell_id) VALUES (7, 155);
INSERT INTO ability_scores_set(char_id, str_score) VALUES (1, 10);
INSERT INTO ability_scores_set(char_id, str_score) VALUES (2, 10);
INSERT INTO ability_scores_set(char_id, str_score) VALUES (3, 10);
INSERT INTO ability_scores_set(char_id, str_score) VALUES (4, 10);
INSERT INTO ability_scores_set(char_id, str_score) VALUES (5, 10);
INSERT INTO ability_scores_set(char_id, str_score) VALUES (6, 10);
INSERT INTO ability_scores_set(char_id, str_score) VALUES (7, 10);
