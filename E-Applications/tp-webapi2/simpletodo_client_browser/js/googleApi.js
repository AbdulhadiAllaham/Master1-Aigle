
function callback(newAdress)
{
    document.getElementById('adr').setAttribute('value', newAdress);
    update();
}

function update(){
    var address = document.getElementById('adr').value;
    var geocoder = new GClientGeocoder();
    var z = 14;
    geocoder.getLatLng(
        address,function(point) {
            if (!point) {
                alert("- "+address+" n'existe pas");
		} else {
                    var a =  point.lat();						
                    var b =  point.lng();
                    initialize3(address,a,b,z);
                }});					
}

function initialize3(address,a,b,z) {
    var map = new GMap2(document.getElementById('Map'+address));	
    map.addControl(new GLargeMapControl3D()); 
    map.addControl(new GMenuMapTypeControl());
    map.setMapType(G_HYBRID_MAP);				
    map.checkResize();
    map.setCenter(new GLatLng(a,b), z);				               
    if(address!=''){
        var geocoder = new GClientGeocoder();
        geocoder.getLatLng(address, function(point){map.setCenter(point,z);});
    }
    var markerMember = GMarker(new GLatLng(a,b)); // Ajout du marqueur
    map.addOverlay(markerMember);        
}

update();

