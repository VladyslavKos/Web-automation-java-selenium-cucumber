Feature: SingIn Outline

  @ScenarioOutline
  Scenario Outline: User Sing In
    When user login as "<LoginData>"
    Then result is "<Result>"
    Examples:
      | LoginData                        | Result    |
      | test724@test.com                 | SingIn    |
      | test735                          | NotSingIn |
      | test735@                         | NotSingIn |
      | @                                | NotSingIn |
      | @test.com                        | NotSingIn |
      | test734@test.comtest734@test.com | NotSingIn |
      | admin                            | NotSingIn |
      |                                  | NotSingIn |