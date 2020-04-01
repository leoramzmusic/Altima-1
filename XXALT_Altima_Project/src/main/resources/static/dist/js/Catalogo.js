 $(document).ready(function() {

	listarMarcas();
	listarColores();
	listarTrazos();
	listarPrendas();
	listarGeneros();
	listarComposiciones();
	listarCuidados();
	listarMedidas();
	listarMateriales();
	listarMarcadores();
	
	


});
 function listarMarcas() {
		
		$.ajax({
		    method: "GET",
		    url: "/marcas",
		    success: (data) => {
		    	$('#quitar').remove();
		    	$('#contenedorTabla').append("<div class='modal-body' id='quitar'>" +
		    			"<table class='table table-striped table-bordered' id='idtable' style='width:100%'>" +
	                                        "<thead>" +
	                                            "<tr>" +
	                                                "<th>Clave</th>" +
	                                                "<th>Nombre</th>" + 
	                                               
	                                                "<th>Cambios</th>" +
	                                                "<th></th>" +
	                                            "</tr>" +
	                                        "</thead>" +
	                                    "</table>" + "</div>");
		        var a;
		        var b = [];
		        for (i in data){
		        	
						a = [
						"<tr>" +
						"<td>" + data[i].idText + "</td>",
						"<td>" + data[i].nombreLookup + "</td>",
						"<td style='text-align: center;'>"+
                        "<button class='btn btn-info popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-html='true' data-content='<strong>Creado por:</strong> <br /><strong>Fecha de creaci&oacute;n:</strong> 01/02/2020<br><strong>Modificado por:</strong> Carlos Gabriel Hernandez Mendez<br><strong>Fecha de modicaci&oacute;n:</strong> 02/09/2020' style='border-radius: 35%;'><i class='fas fa-info-circle'></i></button>&nbsp;"+
                    "</td>",
						" <td style='text-align: center;''>"+
						" <button id='"+data[i].idLookup+"' value='"+data[i].nombreLookup+"' class='btn btn-warning popoverxd edit_data' data-container='body' data-toggle='popover' data-placement='top' data-content='Editar' style='border-radius: 35%;'><i class='fas fa-pen fa-sm'></i></button>&nbsp;"+
                      "<button onclick='bajarMarca("+data[i].idLookup+")' class='btn btn-danger popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-content='Dar de baja' style='border-radius: 35%;'><i class='fas fa-ban fa-sm'></i></button>&nbsp;"+
						"</td>"+
						
						"<tr>"
						];
						b.push(a);
		        }	        
			    var tabla = $('#idtable').DataTable({
	            	"data":b,
	                "ordering": true,
	                "pageLength": 5,
	                "lengthMenu": [
	                    [5, 10, 25, 50, 100],
	                    [5, 10, 25, 50, 100]
	                ],
	                "language": {
	                    "sProcessing": "Procesando...",
	                    "sLengthMenu": "Mostrar _MENU_ registros",
	                    "sZeroRecords": "No se encontraron resultados",
	                    "sEmptyTable": "Ningún dato disponible en esta tabla =(",
	                    "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
	                    "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
	                    "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
	                    "sInfoPostFix": "",
	                    "sSearch": "Buscar:",
	                    "sUrl": "",
	                    "sInfoThousands": ",",
	                    "sLoadingRecords": "Cargando...",
	                    "oPaginate": {
	                        "sFirst": "Primero",
	                        "sLast": "Último",
	                        "sNext": "Siguiente",
	                        "sPrevious": "Anterior"
	                    },
	                    "oAria": {
	                        "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
	                        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
	                    },
	                    "buttons": {
	                        "copy": "Copiar",
	                        "colvis": "Visibilidad"
	                    }
	                }
	            });
		    },
		    error: (e) => {
		        // location.reload();
		    }
	}
	)}
 ///////////////////////////////
 function listarColores() {
		
		$.ajax({
		    method: "GET",
		    url: "/colores",
		    success: (data) => {
		    	$('#quitar2').remove();
		    	$('#contenedorTabla2').append("<div class='modal-body' id='quitar2'>" +
		    			"<table class='table table-striped table-bordered' id='idtable2' style='width:100%'>" +
	                                        "<thead>" +
	                                            "<tr>" +
	                                                "<th>Clave</th>" +
	                                                "<th>Nombre</th>" + 
	                                                "<th></th>" + 
	                                                "<th>Cambios</th>" +
	                                                "<th></th>" +
	                                            "</tr>" +
	                                        "</thead>" +
	                                    "</table>" + "</div>");
		        var a;
		        var b = [];
		        for (i in data){
		        	
						a = [
						"<tr>" +
						"<td>" + data[i].idText + "</td>",
						"<td>" + data[i].nombreLookup + "</td>",
						"<td> <input type='color' value="+ data[i].atributo1 +" disabled> </td>",
						"<td style='text-align: center;'>"+
                     "<button class='btn btn-info popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-html='true' data-content='<strong>Creado por:</strong> <br /><strong>Fecha de creaci&oacute;n:</strong> 01/02/2020<br><strong>Modificado por:</strong> Carlos Gabriel Hernandez Mendez<br><strong>Fecha de modicaci&oacute;n:</strong> 02/09/2020' style='border-radius: 35%;'><i class='fas fa-info-circle'></i></button>&nbsp;"+
                 "</td>",
						" <td style='text-align: center;''>"+
						" <button id='"+data[i].idLookup+"' value='"+data[i].nombreLookup+"' color='"+data[i].atributo1+"' class='btn btn-warning popoverxd edit_data_color' data-container='body' data-toggle='popover' data-placement='top' data-content='Editar' style='border-radius: 35%;'><i class='fas fa-pen fa-sm'></i></button>&nbsp;"+
                   "<button onclick='bajarColor("+data[i].idLookup+")' class='btn btn-danger popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-content='Dar de baja' style='border-radius: 35%;'><i class='fas fa-ban fa-sm'></i></button>&nbsp;"+
						"</td>"+
						
						"<tr>"
						];
						b.push(a);
		        }	        
			    var tabla = $('#idtable2').DataTable({
	            	"data":b,
	                "ordering": true,
	                "pageLength": 5,
	                "lengthMenu": [
	                    [5, 10, 25, 50, 100],
	                    [5, 10, 25, 50, 100]
	                ],
	                "language": {
	                    "sProcessing": "Procesando...",
	                    "sLengthMenu": "Mostrar _MENU_ registros",
	                    "sZeroRecords": "No se encontraron resultados",
	                    "sEmptyTable": "Ningún dato disponible en esta tabla =(",
	                    "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
	                    "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
	                    "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
	                    "sInfoPostFix": "",
	                    "sSearch": "Buscar:",
	                    "sUrl": "",
	                    "sInfoThousands": ",",
	                    "sLoadingRecords": "Cargando...",
	                    "oPaginate": {
	                        "sFirst": "Primero",
	                        "sLast": "Último",
	                        "sNext": "Siguiente",
	                        "sPrevious": "Anterior"
	                    },
	                    "oAria": {
	                        "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
	                        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
	                    },
	                    "buttons": {
	                        "copy": "Copiar",
	                        "colvis": "Visibilidad"
	                    }
	                }
	            });
		    },
		    error: (e) => {
		        // location.reload();
		    }
	}
	)}
 //////////////////////////////
 function listarTrazos() {
		
		$.ajax({
		    method: "GET",
		    url: "/trazos",
		    success: (data) => {
		    	$('#quitar3').remove();
		    	$('#contenedorTabla3').append("<div class='modal-body' id='quitar3'>" +
		    			"<table class='table table-striped table-bordered' id='idtable3' style='width:100%'>" +
	                                        "<thead>" +
	                                            "<tr>" +
	                                                "<th>Clave</th>" +
	                                                "<th>Nombre</th>" + 
	                                               
	                                                "<th>Cambios</th>" +
	                                                "<th></th>" +
	                                            "</tr>" +
	                                        "</thead>" +
	                                    "</table>" + "</div>");
		        var a;
		        var b = [];
		        for (i in data){
		        	
						a = [
						"<tr>" +
						"<td>" + data[i].idText + "</td>",
						"<td>" + data[i].nombreLookup + "</td>",
						"<td style='text-align: center;'>"+
                     "<button class='btn btn-info popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-html='true' data-content='<strong>Creado por:</strong> <br /><strong>Fecha de creaci&oacute;n:</strong> 01/02/2020<br><strong>Modificado por:</strong> Carlos Gabriel Hernandez Mendez<br><strong>Fecha de modicaci&oacute;n:</strong> 02/09/2020' style='border-radius: 35%;'><i class='fas fa-info-circle'></i></button>&nbsp;"+
                 "</td>",
						" <td style='text-align: center;''>"+
						" <button id='"+data[i].idLookup+"' value='"+data[i].nombreLookup+"' class='btn btn-warning popoverxd edit_data_trazo' data-container='body' data-toggle='popover' data-placement='top' data-content='Editar' style='border-radius: 35%;'><i class='fas fa-pen fa-sm'></i></button>&nbsp;"+
                   "<button onclick='bajarTrazo("+data[i].idLookup+")' class='btn btn-danger popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-content='Dar de baja' style='border-radius: 35%;'><i class='fas fa-ban fa-sm'></i></button>&nbsp;"+
						"</td>"+
						
						"<tr>"
						];
						b.push(a);
		        }	        
			    var tabla = $('#idtable3').DataTable({
	            	"data":b,
	                "ordering": true,
	                "pageLength": 5,
	                "lengthMenu": [
	                    [5, 10, 25, 50, 100],
	                    [5, 10, 25, 50, 100]
	                ],
	                "language": {
	                    "sProcessing": "Procesando...",
	                    "sLengthMenu": "Mostrar _MENU_ registros",
	                    "sZeroRecords": "No se encontraron resultados",
	                    "sEmptyTable": "Ningún dato disponible en esta tabla =(",
	                    "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
	                    "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
	                    "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
	                    "sInfoPostFix": "",
	                    "sSearch": "Buscar:",
	                    "sUrl": "",
	                    "sInfoThousands": ",",
	                    "sLoadingRecords": "Cargando...",
	                    "oPaginate": {
	                        "sFirst": "Primero",
	                        "sLast": "Último",
	                        "sNext": "Siguiente",
	                        "sPrevious": "Anterior"
	                    },
	                    "oAria": {
	                        "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
	                        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
	                    },
	                    "buttons": {
	                        "copy": "Copiar",
	                        "colvis": "Visibilidad"
	                    }
	                }
	            });
		    },
		    error: (e) => {
		        // location.reload();
		    }
	}
	)}
 //////////////////////////////////
 function listarPrendas() {
		
		$.ajax({
		    method: "GET",
		    url: "/prendaslook",
		    success: (data) => {
		    	$('#quitar4').remove();
		    	$('#contenedorTabla4').append("<div class='modal-body' id='quitar4'>" +
		    			"<table class='table table-striped table-bordered' id='idtable4' style='width:100%'>" +
	                                        "<thead>" +
	                                            "<tr>" +
	                                                "<th>Clave</th>" +
	                                                "<th>Nombre</th>" + 
	                                               
	                                                "<th>Cambios</th>" +
	                                                "<th></th>" +
	                                            "</tr>" +
	                                        "</thead>" +
	                                    "</table>" + "</div>");
		        var a;
		        var b = [];
		        for (i in data){
		        	
						a = [
						"<tr>" +
						"<td>" + data[i].idText + "</td>",
						"<td>" + data[i].nombreLookup + "</td>",
						"<td style='text-align: center;'>"+
                  "<button class='btn btn-info popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-html='true' data-content='<strong>Creado por:</strong> <br /><strong>Fecha de creaci&oacute;n:</strong> 01/02/2020<br><strong>Modificado por:</strong> Carlos Gabriel Hernandez Mendez<br><strong>Fecha de modicaci&oacute;n:</strong> 02/09/2020' style='border-radius: 35%;'><i class='fas fa-info-circle'></i></button>&nbsp;"+
              "</td>",
						" <td style='text-align: center;''>"+
				"<button onclick='editarPrenda(this);' idlookup='"+ data[i].idLookup+"' nombre='"+ data[i].nombreLookup+"' descripcion='"+ data[i].descripcion+"' class='btn btn-warning popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-content='Editar' style='border-radius: 35%;'><i class='fas fa-pen fa-sm'></i></button>&nbsp;"+
                "<button onclick='bajarPrenda("+ data[i].idLookup+")' class='btn btn-danger popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-content='Dar de baja' style='border-radius: 35%;'><i class='fas fa-ban fa-sm'></i></button>&nbsp;"+
						"</td>"+
						
						"<tr>"
						];
						b.push(a);
		        }	        
			    var tabla = $('#idtable4').DataTable({
	            	"data":b,
	                "ordering": true,
	                "pageLength": 5,
	                "lengthMenu": [
	                    [5, 10, 25, 50, 100],
	                    [5, 10, 25, 50, 100]
	                ],
	                "language": {
	                    "sProcessing": "Procesando...",
	                    "sLengthMenu": "Mostrar _MENU_ registros",
	                    "sZeroRecords": "No se encontraron resultados",
	                    "sEmptyTable": "Ningún dato disponible en esta tabla =(",
	                    "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
	                    "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
	                    "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
	                    "sInfoPostFix": "",
	                    "sSearch": "Buscar:",
	                    "sUrl": "",
	                    "sInfoThousands": ",",
	                    "sLoadingRecords": "Cargando...",
	                    "oPaginate": {
	                        "sFirst": "Primero",
	                        "sLast": "Último",
	                        "sNext": "Siguiente",
	                        "sPrevious": "Anterior"
	                    },
	                    "oAria": {
	                        "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
	                        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
	                    },
	                    "buttons": {
	                        "copy": "Copiar",
	                        "colvis": "Visibilidad"
	                    }
	                }
	            });
		    },
		    error: (e) => {
		        // location.reload();
		    }
	}
	)}
 //////////////////////////
 function listarGeneros() {
		
		$.ajax({
		    method: "GET",
		    url: "/generos",
		    success: (data) => {
		    	$('#quitar5').remove();
		    	$('#contenedorTabla5').append("<div class='modal-body' id='quitar5'>" +
		    			"<table class='table table-striped table-bordered' id='idtable5' style='width:100%'>" +
	                                        "<thead>" +
	                                            "<tr>" +
	                                                "<th>Clave</th>" +
	                                                "<th>Nombre</th>" + 
	                                               
	                                                "<th>Cambios</th>" +
	                                                "<th></th>" +
	                                            "</tr>" +
	                                        "</thead>" +
	                                    "</table>" + "</div>");
		        var a;
		        var b = [];
		        for (i in data){
		        	
						a = [
						"<tr>" +
						"<td>" + data[i].idText + "</td>",
						"<td>" + data[i].nombreLookup + "</td>",
						"<td style='text-align: center;'>"+
               "<button class='btn btn-info popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-html='true' data-content='<strong>Creado por:</strong> <br /><strong>Fecha de creaci&oacute;n:</strong> 01/02/2020<br><strong>Modificado por:</strong> Carlos Gabriel Hernandez Mendez<br><strong>Fecha de modicaci&oacute;n:</strong> 02/09/2020' style='border-radius: 35%;'><i class='fas fa-info-circle'></i></button>&nbsp;"+
           "</td>",
						" <td style='text-align: center;''>"+
				"<button onclick='editarGenero(this);' idlookup='"+ data[i].idLookup+"' nombre='"+ data[i].nombreLookup+"'  class='btn btn-warning popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-content='Editar' style='border-radius: 35%;'><i class='fas fa-pen fa-sm'></i></button>&nbsp;"+
             "<button onclick='bajarGenero("+ data[i].idLookup+")' class='btn btn-danger popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-content='Dar de baja' style='border-radius: 35%;'><i class='fas fa-ban fa-sm'></i></button>&nbsp;"+
						"</td>"+
						
						"<tr>"
						];
						b.push(a);
		        }	        
			    var tabla = $('#idtable5').DataTable({
	            	"data":b,
	                "ordering": true,
	                "pageLength": 5,
	                "lengthMenu": [
	                    [5, 10, 25, 50, 100],
	                    [5, 10, 25, 50, 100]
	                ],
	                "language": {
	                    "sProcessing": "Procesando...",
	                    "sLengthMenu": "Mostrar _MENU_ registros",
	                    "sZeroRecords": "No se encontraron resultados",
	                    "sEmptyTable": "Ningún dato disponible en esta tabla =(",
	                    "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
	                    "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
	                    "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
	                    "sInfoPostFix": "",
	                    "sSearch": "Buscar:",
	                    "sUrl": "",
	                    "sInfoThousands": ",",
	                    "sLoadingRecords": "Cargando...",
	                    "oPaginate": {
	                        "sFirst": "Primero",
	                        "sLast": "Último",
	                        "sNext": "Siguiente",
	                        "sPrevious": "Anterior"
	                    },
	                    "oAria": {
	                        "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
	                        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
	                    },
	                    "buttons": {
	                        "copy": "Copiar",
	                        "colvis": "Visibilidad"
	                    }
	                }
	            });
		    },
		    error: (e) => {
		        // location.reload();
		    }
	}
	)}
 ///////////////////////////////
 function listarComposiciones() {
		
		$.ajax({
		    method: "GET",
		    url: "/composiciones",
		    success: (data) => {
		    	$('#quitar6').remove();
		    	$('#contenedorTabla6').append("<div class='modal-body' id='quitar6'>" +
		    			"<table class='table  table-striped table-bordered' id='idtable6' style='width:100%'>" +
	                                        "<thead>" +
	                                            "<tr>" +
	                                                "<th>Clave</th>" +
	                                                "<th>Nombre</th>" + 
	                                               
	                                                "<th>Cambios</th>" +
	                                                "<th></th>" +
	                                            "</tr>" +
	                                        "</thead>" +
	                                    "</table>" + "</div>");
		        var a;
		        var b = [];
		        for (i in data){
		        	
						a = [
						"<tr>" +
						"<td>" + data[i].idText + "</td>",
						"<td>" + data[i].nombreLookup + "</td>",
						"<td style='text-align: center;'>"+
            "<button class='btn btn-info popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-html='true' data-content='<strong>Creado por:</strong> <br /><strong>Fecha de creaci&oacute;n:</strong> 01/02/2020<br><strong>Modificado por:</strong> Carlos Gabriel Hernandez Mendez<br><strong>Fecha de modicaci&oacute;n:</strong> 02/09/2020' style='border-radius: 35%;'><i class='fas fa-info-circle'></i></button>&nbsp;"+
        "</td>",
						" <td style='text-align: center;''>"+
				"<button onclick='editarComposicion(this);' idlookup='"+ data[i].idLookup+"' nombre='"+ data[i].nombreLookup+"'  class='btn btn-warning popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-content='Editar' style='border-radius: 35%;'><i class='fas fa-pen fa-sm'></i></button>&nbsp;"+
          "<button onclick='bajarComposicion("+ data[i].idLookup+")' class='btn btn-danger popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-content='Dar de baja' style='border-radius: 35%;'><i class='fas fa-ban fa-sm'></i></button>&nbsp;"+
						"</td>"+
						
						"<tr>"
						];
						b.push(a);
		        }	        
			    var tabla = $('#idtable6').DataTable({
	            	"data":b,
	                "ordering": true,
	                "pageLength": 5,
	                "lengthMenu": [
	                    [5, 10, 25, 50, 100],
	                    [5, 10, 25, 50, 100]
	                ],
	                "language": {
	                    "sProcessing": "Procesando...",
	                    "sLengthMenu": "Mostrar _MENU_ registros",
	                    "sZeroRecords": "No se encontraron resultados",
	                    "sEmptyTable": "Ningún dato disponible en esta tabla =(",
	                    "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
	                    "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
	                    "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
	                    "sInfoPostFix": "",
	                    "sSearch": "Buscar:",
	                    "sUrl": "",
	                    "sInfoThousands": ",",
	                    "sLoadingRecords": "Cargando...",
	                    "oPaginate": {
	                        "sFirst": "Primero",
	                        "sLast": "Último",
	                        "sNext": "Siguiente",
	                        "sPrevious": "Anterior"
	                    },
	                    "oAria": {
	                        "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
	                        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
	                    },
	                    "buttons": {
	                        "copy": "Copiar",
	                        "colvis": "Visibilidad"
	                    }
	                }
	            });
		    },
		    error: (e) => {
		        // location.reload();
		    }
	}
	)}
 //////////////////
 function listarCuidados() {
		
		$.ajax({
		    method: "GET",
		    url: "/cuidados",
		    success: (data) => {
		    	$('#quitar7').remove();
		    	$('#contenedorTabla7').append("<div class='modal-body' id='quitar7'>" +
		    			"<table class='table table-striped table-bordered' id='idtable7' style='width:100%'>" +
	                                        "<thead>" +
	                                            "<tr>" +
	                                                "<th>Clave</th>" +
	                                                "<th>Nombre</th>" + 
	                                                "<th></th>" + 
	                                                "<th>Cambios</th>" +
	                                                "<th></th>" +
	                                            "</tr>" +
	                                        "</thead>" +
	                                    "</table>" + "</div>");
		        var a;
		        var b = [];
		        for (i in data){
		        	
						a = [
						"<tr>" +
						"<td>" + data[i].idText + "</td>",
						"<td>" + data[i].nombreLookup + "</td>",
						"<td> <img class='img-thumbnail rounded float-left' style='max-width: 25%; ' src='/uploads/cuidados/"+ data[i].atributo1 +"' /> </td>",
						"<td style='text-align: center;'>"+
         "<button class='btn btn-info popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-html='true' data-content='<strong>Creado por:</strong> <br /><strong>Fecha de creaci&oacute;n:</strong> 01/02/2020<br><strong>Modificado por:</strong> Carlos Gabriel Hernandez Mendez<br><strong>Fecha de modicaci&oacute;n:</strong> 02/09/2020' style='border-radius: 35%;'><i class='fas fa-info-circle'></i></button>&nbsp;"+
     "</td>",
						" <td style='text-align: center;''>"+
				"<button onclick='editarCuidado(this);' idlookup='"+ data[i].idLookup+"' nombre='"+ data[i].nombreLookup+"'  class='btn btn-warning popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-content='Editar' style='border-radius: 35%;'><i class='fas fa-pen fa-sm'></i></button>&nbsp;"+
       "<button onclick='bajarCuidado("+ data[i].idLookup+")' class='btn btn-danger popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-content='Dar de baja' style='border-radius: 35%;'><i class='fas fa-ban fa-sm'></i></button>&nbsp;"+
						"</td>"+
						
						"<tr>"
						];
						b.push(a);
		        }	        
			    var tabla = $('#idtable7').DataTable({
	            	"data":b,
	                "ordering": true,
	                "pageLength": 5,
	                "lengthMenu": [
	                    [5, 10, 25, 50, 100],
	                    [5, 10, 25, 50, 100]
	                ],
	                "language": {
	                    "sProcessing": "Procesando...",
	                    "sLengthMenu": "Mostrar _MENU_ registros",
	                    "sZeroRecords": "No se encontraron resultados",
	                    "sEmptyTable": "Ningún dato disponible en esta tabla =(",
	                    "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
	                    "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
	                    "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
	                    "sInfoPostFix": "",
	                    "sSearch": "Buscar:",
	                    "sUrl": "",
	                    "sInfoThousands": ",",
	                    "sLoadingRecords": "Cargando...",
	                    "oPaginate": {
	                        "sFirst": "Primero",
	                        "sLast": "Último",
	                        "sNext": "Siguiente",
	                        "sPrevious": "Anterior"
	                    },
	                    "oAria": {
	                        "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
	                        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
	                    },
	                    "buttons": {
	                        "copy": "Copiar",
	                        "colvis": "Visibilidad"
	                    }
	                }
	            });
		    },
		    error: (e) => {
		        // location.reload();
		    }
	}
	)}
//////////////////
 function listarMedidas() {
		
		$.ajax({
		    method: "GET",
		    url: "/medidaslook",
		    success: (data) => {
		    	$('#quitar8').remove();
		    	$('#contenedorTabla8').append("<div class='modal-body' id='quitar8'>" +
		    			"<table class='table table-striped table-bordered' id='idtable8' style='width:100%'>" +
	                                        "<thead>" +
	                                            "<tr>" +
	                                                "<th>Clave</th>" +
	                                                "<th>Nombre</th>" + 
	                                               
	                                                "<th>Cambios</th>" +
	                                                "<th></th>" +
	                                            "</tr>" +
	                                        "</thead>" +
	                                    "</table>" + "</div>");
		        var a;
		        var b = [];
		        for (i in data){
		        	
						a = [
						"<tr>" +
						"<td>" + data[i].idText + "</td>",
						"<td>" + data[i].nombreLookup + "</td>",
						"<td style='text-align: center;'>"+
         "<button class='btn btn-info popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-html='true' data-content='<strong>Creado por:</strong> <br /><strong>Fecha de creaci&oacute;n:</strong> 01/02/2020<br><strong>Modificado por:</strong> Carlos Gabriel Hernandez Mendez<br><strong>Fecha de modicaci&oacute;n:</strong> 02/09/2020' style='border-radius: 35%;'><i class='fas fa-info-circle'></i></button>&nbsp;"+
     "</td>",
						" <td style='text-align: center;''>"+
				"<button onclick='editarMedida(this);' idlookup='"+ data[i].idLookup+"' nombre='"+ data[i].nombreLookup+"'  class='btn btn-warning popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-content='Editar' style='border-radius: 35%;'><i class='fas fa-pen fa-sm'></i></button>&nbsp;"+
       "<button onclick='bajarMedida("+ data[i].idLookup+")' class='btn btn-danger popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-content='Dar de baja' style='border-radius: 35%;'><i class='fas fa-ban fa-sm'></i></button>&nbsp;"+
						"</td>"+
						
						"<tr>"
						];
						b.push(a);
		        }	        
			    var tabla = $('#idtable8').DataTable({
	            	"data":b,
	                "ordering": true,
	                "pageLength": 5,
	                "lengthMenu": [
	                    [5, 10, 25, 50, 100],
	                    [5, 10, 25, 50, 100]
	                ],
	                "language": {
	                    "sProcessing": "Procesando...",
	                    "sLengthMenu": "Mostrar _MENU_ registros",
	                    "sZeroRecords": "No se encontraron resultados",
	                    "sEmptyTable": "Ningún dato disponible en esta tabla =(",
	                    "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
	                    "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
	                    "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
	                    "sInfoPostFix": "",
	                    "sSearch": "Buscar:",
	                    "sUrl": "",
	                    "sInfoThousands": ",",
	                    "sLoadingRecords": "Cargando...",
	                    "oPaginate": {
	                        "sFirst": "Primero",
	                        "sLast": "Último",
	                        "sNext": "Siguiente",
	                        "sPrevious": "Anterior"
	                    },
	                    "oAria": {
	                        "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
	                        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
	                    },
	                    "buttons": {
	                        "copy": "Copiar",
	                        "colvis": "Visibilidad"
	                    }
	                }
	            });
		    },
		    error: (e) => {
		        // location.reload();
		    }
	}
	)}
 /////////////////////
//////////////////
 function listarMateriales() {
		
		$.ajax({
		    method: "GET",
		    url: "/materialeslook",
		    success: (data) => {
		    	$('#quitar9').remove();
		    	$('#contenedorTabla9').append("<div class='modal-body' id='quitar9'>" +
		    			"<table class='table table-striped table-bordered' id='idtable9' style='width:100%'>" +
	                                        "<thead>" +
	                                            "<tr>" +
	                                                "<th>Clave</th>" +
	                                                "<th>Nombre</th>" + 
	                                               
	                                                "<th>Cambios</th>" +
	                                                "<th></th>" +
	                                            "</tr>" +
	                                        "</thead>" +
	                                    "</table>" + "</div>");
		        var a;
		        var b = [];
		        for (i in data){
		        	
						a = [
						"<tr>" +
						"<td>" + data[i].idText + "</td>",
						"<td>" + data[i].nombreLookup + "</td>",
						"<td style='text-align: center;'>"+
         "<button class='btn btn-info popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-html='true' data-content='<strong>Creado por:</strong> <br /><strong>Fecha de creaci&oacute;n:</strong> 01/02/2020<br><strong>Modificado por:</strong> Carlos Gabriel Hernandez Mendez<br><strong>Fecha de modicaci&oacute;n:</strong> 02/09/2020' style='border-radius: 35%;'><i class='fas fa-info-circle'></i></button>&nbsp;"+
     "</td>",
						" <td style='text-align: center;''>"+
				"<button onclick='editarMaterial(this);' idlookup='"+ data[i].idLookup+"' nombre='"+ data[i].nombreLookup+"'  class='btn btn-warning popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-content='Editar' style='border-radius: 35%;'><i class='fas fa-pen fa-sm'></i></button>&nbsp;"+
       "<button onclick='bajarMaterial("+ data[i].idLookup+")' class='btn btn-danger popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-content='Dar de baja' style='border-radius: 35%;'><i class='fas fa-ban fa-sm'></i></button>&nbsp;"+
						"</td>"+
						
						"<tr>"
						];
						b.push(a);
		        }	        
			    var tabla = $('#idtable9').DataTable({
	            	"data":b,
	                "ordering": true,
	                "pageLength": 5,
	                "lengthMenu": [
	                    [5, 10, 25, 50, 100],
	                    [5, 10, 25, 50, 100]
	                ],
	                "language": {
	                    "sProcessing": "Procesando...",
	                    "sLengthMenu": "Mostrar _MENU_ registros",
	                    "sZeroRecords": "No se encontraron resultados",
	                    "sEmptyTable": "Ningún dato disponible en esta tabla =(",
	                    "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
	                    "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
	                    "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
	                    "sInfoPostFix": "",
	                    "sSearch": "Buscar:",
	                    "sUrl": "",
	                    "sInfoThousands": ",",
	                    "sLoadingRecords": "Cargando...",
	                    "oPaginate": {
	                        "sFirst": "Primero",
	                        "sLast": "Último",
	                        "sNext": "Siguiente",
	                        "sPrevious": "Anterior"
	                    },
	                    "oAria": {
	                        "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
	                        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
	                    },
	                    "buttons": {
	                        "copy": "Copiar",
	                        "colvis": "Visibilidad"
	                    }
	                }
	            });
		    },
		    error: (e) => {
		        // location.reload();
		    }
	}
	)}
 ///////////////
//////////////////
 function listarMarcadores() {
		
		$.ajax({
		    method: "GET",
		    url: "/marcadoreslook",
		    success: (data) => {
		    	$('#quitar10').remove();
		    	$('#contenedorTabla10').append("<div class='modal-body' id='quitar10'>" +
		    			"<table class='table table-striped table-bordered' id='idtable10' style='width:100%'>" +
	                                        "<thead>" +
	                                            "<tr>" +
	                                                "<th>Clave</th>" +
	                                                "<th>Nombre</th>" + 
	                                               
	                                                "<th>Cambios</th>" +
	                                                "<th></th>" +
	                                            "</tr>" +
	                                        "</thead>" +
	                                    "</table>" + "</div>");
		        var a;
		        var b = [];
		        for (i in data){
		        	
						a = [
						"<tr>" +
						"<td>" + data[i].idText + "</td>",
						"<td>" + data[i].nombreLookup + "</td>",
						"<td style='text-align: center;'>"+
         "<button class='btn btn-info popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-html='true' data-content='<strong>Creado por:</strong> <br /><strong>Fecha de creaci&oacute;n:</strong> 01/02/2020<br><strong>Modificado por:</strong> Carlos Gabriel Hernandez Mendez<br><strong>Fecha de modicaci&oacute;n:</strong> 02/09/2020' style='border-radius: 35%;'><i class='fas fa-info-circle'></i></button>&nbsp;"+
     "</td>",
						" <td style='text-align: center;''>"+
				"<button onclick='editarMarcador(this);' idlookup='"+ data[i].idLookup+"' nombre='"+ data[i].nombreLookup+"'  class='btn btn-warning popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-content='Editar' style='border-radius: 35%;'><i class='fas fa-pen fa-sm'></i></button>&nbsp;"+
       "<button onclick='bajarMarcador("+ data[i].idLookup+")' class='btn btn-danger popoverxd' data-container='body' data-toggle='popover' data-placement='top' data-content='Dar de baja' style='border-radius: 35%;'><i class='fas fa-ban fa-sm'></i></button>&nbsp;"+
						"</td>"+
						
						"<tr>"
						];
						b.push(a);
		        }	        
			    var tabla = $('#idtable10').DataTable({
	            	"data":b,
	                "ordering": true,
	                "pageLength": 5,
	                "lengthMenu": [
	                    [5, 10, 25, 50, 100],
	                    [5, 10, 25, 50, 100]
	                ],
	                "language": {
	                    "sProcessing": "Procesando...",
	                    "sLengthMenu": "Mostrar _MENU_ registros",
	                    "sZeroRecords": "No se encontraron resultados",
	                    "sEmptyTable": "Ningún dato disponible en esta tabla =(",
	                    "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
	                    "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
	                    "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
	                    "sInfoPostFix": "",
	                    "sSearch": "Buscar:",
	                    "sUrl": "",
	                    "sInfoThousands": ",",
	                    "sLoadingRecords": "Cargando...",
	                    "oPaginate": {
	                        "sFirst": "Primero",
	                        "sLast": "Último",
	                        "sNext": "Siguiente",
	                        "sPrevious": "Anterior"
	                    },
	                    "oAria": {
	                        "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
	                        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
	                    },
	                    "buttons": {
	                        "copy": "Copiar",
	                        "colvis": "Visibilidad"
	                    }
	                }
	            });
		    },
		    error: (e) => {
		        // location.reload();
		    }
	}
	)}
//Habilitar form de SweetAlert2
$('#detalleMarcas').on('shown.bs.modal', function() {
     $(document).off('focusin.modal');
 });
// //////////////////////7



// Agregar Marca
function agregarMarca() {
	 Swal.fire({
	      title: 'Agregar marca',
		    html:'<div class="row">'+
	        '<div class="form-group col-sm-12">'+
	          '<label for="pedidonom">Nombre de la marca</label>'+
	          '<input type="text" class="swal2-input" id="marca" placeholder="Parisina">'+
	        '</div>'+
	        '</div>',
	      showCancelButton: true,
	      cancelButtonColor: '#6C757D',
	      cancelButtonText: 'Cancelar',
	      confirmButtonText: 'Agregar',
	      confirmButtonColor:'#FFC107',
	    }).then((result) => {
	      if (result.value && document.getElementById("marca").value) {
			    var Marca=document.getElementById("marca").value;
	    	  console.log(result.value);
	    	  console.log("hola");
			   $.ajax({
	        type: "POST",
	        url: "/guardarcatalogo",
	        data: { 
	        	 "_csrf": $('#token').val(),
	        	'Marca': Marca
	        	// ,'Descripcion':Descripcion
	        }
	       
	    })
	    .done(function( data ) {
	    	
	    	listarMarcas();
  });
	    
	        Swal.fire({
	          position: 'center',
	          icon: 'success',
	          title: 'Insertado correctamente',
	          showConfirmButton: false,
	          timer: 1250
	        })
	        // /window.setTimeout(function(){location.reload()}, 2000);
	      }
	    })
  }
// Editar Marca
$(document).on('click', '.edit_data', function () {
	  var marca_id = $(this).attr("id");  
		var marca_nombre=$(this).attr("value"); 
Swal.fire({
    title: 'Editar marca',
    html:'<div class="row">'+
    '<div class="form-group col-sm-12">'+
      '<label for="pedidonom">Nombre de la marca</label>'+
      '<input type="text" class="form-control" id="marca" value="'+marca_nombre+'" placeholder="Parisina">'+
      '<input type="hidden" value=" '+marca_id+' ">'+
    '</div>'+
    '</div>',
    inputAttributes: {
      autocapitalize: 'off'
    },
    showCancelButton: true,
    cancelButtonColor: '#6C757D',
    cancelButtonText: 'Cancelar',
    confirmButtonText: 'Actualizar',
    confirmButtonColor:'#DC3545',
}).then((result) => {
    if (result.value && document.getElementById("marca").value) {
		    var Marca=document.getElementById("marca").value;
  	  console.log(result.value);
		   $.ajax({
      type: "POST",
      url: "/editarcatalogo",
      data: { 
      	 "_csrf": $('#token').val(),
  	'Marca': Marca,
  	'idLookup': marca_id
      	// ,'Descripcion':Descripcion
      }
     
  }).done(function(data){
	  console.log("color")
	  listarMarcas();
  });
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'editado correctamente',
        showConfirmButton: false,
        timer: 1250
      })
     
    }
  })
}
)
  // Dar de baja marca
  function bajarMarca(idbaja){
	 var id=idbaja;
    Swal.fire({
      title: '¿Deseas dar de baja la marca?',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Dar de baja',
      confirmButtonColor:'#FFC107',
    }).then((result) => {
      if (result.value && id!=null) {
    	 
    		console.log(id);
    	  $.ajax({
    	      type: "POST",
    	      url: "/bajacatalogo",
    	      data: { 
    	      	 "_csrf": $('#token').val(),
    	  	'idcatalogo': id
    	  	
    	      	// ,'Descripcion':Descripcion
    	      }
    	     
    	  }).done(function(data){
    		 
    		  listarMarcas();
    	  });
    	      Swal.fire({
    	        position: 'center',
    	        icon: 'success',
    	        title: 'dado de baja correctamente',
    	        showConfirmButton: false,
    	        timer: 1250
    	      })
      }//////////////termina result value
    })
  }
  // Reactivar marca
  function reactivarMarca(){
    Swal.fire({
      title: '¿Deseas reactivar la marca?',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Activar',
      confirmButtonColor:'#FFC107',
    }).then((result) => {
      if (result.value) {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Reactivada correctamente',
          showConfirmButton: false,
          timer: 1250
        })
      }
    })
  }
// Habilitar form de SweetAlert2
  $('#detalleColores').on('shown.bs.modal', function() {
       $(document).off('focusin.modal');
   });
// Agregar Color
  function agregarColor() {
		 Swal.fire({
		      title: 'Agregar color',
			    html:'<div class="row">'+
		        '<div class="form-group col-sm-12">'+
		          '<label for="pedidonom">Nombre del color</label>'+
		          '<input type="text" class="swal2-input" id="color" placeholder="Rojo">'+
		          '<label for="pedidonom">Codigo del color</label>'+
		          '<input type="color" class="swal2-input" id="codigocolor" placeholder="Rojo">'+
		        '</div>'+
		        '</div>',
		      showCancelButton: true,
		      cancelButtonColor: '#6C757D',
		      cancelButtonText: 'Cancelar',
		      confirmButtonText: 'Agregar',
		      confirmButtonColor:'#FFC107',
		    }).then((result) => {
		      if (result.value && document.getElementById("color").value) {
				    var Color=document.getElementById("color").value;
				    var CodigoColor=document.getElementById("codigocolor").value;
		    	  console.log(CodigoColor);
				   $.ajax({
		        type: "POST",
		        url: "/guardarcatalogo",
		        data: { 
		        	 "_csrf": $('#token').val(),
		        	'Color': Color,
		        	'CodigoColor': CodigoColor
		        	// ,'Descripcion':Descripcion
		        }
		       
		    }).done(function(data){
		    	listarColores();
		    });
		        Swal.fire({
		          position: 'center',
		          icon: 'success',
		          title: 'Insertado correctamente',
		          showConfirmButton: false,
		          timer: 1250
		        })
		      ///  window.setTimeout(function(){location.reload()}, 2000);
		      }
		    })
	  }
	// Editar color
	$(document).on('click', '.edit_data_color', function () {
		  var color_id = $(this).attr("id");  
			var color_nombre=$(this).attr("value"); 
			var color_repr=$(this).attr("color");
	Swal.fire({
	    title: 'Editar color',
	    html:'<div class="row">'+
	    '<div class="form-group col-sm-12">'+
	      '<label for="pedidonom">Nombre del color</label>'+
	      '<input type="text" class="form-control" id="color" value="'+color_nombre+'" placeholder="Rojo">'+
	      '<label for="pedidonom">Codigo del color</label>'+
	      '<input type="color" class="form-control" id="color_repr" value="'+color_repr+'" placeholder="Rojo">'+
	      '<input type="hidden" value=" '+color_id+' ">'+
	    '</div>'+
	    '</div>',
	    inputAttributes: {
	      autocapitalize: 'off'
	    },
	    showCancelButton: true,
	    cancelButtonColor: '#6C757D',
	    cancelButtonText: 'Cancelar',
	    confirmButtonText: 'Actualizar',
	    confirmButtonColor:'#DC3545',
	}).then((result) => {
	    if (result.value && document.getElementById("color").value) {
			    var Color=document.getElementById("color").value;
			    var ColorRepr=document.getElementById("color_repr").value;
	  	  console.log(result.value);
			   $.ajax({
	      type: "POST",
	      url: "/editarcatalogo",
	      data: { 
	      	 "_csrf": $('#token').val(),
	  	'Color': Color,
	  	'idLookup': color_id,
	  	'CodigoColor': ColorRepr
	      	// ,'Descripcion':Descripcion
	      }
	     
	  }).done(function(data){
		  listarColores();
	  });
	      Swal.fire({
	        position: 'center',
	        icon: 'success',
	        title: 'editado correctamente',
	        showConfirmButton: false,
	        timer: 1250
	      })
			
	    }
	  })
	}
	)
  // Dar de baja color
 function bajarColor(idbaja){
	 var id=idbaja;
    Swal.fire({
      title: '¿Deseas dar de baja el color?',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Dar de baja',
      confirmButtonColor:'#FFC107',
    }).then((result) => {
      if (result.value && id!=null) {
    	 
    		console.log(id);
    	  $.ajax({
    	      type: "POST",
    	      url: "/bajacatalogo",
    	      data: { 
    	      	 "_csrf": $('#token').val(),
    	  	'idcatalogo': id
    	  	
    	      	// ,'Descripcion':Descripcion
    	      }
    	     
    	  }).done(function(data){
    		 
    		  listarColores();
    	  });
    	      Swal.fire({
    	        position: 'center',
    	        icon: 'success',
    	        title: 'dado de baja correctamente',
    	        showConfirmButton: false,
    	        timer: 1250
    	      })
      }//////////////termina result value
    })
  }
  // Reactivar color
  function reactivarColor(){
    Swal.fire({
      title: '¿Deseas reactivar el color?',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Activar',
      confirmButtonColor:'#DC3545',
    }).then((result) => {
      if (result.value) {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Reactivado correctamente',
          showConfirmButton: false,
          timer: 1250
        })
      }
    })
  }
// Habilitar form de SweetAlert2
  $('#detalleTrazo').on('shown.bs.modal', function() {
       $(document).off('focusin.modal');
   });
  
  // Agregar Pieza de Trazo
  function agregarTrazo() {
		 Swal.fire({
		      title: 'Agregar trazo',
			    html:'<div class="row">'+
		        '<div class="form-group col-sm-12">'+
		          '<label for="pedidonom">Nombre pieza trazo</label>'+
		          '<input type="text" class="swal2-input" id="trazo" placeholder="Delantero">'+
		        '</div>'+
		        '</div>',
		      showCancelButton: true,
		      cancelButtonColor: '#6C757D',
		      cancelButtonText: 'Cancelar',
		      confirmButtonText: 'Agregar',
		      confirmButtonColor:'#28A745',
		    }).then((result) => {
		      if (result.value && document.getElementById("trazo").value) {
				    var Trazo=document.getElementById("trazo").value;
		    	  console.log(result.value);
				   $.ajax({
		        type: "POST",
		        url: "/guardarcatalogo",
		        data: { 
		        	 "_csrf": $('#token').val(),
		        	'PiezaTrazo': Trazo
		        	// ,'Descripcion':Descripcion
		        }
		       
		    }).done(function(data){
		    	listarTrazos();
		    });
		        Swal.fire({
		          position: 'center',
		          icon: 'success',
		          title: 'Insertado correctamente',
		          showConfirmButton: false,
		          timer: 1250
		        })
		        
		      }
		    })
	  }
	// Editar Trazo
	$(document).on('click', '.edit_data_trazo', function () {
		  var trazo_id = $(this).attr("id");  
			var trazo_nombre=$(this).attr("value");
		console.log($('#token').val());
	Swal.fire({
	    title: 'Editar pieza trazo',
	    html:'<div class="row">'+
	    '<div class="form-group col-sm-12">'+
	      '<label for="pedidonom">Nombre pieza trazo</label>'+
	      '<input type="text" class="form-control" id="trazo" value="'+trazo_nombre+'" placeholder="Delantero">'+
	      '<input type="hidden" value=" '+trazo_id+' ">'+
	    '</div>'+
	    '</div>',
	    inputAttributes: {
	      autocapitalize: 'off'
	    },
	    showCancelButton: true,
	    cancelButtonColor: '#6C757D',
	    cancelButtonText: 'Cancelar',
	    confirmButtonText: 'Actualizar',
	    confirmButtonColor:'#28A745',
	}).then((result) => {
	    if (result.value && document.getElementById("trazo").value) {
			    var Trazo=document.getElementById("trazo").value;
	  	  console.log(result.value);
			   $.ajax({
	      type: "POST",
	      url: "/editarcatalogo",
	      data: { 
	      	 "_csrf": $('#token').val(),
	  	'PiezaTrazo': Trazo,
	  	'idLookup': trazo_id
	      	// ,'Descripcion':Descripcion
	      }
	     
	  }).done(function(data){
		  listarTrazos();
	  });
	      Swal.fire({
	        position: 'center',
	        icon: 'success',
	        title: 'editado correctamente',
	        showConfirmButton: false,
	        timer: 1250
	      })
			
	    }
	  })
	}
	)
  // Dar de baja pieza de trazo
  function bajarTrazo(idbaja){
	 var id=idbaja;
    Swal.fire({
      title: '¿Deseas dar de baja el trazo?',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Dar de baja',
      confirmButtonColor:'#FFC107',
    }).then((result) => {
      if (result.value && id!=null) {
    	 
    		console.log(id);
    	  $.ajax({
    	      type: "POST",
    	      url: "/bajacatalogo",
    	      data: { 
    	      	 "_csrf": $('#token').val(),
    	  	'idcatalogo': id
    	  	
    	      	// ,'Descripcion':Descripcion
    	      }
    	     
    	  }).done(function(data){
    		 
    		  listarTrazos();
    	  });
    	      Swal.fire({
    	        position: 'center',
    	        icon: 'success',
    	        title: 'dado de baja correctamente',
    	        showConfirmButton: false,
    	        timer: 1250
    	      })
      }//////////////termina result value
    })
  }
  // Reactivar pieza de trazo
  function reactivarTrazo(){
    Swal.fire({
      title: '¿Deseas reactivar la pieza de trazo?',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Activar',
      confirmButtonColor:'#28A745',
    }).then((result) => {
      if (result.value) {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Reactivada correctamente',
          showConfirmButton: false,
          timer: 1250
        })
      }
    })
  }
// Habilitar form de SweetAlert2
  $('#detallePrenda').on('shown.bs.modal', function() {
       $(document).off('focusin.modal');
   });
  // Agregar Familia de prendas
  function agregarPrenda() {
		 Swal.fire({
		      title: 'Agregar familia prenda',
			    html:'<div class="row">'+
		        '<div class="form-group col-sm-12">'+
		          '<label for="pedidonom">Nombre de la familia prendas</label>'+
		          '<input type="text" class="swal2-input" id="familia" placeholder="Pantalón">'+
		        '</div>'+
		        '</div>',
		      showCancelButton: true,
		      cancelButtonColor: '#6C757D',
		      cancelButtonText: 'Cancelar',
		      confirmButtonText: 'Agregar',
		      confirmButtonColor:'#17a2b8',
		    }).then((result) => {
		      if (result.value && document.getElementById("familia").value) {
				    var FamiliaPrenda=document.getElementById("familia").value;
				   
				   $.ajax({
		        type: "POST",
		        url: "/guardarcatalogo",
		        data: { 
		        	 "_csrf": $('#token').val(),
		        	'FamiliaPrenda': FamiliaPrenda
		        	
		        	
		        	// ,'Descripcion':Descripcion
		        }
		       
		    }).done(function(data){
		    	listarPrendas();
		    });
		        Swal.fire({
		          position: 'center',
		          icon: 'success',
		          title: 'Insertado correctamente',
		          showConfirmButton: false,
		          timer: 1250
		        })
		       
		      }
		    })
	  }
  
	// Editar Prenda
  
  
  function editarPrenda(e) {
		 var descr=e.getAttribute("descripcion");
		
		console.log(descr);
		 Swal.fire({
		      title: 'Editar prenda',
			   html:'<div class="row">'+
			        '<div class="form-group col-sm-12">'+
			          '<label for="pedidonom">Nombre de la familia prendas</label>'+
			          '<input type="text" value="'+e.getAttribute("nombre")+'" class="swal2-input" id="nombre" placeholder="Pantalón">'+
			        '</div>'+
			        '<div class="form-group col-sm-12">'+
			          '<input type="hidden" value=" '+e.getAttribute("idlookup")+' " class="swal2-input" id="idlookup" placeholder="Pantalón">'+
			        '</div>'+
			        '</div>',
		      showCancelButton: true,
		      cancelButtonColor: '#6C757D',
		      cancelButtonText: 'Cancelar',
		      confirmButtonText: 'Actualizar',
		      confirmButtonColor:'#FFC107',
		    }).then((result) => {
		      if (result.value && document.getElementById("nombre").value && document.getElementById("descripcion").value && document.getElementById("idlookup").value) {
				    var FamiliaPrenda=document.getElementById("nombre").value;
				    var Descripcion=document.getElementById("descripcion").value;
				    var idLookup=document.getElementById("idlookup").value;
		    	  console.log(result.value);
				   $.ajax({
		        type: "POST",
		        url: "/editarcatalogo",
		        data: { 
		        	 "_csrf": $('#token').val(),
		        	'FamiliaPrenda': FamiliaPrenda,
		        	'Descripcion' :Descripcion,
		        	'idLookup' :idLookup
		        	// ,'Descripcion':Descripcion
		        }
		       
		    }).done(function(data){
		    	listarPrendas();
		    });
		        Swal.fire({
		          position: 'center',
		          icon: 'success',
		          title: 'editado correctamente',
		          showConfirmButton: false,
		          timer: 1250
		        })
		      
		      }
		    })
	  }
  // Dar de baja prenda
  function bajarPrenda(idbaja){
		 var id=idbaja;
	    Swal.fire({
	      title: '¿Deseas dar de baja la prenda?',
	      icon: 'warning',
	      showCancelButton: true,
	      cancelButtonColor: '#6C757D',
	      cancelButtonText: 'Cancelar',
	      confirmButtonText: 'Dar de baja',
	      confirmButtonColor:'#FFC107',
	    }).then((result) => {
	      if (result.value && id!=null) {
	    	 
	    		console.log(id);
	    	  $.ajax({
	    	      type: "POST",
	    	      url: "/bajacatalogo",
	    	      data: { 
	    	      	 "_csrf": $('#token').val(),
	    	  	'idcatalogo': id
	    	  	
	    	      	// ,'Descripcion':Descripcion
	    	      }
	    	     
	    	  }).done(function(data){
	    		 
	    		  listarPrendas();
	    	  });
	    	      Swal.fire({
	    	        position: 'center',
	    	        icon: 'success',
	    	        title: 'dado de baja correctamente',
	    	        showConfirmButton: false,
	    	        timer: 1250
	    	      })
	      }//////////////termina result value
	    })
	  }
  // Reactivar prenda
  function reactivarPrenda(){
    Swal.fire({
      title: '¿Deseas reactivar la familia de prenda?',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Activar',
      confirmButtonColor:'#17A2B8',
    }).then((result) => {
      if (result.value) {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Reactivada correctamente',
          showConfirmButton: false,
          timer: 1250
        })
      }
    })
  }
// Habilitar form de SweetAlert2
  $('#detalleGenero').on('shown.bs.modal', function() {
       $(document).off('focusin.modal');
   });
  // Agregar familia de genero
  function agregarGenero() {
		 Swal.fire({
		      title: 'Agregar genero',
			    html:'<div class="row">'+
		        '<div class="form-group col-sm-12">'+
		          '<label for="pedidonom">Nombre del genero</label>'+
		          '<input type="text" class="swal2-input" id="genero" placeholder="Caballero">'+
		        '</div>'+
		        '</div>',
		      showCancelButton: true,
		      cancelButtonColor: '#6C757D',
		      cancelButtonText: 'Cancelar',
		      confirmButtonText: 'Agregar',
		      confirmButtonColor:'#17a2b8',
		    }).then((result) => {
		      if (result.value && document.getElementById("genero").value) {
				    var Genero=document.getElementById("genero").value;
			
		    	  console.log(result.value);
				   $.ajax({
		        type: "POST",
		        url: "/guardarcatalogo",
		        data: { 
		        	 "_csrf": $('#token').val(),
		        	'FamiliaGenero': Genero
		        	
		        	// ,'Descripcion':Descripcion
		        }
		       
		    }).done(function(data){
		    	listarGeneros();
		    });
		        Swal.fire({
		          position: 'center',
		          icon: 'success',
		          title: 'Insertado correctamente',
		          showConfirmButton: false,
		          timer: 1250
		        })
		       
		      }
		    })
	  }

	// Editar genero


function editarGenero(e) {
		 var descr=e.getAttribute("descripcion");
		
		console.log(descr);
		 Swal.fire({
		      title: 'Editar genero',
			   html:'<div class="row">'+
			        '<div class="form-group col-sm-12">'+
			          '<label for="pedidonom">Nombre de genero</label>'+
			          '<input type="text" value="'+e.getAttribute("nombre")+'" class="swal2-input" id="nombre" placeholder="Caballero">'+
			        '</div>'+
			        '<div class="form-group col-sm-12">'+
			        
			          '<input type="hidden" value=" '+e.getAttribute("idlookup")+' " class="swal2-input" id="idlookup" placeholder="Parisina">'+
			        '</div>'+
			        '</div>',
		      showCancelButton: true,
		      cancelButtonColor: '#6C757D',
		      cancelButtonText: 'Cancelar',
		      confirmButtonText: 'Actualizar',
		      confirmButtonColor:'#FFC107',
		    }).then((result) => {
		      if (result.value && document.getElementById("nombre").value  && document.getElementById("idlookup").value) {
				    var FamiliaGenero=document.getElementById("nombre").value;
				   
				    var idLookup=document.getElementById("idlookup").value;
		    	  console.log(result.value);
				   $.ajax({
		        type: "POST",
		        url: "/editarcatalogo",
		        data: { 
		        	 "_csrf": $('#token').val(),
		        	'FamiliaGenero': FamiliaGenero,
		        	'idLookup' :idLookup
		        	// ,'Descripcion':Descripcion
		        }
		       
		    }).done(function(data){
		    	listarGeneros();
		    });
		        Swal.fire({
		          position: 'center',
		          icon: 'success',
		          title: 'editado correctamente',
		          showConfirmButton: false,
		          timer: 1250
		        })
		        //window.setTimeout(function(){location.reload()}, 2000);
		      }
		    })
	  }
  // Dar de baja familia de genero
function bajarGenero(idbaja){
	 var id=idbaja;
   Swal.fire({
     title: '¿Deseas dar de baja el genero?',
     icon: 'warning',
     showCancelButton: true,
     cancelButtonColor: '#6C757D',
     cancelButtonText: 'Cancelar',
     confirmButtonText: 'Dar de baja',
     confirmButtonColor:'#FFC107',
   }).then((result) => {
     if (result.value && id!=null) {
   	 
   		console.log(id);
   	  $.ajax({
   	      type: "POST",
   	      url: "/bajacatalogo",
   	      data: { 
   	      	 "_csrf": $('#token').val(),
   	  	'idcatalogo': id
   	  	
   	      	// ,'Descripcion':Descripcion
   	      }
   	     
   	  }).done(function(data){
   		 
   		  listarGeneros();
   	  });
   	      Swal.fire({
   	        position: 'center',
   	        icon: 'success',
   	        title: 'dado de baja correctamente',
   	        showConfirmButton: false,
   	        timer: 1250
   	      })
     }//////////////termina result value
   })
 }
  // Reactivar familia de genero
  function reactivarGenero(){
    Swal.fire({
      title: '¿Deseas reactivar la familia de g&eacute;nero?',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Activar',
      confirmButtonColor:'#DC3545',
    }).then((result) => {
      if (result.value) {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Reactivada correctamente',
          showConfirmButton: false,
          timer: 1250
        })
      }
    })
  }
// Habilitar form de SweetAlert2
  $('#detalleMantenimiento').on('shown.bs.modal', function() {
       $(document).off('focusin.modal');
   });
  // Agregar composicion
  function agregarComposicion() {
		 Swal.fire({
		      title: 'Agregar composición',
			    html:'<div class="row">'+
		        '<div class="form-group col-sm-12">'+
		          '<label for="pedidonom">Nombre de composición</label>'+
		          '<input type="text" class="swal2-input" id="composicion" placeholder="Algodón">'+
		        '</div>'+
		        '</div>',
		      showCancelButton: true,
		      cancelButtonColor: '#6C757D',
		      cancelButtonText: 'Cancelar',
		      confirmButtonText: 'Agregar',
		      confirmButtonColor:'#17a2b8',
		    }).then((result) => {
		      if (result.value && document.getElementById("composicion").value) {
				    var Composicion=document.getElementById("composicion").value;
			
		    	  console.log(result.value);
				   $.ajax({
		        type: "POST",
		        url: "/guardarcatalogo",
		        data: { 
		        	 "_csrf": $('#token').val(),
		        	'FamiliaComposicion': Composicion
		        	
		        	// ,'Descripcion':Descripcion
		        }
		       
		    }).done(function(data){
		    	listarComposiciones();
		    });
		        Swal.fire({
		          position: 'center',
		          icon: 'success',
		          title: 'Insertado correctamente',
		          showConfirmButton: false,
		          timer: 1250
		        })
		       
		      }
		    })
	  }

	// Editar genero


function editarComposicion(e) {
		 var descr=e.getAttribute("descripcion");
		
		console.log(descr);
		 Swal.fire({
		      title: 'Editar Composición',
			   html:'<div class="row">'+
			        '<div class="form-group col-sm-12">'+
			          '<label for="pedidonom">Nombre composicón</label>'+
			          '<input type="text" value="'+e.getAttribute("nombre")+'" class="swal2-input" id="nombre" placeholder="Algodón">'+
			        '</div>'+
			        '<div class="form-group col-sm-12">'+
			          
			          '<input type="hidden" value=" '+e.getAttribute("idlookup")+' " class="swal2-input" id="idlookup" placeholder="Parisina">'+
			        '</div>'+
			        '</div>',
		      showCancelButton: true,
		      cancelButtonColor: '#6C757D',
		      cancelButtonText: 'Cancelar',
		      confirmButtonText: 'Actualizar',
		      confirmButtonColor:'#FFC107',
		    }).then((result) => {
		      if (result.value && document.getElementById("nombre").value  && document.getElementById("idlookup").value) {
				    var FamiliaComposicion=document.getElementById("nombre").value;
				   
				    var idLookup=document.getElementById("idlookup").value;
		    	  console.log(result.value);
				   $.ajax({
		        type: "POST",
		        url: "/editarcatalogo",
		        data: { 
		        	 "_csrf": $('#token').val(),
		        	'FamiliaComposicion': FamiliaComposicion,
		        	'idLookup' :idLookup
		        	// ,'Descripcion':Descripcion
		        }
		       
		    }).done(function(data){
		    	listarComposiciones();
		    });
		        Swal.fire({
		          position: 'center',
		          icon: 'success',
		          title: 'editado correctamente',
		          showConfirmButton: false,
		          timer: 1250
		        })
		       
		      }
		    })
	  }
// Dar de baja familia de genero
function bajarComposicion(idbaja){
	 var id=idbaja;
  Swal.fire({
    title: '¿Deseas dar de baja la composicion?',
    icon: 'warning',
    showCancelButton: true,
    cancelButtonColor: '#6C757D',
    cancelButtonText: 'Cancelar',
    confirmButtonText: 'Dar de baja',
    confirmButtonColor:'#FFC107',
  }).then((result) => {
    if (result.value && id!=null) {
  	 
  		console.log(id);
  	  $.ajax({
  	      type: "POST",
  	      url: "/bajacatalogo",
  	      data: { 
  	      	 "_csrf": $('#token').val(),
  	  	'idcatalogo': id
  	  	
  	      	// ,'Descripcion':Descripcion
  	      }
  	     
  	  }).done(function(data){
  		 
  		  listarComposiciones();
  	  });
  	      Swal.fire({
  	        position: 'center',
  	        icon: 'success',
  	        title: 'dado de baja correctamente',
  	        showConfirmButton: false,
  	        timer: 1250
  	      })
    }//////////////termina result value
  })
}
// Reactivar familia de genero
function reactivarComposicion(){
 Swal.fire({
   title: '¿Deseas reactivar la familia de g&eacute;nero?',
   icon: 'warning',
   showCancelButton: true,
   cancelButtonColor: '#6C757D',
   cancelButtonText: 'Cancelar',
   confirmButtonText: 'Activar',
   confirmButtonColor:'#DC3545',
 }).then((result) => {
   if (result.value) {
     Swal.fire({
       position: 'center',
       icon: 'success',
       title: 'Reactivada correctamente',
       showConfirmButton: false,
       timer: 1250
     })
   }
 })
}
  // ////////////////////////
// Habilitar form de SweetAlert2
$('#detalleCuidado').on('shown.bs.modal', function() {
     $(document).off('focusin.modal');
 });
function agregarCuidado() {
	var token =$('#token').val();
	 Swal.fire({
	      title: 'Agregar instrucción de cuidado',
		    html:'<form method="POST" enctype="multipart/form-data" id="fileUploadForm" >'+
		    	'<div class="row">'+
	        '<div class="form-group col-sm-12">'+
	          '<label for="pedidonom">Nombre instrucción de cuidado</label>'+
	          '<input type="text" class="swal2-input" name="InstruccionCuidado" id="cuidado" placeholder="Lavar a mano">'+
	          '<label for="pedidonom">Icono instrucción de cuidado</label>'+
	          '<input required type="file" class="swal2-input" name="iconocuidado" id="iconocuidado" placeholder="lavar a mano">'+
	          '<input type="hidden" value='+token+' name="_csrf">'+
	        '</div>'+
	        '</div>'+
	        '</form>',
	      showCancelButton: true,
	      cancelButtonColor: '#6C757D',
	      cancelButtonText: 'Cancelar',
	      confirmButtonText: 'Agregar',
	      confirmButtonColor:'#17a2b8',
	    }).then((result) => {
	      if (result.value && document.getElementById("cuidado").value && document.getElementById("iconocuidado").value ) {
			    var Cuidado=document.getElementById("cuidado").value;
		        var iconocuidado=document.getElementById("iconocuidado").files[0].name; 
	    	  console.log(result.value);
	    	  console.log(iconocuidado);
	    	  var form = $('#fileUploadForm')[0];

	  		// Create an FormData object 
	          var data = new FormData(form);
	    	  $.ajax({
	        type: "POST",
	        url: "/guardarcatalogo",
	       
	        //processData: false,  // Important!
	       // contentType: false,
	        data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000
	       
	    }).done(function(data){
	    	listarCuidados();
	    });
	        Swal.fire({
	          position: 'center',
	          icon: 'success',
	          title: 'Insertado correctamente',
	          showConfirmButton: false,
	          timer: 1250
	        })
	      //  window.setTimeout(function(){location.reload()}, 2000);
	      }else{
	    	  Swal.fire({
		          position: 'center',
		          icon: 'error',
		          title: 'complete todos los campos',
		          showConfirmButton: false,
		          timer: 1250
		        })
	      }
	    })
 }

// Editar genero


function editarCuidado(e) {
	 var descr=e.getAttribute("descripcion");
	
	console.log(descr);
	 Swal.fire({
	      title: 'Editar instruccion de cuidado',
		   html:'<div class="row">'+
		        '<div class="form-group col-sm-12">'+
		          '<label for="pedidonom">Nombre instrucción de cuidado</label>'+
		          '<input type="text" value="'+e.getAttribute("nombre")+'" class="swal2-input" id="nombre" placeholder="Lavar a mano">'+
		        '</div>'+
		        '<div class="form-group col-sm-12">'+
		         
		          '<input type="hidden" value=" '+e.getAttribute("idlookup")+' " class="swal2-input" id="idlookup" placeholder="Parisina">'+
		        '</div>'+
		        '</div>',
	      showCancelButton: true,
	      cancelButtonColor: '#6C757D',
	      cancelButtonText: 'Cancelar',
	      confirmButtonText: 'Actualizar',
	      confirmButtonColor:'#FFC107',
	    }).then((result) => {
	      if (result.value && document.getElementById("nombre").value  && document.getElementById("idlookup").value) {
			    var InstruccionCuidado=document.getElementById("nombre").value;
			   
			    var idLookup=document.getElementById("idlookup").value;
	    	  console.log(result.value);
			   $.ajax({
	        type: "POST",
	        url: "/editarcatalogo",
	        data: { 
	        	 "_csrf": $('#token').val(),
	        	'InstruccionCuidado': InstruccionCuidado,
	        	'idLookup' :idLookup
	        	// ,'Descripcion':Descripcion
	        }
	       
	    }).done(function(data){
	    	listarCuidados();
	    });
	        Swal.fire({
	          position: 'center',
	          icon: 'success',
	          title: 'editado correctamente',
	          showConfirmButton: false,
	          timer: 1250
	        })
	        
	      }
	    })
 }
// Dar de baja familia de genero
function bajarCuidado(idbaja){
	 var id=idbaja;
 Swal.fire({
   title: '¿Deseas dar de baja el cuidado?',
   icon: 'warning',
   showCancelButton: true,
   cancelButtonColor: '#6C757D',
   cancelButtonText: 'Cancelar',
   confirmButtonText: 'Dar de baja',
   confirmButtonColor:'#FFC107',
 }).then((result) => {
   if (result.value && id!=null) {
 	 
 		console.log(id);
 	  $.ajax({
 	      type: "POST",
 	      url: "/bajacatalogo",
 	      data: { 
 	      	 "_csrf": $('#token').val(),
 	  	'idcatalogo': id
 	  	
 	      	// ,'Descripcion':Descripcion
 	      }
 	     
 	  }).done(function(data){
 		 
 		  listarCuidados();
 	  });
 	      Swal.fire({
 	        position: 'center',
 	        icon: 'success',
 	        title: 'dado de baja correctamente',
 	        showConfirmButton: false,
 	        timer: 1250
 	      })
   }//////////////termina result value
 })
}
// Reactivar familia de genero
function reactivarCuidado(){
Swal.fire({
 title: '¿Deseas reactivar la familia de g&eacute;nero?',
 icon: 'warning',
 showCancelButton: true,
 cancelButtonColor: '#6C757D',
 cancelButtonText: 'Cancelar',
 confirmButtonText: 'Activar',
 confirmButtonColor:'#DC3545',
}).then((result) => {
 if (result.value) {
   Swal.fire({
     position: 'center',
     icon: 'success',
     title: 'Reactivada correctamente',
     showConfirmButton: false,
     timer: 1250
   })
 }
})
}
//////////////////////
//Habilitar form de SweetAlert2
$('#detalleMedida').on('shown.bs.modal', function() {
     $(document).off('focusin.modal');
 });
function agregarMedida() {
	 Swal.fire({
	      title: 'Agregar unidades de medida',
		    html:'<div class="row">'+
	        '<div class="form-group col-sm-12">'+
	          '<label for="pedidonom">Nombre unidad de medida</label>'+
	          '<input type="text" class="swal2-input" id="medida" placeholder="Metro">'+
	        '</div>'+
	        '</div>',
	      showCancelButton: true,
	      cancelButtonColor: '#6C757D',
	      cancelButtonText: 'Cancelar',
	      confirmButtonText: 'Agregar',
	      confirmButtonColor:'#17a2b8',
	    }).then((result) => {
	      if (result.value && document.getElementById("medida").value) {
			    var Medida=document.getElementById("medida").value;
		
	    	  console.log(result.value);
			   $.ajax({
	        type: "POST",
	        url: "/guardarcatalogo",
	        data: { 
	        	 "_csrf": $('#token').val(),
	        	'UnidadMedida': Medida
	        	
	        	// ,'Descripcion':Descripcion
	        }
	       
	    }).done(function(data){
	    	listarMedidas();
	    });
	        Swal.fire({
	          position: 'center',
	          icon: 'success',
	          title: 'Insertado correctamente',
	          showConfirmButton: false,
	          timer: 1250
	        })
	      //  window.setTimeout(function(){location.reload()}, 2000);
	      }
	    })
 }

// Editar genero


function editarMedida(e) {
	 var descr=e.getAttribute("descripcion");
	
	console.log(descr);
	 Swal.fire({
	      title: 'Editar unidad de medida',
		   html:'<div class="row">'+
		        '<div class="form-group col-sm-12">'+
		          '<label for="pedidonom">Nombre unidad de medida</label>'+
		          '<input type="text" value="'+e.getAttribute("nombre")+'" class="swal2-input" id="nombre" placeholder="Metro">'+
		        '</div>'+
		        '<div class="form-group col-sm-12">'+
		         
		          '<input type="hidden" value=" '+e.getAttribute("idlookup")+' " class="swal2-input" id="idlookup" placeholder="Parisina">'+
		        '</div>'+
		        '</div>',
	      showCancelButton: true,
	      cancelButtonColor: '#6C757D',
	      cancelButtonText: 'Cancelar',
	      confirmButtonText: 'Actualizar',
	      confirmButtonColor:'#FFC107',
	    }).then((result) => {
	      if (result.value && document.getElementById("nombre").value  && document.getElementById("idlookup").value) {
			    var Medida=document.getElementById("nombre").value;
			   
			    var idLookup=document.getElementById("idlookup").value;
	    	  console.log(result.value);
			   $.ajax({
	        type: "POST",
	        url: "/editarcatalogo",
	        data: { 
	        	 "_csrf": $('#token').val(),
	        	'UnidadMedida': Medida,
	        	'idLookup' :idLookup
	        	// ,'Descripcion':Descripcion
	        }
	       
	    }).done(function(data){
	    	listarMedidas();
	    });
	        Swal.fire({
	          position: 'center',
	          icon: 'success',
	          title: 'editado correctamente',
	          showConfirmButton: false,
	          timer: 1250
	        })
	        
	      }
	    })
 }
// Dar de baja familia de genero
function bajarMedida(idbaja){
	 var id=idbaja;
Swal.fire({
  title: '¿Deseas dar de baja el cuidado?',
  icon: 'warning',
  showCancelButton: true,
  cancelButtonColor: '#6C757D',
  cancelButtonText: 'Cancelar',
  confirmButtonText: 'Dar de baja',
  confirmButtonColor:'#FFC107',
}).then((result) => {
  if (result.value && id!=null) {
	 
		console.log(id);
	  $.ajax({
	      type: "POST",
	      url: "/bajacatalogo",
	      data: { 
	      	 "_csrf": $('#token').val(),
	  	'idcatalogo': id
	  	
	      	// ,'Descripcion':Descripcion
	      }
	     
	  }).done(function(data){
		 
		  listarMedidas();
	  });
	      Swal.fire({
	        position: 'center',
	        icon: 'success',
	        title: 'dado de baja correctamente',
	        showConfirmButton: false,
	        timer: 1250
	      })
  }//////////////termina result value
})
}
// Reactivar familia de genero
function reactivarCuidado(){
Swal.fire({
 title: '¿Deseas reactivar la familia de g&eacute;nero?',
 icon: 'warning',
 showCancelButton: true,
 cancelButtonColor: '#6C757D',
 cancelButtonText: 'Cancelar',
 confirmButtonText: 'Activar',
 confirmButtonColor:'#DC3545',
}).then((result) => {
 if (result.value) {
   Swal.fire({
     position: 'center',
     icon: 'success',
     title: 'Reactivada correctamente',
     showConfirmButton: false,
     timer: 1250
   })
 }
})
}
////////////////////
//Habilitar form de SweetAlert2
$('#detalleMaterial').on('shown.bs.modal', function() {
     $(document).off('focusin.modal');
 });
function agregarMaterial() {
	 Swal.fire({
	      title: 'Agregar material',
		    html:'<div class="row">'+
	        '<div class="form-group col-sm-12">'+
	          '<label for="pedidonom">Nombre material</label>'+
	          '<input type="text" class="swal2-input" id="material" placeholder="Entretela">'+
	        '</div>'+
	        '</div>',
	      showCancelButton: true,
	      cancelButtonColor: '#6C757D',
	      cancelButtonText: 'Cancelar',
	      confirmButtonText: 'Agregar',
	      confirmButtonColor:'#17a2b8',
	    }).then((result) => {
	      if (result.value && document.getElementById("material").value) {
			    var Material=document.getElementById("material").value;
		
	    	  console.log(result.value);
			   $.ajax({
	        type: "POST",
	        url: "/guardarcatalogo",
	        data: { 
	        	 "_csrf": $('#token').val(),
	        	'Material': Material
	        	
	        	// ,'Descripcion':Descripcion
	        }
	       
	    }).done(function(data){
	    	listarMateriales();
	    });
	        Swal.fire({
	          position: 'center',
	          icon: 'success',
	          title: 'Insertado correctamente',
	          showConfirmButton: false,
	          timer: 1250
	        })
	      //  window.setTimeout(function(){location.reload()}, 2000);
	      }
	    })
 }

// Editar genero


function editarMaterial(e) {
	 var descr=e.getAttribute("descripcion");
	
	console.log(descr);
	 Swal.fire({
	      title: 'Editar material',
		   html:'<div class="row">'+
		        '<div class="form-group col-sm-12">'+
		          '<label for="pedidonom">Nombre medida</label>'+
		          '<input type="text" value="'+e.getAttribute("nombre")+'" class="swal2-input" id="nombre" placeholder="Entretela">'+
		        '</div>'+
		        '<div class="form-group col-sm-12">'+
		         
		          '<input type="hidden" value=" '+e.getAttribute("idlookup")+' " class="swal2-input" id="idlookup" placeholder="Parisina">'+
		        '</div>'+
		        '</div>',
	      showCancelButton: true,
	      cancelButtonColor: '#6C757D',
	      cancelButtonText: 'Cancelar',
	      confirmButtonText: 'Actualizar',
	      confirmButtonColor:'#FFC107',
	    }).then((result) => {
	      if (result.value && document.getElementById("nombre").value  && document.getElementById("idlookup").value) {
			    var Material=document.getElementById("nombre").value;
			   
			    var idLookup=document.getElementById("idlookup").value;
	    	  console.log(result.value);
			   $.ajax({
	        type: "POST",
	        url: "/editarcatalogo",
	        data: { 
	        	 "_csrf": $('#token').val(),
	        	'Material': Material,
	        	'idLookup' :idLookup
	        	// ,'Descripcion':Descripcion
	        }
	       
	    }).done(function(data){
	    	listarMateriales();
	    });
	        Swal.fire({
	          position: 'center',
	          icon: 'success',
	          title: 'editado correctamente',
	          showConfirmButton: false,
	          timer: 1250
	        })
	        
	      }
	    })
 }
// Dar de baja familia de genero
function bajarMaterial(idbaja){
	 var id=idbaja;
Swal.fire({
 title: '¿Deseas dar de baja el material?',
 icon: 'warning',
 showCancelButton: true,
 cancelButtonColor: '#6C757D',
 cancelButtonText: 'Cancelar',
 confirmButtonText: 'Dar de baja',
 confirmButtonColor:'#FFC107',
}).then((result) => {
 if (result.value && id!=null) {
	 
		console.log(id);
	  $.ajax({
	      type: "POST",
	      url: "/bajacatalogo",
	      data: { 
	      	 "_csrf": $('#token').val(),
	  	'idcatalogo': id
	  	
	      	// ,'Descripcion':Descripcion
	      }
	     
	  }).done(function(data){
		 
		  listarMateriales();
	  });
	      Swal.fire({
	        position: 'center',
	        icon: 'success',
	        title: 'dado de baja correctamente',
	        showConfirmButton: false,
	        timer: 1250
	      })
 }//////////////termina result value
})
}
// Reactivar familia de genero
function reactivarCuidado(){
Swal.fire({
 title: '¿Deseas reactivar la familia de g&eacute;nero?',
 icon: 'warning',
 showCancelButton: true,
 cancelButtonColor: '#6C757D',
 cancelButtonText: 'Cancelar',
 confirmButtonText: 'Activar',
 confirmButtonColor:'#DC3545',
}).then((result) => {
 if (result.value) {
   Swal.fire({
     position: 'center',
     icon: 'success',
     title: 'Reactivada correctamente',
     showConfirmButton: false,
     timer: 1250
   })
 }
})
}
//////////////////////////
//Habilitar form de SweetAlert2
$('#detalleMarcador').on('shown.bs.modal', function() {
     $(document).off('focusin.modal');
 });
function agregarMarcador() {
	 Swal.fire({
	      title: 'Agregar marcador',
		    html:'<div class="row">'+
	        '<div class="form-group col-sm-12">'+
	          '<label for="pedidonom">Nombre marcador</label>'+
	          '<input type="text" class="swal2-input" id="marcador" placeholder="Cierre en la bolsa">'+
	        '</div>'+
	        '</div>',
	      showCancelButton: true,
	      cancelButtonColor: '#6C757D',
	      cancelButtonText: 'Cancelar',
	      confirmButtonText: 'Agregar',
	      confirmButtonColor:'#17a2b8',
	    }).then((result) => {
	      if (result.value && document.getElementById("marcador").value) {
			    var Marcador=document.getElementById("marcador").value;
		
	    	  console.log(result.value);
			   $.ajax({
	        type: "POST",
	        url: "/guardarcatalogo",
	        data: { 
	        	 "_csrf": $('#token').val(),
	        	'Marcador': Marcador
	        	
	        	// ,'Descripcion':Descripcion
	        }
	       
	    }).done(function(data){
	    	listarMarcadores();
	    });
	        Swal.fire({
	          position: 'center',
	          icon: 'success',
	          title: 'Insertado correctamente',
	          showConfirmButton: false,
	          timer: 1250
	        })
	      //  window.setTimeout(function(){location.reload()}, 2000);
	      }
	    })
 }

// Editar genero


function editarMarcador(e) {
	 var descr=e.getAttribute("descripcion");
	
	console.log(descr);
	 Swal.fire({
	      title: 'Editar marcador',
		   html:'<div class="row">'+
		        '<div class="form-group col-sm-12">'+
		          '<label for="pedidonom">Nombre marcador</label>'+
		          '<input type="text" value="'+e.getAttribute("nombre")+'" class="swal2-input" id="nombre" placeholder="Cierre en la bolsa">'+
		        '</div>'+
		        '<div class="form-group col-sm-12">'+
		         
		          '<input type="hidden" value=" '+e.getAttribute("idlookup")+' " class="swal2-input" id="idlookup" placeholder="Parisina">'+
		        '</div>'+
		        '</div>',
	      showCancelButton: true,
	      cancelButtonColor: '#6C757D',
	      cancelButtonText: 'Cancelar',
	      confirmButtonText: 'Actualizar',
	      confirmButtonColor:'#FFC107',
	    }).then((result) => {
	      if (result.value && document.getElementById("nombre").value  && document.getElementById("idlookup").value) {
			    var Marcador=document.getElementById("nombre").value;
			   
			    var idLookup=document.getElementById("idlookup").value;
	    	  console.log(result.value);
			   $.ajax({
	        type: "POST",
	        url: "/editarcatalogo",
	        data: { 
	        	 "_csrf": $('#token').val(),
	        	'Marcador': Marcador,
	        	'idLookup' :idLookup
	        	// ,'Descripcion':Descripcion
	        }
	       
	    }).done(function(data){
	    	listarMarcadores();
	    });
	        Swal.fire({
	          position: 'center',
	          icon: 'success',
	          title: 'editado correctamente',
	          showConfirmButton: false,
	          timer: 1250
	        })
	        
	      }
	    })
 }
// Dar de baja familia de genero
function bajarMarcador(idbaja){
	 var id=idbaja;
Swal.fire({
 title: '¿Deseas dar de baja el marcador?',
 icon: 'warning',
 showCancelButton: true,
 cancelButtonColor: '#6C757D',
 cancelButtonText: 'Cancelar',
 confirmButtonText: 'Dar de baja',
 confirmButtonColor:'#FFC107',
}).then((result) => {
 if (result.value && id!=null) {
	 
		console.log(id);
	  $.ajax({
	      type: "POST",
	      url: "/bajacatalogo",
	      data: { 
	      	 "_csrf": $('#token').val(),
	  	'idcatalogo': id
	  	
	      	// ,'Descripcion':Descripcion
	      }
	     
	  }).done(function(data){
		 
		  listarMarcadores();
	  });
	      Swal.fire({
	        position: 'center',
	        icon: 'success',
	        title: 'dado de baja correctamente',
	        showConfirmButton: false,
	        timer: 1250
	      })
 }//////////////termina result value
})
}
// Reactivar familia de genero


