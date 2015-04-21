function sortStudentsGrades(input){
    var rawOutput = {},
        name,
        course,
        grade,
        visits;

    for(var i = 0; i < input.length; i++){
        var line = input[i].split("|");
        name = line[0].trim();
        course = line[1].trim();
        grade = Number(line[2].trim());
        visits = Number(line[3].trim());

        if(!rawOutput.hasOwnProperty(course)){
            rawOutput[course] = {};
            rawOutput[course].sumOfGrades = grade;
            rawOutput[course].gradesCount = 1;
            rawOutput[course].sumOfVisits = visits;
            rawOutput[course].visitsCount = 1;
            rawOutput[course].students = [name];
        } else {
            rawOutput[course].sumOfGrades += grade;
            rawOutput[course].gradesCount += 1;
            rawOutput[course].sumOfVisits += visits;
            rawOutput[course].visitsCount += 1;
            if(rawOutput[course].students.indexOf(name) === -1){
                rawOutput[course].students.push(name);
            }
        }
    }

    for(var i in rawOutput){
        rawOutput[i].avgGrade = (rawOutput[i].sumOfGrades / rawOutput[i].gradesCount).toFixed(2);
        rawOutput[i].avgGrade = Number(rawOutput[i].avgGrade);
        rawOutput[i].avgVisits = (rawOutput[i].sumOfVisits / rawOutput[i].visitsCount).toFixed(2);
        rawOutput[i].avgVisits = Number(rawOutput[i].avgVisits);
        delete rawOutput[i].sumOfGrades;
        delete rawOutput[i].gradesCount;
        delete rawOutput[i].sumOfVisits;
        delete rawOutput[i].visitsCount;
    }

    rawOutput = sortObjProperties(rawOutput);
    for(var i in rawOutput){
        rawOutput[i] = sortObjProperties(rawOutput[i]);
        rawOutput[i].students = rawOutput[i].students.sort();
    }

    var output = JSON.stringify(rawOutput);
    console.log(output);

    function sortObjProperties(obj){
        var sortedObj = {},
            arr = [],
            key;

        for(key in obj){
            arr.push(key);
        }
        arr.sort();
        for(key in arr){
            sortedObj[arr[key]] = obj[arr[key]];
        }
        return sortedObj;
    }
}

sortStudentsGrades([
    'Peter Nikolov | PHP  | 5.50 | 8',
    'Maria Ivanova | Java | 5.83 | 7',
    'Ivan Petrov   | PHP  | 3.00 | 2',
    'Ivan Petrov   | C#   | 3.00 | 2',
    'Peter Nikolov | C#   | 5.50 | 8',
    'Maria Ivanova | C#   | 5.83 | 7',
    'Ivan Petrov   | C#   | 4.12 | 5',
    'Ivan Petrov   | PHP  | 3.10 | 2',
    'Peter Nikolov | Java | 6.00 | 9'
]);
