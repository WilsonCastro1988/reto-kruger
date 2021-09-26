-- vaccination.kgrt_employee definition

-- Drop table

-- DROP TABLE vaccination.kgrt_employee;

CREATE TABLE vaccination.kgrt_employee (
	employeev_dni varchar(255) NOT NULL,
	audid_creation_date date NULL,
	audid_delete_date date NULL,
	audid_modification_date date NULL,
	audiv_user_creation varchar(255) NULL,
	audiv_user_delete varchar(255) NULL,
	audiv_user_modification varchar(255) NULL,
	employeeb_active bool NULL,
	employeed_birth_date date NULL,
	employeev_adrress varchar(255) NULL,
	employeev_lastname varchar(255) NULL,
	employeev_mail varchar(255) NULL,
	employeev_name varchar(255) NULL,
	employeev_phone varchar(255) NULL,
	flagemployeev_user varchar(255) NULL,
	CONSTRAINT kgrt_employee_pkey PRIMARY KEY (employeev_dni)
);


-- vaccination.kgrt_vaccine definition

-- Drop table

-- DROP TABLE vaccination.kgrt_vaccine;

CREATE TABLE vaccination.kgrt_vaccine (
	vaccinel_id bigserial NOT NULL,
	audid_creation_date date NULL,
	audid_delete_date date NULL,
	audid_modification_date date NULL,
	audiv_user_creation varchar(255) NULL,
	audiv_user_delete varchar(255) NULL,
	audiv_user_modification varchar(255) NULL,
	vaccineb_active bool NULL,
	vaccinev_lot varchar(255) NULL,
	vaccinev_name varchar(255) NULL,
	CONSTRAINT kgrt_vaccine_pkey PRIMARY KEY (vaccinel_id)
);


-- vaccination.kgrt_vaccination definition

-- Drop table

-- DROP TABLE vaccination.kgrt_vaccination;

CREATE TABLE vaccination.kgrt_vaccination (
	vaccinationl_id bigserial NOT NULL,
	audid_creation_date date NULL,
	audid_delete_date date NULL,
	audid_modification_date date NULL,
	audiv_user_creation varchar(255) NULL,
	audiv_user_delete varchar(255) NULL,
	audiv_user_modification varchar(255) NULL,
	vaccinationb_active bool NULL,
	vaccinationd_date date NULL,
	vaccinationi_dose int4 NULL,
	vaccinationv_observation varchar(255) NULL,
	vaccinationv_path_license varchar(255) NULL,
	employeev_dni varchar(255) NULL,
	vaccinel_id int8 NULL,
	CONSTRAINT kgrt_vaccination_pkey PRIMARY KEY (vaccinationl_id),
	CONSTRAINT fka68pc6k2qyvft7n87t66axkem FOREIGN KEY (employeev_dni) REFERENCES vaccination.kgrt_employee(employeev_dni),
	CONSTRAINT fkmvripy034r5wa00mbwebl6ccw FOREIGN KEY (vaccinel_id) REFERENCES vaccination.kgrt_vaccine(vaccinel_id)
);


-- vaccination.kgrt_vaccination_status definition

-- Drop table

-- DROP TABLE vaccination.kgrt_vaccination_status;

CREATE TABLE vaccination.kgrt_vaccination_status (
	vaccination_statusl_id bigserial NOT NULL,
	audid_creation_date date NULL,
	audid_delete_date date NULL,
	audid_modification_date date NULL,
	audiv_user_creation varchar(255) NULL,
	audiv_user_delete varchar(255) NULL,
	audiv_user_modification varchar(255) NULL,
	vaccination_statusb_active bool NULL,
	vaccination_statusv_name varchar(255) NULL,
	vaccination_statusv_observation varchar(255) NULL,
	vaccinationl_id int8 NULL,
	CONSTRAINT kgrt_vaccination_status_pkey PRIMARY KEY (vaccination_statusl_id),
	CONSTRAINT fk6ixtgqw0me1yc01t40dva3ivr FOREIGN KEY (vaccinationl_id) REFERENCES vaccination.kgrt_vaccination(vaccinationl_id)
);