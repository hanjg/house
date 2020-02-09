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

ALTER TABLE `second_hand_house`
  ADD KEY `idx_md5` (`md5`);
ALTER TABLE `second_hand_house`
  ADD KEY `idx_from_time` (`from_time`);
ALTER TABLE `second_hand_house`
  ADD KEY `idx_to_time` (`to_time`);

CREATE TABLE `sh_house_deal`
(
  `info_id`           BIGINT      NOT NULL AUTO_INCREMENT,
  `source_id`         INT         NOT NULL,
  `house_code`        VARCHAR(32) NOT NULL,
  `origin_price`      BIGINT      NOT NULL,
  `final_price`       BIGINT      NOT NULL,
  `final_unit_price`  BIGINT      NOT NULL,
  `deal_time`         INT,
  `adjust_count`      INT,
  `look_count`        INT,
  `attention_count`   INT,
  `md5`               VARCHAR(32) NOT NULL,
  `gmt_modified`      TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`info_id`),
  KEY `idx_md5` (`md5`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='二手房交易记录';

CREATE TABLE `sh_house_district_summary`
(
  `info_id`           BIGINT      NOT NULL AUTO_INCREMENT,
  `district`          VARCHAR(20) NOT NULL,
  `avg_total_price`   DECIMAL(10, 2),
  `avg_unit_price`    DECIMAL(10, 2),
  `total_house_count` VARCHAR(32) NOT NULL,
  `info_time`         TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`info_id`),
  KEY `idx_time` (`info_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='二手房行政区汇总';

SET FOREIGN_KEY_CHECKS = 1
