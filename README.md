# patient-crud-operation
Spring boot CRUD Operation for adding,updating and deleting patients and also displaying paginations

To start this project, open eclipse or InteliJ editor 
import the project.
create a database in your local machine named patient.
use root or any other user with an appropriate password. 
when you are using linux interface or any other related linux interface like ubuntu, run the command 
sudo -u root mysql to log in to mysql server.
mysql>CTREATE DATABASE patient;
mysql>GRANT ALL PREVILEGES ON patient TO root; this command grant all the operation previleges to root on the patient database.

come bck to the project.
navigate to src/main/java.
go to com.austine.bunde
and right click on the mainclass file named PatientCreateUpdateApplication select run as springboot app to start the server.
test the endpoints using postman or any other api testing tool you can use.
