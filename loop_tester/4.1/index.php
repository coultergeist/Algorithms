<?php
//lab4.1/index.php (from ch0_ex1)

/*
 * Class:       AD 320 WI 18
 * Author:      Danielle Coulter
 * Title:       Index.php (used for lab4.1)
 * Due Date:    Jan 24, 2018
*/

//set default values
$name = '';
$email = '';
$phone = '';
$message = 'Enter some data and click on the Submit button.';

 

//process p.249
$action = filter_input(INPUT_POST, 'action');

switch ($action) {
    case 'process_data':
        $name = filter_input(INPUT_POST, 'name');
        $email = filter_input(INPUT_POST, 'email');//FILTER_VALIDATE_EMAIL pg478
        $phone = filter_input(INPUT_POST, 'phone');

        /*************************************************
         * validate and process the name
         ************************************************/
        // 1. make sure the user enters a name
        if (empty($name)){
            echo 'You must enter your name. Please try again.';
            break;
        }
        // 2. display the name with only the first letter capitalized
        $length = strlen($name);
        $name = ucwords(substr($name, 0)); //assigns first name as substring of name

        /*************************************************
         * validate and process the email address
         ************************************************/
        // 1. make sure the user enters an email
        if (empty($email)){
            echo 'You must enter an email address.';
            break;
        // 2. make sure the email address has at least one @ sign and one dot character
        }else if (strpos($email, '@') === false){
            echo 'That email does not contain the @ symbol. Please try again.';
            break; 
        }else if (strpos($email, '.') === false){
            echo 'That email does not contain the . symbol. Please try again.';
            break;
        }
        /*************************************************
         * validate and process the phone number
         ************************************************/
        // 1. make sure the user enters at least seven digits, not including formatting characters
        
        $phone = preg_replace("/[ˆ0-9]/", "", $phone); //remove spc char from phone input

        if (empty($phone)){
            echo 'You must enter a phone number.';
        ///***********encountering error here through phone     
        }else if(strlen($phone < 7)){
            echo 'Your phone number does not contain enough digits. Please try again.';
            
        // 2. format the phone number like this 123-4567
        }else if (strlen($phone) == 7) {
            $part1 = substr($phone, 0, 3);
            $part2 = substr($phone, 3);
            $phone = $part1 . '-' . $part2;
        }
        
        if(strlen($phone > 7)){
            echo 'Your phone number contains dfdfdf many digits. Please try again.';
            
        // 2. format the phone number like this 123-456-7890

        }else{
            $part1 = substr($phone, 0, 3);
            $part2 = substr($phone, 3, 3);
            $part3 = substr($phone, 6);
            $phone = $part1 . '-' . $part2 . '-' . $part3; 
        }
        
        /*************************************************
         * Display the validation message
         ************************************************/
        
        $message = 
                "Hello $name,\n\n " .         
                "Thank you for entering this data:\n\n" . //\n pg 265                
                "Name: $name\n" . //pg 263
                "Email: $email\n" .
                "Phone: $phone";
                    
        break;
}
include 'string_tester.php';
?>