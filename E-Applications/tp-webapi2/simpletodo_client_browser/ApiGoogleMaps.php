<?php


class Cordonnee {

    public $latitude;
    public $longitiude;

    public function __construct($latitude, $longitiude) {
        $this->latitude = $latitude;
        $this->longitiude = $longitiude;
    }

}

Class GoogleMapApi {

    public $Identifiant; 
    public $nom;
    public $width;
    public $height;

    //Constructeur de l'API Google Maps
    public function __construct($key, $nom) {
        $this->Identifiant = $key;
        $this->nom = $nom;
        $this->width = "300px";
        $this->height = "300px";
        ?>
        <script src="http://maps.google.com/maps?file=api&amp;v=2&amp;sensor=false&amp;key=<?php echo $this->Identifiant; ?>" type="text/javascript">
        </script>
        <?php
    }

    //La taille de la carte à afficher
    public function definirTaille($widthPX, $heigthPX, $unite = 'px') {
        $this->width = $widthPX . $unite;
        $this->height = $heigthPX . $unite;
    }

    //Connexion au serveur distant et récupérer les coordonnées du lieu
    public function getCoordonnees($adr) {
        $URL = 'http://maps.googleapis.com/maps/api/geocode/json?address=' . $adr . '&sensor=false';
        $ch = curl_init();
        curl_setopt($ch, CURLOPT_URL, $URL);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
        $resultat = curl_exec($ch);

        $res = json_decode($resultat, true);

	//on parcourt l'arbre json pour arriver à la latitude et à la longitude
        if ($res != null) {
            $latitude = $res['results'][0]['geometry']['location']['latitude'];
            $longitiude = $res['results'][0]['geometry']['location']['lng'];
            $cordonnee = new Cordonnee($latitude, $longitiude);
            return $cordonnee;
        }
        return null;
    }

    //affichage de la carte Google Maps
    public function affichageMap($lieu) {
        ?>
        <div id="Map<?php echo $lieu; ?>" style="width: <?php echo $this->width ?>; height: <?php echo $this->height ?>;  border: 1px solid #b4b4b4;"></div> 
        <?php
    }

    public function generateCallBack($newAddress) {
        echo "callback('" . $newAddress . "')";
    }

    //Appel de l'API
    public function appelApi($adresse) {
        ?>
        <input type="hidden"  id="adr" value="<?php echo $adresse; ?>" /> &nbsp; 
        <script type="text/javascript" src="js/googleApi.js">
        </script>
        <?php
    }

}
?>
