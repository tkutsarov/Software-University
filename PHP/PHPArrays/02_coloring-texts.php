<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <form method="get" action="#">
            <textarea name="text"></textarea>
            <input  type="submit" name="submit" value="Color text"/>
        </form>
        <?php
            $text = $_GET['text'];
            $text = str_replace(" ", "", $text);
            $textLenght = strlen($text);
            
            for($i = 0; $i < $textLenght; $i++){              
                $letterCode = ord($text[$i]);
                if($letterCode % 2 == 0){
                    echo '<span style="color: red">' . $text[$i] . ' </span>';
                } else{
                    echo '<span style="color: blue">' . $text[$i] . ' </span>';
                }
            }                          
        ?>
    </body>
</html>
