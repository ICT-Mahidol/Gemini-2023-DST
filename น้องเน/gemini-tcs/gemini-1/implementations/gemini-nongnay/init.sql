CREATE TABLE science_plans (
                               plan_no SERIAL PRIMARY KEY,
                               creator VARCHAR(255),
                               end_date VARCHAR(255),
                               funding_inusd DOUBLE PRECISION,
                               objectives TEXT,
                               star_system VARCHAR(255),
                               start_date VARCHAR(255),
                               status VARCHAR(255),
                               submitter VARCHAR(255),
                               telescope_location VARCHAR(255)
);


INSERT INTO science_plans (plan_no, creator, end_date, funding_inusd, objectives, star_system, start_date, status, submitter, telescope_location) VALUES
                                                                                                                                                      (DEFAULT, 'Supasan', '2024-12-31', 100000, 'To study planets', 'Alpha Centauri', '2024-01-01', 'ACTIVE', 'Lalisa', 'Mauna Kea Sky Emission'),
                                                                                                                                                      (DEFAULT, 'Ben', '2024-12-31', 100000, 'To study milky way', 'Alpha Centauri', '2024-01-01', 'ACTIVE', 'Max', 'Mauna Kea Sky Emission');
