

### Details of Automation:

The UI picked for automation is similar to the requirement mentioned for official NSW Government media releases app for assignment.

### Assignment Details
-	Selecting the type of ministers on the category of news.
-	Clicking on the search button to filter the news.
-	News should be filtered as per choice of the ministers selected.
-	Clicking on the reset button to remove all the filters applied.
- 	News should be reset on removal of filters.

### Application Used:

-   NSW Gov URL-> https://www.nsw.gov.au/media-releases

### Automation Framework Details: Its a Page Object Model (POM)Based Framework

### Technologies Used: Selenium, Cucumber, Maven, Java, TestTNG

### Folder Structure: 
### src/test/resources: 
-   Cucumber feature files
-   Config files
-   Drivers(Chrome/Edge)
### src/main/java:
-   Utilities/Config reader/Exception Handler
-   Step definitions
-	Page classes
### src/test/java:
TestNG Runner file
### Reports
-   Test Reports and screenshots are kept here

### Test Details:
As given in the assignment, 2 testcases along with negative testdata has been included 
(These testcases can be seen in the feature file - /eCommerce/src/test/resources/features/FilterByMinister.feature)
### Testcases:
-   Verify the item cards are displayed as filtered by minister
-   Verify the item cards are reset and filter is removed.

### How to read the report:
Report can be found at - file:///C:/Users/Vkumari/Documents/GitHub/MediaReleases/mediarelease-main/com.mediarelease/Reports/SparkReport%2020-Jul-22%2018-54-41/Output/Spark.html
(I have also  attached the report in the mail for easy access).

-   Download the folder : SparkReport 20-Jul-22 18-54-41
-   Open the Spark.html file inside Output folder with any browser
(Right click on Spark.html, open with any browser Eg:Chrome)
-   Click on each test case should open the detailed test steps along with Screenshot.
-   How to read the report video -> NSWGovMediaReleases/FilterByMinister.mp4
									NSWGovMediaReleases/ResetFilter.mp4
### Automation Execution:
I have attached the automation execution video in the mail.




      









