Feature: Package status

  @GuiTests
  Scenario Outline: Check package's status
    Given user is on track shipment page
    When user enters parcel number "<number>"
    And user clicks find button
    Then list of parcel statuses is displayed
    And the last parcel status is "<status>"

    Examples:
      | number                   | status               |
      | 520113014230722029585646 | Dostarczona          |
      | 520107010499997005638120 | Wydana do doręczenia |
      | 523000016696115042036670 | Anulowano etykietę   |
      | 520000011395200025754311 | Dostarczona          |