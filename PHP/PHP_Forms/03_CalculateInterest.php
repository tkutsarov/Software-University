<!DOCTYPE HTML>
<html>
    <head>
    </head>
    <body>
        <form method="get" action>
            <p>Enter Amount</p>
            <input type="number" name="amount"/>
            <input type="radio" name ="currency" value="USD"/>USD
            <input type="radio" name ="currency" value="EUR"/>EUR
            <input type="radio" name ="currency" value="BGN"/>BGN
            <p>Compound Interest Amount</p>
            <input type="number" name ="interest"/>
             <select name="period">
                <option value="6">6 Months</option>
                <option value="12">1 Year</option>
                <option value="24">2 Years</option>
                <option value="60">5 Years</option>
              </select> 
            <input type="submit" name="submit" value="Calculate"/>
        </form>
        <?php            
            if(isset($_GET['submit'])){
                $period = intval($_GET['period']);
                $amount = intval($_GET['amount']);
                $interest = floatval($_GET['interest']) / 12;
                $currency = '';
                switch($_GET['currency']){
                    case 'USD': $currency = '$';
                        break;
                    case 'EUR': $currency = '&#x20ac';
                        break;
                    case 'BGN': $currency = 'BGN';
                        break;
                    default: echo 'Check the switch statement!';
                        break;
                }
                               
                for($i = 1; $i <= $period; $i++){
                    $amount += $amount * ($interest / 100);
                }
                
                echo $currency . ' ' . round($amount, 2);
            }
        ?>
    </body>
    
</html>



