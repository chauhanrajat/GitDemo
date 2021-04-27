Feature: Validating the place api's.

Scenario Outline: Verify that if place is being successfully added using AddplaceApi
	Given Add Place payload with "<name>" "<language>" "<address>"
	When user calls "AddplaceApi" with "Post"  http request
	Then the api call is success with status code 200
	And "status" in response is "OK"
	And "scope" in response body is "APP"
	
Examples:
     |name    | language    | address          |
     |AAhouse | English     |world cross center|
     |chauhan | chauhan     |chauhansaab       |