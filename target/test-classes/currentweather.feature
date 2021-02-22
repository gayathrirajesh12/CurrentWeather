Feature: Get to know the currentweather of trip location


Scenario: Verify Traveller get the weather details before embarking on the trip
        Given Traveller is on Login Page
        When Traveller enters username as "gayathriinfotech13@gmail.com"
        And Traveller enters password as "Gayathri@12"
        And Traveller clicks on Sign in button
        When Traveller clicks on "Weather in your city" in search bar
        Then Entered city as "Mumbai" in search bar
        And  Traveller pressed Enter key
        Then Traveller should get the weather details of "Mumbai"