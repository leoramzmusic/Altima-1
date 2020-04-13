function cancelarSolicitud(){
	Swal.fire({
		  title: '¿Deseas cancelar la solicitud?',
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
		      'Solicitud cancelado correctamente',
		      'success'
		    )
		  }
		});
}
function entregarSolicitud(){
	Swal.fire({
		  title: '¿Solicitud entregada?',
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
		      'Solicitud entregada correctamente',
		      'success'
		    )
		  }
		});
}
function devueltoSolicitud(){
	Swal.fire({
		  title: '¿Prestamo devuelto completo?',
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
		      'Prestamo entregado correctamente',
		      'success'
		    )
		  }
		});
}
function devueltoIndividualSolicitud(){
	Swal.fire({
		  title: '¿Muestras devueltas?',
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
		      'Muestras devueltas correctamente',
		      'success'
		    )
		  }
		});
}
function prestamoSolicitud(){
	Swal.fire({
		  title: '¿Muestras prestadas a la empresa?',
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
		      'Actualizaci&oacute;n correcta',
		      'success'
		    )
		  }
		});
}