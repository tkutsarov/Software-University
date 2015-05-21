<!DOCTYPE HTML>
<html>
    <head>
    <body>       
        <form method="get" action>
        <p>Enter a list of integers:</p>
        <input type="text" name="input"/>
        <input type="submit" name="submit" value="Submit"/>
        </form>
        <?php
            if(isset($_GET['submit'])){                
                $input = explode(', ', $_GET['input']);
                //var_dump($input);
                echo '<table border="1">';
                for($i = 0; $i < count($input); $i++){
                    if(ctype_digit($input[$i])){
                        $num = (int)$input[$i];
                        $sum = 0;
                        while($num > 0){
                            $digit = $num % 10;
                            $num = $num / 10;
                            $sum += $digit;
                        }
                        
                        echo "<tr><td>$input[$i]</td><td>$sum</td></tr>"; 
                    }else{
                        echo "<tr><td>$input[$i]</td><td>I cannot sum that</td></tr>"; 
                    }
                }
            }
        ?>
    </body>
    </head>
</html>