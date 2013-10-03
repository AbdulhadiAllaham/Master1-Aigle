

var indexOf = 0;
var indexMax= document.getElementById('indexMax').getAttribute('value');

// image suivante
function updateImage(id,lieu){
    indexOf++;
    if(indexOf>=indexMax) indexOf=0;
    var src=document.getElementById(lieu+indexOf).getAttribute('value');
    document.getElementById('IMG'+id).setAttribute('src', src);
}

//image précédente
function minusImage(id,lieu){
    indexOf--;
    if(indexOf>=indexMax) indexOf=0;
    var src=document.getElementById(lieu+indexOf).getAttribute('value');
    document.getElementById('IMG'+id).setAttribute('src', src);
}


