CREATE TABLE POST
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    title   VARCHAR(400) NOT NULL,
    content VARCHAR(2000) NULL,
    created timestamp
);

CREATE TABLE COMMENT
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(2000) NULL ,
    post_id BIGINT NOT NULL,
    created timestamp
);

ALTER TABLE COMMENT
    ADD CONSTRAINT comment_post_id
        FOREIGN KEY (post_id) REFERENCES post (id)
