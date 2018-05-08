CREATE TABLE users(
    --user_id         BIGSERIAL PRIMARY KEY,
    user_name       VARCHAR PRIMARY KEY,
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
    user_name       VARCHAR,
    spell_id        BIGINT,
    FOREIGN KEY(user_name) REFERENCES users(user_name) ON DELETE CASCADE,
    FOREIGN KEY(spell_id) REFERENCES spells(spell_id) ON DELETE CASCADE
);

CREATE TABLE items(
    item_id     BIGSERIAL PRIMARY KEY,
    item_name   VARCHAR,
    item_type   VARCHAR,
    item_cost   VARCHAR,
    item_weight VARCHAR,
    item_desc   CLOB
);

CREATE TABLE has_item(
    user_name       VARCHAR,
    item_id         BIGINT,
    FOREIGN KEY(user_name) REFERENCES users(user_name) ON DELETE CASCADE,
    FOREIGN KEY(item_id) REFERENCES items(item_id) ON DELETE CASCADE
);

INSERT INTO spells(SELECT * FROM CSVREAD('data/spells/spells.csv'));

--this is test data
INSERT INTO users( user_name) VALUES ('kev');
INSERT INTO users( user_name) VALUES ('erk');
INSERT INTO users( user_name) VALUES ('Anthony');
INSERT INTO users( user_name) VALUES ('Tommy');
INSERT INTO users( user_name) VALUES ('Jack');
INSERT INTO users( user_name) VALUES ('Steven');
INSERT INTO users( user_name) VALUES ('Eric');
INSERT INTO has_spell( user_name, spell_id) VALUES ('kev', 238);
INSERT INTO has_spell( user_name, spell_id) VALUES ('kev', 239);
INSERT INTO has_spell( user_name, spell_id) VALUES ('kev', 9);
INSERT INTO has_spell( user_name, spell_id) VALUES ('kev', 4);
INSERT INTO has_spell( user_name, spell_id) VALUES ('erk', 38);
INSERT INTO has_spell( user_name, spell_id) VALUES ('erk', 28);
INSERT INTO has_spell( user_name, spell_id) VALUES ('erk', 23);

INSERT INTO items( item_id, item_name, item_desc) VALUES (1, 'Ring of Truth', 'The bearer tell the truth');
INSERT INTO items( item_id, item_name, item_desc) VALUES (2, 'Ring of Lies', 'The bearer tells lies');


INSERT INTO has_item( user_name, item_id) VALUES ('erk', 1);
INSERT INTO has_item( user_name, item_id) VALUES ('erk', 2);
