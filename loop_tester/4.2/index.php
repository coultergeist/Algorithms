<?php
//lab4.2/index.php (from ch0_ex2)
//used with number_tester.php

/*
 * Class:       AD 320 WI 18
 * Author:      Danielle Coulter
 * Title:       Index.php (used for lab4.2)
 * Due Date:    Jan 24, 2018
*/

//set default values
$number1 = 78;
$number2 = -105.33;
$number3 = 0.0049;
$message = 'Enter some numbers and click on the Submit button.';
$error = 'You must compelte the fields in order to view Statistics.';

//process
$action = filter_input(INPUT_POST, 'action');
switch ($action) {
    case 'process_data':
        
        $number1 = (integer)filter_input(INPUT_POST, 'number1');
        $number2 = filter_input(INPUT_POST, 'number2');
        $number3 = (float)filter_input(INPUT_POST, 'number3');
        // make sure the user enters three numbers
        if (isset($number1, $number2, $number3)) {
            // make sure the numbers are valid
            if (is_numeric($number1) && is_numeric($number2) && is_numeric($number3) && !empty($number1) && !empty($number2) && !empty($number3)) {
                // get the ceiling and floor for $number2
                $number2_ceil = ceil($number2);
                $number2_floor = floor($number2);
                // round $number3 to 3 decimal places
                $number3_rounded = round($number3, 3);
                // get the max and min values of all three numbers
                $max = max($number1, $number2, $number3);
                $min = min($number1, $number2, $number3);
                // generate a random integer between 1 and 100
                $random = mt_rand(1, 100);
                // format the message
                //$message = "This page is under construction.\n" .
                //          "Please write the code that process the data.";
                $message =
                    "Number 1: $number1\n" .
                    "Number 2: $number2\n" .
                    "Number 3: $number3\n" .
                    "\n" .
                    "Number 2 ceiling: $number2_ceil\n" .
                    "Number 2 floor: $number2_floor\n" .
                    "Number 3 rounded: $number3_rounded\n" .
                    "\n" .
                    "Min: $min\n" .
                    "Max: $max\n" .
                    "\n" .
                    "Random: $random\n";

            } else{
                print $error;
            }
        }
}

include 'number_tester.php';
?>