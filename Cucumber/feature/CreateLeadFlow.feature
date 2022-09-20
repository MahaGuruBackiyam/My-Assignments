Feature: Create Lead Flow
Scenario: TC001 login with valid credential
Given Chrome browser given1
And load the web application URL1
And Maximize the browser window and set timeouts1
And Enter a valid username1
And Enter a valid password1
When Login Button is clicked1
And CRMFA link is clicked1
And Lead button is clicked1
And Create Lead button is clicked1
Given Enter company name1
And Enter first name1
And Enter Last Name1
When Create Lead button is clicked1
Then View Lead page should be displayed1
