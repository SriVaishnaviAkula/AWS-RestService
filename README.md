# AWS-RestService

This service basically warps around AWS Elastic Beanstalk service that creates RDS instance for postgres and exposes out the REST Interface for its functionality.

It is like a webservice using REST API 

git clone https://github.com/SriVaishnaviAkula/AWS-RestService.git 

then, open eclipse and select "File > import > Maven > Existing Maven Projects > {Select Directory} > Finish"

Finally, add this project to your Java web container(Ex: tomcat) and run.

# Running the application on localhost 

right click on the target folder > Run As > Maven build

right click on the target folder > Run As > SpringBootApp

open the browser and give the localhost port /api/signature to see the JSON file

# Creating Webapp in Elastic Beanstalk
<ul>
<li> Choose Elastic Beanstalk from the Services and create new Application,give the application name and create from the environment tier choose web service environment</li>
<li> Under plactfrom choose Tomcat and upload your code(Here the code is war file for java application)</li>
<li>click in create environment a sample environment will be created with an environment id and a end point URL will be generated for the application</li>
<li> Choose configuration setting and under Data Tier create a new RDS database</li>
<li> under DB Engine choose Postgres and alocate Master Username and Master Password and select Apply,Elastic Beanstalk will creates a postgres databaseinstace</li>
<li> choose RDS under services and click on instances you can see a postgres instance.Select the instance and under instance Action see details. you can see EndPoint username which are the parameters that need to be passed to the hibernate.cfg.xml file to access the postgres instance</li>
<li>In configuration details of postgres instance choose security groups,under security groups select inbound and edit the inbound values.chose Add rule. under Source choose everywhere and click save. by doing this the instace can be accessed by pgAdmin</li>
<li> open the pgAdmin and add a new server under the server tab give a server name and under credentials give Hostname as same as end point of the instance ( aa19myufljptkrw.cgyqpcbp7lx2.us-west-2.rds.amazonaws.com )give the user name and password. the new server will get created</li>
<li>create a table. in this application my table name is form and cloumns are id(auto incremented value),name,address,email,sig. and insert few records of your choice</li>
<li>test the application using localhost and upload it into Elastic beanstalk. test the application by accessing the Endpoint provide by sample application (ex: http://sample-env.57vrmnjhcm.us-west-2.elasticbeanstalk.com/webapi/api/signature)</li>
</ul>

# Creating the Angular 2 Application
git clone the https://github.com/SriVaishnaviAkula/Angular2-FormsDemo.git and follow the steps to bundle the application 

# Upload the Angular 2 application into S3 bucket 
<ul>
<li> Choose s3 from the service and create a bucket name unique to the region</li>
<li> upoad the files. here we need to upload the content from dist folder this dist folder contains the bundled files<li>
<li> go to the properties and under permissions click on Edit Bucket Policy and write a policy for the bucket
{
	"Version": "2012-10-17",
	"Statement": [
		{
			"Sid": "PublicReadGetObject",
			"Effect": "Allow",
			"Principal": {
				"AWS": "*"
			},
			"Action": "s3:GetObject",
			"Resource": "arn:aws:s3:::signaturepaddemo-forms/*"
		}
	]
} 
and click save</li>
<li>under static web hosting give the Index document as index.html and click save.To can access your data click on the given end point(http://signaturepaddemo-forms.s3-website-us-east-1.amazonaws.com/)</li>
<li> now enter the data and click submit. on submission you can see the data from form can be posted to rest application and on accessing the rest Endpoint you can see the data</li>

   
