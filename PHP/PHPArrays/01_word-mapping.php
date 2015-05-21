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
            <input  type="submit" name="submit" value="Count words"/>
        </form>
        <?php
            $text = strtolower($_GET['text']);
            $result = countWords($text);
            
            echo '<table border="1">';
            foreach ($result as $key => $value) {
                echo "<tr><td>$key</td><td>$value</td></tr>";
            }
        
            function countWords($text)
            {
                $output = array();
                $words = array();
                
                preg_match_all("/[A-Za-z'-]+/", $text, $words); 

                foreach ($words[0] as $word)
                {
                    if (!array_key_exists($word, $output)){
                        $output[$word] = 0;
                    }
                    $output[$word]++; 
                }
                return $output;
            }
        ?>
    </body>
</html>
