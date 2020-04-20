 function listarTrazos(id) {
	 document.getElementById("id_muestra").value = id;
	 document.getElementById("tipo").value = "trazo";
	 $('#menu').remove();
	 $('#contenedorTabla').append(
			 "<div  class='modal-header' id='menu' >"+
             "<ul class='nav nav-tabs' role='tablist'>"+
                 "<li class='nav-item'>"+
                     "<a class='nav-link  active' onclick='listarTrazos("+id+")' href='#trazo' role='tab' data-toggle='tab' aria-selected='true'>Trazo</a>"+
                 "</li>"+
                 "<li class='nav-item'>"+
                    " <a class='nav-link'  onclick='listarCorte("+id+")'   href='#corte' role='tab' data-toggle='tab'>Corte</a>"+
                 "</li>"+
                 "<li class='nav-item'>"+
                     "<a class='nav-link' onclick='listarConfeccion("+id+")'  href='#confeccion' role='tab' data-toggle='tab'>Confecci&oacute;n</a>"+
                 "</li>"+
                 "<li class='nav-item'>"+
                     "<a class='nav-link' onclick='listarPlanchado("+id+")'  href='#planchado' role='tab' data-toggle='tab'>Planchado</a>"+
                 "</li>"+
                 "<li class='nav-item'>"+
                     "<a class='nav-link' onclick='listarTerminado("+id+")' href='#terminado' role='tab' data-toggle='tab'>Terminado</a>"+
                 "</li>"+
             "</ul>"+
             "<button type='button' class='close' data-dismiss='modal' aria-label='Close'>"+
                 "<span aria-hidden='true'>&times;</span>"+
             "</button>"+ "</div>");
	 console.log("hola humano yo soy el id que mandas de control de produccionS "+id);
		$.ajax({
		    method: "GET",
		    url: "/listar-procesos/"+id+"/1",
		    success: (data) => {
		    	$('#quitar').remove();
		    	$('#quitar2').remove();
		    	$('#quitar3').remove();
		    	$('#quitar4').remove();
		    	$('#quitar5').remove();
		    	$('#contenedorTabla').append(
		    			
		    			"<div class='modal-body' id='quitar'>" +
		    			"<div class='form-group col-sm-12'>" +
		    			"<button type='button'  onclick='nuevo("+id+",1)' class='btn btn-primary' data-toggle='modal' data-target='#aux'>Nuevo Trazo</button>"+
   						"<button onclick='PausarTodo("+id+", 1)' class='btn btn-danger next-step float-right' type='button'>Pausar Todo</button>"+
  					"</div>"+
		    				
		    			"<table class='table table-striped table-bordered' id='idtable'>" +
	                                        "<thead>" +
	                                            "<tr>" +
	                                                "<th>Operario</th>" +
	                                                "<th>Fecha de recepcion</th>" +
	                                                "<th>Fecha de entrega</th>" +
	                                                "<th>En:</th>" +
	                                                "<th>Controles</th>" +
	                                            "</tr>" +
	                                        "</thead>" +
	                                    "</table>" + "</div>");
		        var a;
		        var b = [];
		        for (i in data){
		        	if (data[i][5]=='Nuevo'){
		        		a = [
							"<tr>" +
							"<td>" + data[i][0] + "</td>",
							"<td>" + data[i][1]+ "</td>",
							"<td>" + data[i][2] + "</td>",
							"<td>" + data[i][5]+ "</td>",
							"<td>"+
							"<button onclick='play("+data[i][4]+","+id+" )' id='"+data[i][4]+"' value='"+data[i][4]+"' style='border-radius: 35%;'> <i class='fas fa-play text-success'>  </i></button>&nbsp;"+
							"<button style='border-radius: 35%;'> <i class='fa fa-pause'></i> </i></button>&nbsp;"+
							"<button  style='border-radius: 35%;'> <i class='fa fa-stop'></i></button>&nbsp;"+
							"</td>"+
							"<tr>"
							];
		        	}
		        	if (data[i][5]=='Play'){
		        		a = [
							"<tr>" +
							"<td> <a class='text-primary'href='#' onclick='listarHoras("+data[i][4]+", 1)' > "+ data[i][0]+"</a> </td>",
							"<td>" + data[i][1]+ "</td>",
							"<td>" + data[i][2] + "</td>",
							"<td>" + data[i][5]+ "</td>",		
							" <td>"+
							" <button style='border-radius: 35%;'> <i class='fa fa-play'></i> </button>&nbsp;"+
							" <button onclick='pausa("+data[i][4]+","+id+" )' id='"+data[i][4]+"' value='"+data[i][4]+"' style='border-radius: 35%;'> <i class='fas fa-pause text-warning'>  </i></button>&nbsp;"+
							"<button  onclick='stop("+data[i][4]+","+id+" )'  style='border-radius: 35%;'><i class='fas fa-stop text-danger'></i></button>&nbsp;"+
							"</td>"+
							"<tr>"
							];
		        	}
		        	if (data[i][5]=='Pausa'){
		        		a = [
							"<tr>" +
							"<td> <a class='text-primary'href='#' onclick='listarHoras("+data[i][4]+", 1)' > "+ data[i][0]+"</a> </td>",
							"<td>" + data[i][1]+ "</td>",
							"<td>" + data[i][2] + "</td>",
							"<td>" + data[i][5]+ "</td>",		
							" <td>"+
							" <button onclick='play("+data[i][4]+","+id+" )' id='"+data[i][4]+"' value='"+data[i][4]+"' style='border-radius: 35%;'> <i class='fas fa-play text-success'>  </i></button>&nbsp;"+
							"<button style='border-radius: 35%;'> <i class='fa fa-pause'></i> </i></button>&nbsp;"+
							"<button  style='border-radius: 35%;'> <i class='fa fa-stop'></i></button>&nbsp;"+
							"</td>"+
							"<tr>"
							];
		        	}
		        	if (data[i][5]=='Stop'){
		        		a = [
							"<tr>" +
							"<td> <a class='text-primary'href='#' onclick='listarHoras("+data[i][4]+", 1)' > "+ data[i][0]+"</a> </td>",
							"<td>" + data[i][1]+ "</td>",
							"<td>" + data[i][2] + "</td>",
							"<td>" + data[i][5]+ "</td>",		
							" <td>"+
							" <button style='border-radius: 35%;'> <i class='fa fa-play'></i> </button>&nbsp;"+
							"<button style='border-radius: 35%;'> <i class='fa fa-pause'></i> </i></button>&nbsp;"+
							"<button  style='border-radius: 35%;'> <i class='fa fa-stop'></i></button>&nbsp;"+
							"</td>"+
							"<tr>"
							];
		        	}
						b.push(a);	
		        }	        
			    var tabla = $('#idtable').DataTable({
	            	"data":b,
	                "ordering": true,
	                "pageLength": 5,
	                "lengthMenu": [
	                    [5, 10, 25, 50, 10],
	                    [5, 10, 25, 50, 10]
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

 function listarCorte(id) {
	 document.getElementById("id_muestra").value = id;
	 document.getElementById("tipo").value = "corte";
	 $('#menu').remove();
	 $('#contenedorTabla').append(
			 "<div  class='modal-header' id='menu' >"+
             "<ul class='nav nav-tabs' role='tablist'>"+
                 "<li class='nav-item'>"+
                     "<a class='nav-link ' onclick='listarTrazos("+id+")' href='#trazo' role='tab' data-toggle='tab' aria-selected='true'>Trazo</a>"+
                 "</li>"+
                 "<li class='nav-item'>"+
                    " <a class='nav-link active'  onclick='listarCorte("+id+")'   href='#corte' role='tab' data-toggle='tab'>Corte</a>"+
                 "</li>"+
                 "<li class='nav-item'>"+
                     "<a class='nav-link' onclick='listarConfeccion("+id+")'  href='#confeccion' role='tab' data-toggle='tab'>Confecci&oacute;n</a>"+
                 "</li>"+
                 "<li class='nav-item'>"+
                     "<a class='nav-link' onclick='listarPlanchado("+id+")'  href='#planchado' role='tab' data-toggle='tab'>Planchado</a>"+
                 "</li>"+
                 "<li class='nav-item'>"+
                     "<a class='nav-link' onclick='listarTerminado("+id+")' href='#terminado' role='tab' data-toggle='tab'>Terminado</a>"+
                 "</li>"+
             "</ul>"+
             "<button type='button' class='close' data-dismiss='modal' aria-label='Close'>"+
                 "<span aria-hidden='true'>&times;</span>"+
             "</button>"+ "</div>");
	 console.log("corte "+id);
		$.ajax({
		    method: "GET",
		    url: "/listar-procesos/"+id+"/2",
		    success: (data) => {
		    	$('#quitar').remove();
		    	$('#quitar2').remove();
		    	$('#quitar3').remove();
		    	$('#quitar4').remove();
		    	$('#quitar5').remove();
		    	$('#contenedorTabla').append(
		    			"<div class='modal-body' id='quitar'>" +
		    			"<div class='form-group col-sm-12'>" +
		    			"<button type='button'  onclick='nuevo("+id+",2)' class='btn btn-primary' data-toggle='modal' data-target='#aux'>Nuevo Corte</button>"+
   						"<button onclick='PausarTodo("+id+", 2)' class='btn btn-danger next-step float-right' type='button'>Pausar Todo</button>"+
  					"</div>"+
		    				
		    			
		    			"<table class='table table-striped table-bordered' id='idtable2'>" +
	                                        "<thead>" +
	                                            "<tr>" +
	                                                "<th>Operario</th>" +
	                                                "<th>Fecha de recepcion</th>" +
	                                                "<th>Fecha de entrega</th>" +
	                                                "<th>En:</th>" +
	                                                "<th>Controles</th>" +
	                                            "</tr>" +
	                                        "</thead>" +
	                                    "</table>" + "</div>");
		        var a;
		        var b = [];
		        for (i in data){
		        	if (data[i][5]=='Nuevo'){
		        		a = [
							"<tr>" +
							"<td>" + data[i][0] + "</td>",
							"<td>" + data[i][1]+ "</td>",
							"<td>" + data[i][2] + "</td>",
							"<td>" + data[i][5]+ "</td>",
							"<td>"+
							"<button onclick='play("+data[i][4]+","+id+" )' id='"+data[i][4]+"' value='"+data[i][4]+"' style='border-radius: 35%;'> <i class='fas fa-play text-success'>  </i></button>&nbsp;"+
							"<button style='border-radius: 35%;'> <i class='fa fa-pause'></i> </i></button>&nbsp;"+
							"<button  style='border-radius: 35%;'> <i class='fa fa-stop'></i></button>&nbsp;"+
							"</td>"+
							"<tr>"
							];
		        	}
		        	if (data[i][5]=='Play'){
		        		a = [
							"<tr>" +
							"<td> <a class='text-primary'href='#' onclick='listarHoras("+data[i][4]+", 2)' > "+ data[i][0]+"</a> </td>",
							"<td>" + data[i][1]+ "</td>",
							"<td>" + data[i][2] + "</td>",
							"<td>" + data[i][5]+ "</td>",		
							" <td>"+
							" <button style='border-radius: 35%;'> <i class='fa fa-play'></i> </button>&nbsp;"+
							" <button onclick='pausa("+data[i][4]+","+id+" )' id='"+data[i][4]+"' value='"+data[i][4]+"' style='border-radius: 35%;'> <i class='fas fa-pause text-warning'>  </i></button>&nbsp;"+
							"<button  onclick='stop("+data[i][4]+","+id+" )'  style='border-radius: 35%;'><i class='fas fa-stop text-danger'></i></button>&nbsp;"+
							"</td>"+
							"<tr>"
							];
		        	}
		        	if (data[i][5]=='Pausa'){
		        		a = [
							"<tr>" +
							"<td> <a class='text-primary'href='#' onclick='listarHoras("+data[i][4]+", 2)' > "+ data[i][0]+"</a> </td>",
							"<td>" + data[i][1]+ "</td>",
							"<td>" + data[i][2] + "</td>",
							"<td>" + data[i][5]+ "</td>",		
							" <td>"+
							" <button onclick='play("+data[i][4]+","+id+" )' id='"+data[i][4]+"' value='"+data[i][4]+"' style='border-radius: 35%;'> <i class='fas fa-play text-success'>  </i></button>&nbsp;"+
							"<button style='border-radius: 35%;'> <i class='fa fa-pause'></i> </i></button>&nbsp;"+
							"<button  style='border-radius: 35%;'> <i class='fa fa-stop'></i></button>&nbsp;"+
							"</td>"+
							"<tr>"
							];
		        	}
		        	if (data[i][5]=='Stop'){
		        		a = [
							"<tr>" +
							"<td> <a class='text-primary'href='#' onclick='listarHoras("+data[i][4]+", 2)' > "+ data[i][0]+"</a> </td>",
							"<td>" + data[i][1]+ "</td>",
							"<td>" + data[i][2] + "</td>",
							"<td>" + data[i][5]+ "</td>",		
							" <td>"+
							" <button style='border-radius: 35%;'> <i class='fa fa-play'></i> </button>&nbsp;"+
							"<button style='border-radius: 35%;'> <i class='fa fa-pause'></i> </i></button>&nbsp;"+
							"<button  style='border-radius: 35%;'> <i class='fa fa-stop'></i></button>&nbsp;"+
							"</td>"+
							"<tr>"
							];
		        	}
						b.push(a);	
		        }	        
			    var tabla = $('#idtable2').DataTable({
	            	"data":b,
	                "ordering": true,
	                "pageLength": 5,
	                "lengthMenu": [
	                    [5, 10, 25, 50, 10],
	                    [5, 10, 25, 50, 10]
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
 
 function listarConfeccion(id) {
	 document.getElementById("id_muestra").value = id;
	 document.getElementById("tipo").value = "confeccion";
	 $('#menu').remove();
	 $('#contenedorTabla').append(
			 "<div  class='modal-header' id='menu' >"+
             "<ul class='nav nav-tabs' role='tablist'>"+
                 "<li class='nav-item'>"+
                     "<a class='nav-link' onclick='listarTrazos("+id+")' href='#trazo' role='tab' data-toggle='tab' aria-selected='true'>Trazo</a>"+
                 "</li>"+
                 "<li class='nav-item'>"+
                    " <a class='nav-link'  onclick='listarCorte("+id+")'   href='#corte' role='tab' data-toggle='tab'>Corte</a>"+
                 "</li>"+
                 "<li class='nav-item'>"+
                     "<a class='nav-link active' onclick='listarConfeccion("+id+")'  href='#confeccion' role='tab' data-toggle='tab'>Confecci&oacute;n</a>"+
                 "</li>"+
                 "<li class='nav-item'>"+
                     "<a class='nav-link' onclick='listarPlanchado("+id+")'  href='#planchado' role='tab' data-toggle='tab'>Planchado</a>"+
                 "</li>"+
                 "<li class='nav-item'>"+
                     "<a class='nav-link' onclick='listarTerminado("+id+")' href='#terminado' role='tab' data-toggle='tab'>Terminado</a>"+
                 "</li>"+
             "</ul>"+
             "<button type='button' class='close' data-dismiss='modal' aria-label='Close'>"+
                 "<span aria-hidden='true'>&times;</span>"+
             "</button>"+ "</div>");
	 console.log("corte "+id);
		$.ajax({
		    method: "GET",
		    url: "/listar-procesos/"+id+"/3",
		    success: (data) => {
		    	$('#quitar').remove();
		    	$('#quitar2').remove();
		    	$('#quitar3').remove();
		    	$('#quitar4').remove();
		    	$('#quitar5').remove();
		    	$('#contenedorTabla').append(

		    			
		    			"<div class='modal-body' id='quitar'>" +
		    			"<div class='form-group col-sm-12'>" +
		    			"<button type='button'  onclick='nuevo("+id+",3)' class='btn btn-primary' data-toggle='modal' data-target='#aux'>Nueva Confección</button>"+
   						"<button onclick='PausarTodo("+id+", 3)' class='btn btn-danger next-step float-right' type='button'>Pausar Todo</button>"+
  					"</div>"+
		    				
		    			
		    			"<table class='table table-striped table-bordered' id='idtable3'>" +
	                                        "<thead>" +
	                                            "<tr>" +
	                                                "<th>Operario</th>" +
	                                                "<th>Fecha de recepcion</th>" +
	                                                "<th>Fecha de entrega</th>" +
	                                                "<th>En:</th>" +
	                                                "<th>Controles</th>" +
	                                            "</tr>" +
	                                        "</thead>" +
	                                    "</table>" + "</div>");
		        var a;
		        var b = [];
		        for (i in data){
		        	if (data[i][5]=='Nuevo'){
		        		a = [
							"<tr>" +
							"<td>" + data[i][0] + "</td>",
							"<td>" + data[i][1]+ "</td>",
							"<td>" + data[i][2] + "</td>",
							"<td>" + data[i][5]+ "</td>",
							"<td>"+
							"<button onclick='play("+data[i][4]+","+id+" )' id='"+data[i][4]+"' value='"+data[i][4]+"' style='border-radius: 35%;'> <i class='fas fa-play text-success'>  </i></button>&nbsp;"+
							"<button style='border-radius: 35%;'> <i class='fa fa-pause'></i> </i></button>&nbsp;"+
							"<button  style='border-radius: 35%;'> <i class='fa fa-stop'></i></button>&nbsp;"+
							"</td>"+
							"<tr>"
							];
		        	}
		        	if (data[i][5]=='Play'){
		        		a = [
							"<tr>" +
							"<td> <a class='text-primary'href='#' onclick='listarHoras("+data[i][4]+", 3)' > "+ data[i][0]+"</a> </td>",
							"<td>" + data[i][1]+ "</td>",
							"<td>" + data[i][2] + "</td>",
							"<td>" + data[i][5]+ "</td>",		
							" <td>"+
							" <button style='border-radius: 35%;'> <i class='fa fa-play'></i> </button>&nbsp;"+
							" <button onclick='pausa("+data[i][4]+","+id+" )' id='"+data[i][4]+"' value='"+data[i][4]+"' style='border-radius: 35%;'> <i class='fas fa-pause text-warning'>  </i></button>&nbsp;"+
							"<button  onclick='stop("+data[i][4]+","+id+" )'  style='border-radius: 35%;'><i class='fas fa-stop text-danger'></i></button>&nbsp;"+
							"</td>"+
							"<tr>"
							];
		        	}
		        	if (data[i][5]=='Pausa'){
		        		a = [
							"<tr>" +
							"<td> <a class='text-primary'href='#' onclick='listarHoras("+data[i][4]+", 3)' > "+ data[i][0]+"</a> </td>",
							"<td>" + data[i][1]+ "</td>",
							"<td>" + data[i][2] + "</td>",
							"<td>" + data[i][5]+ "</td>",		
							" <td>"+
							" <button onclick='play("+data[i][4]+","+id+" )' id='"+data[i][4]+"' value='"+data[i][4]+"' style='border-radius: 35%;'> <i class='fas fa-play text-success'>  </i></button>&nbsp;"+
							"<button style='border-radius: 35%;'> <i class='fa fa-pause'></i> </i></button>&nbsp;"+
							"<button  style='border-radius: 35%;'> <i class='fa fa-stop'></i></button>&nbsp;"+
							"</td>"+
							"<tr>"
							];
		        	}
		        	if (data[i][5]=='Stop'){
		        		a = [
							"<tr>" +
							"<td> <a class='text-primary'href='#' onclick='listarHoras("+data[i][4]+", 3)' > "+ data[i][0]+"</a> </td>",
							"<td>" + data[i][1]+ "</td>",
							"<td>" + data[i][2] + "</td>",
							"<td>" + data[i][5]+ "</td>",		
							" <td>"+
							" <button style='border-radius: 35%;'> <i class='fa fa-play'></i> </button>&nbsp;"+
							"<button style='border-radius: 35%;'> <i class='fa fa-pause'></i> </i></button>&nbsp;"+
							"<button  style='border-radius: 35%;'> <i class='fa fa-stop'></i></button>&nbsp;"+
							"</td>"+
							"<tr>"
							];
		        	}
						b.push(a);	
		        }	        
			    var tabla = $('#idtable3').DataTable({
	            	"data":b,
	                "ordering": true,
	                "pageLength": 5,
	                "lengthMenu": [
	                    [5, 10, 25, 50, 10],
	                    [5, 10, 25, 50, 10]
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
 
 function listarPlanchado(id) {
	 document.getElementById("id_muestra").value = id;
	 document.getElementById("tipo").value = "planchado";
	 $('#menu').remove();
	 $('#contenedorTabla').append(
			 "<div  class='modal-header' id='menu' >"+
             "<ul class='nav nav-tabs' role='tablist'>"+
                 "<li class='nav-item'>"+
                     "<a class='nav-link' onclick='listarTrazos("+id+")' href='#trazo' role='tab' data-toggle='tab' aria-selected='true'>Trazo</a>"+
                 "</li>"+
                 "<li class='nav-item'>"+
                    " <a class='nav-link'  onclick='listarCorte("+id+")'   href='#corte' role='tab' data-toggle='tab'>Corte</a>"+
                 "</li>"+
                 "<li class='nav-item'>"+
                     "<a class='nav-link' onclick='listarConfeccion("+id+")'  href='#confeccion' role='tab' data-toggle='tab'>Confecci&oacute;n</a>"+
                 "</li>"+
                 "<li class='nav-item'>"+
                     "<a class='nav-link active' onclick='listarPlanchado("+id+")'  href='#planchado' role='tab' data-toggle='tab'>Planchado</a>"+
                 "</li>"+
                 "<li class='nav-item'>"+
                     "<a class='nav-link ' onclick='listarTerminado("+id+")' href='#terminado' role='tab' data-toggle='tab'>Terminado</a>"+
                 "</li>"+
             "</ul>"+
             "<button type='button' class='close' data-dismiss='modal' aria-label='Close'>"+
                 "<span aria-hidden='true'>&times;</span>"+
             "</button>"+ "</div>");
	 console.log("corte "+id);
		$.ajax({
		    method: "GET",
		    url: "/listar-procesos/"+id+"/4",
		    success: (data) => {
		    	$('#quitar').remove();
		    	$('#quitar2').remove();
		    	$('#quitar3').remove();
		    	$('#quitar4').remove();
		    	$('#quitar5').remove();
		    	$('#contenedorTabla').append(
		    			

		    			
		    			"<div class='modal-body' id='quitar'>" +
		    			"<div class='form-group col-sm-12'>" +
		    			"<button type='button'  onclick='nuevo("+id+",4)' class='btn btn-primary' data-toggle='modal' data-target='#aux'>Nuevo Planchado</button>"+
   						"<button onclick='PausarTodo("+id+", 4)' class='btn btn-danger next-step float-right' type='button'>Pausar Todo</button>"+
  					"</div>"+
		    				
		    			"<table class='table table-striped table-bordered' id='idtable4'>" +
	                                        "<thead>" +
	                                            "<tr>" +
	                                                "<th>Operario</th>" +
	                                                "<th>Fecha de recepcion</th>" +
	                                                "<th>Fecha de entrega</th>" +
	                                                "<th>En:</th>" +
	                                                "<th>Controles</th>" +
	                                            "</tr>" +
	                                        "</thead>" +
	                                    "</table>" + "</div>");
		        var a;
		        var b = [];
		        for (i in data){
		        	if (data[i][5]=='Nuevo'){
		        		a = [
							"<tr>" +
							"<td>" + data[i][0] + "</td>",
							"<td>" + data[i][1]+ "</td>",
							"<td>" + data[i][2] + "</td>",
							"<td>" + data[i][5]+ "</td>",
							"<td>"+
							"<button onclick='play("+data[i][4]+","+id+" )' id='"+data[i][4]+"' value='"+data[i][4]+"' style='border-radius: 35%;'> <i class='fas fa-play text-success'>  </i></button>&nbsp;"+
							"<button style='border-radius: 35%;'> <i class='fa fa-pause'></i> </i></button>&nbsp;"+
							"<button  style='border-radius: 35%;'> <i class='fa fa-stop'></i></button>&nbsp;"+
							"</td>"+
							"<tr>"
							];
		        	}
		        	if (data[i][5]=='Play'){
		        		a = [
							"<tr>" +
							"<td> <a class='text-primary'href='#' onclick='listarHoras("+data[i][4]+", 4)' > "+ data[i][0]+"</a> </td>",
							"<td>" + data[i][1]+ "</td>",
							"<td>" + data[i][2] + "</td>",
							"<td>" + data[i][5]+ "</td>",		
							" <td>"+
							" <button style='border-radius: 35%;'> <i class='fa fa-play'></i> </button>&nbsp;"+
							" <button onclick='pausa("+data[i][4]+","+id+" )' id='"+data[i][4]+"' value='"+data[i][4]+"' style='border-radius: 35%;'> <i class='fas fa-pause text-warning'>  </i></button>&nbsp;"+
							"<button  onclick='stop("+data[i][4]+","+id+" )'  style='border-radius: 35%;'><i class='fas fa-stop text-danger'></i></button>&nbsp;"+
							"</td>"+
							"<tr>"
							];
		        	}
		        	if (data[i][5]=='Pausa'){
		        		a = [
							"<tr>" +
							"<td> <a class='text-primary'href='#' onclick='listarHoras("+data[i][4]+", 4)' > "+ data[i][0]+"</a> </td>",
							"<td>" + data[i][1]+ "</td>",
							"<td>" + data[i][2] + "</td>",
							"<td>" + data[i][5]+ "</td>",		
							" <td>"+
							" <button onclick='play("+data[i][4]+","+id+" )' id='"+data[i][4]+"' value='"+data[i][4]+"' style='border-radius: 35%;'> <i class='fas fa-play text-success'>  </i></button>&nbsp;"+
							"<button style='border-radius: 35%;'> <i class='fa fa-pause'></i> </i></button>&nbsp;"+
							"<button  style='border-radius: 35%;'> <i class='fa fa-stop'></i></button>&nbsp;"+
							"</td>"+
							"<tr>"
							];
		        	}
		        	if (data[i][5]=='Stop'){
		        		a = [
							"<tr>" +
							"<td>" + data[i][0] + "</td>","<td> <a class='text-primary'href='#' onclick='listarHoras("+data[i][4]+", 4)' > "+ data[i][0]+"</a> </td>","<td>" + data[i][1]+ "</td>",
							"<td>" + data[i][2] + "</td>",
							"<td>" + data[i][5]+ "</td>",		
							" <td>"+
							" <button style='border-radius: 35%;'> <i class='fa fa-play'></i> </button>&nbsp;"+
							"<button style='border-radius: 35%;'> <i class='fa fa-pause'></i> </i></button>&nbsp;"+
							"<button  style='border-radius: 35%;'> <i class='fa fa-stop'></i></button>&nbsp;"+
							"</td>"+
							"<tr>"
							];
		        	}
						b.push(a);	
		        }	        	        
			    var tabla = $('#idtable4').DataTable({
	            	"data":b,
	                "ordering": true,
	                "pageLength": 5,
	                "lengthMenu": [
	                    [5, 10, 25, 50, 10],
	                    [5, 10, 25, 50, 10]
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
 
 function listarTerminado(id) {
	 document.getElementById("id_muestra").value = id;
	 document.getElementById("tipo").value = "terminado";
	 $('#menu').remove();
	 $('#contenedorTabla').append(
			 "<div  class='modal-header' id='menu' >"+
             "<ul class='nav nav-tabs' role='tablist'>"+
                 "<li class='nav-item'>"+
                     "<a class='nav-link' onclick='listarTrazos("+id+")' href='#trazo' role='tab' data-toggle='tab' aria-selected='true'>Trazo</a>"+
                 "</li>"+
                 "<li class='nav-item'>"+
                    " <a class='nav-link'  onclick='listarCorte("+id+")'   href='#corte' role='tab' data-toggle='tab'>Corte</a>"+
                 "</li>"+
                 "<li class='nav-item'>"+
                     "<a class='nav-link' onclick='listarConfeccion("+id+")'  href='#confeccion' role='tab' data-toggle='tab'>Confecci&oacute;n</a>"+
                 "</li>"+
                 "<li class='nav-item'>"+
                     "<a class='nav-link' onclick='listarPlanchado("+id+")'  href='#planchado' role='tab' data-toggle='tab'>Planchado</a>"+
                 "</li>"+
                 "<li class='nav-item'>"+
                     "<a class='nav-link active' onclick='listarTerminado("+id+")' href='#terminado' role='tab' data-toggle='tab'>Terminado</a>"+
                 "</li>"+
             "</ul>"+
             "<button type='button' class='close' data-dismiss='modal' aria-label='Close'>"+
                 "<span aria-hidden='true'>&times;</span>"+
             "</button>"+ "</div>");
	 console.log("corte "+id);
		$.ajax({
		    method: "GET",
		    url: "/listar-procesos/"+id+"/5",
		    success: (data) => {
		    	$('#quitar').remove();
		    	$('#quitar2').remove();
		    	$('#quitar3').remove();
		    	$('#quitar4').remove();
		    	$('#quitar5').remove();
		    	$('#contenedorTabla').append(
		    			

		    			
		    			"<div class='modal-body' id='quitar'>" +
		    			"<div class='form-group col-sm-12'>" +
		    			"<button type='button'  onclick='nuevo("+id+",5)' class='btn btn-primary' data-toggle='modal' data-target='#aux'>Nuevo Terminado</button>"+
   						"<button onclick='PausarTodo("+id+", 5)' class='btn btn-danger next-step float-right' type='button'>Pausar Todo</button>"+
  					"</div>"+
		    				
		    			"<table class='table table-striped table-bordered' id='idtable5'>" +
	                                        "<thead>" +
	                                            "<tr>" +
	                                                "<th>Operario</th>" +
	                                                "<th>Fecha de recepcion</th>" +
	                                                "<th>Fecha de entrega</th>" +
	                                                "<th>En:</th>" +
	                                                "<th>Controles</th>" +
	                                            "</tr>" +
	                                        "</thead>" +
	                                    "</table>" + "</div>");
		        var a;
		        var b = [];
		        for (i in data){
		        	if (data[i][5]=='Nuevo'){
		        		a = [
							"<tr>" +
							"<td>" + data[i][0] + "</td>",
							"<td>" + data[i][1]+ "</td>",
							"<td>" + data[i][2] + "</td>",
							"<td>" + data[i][5]+ "</td>",
							"<td>"+
							"<button onclick='play("+data[i][4]+","+id+" )' id='"+data[i][4]+"' value='"+data[i][4]+"' style='border-radius: 35%;'> <i class='fas fa-play text-success'>  </i></button>&nbsp;"+
							"<button style='border-radius: 35%;'> <i class='fa fa-pause'></i> </i></button>&nbsp;"+
							"<button  style='border-radius: 35%;'> <i class='fa fa-stop'></i></button>&nbsp;"+
							"</td>"+
							"<tr>"
							];
		        	}
		        	if (data[i][5]=='Play'){
		        		a = [
							"<tr>" +
							"<td> <a class='text-primary'href='#' onclick='listarHoras("+data[i][4]+", 5)' > "+ data[i][0]+"</a> </td>",
							"<td>" + data[i][1]+ "</td>",
							"<td>" + data[i][2] + "</td>",
							"<td>" + data[i][5]+ "</td>",		
							" <td>"+
							" <button style='border-radius: 35%;'> <i class='fa fa-play'></i> </button>&nbsp;"+
							" <button onclick='pausa("+data[i][4]+","+id+" )' id='"+data[i][4]+"' value='"+data[i][4]+"' style='border-radius: 35%;'> <i class='fas fa-pause text-warning'>  </i></button>&nbsp;"+
							"<button  onclick='stop("+data[i][4]+","+id+" )'  style='border-radius: 35%;'><i class='fas fa-stop text-danger'></i></button>&nbsp;"+
							"</td>"+
							"<tr>"
							];
		        	}
		        	if (data[i][5]=='Pausa'){
		        		a = [
							"<tr>" +
							"<td> <a class='text-primary'href='#' onclick='listarHoras("+data[i][4]+", 5)' > "+ data[i][0]+"</a> </td>",
							"<td>" + data[i][1]+ "</td>",
							"<td>" + data[i][2] + "</td>",
							"<td>" + data[i][5]+ "</td>",		
							" <td>"+
							" <button onclick='play("+data[i][4]+","+id+" )' id='"+data[i][4]+"' value='"+data[i][4]+"' style='border-radius: 35%;'> <i class='fas fa-play text-success'>  </i></button>&nbsp;"+
							"<button style='border-radius: 35%;'> <i class='fa fa-pause'></i> </i></button>&nbsp;"+
							"<button  style='border-radius: 35%;'> <i class='fa fa-stop'></i></button>&nbsp;"+
							"</td>"+
							"<tr>"
							];
		        	}
		        	if (data[i][5]=='Stop'){
		        		a = [
							"<tr>" +
							"<td> <a class='text-primary'href='#' onclick='listarHoras("+data[i][4]+", 5)' > "+ data[i][0]+"</a> </td>",
							"<td>" + data[i][1]+ "</td>",
							"<td>" + data[i][2] + "</td>",
							"<td>" + data[i][5]+ "</td>",		
							" <td>"+
							" <button style='border-radius: 35%;'> <i class='fa fa-play'></i> </button>&nbsp;"+
							"<button style='border-radius: 35%;'> <i class='fa fa-pause'></i> </i></button>&nbsp;"+
							"<button  style='border-radius: 35%;'> <i class='fa fa-stop'></i></button>&nbsp;"+
							"</td>"+
							"<tr>"
							];
		        	}
						b.push(a);	
		        }	        
			    var tabla = $('#idtable5').DataTable({
	            	"data":b,
	                "ordering": true,
	                "pageLength": 5,
	                "lengthMenu": [
	                    [5, 10, 25, 50, 10],
	                    [5, 10, 25, 50, 10]
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
///7
 
 
//Agregar procreso
 function agregar() {
      if (document.getElementById("operador").value &&
    		  document.getElementById("f1").value &&
    		  document.getElementById("f2").value &&
    		  document.getElementById("muestra").value &&
    		  $('#f2').val() > $('#f1').val()  ) {
    	  var selectValue = $("#muestra").val() || [];
    	  selectValue.join(", ");
		      var operador=document.getElementById("operador").value;
		      var f1=document.getElementById("f1").value;
		      var f2=document.getElementById("f2").value;
		      var id=document.getElementById("id_muestra").value;
		      var tipo=document.getElementById("tipo").value;
		      var muestra= new String (selectValue);
		      
    	 console.log("La muestra es "+muestra);
		   $.ajax({
        type: "POST",
        url: "/guardar-proceso",
        data: { 
        	 "_csrf": $('#token').val(),
        	'operador': operador,
        	'f1': f1,
        	'f2': f2,
        	'id': muestra, 
        	'tipo': tipo
        }
    })
    .done(function( data ) { 	
    	if (tipo =="trazo"){ listarTrazos(id);}
    	if (tipo =="corte"){ listarCorte(id);}
    	if (tipo =="confeccion"){ listarConfeccion(id);}
    	if (tipo =="planchado"){ listarPlanchado(id);}
    	if (tipo =="terminado"){ listarTerminado(id);}
    	
    	
    	});
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Insertado correctamente',
          showConfirmButton: false,
          timer: 1250
        })
        $("#aux").modal('hide');//ocultamos el modal
        
        document.getElementById('operador').options.selectedIndex = 0;
       document.getElementById("f1").value ="";
      document.getElementById("f2").value ="";
      }else {
    	 
    	  Swal.fire({
              position: 'center',
              icon: 'warning',
              title: 'Datos Incorrectos',
              showConfirmButton: false,
              timer: 1250
            })
            
              
      }
      
    
}
 
 
 // poner en play
 function play(id , id2){
	 var tipo=document.getElementById("tipo").value;
	 
	 console.log('play');
	 console.log(tipo);
	 console.log(id);
    Swal.fire({
      title: '¿Deseas iniciar este proceso?',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Comenzar',
      confirmButtonColor:'#FFC107',
    }).then((result) => {
      if (result.value && id!=null) {
    	 
    		console.log(id);
    	  $.ajax({
    	      type: "POST",
    	      url: "/play",
    	      data: { 
    	      	 "_csrf": $('#token').val(),
    	  	'idproceso': id,
    	  	'tipo': tipo
    	      	// ,'Descripcion':Descripcion
    	      }
    	     
    	  }).done(function(data){
    		 
 
    		  
    		  if (tipo =="trazo"){ listarTrazos(id2);}
   	    	if (tipo =="corte"){ listarCorte(id2);}
   	    	if (tipo =="confeccion"){ listarConfeccion(id2);}
   	    	if (tipo =="planchado"){ listarPlanchado(id2);}
   	    	if (tipo =="terminado"){ listarTerminado(id2);}
    	  });
    	      Swal.fire({
    	        position: 'center',
    	        icon: 'success',
    	        title: 'Proceso iniciado correctamente',
    	        showConfirmButton: false,
    	        timer: 1250
    	      })
      }//////////////termina result value
    })
  }
 
 
 function pausa(id , id2){
	 var tipo=document.getElementById("tipo").value;
    Swal.fire({
      title: '¿Deseas pausar este proceso?',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Comenzar',
      confirmButtonColor:'#FFC107',
    }).then((result) => {
      if (result.value && id!=null) {
    	 
    		console.log(id);
    	  $.ajax({
    	      type: "POST",
    	      url: "/pausa",
    	      data: { 
    	      	 "_csrf": $('#token').val(),
    	      	'idproceso': id,
        	  	'tipo': tipo
    	  	
    	      	// ,'Descripcion':Descripcion
    	      }
    	     
    	  }).done(function(data){
    		 
    		  if (tipo =="trazo"){ listarTrazos(id2);}
     	    	if (tipo =="corte"){ listarCorte(id2);}
     	    	if (tipo =="confeccion"){ listarConfeccion(id2);}
     	    	if (tipo =="planchado"){ listarPlanchado(id2);}
     	    	if (tipo =="terminado"){ listarTerminado(id2);}
    	  });
    	      Swal.fire({
    	        position: 'center',
    	        icon: 'success',
    	        title: 'Proceso pausado correctamente',
    	        showConfirmButton: false,
    	        timer: 1250
    	      })
      }//////////////termina result value
    })
  }
 
 
 function stop(id , id2){
	 var tipo=document.getElementById("tipo").value;
    Swal.fire({
      title: '¿Deseas Terminar con este proceso?',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Comenzar',
      confirmButtonColor:'#FFC107',
    }).then((result) => {
      if (result.value && id!=null) {
    	 
    		console.log(id);
    	  $.ajax({
    	      type: "POST",
    	      url: "/stop",
    	      data: { 
    	      	 "_csrf": $('#token').val(),
    	      	'idproceso': id,
        	  	'tipo': tipo
    	  	
    	      	// ,'Descripcion':Descripcion
    	      }
    	     
    	  }).done(function(data){
    		 
    		  if (tipo =="trazo"){ listarTrazos(id2);}
     	    	if (tipo =="corte"){ listarCorte(id2);}
     	    	if (tipo =="confeccion"){ listarConfeccion(id2);}
     	    	if (tipo =="planchado"){ listarPlanchado(id2);}
     	    	if (tipo =="terminado"){ listarTerminado(id2);}
    	  });
    	      Swal.fire({
    	        position: 'center',
    	        icon: 'success',
    	        title: 'Proceso terminado correctamente',
    	        showConfirmButton: false,
    	        timer: 1250
    	      })
      }//////////////termina result value
    })
  }
 
 
 function listarHoras(id, tipo) {
		$.ajax({
		    method: "GET",
		    url: "/listar-horas/"+id+"/"+tipo,
		    success: (data) => {
		    	$('#quitarContador').remove();
		    	$('#contenedorTablaContador').append(
		    			
		    			"<div class='modal-body' id='quitarContador'>" +
		    			
		    			"<table class='table table-striped table-bordered' id='idtableContador'>" +
	                                        "<thead>" +
	                                            "<tr>" +
	                                                "<th>Fecha Inicio</th>" +
	                                                "<th>Fecha Fin</th>" +
	                                                "<th>Proceso</th>" +
	                                                "<th>Estatus</th>" +
	                                                "<th>Tiempo</th>" +
	                                                
	                                            "</tr>" +
	                                        "</thead>" +
	                                    "</table>" + "</div>");
		        var a;
		        var b = [];
		        for (i in data){
		        	
		        		a = [
							"<tr>" +
							"<td>" + data[i][1] + "</td>",
							"<td>" + data[i][2]+ "</td>",
							"<td>" + data[i][3] + "</td>",
							"<td>" + data[i][5]+ "</td>",
							"<td>" + data[i][4]+ "</td>",
							"<tr>"
							];
		    
						b.push(a);	
		        }	        
			    var tabla = $('#idtableContador').DataTable({
	            	"data":b,
	                "ordering": true,
	                "pageLength": 5,
	                "lengthMenu": [
	                    [5, 10, 25, 50, 10],
	                    [5, 10, 25, 50, 10]
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
			    $('#Contador').modal('show');
		    },
		    error: (e) => {
		        // location.reload();nnn
		    }
	}
		
	)}
 
 
 
 function nuevo(id, tipo) {
	 
	 console.log(tipo);
	 $('#operador').remove();
	 $('#contenedorMuestra').remove();
	 $('#contenedorOperador').append(
                 "<select class='swal2-input' id='operador' name='operador' required='required'>"+
                     "<option value=''>Seleccione a un operador</option>"+
                 "</select>"+"</div>");
	 $('#contenedorSelect').append(
			 
			 "<div class='form-group col-sm-6' id ='contenedorMuestra'>"+
			 "<label for='pedidonom'>Muestra</label>"+
			 "<br><br>"+	
             "<select  class='selectpicker' multiple    id='muestra' name='muestra' required='required'>"+
                 
             "</select>"+"</div>");
	 $.ajax({  
		    method: "GET",
		    url: "/operadores",
		    success: (data) => {
		    	$.each(data, function(key, val) {
		    		$('#operador').append('<option value="' + val[0] + '">'+val[1]+'</option>');})
		    },
		    error: (e) => {
		    }
	})
	if ( tipo== 1){
		$.ajax({  
		    method: "GET",
		    url: "/orden-pedidos/"+id,
		    success: (data) => {
		    	$.each(data, function(key, val) {
		    		$('#muestra').append('<option value="' + val[0] + '">'+val[1]+'</option>');})
		    		 $('.selectpicker').selectpicker(["refresh"]);
		    } , 
		    error: (e) => {
		    }
		})	
	}
	 
	 if ( tipo> 1){
			$.ajax({  
			    method: "GET",
			    url: "/terminados/"+id+"/"+tipo,
			    success: (data) => {
			    	$.each(data, function(key, val) {
			    		$('#muestra').append('<option value="' + val[0] + '">'+val[1]+'</option>');})
			    		$('.selectpicker').selectpicker(["refresh"]);
			    },
			    error: (e) => {
			    }
			})	
		}
	
 }
 
 
 
 function PausarTodo(id , id2){
	 var tipo=document.getElementById("tipo").value;
    Swal.fire({
      title: '¿Deseas pausar todo?',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#6C757D',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Comenzar',
      confirmButtonColor:'#FFC107',
    }).then((result) => {
      if (result.value && id!=null) {
    	 
    		console.log("los id que reviso son;"+id +","+id2);
    	  $.ajax({
    	      type: "POST",
    	      url: "/PausarTodo",  
    	      data: { 
    	      	 "_csrf": $('#token').val(),
    	      	'id': id,
        	  	'tipo': id2
    	  	
    	      	// ,'Descripcion':Descripcion
    	      }
    	     
    	  }).done(function(data){
    		 
    		  if (tipo =="trazo"){ listarTrazos(id);}
     	    	if (tipo =="corte"){ listarCorte(id);}
     	    	if (tipo =="confeccion"){ listarConfeccion(id);}
     	    	if (tipo =="planchado"){ listarPlanchado(id);}
     	    	if (tipo =="terminado"){ listarTerminado(id);}
    	  });
    	      Swal.fire({
    	        position: 'center',
    	        icon: 'success',
    	        title: 'Procesos pausados correctamente',
    	        showConfirmButton: false,
    	        timer: 1250
    	      })
      }//////////////termina result value
    })
  }