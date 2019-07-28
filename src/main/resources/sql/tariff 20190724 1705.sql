--
-- Скрипт сгенерирован Devart dbForge Studio for MySQL, Версия 8.0.80.0
-- Домашняя страница продукта: http://www.devart.com/ru/dbforge/mysql/studio
-- Дата скрипта: 24.07.2019 17:05:46
-- Версия сервера: 5.7.25-log
-- Версия клиента: 4.1
--

-- 
-- Отключение внешних ключей
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- Установить режим SQL (SQL mode)
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 
-- Установка кодировки, с использованием которой клиент будет посылать запросы на сервер
--
SET NAMES 'utf8';

DROP DATABASE IF EXISTS tariff;

CREATE DATABASE IF NOT EXISTS tariff
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Установка базы данных по умолчанию
--
USE tariff;

--
-- Создать таблицу `client`
--
CREATE TABLE IF NOT EXISTS client (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 6,
CHARACTER SET utf8,
COLLATE utf8_general_ci,
COMMENT = 'данные о пользователях';

--
-- Создать таблицу `tariff`
--
CREATE TABLE IF NOT EXISTS tariff (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  user_id bigint(20) NOT NULL,
  tariff varchar(25) NOT NULL,
  balance decimal(10, 2) NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 10,
CHARACTER SET utf8,
COLLATE utf8_general_ci,
COMMENT = 'содержит все тарифы для каждого пользователя';

--
-- Создать внешний ключ
--
ALTER TABLE tariff
ADD CONSTRAINT FK_tariff_to_user_id FOREIGN KEY (user_id)
REFERENCES client (id);

-- 
-- Вывод данных для таблицы client
--
INSERT INTO client VALUES
(1, 'Иван', 'Николаев'),
(2, 'Рита', 'Сергеенко'),
(3, 'Олег', 'Романович'),
(4, 'Наталья', 'Ивановна'),
(5, 'Ирина', 'Сидоренко');

-- 
-- Вывод данных для таблицы tariff
--
INSERT INTO tariff VALUES
(1, 1, 'MTC', 2.15),
(2, 2, 'MTC', 0.50),
(3, 2, 'WELCOM', 2.13),
(4, 3, 'Life', 12.00),
(5, 3, 'WELCOM', 0.50),
(6, 3, 'MTC', 1.18),
(7, 4, 'WELCOM', 4.21),
(8, 5, 'WELCOM', 2.15),
(9, 5, 'MTC', 3.74);

-- 
-- Восстановить предыдущий режим SQL (SQL mode)
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- Включение внешних ключей
-- 
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;