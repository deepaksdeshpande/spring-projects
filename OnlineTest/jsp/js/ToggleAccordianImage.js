/**
 * 
 */
var change;
var lastId = null;
function changeAccordionImage(id) {
	changedId(id);
	lastId = id;
	var className = "#accordionImage" + id;
	if (change) {
		$(className).toggleClass('fa fa-expand pull-right');
		change = true;
	} else {
		$(className).toggleClass('fa-compress');
		$(className).addClass('fa');
		$(className).addClass('pull-right');
		change = false;
	}
}

function changedId(Id) {
	var className = "#accordionImage" + lastId;
	if (lastId != null && lastId != Id) {
		$(className).removeClass('fa fa-expand pull-right fa-compress');
		$(className).addClass('fa-expand');
		$(className).addClass('fa');
		$(className).addClass('pull-right');
	}
}