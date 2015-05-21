<!DOCTYPE HTML>
<html>
    <head>
    <body>       
        <form method="get" action>
        <p>Enter number of years:</p>
        <input type="text" name="years"/>
        <input type="submit" name="submit" value="Show costs"/>
        </form>
        <?php
            if(isset($_GET['submit'])){                
                $years = htmlentities($_GET['years']);
                $startingYear = 2014;
                
                if($years > 0){
                    echo '<table border="1"><tr><td>Year</td><td>January</td>' .
                            '<td>February</td><td>March</td><td>April</td><td>May</td>' .
                            '<td>June</td><td>July</td><td>August</td><td>September</td>' .
                            '<td>October</td><td>November</td><td>December</td><td>Total:</td></tr>';
                    for($i = 1; $i <= $years; $i++){
                        $randNums = [];
                        $sum = 0;
                        
                        for($num = 0; $num < 12; $num++){
                            $randNums[$num] = rand(0, 999);
                            $sum += $randNums[$num];
                        }
                    
                        echo '<tr><td>' . $startingYear . '</td><td>' . $randNums[0] . '</td><td>' .
                            $randNums[1] . '</td><td>' . $randNums[2] . '</td><td>' .
                            $randNums[3] . '</td><td>' . $randNums[4] . '</td><td>' .
                            $randNums[5] . '</td><td>' . $randNums[6] . '</td><td>' .
                            $randNums[7] . '</td><td>' . $randNums[8] . '</td><td>' .
                            $randNums[9] . '</td><td>' . $randNums[10] . '</td><td>' .
                            $randNums[11] . '</td><td>' . $sum . '</td></tr>';
                        
                        $startingYear--;
                    }
                }else{
                    echo 'The years have to be a positive integer!';
                }
                
            }
        ?>
    </body>
    </head>
</html>