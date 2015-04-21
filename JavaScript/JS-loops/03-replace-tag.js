var str = '<ul>\n <li>\n  <a href=http://softuni.bg>SoftUni</a>\n </li>\n</ul>',
    result;

function replaceATag(input){
    input = input.replace(/<a/g, '[URL');
    input = input.replace(/<\/a>/g, '[/URL]');

    for(var i = 0; i < input.length; i += 1){
        if((input[i] === "[") && (i < input.length - 4)){
            var temp = input[i+1] + input[i+2] + input[i+3];
            if(temp === "URL"){
                for(var j = i + 4; j < input.length; j += 1){
                    if(input[j] === ">"){
                        result = input.substr(0, j) + "]" + input.substr(j+1, input.length + 1);
                        return result;
                    }
                }
            }
        }
    }
}

console.log(replaceATag(str));
