Feature: As a DemoBlaze user I should be able to get list of the products with or without logged in to the application



Scenario Outline: User is launching the DemoBlaze website
		When user launches the url
		Then verify if user gets the title of the DemoBlaze Website <Title>
		
Examples:
|Title|
|STORE|

Scenario Outline: User is getting logged in to the DemoBlaze website
		When user is on login page
		Then verify if user gets logged in with <username>
		
Examples:
|username|
|abc786@gmail.com|



Scenario Outline: Getting the list of Phones from Phone option that is  available on Home Page of
									 DemoBlaze website without logged in to the application:
   When user gets list of phones    
   Then verify if <phone> item is present on that page
   
Examples:
|phone|
|The Samsung Galaxy S6|



Scenario Outline: Getting the list of Laptops from Laptop option that is  available on Home Page of DemoBlaze website:
   When user gets list of laptops    
   Then verify if user able to view the <laptop> item
   
Examples:
|laptop|
|MacBook Pro line|
   

Scenario Outline: Getting the list of Laptops from Laptop option that is  available on Home Page of DemoBlaze website:
   When user gets list of Monitors     
   Then verify if user is able to get the <monitor>
   
 Examples:
|monitor|
|LED Cinema Display|

Scenario Outline: User is navigating to the next page and getting the monitor items from next page
   When navigates to the next page   
   Then verify if user gets <MonitorItem> from NextPage
   
 Examples:
|MonitorItem|
|ASUS|

 
 


