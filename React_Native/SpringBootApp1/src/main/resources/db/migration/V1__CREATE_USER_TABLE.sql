create table hitha_user (
    --user_id uuid default uuid_generate_v4 () primary key,
    phone_number char(10) primary key,
    aadhar_number char(12) unique,
    first_name varchar(255) not null,
    middle_name varchar(255),
    last_name varchar(255) not null,
    "language" char(3) not null
);