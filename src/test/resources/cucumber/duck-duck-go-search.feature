#Feature: DuckDuckGo Search
#
#  Scenario: user can search any keyword
#
#    Given an open browser with duckduckgo.com
#    When user search for selenium
#    Then the first result should contain selenium
#    And quit browser
#
#  Scenario Outline: user can search any keyword
#
#    Given an open browser with duckduckgo.com
#    When user search for <keyword>
#    Then the first result should contain <expectedKeyword>
#    And quit browser
#
#    Examples:
#      | keyword  | expectedKeyword |
#      | selenium | selenium        |
#      | potas    | Potassium       |
#      | ziemniak | Ziemniak        |