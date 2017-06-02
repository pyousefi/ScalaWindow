# Challenge 1 (“time series”) #

This README would normally document whatever steps are necessary to get your application up and running.

### Problem Statement ###
Part of our daily routine consists in efficiently processing time series. One of the common ways to analyze them is to compute local information within a rolling time window of length T, such as:

* number of measurements in a window
* minimum of measurements in a window
* maximum of measurements in a window
* rolling sum.
When implemented well such an analyses could be run on inputs vastly exceeding an amount of RAM on a computer.

The goal is to write a small Scala program performing analysis of price ratios in an efficient way.

The program accepts a path to a file containing time series on a local file system as a command-line argument and print out results of analyses to the standard output.
The length of the rolling time window is 60 seconds.

The problem is solved using only the standard library and a test framework.

### Format of Input File ###
An input file is in plain text. Each line contains a timestamp of a measurement in seconds and the measurement of price ratio as floating point number (which is guaranteed to fit into Scala Double data type). They are separated by a space or a tab character.


### Format of Output ###

The program prints results as a table. Each row represents analysis for one position of rolling window over the time-series. Each row of the output has the following values:

* ET — event time from input in seconds
* T — number of seconds since beginning of epoch at which rolling window ends
* V — measurement of price ratio at time T.
* N — number of measurements in the window.
* RS — a rolling sum of measurements in the window.
* MinV — minimum price ratio in the window.
* MaxV — maximum price ratio the window.

The table has a header aligned with values in the following rows. All floating point numbers are rounded up to 5 decimal points.
The output does not include any other records like slf4j initialization messages or debug output.
