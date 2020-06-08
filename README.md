# trainingcenter
Basic Spring boot rest api project

This is the zip file for the Training Center API.
Setup:
Change in application.properties: The details of SQL DB as you want to configure.
This project is Created in intellij ide. Tech used: Core Java, MySQL, Spring BOOT, Spring MVC and other Spring projects.
Open your ide and import as maven project.
Run the application.

You can create jar and run:
Prerequisite:
1. JDK 1.8+
2. Maven installed
Steps:
1. Extract this zip.
2. Find application.properties and put your mysql details.
3. open cmd in this location and run "mvn clean install"
4. Go to target folder in cmd and run: "java -jar <jar_name>"
5. Go to URL:http://localhost:8080/trainingcenter/ 

There are two API's currently
-Post
	Add Any training center.
	Be sure to follow validations.
	If some error, then it will be displayed.
	Remember to set content type in header.
	-Content-Type application/json
	
	JSON format for successfull post request:
	{
        "uuid": "3473dc31-afd9-4970-a6b7-0817d72f872e",
        "centerName": "rterretfdfdgfgdfubh",
        "centerCode": "BOkjf5dffdeg",
        "capacity": 12,
        "courses": [
            "Spring",
            "Java"
        ],
        "createdOn": 1591626298804,
        "contactEmail": "myemail@gmail.com",
        "contactPhone": "9875882158",
        "addresses": {
            "addressLine1": "9257",
            "addressLine2": "100",
            "city": "Allahabad",
            "state": "12",
            "country": "21",
            "zipCode": "708451"
        }
    }
	
-Get
	Fetches all training center and its details in json format.
	
	
Some features:
Primary key is UUID. It will be generated automatically.
Creation date is generated automatically.
All validations mentioned in documents are done and exception will be displayed for that.

