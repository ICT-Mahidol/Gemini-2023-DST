create database Gemini ;

use Gemini ;

# About  Controller --> LoginController  Model--> Astronomer , ScienceObserver , User
CREATE TABLE users (
    username VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255)
);
# About  Controller --> SciencePlanController   Model--> SciencePlan , DataProcessRequirment
CREATE TABLE science_plans (
    id INT PRIMARY KEY AUTO_INCREMENT,
    plan_no INT ,
    creator VARCHAR(255),
    submitter VARCHAR(255),
    funding_inusd double,
    objectives TEXT,
    star_system VARCHAR(255),
    start_date Date,
    end_date Date,
    telescope_location VARCHAR(255),
    status VARCHAR(50)
);
# run ตัยนี้ด้วย เชื่อมใน Science plan
CREATE TABLE data_proc_requirements (
    id SERIAL PRIMARY KEY,
    file_type VARCHAR(255),
    file_quality VARCHAR(255),
    color_type VARCHAR(255),
    contrast DOUBLE PRECISION,
    brightness DOUBLE PRECISION,
    saturation DOUBLE PRECISION,
    highlights DOUBLE PRECISION,
    exposure DOUBLE PRECISION,
    shadows DOUBLE PRECISION,
    whites DOUBLE PRECISION,
    blacks DOUBLE PRECISION,
    luminance DOUBLE PRECISION,
    hue DOUBLE PRECISION
);

# About  Controller --> ObservingProgramController   Model--> ObservingProgram
CREATE TABLE observing_program (
    id INT AUTO_INCREMENT PRIMARY KEY,
    calibration_unit VARCHAR(255),
    f_stop DOUBLE,
    gemini_location VARCHAR(255),
    light_type VARCHAR(255),
    module_content INT,
    optics_primary VARCHAR(255),
    optics_secondaryrms INT,
    plan_no INT,
    science_fold_mirror_degree INT,
    science_fold_mirror_type VARCHAR(255),
    validation_status INT
);

# ใส่ค่าเข้าไปให้ Run usersจะได้มีข้อมูล
INSERT INTO users (username , password ,role )
VALUES 	("astro01" , "123" , "astronomer" ),
		("astro02" , "123" , "astronomer" ),
		("astro03" , "123" , "astronomer" ),
        ("astro04" , "123" , "astronomer" ),
        ("astro05" , "123" , "astronomer" ),
        ("John Doe" , "123" , "astronomer" ),
        ("Jane Dunn" , "123" , "astronomer" ),
        ("Andrew Griffin" , "123" , "astronomer" ),
        ("sciobser01","123","scienceobserver"),
        ("sciobser02","123","scienceobserver");
        
        
        
        
        
# ใส่ค่าเข้าไปให้ Run All Science plan จะได้มีข้อมูล
INSERT INTO science_plans (plan_no, creator, submitter, funding_inusd, objectives, star_system, start_Date, end_Date, telescope_location, status)
VALUES (1, 'John Doe', 'John Doe', 1000.0, '1. To explore Neptune. 2. To collect astronomical data for future research.', 'Andromeda', '2024-04-11 09:00:00', '2024-04-12 10:00:00', 'HAWAII', 'SAVED'),
       (2, 'Jane Dunn', 'Andrew Griffin', 2500.0, '1. To explore Mars. 2. To collect astronomical data for future research.', 'Antlia', '2024-04-13 13:00:00', '2024-04-14 15:00:00', 'CHILE', 'SAVED'),
 (3, 'astro01', 'astro02', 2400.0, '1. To explore Earth. 2. To collect astronomical data for future research.', 'Leo', '2024-04-15 09:00:00', '2024-04-16 10:00:00', 'CHILE', 'TESTED'),
       (4, 'astro03', 'astro04', 1800.0, '1. To explore Moon 21. 2. To collect astronomical data for future research.', 'Microscopium', '2024-04-15 09:00:00', '2024-04-16 10:00:00', 'HAWAII', 'TESTED');


# ใส่ค่าเข้าไปให้ Run All Observeung Program จะได้มีข้อมูล
INSERT INTO observing_program (id, calibration_unit, f_stop, gemini_location, light_type, module_content, optics_primary, optics_secondaryrms, plan_no, science_fold_mirror_degree, science_fold_mirror_type, validation_status) VALUES
('1', 'Xenon', '5.5', NULL, 'MaunaKeaSkyEmission', '2', 'GSZ', '12', '2', '0', 'REFLECTIVE_CONVERGING_BEAM', 1),
('2', 'Argon', '5.5', 'S', 'MaunaKeaSkyEmission', '1', 'GSZ', '12', '2', '0', 'REFLECTIVE_CONVERGING_BEAM', 0),
('3', 'Xenon', '5.5', NULL, 'MaunaKeaSkyEmission', '2', 'GSZ', '12', '2', '0', 'REFLECTIVE_CONVERGING_BEAM', 1);


select * from users ;
select * from astronomer ;
select * from science_observer ;

select * from science_plans ;
select * from data_proc_requirements ;
select * from observing_program ;







SET SQL_SAFE_UPDATES = 0;

DELETE FROM users ;
DELETE FROM science_plans WHERE plan_no="7" ;
-- and creator="astro03";
DELETE FROM users WHERE username = "sciobser01";
drop table science_plans ;
ALTER TABLE data_proc_requirements DROP FOREIGN KEY FKc0lhsh4pv5rieoxr2p9ua1e5f;