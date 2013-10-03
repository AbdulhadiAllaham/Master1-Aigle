<?php
function createElement($domObj, $tag_name, $value = NULL, $attributes = NULL)
{
	$element = ($value != NULL ) ? $domObj->createElement($tag_name, $value) : $domObj->createElement($tag_name);

	if( $attributes != NULL )
	{
		foreach ($attributes as $attr=>$val)
		{
			$element->setAttribute($attr, $val);
		}
	}

	return $element;
}

function addField(eltCible, txt, txtId, idAppelant)
{
	$dom = new DOMDocument();
	$dom->loadHTMLFile("../$pageAppelante");

	$elm = createElement($dom, 'foo', 'bar', array('attr_name'=>'attr_value'));

	$dom->appendChild($elm);

	echo $dom->saveXML();
}

?>