$(document).ready(function() {

});

function readURL(input) 
{
	  if (input.files && input.files[0]) {
	    var reader = new FileReader();
	    
	    reader.onload = function(e) {
	      $('#blah1').attr('src', e.target.result);
	    }
	    
	    reader.readAsDataURL(input.files[0]); // convert to base64 string
	  }
}

function readURL2(input) 
{
	  if (input.files && input.files[0]) {
	    var reader = new FileReader();
	    
	    reader.onload = function(e) {
	      $('#blah2').attr('src', e.target.result);
	    }
	    
	    reader.readAsDataURL(input.files[0]); // convert to base64 string
	  }
}

	$("#file").change(function() 
	{
	  readURL(this);
	});
	
	$("#file2").change(function() 
	{
		readURL2(this);
	});

function RecogerDatosPrimeraParte()
{
	var today = new Date(); 
	var actual = today.getFullYear() + '-' + today.getMonth() + '-' + today.getDate() + ' ' + today.getHours() + ':' + today.getMinutes() + ':' + today.getSeconds();
	objeto_prenda['idFamiliaPrenda'] = "1";
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
	objeto_prenda['cveRuta'] = $('#Ruta').val();
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
	
	
	
	
	
	
	if($('#combi').is(':checked'))
	{
		objeto_prenda['combinacion'] = "1";
	}
	else
	{
		objeto_prenda['combinacion'] = "0";
	}
	if($('#ticket').is(':checked'))
	{
		objeto_prenda['imprimirEtiquetas'] = "1";
	}
	else
	{
		objeto_prenda['imprimirEtiquetas'] = "0";
	}
}

function RecogerDatosSegundaParte()
{
	objeto_prenda['detalleConfeccion'] = $('#DetalleConfeccion').val();
	objeto_prenda['marcadores'] = $('#Marcadores').val();
}


function SacarListaMateriales()
{
	console.log(objeto_patronaje);
}

function AgregarElementoListaMateriales()
{
	var id = $('#ListaDeMateriales').val();
	$('#AgregarElementoMaterial').prop('disabled', true);

	//Solicitud Ajax para obtener los demas campos.

    $.ajax({
        type: "GET",
        url: "/detalle_material",
        data: { id },
        success: (data) =>{	
        	console.log(data);
        	$('#AgregarElementoMaterial').prop('disabled', false);
        	

        	var identidad = id + '_' + data[0][1];
        	var temp = {identidad: identidad, id: data[0][0], NoMaterial: data[0][1], Nombre: data[0][8], Clasificacion: data[0][3], Tamanio: data[0][5] + ' ' + data[0][4],
        			Modelo: data[0][6], Proceso: data[0][7], Cantidad: 1};
        	
        	objeto_materiales.push(temp);
        	console.log(temp);

        	$('#CuerpoTablaMateriales').append("<tr id='RemoverElemento-" + identidad + "'>" + 
        											"<td>" + data[0][1] + "</td>" + 
        											"<th scope='row'>" + data[0][8] +"</th>" +
        											"<td>" +  data[0][3] + "</td>" +
        											"<td>" +  data[0][5] + ' ' + data[0][4] + "</td>" +
        											"<td>" + data[0][6] +"</td>" +
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

}

function QuitarMaterial(identidad)
{
	$('#RemoverElemento-' + identidad).remove();
	var removeIndex = objeto_materiales.map(function(item) { return item.identidad; }).indexOf(identidad);
	objeto_materiales.splice(removeIndex, 1);
}

function CambiarCantidadMaterial(identidad)
{
	var cantidad = parseInt($('#CantidadMaterial-' + identidad).val(), 10);
	var CambiarCantidad = objeto_materiales.map(function(item) { return item.identidad; }).indexOf(identidad);
	objeto_materiales[CambiarCantidad].cantidad = 0;
	objeto_materiales[CambiarCantidad].cantidad = cantidad;
	console.log(objeto_materiales[CambiarCantidad]);
}
function AgregarElementoListaPatronaje()
{
	//Se recogen variables
	$('#BotonAgregarPatronaje').prop('disabled', true);
	var id = $('#ListaPatronaje').val();
	var nombre = "Jsjjs";
	var cantidadTela = $('#CantidadTela').val();
	var cantidadForro = $('#CantidadForro').val();
	var cantidadEntretela = $('#CantidadEntretela').val();
	
	//Solicitud Ajax para obtener los demas campos.
    $.ajax({
        type: "GET",
        url: "/detalle_patronaje",
        data: { id },
        success: (data) =>{
        	console.log(data);
        	$('#BotonAgregarPatronaje').prop('disabled', false);
        	var identidad = data[0] + '_' + data[1];
        	var temp = {identidad: identidad, id: data[0], cantidadTela: cantidadTela, cantidadForro: cantidadForro, cantidadEntretela: cantidadEntretela};
        	objeto_patronaje.push(temp);
	
			$('#CuerpoPatronaje').append("<tr id='QuitarFilaPatronaje-" + identidad + "'>" +
										  	  "<th scope='row'>" + data[1] + "</th>" + 
										  	  "<td>" + data[2] + "</td>" + 
										  	  "<td>" + cantidadTela +  "</td>" + 
										  	  "<td>" + cantidadForro + "</td>" + 
										  	  "<td>" + cantidadEntretela + "</td>" + 
										  	  "<td class='tdcenter'>" +
										  	  		"<button href='#' class='btn btn-danger rounded-circle' onclick=\"QuitarPatronaje(\'" + identidad + "\');\"	>" +
										  	  			"<i class='fas fa-minus fa-sm'></i>" + 
										  	  		"</button>" + 
										  	  "</td>" +
										 "</tr>");

			},
			error: (e) => {
				console.log(e);
			}
			});

}

function QuitarPatronaje(identidad)
{
	$('#QuitarFilaPatronaje-' + identidad).remove();
	var removeIndex = objeto_patronaje.map(function(item) { return item.identidad; }).indexOf(identidad);
	objeto_patronaje.splice(removeIndex, 1);
}

function Guardar()
{
	RecogerDatosPrimeraParte();
	RecogerDatosSegundaParte();
	
	
	var token = $('#token').val();
	var header = $('#token').val();
	console.log(objeto_materiales);
	$( '#FormImagenes' ).click();
	
	
	//Solicitud Ajax
    $.ajax({
        type: "POST",
        url: "/guardar_prenda",
        data: {
        	"_csrf": $('#token').val(),
        	"disenioprenda" : JSON.stringify(objeto_prenda)
        },
        success: (data) => {
        	console.log(data);	
        	
        	
            $.ajax({
                type: "GET",
                url: "/guardar_final",
                data: {
                	"_csrf": $('#token').val(),
                	"objeto_materiales" : JSON.stringify(objeto_materiales),
                	"objeto_patronaje" : JSON.stringify(objeto_patronaje)
                },
                success: (data) => {
                	console.log('final');	
        		},
        		failure: function(errMsg) {
        	        alert(errMsg);
        	    }
        	}); 
        	
		},
		failure: function(errMsg) {
	        alert(errMsg);
	    }
	}); 
}

function ValidarPrimerPestana()
{
	if($('#NombrePrenda').val() != "" && $('#DescripcionPrenda').val() != "" && $('#NotaEspecial').val() != "" 
		&& $('#Ruta').val() != "" && $('#DetallePrenda').val() != "" && $('#file').val() != ""
			&& $('#file2').val() != "" && $('#TipoPrenda').val() != "")
	{
		$('#AlertaPrimerPestana').css('display', 'none');
		$('#SiguientePrimeraPestana').click();
	}
	else
	{
		$('#AlertaPrimerPestana').css('display', 'block');
	}
}

function ValidarSegundaPestana()
{
	if($('#DetalleConfeccion').val() != "" && $('#Marcadores').val() != "")
	{
		$('#AlertaSegundaPestana').css('display', 'none');
		$('#SiguienteSegundaPestana').click();
		console.log('lleno');
	}
	else
	{
		$('#AlertaSegundaPestana').css('display', 'block');
		console.log('vacio');
	}
}

function ValidarTerceraPestana()
{
	if(objeto_materiales.length === 0)
	{
		$('#AlertaTerceraPestana').css('display', 'block');
	}
	else
	{
		$('#AlertaTerceraPestana').css('display', 'none');
		$('#SiguienteTerceraPestana').click();
	}
}

function ValidarCuartaPestana()
{
	if(objeto_patronaje.length === 0)
	{
		$('#AlertaCuartaPestana').css('display', 'block');
	}
	else
	{
		$('#AlertaCuartaPestana').css('display', 'none');
		$('#SiguienteCuartaPestana').click();
		console.log('le di clic');
	}
}

function ValidarCantidadesPatronaje()
{
	if($('#CantidadTela').val() != "" && $('#CantidadForro').val() != "" && $('#CantidadEntretela').val() != "" )
	{
		$('#AlertaCantidadesPatronaje').css('display', 'none');
		AgregarElementoListaPatronaje();
	}
	else
	{
		$('#AlertaCantidadesPatronaje').css('display', 'block');
	}
}
