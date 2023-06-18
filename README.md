# Protogame
Simple school project prototype for making a game without graphics, 

Feel free to write here, we can use this both as todo-list and also as documentation of what's done

## The idea 
It is an Android app with two button which take exactly half the screen, on can press them without seing.
The "Map" is a simple 2D arrays.
We listen for events (button press and gyro and shake) then using this information we update the state of the game (`MainLoop.update()`) Uuing the info from the buttons and sensors.
This makes it easy performance friendly and good enough for a proof of concept.

##Tasks
- Add the listener for the buttons
- Add listener for the sensors and process their inputs
- Implement `MainLoop.update()`
