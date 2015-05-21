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
                $result = [];
                
                for ($i = 0; $i < count($tagsArr); $i++){
                   if(array_key_exists($tagsArr[$i], $result)){
                       $result[$tagsArr[$i]] = $result[$tagsArr[$i]] + 1;
                   } else {
                       $result[$tagsArr[$i]] = 1;
                   }
                }
                
                arsort($result);
                
                foreach ($result as $key => $value){
                    echo $key . ' : ' . $value . ' times<br>';
                }
            }
        ?>
    </body>
    </head>
</html>



