//Popover 
$(function() {
            $('.popoverxd').popover({
                container: 'body',
                trigger: 'hover'
            })
        });
//Select2 Bootstrap Select with Search
$(function() {
	$('select').each(function() {
		$(this).select2({
			theme : 'bootstrap4',
			width : 'style',
			placeholder : $(this).attr('placeholder'),
			allowClear : Boolean($(this).data('allow-clear')),
		});
	});
});