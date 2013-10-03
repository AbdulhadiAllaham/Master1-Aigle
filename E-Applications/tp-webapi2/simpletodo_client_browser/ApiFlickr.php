<?php

class ApiFlickr {

    public $Identifiant;
    public $nomApi;
    public $nombreImages;
    public $width;
    public $height;

    //Taille de l'image à afficher
    public function definirTaille($width, $height, $unite = 'px') {
        $this->width = $width . $unite;
        $this->height = $height . $unite;
    }

    //constructeur de l'api Flickr
    public function __construct($nomApi, $key, $nombre) {
        $this->Identifiant = $key;
        $this->nomApi = $nomApi;
        $this->nombreImages = $nombre;
        $this->width = "100px";
        $this->height = "300px";
        ?>
        <input type="hidden" id="imageMax" value="<?php echo $this->nombreImages; ?>"/>

        <script type="text/javascript" src="js/ApiFlickr.js">
        </script>
        <?php
    }

    //Se connecter au serveur distant et récupérer des images à l'aide d'une URL
    public function getFlickrPhotos($lieu) {
        $URL = 'http://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=' . $this->Identifiant . '&text=' . $lieu . '&sort=relevance&per_page=' . $this->nombreImages . '&format=json&nojsoncallback=1';
	
        $ch = curl_init();
        curl_setopt($ch, CURLOPT_URL, $URL);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
        $resultat = curl_exec($ch);
        $res = json_decode($resultat, true);

        $data = array();
	//récupérer les photos
        foreach ($res['photos']['photo'] as $ele) {
            $inter = 'http://farm' . $ele['farm'] . '.staticflickr.com/' . $ele['server'] . '/' . $ele['id'] . '_' . $ele['secret'] . '.jpg';
            $data[] = $inter;
        }
        return $data; 
    }

    // Affichage des photos
    public function printFlickrPhotos($id, $lieu) {
        $data = $this->getFlickrPhotos($lieu);
        $i = 0;
        foreach ($data as $ele) {
            ?>

            <input type="hidden" value="<?php echo $ele ?>"  id="<?php echo $lieu . $i; ?>"/>

            <?php
            $i++;
        }
        ?>      
        <div>
            <img id="IMG<?php echo $id; ?>" style="width: <?php echo $this->width; ?>; height: <?php echo $this->height ?>;  border: 1px solid #b4b4b4;" 
                 src="<?php echo $data[0]; ?>"/> <br/>
            <div>  
		<p align="center">
		    <input type="button" style="width: 150px; height: 35px;" value="Précédent" onclick="minusImage('<?php echo $id; ?>', '<?php echo $lieu; ?>');" />
            <input type="button" style="width: 150px; height: 35px;" value="Suivant" onclick="updateImage('<?php echo $id; ?>', '<?php echo $lieu; ?>');" />
		
		</p>
            </div>
        </div>
        <?php
    }

}
?>
