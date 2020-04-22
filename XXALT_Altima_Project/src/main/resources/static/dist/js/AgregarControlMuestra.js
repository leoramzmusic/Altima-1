//Agregar procreso
 function agregar() {
	 
	 
      if (document.getElementById("id_familia_prenda").value &&
    		  document.getElementById("nombre_prenda").value &&
    		  document.getElementById("precio").value &&
    		  document.getElementById("cantidad").value &&
    		  document.getElementById("talla").value &&
    		  document.getElementById("largo").value ) {
    	  
		      var familia=document.getElementById("id_familia_prenda").value;
		      var nombre=document.getElementById("nombre_prenda").value;
		      var precio=document.getElementById("precio").value;
		      var cantidad=document.getElementById("cantidad").value;
		      var talla=document.getElementById("talla").value;
		      var largo=document.getElementById("largo").value;
		      
		      var idPedido=document.getElementById("idPedido").value;
		      
		      
		  
      		
    	 
    	 $.ajax({
    	method: "POST",
        url: "/guardar-prenda-foranea",
        data: { 
        	 "_csrf": $('#token').val(),
        	'familia': familia,
        	'nombre': nombre,
        	'precio': precio,
        	'cantidad': cantidad, 
        	'talla': talla,
        	"largo":largo,
        	'idPedido':idPedido
        },
        
        success: (data) => {

		
			
			document.getElementById("idPedido").value =data;
			

		} ///////////////
    })
    .done(function( data ) { 	
    	
    	});
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Insertado correctamente',
          showConfirmButton: false,
          timer: 1250
        })
       
      }else{
    	  Swal.fire({
    		  position: 'center',
	          icon: 'error',
	          title: 'Debe llenar los campos no sea imbecil',
	          showConfirmButton: false,
	          timer: 1250
            })
      }
}
 // LISTAR