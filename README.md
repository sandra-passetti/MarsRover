# Mars Rover
This is the Platform45 Mars Rover Technical Challenge solution
as implemented by Sandra Passetti.

#Assumptions
We must not allow rovers to go outside the grid, even if the
movement instructions would place them there.
Rovers can navigate around each other if needed (they won't
drive into each other on their way to their final position).

#Installation and Use
Download the repository from GitHub.

You may choose to run the code using an IDE, or the command line.
Below I will give an example of running the code using IntelliJ:
1. Open the project
2. Click the downwards arrow next to the button that has "Main"
written on it. This opens a menu.
3. In the menu, click on "Edit configurations". This opens a popup.
4. In the popup, under "Build and Run", add an argument in the
   box that is for passing CLI arguments into main. The argument should 
   be the path to the file you want to use as input. You can use any
   of the test files provided in "resources" or choose your own.
   An example is "./resources/validInputExample.txt".
5. Click Apply and close the popup.
6. Run Main using the green play button.

#Testing
This implementation has been tested to work with multiple rovers,
large grids (e.g. 1000 , 1000) and long sequences of moves (350+).