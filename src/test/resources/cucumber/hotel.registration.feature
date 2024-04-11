Feature: HotelStep

  Scenario: Rejestracja użytkownika

    Given Użytkownik jest na stronie hotelu
    When Użytkownik rejestruje się z Jan Sobieski i hasłem 12345
    And Zamknięcie przeglądarki

  Scenario Outline: Wprowadzanie danych
    Given Użytkownik jest na stronie hotelu
    When Użytkownik rejestruje się z <name> <lastname> i hasłem <password>
    And Zamknięcie przeglądarki

    Examples:
      | name | lastname | password |
      | Adam | Kaczka   | 45678    |
      | Alan | Kotek    | 78901    |


  Scenario Outline: Wprowadzanie nowego adresu
    Given Użytkownik jest na stronie hotelu
    When Użytkownik rejestruje się z <name> <lastname> i hasłem <password>
    And Użytkownik dodaje swój pierwszy adres <address> <postalCode> <city> <phoneNumber>
    Then Adres użytkownika został zapisany
    And Usunięcie adresu
    And Zrzut ekranu

    Examples:
      | name | lastname | password | address | postalCode | city | phoneNumber |
      | Adam | Kaczka   | 45678    | aaa     | 00000      | aaa  | 243567487   |
      | Alan | Kotek    | 78901    | bbb     | 11111      | bbb  | 457093672   |