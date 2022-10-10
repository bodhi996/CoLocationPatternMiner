# CoLocationPatternMiner

## Domain 

Prior to understanding Spatial data mining, we must first delve into what exactly is data mining. Analysing large quantity of data to hunt for patterns is impractical for humans to engage in because it will be very time inefficient and prone to human error. Data mining is the process of sorting through large data sets to identify patterns and relationships that can help solve business problems through data analysis in a time efficient manner. Data mining techniques and tools enable enterprises to make sense of the data and extrapolate it into the future. One of the biggest implementation of data mining was first made by Walmart. Walmart uses data mining to analyze patterns in the sales data. Data mining helps Walmart find patterns that can be used to provide product recommendations to users based on which products
were bought together or which products were bought before the purchase of a particular product. Effective data mining at Walmart has increased its
conversion rate of customers. A familiar example of effective data mining through association rule learning technique at Walmart is – finding that
Strawberry pop-tarts sales increased by 7 times before a Hurricane. After Walmart identified this association between Hurricane and Strawberry poptarts through data mining, it places all the Strawberry pop-tarts at the checkouts before a hurricane.  

## Co-Location Patterns

Spatial co-location pattern mining refers to the task of discovering the group of
objects or events that co-occur at many places. Co-location patterns represent
subsets of spatial features whose instances are often located in close
geographic proximity. Examples include symbiotic species and crime attractors
(e.g., bars, misdemeanors, etc.). Boolean spatial features describe the
presence or absence of geographic object types at different locations in a twodimensional or three-dimensional metric space, for example, the surface of the
Earth. Examples of spatial features include plant species and crime.
Extracting these patterns from spatial data is very difficult due to the
complexity of spatial data types, spatial relationships, and spatial autocorrelation. Co-location rules are models to infer the presence of spatial
features in the neighbourhood of instances of other spatial features. 
1. ```Association Rule```: Association rule mining is a procedure which is meant
to find frequent patterns, correlations, associations, or causal structures
from data sets found in various kinds of databases such as relational
databases, transactional databases, and other forms of data
repositories.
Given a set of transactions, association rule mining aims to find the rules
which enable us to predict the occurrence of a specific item based on
the occurrences of the other items in the transaction.
So, in a given transaction with multiple items, it tries to find the rules
that govern how or why such items are often bought together. For
example, peanut butter and jelly are often bought together because a
lot of people like to make PB&J sandwiches. 
2. ```Apriori Estimation```: Apriori is an algorithm for frequent item set mining
and association rule learning over relational databases. It proceeds by
identifying the frequent individual items in the database and extending
them to larger and larger item sets as long as those item sets appear
sufficiently often in the database. The frequent item sets determined by
Apriori can be used to determine association rules which highlight
general trends in the database: this has applications in domains such as
market basket analysis.
Apriori performs market basket analysis by discovering co-occurring
items (frequent itemsets) within a set. Apriori finds rules with support
greater than specified minimum support and confidence greater than
specified minimum confidence. 

## Practical Implementation

Till so far, we discussed the general algorithm and now we will look into the
practical implementation of the same. Then we will be discussing the results of
the code. The tools I have designed extensively used are JDK to develop code
in the java environment, VS Code as the IDE, Postgres SQL database primarily
for storing the feature types and their row instance, and finally the JDBC to
integrate the JDK environment with Postgres environment.
1. ```Java Development Kit```: Or JDK as it is popularly called is a distribution of the
Java Technology by the Oracle company. It implements the Java Virtual
Machine or JVM as it is popularly called which allows Java to function as a
platform independent programming language. It basically provides software
for working of Java Application. Examples of the same include a virtual
machine, compiler, debugger, performance monitoring tools, etc.
The JDK also comes with a complete Java Runtime Environment (JRE), usually
called a private runtime. Copies of JDK also include a wide selection of
programs capable of enumerating most Java APIs.
2. ```VisualStudios Code```: VS code is an integrated development environment
provided by Microsoft to develop computer programs, website, mobile
application development, and web services. Visual Studio includes a code
editor supporting code refactoring. It allows editing and debugging in almost
36 languages the likes of which include C++, Java, Javascript, SQL, Bash, HTML,
etc. 
3. ```PostGres SQL```: Also referred as Postgres, is an open-source relational database.
Initially, I planned to use PostGIS for implementation of the spatial
neighbourhood relation. However, since the Co-location pattern miner I
designed didn’t require such a thing, I stuck to Postgres SQL. Postgres features
Atomicity, Consistency, Isolation, Durability as its properties and automatically
update views, triggers, foreign keys, and stored procedure.
4. ```Java Database Connectivity``` : Or JDBC as its popularly called is an Application
Programming Interface that allows Java users to manage access to databases.
It is a Java-based data access technology used for Java database connectivity.
JDBC allows multiple implementations to exist and be used by the same
application. The API provides a mechanism for dynamically loading the correct
Java packages and registering them with the JDBC Driver Manager. The Driver
Manager is used as a connection factory for creating JDBC connections. 



## Description of the codebase

<img src="assets/Icons/Screenshot%20(173).png" width="170" height="400"> <img src="assets/Icons/Screenshot%20(174).png" width="150" height="400"> 
<img src="assets/Icons/Screenshot%20(175).png" width="170" height="400"><img src="assets/Icons/Screenshot%20(178).png" width="150" height="400">&nbsp;<img src="assets/Icons/Screenshot%20(176).png" width="170" height="400">
       
The code is well arranged into sub-directories which are -
1. The first page is the ```home``` page. 
2. The second page is the ```product```catalogue page. 
3. The third page is the ``` Cart/Basket``` page. 
4. The fourth Page is the ```Connect With``` page so that the user can connect with prospective clients. 
5. Finally, the fifth page is the ```payment``` gateway.

# How to Run

<img src="assets/Icons/10.png" width="5000" height="400">

1. Make sure Flutter is installed in your system.
2. Install Android in your system. 
3. In the event you want to understand the installation process in detail [Youtube](https://www.youtube.com/watch?v=x0uinJvhNxI&t=5071s) will be very helpful
4. For Windows 41:32 and for Linux/iOS 18:34.
5. Open the repository in Android Studio.
6. Crate an emulator in AVD manager. 
7. Run the application.
8. Create a new issue if you face any difficulties or call Bodhisatwa at 8910602015 or Safal at 9123169595

## Team Mentor

Saurav Priadarshini <br />
Special thanks and appreciation to our mentor who entertained even our stupidest doubts without hesitation. 😁

## Team Members

<img src="assets/Icons/DS%20Back.png" width="170" height="170">


## APK Version

You can find the apk version of [Skill Hub](https://github.com/bodhi996/IEEE-Megaproject/blob/master/student_store/SkillHub.apk) here 
