# Object Orientation with Design Patterns
## Stock Market Simulator

### Design Patterns Used

* **Builder** - The Builder Pattern was used to create the 100 fake companies and investors, the reason for that was to facilitate the setters for each random value.
  
* **Observer** - The Observer Pattern was used to watch all the shares sold, for each share sold the company that is selling it must inform the Observer and the Observer will notify all the other companies if it is needed.
I've chosen the Observer because is the best approach to notify a list of objects if some update happens in the system.
In this case, the observer notifies companies that didn't sell any share after 10 shares in a row are sold.

* **Façade** - The Façade Pattern was used to allow the client communicate with the system through the Menu. 
For each Menu Option entered by the user, the Façade Pattern will deliver a different result. It was a good pattern to use because it facilitated to get the results request by the user, which are the Best and Worst Investors and Companies. 

* **Singleton** - I used Singleton to create the Observer class since all companies are using the same Observer for adding itself to the list, removing itself from the list and also to update the observer. I needed to use the same observer, therefore the single instance. I also used singleton for the Generator, but for no real reason.


