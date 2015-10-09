(function() {
	'use strict';

	angular
		.module('app.testData')
		.service('Data', Data);
		
	function Data() {
		return {
			getCodes: function() {
				return [
					new Code("velcom", "****"),
					new Code("mts", "****"),
					new Code("abca", "****"),
					new Code("defe", "****"),
					new Code("ghig", "****"),
					new Code("jklk", "****"),
					new Code("mnon", "****"),
					new Code("pqrp", "****"),
					new Code("stus", "****"),
					new Code("vwvw", "****"),
					new Code("xyzx", "****")
				];
			}
		};
	}
    
	function Code(name, password) {
		this.name = name || "";
		this.password = password || "";
	}

})();