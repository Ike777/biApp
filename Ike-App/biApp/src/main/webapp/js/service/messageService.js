
		    	
var Mes = {};

Mes.show = function(message) {
	Messenger().post({
		  message: message,
		  type: "info",
		  hideAfter: 2
		});
}
