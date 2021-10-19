#INTEGRATION README

##Project Details
1. **Name**: 
   Project 1
2. **Description:** 
   This project consists of a REPL, with some math, star, and user commands.
3. **Team Members and Contributions:** 
   This was a group project by movo5hmkwxub4roi, qhtxrfw3rg55v8qa, and 2fykt1olsbpqx85v (who dropped the class during 
   integration).
   movo5hmkwxub4roi worked on the KDTree implementation as well as some testing, with the help of 2fykt1olsbpqx85v on
   some of the KDTree methods, while qhtxrfw3rg55v8qa was primarily focused on the API component of the project. All 
   team members thought a lot about design and how to get all pieces of the project working.
   


##Design Choices
**Classes, and their Relationship**
Each package of our project 1 contains the necessary classes of the specific, and are intended to interact with the 
Main package. 
The API component is spread out in the client and core packages, and interact with the API Aggregator in Main. 
datatypes has the User class, and interacts with the KDTree in core. 
commands holds most of the REPL commands that project 1 requires. 

**Unusual algorithms**
No unusual algorithms.


##Bugs
**Onboarding bugs:**
All commands seem to work except for the two "naive_neighbors" command. I tried using print statements to see 
whether my REPL was even detecting the command, and it did not react. I've tried editing if statements and making 
changes to the logic of that command but "naive_neighbors" still does not even seem to be processed. Because of this, 
I do not know if my "naive_neighbors" finds the right neighbors.
Another bug is that the exceptions instead throw the exception on line 209 in Main. I suspect that this is because I 
am trying to throw the exceptions while inside a `<try{}>` indent. Instead of printing out my exception, it goes to the
corresponding `<catch{}>` statement.

**Sprint bugs:**
First, the KDTree similarUsers() method returns the wrong results. Additionally, the classify command does not work when 
called in the REPL.

**Integration bugs**
After mostly completing user story 1, the similar command no longer returns user ids. There is a problem with the similar
users command not having acces to the saved kd tree from the users command.


##Tests
**Onboarding tests**
When I run `<./cs32-test src/test/system/*.test>` in my command line, only 3/4 tests pass. The one that fails is the 
"Running error". I am unsure about what this means exactly; I am guessing that it could be related to why my 
"naive_neighbor" commands don't work. 
I did not have time to write my own tests. I did look at the tests in the src/test/system/stars, and simulated them by 
running my REPL with the input in the files from that folder, to test for basic functionality. 

**Integration tests**
movo5hmkwxub4roi wrote tests for the Node class, KDTree class and User class.


##Questions
**Integration**
In terms of handling identity-based bias, we could give a small boost to anyone that identifies with a marginalized or
underrepresented group. We would then create matches using these altered values.


##Links
*Here are some links that helped me write some of the code in my project:*
https://stackoverflow.com/questions/11990211/reading-csv-file-using-bufferedreader-resulting-in-reading-alternative-lines
https://stackoverflow.com/questions/8065532/how-to-randomly-pick-an-element-from-an-array
https://javatutoring.com/distance-between-two-points-java-program/
https://en.wikipedia.org/wiki/K-d_tree#Construction

