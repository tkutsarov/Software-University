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
            <input type="text" name="category"/>
            <input type="text" name="tags"/>
            <input type="text" name="months"/>
            <input  type="submit" name="submit" value="Generate"/>
        </form>
        <?php
            $categories = $_GET['category'];
            $tags = $_GET['tags'];
            $months = $_GET['months'];
            
            makeSidebar('Categories', $categories);
            makeSidebar('Tags', $tags);
            makeSidebar('Months', $months);
            
            function makeSidebar($type, $text){
                $list = explode(', ', $text);
                echo '<aside style="border: 1px solid black; width:200px;"><h1>' . 
                        $type . '</h1><hr><ul>';
                foreach ($list as $value) {
                    echo "<li><a>$value</a></li>";
                }
                echo '</ul></aside>';
            }
        ?>
    </body>
</html>