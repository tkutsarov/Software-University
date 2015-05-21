<?php
    $var1 = 15;
    $var2 = 'hello';
    $var3 = 45.12;
    $var4 = [];
    $var5 = true;
    if(is_numeric($var2)){
        var_dump($var2);
    } else{
        echo gettype($var2);
    }
?>

