function filesSort(input){
    var output = {},
        line = [],
        fileName,
        fileExtension,
        fileSizeStr,
        fileSize;

    for(var i in input){
        line = input[i].split(' ');
        fileName = line[0].trim();
        fileExtension = line[1].trim();
        fileSizeStr = line[2].trim();
        fileSize = Number(fileSizeStr.substring(0, fileSizeStr.length - 2));

        if(!output.hasOwnProperty(fileExtension)){
            output[fileExtension] = {};
            output[fileExtension].files = [];
            output[fileExtension].memory = 0;
        }
        if(output[fileExtension].files.indexOf(fileName) === -1){
            output[fileExtension].files.push(fileName);
        }
        output[fileExtension].memory += fileSize;
    }

    output = sortObjProperties(output);
    for(var i in output){
        output[i].files = output[i].files.sort();
        output[i].memory = output[i].memory.toFixed(2);
    }

    output = JSON.stringify(output);
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

filesSort([
    'sentinel .exe 15MB',
    'zoomIt .msi 3MB',
    'skype .exe 45MB',
    'trojanStopper .bat 23MB',
    'kindleInstaller .exe 120MB',
    'setup .msi 33.4MB',
    'winBlock .bat 1MB',
])
