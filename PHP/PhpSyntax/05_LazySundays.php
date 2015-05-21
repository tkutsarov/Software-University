<?php
    function getSundays($year,$month){
        return new DatePeriod(
                new DateTime("first sunday of $year-$month"),
                DateInterval::createFromDateString('next sunday'),
                new DateTime("next month $year-$month-01")
                );
    }
    
    foreach (getSundays(2015, 04) as $sunday){
        echo $sunday->format("jS F, Y")."<br>" ;
    }
?>

