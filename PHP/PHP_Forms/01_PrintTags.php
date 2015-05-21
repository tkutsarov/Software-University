<!DOCTYPE HTML>
<html>
    <head>
    <body>
        <?php
            echo '<form method="get" action>';
            echo '<p>Enter Tags:</p>';
            echo '<input type="text" name="tags"/>';
            echo '<input type="submit" name="submit" value="Submit"/>';
            echo '</form>';
            if(isset($_GET['submit'])){
                $tagsArr = explode(', ', $_GET['tags']);
                
                for ($i = 0; $i < count($tagsArr); $i++){
                   echo "$i:" . $tagsArr[$i] . "<br>";
                }
            }
        ?>
    </body>
    </head>
</html>



