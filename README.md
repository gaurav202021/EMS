# EMS
EMS System
#API with sping boot,H2 database

 clone  https://github.com/gaurav202021/EMS.git

#Navigate to directory
 cd EMS

# Build a project
	docker build  -t imagename .

# Run Docker
	docker run imageName
# Open a swagger to browser
	http://localhost:8090/swagger-ui.html

# Run Testing
 1)open http://localhost:8090/swagger-ui.html
 2)add employee
 3)get employee list using swagger
 4)update employee using id and status(ADDED,
	IN_CHECK,
	APPROVED,
	ACTIVE)
 

###End