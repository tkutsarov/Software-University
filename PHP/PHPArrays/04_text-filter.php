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
            <input type="text" name="banlist"/>            
            <input  type="submit" name="submit" value="Generate"/>
        </form>
        <?php
            $text = $_GET['text'];
            $banlist = $_GET['banlist'];
            $banlistArr = explode(', ', $banlist);
            
            foreach ($banlistArr as $word) {
                $wordReplace = trim($word);
                $wordLength = strlen($wordReplace);
                $replacement = str_repeat('*', $wordLength);
                
                $text = str_replace($wordReplace, $replacement, $text);
            }          
            
            echo $text;
        ?>
    </body>
</html>