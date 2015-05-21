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
               
            <input  type="submit" name="submit" value="Generate"/>
        </form>
        <?php        
            $text = $_GET['text'];
            $text = str_replace( '</a>', '[/URL]', $text);
            $text = str_replace( '<a href="', '[URL=', $text);
            $text = str_replace( '">', ']', $text); 
            
            echo $text;
        ?>
    </body>
</html>