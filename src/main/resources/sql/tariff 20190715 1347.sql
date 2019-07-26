--
-- Скрипт сгенерирован Devart dbForge Studio for MySQL, Версия 8.0.80.0
-- Домашняя страница продукта: http://www.devart.com/ru/dbforge/mysql/studio
-- Дата скрипта: 15.07.2019 13:47:23
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
-- Создать таблицу `user`
--
CREATE TABLE IF NOT EXISTS user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
  tariff varchar(50) NOT NULL,
  balance decimal(10, 2) DEFAULT 0.00,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 6,
CHARACTER SET utf8,
COLLATE utf8_general_ci,
COMMENT = 'данные о пользователях';

-- 
-- Вывод данных для таблицы user
--
INSERT INTO user VALUES
(1, 'Иван', 'Николаев', 'MTC', 2.10),
(2, 'Рита', 'Сергеенко', 'WELCOM', 12.50),
(3, 'Олег', 'Романович', 'МТС', 13.74),
(4, 'Наталья', 'Ивановна', 'WELCOM', 7.18),
(5, 'Ирина', 'Сидоренко', 'МТС', 3.55);

-- 
-- Восстановить предыдущий режим SQL (SQL mode)
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- Включение внешних ключей
-- 
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;