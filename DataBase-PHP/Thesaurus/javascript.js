function createLeaf(tagName, txt)
{
	var node = document.createElement(tagName);
	var text = document.createTextNode(txt);
	node.appendChild(text);
	
	return node;
}

var cpt = 0;

// Créer un nouveau champ input text dans le formulaire avant <eltCible>, dont le texte du label sera <txt> et l'id du champ sera <txtId>
function createField(eltCible, txt, txtId, idAppelant)
{
	//var elt = document.getElementById(txtId);
	// Test afin de savoir si le champ que l'on veut créer n'existe pas déjà (pour éviter la création multiple)
	/*if (elt == null)
	{*/
	var bouton = document.getElementById(eltCible);
	var parentBtn = bouton.parentNode;
	cpt++;
	txt += " " + cpt + " : ";
	txtId += cpt;
	var label = createLeaf("label", txt);
	label.setAttribute("for", txtId);
	
	var input = document.createElement("input");
	input.setAttribute("type", "text");
	input.setAttribute("id", txtId);
	input.setAttribute("name", txtId);
	//input.setAttribute("class", "btnAjout");
	input.setAttribute("required", true);
	
	var p = document.createElement("p");
	
	p.appendChild(label);
	p.appendChild(input);
	parentBtn.insertBefore(p, bouton);
	//}
	
	if (cpt <= 1)
	{
		var btnSupp = document.createElement("input");
		
		btnSupp.setAttribute("type", "button");
		btnSupp.setAttribute("id", "btnSupp");
		btnSupp.setAttribute("name", "btnSupp");
		btnSupp.setAttribute("value", "Supprimer le dernier synonyme");
		btnSupp.setAttribute("onclick", "deleteField(\"terme_synonyme\");");
		
		parentBtn.insertBefore(btnSupp, bouton.nextSibling);
	}
}

function deleteField(txtId)
{
	var txt = txtId + cpt;
	
	if (cpt > 0)
	{
		var noeud = document.getElementById(txt);
		var p = noeud.parentNode;
		var parent = p.parentNode;
		parent.removeChild(p);
		cpt--;
	}
	
	if (cpt == 0)
	{
		var btn = document.getElementById("btnSupp");
		var parentBtn = btn.parentNode;
		parentBtn.removeChild(btn);
	}
}
// Suppression des champs si changement de bouton radio
/*function deleteField(appelant)
{
	switch(appelant)
	{
		case 'concept' :
			var noeud = document.getElementById("terme_vedette");
			if (noeud != null)
			{
				var p = noeud.parentNode;
				var parent = p.parentNode;
			
				parent.removeChild(p);
			}
			noeud = document.getElementById("terme_synonyme");
			if (noeud != null)
			{
				var p = noeud.parentNode;
				var parent = p.parentNode;
				
				parent.removeChild(p);
			}
		break;
		
		
		case 'vedette' :
			var p;
			var parent;
			var noeud = document.getElementById("terme_concept");
			if (noeud != null)
			{
				p = noeud.parentNode;
				parent = p.parentNode;
				
				parent.removeChild(p);
			}

			noeud = document.getElementById("terme_vedette_concept");
			if (noeud != null)
			{
				p = noeud.parentNode;
				parent = p.parentNode;
				
				parent.removeChild(p);
			}
			
			noeud = document.getElementById("terme_synonyme");
			if (noeud != null)
			{
				p = noeud.parentNode;
				parent = p.parentNode;
				
				parent.removeChild(p);
			}
		break;

		
		case 'synonyme' :
			var p;
			var parent;
			var noeud = document.getElementById("terme_concept");
			if (noeud != null)
			{
				p = noeud.parentNode;
				parent = p.parentNode;

				parent.removeChild(p);
			}
			
			noeud = document.getElementById("terme_vedette_concept");
			if (noeud != null)
			{
				p = noeud.parentNode;
				parent = p.parentNode;
				
				parent.removeChild(p);
			}
			
			noeud = document.getElementById("terme_vedette");
			if (noeud != null)
			{
				p = noeud.parentNode;
				parent = p.parentNode;
				
				parent.removeChild(p);
			}
		break;
	}
}
*/