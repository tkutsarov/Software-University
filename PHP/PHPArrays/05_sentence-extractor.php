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
            <input type="text" name="word"/>            
            <input  type="submit" name="submit" value="Generate"/>
        </form>
        <?php
            $text = $_GET['text'];
            $word = $_GET['word'];
             
            $regex = "/([A-Z][^\.\?\!]* $word [^\.\?\!]*[\.\!\?])/";

            if (preg_match_all($regex, $text, $match)){
                foreach ($match[0] as $sentence) {
                    echo $sentence . '<br>';
                }                                 
            }               
        ?>
    </body>
</html>