# gibdd-web-services

Course project demonstrating SOAP web services. The next step is combining services in BPEL process as example of SOA architecture.

## Languages

This project is authored in Java.

## Installation

### Fork the Repository

Fork the [gibdd-web-services](https://github.com/deathman92/gibdd-web-services) on GitHub.  Clone the project to the host machine.

### Dependencies

The project requires the following dependencies be installed on the host machine:

* Java Development Kit 8
* Gradle 2.4 or later

### Run

#### gradlew clean build -x test

* builds all projects

#### gradlew :[name of the project]:flywayMigrate

* generate database and tables for project

#### gradlew :[name of the project]:bootRun

* runs dev server for project

### Gradle tasks

#### gradlew :web-services-common:xjc

* generates classes from common schemas

#### gradlew :[name of the project]:xjc

* generate classes for project schemas

## License

Copyright (C) 2016  Victor Zhivotikov

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.