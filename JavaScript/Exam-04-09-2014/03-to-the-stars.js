function toTheStars(input){
    var starSystem1 = input[0].split(' '),
        ss1X = Number(starSystem1[1]),
        ss1Y = Number(starSystem1[2]),
        starSystem2 = input[1].split(' '),
        ss2X = Number(starSystem2[1]),
        ss2Y = Number(starSystem2[2]),
        starSystem3 = input[2].split(' '),
        ss3X = Number(starSystem3[1]),
        ss3Y = Number(starSystem3[2]),
        shipCords = input[3].split(' '),
        shipX = Number(shipCords[0]),
        shipY = Number(shipCords[1]),
        moves = Number(input[4]),
        i;

    for(i = 0; i <= moves; i++ ){
        if((shipX >= ss1X - 1 ) && (shipX <= ss1X + 1) &&
        (shipY >= ss1Y - 1) && (shipY <= ss1Y + 1)){
            console.log(starSystem1[0].toLowerCase());
        } else if((shipX >= ss2X - 1 ) && (shipX <= ss2X + 1) &&
            (shipY >= ss2Y - 1) && (shipY <= ss2Y + 1)){
            console.log(starSystem2[0].toLowerCase());
        } else if((shipX >= ss3X - 1 ) && (shipX <= ss3X + 1) &&
            (shipY >= ss3Y - 1) && (shipY <= ss3Y + 1)){
            console.log(starSystem3[0].toLowerCase());
        } else{
            console.log("space");
        }
        shipY += 1;
    }
}

toTheStars([
    'Sirius 3 7',
    'Alpha-Centauri 7 5',
    'Gamma-Cygni 10 10',
    '8 1',
    '6'
])

toTheStars([
    'Terra-Nova 16 2',
    'Perseus 2.6 4.8',
    'Virgo 1.6 7',
    '2 5',
    '4'
])
