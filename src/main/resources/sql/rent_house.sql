SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `community` CASCADE;

DROP TABLE IF EXISTS `renting_house` CASCADE;

CREATE TABLE `community`
(
  `info_id`        BIGINT      NOT NULL AUTO_INCREMENT,
  `source_id`      INT         NOT NULL,
  `community_code` VARCHAR(20) NOT NULL,
  `community_name` VARCHAR(50) NOT NULL,
  `latitude`       DECIMAL(10, 6),
  `longitude`      DECIMAL(10, 6),
  `city`           VARCHAR(10) NOT NULL,
  `district`       VARCHAR(20) NOT NULL,
  `block`          VARCHAR(20) NOT NULL,
  `md5`            VARCHAR(32) NOT NULL,
  `from_time`      TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `to_time`        TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status`         TINYINT     NOT NULL DEFAULT 2,
  CONSTRAINT `PK_community` PRIMARY KEY (`info_id`)
);

CREATE TABLE `renting_house`
(
  `info_id`           BIGINT      NOT NULL AUTO_INCREMENT,
  `source_id`         INT         NOT NULL,
  `house_code`        VARCHAR(20) NOT NULL,
  `title`             VARCHAR(50) NOT NULL,
  `bedroom_num`       TINYINT,
  `hall_num`          TINYINT,
  `orientation`       VARCHAR(10),
  `price_total`       INT,
  `rent_area`         DECIMAL(10, 2),
  `community_info_id` BIGINT      NOT NULL,
  `md5`               VARCHAR(32) NOT NULL,
  `from_time`         TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `to_time`           TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status`            TINYINT     NOT NULL DEFAULT 2,
  CONSTRAINT `PK_renting_house` PRIMARY KEY (`info_id`)
);

ALTER TABLE `renting_house`
  ADD CONSTRAINT `FK_renting_house_community`
FOREIGN KEY (`community_info_id`) REFERENCES `community` (`info_id`);

SET FOREIGN_KEY_CHECKS = 1
