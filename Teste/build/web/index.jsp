<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Janelas que se escondem</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<style type="text/css">
<!--
.janela {
	font-family: Arial, Helvetica, sans-serif;
	border: thin solid #0066FF;
	width: 400px;
	margin: 0px;
}
.titulo {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	font-weight: bold;
	color: #FFFF00;
	background-color: #0099FF;
	text-align: left;
	vertical-align: middle;
	height: 25px;
	width: 400px;
	margin: 0px;
}
-->
</style>
<style type="text/css">
<!--
.conteudo {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	font-weight: normal;
}
-->
</style>
<script language="JavaScript">
function ver(num){
	var id="conteudo_"+num;
	var obj=document.getElementById(id);
	var status=obj.style.display;
	if(status=="none"){obj.style.display="inline"}
	else{obj.style.display="none";}
}
</script>
</head>

<body>
<div id="janela_1" class="janela"><!-- o ide pode ser qulquer um que você queira.-->
<span id="titulo_1" class="titulo"><label onClick="ver('1')">&nbsp;&nbsp;&nbsp;Título da janela</label></span><!-- o ide pode ser qualquer um que você queira.-->
<span id="conteudo_1" class="conteudo" style="display: none;"><p>Aqui deve ser colocado o conteúdo da janela. Pode ser inclusive um frame oi iframe.</p></span><!-- ATENÇÃO! O ID deste SPAN precisa ser no formato "conteudo_[número], onde [número] é o mesmo da função ver() no ONCLICK na imagem! (Mas isso você pode alterar, se souber o que estiver fazendo.)-->
</div>
</body>
</html>