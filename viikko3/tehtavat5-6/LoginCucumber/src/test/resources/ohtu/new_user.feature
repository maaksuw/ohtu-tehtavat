Feature: A new user account can be created if a proper unused username and password are given

    Scenario: creation is successful with valid username and password
        Given command new is selected
        When  username "liisi" is entered
        And   password "isiilisiil9" is entered
        Then  system will respond with "new user registered"

    Scenario: creation fails with already taken username and valid password
        Given command new is selected
        When  username "pekka" is entered
        And   password "akkepakkep7" is entered
        Then  system will respond with "new user not registered"

    Scenario: creation fails with too short username and valid password
        Given command new is selected
        When  username "li" is entered
        And   password "lililili13" is entered
        Then  system will respond with "new user not registered"

    Scenario: creation fails with valid username and too short password
        Given command new is selected
        When  username "liisi" is entered
        And   password "liisi8" is entered
        Then  system will respond with "new user not registered"

    Scenario: creation fails with valid username and password long enough but consisting of only letters
        Given command new is selected
        When  username "liisi" is entered
        And   password "liisiliisi" is entered
        Then  system will respond with "new user not registered"

    Scenario: can login with successfully generated account
        Given user "eero" with password "salainen1" is created
        And   command login is selected
        When  username "eero" is entered
        And   password "salainen1" is entered
        Then  system will respond with "logged in"