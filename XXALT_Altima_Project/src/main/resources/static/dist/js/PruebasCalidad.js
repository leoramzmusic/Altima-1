$(document).ready(function() {
});

function listarTabla(){
	$.ajax({
	    method: "GET",
	    url: "/listarCalidad",
	    success: (data) => {
				var a="";
			    var b = [];
			    var estatus;
			    console.log(data);
			    for (i in data){
			    	estatus = (data[i].estatus=='0')?'En Proceso':'Terminada';
			    	a += 
			    		"<tr>"+
			    		"<td>"+data[i].idText+"</td>"+
						"<td>"+data[i].idText+"</td>"+
						"<td class='tdcenter'><a"+
							" class='btn btn-info popoverxd text-white'"+
							" data-container='body' data-placement='top' data-html='true'"+
							" data-content='<strong>Prueba de encogimiento: </strong>"+estatus+"<br><strong>Prueba de lavado y pilling: </strong>"+estatus+"<br><strong>Prueba de costura: </strong>Terminada<br><strong>Prueba de contaminaci&oacute;n: </strong>"+estatus+"'"+
							" style='border-radius: 35%;'><i class='fas fa-info fa-sm'></i></a>&nbsp;"+
						"</td>"+
						"<td>"+estatus+"</td>"+
						"<td class='tdcenter'><a href='detalle-calidad/"+data[i].idCalidad+"'"+
							" class='btn btn-info text-white'><i"+
								" class='fas fa-info-circle'></i> Ver m&aacute;s detalles</a>&nbsp;"+
						"</td>"+
						"<td class='tdcenter'><a"+
							" class='btn btn-warning popoverxd' data-container='body' href='/calidad-nueva-prueba/"+data[i].idCalidad+"'"+
							" data-placement='top' data-content='Editar'"+
							" style='border-radius: 35%;'><i class='fas fa-pen fa-sm'></i></a>&nbsp;"+
						"</td>"+
					"</tr>"
			    		
					b.push(a);
			    }
			    $('#contenidoTablaCalidad').append(a);
			    
				var table = $('table.tablexd')
						.DataTable(
								{
									"ordering" : false,
									"pageLength" : 5,
									"responsive" : true,
									"lengthMenu" : [
											[ 5, 10, 25, 50, 100 ],
											[ 5, 10, 25, 50, 100 ] ],
									"language" : {
										"sProcessing" : "Procesando...",
										"sLengthMenu" : "Mostrar _MENU_ registros",
										"sZeroRecords" : "No se encontraron resultados",
										"sEmptyTable" : "Ningún dato disponible en esta tabla =(",
										"sInfo" : "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
										"sInfoEmpty" : "Mostrando registros del 0 al 0 de un total de 0 registros",
										"sInfoFiltered" : "(filtrado de un total de _MAX_ registros)",
										"sInfoPostFix" : "",
										"sSearch" : "Buscar:",
										"sUrl" : "",
										"sInfoThousands" : ",",
										"sLoadingRecords" : "Cargando...",
										"oPaginate" : {
											"sFirst" : "Primero",
											"sLast" : "Último",
											"sNext" : "Siguiente",
											"sPrevious" : "Anterior"
										},
										"oAria" : {
											"sSortAscending" : ": Activar para ordenar la columna de manera ascendente",
											"sSortDescending" : ": Activar para ordenar la columna de manera descendente"
										},
										"buttons" : {
											"copy" : "Copiar",
											"colvis" : "Visibilidad"
										}
									}
								});
				new $.fn.dataTable.FixedHeader(table);
			    
	    },
	    error: (e) => {
	        // location.reload();
	    }
}
)}


function nextTab(elem) {
	$(elem).parent().next().find('a[data-toggle="tab"]').click();

}
function prevTab(elem) {
	$(elem).parent().prev().find('a[data-toggle="tab"]').click();

}
function agregarPrueba(id){
	var valor = id;
	console.log(valor);
	return valor;
}
function listarTelas(){
	var resultado = agregarPrueba();
	console.log(resultado);
	$.ajax({
		 method: "GET",
		    url: "/listarTelasCalidad",
		    data: {
		    	"_csrf": $('#token').val()
		    },
		    success: (data) => {
				for (i in data){
		    	$('.idtelas').append("<option value='"+data[i].idTela+"'>"+data[i].nombreTela+"</option>");
				}
		    },
		   
		    error: (e) => {
		        // location.reload();
		    }
		});
	
	
}

function listarOperarios(){
	$.ajax({
		 method: "GET",
		    url: "/listarOperarios",
		    data: {
		    	"_csrf": $('#token').val()
		    },
		    success: (data) => {
				for (i in data){
		    	$('.idOperarios').append("<option value='"+data[i][0]+"'>"+data[i][1]+data[i][2]+data[i][3]+"</option>");
				}
		    },
		    error: (e) => {
		        // location.reload();
		    }
		});
}

function listarEntretelas(){
	$.ajax({
		 method: "GET",
		    url: "/listarEntretelas",
		    data: {
		    	"_csrf": $('#token').val()
		    },
		    success: (data) => {
				for (i in data){
		    	$('#entretelaEncogi').append("<option value='"+data[i][0]+"'>"+data[i][1]+"</option>");
				}
		    },
		    error: (e) => {
		        // location.reload();
		    }
		});
}




//=================== funciones para guardar las pruebas =======================//
//                                    |                                         //
//                                    |                                         //
//                                    v                                         //


function PruebasEncogimiento(){
	
//===================variables de pruebas de encogimiento=======================
	var tipoTela= $('#tela').val();
	var operario= $('#operarioEncogi').val();
	var frealizacion= $('#fechaRealizacionEncogi').val();
	var ffinalizacion= $('#fechaFinalizacionEncogi').val();
	
//===================variables de Pruebas de vapor=======================
	var entretela= $('#entretelaEncogi').val();
	var adherencia= $('#adherenciaEncogi').val();
	var proveedor= $('#proveedorEncogi').val();
	var temperatura= $('#temperaturaPruebaVapor').val();
	var tiempo= $('#tiempoPruebaVapor').val();
	var presion= $('#presionPruebaVapor').val();
	var medidaHiloPruebaVapor= $('#medidaHiloPruebaVapor').val();
	var medidaTramaPruebaVapor= $('#finalTramaPruebaVapor').val();
//resultado
	var diferenciaHiloPruebaVapor= $('#diferenciaHiloPruebaVapor').val();
	//var finalHiloMedPruebaVapor= $('#finalHiloMedPruebaVapor').val();
	var diferenciaTramaPruebaVapor= $('#diferenciaTramaPruebaVapor').val();
	//var finalTramaMedPruebaVapor= $('#finalTramaMedPruebaVapor').val();
	var observacionesReultPruebaVapor= $('#observacionesReultPruebaVapor').val();

//===================variables de Pruebas de fusión=======================
	var medidaHiloPruebaFusion= $('#medidaHiloPruebaFusion').val();
	var medidaTramaPruebaFusion= $('#medidaTramaPruebaFusion').val();
	//resultado
	var diferenciaHiloPruebaFusion= $('#diferenciaHiloPruebaFusion').val();
	//var finalHiloMedPruebaFusion= $('#finalHiloMedPruebaFusion').val();
	var diferenciaTramaPruebaFusion= $('#diferenciaTramaPruebaFusion').val();
	//var finalTramaMedPruebaFusion= $('#finalTramaMedPruebaFusion').val();
	var observacionesReultPruebaFusion= $('#observacionesReultPruebaFusion').val();

//===================variables de Plancha de vapor=======================
	var medidaHiloPlanchaVapor= $('#medidaHiloPlanchaVapor').val();
	var medidaTramaPlanchaVapor= $('#medidaTramaPlanchaVapor').val();
	//resultado
	var diferenciaHiloPlanchaVapor= $('#diferenciaHiloPlanchaVapor').val();
	//var finalHiloMedPlanchaVapor= $('#finalHiloMedPlanchaVapor').val();
	var diferenciaTramaPlanchaVapor= $('#diferenciaTramaPlanchaVapor').val();
	//var finalTramaMedPlanchaVapor= $('#finalTramaMedPlanchaVapor').val();
	var observacionesReultPlanchaVapor= $('#observacionesReultPlanchaVapor').val();
	var idCalidad = $('#idCalidadEnco').val();
	var valordeReferencia = " ";
	
	var datos = [tipoTela,
				operario, 
				frealizacion,
				ffinalizacion,
				entretela,
				adherencia,
				proveedor,
				temperatura,
				tiempo,
				presion,
				medidaHiloPruebaVapor,
				medidaTramaPruebaVapor,
				diferenciaHiloPruebaVapor,
				diferenciaTramaPruebaVapor,
				observacionesReultPruebaVapor,
				medidaHiloPruebaFusion,
				medidaTramaPruebaFusion,
				diferenciaHiloPruebaFusion,
				diferenciaTramaPruebaFusion,
				observacionesReultPruebaFusion,
				medidaHiloPlanchaVapor,
				medidaTramaPlanchaVapor,
				diferenciaHiloPlanchaVapor,
				diferenciaTramaPlanchaVapor,
				observacionesReultPlanchaVapor,
				idCalidad,
				valordeReferencia];
	var dato = datos.toString();
	console.log(datos);
	$.ajax({
	    type: "POST",
	    url: "/guardarPruebaEncogimiento",
		
		 data: {
		    	"_csrf": $('#token').val(),
		    	datos:dato

		    },
	    
	    success: (data) => {
	    },
	   
	    error: (e) => {
	        // location.reload();
	    }
	});
}



function PruebasLavado(){
	
//===================variables de pruebas de lavado y pilling=======================
	var tipoTela= $('#telas').val();
	var operario= $('#operarioLavado').val();
	var frealizacion= $('#fechaRealizacionLavado').val();
	var ffinalizacion= $('#fechaFinalizacionLavado').val();
	
//===================variables de Prueba de lavado=======================
	var medidaHiloPruebaLavado= $('#medidaHiloPruebaLavado').val();
	var medidaTramaPruebaLavado= $('#medidaTramaPruebaLavado').val();
//resultado
	var diferenciaHiloPlanchaVapor= $('#diferenciaHiloPruebaLavado').val();
	var finalHiloMedPlanchaVapor= $('#finalHiloMedPruebaLavado').val();
	var diferenciaTramaPlanchaVapor= $('#diferenciaTramaPruebaLavado').val();
	var finalTramaMedPlanchaVapor= $('#finalTramaMedPruebaLavado').val();
	var observacionesReultPlanchaVapor= $('#observacionesReultPruebaLavado').val();
	
//===================variables de Prueba de solidez y color=======================
	
	var calidad = $('input:radio[name=calidad]:checked').val();
	var observacionesReultSolidez= $('#observacionesReultSolidez').val();

//===================variables de Prueba de pilling=======================
	
	var pilling = $('input:radio[name=decision]:checked').val();
	var observacionesReultPilling= $('#observacionesReultPilling').val();
	var idCalidad = $('#idCalidadLavado').val();
	var valordeReferencia = " ";

	
	var datos =[tipoTela,
				operario,
				frealizacion,
				ffinalizacion,
				medidaHiloPruebaLavado,
				medidaTramaPruebaLavado,
				diferenciaHiloPlanchaVapor,
				diferenciaTramaPlanchaVapor,
				observacionesReultPlanchaVapor,
				calidad,
				observacionesReultSolidez,
				pilling,
				observacionesReultPilling,
				idCalidad,
				valordeReferencia];
	var dato = datos.toString();
	console.log(datos);
	$.ajax({
	    type: "POST",
	    url: "/guardarPruebaLavado",
		
		 data: {
		    	"_csrf": $('#token').val(),
		    	datos:dato

		},
	    success: (data) => {
	    },
	   
	    error: (e) => {
	        // location.reload();
	    }
	});
}


function PruebaCostura(){
	
	//===================variables de pruebas de Costura=======================
	var tipoTela= $('#telass').val();
	var operario= $('#operarioCostura').val();
	var frealizacion= $('#fechaRealizacionCostura').val();
	var ffinalizacion= $('#fechaFinalizacionCostura').val();
	
//===================variables de Prueba de costura=======================
	var tipoAguja = $('#tipoAguja').val();
	var Deslizamiento = $('input:radio[name=decisionDeslizamiento]:checked').val();
	var observacionesDeslizamiento= $('#observacionesDeslizamiento').val();
	
	var Rasgado = $('input:radio[name=decisionRasgado]:checked').val();
	var observacionesRasgado= $('#observacionesRasgado').val();
	var idCalidad = $('#idCalidadCostura').val();
	var valordeReferencia = " ";
	
	
	var datos =[tipoTela,
				operario,
				frealizacion,
				ffinalizacion,
				tipoAguja,
				Deslizamiento,
				observacionesDeslizamiento,
				Rasgado,
				observacionesRasgado,
				idCalidad,
				valordeReferencia];
	var dato = datos.toString();
	console.log(datos);
	$.ajax({	  
		type: "POST",
	    url: "/guardarPruebaCostura",
		
		 data: {
		    	"_csrf": $('#token').val(),
		    	datos:dato

		},
	    success: (data) => {
	    	
	    },
	   
	    error: (e) => {
	        // location.reload();
	    }
	});
}

function PruebaContaminacion() {
	
	//===================variables de pruebas de Contaminacion=======================
	var tipoTela= $('#telasss').val();
	var operarioContaminacion= $('#operarioContaminacion').val();
	var frealizacionContaminacion= $('#fechaRealizacionContaminacion').val();
	var ffinalizacionContaminacion= $('#fechaFinalizacionContaminacion').val();
	
	//===================variables de resultados de pruebas de Contaminacion=======================
	var calidadContaminacion = $('input:radio[name=calidadConta]:checked').val();

	var observacionesReultSolidez= $('#observacionesReultContaminacion').val();
	var idCalidad = $('#idCalidadConta').val();
	var valordeReferencia = " ";
	
	var datos= [tipoTela,
				operarioContaminacion,
				frealizacionContaminacion,
				ffinalizacionContaminacion,
				calidadContaminacion,
				observacionesReultSolidez,
				idCalidad,
				valordeReferencia];
	var dato = datos.toString();
	console.log(datos);
$.ajax({	  
		type: "POST",
	    url: "/guardarPruebaContaminacion",
		
		 data: {
		    	"_csrf": $('#token').val(),
		    	datos:dato
	
		},
	    
	    success: (data) => {

	    	
	    },
	   
	    error: (e) => {
	        // location.reload();
	    }
	});
	
}

// ============Validaciones de datos==================
function ValidacionEncogimiento() {
    if ($('#tela').val() != ""
        && $('#operarioEncogi').val() != ""
        && $('#fechaRealizacionEncogi').val() != ""
        && $('#fechaFinalizacionEncogi').val() != ""
        && $('#entretelaEncogi').val() != ""
        && $('#adherenciaEncogi').val() != ""
        && $('#proveedorEncogi').val() != ""
        && $('#temperaturaPruebaVapor').val() != ""
        && $('#tiempoPruebaVapor').val() != ""
        && $('#presionPruebaVapor').val() != ""
        && $('#medidaHiloPruebaVapor').val() != ""
        && $('#finalTramaPruebaVapor').val() != ""
        && $('#diferenciaHiloPruebaVapor').val() != ""
        && $('#finalHiloMedPruebaVapor').val() != ""
        && $('#diferenciaTramaPruebaVapor').val() != ""
        && $('#finalTramaMedPruebaVapor').val() != ""
        && $('#medidaHiloPruebaFusion').val() != ""
        && $('#medidaTramaPruebaFusion').val() != ""
        && $('#diferenciaHiloPruebaFusion').val() != ""
        && $('#finalHiloMedPruebaFusion').val() != ""
        && $('#diferenciaTramaPruebaFusion').val() != ""
        && $('#finalTramaMedPruebaFusion').val() != ""
        && $('#finalTramaMedPruebaVapor').val() != ""
        && $('#medidaHiloPlanchaVapor').val() != ""
        && $('#medidaTramaPlanchaVapor').val() != ""
        && $('#diferenciaHiloPlanchaVapor').val() != ""
        && $('#finalHiloMedPlanchaVapor').val() != ""
        && $('#diferenciaTramaPlanchaVapor').val() != ""
        && $('#finalTramaMedPlanchaVapor').val() != ""
    ) {
        $('#AlertaPestanaEncogimiento').css('display', 'none');
        $('#enlace').click();
        location.href = "calidad";
    }
    else {
        $('#AlertaPestanaEncogimiento').css('display', 'block');
    }
}

function ValidacionLavado() {
    if ($('#telas').val() != ""
        && $('#operarioLavado').val() != ""
        && $('#fechaRealizacionLavado').val() != ""
        && $('#fechaFinalizacionLavado').val() != ""
        && $('#medidaHiloPruebaLavado').val() != ""
        && $('#medidaTramaPruebaLavado').val() != ""
        && $('#diferenciaHiloPruebaLavado').val() != ""
        && $('#finalHiloMedPruebaLavado').val() != ""
        && $('#diferenciaTramaPruebaLavado').val() != ""
        && $('#finalTramaMedPruebaLavado').val() != ""
        && $('input:radio[name=calidad]:checked').val() == "buena"
        || $('input:radio[name=calidad]:checked').val() == "regular"
        || $('input:radio[name=calidad]:checked').val() == "mala"
        && $('input:radio[name=decision]:checked').val() == "si"
        || $('input:radio[name=decision]:checked').val() == "no"
    ) {
        $('#AlertaPestanaLavado').css('display', 'none');
        $('#enlaceLavado').click();
        location.href = "calidad";
    }
    else {
        $('#AlertaPestanaLavado').css('display', 'block');
    }
}

function ValidacionCostura() {
    if ($('#telass').val() != ""
        && $('#operarioCostura').val() != ""
        && $('#fechaRealizacionCostura').val() != ""
        && $('#fechaFinalizacionCostura').val() != ""
        && $('#tipoAguja').val() == ""

        && $('input:radio[name=decisionDeslizamiento]:checked').val() == "si"
        || $('input:radio[name=decisionDeslizamiento]:checked').val() == "no"

        && $('input:radio[name=decisionRasgado]:checked').val() == "si"
        || $('input:radio[name=decisionRasgado]:checked').val() == "no"

        || $('input:radio[name=decision]:checked').val() == "no"
    ) {
        $('#AlertaPestanaCostura').css('display', 'none');
        $('#enlaceCostura').click();
        location.href = "calidad";
    }
    else {
        $('#AlertaPestanaCostura').css('display', 'block');
    }
}

function ValidacionContaminacion() {
    if ($('#telasss').val() != ""
        && $('#operarioContaminacion').val() != ""
        && $('#fechaRealizacionContaminacion').val() != ""
        && $('#fechaFinalizacionContaminacion').val() != ""

        && $('input:radio[name=calidadConta]:checked').val() == "buena"
        || $('input:radio[name=calidadConta]:checked').val() == "regular"
        || $('input:radio[name=calidadConta]:checked').val() == "mala"
    ) {
        $('#AlertaPestanaContaminacion').css('display', 'none');
        $('#enlaceContaminacion').click();
        location.href = "calidad";
    }
    else {
        $('#AlertaPestanaContaminacion').css('display', 'block');
    }
}