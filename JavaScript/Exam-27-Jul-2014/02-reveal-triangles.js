function revealTriangles(input) {
    var i,
        j,
        result = [];

    for (i = 0; i < input.length; i++) {
        result[i] = input[i].slice();
    }


    console.log(input);
    console.log(result);
}
    /*for(i = 0; i < input.length - 1; i++){
        for(j = 0; j < Math.min(input[i + 1].length - 1, input[i].length - 1) ; j++){
            if((input[i][j + 1] === input[i + 1][j]) && (input[i + 1][j] === input[i + 1][j + 1]) &&
            (input[i + 1][j + 1] === input[i + 1][j + 2])){
                result[i][j+1] = '*';
                result[i + 1][j] = '*';
                result[i + 1][j + 1] = '*';
                result[i + 1][j + 2] = '*';
            };
        };
    };

    for(i = 0; i < result.length; i++){
        console.log(result[i].join(''));
    };
}*/

revealTriangles(
    ['abcdexgh'
    ]);
/*revealTriangles(
    ['ax',
    'xxx',
    'b',
    'bbb',
    'bbbb'
]);*/
