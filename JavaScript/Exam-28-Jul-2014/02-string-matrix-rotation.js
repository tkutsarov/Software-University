function rotateMatrix(input){
    var maxLength = input[1].length,
        rotate = 0,
        temp = input[0],
        turns = 0,
        i;

    input = input.slice(1);
    rotate = parseInt(temp.match(/([1-9])\w+/g));

    for(i in input){
        if(maxLength < input[i].length){
            maxLength = input[i].length;
        };
    };

    for(i = 0; i < input.length; i++){
        for( var char = 0; char < maxLength; char++){
            if(input[i][char] == undefined){
                input[i] = input[i] + ' ';
            };
        };
    };

    function rotateNinetyDegrees(matrix){
        var arr = [];
        for(var col = 0; col < matrix[0].length; col++){
            var newRow = '';
            for(var row = matrix.length - 1; row >= 0; row--){
                newRow += matrix[row][col];
            };
            arr[col] = newRow;
        };
        return arr;
    };

    turns = rotate / 90;
    for(var shift = 1; shift <= turns; shift++){
        input = rotateNinetyDegrees(input);
    };

    for(var rowIndex in input){
        console.log(input[rowIndex]);
    };
};

rotateMatrix([
    'Rotate(270)',
    'hello',
    'softuni',
    'exam'
])
