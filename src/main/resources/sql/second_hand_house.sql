SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `second_hand_house` CASCADE;

CREATE TABLE `second_hand_house`
(
  `info_id`           BIGINT      NOT NULL AUTO_INCREMENT,
  `source_id`         INT         NOT NULL,
  `house_code`        VARCHAR(32) NOT NULL,
  `title`             VARCHAR(50) NOT NULL,
  `bedroom_num`       TINYINT,
  `hall_num`          TINYINT,
  `orientation`       VARCHAR(32),
  `price_total`       INT,
  `unit_price`        INT,
  `area`         DECIMAL(10, 2),
  `community_info_id` BIGINT      NOT NULL,
  `md5`               VARCHAR(32) NOT NULL,
  `from_time`         TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `to_time`           TIMESTAMP   NOT NULL,
  `status`            TINYINT     NOT NULL DEFAULT 2,
  CONSTRAINT `PK_second_hand_house` PRIMARY KEY (`info_id`)
);

ALTER TABLE `second_hand_house`
  ADD CONSTRAINT `FK_second_hand_house_community`
FOREIGN KEY (`community_info_id`) REFERENCES `community` (`info_id`);

SET FOREIGN_KEY_CHECKS = 1
