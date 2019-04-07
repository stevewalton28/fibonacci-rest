[![Build Status](https://travis-ci.com/digital-delivery-academy/fibonacci-rest.svg?branch=master)](https://travis-ci.com/digital-delivery-academy/fibonacci-rest)

# fibonacci-rest

We use this repository for teaching and for job interviews.  If you're here for an interview, scroll down!  

## Teaching

### Deployment to AWS

We deploy to Elastic Beanstalk in a Docker container via Travis.

Environments (that are only deployed when we are teaching)
can be hit at:
 
- https://fibonacci.test.digitaldelivery.academy (TEST)
- https://fibonacci.digitaldelivery.academy (PROD)

### Build

Travis takes care of our build.  It runs:

- git clone
- compile
- unit test
- integration/contract tests
- package
- deploy to test env

We deploy to TEST on all feature branches and on commit to master.

We deploy to PROD on every tag.

## Interviews

If you're here to take the interview challenge, please read on!

### Testing Rest Services

There are a number of endpoints in this application.  The following question needs to be answered:

- When does the application STOP returning Fibonacci numbers in their correct sequence?

There are no automated checks for this application.  Treating the application as a black box, 
produce appropriate automated checks against the applications interfaces.  
Consider that there is more than one interface into the application.

- Use only RestAssured or RestEasy to test the REST interface.
- Use only JUnit as a test harness.
- Ensure that your tests can be executed with an appropriate goal from Maven.

### To submit your test
Either fork this repo and share the link, or submit commits to a branch.
