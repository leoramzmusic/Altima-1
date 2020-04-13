function bajaInventario(){
	Swal.fire({
		  title: '¿Deseas dar de baja la muestra?',
		  icon: 'warning',
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		  confirmButtonText: 'Confirmar',
		  cancelButtonText: 'Cancelar'
		}).then((result) => {
		  if (result.value) {
		    Swal.fire(
		      'Correcto',
		      'Muestra dada de baja correctamente',
		      'success'
		    )
		  }
		});
}
function activaInventario(){
	Swal.fire({
		  title: '¿Deseas reactivar la muestra?',
		  icon: 'warning',
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		  confirmButtonText: 'Confirmar',
		  cancelButtonText: 'Cancelar'
		}).then((result) => {
		  if (result.value) {
		    Swal.fire(
		      'Correcto',
		      'Muestra reactivada correctamente',
		      'success'
		    )
		  }
		});
}