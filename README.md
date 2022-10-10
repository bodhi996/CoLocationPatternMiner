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
1. Association Rule: Association rule mining is a procedure which is meant
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
2. Apriori Estimation: Apriori is an algorithm for frequent item set mining
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


## Example of Application Domain

The idea of the project is as an intra-organizational employment-oriented service that operates via mobile apps. 
The organisation that we have used as a test case is BIT Mesra, however, it can be oriented towards any other organisation as well. The main goal is to bring convenience to freelancers and startups by hiring people from within the community from where they are based.<br />
The app can be handy to foster the experience of networking to those who have no prior industry experience and also to those looking for a cost competitive employability from within their organizational structure. 

# Achievements

Our application boasts of several features:
1. The application differentiates between verified and non-verified users. The algorithm will give verification symbols to those who have been consistent users of this platform.
2. The app also uses third party features such as Linkedin to give out users better depth into their prospective employees.
3. The app provides for a basket so that the user can select multiple people at one time without having to go through the same process recursively. 
4.  The app also provides for payment gateway so that the user doesn't have to deal with the hassle of negotiation and engaging with third party payments procedure. 
5.  The user also has the feature of deleting any of this selection from the Cart/Basket page if he/she reconsiders their decision. 

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
