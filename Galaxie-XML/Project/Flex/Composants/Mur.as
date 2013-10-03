package Composants
{
        import mx.containers.Canvas;
        import mx.controls.Alert;

        public class Mur extends Canvas
        {
                public var x1:int;
                public var y1:int;
                public var x2:int;
                public var y2:int;

                // Coordonnées basses du plan du fond
                public var x1f:Number;
                public var y1f:Number;
                public var x2f:Number;
                public var y2f:Number;

                public var h:int;

                public var angleRadians:Number;
                public var angleDegres:Number;

                public var moinsZ:Number;
                public var offsetX:Number;

                public var json:String = "";

                public function Mur(x1:int, y1:int, x2:int, y2:int, pas:uint, offset_x:int, offset_y:int, hauteur:int)
                {	
                       var x1f:Number;
                       var y1f:Number;
                       var x2f:Number;
                       var y2f:Number;

                        this.x1 = x1/pas - offset_x;
                        this.y1 = y1/pas - offset_y;
                        this.x2 = x2/pas - offset_x;
                        this.y2 = y2/pas - offset_y;
                        this.h = hauteur;

                        var adjacent:Number = Math.abs(this.x2-this.x1);
                        var hypotenuse:Number = Math.abs(Math.sqrt(Math.pow(this.x2-this.x1,2) + Math.pow(this.y2-this.y1,2)));
                        this.angleRadians = Math.acos(adjacent/hypotenuse);
                        this.angleDegres = 180*angleRadians/Math.PI;
			//Alert.show("adj = "+adjacent+" hyp = "+hypotenuse+" angleR = "+angleRadians+" angleD = "+angleDegres);

                        moinsZ = Math.acos(angleRadians) * pas/2;
                        var angleComplementaire:Number = Math.PI*(90 - this.angleDegres)/180;
                        offsetX = Math.acos(angleComplementaire) * pas/2;
                        //Alert.show("moinsZ = "+moinsZ + " offsetX = "+offsetX);

                        // Mur s'éloignant (montant sur la grille)
                        if (y2 < y1) {
                               x1f = x1 - offsetX;
                               y1f = y1 - moinsZ;
                               x2f = x2 - offsetX;
                               y2f = y2 - moinsZ;
                        }
                        else {
                               x1f = x1 + offsetX;
                               y1f = y1 - moinsZ;
                               x2f = x2 + offsetX;
                               y2f = y2 - moinsZ;
                        }
                        this.x1f = Math.round((x1f/pas - offset_x)*100)/100;
                        this.y1f = Math.round((y1f/pas - offset_y)*100)/100;
                        this.x2f = Math.round((x2f/pas - offset_x)*100)/100;
                        this.y2f = Math.round((y2f/pas - offset_y)*100)/100;

                        paint(x1, y1, x2, y2, 1);
                        paint(x1f, y1f, x2f, y2f, 2);
                }

                public function paint(x1:int, y1:int, x2:int, y2:int, couleur:uint):void
                { 
                        if (couleur == 1) graphics.lineStyle(2, 0xFF0000, 1);
                        else                        graphics.lineStyle(2, 0x0000FF, 2);
                        graphics.moveTo(x1, y1);
                        graphics.lineTo(x2, y2);
                }

                public function toJSON():String
                {
                        json = "[";

                        // Face avant
                        json += x1 + ".0," + "0.0" + ","  + y1 + ".0," 
                        json += x2 + ".0," + "0.0" + ","  + y2 + ".0,";
                        json += x2 + ".0," + h + ".0,"    + y2 + ".0,";
                        json += x1 + ".0," + h + ".0,"    + y1 + ".0,";

                        // Face Arrière
                        json += x1f + "," + "0.0" + ","  + y1f + "," 
                        json += x2f + "," + "0.0" + ","  + y2f + ",";
                        json += x1f + "," + h + ".0,"    + y1f + ",";
                        json += x2f + "," + h + ".0,"    + y2f + ",";

                        // Face de dessus
                        json += x1  + ".0," + h + ".0,"    + y1  + ".0," 
                        json += x2  + ".0," + h + ".0,"    + y2  + ".0,";
                        json += x1f + "," + h + ".0,"    + y1f + ",";
                        json += x2f + "," + h + ".0,"    + y2f + ",";

                       // Face de dessous
                        json += x1  + ".0," + "0.0,"    + y1  + ".0," 
                        json += x2  + ".0," + "0.0,"    + y2  + ".0,";
                        json += x1f + "," + "0.0,"    + y1f + ",";
                        json += x2f + "," + "0.0,"    + y2f + ",";
                      
                        // Face droite
                        json += x2  + ".0," + "0.0" + ","  + y2  + ".0," 
                        json += x2f + ","    + "0.0" + ","  + y2f + ",";
                        json += x2  + ".0," + h + ".0,"    + y2  + ".0,";
                        json += x2f + ","    + h + ".0,"    + y2f + ",";

                        // Face gauche
                        json += x1  + ".0," + "0.0" + ","  + y1  + ".0," 
                        json += x1f + ","    + "0.0" + ","  + y1f + ",";
                        json += x1  + ".0," + h + ".0,"    + y1  + ".0,";
                        json += x1f + ","    + h + ".0,"    + y1f;

                        json += "]";
                        return json;
                }
        }
}
