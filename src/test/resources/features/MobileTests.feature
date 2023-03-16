Feature: Test different flows of the IMDB Android APP

  @search
  Scenario: User search for a movie
    Given the user is in the main page of the app
    And the user skips the login process
    When the user searches for the movie "Finding Nemo"
    And the user selects the first result
    Then the overview must match with an existing overviewed text

  @watch_list
  Scenario: User adds a movie to a watch list
    Given the user is logged into the app
    And the user searches for the movie "Harry Potter"
    And the user selects any movie
    And the user adds the movie to the watch list
    When the user sees its watchlist
    Then the watch list must contain the previous searched movie

  @rating
  Scenario: User wants to rate a movie
    Given the user is logged into the app
    And the user searches for a movie
    When user rates the selected movie
    Then the message "Rating saved" is displayed to the user