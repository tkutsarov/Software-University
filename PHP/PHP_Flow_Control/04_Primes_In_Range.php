<!DOCTYPE HTML>
<html>
    <head>
    <body> 
        <form method="get" action>
            <p>Enter number of years:</p>
            <input type="text" name="start"/>
            <input type="text" name="end"/>
            <input type="submit" name="submit" value="Submit"/>
        </form>

        <?php
            if(isset($_GET['submit'])){
                function checkPrime($num){
                    if($num < 2){
                        return false;
                    } else{                                                                      
                        $endOfPrimesCheck = floor(sqrt($num));
                        for($j = 2; $j <= $endOfPrimesCheck; $j++){
                            if($num % $j == 0){
                                return false;
                            }
                        } 
                        return true;
                    }          
                }

                $start =  (int)$_GET['start'];
                $end = (int)$_GET['end'];
                $result = array();
                for($num = $start; $num <= $end; $num++){          
                    $result[] = $num;         
                }

                $output = '';
                for($i = 0; $i < count($result); $i++){
                    if(checkPrime($result[$i])){
                        $output = $output . "<b>" . $result[$i] . "</b>, ";
                    } else{
                        $output = $output . "$result[$i], ";
                    }
                }       

                echo substr($output, 0, strlen($output) - 2);
            }
        ?>
    </body>
    </head>
</html>