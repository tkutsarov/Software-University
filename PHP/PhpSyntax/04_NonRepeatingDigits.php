<?php
    $n = 198;
    if($n > 101){
        for($i = 102; $i <= $n && $i < 988; $i++){
            $thirdDigit = $i % 10;
            $secondDigit = ($i / 10) % 10;
            $firstDigit = ($i / 100) % 10;
            if(($firstDigit != $secondDigit) && ($secondDigit != $thirdDigit) &&
                    ($firstDigit != $thirdDigit)){
                if($i != $n && $i != 987){
                    echo $i.', ';
                } else{
                    echo $i;
                }
            }
        }
    } else{
        echo 'no';
    }
?>

