SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `community` CASCADE;

DROP TABLE IF EXISTS `renting_house` CASCADE;

CREATE TABLE `community`
(
  `community_id`   BIGINT      NOT NULL,
  `community_name` VARCHAR(50) NOT NULL,
  `latitude`       DECIMAL(10, 6),
  `longitude`      DECIMAL(10, 6),
  `city`           VARCHAR(10) NOT NULL,
  `district`       VARCHAR(20) NOT NULL,
  `area`           VARCHAR(20) NOT NULL,
  `create_time`    DATETIME    NOT NULL,
  `update_time`    DATETIME    NOT NULL,
  `md5`            VARCHAR(32) NOT NULL,
  CONSTRAINT `PK_community` PRIMARY KEY (`community_id`)
);

CREATE TABLE `renting_house`
(
  `house_source_id` INT         NOT NULL,
  `house_code`      VARCHAR(20) NOT NULL,
  `title`           VARCHAR(50) NOT NULL,
  `bedroom_num`     TINYINT,
  `hall_num`        TINYINT,
  `orientation`     VARCHAR(10),
  `price_total`     INT,
  `rent_area`       DECIMAL(10, 2),
  `community_id`    BIGINT      NOT NULL,
  `create_time`     DATETIME    NOT NULL,
  `update_time`     DATETIME    NOT NULL,
  `md5`             VARCHAR(32) NOT NULL,
  `is_new`          BOOLEAN     NOT NULL DEFAULT TRUE,
  CONSTRAINT `PK_renting_house` PRIMARY KEY (`house_code`, `house_source_id`)
);

ALTER TABLE `renting_house`
  ADD CONSTRAINT `FK_renting_house_community`
FOREIGN KEY (`community_id`) REFERENCES `community` (`community_id`);

SET FOREIGN_KEY_CHECKS = 1
