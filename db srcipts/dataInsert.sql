INSERT INTO `address` (`address_id`, `street`, `city`, `state`, `country`, `zip`, `is_deleted`) VALUES (NULL, 'Flat: X, Road: Y, Block: Z', 'Irvine', 'California', 'USA', '92602', '0');
INSERT INTO `address` (`address_id`, `street`, `city`, `state`, `country`, `zip`, `is_deleted`) VALUES (NULL, 'Flat: A, Road: B, Block: C', 'Los Angles', 'California', 'USA', '90001', '0');
INSERT INTO `address` (`address_id`, `street`, `city`, `state`, `country`, `zip`, `is_deleted`) VALUES (NULL, 'Flat: I, Road: J, Block: K', 'Dhaka', 'Dhaka', 'Bangladesh', '1216', '0');


INSERT INTO `adult` (`adult_id`, `first_name`, `last_name`, `address_id`, `is_deleted`) VALUES (NULL, 'Eris', 'Eris', '1', '0');
INSERT INTO `adult` (`adult_id`, `first_name`, `last_name`, `address_id`, `is_deleted`) VALUES (NULL, 'Chrissy', 'Coztanza', '2', '0');
INSERT INTO `adult` (`adult_id`, `first_name`, `last_name`, `address_id`, `is_deleted`) VALUES (NULL, 'Tamim', 'Iqbal', '3', '0');

INSERT INTO `child` (`child_id`, `adult_id`, `first_name`, `last_name`, `is_deleted`) VALUES (NULL, '1', 'Eris', 'Jr', '0');
INSERT INTO `child` (`child_id`, `adult_id`, `first_name`, `last_name`, `is_deleted`) VALUES (NULL, '1', 'Robert', 'Bruce', '0');