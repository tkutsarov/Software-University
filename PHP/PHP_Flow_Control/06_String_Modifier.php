<!DOCTYPE HTML>
<html>
    <head>
    <body>       
        <form method="post" action>
        <p>Enter a list of integers:</p>
        <input type="text" name="input"/>
        <input type="radio" name="function" value="palindrome"/>
        <label>Check Palindrome</label>
        <input type="radio" name="function" value="reverse"/>
        <label>Reverse string</label>
        <input type="radio" name="function" value="split"/>
        <label>Split</label>
        <input type="radio" name="function" value="hash"/>
        <label>Hash</label>
        <input type="radio" name="function" value="shuffle"/>
        <label>Shuffle string</label>
        <input type="submit" name="submit" value="Submit"/>
        </form>
        <?php
            if(isset($_POST['submit']) && isset($_POST['function'])){    
                $choice = $_POST['function'];
                $value = $_POST['input'];
                        
                function palindromeCheck($input){
                    $a = strtolower(preg_replace("/[^A-Za-z0-9]/","",$input));
                    return $a==strrev($a);
                }
                
                function extractStrings($input){
                    $result = preg_replace("/[^a-zA-Z]+/", "", $input); 
                    for($i = 0; $i < strlen($result); $i++){
                        echo "$result[$i] ";
                    }                   
                }
               
                switch($choice){
                    case 'palindrome':                                         
                        if(palindromeCheck($value)){
                            echo "$value is a palindrome.";
                        } else{
                            echo "$value is not a palindrome.";
                        }                  
                        break;
                    case 'reverse': strrev($value);             
                        break;
                    case 'split': extractStrings($value);             
                        break;
                    case 'hash': echo crypt($value);             
                        break;
                    case 'shuffle': echo str_shuffle($value);             
                        break;
                    default: echo 'switch';                       
                }              
            }
        ?>
    </body>
    </head>
</html>