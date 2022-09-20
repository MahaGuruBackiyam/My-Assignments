Feature: Login with multiple user 

Background: 
	Given Chrome browser given 
	And load the web application URL 
	And Maximize the browser window and set timeouts 
	And Enter a valid username 
	And Enter a valid password 
	When Login Button is clicked 
	And CRMFA link is clicked 
	And Lead button is clicked
Scenario Outline: TC001 Create Lead Flow 


	When Create Lead button is clicked 
	Given Enter company name as<Company_name>
	And Enter First name as<First_name>
	And Enter Last Name as<Last_name>
	When Create Lead button2 is clicked 
	Then View Lead page should be displayed
	
	Examples:
	|Company_name|First_name|Last_name|
	|tcs         |Hari      |R        |


Scenario: TC002 Delete Lead Flow
	
	When Side Find Leads button is clicked 
	And Phone is clicked 
	Given Enter phone number 
	When Centre Find Leads button is clicked 
	Then Wait for sometime
	And Copy Lead ID of first resulting Lead 
	When First resulting Lead ID is clicked 
	And Delete is clicked 
	When Side Find Leads button is clicked 
	Given Enter Lead ID 
	When Centre Find Leads button is clicked
	Then Wait for sometime 
	But Error message id displayed 
	
Scenario: TC003  Duplicate Lead Flow 
	
	When Side Find Leads button is clicked
	And Phone is clicked 
	Given Enter phone number 
	When Centre Find Leads button is clicked 
	Then Wait for sometime
	When First resulting Lead ID is clicked 
	And Duplicate Lead is clicked 
	When Create Lead button2 is clicked 
Scenario Outline: TC004  Edit Lead Flow 
	 
	When Side Find Leads button is clicked
	And Phone is clicked 
	Given Enter phone number 
	When Centre Find Leads button is clicked 
	Then Wait for sometime
	And First resulting Lead ID is clicked 
	And Edit button is clicked 
	Given Enter new company name as<cm>
	When Update button is clicked 
	Then View Lead page should be displayed
	Examples:
	|cm|
	|TCS|
Scenario Outline: TC005  Merge Lead Flow 
	When Merge Leads button is clicked 
	And Widget of From Contact is clicked 
	Then Focus is moved to Second window 
	Given Enter the first name as<fn> 
	When Centre Find Leads button is clicked 
	Then Wait for sometime
	And Copy Lead ID of first resulting Lead 
	And First resulting Lead ID is clicked
	Then Focus is moved to first window 
	And Widget of to Contact is clicked 
	Then Focus is moved to Second window2
	Given Enter the first name2 as<fn2> 
	When Centre Find Leads button is clicked 
	Then Wait for sometime
	And First resulting Lead ID is clicked 
	Then Focus is moved to first window2
	When Merge button is clicked 
	Then Alert is accepted
	When Side Find Leads button is clicked 
	Given Enter Lead ID 
	When Centre Find Leads button is clicked
	Then Verify the title of the page 
	Examples:
	|fn|fn2|
	|isha|Isha|
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
