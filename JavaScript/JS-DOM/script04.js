
var HTMLGenerator = {
    createParagraph: function (id,text){
        var parent = document.getElementById(id);
        var newElement = document.createElement("p");
        newElement.innerHTML = text;
        parent.appendChild(newElement);
    },
    createDiv: function (id, elClass){
        var parent = document.getElementById(id);
        var newElement = document.createElement("div");
        newElement.className = elClass;
        parent.appendChild(newElement);
    },
    createLink: function (id, text, url){
        var parent = document.getElementById(id);
        var newElement = document.createElement("a");
        newElement.link = url;
        newElement.innerHTML = text;
        parent.appendChild(newElement);
    }
};

HTMLGenerator.createParagraph('wrapper', 'Soft Uni');
HTMLGenerator.createDiv('wrapper', 'section');
HTMLGenerator.createLink('book', 'C# basics book', 'http://www.introprogramming.info/');
