function keepTheChange(input){
    var bill = Number(input[0]),
        mood = input[1],
        tip = 0;

    if(mood === "happy"){
        tip = bill * 0.1;
    } else if (mood === "married"){
        tip = bill * 0.0005;
    } else if(mood === "drunk"){
        var baseTip = bill * 0.15;
        var firstDigit = baseTip.toString().substring(0,1);
        var pow = parseInt(firstDigit);
        tip = Math.pow(baseTip, pow);
    } else{
        tip = bill * 0.05;
    }
    console.log(tip.toFixed(2));
}

keepTheChange([
    '120.44',
    'happy'
])

keepTheChange([
    '1230.83',
    'drunk'
])