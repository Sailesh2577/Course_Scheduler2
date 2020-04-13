#   CSCE 361 Capstone Projects

Questions to clarify a project's requirements should be posted to Piazza so
that all teams assigned that project may benefit. I encourage students to
discuss (on Piazza) those questions. If students collaboratively arrive at a
reasonable interpretation that does not contradict another requirement, we
will likely accede to that interpretation. If students cannot arrive at a
reasonable consensus, then we will provide the interpretation to use.

## Yahtzee

Procrastination Pastimes (PP) wants you to develop a computer game of Yahtzee.  
The program should implement the rules of the pencil-and-paper version of
Yahtzee as faithfully as is possible.  The rules for the pencil-and-paper
version of Yahtzee are available at
<https://www.hasbro.com/common/instruct/Yahtzee.pdf> (see also
<https://en.wikipedia.org/wiki/Yahtzee>)

The game shall have a single-player mode and a multi-player mode. Multi-player
mode must accommodate any number of players up to 6.

-   If you implement a GUI, your multi-player mode may be multiple-player on a
    single computer, or it may be multiple-player across a network.
-   If you do not implement a GUI, your multi-player mode must be multiple-
    player across a network.

## Card Games

Procrastination Pastimes (PP) wants you to develop a computerized card game
that use the standard "French" 52-card deck (or multiple standard decks).[^2]

[^2]: A standard deck of cards consists of four suits (clubs(♣︎), diamonds(♢),
hearts (♡) and spades (♠︎)), with each suit having an Ace, a King, a Queen, a
Jack, and numbered cards 2-10. Some games may make use of two Joker cards.

The system shall offer at least one solitaire game and at least one game played
with multiple players. The multi-player card game(s) must accommodate any
number of players up to 6.

-   If you implement a GUI, your multi-player mode may be multiple-player on a
    single computer, or it may be multiple-player across a network.
-   If you do not implement a GUI, your multi-player mode must be multiple-
    player across a network.

## Voting System

The city of Pacopolis wants you to develop an electronic voting system. While
the mayoral race between Pat Mann and Dawn Keykong is the most visible
election, there are other elections and issues that will also need to be
decided. And, of course, the electronic voting system must be usable in future
elections, too.

The system shall allow a voter to identify themselves through authentication,
after which they shall be presented with the ballot. After making their
selections, the voter shall be offered the opportunity to review and change
their selections. Once submitted, the voter's choices shall be recorded. The
system shall prohibit a voter from voting more than once in the same election.
At the end of the voting day, the system shall determine the winner of each
election and the outcome of each issue.

While it shall be possible for a voter to later view their recorded vote to
confirm that it was recorded correctly, and it shall be possible for a third
party to determine *whether* a particular voter voted, it shall be impossible
for a third party to determine *how* any particular voter voted.

The system shall allow an unlimited number of voters to vote from their own
computers or from a shared computer at a polling location.

-   The system may be implemented in text-mode or with a GUI.

***NOTE: The Voting System 2 team* must *implement their system using a GUI
for the extra scope that is required for a team of 5.***

## Course Scheduling

The Computing College at the University of Never Land (UNL) wants you to
develop a course scheduling system so that it can project course schedules into
the future.

Students in the college shall be able to enter and edit their "4 year schedule"
to describe the courses they plan to take between now and graduation (which may
be greater or fewer than four years in the future). An administrator shall be
able upload the current year's course schedule for other departments (as other
departments' schedules are outside the Computing College's control, we shall
assume they will repeat their annual schedules indefinitely into the future).

When instructed to do so, the system shall provide the administrator with a
proposed schedule for each semester up to four years into the future that will
allow all students to take the computing courses they wish to take. If that is
not possible, the system shall propose a schedule that will maximize the number
of students who can take the courses they wish in the semester they wish, with
preference given to graduating seniors and then to juniors.

-   The system may be implemented in text-mode or with a GUI.
