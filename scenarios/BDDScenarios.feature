Feature: Login Feature

  @ParameterizedTest
  Scenario Outline: To verify login and logout of Gmail
    Given user launches Gmail website
    When user login to gmail with <username> and <password>
    Then user logout from Gmail
      | username                     | password      |
      | saurabhsharma.it14@gmail.com | Mahakaal@2910 |
      | saurabhsharma.it14@gmail.com | Mahakaal@2910 |

  @Tests
  Scenario: To verify login and logout of Gmail
    Given user launches Gmail website
    When user login to gmail
    Then user logout from Gmail
