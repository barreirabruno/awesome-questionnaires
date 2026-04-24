# AWESOME QUESTIONAIRES

## Description:

Create and manage awesome questionaires. Questionaires are groups of questions and also additional questions(if you want). You can also manage the questionaires direct from this app, make them active, deactivate and edit them. Also choose for different types of questions when creating a questionaire.

## Tech Stack:

- Java 17.0.8
- Gradle

## CLI

When users enter the program:

====================================
Greeting from Awesome Questionnaires.
====================================

Type 0 to create a new questionnaire
Type 1 for manage questionnaires
Type 2 to respond questionnaires
Type 3 for exit

Please, type your option 

---

0 - Create a new questionnaire

**There is an I/O action here, right? A file must be created for this questionnaire.**

    1 - Questionnaire name
    2 - Questionnaire description
    3 - Add questions
    4 - Publish now? Yes/No

---

1 - Manage questionnaires

Type 1 to manage drafted questionnaires
 - [Questionnaire title A]
 - [Questionnaire title B]
 - [Questionnaire title C]

Type at least three characters of questionnaire title here: 

    - [Questionnaire title A]
        1 - Edit title
        2 - Edit description
        3 - Add question
        4 - Edit question
        5 - Publish questionnaire
        6 - Discart questionnaire
        7 - Back

Type 2 to manage published questionnares
 - [Questionnaire title A]
 - [Questionnaire title B]
 - [Questionnaire title C]

Type at least three characters of questionnaire title here: 

---

2 - Respond questionnaires

Great, here the following available questionnaires you can respond:

 - [Questionnaire title A]
 - [Questionnaire title B]
 - [Questionnaire title C]

Can't found the questionnaire you're looking for? Contact admin.

Type at least three characters of questionnaire title here: 

---

3 - Exit

========================================
Thanks for using Awesome Questionnaires!
========================================


## Data modelling

### Questionnaire

Questionnaires will be persisted in files with the following name rule: questionnaire_<questionnaire id>.json

- ID = Unique identifier of a questionnaire
- TITLE = Every questionnare must have a title
- DESCRIPTION = Every questionnaire must have a description of its intention
- STATUS =
    - DRAFT = Not published yet
    - PUBLISHED = Visible for all users
    - DISCARDED = Cant be published, but was a DRAFT sometime
- ACTIVE = 
    TRUE = This questionnaire is active and can be displayed for users
    FALSE = This questionnaire is deleted and cannot be displayed for users
- QUESTIONS = A group of questions

### Question

Questions can be of different type, by now Awesome questionnaires support the following question types:

- Single option response
- Multi option response

Questions can hold additional questions, with no limit for additional questions

- ID = Unique identifier of a question
- DISPLAY_ORDER = Questions must be placed in order of display, this field evidence in which order each question is displayed for user like 1, 2, 3 and so on...
- TYPE:
    - SINGLE RESPONSE - User must select one response and submit
    - MULTIPLE RESPONSE - User must select one or more responses and submit
- STATUS =
    - DRAFT = Not published yet
    - PUBLISHED = Visible for all users
    - DISCARDED = Cant be published, but was a DRAFT sometime
- ACTIVE = 
    TRUE = This questionnaire is active and can be displayed for users
    FALSE = This questionnaire is deleted and cannot be displayed for users
- OPTIONS = One or more options for this question

### Question option

- ID = Unique identifier for a question option
- OPTION DISPLAY TEXT = Text the user will read in screen for this question option
- CORRECT OPTION = 
    TRUE = When this is the correct option for this question
    FALSE = When this is not the correct option for this question

### Questionnaire response

Questionnaire responses will be saved in a file

File name structure = timestamp + questionnaire id

- ID = Response ID unique identifier
- QUESTIONNAIER ID = Unique identifier for questionnaire response
- ANSWERS = For questions the user is responding in this questionnaire
    - QUESTION ID = Question id user is responding
    - SELECTED OPTION IDS = One or more options user has selected

## Folder structure for Questionnaires and Questions:
```bash
/awesome-questionnaires
    /questionnaires
        questionnaire_101.json
        questionnaire_102.json

    /responses
        response_20260424_101.json
        response_20260424_102.json
```
