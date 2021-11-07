
function iniciarMapa(){
    var coord = {lat:13.72128 , lng:-89.20019};
    var map = new google.maps.Map(document.getElementById('map'),{
      zoom: 18,
      center: coord
    });
    var marker = new google.maps.Marker({
      position: coord,
      map: map
    });
}