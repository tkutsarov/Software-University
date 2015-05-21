<!DOCTYPE HTML>
<html>
    <head>
    <body>       
        <form method="get" action>
        <p>Enter Cars:</p>
        <input type="text" name="cars"/>
        <input type="submit" name="submit" value="Submit"/>
        </form>
        <?php
            if(isset($_GET['submit'])){                
                $cars = explode(', ', $_GET['cars']);
                
                function random_color_part() {
                    return str_pad( dechex( mt_rand( 0, 255 ) ), 2, '0', STR_PAD_LEFT);
                }

                function random_color() {
                    return random_color_part() . random_color_part() . random_color_part();
                }
                
                echo '<table border="1">'; 
                echo '<tr><td>Car</td><td>Color</td><td>Count</td></tr>';
                
                foreach ($cars as $car) {                   
                    echo '<tr><td>' . $car . '</td><td>' . random_color() .
                            '</td><td>' . rand(1, 5) . '</td></tr>';
                }
               
                echo '</table>';
            }
        ?>
    </body>
    </head>
</html>