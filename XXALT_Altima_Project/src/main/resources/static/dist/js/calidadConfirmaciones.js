function aceptarCalidad(){
	
	Swal.fire({
		  title: '¿Seguro quieres aprobarla?',
		  text: "Una vez aprobada no se puede cambiar",
		  icon: 'warning',
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		  confirmButtonText: 'Confirmar',
		  cancelButtonText: 'Cancelar'
		}).then((result) => {
		  if (result.value) {
		    Swal.fire(
		      'Aprobada',
		      'Aprobada correctamente',
		      'success'
		    )
		  }
		});
}
function rechazarCalidad(){
	
	Swal.fire({
		  title: '¿Seguro quieres recharzala?',
		  text: "Una vez rechazada no se puede cambiar",
		  icon: 'warning',
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		  confirmButtonText: 'Confirmar',
		  cancelButtonText: 'Cancelar'
		}).then((result) => {
		  if (result.value) {
		    Swal.fire(
		      'Rechazada',
		      'Rechazada correctamente',
		      'success'
		    )
		  }
		});
}