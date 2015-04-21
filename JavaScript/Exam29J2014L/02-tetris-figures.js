function tetrisFigures(input){
    var result = {"I": 0, "L": 0, "J":0, "O":0, "Z":0, "S":0, "T":0},
        rowLength = input[0].length;

    // I search
    if(input.length > 3){
        for(var row = 0; row < input.length - 3; row++){
            for(var col = 0; col < input[row].length; col++){
                if((input[row][col] === input[row + 1][col]) &&
                    (input[row + 1][col] === input[row + 2][col]) &&
                    (input[row + 2][col] === input[row + 3][col]) &&
                    (input[row + 3][col] === "o")){
                    result.I += 1;
                }
            }
        }
    }

    // L search
    if((input.length > 2) && (rowLength > 1)){
        for(var row = 0; row < input.length - 2; row++){
            for(var col = 0; col < input[row].length - 1; col++){
                if((input[row][col] === input[row + 1][col]) &&
                    (input[row + 1][col] === input[row + 2][col]) &&
                    (input[row + 2][col] === input[row + 2][col + 1]) &&
                    (input[row + 2][col] === "o")){
                    result.L += 1;
                }
            }
        }
    }

    // J search
    if((input.length > 2) && (rowLength > 1)){
        for(var row = 0; row < input.length - 2; row++){
            for(var col = 1; col < input[row].length; col++){
                if((input[row][col] === input[row + 1][col]) &&
                    (input[row + 1][col] === input[row + 2][col]) &&
                    (input[row + 2][col] === input[row + 2][col - 1]) &&
                    (input[row + 2][col - 1] === "o")){
                    result.J += 1;
                }
            }
        }
    }

    // O search
    if((input.length > 1) && (rowLength > 1)){
        for(var row = 0; row < input.length - 1; row++){
            for(var col = 0; col < input[row].length - 1; col++){
                if((input[row][col] === input[row][col + 1]) &&
                    (input[row][col + 1] === input[row + 1][col]) &&
                    (input[row + 1][col] === input[row + 1][col + 1]) &&
                    (input[row + 1][col + 1] === "o")){
                    result.O += 1;
                }
            }
        }
    }

    // Z search
    if((input.length > 1) && (rowLength > 2)){
        for(var row = 0; row < input.length - 1; row++){
            for(var col = 0; col < input[row].length - 2; col++){
                if((input[row][col] === input[row][col + 1]) &&
                    (input[row][col + 1] === input[row + 1][col + 1]) &&
                    (input[row + 1][col + 1] === input[row + 1][col + 2]) &&
                    (input[row + 1][col + 2] === "o")){
                    result.Z += 1;
                }
            }
        }
    }

    // S search
    if((input.length > 1) && (rowLength > 2)){
        for(var row = 1; row < input.length; row++){
            for(var col = 0; col < input[row].length - 2; col++){
                if((input[row][col] === input[row][col + 1]) &&
                    (input[row][col + 1] === input[row - 1][col + 1]) &&
                    (input[row - 1][col + 1] === input[row - 1][col + 2]) &&
                    (input[row - 1][col + 2] === "o")){
                    result.S += 1;
                }
            }
        }
    }

    // T search
    if((input.length > 1) && (rowLength > 2)){
        for(var row = 0; row < input.length - 1; row++){
            for(var col = 0; col < input[row].length - 2; col++){
                if((input[row][col] === input[row][col + 1]) &&
                    (input[row][col + 1] === input[row][col + 2]) &&
                    (input[row][col + 2] === input[row + 1][col + 1]) &&
                    (input[row + 1][col + 1] === "o")){
                    result.T += 1;
                }
            }
        }
    }

    //function findMatched(input, startRow, startCol, endRow, endCol, objProperty){
    //
    //}

    var strResult = JSON.stringify(result);

    console.log(strResult);
}

tetrisFigures([
    "--o--o-",
    "--oo-oo",
    "ooo-oo-",
    "-ooooo-",
    "---oo--",
])