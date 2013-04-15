Animated GIF Encoder
==================

Port of the Java animated GIF encoder to not use AWT classes. The benefit is that this is then compatible with Android (and J2ME?)

The way it handles the pixel data is very inefficient (takes in an array of ints, converts it to an array of bytes, it should just work directly off the array of ints).

See the test directory for usage example.

Originally sourced from here http://www.java2s.com/Code/Java/2D-Graphics-GUI/AnimatedGifEncoder.htm