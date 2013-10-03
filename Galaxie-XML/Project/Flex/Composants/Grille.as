package Composants
{
        import mx.containers.Canvas;
        import flash.events.MouseEvent;
        import mx.controls.Alert;
        import mx.controls.Label;
        import flash.display.BitmapData;
        import flash.net.*;

        public class Grille extends Canvas
        {
                private var gridSize:uint=600;
                private var pas:uint = 40;
                private var nb:uint = gridSize/40;

                private var memoireX:int = -1;
                private var memoireY:int = -1;

                private var murs:Array = new Array();
                public   var json:String = "";

                private var indicesH:Array = new Array();
                private var indicesV:Array = new Array();
		
                public function Grille()
                {	
                        paint(pas); // cet appel peut être réalisé dans l'interface MXML
                        this.addEventListener(MouseEvent.CLICK, clicked);
                }

                public function paint(pas:uint):void
                {	
                        this.pas = pas;

                        var bitmapdata:BitmapData;
                        var i:uint;

                        for (i=0; i < indicesH.length; i++) { removeChild(indicesH[i]); indicesH[i] = null; }
                        for (i=0; i < indicesV.length; i++) { removeChild(indicesV[i]); indicesV[i] = null; }

                        graphics.clear();
			graphics.lineStyle(1, 0x000000, 1);
                        graphics.drawRect(0, 0, gridSize, gridSize);

                        graphics.beginFill(0xFFFFFF, 1);
                        graphics.drawRect(0, 0, gridSize, gridSize);
                        graphics.endFill();
			
			graphics.lineStyle(1, 0x000000, 1);

                        var nbIndicesH:uint =0;
                        for(i=pas; i<gridSize; i+=pas)
                        {
                                graphics.moveTo(i, 1);
                                graphics.lineTo(i, gridSize);

                                indicesH[nbIndicesH] = new Label();
                                indicesH[nbIndicesH].text = ""+((i/pas)-(nb+1)/2);
                                //indicesH[nbIndicesH].fontWeight = "bold";
                                indicesH[nbIndicesH].x = i-5;
                                indicesH[nbIndicesH].y = gridSize;
                                addChild(indicesH[nbIndicesH]);
                                nbIndicesH++;
                        }

                        var nbIndicesV:uint =0;
                        for(i=pas; i<gridSize; i+=pas)
                        {
                                graphics.moveTo(1, i);
                                graphics.lineTo(gridSize, i);

                                indicesV[nbIndicesV] = new Label();
                                indicesV[nbIndicesV].text = ""+((i/pas)-(nb+6));
                                //indicesH[nbIndicesV].fontWeight = "bold";
                                indicesV[nbIndicesV].x = gridSize+10;
                                indicesV[nbIndicesV].y = i-5;
                                addChild(indicesV[nbIndicesV]);
                                nbIndicesV++;
                        }
                }

                private function clicked(event:MouseEvent):void 
                {
                        var X:int = Math.round(event.localX/pas)*pas;
                        var Y:int = Math.round(event.localY/pas)*pas;	

                        if (memoireX != -1 && memoireY != -1) {
                                var mur:Mur = new Mur(memoireX, memoireY, X, Y, pas, (nb+1)/2, nb+6, 2);
                                addChild(mur);
                                murs.push(mur);
                                memoireX = -1;
                                memoireY = -1;
                        }
                        else {
			        memoireX = X;
			        memoireY = Y;
                        }
                }

                public function toJSON():void 
                {
                        json = "[";
                        for (var i:int=0; i < murs.length; i++) {
                                json += "{\"valeurs\":";
                                json += murs[i].toJSON();
                                json += "}";
                                if ( i < murs.length-1) { json += ","; }
                        }
                        json += "]";

                        //navigateToURL(new URLRequest("http://localhost/sauvegardeJSON.php?json="+json), "blank");

                        var request:URLRequest = new URLRequest("http://localhost/sauvegardeJSON.php");
                        var variables:URLVariables = new URLVariables();
                        variables.json = json;
                        request.data = variables;
                        request.method = URLRequestMethod.POST;
                        var loader:URLLoader = new URLLoader();
                        try {
                              loader.load(request);
                              Alert.show("OK "+json);
                        }
                        catch (error:ArgumentError) {
                               Alert.show("ArgumentError");
                        }
                        catch (error:SecurityError) {
                               Alert.show("SecurityError");
                        }
                }
       }
}
