Feature: Age Gateway

  Scenario: user enter date equals to 18 years old
    Given user navigate to jager meister website
    When user enter valid date equals to 18 years old
    Then user directed to the site page without clicking Enter

  Scenario: user enter date bigger than 18 years old
    Given user navigate to jager meister website
    When user enter valid date bigger than 18 years old
    Then user directed to the site page without clicking Enter

  Scenario: user enter date smaller than 18 years old
    Given user navigate to jager meister website
    When user enter valid date smaller than 18 years old
    Then Error message to appear with date entered is smaller than 18 years old

  Scenario Outline: user enter inValid date
    Given user navigate to jager meister website
    When user enter inValid date "<DD>", "<MM>" and "<YYYY>"
    Then user should stay in same page
    Examples:
      | DD | MM | YYYY |
      |    | 12 | 2005 |
      | 23 |    | 2005 |
      | 23 | 12 |      |

  Scenario: user enter inValid Day
    Given user navigate to jager meister website
    When user enter inValid Day "32", "12" and "2005"
    Then Error message to appear with invalid Day

  Scenario: user enter date inValid Month
    Given user navigate to jager meister website
    When user enter inValid Month "22", "13" and "2005"
    Then Error message to appear with invalid Month

  Scenario: user enter date with less than 1900
    Given user navigate to jager meister website
    When user enter less than 1900 as year "22", "12" and "1899"
    Then Error message to appear with unReal date