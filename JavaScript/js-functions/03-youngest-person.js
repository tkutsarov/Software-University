function findYoungestPerson(arr){
    var lowestAge = 200,
        index = 0,
        i;

    for (i in arr){
        if(arr[i].hasSmartphone == true){
            if(arr[i].age < lowestAge){
                lowestAge = arr[i].age;
                index = i;
            }
        }
    }

    console.log("The youngest person is " + arr[index].firstname + " " + arr[index].lastname);
}

var people = [
    { firstname : 'George', lastname: 'Kolev', age: 32, hasSmartphone: false },
    { firstname : 'Vasil', lastname: 'Kovachev', age: 40, hasSmartphone: true },
    { firstname : 'Bay', lastname: 'Ivan', age: 81, hasSmartphone: true },
    { firstname : 'Baba', lastname: 'Ginka', age: 40, hasSmartphone: false }]

findYoungestPerson(people);