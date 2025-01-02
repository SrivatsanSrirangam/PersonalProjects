SQL.sql -> Creates and populates the tables for the MovieDB

There are 5 Main entities each corresponding to the database, each will let you access their content based on what Namedquery you are trying to access 
  Zipcode.java  -> Lets you get all the available Zipcodes
  Theater.java  -> Lets you get all the theater based on the Zipcode
  Shownat.java  -> Lets you access what movieId and shownid is corresponding to the theater
  Movie.java -> Lets you access the movies based on the movieid
  Shownattimes.java -> Lets you access the movie times that will be shown based on the shownatId

The ejb lets the beans acceess the database by calling on the corresponding named query.
  Movieejb.java ->  findAllZipcode  -> lets you get all the zipcodes
                    getTheatersFromZipcode -> lets you get all the theaters based on the zipcodes
                    getMoviesFromTheaterId -> lets you get all the movies based on the theaters
                    getTimesFromMovieId -> lets you get the show times from the movieid
The jsf cdi beans calls ejb functions or has its own methods to perform various operations based on the values from the jsf pages
  ZipcodeBean.java -> getZipcodeList -> gets the list of all available zipcodes
  
  MovieBean.java -> selectTheater -> Sets the theater value and returns the page where the movies for the specific theater are displayed
                    getMoviesForTheater -> Gets the movies for a specific theater
                    selectMovieShowDescription -> Sets the movie when show description is selected and then the description page is returned
                    selectMovieShowTimes -> Sets the movie when show time is selected and then the times for the movie page is returned
                    getTimesForMovie -> Gets the available times for a specific movie
  TheaterBean.java -> selectZipcode -> Sets the zipcode value and returns the page to display where the theaters for a specific zipcode are displayed
  
  ValidationBean.java -> validateValues -> Validates the credit card number, zipcode and the number of tickets and makes sure they are in the correct range

The jsf pages are web pages which interact with the jsf cdi bean to perform various functions
  SelectZipcode.xhtml  -> Displays the available zipcodes for which the user can select a value
  TheatersForZipcode.xhtml  -> Displays the theaters for the selected zipcode for which the user can select a theater
  MoviesForTheater.xhtml  -> Displays the movies for the selected theater for which the user can select to view the description, or book tickets
  MovieDescription.xhtml  -> Displays the name, description and title for the selected movie. The user can choose to book the ticket if they decide so.
  TimeForMovie.xhtml  -> Displays the available times for the selected movie for which the user can select a time to book tickets
  BookTicket.xhtml  -> User can book the ticket after entering the required information. It returns the total cost based on the number of tickets.