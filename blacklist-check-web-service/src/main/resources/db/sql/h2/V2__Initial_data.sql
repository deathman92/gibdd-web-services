insert into Citizen(id, firstname, middlename, lastname, gender, birthday, birthplace,
                    series, number, issuedate, issuedby, region, district, city, address, date)
values(111, 'Guy', 'Very', 'Bad', 'male', '1991-2-2', 'Place',
            '1111', '111111', '2011-2-2', 'Place', 'Region', 'District', 'City', 'Address', '2001-2-2');

insert into Vehiclepass(id, vin, model, type, category, enginenumber,
                        chassisnumber, builtyear, bodynumber, bodycolor)
values(111, 'ABCDEFG1234567890', 'Truck', 'Truck', 'C', 'ZYX987',
       'ZYX987', 1981, 'ZYX987', 'Red');

insert into Citizenblacklist(statusmessage, record_id) values('Terrorist!', 111);

insert into Citizenblacklist(statusmessage, record_id) values('Gangster!', 111);

insert into Vehicleblacklist(statusmessage, record_id) values('Stolen', 111);