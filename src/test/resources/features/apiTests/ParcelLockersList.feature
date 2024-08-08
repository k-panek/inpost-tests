Feature: Parcel lockers list

  @ApiTests
  Scenario Outline: Search parcel lockers list for specific city and save the response

    Given user prepares parcel lockers search request
    And user adds to the request query param city "<city>"
    When user makes a call
    And response status code is 200
    Then list of parcel lockers for "<city>" is returned
    And name, postal code and coordinates for returned list are saved to the file parcellockers."<city>".json

    Examples:
      | city      |
      | Sopot     |
      | Tychy     |
      | Jastarnia |
      | Zakopane  |