Feature: To make a userprofile in Mailchimp
  one will be a normal profile
  one will be with too long username
  one will try to make a user that already exists
  one will be incomplete (lacking e-mail).

  Scenario Outline:
    Given I have started a "<browser>" browser
    Given I enter "<email>"
    Given I put "<username>"
    Given I enter a "<password>"
    When I click the signup button
    Then I get a "<result>"

    Examples:
    |browser|email|username|password|result|
    |chrome|korva@mail.com|TheKorva1|Go@7|signup-content|
    |chrome|korva@mail.com|TheKorva1|Go@7|signup-content|
    |edge|gurgel@mail.com|TheGurgel1|Go!7|signup-content|

