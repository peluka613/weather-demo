INSERT INTO location (id, lon, lat, city, state) VALUES (1, 2.0223, 2.3349, 'Dallas', 'Texas');
INSERT INTO location (id, lon, lat, city, state) VALUES (2, 1.7541, 2.3845, 'Los Angeles', 'California');
INSERT INTO location (id, lon, lat, city, state) VALUES (3, 2.0873, 3.3452, 'Phoenix', 'Arizona');
INSERT INTO location (id, lon, lat, city, state) VALUES (4, 2.3523, 2.3458, 'Seattle', 'Washington');
INSERT INTO location (id, lon, lat, city, state) VALUES (5, 3.5284, 2.8542, 'Kansas City', 'Missouri');

INSERT INTO weather_record (id, wdate, location) VALUES (37892, parsedatetime('2020-09-15', 'yyyy-MM-dd'), 1);

INSERT INTO temperature (weather, temperature) VALUES (37892, 30.0);
INSERT INTO temperature (weather, temperature) VALUES (37892, 2.1);
INSERT INTO temperature (weather, temperature) VALUES (37892, 11.2);