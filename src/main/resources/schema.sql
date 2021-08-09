CREATE TABLE IF NOT EXISTS `address` (
  `id` bigint(20) NOT NULL,
  `city` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `line_one` varchar(255) NOT NULL,
  `line_two` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `region` varchar(255) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `customer` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
);
