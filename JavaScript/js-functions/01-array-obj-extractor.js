function extractObjects(input){
    var resultArr = [],
        i;

    for(i = 0; i < input.length; i += 1){
        if((typeof(input[i]) === 'object') && !(input[i] instanceof Array)){
            resultArr.push(input[i]);
        }
    }

    console.log(resultArr);
}

extractObjects([
        "Pesho",
        4,
        4.21,
        { name : 'Valyo', age : 16 },
        { type : 'fish', model : 'zlatna ribka' },
        [1,2,3],
        "Gosho",
        { name : 'Penka', height: 1.65}
    ]
);