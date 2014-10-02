<?php

header('Content-Type: application/json');
// header('Content-Type: text/plain');

$nonesuch = $_GET["nonesuch"];

$appid = $_GET["appid"];
$input = $_GET["input"];

if ($appid === $nonesuch) {
	echo "No APPID";
} else if ($input === $nonesuch) {
	echo "No input";
} else {
	$out = array();
	exec("/home/bismith/Programs/wolframalpha-json/ParseXML.sh \"http://api.wolframalpha.com/v2/query?input=$input&appid=$appid\"", $out);

	foreach ($out as $line) {
		echo $line;
		echo "\n";
	}
}

?>