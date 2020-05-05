
  $(function () {
	    var dialog, form,
	    
     	tips = $( ".validateTips" ); 
    
    function validateDateRange(start, end) {
    	console.log("inicio:"+start+"fin:"+end);
    	if(!start.isValid()) {
    		Swal.fire({
				position: 'center',
				icon: 'success',
				title: 'Start date is invalid',
				showConfirmButton: false,
				timer: 1250
			})
    		
    		return false; 
    	}//dddfff
    	
    	if(!end.isValid()) {
    		alert("End date is invalid");
    		Swal.fire({
				position: 'center',
				icon: 'success',
				title: 'End date is invalid',
				showConfirmButton: false,
				timer: 1250
			})
    		return false; 
    	}
    	
    	if(start.isAfter(end)) {
	 		alert("End date must be after start date");	
	 		Swal.fire({
				position: 'center',
				icon: 'success',
				title: 'End date must be after start date',
				showConfirmButton: false,
				timer: 1250
			})
	 		return false; 
	 	}
    	
    	if(start.isSame(end)) {
    		alert("End date must be after start date");
    		Swal.fire({
				position: 'center',
				icon: 'success',
				title: 'End date must be after start date',
				showConfirmButton: false,
				timer: 1250
			})
    		return false;
    	}
    	return true;
    }
    
	 
   	function removeEvent() {  
   		
   		Swal.fire({
   			title: '¿Deseas eliminar esta cita?',
   			icon: 'warning',
   			showCancelButton: true,
   			cancelButtonColor: '#6C757D',
   			cancelButtonText: 'Cancelar',
   			confirmButtonText: 'Dar de baja',
   			confirmButtonColor: '#dc3545',
   		}).then((result) => {
   			
   			if (result.value) {
   				
   			
    	var eventData;
		if (idCalendario.value) {
			eventData = idCalendario.value;
			console.log("id:"+eventData);
			$('#agendarCita').modal('hide');
    		$.ajax({
    	        type: "DELETE",
    	        url: "/event",
    	        
    	        data: {
    	        	"id":eventData,
					'_csrf': $('#token').val()
				},
    	        
    	        
    	        success: (data) => {
    	        	calendar.refetchEvents();
    	        	console.log("id="+eventData);
    	        	
    	        	Swal.fire({
    					position: 'center',
    					icon: 'success',
    					title: 'Dada de baja correctamente',
    					showConfirmButton: false,
    					timer: 1250
    				})
    	        },
    	        error: (e) => {
    	            $("#error").text(e.responseText);
    	        }
    	      });
			
		}
	    return true;
   		}
   		else{$('#agendarCita').modal('hide');}
   		})
    }
	   
    function editEvent(info) {
    	var eventStart = moment(info.event.start).format("YYYY-MM-DDTHH:mm:ss"); //moment(event.start);
 			var eventEnd = moment(info.event.end).format("YYYY-MM-DDTHH:mm:ss");
 			
       	newtitle.value = info.event.title;
	    description.value = info.event.extendedProps.description; 
	    startdateandtime.value = eventStart;			
	    enddateandtime.value = eventEnd;
	    idCalendario.value =info.event.extendedProps.idCalendario; 
	    $('#agendarCita').modal('toggle');
	    
    }	
    
    function saveEvent() {
    	var valid = true;
    	
	 	var eventStart = moment(startdateandtime.value);
 			var eventEnd = moment(enddateandtime.value);
   
 		valid = valid && newtitle.value;
	 	valid = valid && validateDateRange(eventStart, eventEnd);
	   
		if ( valid ) {
	    	var eventData;
			if (newtitle.value) {
				eventData = {
					idCalendario: idCalendario.value,
					title: newtitle.value,
					start: startdateandtime.value,
					end:  enddateandtime.value, 
					description: description.value,
					color: 'red',
					
				};
		//		alert(eventData.title.value + " " + eventData.start.value + " " + eventData.finish.value)
		//		$('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
			}
			
			calendar.unselect();
			$('#agendarCita').modal('hide');
    		$.ajax({
    	        type: "PATCH",
    	        url: "/event",
			    data: {
			    	'idCalendario': idCalendario.value,
					'title': newtitle.value,
					'start': startdateandtime.value,
					'end':  enddateandtime.value, 
					'description': description.value,
					'color': 'red',
					'_csrf': $('#token').val()
				},
				success: (data) => {	
    	        	calendar.refetchEvents()
    	        	console.log(JSON.stringify(eventData));
    	        	
    	        	Swal.fire({
    					position: 'center',
    					icon: 'success',
    					title: 'Cita guardada correctamente',
    					showConfirmButton: false,
    					timer: 1250
    				})
    				
    				
    				
    	        },
    	        error: (e) => {
    	        	console.log("error 111");
    	        }
    	      });
    	}
	 	return valid;
    }
    function moveEvent(info) {
    	var eventStart = moment(info.event.start).format("YYYY-MM-DDTHH:mm:ss"); //moment(event.start);
		var eventEnd = moment(info.event.end).format("YYYY-MM-DDTHH:mm:ss");
    	var valid = true;
   
    	valid = valid && info.event.title;
		if ( valid ) {
			console.log("entra");
	    	var eventData;
			if (info.event.title) {
				eventData = {
					//idCalendario: info.event.idCalendario,
					idCalendario: info.event.extendedProps.idCalendario,
					title: info.event.title,
					start: eventStart,
					end:  eventEnd, 
					description: description.value,
					color: 'blue',
					
				};
				console.log("que pedal");
		//		alert(eventData.title.value + " " + eventData.start.value + " " + eventData.finish.value)
		//		$('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
			}
			calendar.unselect();
			$('#agendarCita').modal('hide');
			console.log(JSON.stringify(eventData));
    		$.ajax({
    	        type: "PATCH",
    	        url: "/event",
    	        
    	        data: {
    	        	'idCalendario': info.event.extendedProps.idCalendario,
					'title': info.event.title,
					'start': eventStart,
					'end':  eventEnd, 
					'description': description.value,
					'color': 'blue',
					'_csrf': $('#token').val()
				},
    	        success: (data) => {
    	        	calendar.refetchEvents();
    	        	console.log(JSON.stringify(eventData));
    	        	
    	        	Swal.fire({
    					position: 'center',
    					icon: 'success',
    					title: 'Cita movida correctamente',
    					showConfirmButton: false,
    					timer: 1250
    				})
    	        },
    	        error: (e) => {
    	        	console.log("error 222");
    	        }
    	      });
    	}
	 	return valid;
    }
    
   function addEvent(start, end) {
      	var valid = true;
 			
 			var eventStart = moment(startdateandtime.value);
 			var eventEnd = moment(enddateandtime.value);
   
		valid = valid && newtitle.value;
	 	valid = valid && startdateandtime.value;
	 	valid = valid && validateDateRange(eventStart, eventEnd);
	 	    
		if ( valid ) {
	    	var eventData;
			if (newtitle.value) {
				eventData = {
					title: newtitle.value,
					description: description.value,
					start: startdateandtime.value,
					end: enddateandtime.value, 
					color: color.value
				};
				//$('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
			}
			
			calendar.unselect();
			$('#agendarCita').modal('hide');
			console.log(JSON.stringify(eventData));
			 $.ajax({
			    type: "POST",
			    url: "/event",
			    data:{
			    	'title': newtitle.value,
					'description': description.value,
					'start': startdateandtime.value,
					'end': enddateandtime.value, 
					'color': color.value,
			    	'_csrf': $('#token').val()
			    },
			    success: function(data){
			    	calendar.refetchEvents();
			    	console.log(JSON.stringify(eventData));
			    	Swal.fire({
    					position: 'center',
    					icon: 'success',
    					title: 'Cita guardada correctamente',
    					showConfirmButton: false,
    					timer: 1250
    				})
			    },
			    failure: function(errMsg) {
			        alert(errMsg);
			    }
			});
      }
      return valid;
    }
    $("#submit-modal").click((e) => {
    	e.preventDefault();
    	if($("#submit-modal"). val()=='1'){
    		addEvent();
    	}
    	else{saveEvent();}	
    });
    $("#nueva-cita").click((e) => {
    	
    	idCalendario.value="";
		newtitle.value="";
		startdateandtime.value="";
		enddateandtime.value="";
		description.value="";
    	
    	e.preventDefault();
    	$('#delete-modal').hide();
    	$('#submit-modal').text("Agendar");
    	$('#submit-modal').val("1");
    });
    
    $("#delete-modal").click((e) => {
    	console.log("hola");
    	e.preventDefault();
    	
    	removeEvent();
    }); 

    var Calendar = FullCalendar.Calendar;
    var calendarEl = document.getElementById('calendar');
    var calendar = new Calendar(calendarEl, {
      locale:"es-us",
      plugins: [ 'bootstrap', 'interaction', 'dayGrid', 'timeGrid','list'],
      header    : {
        left  : 'prev,next today',
        center: 'title',
        right : 'dayGridMonth,timeGridWeek,listMonth'
      },
      	allDaySlot:false,
		defaultDate: moment().format("YYYY-MM-DD"),
		editable: true,
		slotLabelInterval : '01:00:00',
		slotDuration : '01:00:00',
		viewSubSlotLabel : true,
		minTime:'08:00:00',
		maxTime:'20:00:00',
		contentHeight: 'auto',
		eventDrop: function(info) {
			console.log(info.event.start,info.event.end);
			Swal.fire({
				title: '¿Te gustaria cambiar la cita?', 
				showCancelButton: true, 
				confirmButtonText: 'Cambiar',
				cancelButtonText: 'Cancelar',
				confirmButtonColor: '#dc3545'}).then(result => {
				  if (result.value) {
					  moveEvent(info);
				  } else {
					  info.revert();
				  }
				})
			
			  },
	   eventResize: function(info) {
		   Swal.fire({
				title: '¿Te gustaria cambiar la cita?', 
				showCancelButton: true, 
				confirmButtonText: 'Cambiar',
				cancelButtonText: 'Cancelar',
				confirmButtonColor: '#dc3545'}).then(result => {
				  if (result.value) {
					  moveEvent(info);
				  } else {
					  info.revert();
				  }
				})
		  },
		eventLimit: true, // allow "more" link when too many events
		events: {
	        url: '/allevents',
	        type: 'GET',
	        error: function() {
	            alert('there was an error while fetching events!');
	        },
	        //color: 'blue',   // a non-ajax option
	        //textColor: 'white' // a non-ajax option
	    },
		selectable: true,
		selectHelper: true,
		selectMirror: true,
		timeFormat: 'h(:mm)',
		select: function(arg) {

	    	idCalendario.value="";
			newtitle.value="";
			startdateandtime.value="";
			enddateandtime.value="";
			description.value="";
			console.log("inicio:"+ moment(arg.start).format("YYYY-MM-DDTHH:mm:ss")+"final:"+moment(arg.end).format("YYYY-MM-DDTHH:mm:ss"));
			startdateandtime.value = moment(arg.start).format("YYYY-MM-DDTHH:mm:ss");
			enddateandtime.value = moment(arg.end).format("YYYY-MM-DDTHH:mm:ss");
			$('#submit-modal').text("Agendar");
			$('#delete-modal').hide();
			$('#agendarCita').modal('toggle');
		},
		eventClick: function(info) {
			//info.jsEvent.preventDefault(); 
			$('#delete-modal').show();
			$('#submit-modal').text("Editar");
			$('#submit-modal').val("0");
			editEvent(info);
			
	       //$('#calendar').fullCalendar('updateEvent', event);
 	    }	
	  	
// 		loading: function(bool) {
// 			$('#loading').toggle(bool);
// 		}
    });

    calendar.render();

  })