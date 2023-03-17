## **Mobile Automation Challenge Endava 2023**
Hi!

In this challenge we want to automate some test for the IMDb android app

The covered scenarios are the following:
1. Movie Searching
2. Watch List
3. Movie Rating 
4. Movie Sorting

Which correspond to the following workflows:

1. Given the application IMDb, user clicks on skip login, user search for a movie, clicks on the first result and verifies the overview content

2. Given the application IMDb, user log into the app, searches for a movie, selects any result, add the result to the watchlist and verifies its watchlist

3. Given the application IMDb, user log into the app, searches for a movie, selects the first result, goes to the "user reviews" section and rates the movie.

4. Given the application IMDb, user log into the app, user sees all the popular trailers and sorts the trailers alphabetically

In this challenge I use the BDD Approach using Cucumber, TestNG as runner, Cucumber reports as reporting tool, AssertJ for the assertions and Log4J as logging tool.

I solved the challenge using the POM design pattern oriented to the mobile testing.

### **Developed bonus points**
1. Manual account creation (for scenarios where login is needed)
2. Added an extra scenario (movie sorting)
3. Screenshots on test failure
4. This `README` file :D
-----
By: Angel Mateo Gonzalez | Testing intern 

