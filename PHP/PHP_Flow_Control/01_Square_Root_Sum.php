<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>Number</td>
                <td>Square</td>
            </tr>          
            <?php
            $sum = 0;
                for($i = 0; $i <= 100; $i+=2) :
            ?>
                <tr>
                    <td><?php echo "$i" ?></td>
                    <td>
                        <?php 
                            $sqrtI = sqrt($i);
                            $sqrtI = round($sqrtI, 2);
                            $sum += $sqrtI;
                            echo "$sqrtI";
                        ?>
                    </td>
                </tr>               
            <?php endfor; ?>
            <tr>
                <td>Total:</td>
                <td><?php echo "$sum" ?></td>
            </tr>
        </table>
    </body>
</html>
