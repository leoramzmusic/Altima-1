$(document).ready(function () {

	$("#file").change(function () {
		var $this = $(this), $clone = $this.clone();
		$this.after($clone).appendTo($('#ContenedorFrente'));
		CambiarImgFrente = true;
	});

	$("#file2").change(function () {
		var $this = $(this), $clone = $this.clone();
		$this.after($clone).appendTo($('#ContenedorEspalda'));
		CambiarImgEspalda = true;
	});

});

function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();

		reader.onload = function (e) {
			$('#blah1').attr('src', e.target.result);
		}

		reader.readAsDataURL(input.files[0]); // convert to base64 string
	}
}

function readURL2(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();

		reader.onload = function (e) {
			$('#blah2').attr('src', e.target.result);
		}

		reader.readAsDataURL(input.files[0]); // convert to base64 string
	}
}

$("#file").change(function () {
	readURL(this);
	console.log("cambio");
});

$("#file2").change(function () {
	readURL2(this);
	console.log("cambio");
});

function RecogerDatosPrimeraParte() {
	var today = new Date();
	var actual = today.getFullYear() + '-' + today.getMonth() + '-' + today.getDate() + ' ' + today.getHours() + ':' + today.getMinutes() + ':' + today.getSeconds();
	objeto_prenda['idFamiliaPrenda'] = $('#TipoPrenda').val();
	objeto_prenda['creadoPor'] = "Adan";
	objeto_prenda['actualizadoPor'] = "Adan";
	objeto_prenda['numeroPrenda'] = "1";
	objeto_prenda['nombrePrenda'] = $('#NombrePrenda').val();
	objeto_prenda['descripcionPrenda'] = $('#DescripcionPrenda').val();
	objeto_prenda['tipoPrenda'] = $('#TipoPrenda').val();
	objeto_prenda['detallePrenda'] = $('#DetallePrenda').val();
	objeto_prenda['notaEspecial'] = $('#NotaEspecial').val();
	objeto_prenda['consumoTela'] = 0.0;
	objeto_prenda['consumoForro'] = 0.0;
	objeto_prenda['precio'] = 0.0;
	objeto_prenda['precioLocalActual'] = 0.0;
	objeto_prenda['precioLocalAnterior'] = 0.0;
	objeto_prenda['precioForaneoActual'] = 0.0;
	objeto_prenda['precioForaneoAnterior'] = 0.0;
	objeto_prenda['cvePrenda'] = 0;
	objeto_prenda['tipoLargo'] = "Ninguno";
	objeto_prenda['especificacion'] = "Ninguna";
	objeto_prenda['modeloBoton'] = "Ninguno";
	objeto_prenda['estatusRecepcionMuestra'] = "Ninguno";
	objeto_prenda['devolucion'] = "";

	objeto_prenda['precioMprod'] = 0.0;
	objeto_prenda['precioMmuestra'] = 0.0;
	objeto_prenda['categoria'] = "Ninguna";

	objeto_prenda['totalPrendas'] = 0;
	objeto_prenda['mostrar'] = "Ninguna";
	objeto_prenda['idLookup'] = 0;
	objeto_prenda['idLookup2'] = 0;
	objeto_prenda['idLookup3'] = 0;






	if ($('#combi').is(':checked')) {
		objeto_prenda['combinacion'] = "1";
	}
	else {
		objeto_prenda['combinacion'] = "0";
	}
	if ($('#ticket').is(':checked')) {
		objeto_prenda['imprimirEtiquetas'] = "1";
	}
	else {
		objeto_prenda['imprimirEtiquetas'] = "0";
	}
}
function RecogerDatosSegundaParte() {
	objeto_prenda['detalleConfeccion'] = $('#DetalleConfeccion').val();
	//Campo en duro de lo de los marcadores, cambiarlo posteriormente.
	objeto_prenda['marcadores'] = "1";
}
function RecogerDatosTerceraParte() {
	var id = null;
	$('#tablita tr').each(function () {
		if (id == null) {
			id = $(this).find('td').eq(0).html()
		}
		else {
			id = $(this).find('td').eq(0).html() + "," + id;
		}
	});
	return id;
}


//Funcion para agregar un nuevo Material desde la vista agregar-confirmar prenda y editar-prenda
function AgregarElementoListaMateriales() {
	var id = $('#ListaDeMateriales').val();
	$('#AgregarElementoMaterial').prop('disabled', true);
	$('#SiguienteTerceraPestana').prop('disabled', true);

	//Este es un boolean para saber si ya se encontro un registro parecido
	var EncontreUnMaterialIgual = false;
	//Si ya existe un registro asi en el objeto que tenemos, se le suma uno a la cantidad.
	for (k = 0; k < objeto_materiales.length; k++) {
		if (objeto_materiales[k].id == id) {
			var can = objeto_materiales[k].cantidad;
			objeto_materiales[k].cantidad = 0;
			objeto_materiales[k].cantidad = (can + 1);
			$('#CantidadMaterial-' + objeto_materiales[k].identidad).val((can + 1));
			$('#AgregarElementoMaterial').prop('disabled', false);
			$('#SiguienteTerceraPestana').prop('disabled', false);
			EncontreUnMaterialIgual = true;
			console.log("si coincidio");
		}
	}


	//Solicitud Ajax para obtener los demas campos.
	if (!EncontreUnMaterialIgual) {


		$.ajax({
			type: "GET",
			url: "/detalle_material",
			data: { id },
			success: (data) => {
				console.log(data);
				$('#AgregarElementoMaterial').prop('disabled', false);
				$('#SiguienteTerceraPestana').prop('disabled', false);


				var identidad = id + '_' + data[0][1];
				var temp = {
					identidad: identidad, id: data[0][0], NoMaterial: data[0][1], Nombre: data[0][8], Clasificacion: data[0][3], Tamanio: data[0][5] + ' ' + data[0][4],
					Modelo: data[0][6], Proceso: data[0][7], cantidad: 1
				};


				objeto_materiales.push(temp);
				console.log(temp);
				$('#CuerpoTablaMateriales').append("<tr id='RemoverElemento-" + identidad + "'>" +
					"<td>" + data[0][1] + "</td>" +
					"<th scope='row'>" + data[0][8] + "</th>" +
					"<td>" + data[0][3] + "</td>" +
					"<td>" + data[0][5] + ' ' + data[0][4] + "</td>" +
					"<td>" + data[0][6] + "</td>" +
					"<td>" + data[0][7] + "</td>" +
					"<td><input class='form-control' type='number' id='CantidadMaterial-" + identidad + "' value='1' onclick=\"CambiarCantidadMaterial(\'" + identidad + "\');\"/></td>" +
					"<td class='tdcenter'>" +
					"<button href='' class='btn btn-danger rounded-circle' onclick=\"QuitarMaterial(\'" + identidad + "\');\" >" +
					"<i class='fas fa-minus fa-sm'></i></button>" +
					"</td>" +
					"</tr>");

			},
			error: (e) => {
				console.log(e);
			}
		});


	}//Cierra el if
}
function QuitarMaterial(identidad) {
	$('#RemoverElemento-' + identidad).remove();
	var removeIndex = objeto_materiales.map(function (item) { return item.identidad; }).indexOf(identidad);
	objeto_materiales.splice(removeIndex, 1);
}
function CambiarCantidadMaterial(identidad) {
	var cantidad = $('#CantidadMaterial-' + identidad).val();
	var CambiarCantidad = objeto_materiales.map(function (item) { return item.identidad; }).indexOf(identidad);
	objeto_materiales[CambiarCantidad].cantidad = 0;
	objeto_materiales[CambiarCantidad].cantidad = cantidad;
	console.log(objeto_materiales[CambiarCantidad]);

}



function Guardar() {
	console.log("que pedo que pedo");
	if (CambiarImgFrente == true && CambiarImgEspalda == true) {
		$('#FormImagenes').click();
	}

	if (CambiarImgFrente != true && CambiarImgEspalda != true) {
		console.log("ninguna imagen cambio");
	}

	if (CambiarImgFrente == true && CambiarImgEspalda != true) {
		$('#FormImagenFrente').click();
	}

	if (CambiarImgFrente != true && CambiarImgEspalda == true) {
		$('#FormImagenEspalda').click();
	}

	RecogerDatosPrimeraParte();
	RecogerDatosSegundaParte();


	var token = $('#token').val();
	var header = $('#token').val();
	console.log(objeto_patronajes);
	console.log("entre al guardar");


	//Solicitud Ajax
	$.ajax({
		type: "POST",
		url: "/guardar_prenda",
		data: {
			"_csrf": $('#token').val(),
			"disenioprenda": JSON.stringify(objeto_prenda)
		},
		success: (data) => {
			console.log(data);


			$.ajax({
				type: "POST",
				url: "/guardar_final",
				data: {
					"_csrf": $('#token').val(),
					"objeto_materiales": JSON.stringify(objeto_materiales),
					"objeto_patronajes": JSON.stringify(objeto_patronajes),
					"objeto_marcadores": RecogerDatosTerceraParte(),
					"accion": $('#accionPag').val()
				},
				success: (data) => {
					console.log('final');

					if (CambiarImgFrente != true || CambiarImgEspalda != true) {
						window.location.href = '/prendas';
					}

					$('#BotonBloquearGuardar').prop('disabled', false);
				},
				failure: function (errMsg) {
					alert(errMsg);
				}
			});

		},
		failure: function (errMsg) {
			alert(errMsg);
		}
	});
}

function EnviarInfoProspecto() {
	RecogerDatosPrimeraParte();
	RecogerDatosSegundaParte();

	var token = $('#token').val();
	var header = $('#token').val();
	console.log(objeto_materiales);
	$('#FormImagenes').click();


	//Solicitud Ajax
	$.ajax({
		type: "POST",
		url: "/guardar_prenda",
		data: {
			"_csrf": $('#token').val(),
			"disenioprenda": JSON.stringify(objeto_prenda)
		},
		success: (data) => {
			console.log(data);


			$.ajax({
				type: "GET",
				url: "/guardar_final_prospecto",
				data: {
					"_csrf": $('#token').val()
				},
				success: (data) => {
					console.log('final');
					$('#BloquearBotonProspecto').prop('disabled', false);
				},
				failure: function (errMsg) {
					alert(errMsg);
				}
			});

		},
		failure: function (errMsg) {
			alert(errMsg);
		}
	});
}

//Esta valida que los campos esten llenos cuando se va a editar o confirmar una prenda
function ValidarPrimerPestana() {
	if ($('#NombrePrenda').val() != "" && $('#DescripcionPrenda').val() != "" && $('#NotaEspecial').val() != ""
		&& $('#Ruta').val() != "" && $('#DetallePrenda').val() != "" && $('#TipoPrenda').val() != "") {
		console.log("entra");
		$('#AlertaPrimerPestana').css('display', 'none');
		$('#SiguientePrimeraPestana').click();
	}
	else {
		$('#AlertaPrimerPestana').css('display', 'block');
	}
}

//Esta valida que los campos esten llenos cuando se va a hacer un prospecto de prenda
function ValidarPrimerPestana2() {
	console.log("aqui es donde vale verga");
	$('#BloquearBotonProspecto').prop('disabled', true);

	if ($('#NombrePrenda').val() != "" && $('#DescripcionPrenda').val() != "" && $('#NotaEspecial').val() != ""
		&& $('#DetallePrenda').val() != "" && $('#TipoPrenda').val() != "" && $('#file').val() != "" && $('#file2').val() != "") {
		
		$('#AlertaPrimerPestana').css('display', 'none');
		EnviarInfoProspecto();
		console.log('paso');
	}
	else {
		$('#AlertaPrimerPestana').css('display', 'block');
		$('#BloquearBotonProspecto').prop('disabled', false);
		console.log('no paso');
	}
}

//Esto solo valida que los campos de la 2da parte esten llenos.
function ValidarSegundaPestana() {

	if ($('#DetalleConfeccion').val() != "") {
		$('#AlertaSegundaPestana').css('display', 'none');
		$('#SiguienteSegundaPestana').click();
	}
	else {
		$('#AlertaSegundaPestana').css('display', 'block');
	}
}

//Esto valida que la tercer pestana, de materiales, tenga al menos un material
function ValidarTerceraPestana(id) {
	if (objeto_materiales.length === 0) {
		$('#AlertaTerceraPestana').css('display', 'block');
	}
	else {
		$('#AlertaTerceraPestana').css('display', 'none');
		$('#SiguienteTerceraPestana').click();
		AsignarID(id);
	}
}

function ValidarCuartaPestana() {
	var j=0;
	var validacion=true;
	$('#CuerpoPatronaje tr').each(function () {
		j++;
	});
	console.log("var j="+j);
	if (j== 0) {
		$('#AlertaCuartaPestana').css('display', 'block');
	}
	else {
		//Se deshabilita el boton
		console.log("aqui si jala");
		$('#AlertaCuartaPestana').css('display', 'none');
		$('#CuerpoPatronaje tr').each(function () {
			console.log($('#CantidadTela'+$(this).find('td').eq(0).html()).val());
			if($('#CantidadTela'+$(this).find('td').eq(0).html()).val()=="" || $('#CantidadForro'+$(this).find('td').eq(0).html()).val()==""||$('#CantidadEntretela'+$(this).find('td').eq(0).html()).val()==""){
				Swal.fire({
					icon: 'error',
					title: 'Error',
					text: 'Todos los campos deben de estar llenos!'
				  })
				  
						objeto_patronajes=[];
						console.log("que pedo con esta pus "+objeto_patronajes);
						validacion=false;
						return true;
			}
			if(validacion===true)
			{
				_id=$(this).find('td').eq(0).html();
				var temp = {id: $(this).find('td').eq(0).html(), cantidadTela: $('#CantidadTela'+$(this).find('td').eq(0).html()).val(), cantidadForro: $('#CantidadForro'+$(this).find('td').eq(0).html()).val(), cantidadEntretela: $('#CantidadEntretela'+$(this).find('td').eq(0).html()).val() };
				objeto_patronajes.push(temp);
			}
		});
		if(validacion===true)
		{
			$('#SiguienteCuartaPestana').click();
			$('#BotonBloquearGuardar').prop('disabled', true);	
		}

	}
}

//Este valida que las cantidades del patronaje no esten nulas cuando se confirma una prenda
function ValidarCantidadesPatronaje() {
	if ($('#CantidadTela').val() != "" && $('#CantidadForro').val() != "" && $('#CantidadEntretela').val() != "") {
		$('#AlertaCantidadesPatronaje').css('display', 'none');
		console.log("si hace la entrasion");
		AgregarElementoListaPatronaje();
	}
	else {
		$('#AlertaCantidadesPatronaje').css('display', 'block');
	}
}


//Funciones para limpiar inputs
function LimpiarInput1() {
	$('#file').val(null);
	$('#blah1').attr("src", "/dist/img/preview.png");
}

function LimpiarInput2() {
	$('#file2').val(null);
	$('#blah2').attr("src", "/dist/img/preview.png");
}

//Cambios Uriel ***********************Marcadores
function guardarMarcador() {

	var _id = document.getElementById("marcador_").value;
	var _text = document.getElementById("marcador_").options[document.getElementById("marcador_").selectedIndex].text;
	var fila = "<tr><td style='display: none;'>" + _id + "</td><td>" + _text + "</td><td>" + '<button type="button" name="remove" id="' + _id + '"onclick="eliminarMarcador(this)" class="btn btn-danger btn_remove">Quitar</button></td></tr>';
	var campo_id;
	$('#tablita tr').each(function () {
		if($(this).find('td').eq(0).html()!=null){
			console.log("entra1");
			if(campo_id==null){
				campo_id=$(this).find('td').eq(0).html()
			}
			else{
				campo_id=$(this).find('td').eq(0).html()+","+campo_id;
			}
		}
	});
	if(campo_id!=null){
		console.log("entra2 "+campo_id);
		for(var j=0;j<=campo_id.split(",").length;j++){

			if(_id==campo_id.split(",")[j]){
				console.log("entra3 "+_id);
				return false;
			}
		}
	}
	var btn = document.createElement("TR");
	btn.innerHTML = fila;
	document.getElementById("tablita").appendChild(btn);
}
function eliminarMarcador(t) {
	var td = t.parentNode;
	var tr = td.parentNode;
	var table = tr.parentNode;
	table.removeChild(tr);
}

function guardarPatronaje() {

	var _id = document.getElementById("ListaPatronaje").value;
	var _text = document.getElementById("ListaPatronaje").options[document.getElementById("ListaPatronaje").selectedIndex].text;
	var fila = "<tr><td style='display: none;'>" +_id + "</td>"+
		"<td>" + _text + "</td>"+
		"<td>" + '<input type="number" class="form-control" placeholder="10" id="CantidadTela'+_id+'">' + "</td>"+
		"<td>" + '<input type="number" class="form-control" placeholder="10" id="CantidadForro'+_id+'">' + "</td>"+
		"<td>" + '<input type="number" class="form-control" placeholder="10" id="CantidadEntretela'+_id+'">' + "</td>"+
		"<td class='tdcenter'>" +'<button type="button" name="remove" id="' +_id + '"onclick="eliminarPatronaje(this)" class="btn btn-danger btn_remove">Quitar</button></td>'+

		'</tr>';
	var campo_id;
	$('#CuerpoPatronaje tr').each(function () {
		if($(this).find('td').eq(0).html()!=null){
			console.log("entra1");
			if(campo_id==null){
				campo_id=$(this).find('td').eq(0).html()
			}
			else{
				campo_id=$(this).find('td').eq(0).html()+","+campo_id;
			}
		}
	});
	if(campo_id!=null){
		console.log("entra2 "+campo_id);
		for(var j=0;j<=campo_id.split(",").length;j++){

			if(_id==campo_id.split(",")[j]){
				console.log("entra3 "+_id);
				return false;
			}
		}
	}
	var btn = document.createElement("TR");
	btn.innerHTML = fila;
	document.getElementById("CuerpoPatronaje").appendChild(btn);
}
function eliminarPatronaje(t) {
	var td = t.parentNode;
	var tr = td.parentNode;
	var table = tr.parentNode;
	table.removeChild(tr);
}