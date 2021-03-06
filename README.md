[![Build Status](https://travis-ci.com/Sajed49/Family.svg?branch=main)](https://travis-ci.com/Sajed49/Family)
[![Maintainability](https://api.codeclimate.com/v1/badges/920ee5408d29abb3970c/maintainability)](https://codeclimate.com/github/Sajed49/Family/maintainability)
[![license](http://img.shields.io/badge/license-MIT-brightgreen.svg)](https://github.com/Sajed49/Family)
[![HitCount](http://hits.dwyl.com/Sajed49/https://githubcom/Sajed49/Familygit.svg)](http://hits.dwyl.com/Sajed49/https://githubcom/Sajed49/Familygit)

[![Generic badge](https://img.shields.io/badge/Java-11.0-Blue.svg)](https://shields.io/)
[![Generic badge](https://img.shields.io/badge/Maven-3.6.3-Blue.svg)](https://shields.io/)

# Family

An PoC project for web based family information

## How to run on ubuntu
1. Open a terminal (ctrl+alt+T)
2. git clone https://github.com/Sajed49/Family.git
3. cd Family
4. sudo apt update
5. Install & setup mysql
   1. sudo apt install mysql-server
   2. sudo mysql_secure_installation
   3. Select password as **Archi@49**
   4. Execute the .sql scripts inside the "db scripts" folder. This will load data into database.
    Firstly, **dbAndTableCreation.sql** and then **dataInsert.sql**
6. apt-get install openjdk-11-jdk
   1. If you have other jdk installed please switch to jdk11
7. apt-get install maven
8. mvn clean install
9. mvn spring-boot:run
   1. For running with other profiles change the profile settings in pom.xml
10. The server will start at 8080
11. Go to http://localhost:8080/family/swagger-ui/ in your browser
12. Here you can test the API's provided with documentation.


## Testing
1. To run the Unit and integration tests type **mvn test** in the terminal and enter.
