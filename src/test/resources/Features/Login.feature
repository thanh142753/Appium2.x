Feature: Login with Valid Credentials

  @Mobile
  Scenario Outline: Login
    When I input username "<username>"
    And I input password "<password>"
    And I click on login button
    Given I login to app successfully

    Examples: login
      | username      | password        |
      | standard_user | invalidPassword |
      | standard_user | secret_sauce    |


  @WebApp
  Scenario: Vinmart
#    Given I login to google chrome
    And I access link "https://winmart.vn/"
    And I close the web advertisement
    And I click on module "Ưu Đãi Hội Viên"
    And I add product "MEATDELI [PRE] Thịt heo xay đặc biệt" to the cart
    And I click my cart
    Then I verify the product "MEATDELI [PRE] Thịt heo xay đặc biệt" is displaying with the product quantity of "1"

