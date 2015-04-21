function createParagraph(id, text){
    var parent = document.getElementById(id);
    var newElement = document.createElement("p");
    newElement.innerHTML = text;
    parent.appendChild(newElement);
}

createParagraph('wrapper', 'Some text');

